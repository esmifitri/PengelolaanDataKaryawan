package com.example.mapper;

import com.example.tuple.TupleInsertUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface InsertUserMapper {

    TupleInsertUser findByUsername(String username);

    void insertUser(TupleInsertUser user);
}
