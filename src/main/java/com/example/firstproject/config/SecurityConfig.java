package com.example.firstproject.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
  /*   @Bean
    public InMemoryUserDetailsManager settingInMemoryUsers(){
        UserDetails nenu = User.builder().username("rama").password("{noop}testram").roles("EMPLOYEE").build();
        UserDetails akka = User.builder().username("renuka").password("{noop}testren").roles("EMPLOYEE","MANAGER").build();
        UserDetails amma = User.builder().username("rajeshwari").password("{noop}testraj").roles("EMPLOYEE","MANAGER","ADMIN").build();

        return new InMemoryUserDetailsManager(nenu,akka,amma);
    } */

    // @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(configurer->configurer.requestMatchers(HttpMethod.GET,"/api/engineers").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/api/engineers/**").hasRole("EMPLOYEE").
                        requestMatchers(HttpMethod.POST,"/api/engineers").hasRole("MANAGER").
                        requestMatchers(HttpMethod.PUT,"/api/engineers").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"/api/engineers/**").hasRole("ADMIN")
                );
        httpSecurity.httpBasic(Customizer.withDefaults());
        httpSecurity.csrf(csrf->csrf.disable());//for POST , PUT, DELETE requests necessary
        return httpSecurity.build();

    }
    
    // @Bean
    public JdbcUserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager=  new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery("SELECT user_id, pw,active FROM members WHERE user_id=?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("SELECT user_id,role FROM roles WHERE user_id=?;");
        return jdbcUserDetailsManager;//created two new tables members & roles custom tables
    }
}
