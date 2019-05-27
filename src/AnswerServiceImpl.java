import java.util.List;

public class AnswerServiceImpl implements AnswerService{


    AnswerDao dao = new AnswerDaoImpl();
    //回答问题不用考虑是否重复 直接插入就行了
    @Override
    public String register(Answer answer) {
        //检查是否有任意一项的内容是空
        if(answer.getAnswer()!=null){
            dao.insertElement(answer);
            return "回答成功";
        }
        else return "回答失败";
    }
}
