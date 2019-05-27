import java.util.List;
import java.util.Map;

public interface UserDao {
    //找到所有元素,用来验证登录信息
    public  List<User> findAll();
    //插入元素,用来注册
    public void insertElement(User people);
    // find id base username a special find method
    public Map<String, User> findUserBaseUsername();
}