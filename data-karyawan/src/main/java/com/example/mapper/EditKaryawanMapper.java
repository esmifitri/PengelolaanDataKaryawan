package com.example.mapper;

import com.example.tuple.TupleEditKaryawan;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EditKaryawanMapper {
    int updateKaryawan(String username, String nama, String alamat, String pendidikanTerakhir);

    List<TupleEditKaryawan> findKaryawanByUsername(String username);
}
