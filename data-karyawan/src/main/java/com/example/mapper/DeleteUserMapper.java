package com.example.mapper;

import com.example.tuple.TupleDeleteUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DeleteUserMapper {
    int deleteUserByUsername(String username);

    TupleDeleteUser findByUsername(String username);

}
