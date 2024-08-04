package com.example.mapper;

import com.example.tuple.TupleEmailUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    List<TupleEmailUser> getEmailUser();

}
