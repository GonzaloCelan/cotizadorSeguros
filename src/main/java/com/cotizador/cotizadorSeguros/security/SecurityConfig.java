package com.cotizador.cotizadorSeguros.security;


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
import org.springframework.security.provisioning.InMemoryUserDetailsManager;



@Configuration
@EnableWebSecurity

public class SecurityConfig {

	  
	  @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	        http
	            .authorizeHttpRequests(a -> a
	                .requestMatchers(
	                    "/login",
	                    "/manifest.webmanifest",
	                    "/sw.js",
	                    "/logo.png",
	                    "/icons/**",
	                    "/css/**",
	                    "/js/**"
	                ).permitAll()
	                .anyRequest().authenticated()
	            )
	            .formLogin(f -> f
	                .loginPage("/login")
	                .loginProcessingUrl("/login")
	                .defaultSuccessUrl("/index.html", true)
	                .permitAll()
	            )
	            .logout(l -> l
	                .logoutSuccessUrl("/login?logout")
	                .invalidateHttpSession(true)  // invalida sesión
	                .deleteCookies("JSESSIONID")  // elimina cookie de sesión
	                .permitAll()
	            )
	            .sessionManagement(s -> s
	                .maximumSessions(1)  // solo una sesión activa por usuario
	                .maxSessionsPreventsLogin(false)
	            )
	            .sessionManagement(s -> s
	                .sessionFixation().migrateSession() // previene ataques de fijación de sesión
	                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
	            );

	        return http.build();
	    }

	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

	    @Bean
	    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder encoder) {
	        UserDetails admin = User.withUsername("francoroldan")
	            .password(encoder.encode("franco1234"))
	            .roles("ADMIN")
	            .build();
	        return new InMemoryUserDetailsManager(admin);
	    }
}
