package com.akbulutmehmet.authservice.config;

import com.akbulutmehmet.authservice.service.UserDetailServiceImp;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

   private final UserDetailServiceImp userDetailServiceImp;

   public SecurityConfig(UserDetailServiceImp userDetailServiceImp) {
      this.userDetailServiceImp = userDetailServiceImp;
   }

   @Override
   protected void configure(HttpSecurity http) throws Exception {
      http.csrf().disable();
      http.httpBasic();
      http.formLogin().disable();
      http.authorizeRequests().antMatchers("api/v1/user/login").permitAll().
              and().authorizeRequests().antMatchers("/api/v1/user/register").permitAll();
      http.authorizeRequests().antMatchers("/api/v1/user/listusers").hasRole("USER");
   }


   @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.userDetailsService(userDetailServiceImp);
   }
}
