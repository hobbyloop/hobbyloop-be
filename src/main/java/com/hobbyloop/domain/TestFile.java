package com.hobbyloop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TestFile {
    @Id
    @GeneratedValue
    private Long id;
}
