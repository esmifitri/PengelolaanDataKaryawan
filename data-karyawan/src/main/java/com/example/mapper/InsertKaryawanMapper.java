package com.example.mapper;

import com.example.tuple.TupleInsertKaryawan;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface InsertKaryawanMapper {

    TupleInsertKaryawan findByUsername(String username);

    void insertKaryawan(TupleInsertKaryawan karyawan);
}
