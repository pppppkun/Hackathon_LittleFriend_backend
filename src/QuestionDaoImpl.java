import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionDaoImpl implements QuestionDao {

    Connection connection=null;
    PreparedStatement ps=null;
    ResultSet rs=null;

    /**
     * dao层，从数据库里面取出数据
     */
    @Override
    public List<Question> findAll() {
        List<Question> list=null;
        try {
            //通过工具类获得连接
            connection = JDBCUtils.getConnetion();
            //通过连接对象获取操作数据库的对象
            String sql="SELECT * FROM question;";//查询sql语句
            ps=connection.prepareStatement(sql);
            //返回查询结果集
            rs=ps.executeQuery();
            //遍历rs，并封装数据
            list=new ArrayList<Question>();
            while(rs.next()) {
                Question question=new Question(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getBoolean(8));
                question.setID(rs.getInt(1));
                list.add(question);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            JDBCUtils.close(connection, ps, rs);//关闭连接

        }
        return list;
    }

    public Map<Integer , Question> findBaseId(){
        Map<Integer , Question> map = new HashMap<>();
        try {
            //通过工具类获得连接
            connection = JDBCUtils.getConnetion();
            //通过连接对象获取操作数据库的对象
            String sql="SELECT * FROM question;";//查询sql语句
            ps=connection.prepareStatement(sql);
            //返回查询结果集
            rs=ps.executeQuery();
            //遍历rs，并封装数据
            while(rs.next()) {
                Question question=new Question(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getBoolean(8));
                question.setID(rs.getInt(1));
                map.put(question.getID(),question);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            JDBCUtils.close(connection, ps, rs);//关闭连接
        }
        return map;
    }

    public Map<String , Question> findBaseTitle(){
        Map<String , Question> map = new HashMap<>();
        try {
            //通过工具类获得连接
            connection = JDBCUtils.getConnetion();
            //通过连接对象获取操作数据库的对象
            String sql="SELECT * FROM question;";//查询sql语句
            ps=connection.prepareStatement(sql);
            //返回查询结果集
            rs=ps.executeQuery();
            //遍历rs，并封装数据
            while(rs.next()) {
                Question question=new Question(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getBoolean(8));
                question.setID(rs.getInt(1));
                map.put(question.getTitle(),question);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            JDBCUtils.close(connection, ps, rs);//关闭连接
        }
        return map;
    }

    @Override
    public void insertElement(Question question) {
        try {
            connection=JDBCUtils.getConnetion();
            String sql="INSERT INTO question(tag_ONE,tag_TWO,tag_THREE,Title,description, whoasked , hassolved) VALUES(?,?,?,?,?,?,?);";//插入语句
            ps=connection.prepareStatement(sql);
            ps.setString(1,question.getTag_ONE());//使用prepareStatement可以防止sql注入
            ps.setString(2,question.getTag_TWO());
            ps.setString(3,question.getTag_THREE());
            ps.setString(4,question.getTitle());
            ps.setString(5,question.getDescription());
            ps.setString(6,question.getWhoasked());
            ps.setBoolean(7,false);
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
