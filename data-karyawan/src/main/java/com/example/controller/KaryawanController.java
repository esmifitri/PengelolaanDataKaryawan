package com.example.controller;

import com.example.mapper.KaryawanMapper;
import com.example.mapper.InsertKaryawanMapper;
import com.example.service.KaryawanService;
import com.example.service.UserService;
import com.example.tuple.TupleEditKaryawan;
import com.example.tuple.TupleInsertKaryawan;
import com.example.tuple.TupleKaryawan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;

@RestController
public class KaryawanController {

    @Autowired
    private KaryawanMapper karyawanMapper;

    @Autowired
    private InsertKaryawanMapper InsertKaryawanMapper;

    @Autowired
    private KaryawanService karyawanService;

    @GetMapping(path = "/get-data-karyawan")
    public ResponseEntity KaryawanList(@RequestParam(value = "id", required = false) String id){
        LinkedHashMap<String, Object> res = new LinkedHashMap<>();
        try{
            List<TupleKaryawan> userKaryawan = karyawanMapper.getDataKaryawan(id);
            res.put("status", true);
            res.put("message", "Data karyawan berhasil diambil");
            res.put("data", userKaryawan);
            return ResponseEntity.ok().body(res);
        }
        catch (Exception e){
            res.put("status", false);
            res.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(res);
        }
    }

    @PostMapping(path = "/insert-data-karyawan")
    public ResponseEntity InsertKaryawan(@RequestBody TupleInsertKaryawan karyawan){
        LinkedHashMap<String, Object> res = new LinkedHashMap<>();
        try{
            boolean isCreated = karyawanService.createKaryawan(karyawan);
            if (isCreated) {
                res.put("status", true);
                res.put("message", "Data karyawan berhasil ditambahkan");
            } else {
                res.put("status", false);
                res.put("message", "Data karyawan / Username sudah ada");
            }
            return ResponseEntity.ok().body(res);
        }
        catch (Exception e){
            res.put("status", false);
            res.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(res);
        }
    }

    @PutMapping("/edit-data-karyawan")
    public ResponseEntity editUser(
            @RequestParam(value = "username", required = true) String username,
            @RequestParam(value = "nama", required = false) String nama,
            @RequestParam(value = "alamat", required = false) String alamat,
            @RequestParam(value = "pendidikanTerakhir", required = false) String pendidikanTerakhir
            ) {

        LinkedHashMap<String, Object> res = new LinkedHashMap<>();
        try {
            List<TupleEditKaryawan> updatedKaryawan = karyawanService.updateKaryawan(username, nama, alamat, pendidikanTerakhir);
            if(updatedKaryawan != null && !updatedKaryawan.isEmpty()) {
                res.put("status", true);
                res.put("updatedData", updatedKaryawan); // Menyertakan username baru dalam respons
                res.put("message", "User berhasil diupdate");
            }
            else{
                res.put("status", false);
                res.put("message", "User tidak ditemukan / Update gagal");
            }
            return ResponseEntity.ok().body(res);
        } catch (Exception e) {
            res.put("status", false);
            res.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(res);
        }
    }

    @DeleteMapping("/delete-data-karyawan")
    public ResponseEntity<?> deleteKaryawan(@RequestParam String username) {
        LinkedHashMap<String, Object> res = new LinkedHashMap<>();
        try {
            boolean isDeleted = karyawanService.deleteKaryawan(username);
            if (isDeleted) {
                res.put("status", true);
                res.put("message", "User berhasil dihapus");
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
