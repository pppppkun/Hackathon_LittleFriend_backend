import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class QuestionServiceImpl implements QuestionService {

    private QuestionDaoImpl dao = new QuestionDaoImpl();

    @Override
    public String register(Question question) {
        List<Question> list = dao.findAll();

        for (Question q : list) {
            if (question.getTitle() == q.getTitle()) return "提问失败，已经存在相同问题";
        }

        return "提问成功";
    }

    @Override
    public ArrayList<Question> findQuestion(String[] tags, Boolean Intent) {
        List<Question> list = dao.findAll();
        ArrayList<Question> relist = new ArrayList<Question>();
        Question question = new Question(tags[0],tags[1],tags[2],null);
        for (Question q : list){
            if(q.tagEqual(question)&&q.isHassolved()==Intent) relist.add(q);
        }
        return relist;
    }

    @Override
    public String taktQuestion(int ID) {
        Map<String,Question> map = dao.findBaseId();
        Question question = map.get(Integer.toString(ID));
        StringBuilder a = new StringBuilder();
        a.append(question.getTag_ONE()+" "+question.getTag_TWO()+" "+question.getTag_THREE()+" "+question.getTitle());
        return a.toString();
    }
}
