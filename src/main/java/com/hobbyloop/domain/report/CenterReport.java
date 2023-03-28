package com.hobbyloop.domain.report;

import com.hobbyloop.domain.center.Center;
import com.hobbyloop.domain.user.User;

import javax.persistence.*;

@Entity
public class CenterReport extends Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long centerReportId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User reporter;

    @ManyToOne
    @JoinColumn(name = "centerId")
    private Center center;
}
