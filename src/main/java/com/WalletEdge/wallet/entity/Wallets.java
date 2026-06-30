package com.WalletEdge.wallet.entity;

import com.WalletEdge.shared.entity.BaseEntity;
import com.WalletEdge.user.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Entity
@Table(name = "wallets")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Wallets extends BaseEntity {

@ManyToOne(fetch = FetchType.LAZY, optional = false)
@JoinColumn(name = "user_id", nullable = false, updatable = false)
    private User user;

@Column(nullable = false, unique = true)
@NotNull
private String virtual_iban;

@Column(nullable = false, unique = true)
@NotNull
private String currency;





}
