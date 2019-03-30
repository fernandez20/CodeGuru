import java.util.ArrayList;

public class Announcement {
  private String date;
  private String body;
  private Admin author;
  private final String sep = "\n----------------------------------------------------------\n";
  private static ArrayList<Announcement> msgList = new ArrayList<Announcement>();
  
  public Announcement(String d, String b, Admin a) {
    date = d;
    body = b;
    author = a;
    msgList.add(this);
  }
  
  public static void display() {
    for (int i = msgList.size(); i >= 0; i--) {
      System.out.println(msgList.get(i).toString());
    }
  }
  
  public String toString() {
    String res =  "Posted on " + date + " by " +author.getName() + ".";
    res += "\n" + body + sep;
    return res;
  }
}
