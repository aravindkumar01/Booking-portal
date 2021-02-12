package com.booking.hotel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.booking.hotel.Repo.RoleRepo;
import com.booking.hotel.Repo.UserRoleRepo;
import com.booking.hotel.Repo.UsersRepo;
import com.booking.hotel.model.Role;
import com.booking.hotel.model.User;
import com.booking.hotel.model.UserRole;

@SpringBootApplication
public class Application extends  SpringBootServletInitializer{

	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    
    @Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(Application.class);
	}
    
    @Bean
    public CommandLineRunner demoData(UsersRepo repo,RoleRepo roleRepo,UserRoleRepo userRoleRepo) {
        return args -> { 

            //repo.save(new Entity(...));
        	List<Role> roleList=roleRepo.findAll();
        	if(roleList.isEmpty()) {
        		Role r=new Role();
        		r.setName("ADMIN");
        		r.setDescription("admin");        		
        		roleRepo.save(r);
        			        		
        	}
        	
        	List<User> users=repo.findAll();
        	if(users.isEmpty()) {
        		
        		
        		User u=new User();
		        		u.setUsername("aravindkumark1997@gmail.com");	
		        		u.setActive(0);
		        		u.setPassword(bcryptEncoder.encode("1234"));
        		repo.save(u);  
        		
        		User r1=repo.findByUsername(u.getUsername());        		
        		
        		UserRole role=new UserRole();
        		   role.setRole_id(roleRepo.finId("ADMIN"));
        		   role.setUser_id(r1.getId());
        		userRoleRepo.save(role);
        		      		 
        		 
        	
        	}
        	
        };
    }
}
