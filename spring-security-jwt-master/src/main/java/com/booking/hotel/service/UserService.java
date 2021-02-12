package com.booking.hotel.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.booking.hotel.model.User;

public interface UserService {

    String save(User user,String role);
    List<User> findAll();
    void delete(long id);
    User findOne(String username);

    User findById(Long id);
}
