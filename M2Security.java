package com.csc280.FantasyWorldLab2;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class M2Security extends WebSecurityConfigurerAdapter  {
	static InMemoryUserDetailsManager memAuth = new InMemoryUserDetailsManager();

    // ///////////////////////////////////////////
    // Create in-memory user
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        System.out.println("configure - A");
        
//        // 
//        auth.inMemoryAuthentication().withUser("admin").password(passEncode()
//                .encode("test")).roles("ADMIN")
//        .and().withUser("USER").password(passEncode().encode("test")).roles("USER");
//        // */
        
        UserDetails admin = User.withUsername("admin")
        		.password(passEncode().encode("test"))
        		.roles("ADMIN").build();
        
        memAuth.createUser(admin);

        auth.userDetailsService(memAuth);
        
        UserDetails newUser = User.withUsername("user")
        		.password(passEncode().encode("test"))
        		.roles("USER").build();
        
        memAuth.createUser(newUser);

        auth.userDetailsService(memAuth);
        
    }
    // ///////////////////////////////////////////
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        System.out.println("configure - B");

//        // 
//        http.authorizeRequests()
//        .anyRequest()
//        .authenticated()
//        .and()
//        .httpBasic().and().csrf().disable();
//    }
        
        http.authorizeRequests()
        //.antMatchers("**").permitAll()
        .antMatchers("/user/**").hasAnyRole("USER", "ADMIN")
        .antMatchers("/admin/**").hasRole("ADMIN")
        .and()
        .httpBasic().and().csrf().disable();
    }
    
    // ///////////////////////////////////////////
    @Bean
    PasswordEncoder passEncode() {
        return new BCryptPasswordEncoder();
    }
    
//    public static int getHTTPResponseStatusCode(String u) throws IOException {
//
//        URL url = new URL(u);
//        HttpURLConnection http = (HttpURLConnection)url.openConnection();
//        return http.getResponseCode();
//    }
    
    @Bean 
    public InMemoryUserDetailsManager getInMemoryUserDetailsManager() {
    	System.out.println("*** Enter InMemoryUserDetailsManager()");
    	return memAuth;
    }
    

}