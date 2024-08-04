package com.example.controller;

import com.example.mapper.InsertUserMapper;
import com.example.mapper.KaryawanMapper;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import com.example.tuple.TupleEmailUser;
import com.example.tuple.TupleInsertUser;
import com.example.tuple.TupleKaryawan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private InsertUserMapper insertUserMapper;

    @Autowired
    private UserService userService;


    @GetMapping(path = "/get-user")
    public ResponseEntity emailList(){
        LinkedHashMap<String, Object> res = new LinkedHashMap<>();
        try{
            List<TupleEmailUser> userEmail = userMapper.getEmailUser();
            res.put("status", true);
            res.put("message", "Data user berhasil diambil");
            res.put("data", userEmail);
            return ResponseEntity.ok().body(res);
        }
        catch (Exception e){
            res.put("status", false);
            res.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(res);
        }
    }

    @PostMapping(path = "/insert-user")
    public ResponseEntity insertUser(@RequestBody TupleInsertUser user){
        LinkedHashMap<String, Object> res = new LinkedHashMap<>();
        try {
            boolean isCreated = userService.createUser(user);
            if (isCreated) {
                res.put("status", true);
                res.put("message", "Data user berhasil dibuat");
            } else {
                res.put("status", false);
                res.put("message", "Username sudah ada, silahkan coba username lainnya");
            }
            return ResponseEntity.ok().body(res);
        } catch (Exception e) {
            res.put("status", false);
            res.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(res);
        }
    }

    @PutMapping("/edit-user")
    public ResponseEntity editUser(
            @RequestParam(value = "oldUsername", required = true) String oldUsername,
            @RequestParam(value = "oldPassword", required = true) String oldPassword,
            @RequestParam(value = "newUsername", required = true) String newUsername,
            @RequestParam(value = "newPassword", required = true) String newPassword) {

        LinkedHashMap<String, Object> res = new LinkedHashMap<>();
        try {
            String updatedUsername = userService.updateUser(oldUsername, oldPassword, newUsername, newPassword);
            if (updatedUsername != null) {
                res.put("status", true);
                res.put("newUsername", updatedUsername); // Menyertakan username baru dalam respons
                res.put("message", "Data user berhasil diupdate");
            } else {
                res.put("status", false);
                res.put("message", "Invalid password atau username sudah terpakai");
            }
            return ResponseEntity.ok().body(res);
        } catch (Exception e) {
            res.put("status", false);
            res.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(res);
        }
    }

    @DeleteMapping("/delete-user")
    public ResponseEntity<?> deleteUser(@RequestParam String username) {
        LinkedHashMap<String, Object> res = new LinkedHashMap<>();
        try {
            boolean isDeleted = userService.deleteUser(username);
            if (isDeleted) {
                res.put("status", true);
                res.put("message", "Data user berhasil dihapus");
            } else {
                res.put("status", false);
                res.put("message", "User tidak ditemukan");
            }
            return ResponseEntity.ok().body(res);
        } catch (Exception e) {
            res.put("status", false);
            res.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(res);
        }
    }
}
