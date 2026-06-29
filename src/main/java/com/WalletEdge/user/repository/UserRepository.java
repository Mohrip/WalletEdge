package com.WalletEdge.user.repository;

import com.WalletEdge.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    boolean existsByPhoneNumber(String phoneNumber);

    boolean existsByEmail(String email);


}
