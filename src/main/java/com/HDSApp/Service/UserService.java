package com.HDSApp.Service;

import com.HDSApp.Repository.UserRepository;
import com.HDSApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserService{

    @Autowired
    private UserRepository userRepository;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void saveUser(User user){
        userRepository.save(user);
    }

    public void saveNewUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public Optional<User> getUserById(ObjectId objectId){
        return userRepository.findById(objectId);
    }

    public boolean deleteById(ObjectId objectId){
        userRepository.deleteById(objectId);
        return true;
    }

    public User findByUserName(String username){
        return userRepository.findByUserName(username);
    }

    public void deleteByUserName(String username){
        userRepository.deleteByUserName(username);
    }
}
