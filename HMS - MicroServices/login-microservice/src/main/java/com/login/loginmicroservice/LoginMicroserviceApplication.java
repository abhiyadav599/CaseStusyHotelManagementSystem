package com.login.loginmicroservice;

import com.login.loginmicroservice.model.Role;
import com.login.loginmicroservice.model.User;
import com.login.loginmicroservice.model.UserRole;
import com.login.loginmicroservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class LoginMicroserviceApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;


	public static void main(String[] args) {
		SpringApplication.run(LoginMicroserviceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		System.out.println("Code start");

//		User user = new User();
//
//		user.setUserName("abhi");
//		user.setPassword("abhi");
//		user.setProfile("abc.png");
//
//		Role role1 = new Role();
//		role1.setRoleId(1);
//		role1.setRoleName("ADMIN");
//
//		Set<UserRole> userRoleSet = new HashSet<>();
//		UserRole userRole = new UserRole();
//		userRole.setRole(role1);
//		userRole.setUser(user);
//		userRoleSet.add(userRole);
//
//		User user1 = this.userService.createUser(user, userRoleSet);
//		System.out.println(user1.getUserName());

	}

}
