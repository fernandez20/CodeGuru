import java.util.ArrayList;
public class Member {
  
  private String name;
  private int osis;
  private String email;
  public static ArrayList<Member> memberList = new ArrayList<Member>();
  
  public Member(String n, int o, String e){
    name = n;
    osis = o;
    email = e;
    memberList.add(this);
  }
  
  public String getName(){
    return name;
  }
  
  public String getEmail(){
    return email;
  }
  
  public int getID(){
    return osis;
  }
}