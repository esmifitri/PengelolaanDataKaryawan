package com.example.tuple;

import lombok.Data;

@Data
public class TupleInsertUser {
    private String id;
    private String username;
    private String password;
    private String email;
    private String createdAt;
    private String createdBy;
}
