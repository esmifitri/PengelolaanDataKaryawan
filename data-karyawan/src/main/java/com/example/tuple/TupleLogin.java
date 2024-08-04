package com.example.tuple;
import lombok.Data;

@Data
public class TupleLogin {
    private String username;
    private String password; // Simpan password yang sudah di-hash

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
