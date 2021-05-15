package app.core.managers;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	
        auth.inMemoryAuthentication()
            .passwordEncoder(passwordEncoder())
            .withUser("simple.farmer")
            .password(passwordEncoder().encode("9aebeb6a-3220-4fb0-83a8-89666a7e67ae"))
            .roles("USER")
            .and()
            .withUser("gold.fish")
            .password(passwordEncoder().encode("q%^R:N&R></}_efD)zD<35mzph`(rGQg{X&EhqLvK"))
            .roles("ADMIN");
    }
    
    protected void configure(HttpSecurity http) throws Exception {
        http
        .cors()
        .and()
        .authorizeRequests().antMatchers(HttpMethod.POST).hasRole("ADMIN")
        .and()
        .authorizeRequests().antMatchers(HttpMethod.PATCH).hasRole("ADMIN")
        .and()
        .authorizeRequests().antMatchers(HttpMethod.DELETE).hasRole("ADMIN")
        .anyRequest().authenticated()
        .and()
        .httpBasic()
        .and()
        .csrf().disable();
    }
    
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return passwordEncoder;
    }
}