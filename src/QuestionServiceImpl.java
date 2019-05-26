import java.util.List;

public class QuestionServiceImpl implements QuestionService {

    private QuestionDaoImpl dao = new QuestionDaoImpl();

    @Override
    public String checkrepeat(Question question) {
        List<Question> list = dao.findAll();

        for(Question q : list){
            if(question.getTitle()==q.getTitle()) return "提问失败，已经存在相同问题";
        }

        return "提问成功";

    }
}
