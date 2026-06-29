package com.WalletEdge.user.mapper;

import com.WalletEdge.user.dto.UserRequest;
import com.WalletEdge.user.dto.UserResponse;
import com.WalletEdge.user.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {


    public User toEntity(UserRequest userRequest) {
        return User.builder()
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .email(userRequest.getEmail())
                .phoneNumber(userRequest.getPhoneNumber())
                .build();
    }

    public UserResponse toResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .createdAt(user.getCreatedDate())
                .updatedAt(user.getLastModifiedDate())
                .build();
    }
}
