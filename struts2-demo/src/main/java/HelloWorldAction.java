import com.opensymphony.xwork2.ActionSupport;

public class HelloWorldAction extends ActionSupport {



    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String execute(){

        return ERROR;
    }

}
