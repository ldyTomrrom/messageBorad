package com.mesboard.mapper;

import com.mesboard.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(String acId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String acId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User userLogin(@Param("at") String at, @Param("pwd") String pwd);

    User checkPhone(@Param("at") String at);
}