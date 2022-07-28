package com.prac.mybatis.mapper;

import com.prac.mybatis.model.UserProfile;
import org.apache.ibatis.annotations.*;


import java.util.List;

@Mapper
public interface UserProfileMapper {
    //DB에서 id로 UserProfile 조회 해서 리턴
    @Select("SELECT * FROM UserProfile WHERE id=#{id}")
    UserProfile getUserProfile(@Param("id") String id);

    @Select("SELECT * FROM UserProfile")
    List<UserProfile> getUserProfileList();

    //SQL문에 적용된 레코드의 갯수가 반환
    @Insert("INSERT INTO UserProfile VALUES(#{id},#{name},#{phone},#{address})")
    int insertUserProfile(@Param("id") String id, @Param("name") String name,
                          @Param("phone") String phone, @Param("address") String address);

    @Update("UPDATE UserProfile SET name=#{name}, phone=#{phone}, address=#{address}) WHERE id=#{id}")
    int updateUserProfile(@Param("id") String id, @Param("name") String name,
                          @Param("phone") String phone, @Param("address") String address);

    @Delete("DELETE FROM UserProfile WHERE id=#{id}")
    int deleteUserProfile(@Param("id") String id);
}
