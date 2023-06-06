package com.leek.guestbooks.Service;

import com.leek.guestbooks.pojo.User;

public interface UserService {
    User loginService(String name,String password);

    User registService(User user);

}
