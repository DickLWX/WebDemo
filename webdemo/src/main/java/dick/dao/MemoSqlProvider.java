package dick.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import dick.entity.Memo;

public class MemoSqlProvider {

    public String insertSelective(Memo record) {
        BEGIN();
        INSERT_INTO("table_memo");
        
        if (record.getMemoId() != null) {
            VALUES("memo_id", "#{memoId,jdbcType=VARCHAR}");
        }
        
        if (record.getEditTime() != null) {
            VALUES("edit_time", "#{editTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSendTime() != null) {
            VALUES("send_time", "#{sendTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUserId() != null) {
            VALUES("user_id", "#{userId,jdbcType=VARCHAR}");
        }
        
        if (record.getState() != null) {
            VALUES("state", "#{state,jdbcType=INTEGER}");
        }
        
        if (record.getMemoContent() != null) {
            VALUES("memo_content", "#{memoContent,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(Memo record) {
        BEGIN();
        UPDATE("table_memo");
        
        if (record.getEditTime() != null) {
            SET("edit_time = #{editTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSendTime() != null) {
            SET("send_time = #{sendTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUserId() != null) {
            SET("user_id = #{userId,jdbcType=VARCHAR}");
        }
        
        if (record.getState() != null) {
            SET("state = #{state,jdbcType=INTEGER}");
        }
        
        if (record.getMemoContent() != null) {
            SET("memo_content = #{memoContent,jdbcType=VARCHAR}");
        }
        
        WHERE("memo_id = #{memoId,jdbcType=VARCHAR}");
        
        return SQL();
    }
}