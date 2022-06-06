package com.animalrenting.services;

import com.animalrenting.models.SimpleUser;
import com.animalrenting.models.Users;
import com.animalrenting.repositories.UsersRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service

public class AnimalUserDetailsService implements UserDetailsService {
    private final UsersRepository usersRepository;

    public AnimalUserDetailsService(UsersRepository userRepository) {
        this.usersRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Users user = getFullUserByUsername(userName);

        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(), Collections.emptyList());
    }

    public SimpleUser getUserByUsername(String userName) {
        getFullUserByUsername(userName); // user exists?
        return new SimpleUser(userName);
    }

    private Users getFullUserByUsername(String userName) {
        return usersRepository.findFirstByUsername(userName);
    }
}
