package com.wanyua.Log.in.Service;

import com.wanyua.Log.in.Entity.User;
import com.wanyua.Log.in.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(String login, String password, String email){
        if(login != null && password != null){
            User user = new User();
            user.setLogin(login);
            user.setPassword(password);
            user.setEmail(email);
            return userRepository.save(user);
        }
        else{
            return null;
        }
    }

    public User authentication(String login, String password){
        return userRepository.findByIdAndPassword(login,password)
                .orElse(null);
    }

}
