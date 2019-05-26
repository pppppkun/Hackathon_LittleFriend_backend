import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class QuestionServiceImpl implements QuestionService {

    private QuestionDaoImpl dao = new QuestionDaoImpl();

    @Override
    public String register(Question question) {
        List<Question> list = dao.findAll();

        for (Question q : list) {
            if(q.equals(question)&&question.getTitle() == q.getTitle()) return "提问失败，已经存在相同问题";
        }
        dao.insertElement(question);
        return "提问成功";
    }

    @Override
    public ArrayList<Question> findQuestion(String[] tags, Boolean Intent) {
        List<Question> list = dao.findAll();
        ArrayList<Question> relist = new ArrayList<Question>();
        Question question = new Question(tags[0],tags[1],tags[2]);
        for (Question q : list){
            if(q.tagEqual(question)&&q.isHassolved()==Intent) relist.add(q);
        }
        return relist;
    }

    @Override
    public String takeQuestion(int ID) {
        Map<String,Question> map = dao.findBaseId();
        Question question = map.get(Integer.toString(ID));
        StringBuilder a = new StringBuilder();
        a.append(question.getTag_ONE()+" "+question.getTag_TWO()+" "+question.getTag_THREE()+" "+question.getTitle()+" "+question.getDescription());
        return a.toString();
    }


    public Question takeQuestion(String title) {
        Map<String, Question> map = dao.findBaseTitle();
        Question question = map.get(title);
        return question;
    }



}
