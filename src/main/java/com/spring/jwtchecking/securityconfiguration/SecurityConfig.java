package com.spring.jwtchecking.securityconfiguration;

import com.spring.jwtchecking.repository.AppUserRepository;
import com.spring.jwtchecking.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    @Autowired
    private JwtTokenUtils jwtTokenUtils;

    @Autowired
    private AppUserRepository appUserRepo;

   /* @Autowired
    private AppUserService userService;*/

    private String[] PUBLIC_RESOURCE_AND_URL = {"/",
            "/user/sign-up",
            "/user/sign-in"

    };

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        // We don't need CSRF for this example

        http.csrf()
                .disable()
                .authorizeHttpRequests()
                .anyRequest()
                .authenticated()
                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler()).and().addFilterBefore(
                        new JwtAuthenticationFilter(jwtTokenUtils,appUserRepo), BasicAuthenticationFilter.class).
                addFilterBefore(new CustomCORSFilter(), ChannelProcessingFilter.class);

        return http.build();
    }


    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.debug(false)
                .ignoring()
                .requestMatchers(PUBLIC_RESOURCE_AND_URL);
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }
}
