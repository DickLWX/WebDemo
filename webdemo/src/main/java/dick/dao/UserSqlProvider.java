package dick.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import dick.entity.User;

public class UserSqlProvider {

    public String insertSelective(User record) {
        BEGIN();
        INSERT_INTO("table_user");
        
        if (record.getUserId() != null) {
            VALUES("user_id", "#{userId,jdbcType=VARCHAR}");
        }
        
        if (record.getUserNickname() != null) {
            VALUES("user_nickname", "#{userNickname,jdbcType=VARCHAR}");
        }
        
        if (record.getUserPassword() != null) {
            VALUES("user_password", "#{userPassword,jdbcType=VARCHAR}");
        }
        
        if (record.getUserEmail() != null) {
            VALUES("user_email", "#{userEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getActiState() != null) {
            VALUES("acti_state", "#{actiState,jdbcType=INTEGER}");
        }
        
        if (record.getActiCode() != null) {
            VALUES("acti_code", "#{actiCode,jdbcType=VARCHAR}");
        }
        
        if (record.getSalt() != null) {
            VALUES("salt", "#{salt,jdbcType=VARCHAR}");
        }
        
        if (record.getTokenExptime() != null) {
            VALUES("token_exptime", "#{tokenExptime,jdbcType=TIMESTAMP}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(User record) {
        BEGIN();
        UPDATE("table_user");
        
        if (record.getUserNickname() != null) {
            SET("user_nickname = #{userNickname,jdbcType=VARCHAR}");
        }
        
        if (record.getUserPassword() != null) {
            SET("user_password = #{userPassword,jdbcType=VARCHAR}");
        }
        
        if (record.getUserEmail() != null) {
            SET("user_email = #{userEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getActiState() != null) {
            SET("acti_state = #{actiState,jdbcType=INTEGER}");
        }
        
        if (record.getActiCode() != null) {
            SET("acti_code = #{actiCode,jdbcType=VARCHAR}");
        }
        
        if (record.getSalt() != null) {
            SET("salt = #{salt,jdbcType=VARCHAR}");
        }
        
        if (record.getTokenExptime() != null) {
            SET("token_exptime = #{tokenExptime,jdbcType=TIMESTAMP}");
        }
        
        WHERE("user_id = #{userId,jdbcType=VARCHAR}");
        
        return SQL();
    }
}