package com.waterfogsw.ssoauth2.user.entity;

import com.waterfogsw.ssoauth2.common.entity.BaseTime;
import com.waterfogsw.ssoauth2.oauth.entity.ProviderType;
import com.waterfogsw.ssoauth2.oauth.entity.RoleType;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 64)
    @Column(length = 64, unique = true)
    private String userId;

    @NotBlank
    @Size(max = 100)
    @Column(length = 100)
    private String username;

    @NotBlank
    @Size(max = 128)
    @Column(length = 128)
    private String password;

    @NotBlank
    @Size(max = 512)
    @Column(length = 512, unique = true)
    private String email;

    @NotBlank
    @Size(min = 1, max = 1)
    @Column(length = 1)
    private String emailVerifiedYn;

    @NotBlank
    @Size(max = 512)
    @Column(length = 512)
    private String profileImageUrl;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ProviderType providerType;

    @NotNull
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    protected User() {/*no-op*/}

    public User(
            @NotBlank @Size(max = 64) String userId,
            @NotBlank @Size(max = 100) String username,
            @NotBlank @Size(max = 512) String email,
            @NotBlank @Size(max = 1) String emailVerifiedYn,
            @NotBlank @Size(max = 512) String profileImageUrl,
            @NotNull ProviderType providerType,
            @NotNull RoleType roleType
    ) {
        this.userId = userId;
        this.username = username;
        this.password = "NO_PASS";
        this.email = email != null ? email : "NO_EMAIL";
        this.emailVerifiedYn = emailVerifiedYn;
        this.profileImageUrl = profileImageUrl != null ? profileImageUrl : "";
        this.providerType = providerType;
        this.roleType = roleType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public ProviderType getProviderType() {
        return providerType;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }
}
