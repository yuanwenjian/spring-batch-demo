package com.yuanwj.batch.model;

import lombok.Data;

import java.util.Date;

@Data
public class Topic {
    private Integer id;

    private String title;
    private String content;
    private String tag;
    private Date inTime;
}
