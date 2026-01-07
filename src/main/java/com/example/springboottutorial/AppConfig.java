package com.example.springboottutorial;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class AppConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(PasswordEncoder passwordEncoder) {
        UserDetails user1 = User.builder().username("user1").password(passwordEncoder.encode("user123")).roles("USER").build();
        UserDetails user2 = User.builder().username("user2").password(passwordEncoder.encode("user123")).roles("USER").build();
        UserDetails user3 = User.builder().username("user3").password(passwordEncoder.encode("user123")).roles("USER").build();
        return new InMemoryUserDetailsManager(user1, user2, user3);
    }


}
