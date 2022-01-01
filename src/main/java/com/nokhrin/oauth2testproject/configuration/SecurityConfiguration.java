package com.nokhrin.oauth2testproject.configuration;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration  extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().antMatcher("/**").authorizeRequests()
              //  .antMatchers("/", "/index.html").authenticated()
                .anyRequest().authenticated()
           //     .and().formLogin().permitAll()
                .and()
                .oauth2Login().permitAll()
                .and().
                logout().logoutSuccessUrl("/");
    }
}
