package com.example.mapper;

import com.example.tuple.TupleEditUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface EditUserMapper {

    int updateUser(TupleEditUser user);

    TupleEditUser findByUsername(String username);

}
