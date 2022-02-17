
package com.example.api_project.security;


import com.example.api_project.filter.CustomAuthentificationFilter;
import com.example.api_project.filter.CustomAuthorizationFilter;
import com.example.api_project.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class Securityconfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    MyUserDetailsService myUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(myUserDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        auth.authenticationProvider(daoAuthenticationProvider);
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.cors();
        http.headers().cacheControl();
        http.csrf().disable();
        http.authorizeRequests()
                        .antMatchers("/arbitres/all","/matches/all","/equipes/all","/stades/all","/joueurs/all").hasAnyRole("ADMIN","USER","EMPLOYEE")
                        .antMatchers("/arbitres/add","/matches/add","/equipes/add","/stades/add","/joueurs/add","/matches/update").hasAnyRole("ADMIN","EMPLOYEE")
                        .antMatchers("/arbitres/delete","/matches/delete","/equipes/delete","/stades/delete","/joueurs/delete").hasRole("ADMIN");
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilter(new CustomAuthentificationFilter(authenticationManagerBean()));
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }

}
