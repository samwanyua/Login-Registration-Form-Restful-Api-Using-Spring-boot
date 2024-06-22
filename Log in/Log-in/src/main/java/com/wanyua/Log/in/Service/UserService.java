package com.wanyua.Log.in.Service;

import com.wanyua.Log.in.Entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User registerUser(String login, String password, String email){
        if(login != null && password != null){
            User user = new User();
            user.setLogin();

        }
    }
}
