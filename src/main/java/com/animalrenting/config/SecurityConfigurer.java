package com.animalrenting.config;

import com.animalrenting.filter.JwtRequestFilter;
import com.animalrenting.services.AnimalUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfigurer extends WebSecurityConfigurerAdapter{
    private final AnimalUserDetailsService invitationsAnimalUserDetailsService;
    private final JwtRequestFilter jwtRequestFilter;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(invitationsAnimalUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // CSRF not needed
        http.csrf().disable()
                // enabled cors
                .cors().and()
                // don't authenticate this particular request
                .authorizeRequests().antMatchers("/authenticate").permitAll()
                // add spring actuator to permit list
                .antMatchers("/actuator").permitAll()
                // add spring openapi docs to permit list
                .antMatchers("/swagger-ui.html").permitAll()
                // all other requests need to be authenticated
//                .anyRequest().authenticated()
                // exceptions handling
                .and().exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
                // make sure stateless session is used; session won't be used to store user's state
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // Add a filter to validate the tokens with every request
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
