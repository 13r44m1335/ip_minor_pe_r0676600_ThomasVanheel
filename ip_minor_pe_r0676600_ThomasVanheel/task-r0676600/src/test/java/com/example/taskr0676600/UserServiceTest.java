package com.example.taskr0676600;

import com.example.taskr0676600.domain.service.UserService;
import com.example.taskr0676600.dto.CreateUserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Transactional
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testLoadUserByUsername() {
        // setup
        CreateUserDTO userDTO = new CreateUserDTO();
        userDTO.setUsername("Test");
        userDTO.setPassword("t");
        userService.createUser(userDTO);

        // method to be tested
        UserDetails userDetails = userService.loadUserByUsername("Test");

        // checks
        assertNotNull(userDetails);
        assertEquals("Test", userDetails.getUsername());
    }


}
