package com.techpeak.your_openion.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.redis.core.RedisHash;


import java.time.LocalDate;
import java.util.Date;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "opinions")
//@RedisHash("Opinion")
public class OpinionEntity {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    @Column(columnDefinition="TEXT")
    @NotNull(message = "Content should not be null or empty")
    private String content;

    private Boolean isOpened = false;
//    @CreatedDate()
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createdAt = new Date();
}
