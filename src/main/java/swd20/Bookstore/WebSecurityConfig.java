package swd20.Bookstore;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
@Override
protected void configure(HttpSecurity http) throws Exception {
	http
		.authorizeRequests().antMatchers("/css/**").permitAll() //Ei vaadi sisäänkirjautumista
		.and()
		.authorizeRequests().anyRequest().authenticated() //kaikki muut endpointit vaativat sisäänkirjautumisen
		.and()
	.formLogin()
		.loginPage("/login") //login page endpoint
		.defaultSuccessUrl("/booklist") //ohjaus jos login onnistunut
		.permitAll()
		.and()
	.logout()
		.permitAll();
}

@Bean
@Override
public UserDetailsService userDetailsService() {
	List<UserDetails> users = new ArrayList();
	UserDetails user = User.withDefaultPasswordEncoder()
		.username("user")
		.password("user")
		.roles("USER")
		.build();
	
	users.add(user);
	
	user = User.withDefaultPasswordEncoder()
		.username("admin")
		.password("admin")
		.roles("USER", "ADMIN")
		.build();
	
	users.add(user);
	
	return new InMemoryUserDetailsManager(users);
}



}
