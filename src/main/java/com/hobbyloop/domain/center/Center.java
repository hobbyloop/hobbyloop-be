package com.hobbyloop.domain.center;

import com.hobbyloop.domain.BaseTime;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Entity
public class Center extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long centerId;

    private String name;

    private String kakaoLinkUrl;

    private int saleCount;

    private int reviewCount;

    private String repImageUrl;

    private String centerIntroduction;

    private String facilityIntroduction;

    private LocalDateTime counselingTime;
}
