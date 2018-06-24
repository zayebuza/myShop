package com.demo.shopuser.mapper;

import com.demo.shopuser.entity.User;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Created by miaodongbiao
 * Date:2018/6/24-13:59
 * Description:
 */
@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {
    /**
     * 根据登录名查找用户信息
     * @param username
     * @return
     */
   @Select("SELECT\n" +
           "    \t\tuser_id AS userId, \n" +
           "    \t\tuser_number AS userNumber, \n" +
           "    \t\tuser_name AS userName, \n" +
           "    \t\tlogin_password AS loginPassword, \n" +
           "    \t\treal_name AS realName, \n" +
           "    \t\tsalt,\n" +
           "    \t\tstatus,\n" +
           "    \t\temail_is_active AS emailIsActive,\n" +
           "    \t\temail, \n" +
           "    \t\ttelephone\n" +
           "    \tFROM\n" +
           "    \t\tos_user\n" +
           "    \tWHERE\n" +
           "    \t\temail = #{loginName} \n" +
           "    \tOR telephone = #{loginName}")
    User getUserByLoginName(String username);

    @Delete("delete from os_user where user_id = #{userId}")
    void deleteById(Long userId);

}
