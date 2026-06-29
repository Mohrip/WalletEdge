package com.WalletEdge.shared.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;


@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {


    @Id
    @UuidGenerator
    @Column(updatable = false, nullable = false)
    private UUID id;

    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdDate;


    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime lastModifiedDate;

}
