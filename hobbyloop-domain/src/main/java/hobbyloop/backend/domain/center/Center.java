package hobbyloop.backend.domain.center;

import hobbyloop.backend.domain.BaseTime;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDateTime;

@NoArgsConstructor
@Entity
@Getter
public class Center extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long centerId;

    private String name;

    private String address;

    private String kakaoLinkUrl;

    private int saleCount;

    private int reviewCount;

    private String repImageUrl;

    private String centerIntroduction;

    private String facilityIntroduction;

    private String counselingAvailableTime;
}
