import java.util.List;

public class Question {

    private String tag_ONE;
    private String tag_TWO;
    private String tag_THREE;
    private String ID;
    private boolean hassolved;
    private String Title;
    private List<User> whoAnswer;
    private List<Answer> answers;

    public Question(){

    }

    public Question(String one,String two,String three,String title){
         tag_ONE=one;
         tag_TWO=two;
         tag_THREE=three;
         this.Title = title;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }


    public String getTag_ONE() {
        return tag_ONE;
    }

    public String getTag_TWO() {
        return tag_TWO;
    }

    public String getTag_THREE() {
        return tag_THREE;
    }

    public void setTag_ONE(String tag_ONE) {
        this.tag_ONE = tag_ONE;
    }

    public void setTag_TWO(String tag_TWO) {
        this.tag_TWO = tag_TWO;
    }

    public void setTag_THREE(String tag_THREE) {
        this.tag_THREE = tag_THREE;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public boolean tagEqual(Question q){
        if(this.tag_ONE.equals(q.getTag_ONE())&&this.tag_TWO.equals(q.getTag_TWO())&&this.tag_THREE.equals(q.getTag_THREE())){
            return true;
        }
        else return false;
    }

    public boolean isHassolved() {
        return hassolved;
    }


}
