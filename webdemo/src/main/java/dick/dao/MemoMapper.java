package dick.dao;

import dick.entity.Memo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface MemoMapper {
    @Delete({
        "delete from table_memo",
        "where memo_id = #{memoId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String memoId);

    @Insert({
        "insert into table_memo (memo_id, edit_time, ",
        "send_time, user_id, ",
        "state, memo_content)",
        "values (#{memoId,jdbcType=VARCHAR}, #{editTime,jdbcType=TIMESTAMP}, ",
        "#{sendTime,jdbcType=TIMESTAMP}, #{userId,jdbcType=VARCHAR}, ",
        "#{state,jdbcType=INTEGER}, #{memoContent,jdbcType=VARCHAR})"
    })
    int insert(Memo record);

    @InsertProvider(type=MemoSqlProvider.class, method="insertSelective")
    int insertSelective(Memo record);

    @Select({
        "select",
        "memo_id, edit_time, send_time, user_id, state, memo_content",
        "from table_memo",
        "where memo_id = #{memoId,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="memo_id", property="memoId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="edit_time", property="editTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="send_time", property="sendTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="state", property="state", jdbcType=JdbcType.INTEGER),
        @Result(column="memo_content", property="memoContent", jdbcType=JdbcType.VARCHAR)
    })
    Memo selectByPrimaryKey(String memoId);

    @UpdateProvider(type=MemoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Memo record);

    @Update({
        "update table_memo",
        "set edit_time = #{editTime,jdbcType=TIMESTAMP},",
          "send_time = #{sendTime,jdbcType=TIMESTAMP},",
          "user_id = #{userId,jdbcType=VARCHAR},",
          "state = #{state,jdbcType=INTEGER},",
          "memo_content = #{memoContent,jdbcType=VARCHAR}",
        "where memo_id = #{memoId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Memo record);
}