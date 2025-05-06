package com.HDSApp.Service;

import com.HDSApp.Repository.UserRepository;
import com.HDSApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if(user != null){
           return org.springframework.security.core.userdetails.User.builder()
                   .username(user.getUserName())
                   .password(user.getPassword())
                   .build();
        }
        throw new UsernameNotFoundException("user not found with username" + username);
    }
}
