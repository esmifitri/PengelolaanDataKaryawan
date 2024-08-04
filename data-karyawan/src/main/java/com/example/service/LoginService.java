package com.example.service;

import com.example.mapper.LoginMapper;
import com.example.tuple.TupleLogin;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;

@Service
public class LoginService {

    @Autowired
    private LoginMapper loginMapper;

    public boolean authenticateUser(String username, String password) {
        TupleLogin user = loginMapper.findByUsername(username);
        if (user == null) {
            return false; // User tidak ditemukan
        }
        String hashedPassword = DigestUtils.md5DigestAsHex(password.getBytes());
        return hashedPassword.equals(user.getPassword()); // Verifikasi password
    }

}
