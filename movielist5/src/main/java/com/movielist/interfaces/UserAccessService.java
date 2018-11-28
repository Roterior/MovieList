package com.movielist.interfaces;

import com.movielist.main.dto.Customer;

public interface UserAccessService {

    Customer loginUser(String login, String password);

    Customer registerUser(String login, String password, String name);
}
