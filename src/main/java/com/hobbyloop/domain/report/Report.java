package com.hobbyloop.domain.report;

import com.hobbyloop.domain.BaseTime;
import com.hobbyloop.domain.user.User;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Report extends BaseTime {

    @Id
    @GeneratedValue
    private Long reportId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User reporter;
    private String reportMessage;

    @Enumerated(EnumType.STRING)
    private ReportCategory reportCategory;
}
