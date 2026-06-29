package com.WalletEdge.user.dto;

import lombok.*;


import java.time.LocalDateTime;
import java.util.UUID;




@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {

    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

