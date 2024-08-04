package com.example.service;

import com.example.mapper.DeleteUserMapper;
import com.example.mapper.EditUserMapper;
import com.example.mapper.InsertUserMapper;
import com.example.tuple.TupleEditUser;
import com.example.tuple.TupleInsertUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private InsertUserMapper insertUserMapper;

    @Autowired
    private EditUserMapper editUserMapper;

    @Autowired
    private DeleteUserMapper deleteUserMapper;

    public boolean createUser(TupleInsertUser user) {
        if (insertUserMapper.findByUsername(user.getUsername()) != null) {
            return false;
        }

        user.setId(UUID.randomUUID().toString());
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes(StandardCharsets.UTF_8)));
        user.setCreatedAt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        insertUserMapper.insertUser(user);
        return true;
    }

    public String updateUser(String oldUsername, String oldPassword, String newUsername, String newPassword) {
        // Cek apakah username baru sudah ada
        TupleEditUser existingUser = editUserMapper.findByUsername(newUsername);
        if (existingUser != null && !oldUsername.equals(newUsername)) {
            return null; // Username sudah ada
        }

        // Hash password lama untuk verifikasi
        String hashedOldPassword = DigestUtils.md5DigestAsHex(oldPassword.getBytes());

        // Hash password baru
        String hashedNewPassword = DigestUtils.md5DigestAsHex(newPassword.getBytes());

        // Create TupleUser object
        TupleEditUser user = new TupleEditUser();
        user.setOldUsername(oldUsername);
        user.setOldPassword(hashedOldPassword);
        user.setNewUsername(newUsername);
        user.setNewPassword(hashedNewPassword);

        // Update username dan password
        int rowsAffected = editUserMapper.updateUser(user);
        if (rowsAffected > 0) {
            return newUsername; // Jika baris terpengaruh lebih dari 0, update berhasil
        }
        return null; // Jika tidak ada baris yang terpengaruh, update gagal
    }

    public boolean deleteUser(String username) {
        // Cek apakah pengguna ada
        if (deleteUserMapper.findByUsername(username) != null) {
            // Hapus pengguna
            int rowsAffected = deleteUserMapper.deleteUserByUsername(username);
            return rowsAffected > 0; // Mengembalikan true jika pengguna berhasil dihapus
        }
        return false; // Pengguna tidak ditemukan
    }
}
