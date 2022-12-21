
package com.example.demo;

import com.example.demo.Filter.JwtAuthenticationFilter;
import com.example.demo.Filter.JwtAuthorizationFilter;
import com.example.demo.domain.User;
import com.example.demo.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.Collection;

@Configuration
@EnableWebSecurity
public class ConfigSecurity extends WebSecurityConfigurerAdapter {
    @Autowired
    UserServices userServices;

    @Override

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
         auth.userDetailsService(new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                 User user = userServices.loadUserByUsername(username);
                 Collection<GrantedAuthority> authorities = new ArrayList<>();
                 user.getRoles().forEach(role -> {
                     authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
                 });
                 return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);

             }
         });
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
      /**
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/product/**").hasAnyAuthority("FOURNISSEUR");
        http.authorizeRequests().antMatchers(HttpMethod.POST,"/product/**").hasAnyAuthority("FOURNISSEUR");

        http.addFilter(new JwtAuthenticationFilter(authenticationManager()));
        http.addFilterBefore( new JwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

        http.authorizeRequests().anyRequest().authenticated();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.formLogin();
      **/
      http.csrf().disable();
    }

    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
}
