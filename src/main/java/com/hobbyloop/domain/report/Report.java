package com.hobbyloop.domain.report;

import com.hobbyloop.domain.BaseTime;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Report extends BaseTime {

    private String reportMessage;

}
