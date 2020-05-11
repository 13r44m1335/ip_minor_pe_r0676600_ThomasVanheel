package com.example.taskr0676600.domain.service;

import com.example.taskr0676600.domain.model.User;
import com.example.taskr0676600.domain.model.UserRole;
//import com.example.taskr0676600.dto.CreateUserDTO;
import com.example.taskr0676600.dto.CreateUserDTO;
import com.example.taskr0676600.dto.UserDTO;
import com.example.taskr0676600.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User does not exist");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Collections.singletonList(new SimpleGrantedAuthority(user.getRole().name())));
    }

    @Override
    public UserDTO createUser(CreateUserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        System.out.println(userDTO.getUserRole());
        if(userDTO.getUserRole().equals("ADMIN")) user.setRole(UserRole.ADMIN);
        else user.setRole(UserRole.USER);
        user = repository.save(user);
        System.out.println("user created");
        return convert(user);

    }

    private UserDTO convert(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setRole(user.getRole());
        return dto;
    }
}
