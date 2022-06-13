package com.waterfogsw.ssoauth2.user.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "USER_REFRESH_TOKEN")
public class UserRefreshToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long refreshTokenSeq;

    @NotBlank
    @Size(max = 64)
    @Column(length = 64, unique = true)
    private String userId;

    @NotBlank
    @Size(max = 256)
    @Column(length = 256)
    private String refreshToken;

    protected UserRefreshToken() {
    }

    public UserRefreshToken(
            @NotBlank @Size(max = 64) String userId,
            @NotBlank @Size(max = 256) String refreshToken
    ) {
        this.userId = userId;
        this.refreshToken = refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
