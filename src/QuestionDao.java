import java.util.List;

public interface QuestionDao {

    //找到所有题目，避免重复题目出现
    public List<Question> findAll();
    //提问人提问的时候插入问题
    public void insertElement(Question question);

}
