import java.util.ArrayList;
public class Admin extends Member {
  private String pass;
  public static ArrayList<Admin> adminList = new ArrayList<Admin>(); 
  
  public Admin(String n, int id, String e, String p) {
    super(n, id, e);
    pass = p;
    adminList.add(this);
  }
  
  public String getPass() {
    return pass;
  }
  
  public void changePass(String p) {
    pass = p;
  }
  
}