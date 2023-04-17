package hobbyloop.backend.domain.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Setter
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String password;

    @Enumerated(value = EnumType.STRING)
    private AuthProvider authProvider;
    private String socialEmail;

    @Enumerated(value = EnumType.STRING)
    private UserStatus userStatus;

    @Enumerated(value = EnumType.STRING)
    private UserRole userRole;

    private String nickname;
    private String profileImgUrl;
    private String introduction;
    private int point;
    private String account;

    private LocalDate infoAgreement;
    private LocalDate locationAgreement;

}
