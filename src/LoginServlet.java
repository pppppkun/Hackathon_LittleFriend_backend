import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String BM = "UTF-8";
    private static final UserService Uservice = new UserServiceImpl();
    private static final QuestionService Qservice = new QuestionServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding(BM);//解决请求乱码(post)
        response.setCharacterEncoding(BM);//解决响应乱码,下面要以字符流输出（若字节流输出则要再次编码）
        String sign = request.getParameter("sign");
        PrintWriter out = response.getWriter();
        //把传来的数据封装进javabean中
        switch (sign) {
            case "1":
                String loginInfo = userCheckLogin(request, response);
                out.print(loginInfo);
                break;
            case "2":
                String registerInfo = userRegister(request, response);
                out.print(registerInfo);
                break;
            case "3":
                String findquestionInfo = questionFind(request, response);
                out.print(findquestionInfo);
                break;
            case "4":
                String takeInfo = questiontake(request, response);
                out.print(takeInfo);
                break;
            case "5":
                String qRegisterInfo = questionRegister(request, response);
                out.print(qRegisterInfo);
            case "6":
            default:
                break;
        }
        //

//            System.out.println(username);//在控制台输出
//            System.out.println(password);
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
        Question question = new Question(tag_one, tag_two, tag_three, Title , description, askername);
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
        Answer answer1 = new Answer();
        answer1.setAnswer(answer);
        return null;
    }
}
