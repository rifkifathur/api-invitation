package com.undangan.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AnyRequestMatcher;

import com.undangan.repositories.AppUserRepository;
import com.undangan.services.impl.UserServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecureConfig extends WebSecurityConfigurerAdapter {
    // @Autowired
    // UserDetailsService userDetailsService;

    @Autowired
    UserServiceImpl userServiceImpl;

    // @Autowired
    // AppUserRepository userRepository;

    @Value("${yourapp.http.auth-token-header-name}")
    private String principalRequestHeader;

    @Value("${yourapp.http.auth-token}")
    private String principalRequestValue;
    
    // @Override
    // protected void configure(HttpSecurity httpSecurity) throws Exception {
    //     APIKeyAuthFilter filter = new APIKeyAuthFilter(principalRequestHeader);
    //     filter.setAuthenticationManager(new AuthenticationManager() {

    //         @Override
    //         public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    //             String principal = (String) authentication.getPrincipal();
    //             if (!principalRequestValue.equals(principal))
    //             {
    //                 throw new BadCredentialsException("The API key was not found or not the expected value.");
    //             }
    //             authentication.setAuthenticated(true);
    //             return authentication;
    //         }
    //     });
    //     httpSecurity.
    //         // antMatcher("/api/client/customer").
    //         csrf().disable().
    //         sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).
    //         and().addFilter(filter).authorizeRequests().anyRequest().authenticated();
    // }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests()
        .antMatchers("/api/client/customer").permitAll().antMatchers("/api/client/customer/mypath").permitAll()
        .anyRequest().authenticated().and().httpBasic();
        
        // http.csrf().disable().authorizeRequests()
        // .antMatchers("/api/client/customer").permitAll()
        // .anyRequest().fullyAuthenticated().and().httpBasic();
        // http.authorizeRequests()
        //         .antMatchers("/api/client/customer").anonymous()
        //         .anyRequest().authenticated()
        //         .and()
        //         .sessionManagement()
        //         .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        //         .and()
        //         .csrf().disable()
        //         .formLogin().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
        // auth.userDetailsService(username -> userRepository.findByUsername(username)
        // .orElseThrow(() -> new
        // UsernameNotFoundException(String.format("Unauthorized'%s'", username))))
        // .passwordEncoder(passwordEncoder());
        // auth.userDetailsService(this.userServiceImpl).passwordEncoder(passwordEncoder());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        // // provider.setUserDetailsService(username ->
        // userRepository.findByUsername(username)
        // // .orElseThrow(() -> new
        // UsernameNotFoundException(String.format("Unauthorized '%s'",
        // // username))));
        provider.setUserDetailsService(userServiceImpl);
        return provider;
    }
    // @Bean
    // public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    // http
    // .csrf().disable().formLogin().disable();
    // http.authorizeRequests().antMatchers("/api/customer",
    // "/api/customer/mypath").permitAll()
    // .anyRequest().authenticated();

    // return http.build();
    // }

    // @Autowired
    // protected void configureGlobal(AuthenticationManagerBuilder auth)
    // throws Exception {
    // auth.inMemoryAuthentication()
    // .withUser("admin")
    // .password("{noop}password")
    // .roles("USER");
    // auth.userDetailsService(userServiceImpl).passwordEncoder(passwordEncoder());
    // }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
