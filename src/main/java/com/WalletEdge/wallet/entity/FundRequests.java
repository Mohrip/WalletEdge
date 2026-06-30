package com.WalletEdge.wallet.entity;

import com.WalletEdge.shared.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "fund_requests")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FundRequests extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String idempotencyKey;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "wallet_id", nullable = false, updatable = false)
    private Wallets wallet;

    @Column(name = "user_id", nullable = false, updatable = false)
    private UUID userId;

    @Column(nullable = false, precision = 18, scale = 4)
    private BigDecimal amount;

    @Column(nullable = false, length = 3)
    @Builder.Default
    private String currency = "SAR";

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RequestType requestType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private FundRequestStatus status = FundRequestStatus.PENDING;

    @Column
    private UUID paymentId;

    @Column
    private String paymentUrl;

    public enum RequestType {
        TOPUP, FUND_TRANSFER
    }

    public enum FundRequestStatus {
        PENDING, PROCESSING, PAID, FAILED
    }
}
