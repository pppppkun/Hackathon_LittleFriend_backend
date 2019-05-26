
public interface UserService {
    //查验登录
    public String checkLogin(User user);
    //注册用户
    public String register(User user);
    //查找用户
    public User findUser(String username);
}