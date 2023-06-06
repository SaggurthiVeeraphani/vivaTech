package com.example.VivaTech.Service;

import com.example.VivaTech.Model.user;
import com.example.VivaTech.Respository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String phoneNo) throws UsernameNotFoundException {
        user user1 = userRepository.findByUserName(phoneNo);
        if(user1 == null){
            user1 = new user();
            user1.setUserName(phoneNo);
            userRepository.save(user1);
        }
        return new org.springframework.security.core.userdetails.User(user1.getUserName(), "",
                new ArrayList<>());
    }
}
