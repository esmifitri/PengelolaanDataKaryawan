package com.example.mapper;

import com.example.tuple.TupleLogin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LoginMapper {
    TupleLogin findByUsername(String username);
}
