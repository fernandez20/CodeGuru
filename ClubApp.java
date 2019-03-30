import java.util.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.imageio.ImageIO;


public class ClubApp {
  public static void main(String[] args) {
    Scanner console = new Scanner(System.in);
    
    System.out.print("Are you logging in as a member [1] or admin [2]?");
    int userType = console.nextInt();
    
    switch (userType) {
      case 1:
        System.out.println("Announcements:");
        Announcement.display();
        break;
        
      case 2:
        boolean logged = false;
        Admin log;
        System.out.print("Enter your OSIS.");
        int id = console.nextInt();
        System.out.print("Enter your password.");
        String password = console.nextLine();
      for (Admin a : Admin.adminList) {
        if (a.getID() == id) {
          if (password == a.getPass()) {
            logged = true;
            log = a;
          } else {
            System.out.println("Incorrect password.");
            break;
          }
        }
      }
      while (logged) {
        System.out.print("1: Make an announcement\n2:Send club email\n3:Start attendance\n4:Club info\n5:New member/admin\n");
        int choice = console.nextInt();
        switch (choice) {
          case 1: 
            System.out.print("What should the annoucement say?");
            String msg = console.nextLine();
            Date today = new Date();
            Announcement notice = new Announcement(today.toString(), msg, log);
            System.out.println("Announcement created.");
            break;
          case 2:
            Emailer sender = new Emailer();
            sender.email(Member.memberList);
            System.out.print("Email sent.");
            break;
          case 3:
            boolean finished = false;
            ArrayList<Member> rec = new ArrayList<Member>();
            while (!finished) {
              System.out.print("Enter name, OSIS, and email of present member. Enter \"DONE\" when finished.");
              String input = console.nextLine();
              if (input.equals("DONE")) {
                finished = true;
              }
              String n = input.substring(0, input.indexOf(","));
              input = input.substring(input.indexOf(","));
              int o = Integer.parseInt(input.substring(0, input.indexOf(",")));
              String e = input.substring(input.indexOf(",") + 1);
              Member added = new Member(n, o, e);
              rec.add(added);
              Attendance currentWeek = new Attendance(rec);
            }
            break;
          case 4:
            System.out.println("Admins:");
            for (int i = 0; i < Admin.adminList.size(); i++) {
              System.out.println(Admin.adminList.get(i).getName() + "\t\t" + Admin.adminList.get(i).getID());
            }
            System.out.println("Members:");
            for (int i = 0; i < Member.memberList.size(); i++) {
              System.out.println(Member.memberList.get(i).getName() + "\t\t" + Member.memberList.get(i).getID());
            }
            break;
          case 5:
            System.out.print("New member or admin?");
            String choose = console.next();
            if (choose.equals("member")) {
              System.out.print("Enter name, OSIS, and email of member.");
              String input = console.nextLine();
              String n = input.substring(0, input.indexOf(","));
              input = input.substring(input.indexOf(","));
              int o = Integer.parseInt(input.substring(0, input.indexOf(",")));
              String e = input.substring(input.indexOf(",") + 1);
              new Member(n, o, e);
            } else if (choose.equals("admin")) {
              System.out.print("Enter name, OSIS, and email of admin.");
              String input = console.nextLine();
              String n = input.substring(0, input.indexOf(","));
              input = input.substring(input.indexOf(","));
              int o = Integer.parseInt(input.substring(0, input.indexOf(",")));
              String e = input.substring(input.indexOf(",") + 1);
              System.out.print("Enter a password.");
              String p = console.nextLine();
              new Admin(n, o, e, p);
            }
          default:
            System.exit(0);
        }
      }
    }
    console.close();
  }
}