package com.cotizador.cotizadorSeguros.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;



import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;



@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	 // Lee variables de entorno (con valores por defecto si faltan)
	  @Value("${APP_USER:admin}")
	  private String appUser;

	  @Value("${APP_PASS:changeme}")
	  private String appPass;

	 
	  @Value("${APP_ROLES:USER}")
	  private String appRoles;


    

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            // 🔐 Desactiva CSRF para permitir fetch() POST sin token
        //.csrf(csrf -> csrf.disable())

            // ✅ Autoriza rutas públicas
        	.csrf(csrf -> {})
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/login",                       // Página de login
                    "/api/cotizador/login",        // Endpoint de login
                    "/api/cotizador/consultar",   
                    "/api/cotizador/detalle",  // Todas las rutas de la API (consultar, detalle, etc.)
                    "/manifest.webmanifest",
                    "/sw.js",
                    "/logo.png",
                    "/icons/**",
                    "/css/**",
                    "/js/**"
                ).permitAll()
                .anyRequest().authenticated()     // Todo lo demás requiere login
            )

            // 🔐 Configura formulario de login
            .formLogin(form -> form
                .loginPage("/api/cotizador/login")          // Página de login (HTML)
                .loginProcessingUrl("/login")               // Endpoint POST al hacer login
                .defaultSuccessUrl("/api/cotizador/inicio", true) // Redirige al éxito
                .permitAll()
            )

            // 🚪 Configura logout
            .logout(logout -> logout
                .logoutSuccessUrl("/login?logout")          // Redirige tras logout
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll()
            )

            // 👤 Manejo de sesiones
            .sessionManagement(session -> session
                .invalidSessionUrl("/login?expired=true")
                .maximumSessions(1)
                .maxSessionsPreventsLogin(false)
            )

            .sessionManagement(session -> session
                .sessionFixation().migrateSession()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
            );

        return http.build();
    }
    
    // solo si tengo varios roles 
    
    @Bean
     public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        UserDetails user = User.builder()
            .username(appUser)
            .password(encoder.encode(appPass))
            .roles(appRoles)
            .build();

        return new InMemoryUserDetailsManager(user);
    }

    // 🔐 Codificador para contraseñas
    
    @Bean
     public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
