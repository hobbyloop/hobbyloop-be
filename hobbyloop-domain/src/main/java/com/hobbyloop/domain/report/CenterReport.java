package com.hobbyloop.domain.report;

import com.hobbyloop.domain.center.Center;
import com.hobbyloop.domain.user.User;

import javax.persistence.*;

@Entity
public class CenterReport extends Report {

    @ManyToOne
    @JoinColumn(name = "centerId")
    private Center center;
}
