package Local;

public class User {
    private int id;
    private String usrName;
    private String usrEmail;
    private String usrPasswd;

    // Constructors
    public User(){
        id=0;
        usrEmail = "";
        usrName = "";
        usrPasswd = "";
    }
    public User(String name, String email, String passwd){
        id=0;
        usrEmail = name;
        usrName = email;
        usrPasswd = passwd;
    }

    public void clearObjectData(){
        id=0;
        usrEmail = "";
        usrName = "";
        usrPasswd = "";
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", usrName='" + usrName + '\'' +
                ", usrEmail='" + usrEmail + '\'' +
                ", usrPasswd='" + usrPasswd + '\'' +
                '}';
    }

    // Getters
    public int getId() {
        return id;
    }
    public String getUsrEmail() {
        return usrEmail;
    }
    public String getUsrName() {
        return usrName;
    }
    public String getUsrPasswd() {
        return usrPasswd;
    }
    // Setters

    public void setId(int id) {
        this.id = id;
    }
    public void setUsrEmail(String usrEmail) {
        this.usrEmail = usrEmail;
    }
    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }
    public void setUsrPasswd(String usrPasswd) {
        this.usrPasswd = usrPasswd;
    }
}
