package com.booking.hotel.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.booking.hotel.Repo.UsersRepo;
import com.booking.hotel.dao.UserDao;
import com.booking.hotel.model.User;
import com.booking.hotel.service.UserService;


@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {
	
	@Autowired
	private UserDao userDao;
	
	
	@Autowired
	private UsersRepo userRepo;

	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;
	
	@Autowired
	RoleService roleService;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUsername(username);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
	}

	private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		user.getRoles().forEach(role -> {
			//authorities.add(new SimpleGrantedAuthority(role.getName()));
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
		});
		return authorities;
		//return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	public List<User> findAll() {
		List<User> list = new ArrayList<>();
		userDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(long id) {
		userDao.deleteById(id);
	}

	@Override
	public User findOne(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public User findById(Long id) {
		return userDao.findById(id).get();
	}

	@Override
    public String save(User user,String role) {
		try {
			
			if (user.getId() == 0) {
				if (findByEmail(user.getUsername()) != null) {
					return "Email already registerd";
				}

			}
			
			User newUser = new User();
			if(user.getId()==0){		
				
			    newUser.setUsername(user.getUsername());
			    newUser.setPassword(bcryptEncoder.encode(user.getPassword()));		
			    newUser.setName(user.getName());
			    userDao.save(newUser);
			    long user_id=userRepo.findId(user.getUsername());
			    newUser.setId(user_id);
			    roleService.newUserRole(user_id,role);
				
			}
			else{
				newUser.setId(user.getId());
			    newUser.setUsername(user.getUsername());
			    newUser.setName(user.getName());
			    newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
			    userDao.save(newUser);	  
			    
			    roleService.updateRole(user.getId(), role);
			
			}
			  	
		        return "successfully register";
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
			// TODO: handle exception
		}
	  
    }
	
	public long findByid(String email)
	{
		
		try {
			
			return userRepo.findId(email);
		} catch (Exception e) {
			return 0;
			// TODO: handle exception
		}
	}
	
	
	public User findByEmail(String username)
	{
		
		try {			
			
			return userRepo.findByUsername(username);
		} catch (Exception e) {
			return null;
			// TODO: handle exception
		}
	}

	public String deleteByUser(String username) {
		// TODO Auto-generated method stub

		try {
			userRepo.deleteByEmail(username);
			return "sucess";
		} catch (Exception e) {
			
			return e.toString();
			// TODO: handle exception
		}
		
	}
	
}
