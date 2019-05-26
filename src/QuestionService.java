import java.util.ArrayList;

public interface QuestionService {

    //注册题目
    public String register(Question question);
    //查找题目
    public ArrayList<Question> findQuestion(String[] tag , Boolean Intent);
    //搜索题目 baseid
    public String takeQuestion(int ID);
    //搜索题目 basetitle
    public Question takeQuestion(String title);
}
