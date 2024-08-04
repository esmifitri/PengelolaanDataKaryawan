package com.example.mapper;

import com.example.tuple.TupleDeleteKaryawan;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DeleteKaryawanMapper {
    int deleteKaryawanByUsername(String username);

    TupleDeleteKaryawan findByUsernameKaryawan(String username);
}
