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
            //    private String Title;
            //    private String tag_ONE;
            //    private String tag_TWO;
            //    private String tag_THREE;
            while(rs.next()) {
                Question question=new Question();
                question.setTag_ONE(rs.getString(2));//索引从1开始，id参数不用取
                question.setTag_TWO(rs.getString(3));
                question.setTag_THREE(rs.getString(4));
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

    public Map<String , Question> findBaseId(){
        Map<String , Question> map = null;
        try {
            //通过工具类获得连接
            connection = JDBCUtils.getConnetion();
            //通过连接对象获取操作数据库的对象
            String sql="SELECT * FROM question;";//查询sql语句
            ps=connection.prepareStatement(sql);
            //返回查询结果集
            rs=ps.executeQuery();
            //遍历rs，并封装数据
            map = new HashMap<>();
            //    private String Title;
            //    private String tag_ONE;
            //    private String tag_TWO;
            //    private String tag_THREE;
            while(rs.next()) {
                Question question=new Question();
                question.setID(rs.getString(1));
                question.setTag_ONE(rs.getString(2));
                question.setTag_TWO(rs.getString(3));
                question.setTag_THREE(rs.getString(4));
                question.setTitle(rs.getString(5));
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
        Map<String , Question> map = null;
        try {
            //通过工具类获得连接
            connection = JDBCUtils.getConnetion();
            //通过连接对象获取操作数据库的对象
            String sql="SELECT * FROM question;";//查询sql语句
            ps=connection.prepareStatement(sql);
            //返回查询结果集
            rs=ps.executeQuery();
            //遍历rs，并封装数据
            map = new HashMap<>();
            //    private String Title;
            //    private String tag_ONE;
            //    private String tag_TWO;
            //    private String tag_THREE;
            while(rs.next()) {
                Question question=new Question();
                question.setID(rs.getString(1));
                question.setTag_ONE(rs.getString(2));
                question.setTag_TWO(rs.getString(3));
                question.setTag_THREE(rs.getString(4));
                question.setTitle(rs.getString(5));
                question.setDescription(rs.getString(6));
                question.setWhoasked(rs.getString(7));
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
            String sql="INSERT INTO user(tag_one,tag_two,tag_three,title,description,asker_name) VALUES(?,?,?,?,?,?);";//插入语句
            ps=connection.prepareStatement(sql);
            ps.setString(1,question.getTag_ONE());//使用prepareStatement可以防止sql注入
            ps.setString(2,question.getTag_TWO());
            ps.setString(3,question.getTag_THREE());
            ps.setString(4,question.getTitle());
            ps.setString(5,question.getDescription());
            ps.setString(6,question.getWhoasked());
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