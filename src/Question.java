import java.util.List;

public class Question {

    private String tag_ONE;
    private String tag_TWO;
    private String tag_THREE;
    private String ID;
    private String Title;
    private String description;
    private boolean hassolved;
    private String whoasked;


    public Question() {

    }

    public Question(String one, String two, String three, String title, String description,String us) {
        tag_ONE = one;
        tag_TWO = two;
        tag_THREE = three;
        this.Title = title;
        this.description = description;
        whoasked = us;
    }

    public Question(String one, String two, String three){
        tag_ONE = one;
        tag_TWO = two;
        tag_THREE = three;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public boolean tagEqual(Question q) {
        if (this.tag_ONE.equals(q.getTag_ONE()) && this.tag_TWO.equals(q.getTag_TWO()) && this.tag_THREE.equals(q.getTag_THREE())) {
            return true;
        } else return false;
    }

    public boolean isHassolved() {
        return hassolved;
    }

    public void setHassolved(boolean hassolved) {
        this.hassolved = hassolved;
    }

    public String getWhoasked() {
        return whoasked;
    }

    public void setWhoasked(String whoasked) {
        this.whoasked = whoasked;
    }
}
