package com.example.mapper;

import com.example.tuple.TupleKaryawan;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface KaryawanMapper {

    List<TupleKaryawan> getDataKaryawan(String id);

}
