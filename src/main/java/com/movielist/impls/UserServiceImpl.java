package com.movielist.impls;

import com.movielist.interfaces.UserAccessService;
import com.movielist.interfaces.UserService;
import com.movielist.main.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    UserServiceImpl(UserAccessService userAccessService) {
        this.userAccessService = userAccessService;
    }

    private UserAccessService userAccessService;

    @Override
    public Customer loginUser(String login, String password) {
        return userAccessService.loginUser(login, password);
    }

    @Override
    public Customer registerUser(String login, String password, String name) {
        return userAccessService.registerUser(login,password,name);
    }
}
