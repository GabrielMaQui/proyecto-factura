package com.bolsadeideas.springboot.app.configuration;


import com.bolsadeideas.springboot.app.auth.LoginSuccessHandler;
import com.bolsadeideas.springboot.app.service.UserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//igframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@Configuration
@AllArgsConstructor
public class SecurityConfig {

    @Autowired
    private UserDetailsService detalleUsuarioService;

    @Autowired
    private LoginSuccessHandler successHandler;

    private BCryptPasswordEncoder passwordEncoder;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        auth ->
                        auth.requestMatchers("/",
                                            "/auth/login",
                                            "/css/**",
                                            "/js/**",
                                            "/images/**",
                                            "/listar",
                                "/resources/**",
                                "/static/**").permitAll().anyRequest().authenticated()

                )
                .formLogin(
                        login -> login.loginPage("/auth/login")
                                .successHandler(successHandler)
                )
                .logout(
                        logout ->
                                logout.logoutSuccessUrl("/auth/login")
                                        .invalidateHttpSession(true)
                ).authenticationProvider(authenticationProvider())

                .exceptionHandling((exceptionHandling) -> exceptionHandling
                        .accessDeniedPage("/error_403")
                );
        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() throws Exception {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(detalleUsuarioService);
        daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        return daoAuthenticationProvider;
    }

    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception
    {
        build.userDetailsService(detalleUsuarioService)
                .passwordEncoder(passwordEncoder);
    }


}