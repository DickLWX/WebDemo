package dick.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import dick.entity.User;

public interface UserMapper extends BaseMapper<User>{
    @Delete({
        "delete from table_user",
        "where user_id = #{userId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String userId);

    @Insert({
        "insert into table_user (user_id, user_nickname, ",
        "user_password, user_email, ",
        "acti_state, acti_code, ",
        "salt, token_exptime)",
        "values (#{userId,jdbcType=VARCHAR}, #{userNickname,jdbcType=VARCHAR}, ",
        "#{userPassword,jdbcType=VARCHAR}, #{userEmail,jdbcType=VARCHAR}, ",
        "0, uuid(),",
        "#{salt,jdbcType=VARCHAR}, now())"
    })
    int insert(User record);

    @InsertProvider(type=UserSqlProvider.class, method="insertSelective")
    int insertSelective(User record);

    @Select({
        "select",
        "user_id, user_nickname, user_password, user_email, acti_state, acti_code, salt, ",
        "token_exptime",
        "from table_user",
        "where user_id = #{userId,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="user_nickname", property="userNickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_password", property="userPassword", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_email", property="userEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="acti_state", property="actiState", jdbcType=JdbcType.INTEGER),
        @Result(column="acti_code", property="actiCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="salt", property="salt", jdbcType=JdbcType.VARCHAR),
        @Result(column="token_exptime", property="tokenExptime", jdbcType=JdbcType.TIMESTAMP)
    })
    User selectByPrimaryKey(String userId);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User record);

    @Update({
        "update table_user",
        "set user_nickname = #{userNickname,jdbcType=VARCHAR},",
          "user_password = #{userPassword,jdbcType=VARCHAR},",
          "user_email = #{userEmail,jdbcType=VARCHAR},",
          "acti_state = #{actiState,jdbcType=INTEGER},",
          "acti_code = #{actiCode,jdbcType=VARCHAR},",
          "salt = #{salt,jdbcType=VARCHAR},",
          "token_exptime = #{tokenExptime,jdbcType=TIMESTAMP}",
        "where user_id = #{userId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(User record);
}