package hobbyloop.backend.domain.userProfile;

import hobbyloop.backend.domain.user.User;
import hobbyloop.backend.domain.user.UserStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
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

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    private LocalDate birth;
    private String phoneNum;

    private int chargedPoint;
    private int givenPoint;
    private String account;
    private LocalDate infoAgreement;
    private LocalDate locationAgreement;

}