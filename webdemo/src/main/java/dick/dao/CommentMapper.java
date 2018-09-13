package dick.dao;

import dick.entity.Comment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface CommentMapper {
    @Delete({
        "delete from table_comment",
        "where comment_id = #{commentId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String commentId);

    @Insert({
        "insert into table_comment (comment_id, user_id, ",
        "create_time, content)",
        "values (#{commentId,jdbcType=VARCHAR}, #{userId,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{content,jdbcType=LONGVARCHAR})"
    })
    int insert(Comment record);

    @InsertProvider(type=CommentSqlProvider.class, method="insertSelective")
    int insertSelective(Comment record);

    @Select({
        "select",
        "comment_id, user_id, create_time, content",
        "from table_comment",
        "where comment_id = #{commentId,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="comment_id", property="commentId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    Comment selectByPrimaryKey(String commentId);

    @UpdateProvider(type=CommentSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Comment record);

    @Update({
        "update table_comment",
        "set user_id = #{userId,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "content = #{content,jdbcType=LONGVARCHAR}",
        "where comment_id = #{commentId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKeyWithBLOBs(Comment record);

    @Update({
        "update table_comment",
        "set user_id = #{userId,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where comment_id = #{commentId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Comment record);
}