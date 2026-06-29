package com.WalletEdge.user.service;

import com.WalletEdge.user.dto.UserRequest;
import com.WalletEdge.user.dto.UserResponse;
import com.WalletEdge.user.entity.User;
import com.WalletEdge.user.mapper.UserMapper;
import com.WalletEdge.user.repository.UserRepository;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;



@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserResponse registerUser(UserRequest userRequest){
        log.info("Registering user {}", userRequest.getFirstName());
        if(userRepository.existsByEmail(userRequest.getEmail())) {
            throw new IllegalStateException("User with email " + userRequest.getEmail() + " already exists");
        }

        User user = userMapper.toEntity(userRequest);
        User savedUser = userRepository.save(user);
        log.info("User saved {}", savedUser);
        return userMapper.toResponse(savedUser);
    }

    @Transactional(readOnly = true)
    public UserResponse getUserById(UUID id) {
        log.info("Retrieving user by id {}", id);
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("User with id " + id + " not found"));
        return userMapper.toResponse(user);
    }
}
