package hobbyloop.backend.domain.user;

import hobbyloop.backend.domain.BaseTime;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
@AllArgsConstructor
public class User extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Enumerated(value = EnumType.STRING)
    private SocialType socialType;
    private String email;

    private String password;

    private String socialEmail;

    @Column(columnDefinition="TEXT")
    private String accessToken;
    @Column(columnDefinition="TEXT")
    private String refreshToken;
    private String socialId;


    @Enumerated(value = EnumType.STRING)
    private Role role;

    // 비밀번호 암호화 메소드
    public void passwordEncode(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(this.password);
    }

    public void updateRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public void updateAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void updateUserRole(Role role) {
        this.role = role;
    }
}
