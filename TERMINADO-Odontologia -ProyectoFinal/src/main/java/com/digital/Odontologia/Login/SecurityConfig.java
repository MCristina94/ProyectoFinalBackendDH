package com.digital.Odontologia.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AppUserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //El usuario Admin tiene permiso para ingresar y hacer modificaciones en url odontologos, pacientes y turnos
        //El usuario común unicamente puede interactuar con la url de turnos

        http.csrf().disable()
                .headers().frameOptions().sameOrigin().and()
                .authorizeRequests()
                .antMatchers("/h2-console").permitAll()
                .antMatchers("/odontologos").hasRole("ADMIN")
                .antMatchers("/turnos").hasAnyRole("USER", "ADMIN")
                .antMatchers( "/pacientes").hasRole("ADMIN")
                .anyRequest().authenticated() // Todas las demás rutas requieren autenticación
                .and()
                .formLogin();


    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.authenticationProvider(dao());
    }

    @Bean
    public DaoAuthenticationProvider dao(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(userService);
        return provider;

    }
}
