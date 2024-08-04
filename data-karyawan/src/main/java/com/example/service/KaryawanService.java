package com.example.service;

import com.example.mapper.DeleteKaryawanMapper;
import com.example.mapper.EditKaryawanMapper;
import com.example.mapper.InsertKaryawanMapper;
import com.example.tuple.TupleEditKaryawan;
import com.example.tuple.TupleInsertKaryawan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class KaryawanService {

    @Autowired
    private InsertKaryawanMapper insertKaryawanMapper;

    @Autowired
    private EditKaryawanMapper editKaryawanMapper;

    @Autowired
    private DeleteKaryawanMapper deleteKaryawanMapper;

    public boolean createKaryawan(TupleInsertKaryawan karyawan) {
        if (insertKaryawanMapper.findByUsername(karyawan.getUsername()) != null) {
            return false;
        }

        karyawan.setId(UUID.randomUUID().toString());
        karyawan.setCreatedAt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        insertKaryawanMapper.insertKaryawan(karyawan);
        return true;
    }

    public List<TupleEditKaryawan> updateKaryawan(String username, String nama, String alamat, String pendidikanTerakhir) {
        editKaryawanMapper.updateKaryawan(username, nama, alamat, pendidikanTerakhir);
        return editKaryawanMapper.findKaryawanByUsername(username);
    }

    public boolean deleteKaryawan(String username) {
        // Cek apakah pengguna ada
        if (deleteKaryawanMapper.findByUsernameKaryawan(username) != null) {
            // Hapus pengguna
            int rowsAffected = deleteKaryawanMapper.deleteKaryawanByUsername(username);
            return rowsAffected > 0; // Mengembalikan true jika pengguna berhasil dihapus
        }
        return false; // Pengguna tidak ditemukan
    }

}
