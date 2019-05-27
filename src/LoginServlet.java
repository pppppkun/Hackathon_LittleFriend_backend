import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * Hackathon 2019
 *
 *
 *                        ::
 *                       :;J7, :,                        ::;7:
 *                       ,ivYi, ,                       ;LLLFS:
 *                       :iv7Yi                       :7ri;j5PL
 *                      ,:ivYLvr                    ,ivrrirrY2X,
 *                      :;r@Wwz.7r:                :ivu@kexianli.
 *                     :iL7::,:::iiirii:ii;::::,,irvF7rvvLujL7ur
 *                    ri::,:,::i:iiiiiii:i:irrv177JX7rYXqZEkvv17
 *                 ;i:, , ::::iirrririi:i:::iiir2XXvii;L8OGJr71i
 *               :,, ,,:   ,::ir@mingyi.irii:i:::j1jri7ZBOS7ivv,
 *                  ,::,    ::rv77iiiriii:iii:i::,rvLq@huhao.Li
 *              ,,      ,, ,:ir7ir::,:::i;ir:::i:i::rSGGYri712:
 *            :::  ,v7r:: ::rrv77:, ,, ,:i7rrii:::::, ir7ri7Lri
 *           ,     2OBBOi,iiir;r::        ,irriiii::,, ,iv7Luur:
 *         ,,     i78MBBi,:,:::,:,  :7FSL: ,iriii:::i::,,:rLqXv::
 *         :      iuMMP: :,:::,:ii;2GY7OBB0viiii:i:iii:i:::iJqL;::
 *        ,     ::::i   ,,,,, ::LuBBu BBBBBErii:i:i:i:i:i:i:r77ii
 *       ,       :       , ,,:::rruBZ1MBBqi, :,,,:::,::::::iiriri:
 *      ,               ,,,,::::i:  @arqiao.       ,:,, ,:::ii;i7:
 *     :,       rjujLYLi   ,,:::::,:::::::::,,   ,:i,:,,,,,::i:iii
 *     ::      BBBBBBBBB0,    ,,::: , ,:::::: ,      ,,,, ,,:::::::
 *     i,  ,  ,8BMMBBBBBBi     ,,:,,     ,,, , ,   , , , :,::ii::i::
 *     :      iZMOMOMBBM2::::::::::,,,,     ,,,,,,:,,,::::i:irr:i:::,
 *     i   ,,:;u0MBMOG1L:::i::::::  ,,,::,   ,,, ::::::i:i:iirii:i:i:
 *     :    ,iuUuuXUkFu7i:iii:i:::, :,:,: ::::::::i:i:::::iirr7iiri::
 *     :     :rk@Yizero.i:::::, ,:ii:::::::i:::::i::,::::iirrriiiri::,
 *      :      5BMBBBBBBSr:,::rv2kuii:::iii::,:i:,, , ,,:,:i@petermu.,
 *           , :r50EZ8MBBBBGOBBBZP7::::i::,:::::,: :,:,::i;rrririiii::
 *               :jujYY7LS0ujJL7r::,::i::,::::::::::::::iirirrrrrrr:ii:
 *            ,:  :@kevensun.:,:,,,::::i:i:::::,,::::::iir;ii;7v77;ii;i,
 *            ,,,     ,,:,::::::i:iiiii:i::::,, ::::iiiir@xingjief.r;7:i,
 *         , , ,,,:,,::::::::iiiiiiiiii:,:,:::::::::iiir;ri7vL77rrirri::
 *          :,, , ::::::::i:::i:::i:i::,,,,,:,::i:i:::iir;@Secbone.ii:::
 *
 *
 * 狗头保命
 * @author P君
 *
 */

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String BM = "UTF-8";
    private static final UserService Uservice = new UserServiceImpl();
    private static final QuestionService Qservice = new QuestionServiceImpl();
    private static final AnswerService Aservice = new AnswerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding(BM);//解决请求乱码(post)
        response.setCharacterEncoding(BM);//解决响应乱码,下面要以字符流输出（若字节流输出则要再次编码）
        String sign = request.getParameter("sign");
        PrintWriter out = response.getWriter();
        //把传来的数据封装进javabean中
        switch (sign) {
            case "1":
                //登录操作
                String loginInfo = userCheckLogin(request, response);
                out.print(loginInfo);
                break;
            case "2":
                //注册操作
                String registerInfo = userRegister(request, response);
                out.print(registerInfo);
                break;
            case "3":
                //客户端传过来三个tag和一个intent表明需要类问题，是否被回答，服务端返回一个问题
                String findquestionInfo = questionFind(request, response);
                out.print(findquestionInfo);
                break;
            case "4":
                //根据题目的ID，直接返回一个题目
                String takeInfo = questiontake(request, response);
                out.print(takeInfo);
                break;
            case "5":
                //注册一个题目，对方提供3个tag title description username
                String qRegisterInfo = questionRegister(request, response);
                out.print(qRegisterInfo);
            case "6":
                //注册一个回答，对方提供回答内容，题目title，回答者的username
                String aRegisterInfo = answerQuestion(request, response);
                out.print(aRegisterInfo);
                break;
            default:
                break;
        }
        System.out.println(sign);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    //注册操作
    protected String userCheckLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding(BM);//解决请求乱码(post)
        response.setCharacterEncoding(BM);//解决响应乱码,下面要以字符流输出（若字节流输出则要再次编码）
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String school = request.getParameter("school");
        String major = request.getParameter("major");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setSchool(school);
        user.setMajor(major);
        UserService service = new UserServiceImpl();
        return service.checkLogin(user);
    }

    protected String userRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding(BM);
        response.setCharacterEncoding(BM);
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return Uservice.register(user);
    }

    //tag_one,tag_two,tag_three,title
    protected String questionRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding(BM);
        response.setCharacterEncoding(BM);
        UserDao dao = new UserDaoImpl();
        String tag_one = request.getParameter("tag_one");
        String tag_two = request.getParameter("tag_two");
        String tag_three = request.getParameter("tag_three");
        String Title = request.getParameter("title");
        String description = request.getParameter("Description");
        String askername = request.getParameter("username");
        Question question = new Question(tag_one, tag_two, tag_three, Title , description, askername , false);
        return Qservice.register(question);
    }

    protected String questionFind(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding(BM);
        response.setCharacterEncoding(BM);
        String[] tags = new String[3];
        tags[0] = request.getParameter("tag_one");
        tags[1] = request.getParameter("tag_two");
        tags[2] = request.getParameter("tag_three");
        String intent = request.getParameter("Intent");
        StringBuilder p = new StringBuilder();
        for(Question q : Qservice.findQuestion(tags, Boolean.valueOf(intent))){
            p.append(q.getTitle()+"\n");
        }
        return p.toString();
    }

    protected String questiontake(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding(BM);
        response.setCharacterEncoding(BM);
        int ID = Integer.valueOf(request.getParameter("ID"));
        return Qservice.takeQuestion(ID);
    }

    protected String answerQuestion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding(BM);
        response.setCharacterEncoding(BM);
        String username = request.getParameter("username");
        String title = request.getParameter("title");
        String answer = request.getParameter("answer");
        Question question = Qservice.takeQuestion(title);
        User user = Uservice.findUser(username);
        Answer answer1 = new Answer(answer,question.getID(),user.getId());
        return Aservice.register(answer1);
    }
}
