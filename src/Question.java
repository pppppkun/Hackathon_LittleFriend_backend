import java.util.List;

public class Question {

    private String tag_ONE;
    private String tag_TWO;
    private String tag_THREE;

    private String Title;
    private List<String> whoAnswer;

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
}
