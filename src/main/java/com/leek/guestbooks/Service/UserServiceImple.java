package com.leek.guestbooks.Service;

import com.leek.guestbooks.pojo.User;
import com.leek.guestbooks.repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service()
public class UserServiceImple implements UserService{

    @Resource
    private UserRepository userRepository;
    @Override
    public User loginService(String name, String password) {
        User user =userRepository.findByNameAndPassword(name,password);
        if(user!=null){
            user.setPassword("");
        }
        return user;
    }

    @Override
    public User registService(User user) {
        if(userRepository.findByName(user.getName())!=null){
            return null;
        }else{
            User newUser = userRepository.save(user);
            if(newUser!=null){
                newUser.setPassword("");
            }
            return newUser;
        }
    }
}
