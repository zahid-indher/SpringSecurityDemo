package com.spring.security;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private DataSource datasource;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception{
		authenticationMgr.jdbcAuthentication().dataSource(datasource)
		.passwordEncoder(new BCryptPasswordEncoder())
		.usersByUsernameQuery("select USER_NAME, PASSWORD, IS_ACTIVE from USERS WHERE USER_NAME = ?")
		.authoritiesByUsernameQuery("select USER_NAME, ROLE from USER_ROLES where USER_NAME = ?");
	}
	
	//Authorization
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
		.authorizeRequests()
		.antMatchers("/students*").hasRole("USER")
		.antMatchers("/students*").hasRole("ADMIN")
		.antMatchers("/", "/notProtected*").permitAll()
		.and()
		.csrf().disable()
		.httpBasic();
		
	}
	
	/*
	create table USERS (
	USER_NAME varchar (100) not null primary key,
	PASSWORD varchar (100) not null,
	IS_ACTIVE boolean not null);

	create table USER_ROLES(
	USER_NAME varchar (100) not null,
	ROLE varchar (100) not null,
	constraint FK_USER_ROLES_USERS foreign key (USER_NAME) references USERS(USER_NAME));

	create unique index IX_USER_ROLES_USER_NAME on USER_ROLES (USER_NAME, role);

	insert into USERS (USER_NAME, PASSWORD, IS_ACTIVE)values ('user','$2a$10$3OcLqfJXrxSbXLEx0/BV7.xwCv/yMIdbfpoiNWWIrKHgyb2FuATsK', true);
	insert into USERS (USER_NAME, PASSWORD, IS_ACTIVE)values ('root','$2a$10$h5CUEDJgZ6w/WqZ/7.1AKOuenq7r9Go751G2/gCL5geoEaO1bmTsW', true);
	insert into USER_ROLES (USER_NAME, ROLE) values ('root','ROLE_ADMIN');
	insert into USER_ROLES (USER_NAME, ROLE) values ('user','ROLE_USER');
	*/
	

}
