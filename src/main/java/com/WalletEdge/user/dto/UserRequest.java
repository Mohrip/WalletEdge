package com.WalletEdge.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequest {

    @NotBlank(message = "First Name is required")
    private String firstName;

    @NotBlank(message = "Last Name is required")
    private String lastName;


    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;


    @NotBlank(message = "phone number is required")
    private String phoneNumber;

}
