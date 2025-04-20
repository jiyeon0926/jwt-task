package com.example.task.domain.notice.entity;

import com.example.task.domain.user.entity.User;
import com.example.task.global.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "notice")
@Getter
@NoArgsConstructor
public class Notice extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(nullable = false)
    private boolean isDeleted = false;

    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = false)
    private User user;

    public Notice(User user, String title, String content) {
        this.user = user;
        this.title = title;
        this.content = content;
    }
}
