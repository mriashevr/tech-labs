package com.example.kotikiadministrator.service;

import com.example.kotikiadministrator.entities.Users;
import com.example.kotikiadministrator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private final UserRepository userRepository;

    @Override
    public Users findById(Integer id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<Users> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(Users user) {
        userRepository.save(user);
    }

    @Override
    public Users update(Users user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(Users user) {
        userRepository.delete(user);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Users user = userRepository.findByLogin(userName);
        if (user == null) {
            throw new UsernameNotFoundException("Unknown user: "+userName);
        }
        UserDetails userDetails = User.builder()
                .username(user.getLogin())
                .password(user.getPassword())
                .roles(user.getRole().toString())
                .build();
        return userDetails;
    }
}
