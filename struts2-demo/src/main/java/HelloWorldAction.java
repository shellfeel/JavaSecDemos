import com.opensymphony.xwork2.ActionSupport;

public class HelloWorldAction extends ActionSupport {



    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String execute(){

        return SUCCESS;
    }

}
