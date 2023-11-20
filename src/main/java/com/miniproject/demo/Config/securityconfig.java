package com.miniproject.demo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class securityconfig {


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(){

        UserDetails adminUser = User.withUsername("user")
                               .password(passwordEncoder().encode("password"))
                               .roles("ADMIN")
                               .build();
        
        return new InMemoryUserDetailsManager(adminUser);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

             
        http.authorizeHttpRequests((requests) -> requests
                               .requestMatchers(AntPathRequestMatcher.antMatcher("/webjars/**")).permitAll()
                               .requestMatchers(AntPathRequestMatcher.antMatcher("/Viewer/*")).permitAll()
                               .anyRequest().authenticated())
            .formLogin(form -> form
                               .loginPage("/login").permitAll()
                               .loginProcessingUrl("/perform_login")
                               .defaultSuccessUrl("/index", true)
                               );

        return http.build();
    }
}
