package org.evertones.config.security;

import org.evertones.persistence.security.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

//@EnableWebSecurity -> when uncommented the page doesn't load the CSS/JS from the webjar
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private ErrorHandler accessDeniedHandler;

    @Autowired
    private UsersService usersService;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    // custom 403 access denied handler
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
            .authorizeRequests()
                // The code below is to allow H2 console to be accessed (even for users that are not logged in)
                .antMatchers("/h2/**", "/console/**").permitAll()

                .antMatchers("/").hasAnyRole("USER")
                .antMatchers("/index", "/**").hasAnyRole("USER")
                .antMatchers("/period/**").hasAnyRole("ADMIN")

                .anyRequest().authenticated()
            .and()
                .formLogin().loginPage("/login").permitAll()
            .and()
                .logout().permitAll()
                .logoutSuccessUrl("/login")
            .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler);

        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(usersService)
                .passwordEncoder(bCryptPasswordEncoder);
    }

}
