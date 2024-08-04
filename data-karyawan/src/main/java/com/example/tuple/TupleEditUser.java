package com.example.tuple;

import lombok.Data;

@Data
public class TupleEditUser {
    private String oldUsername;
    private String oldPassword; // Password lama yang sudah di-hash
    private String newUsername;
    private String newPassword; // Password baru yang sudah di-hash

    // Getters and setters
    public String getOldUsername() {
        return oldUsername;
    }

    public void setOldUsername(String oldUsername) {
        this.oldUsername = oldUsername;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewUsername() {
        return newUsername;
    }

    public void setNewUsername(String newUsername) {
        this.newUsername = newUsername;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
