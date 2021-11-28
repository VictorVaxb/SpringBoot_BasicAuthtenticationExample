package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("victor").password("adminpass").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("pedro").password("userpass").roles("USER");
	}
	
	/*
	 * Se realizan validaciones para que se permita acceder a los metodos solo a los roles que se definan
	 * si la Url contiene guardar_ejemplo en la posicion entonces se validara que solo los usuarios ADMIN
	 * puedan acceder, para no escribir una linea por mapeo en el controller
	 * 
	 * */
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
		.antMatchers("/find_all_public").permitAll()
		.antMatchers("/find_all_user").hasRole("USER")
		.antMatchers("/find_all_admin").hasRole("ADMIN")
		.antMatchers("/*/guardar_ejemplo/**").hasRole("ADMIN") 
		.and().httpBasic();
	}
	
	/*
	 * Solo para pruebas, se deberia codificar la password
	 * 
	 * */
	@SuppressWarnings("deprecation")
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
	
}
