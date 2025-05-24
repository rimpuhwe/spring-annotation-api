package com.springboot.usermanager.User;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLogic {
    private final UserRepository userRepository;

    public UserLogic(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public UserTable CreateUser(UserTable user){
        return userRepository.save(user);
    }
    public List<UserTable> GetAllUsers(){
        return userRepository.findAll();
    }
    public UserTable GetUserById(Long id){
        return userRepository.findById(id).orElseThrow(()->new RuntimeException("user not found"));
    }
    public void Delete(long id){
        var table = userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));
         userRepository.delete(table);
    }
    public UserTable Update(long id, UserTable user){
        var table = userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));
        table.setFirstname(user.getFirstname());
        table.setLastname(user.getLastname());
        table.setEmail(user.getEmail());
        return userRepository.save(table);
    }

}
