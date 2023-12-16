package com.codedecode.userInfo.service;

import com.codedecode.userInfo.dto.UserDTO;
import org.springframework.http.ResponseEntity;

public interface UserService {
    UserDTO addUser(UserDTO userDTO);

    ResponseEntity<UserDTO> fetchUserDetailsById(Integer userId);
}
