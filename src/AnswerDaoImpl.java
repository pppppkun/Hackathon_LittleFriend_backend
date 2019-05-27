import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AnswerDaoImpl implements AnswerDao{

    Connection connection=null;
    PreparedStatement ps=null;
    ResultSet rs=null;

    public List<Answer> findAll() {
        List<Answer> list=null;
        try {
            //通过工具类获得连接
            connection = JDBCUtils.getConnetion();
            //通过连接对象获取操作数据库的对象
            String sql="SELECT * FROM question;";//查询sql语句
            ps=connection.prepareStatement(sql);
            //返回查询结果集
            rs=ps.executeQuery();
            //遍历rs，并封装数据
            list=new ArrayList<Answer>();

            while(rs.next()) {
                Answer answer = new Answer(rs.getString(2),rs.getString(3),rs.getString(4));
                list.add(answer);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            JDBCUtils.close(connection, ps, rs);//关闭连接

        }
        return list;
    }

    @Override
    public void insertElement(Answer answer) {
        try {
            connection=JDBCUtils.getConnetion();
            String sql="INSERT INTO answer(answer,questionid,answersid) VALUES(?,?,?);";//插入语句
            ps=connection.prepareStatement(sql);
            ps.setString(1,answer.getAnswer());//使用prepareStatement可以防止sql注入
            ps.setString(2,answer.getQuestionID());
            ps.setString(3,answer.getAnswersID());

            //执行更新语句
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            JDBCUtils.close(connection, ps, rs);
        }
    }
}
