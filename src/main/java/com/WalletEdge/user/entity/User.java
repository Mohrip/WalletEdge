package com.WalletEdge.user.entity;

import com.WalletEdge.shared.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User extends BaseEntity {


    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 12)
    private String password;


    @Column(nullable = false, unique = true)
    @Email(message = "Must be a valid email address")
    @NotBlank(message = "Email is required")
    private String email;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "phone number is required")
    private String phoneNumber;




}
