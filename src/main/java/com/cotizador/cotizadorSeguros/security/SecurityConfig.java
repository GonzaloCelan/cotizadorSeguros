package com.cotizador.cotizadorSeguros.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
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
					        "/login",                      // tu página de login (Thymeleaf)
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
		    .loginPage("/login")              // -> templates/login.html vía controlador
		    .loginProcessingUrl("/login")     // POST del form
		    .defaultSuccessUrl("/index.html", true) // vuelve al cotizador estático
		    .permitAll()
		  )
		  .logout(l -> l.logoutSuccessUrl("/login?logout").permitAll());

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
