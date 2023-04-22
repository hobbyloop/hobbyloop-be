package hobbyloop.backend.domain.user;

import hobbyloop.backend.domain.user.User;
import hobbyloop.backend.domain.user.UserStatus;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userProfileId;

    @OneToOne
    private User user;

    @Enumerated(value = EnumType.STRING)
    private UserStatus userStatus;

    private String name;
    private String nickname;
    private String profileImgUrl;
    private String introduction;
    private int point;
    private String account;
    private LocalDate infoAgreement;
    private LocalDate locationAgreement;

}
