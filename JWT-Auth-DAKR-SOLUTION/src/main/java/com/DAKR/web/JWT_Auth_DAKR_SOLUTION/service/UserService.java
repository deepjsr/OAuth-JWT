package com.DAKR.web.JWT_Auth_DAKR_SOLUTION.service;

import com.DAKR.web.JWT_Auth_DAKR_SOLUTION.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private List<User> store=new ArrayList<>();

    public UserService(){
        store.add(new User(UUID.randomUUID().toString(),"Deep","d@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(),"Fahad","fh@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(),"Ankiya","an@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(),"Anuja","aj@gmail.com"));
    }

    public List<User> getUsers(){
        return this.store;
    }
}
