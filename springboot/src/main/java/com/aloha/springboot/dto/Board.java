package com.aloha.springboot.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Board {
    private int no;
    private String title;
    private String content;
    private String writer;
    private Date createdAt;
    private Date updatedAt;
}
