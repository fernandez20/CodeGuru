import java.util.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.imageio.ImageIO;

public class GUI {
  public static void main(String[] args) {
    final JFrame window = new JFrame("ClubGuru");
    final JTextField user = new JTextField("OSIS");
    final JTextField pass = new JTextField("Password");
    boolean clicked = false;
    
    user.setForeground(new Color(128, 128, 128));
    pass.setForeground(new Color(128, 128, 128));
    
    user.setBounds(400, 325, 200, 30);
    pass.setBounds(400, 360, 200, 30);
    user.setFont(new Font("Century Gothic", Font.PLAIN, 14));
    pass.setFont(new Font("Century Gothic", Font.PLAIN, 14));
    
    final JButton login = new JButton("Log in");    
    login.setBounds(420, 400, 140, 60);
    //login.setContentAreaFilled(false);;
    login.setForeground(Color.WHITE);
    login.setFont(new Font("Century Gothic", Font.BOLD, 36));
    //login.setBorderPainted(false);
    
    try {
      BufferedImage image = ImageIO.read(new File("ClubguruLogo.jpg"));
      JLabel label = new JLabel(new ImageIcon(image));
      label.setBounds(240, 20, 504, 300);
      window.add(label);
    } catch (IOException ex) {
      
    }
    
    window.add(login); 
    window.add(user);
    window.add(pass);
    
    window.setSize(1000, 600);
    window.setLocation(183, 84);
    window.getContentPane().setBackground(new Color(242, 149, 45));
    window.setLayout(null);    
    window.setVisible(true);
    window.setResizable(false);
    
    login.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        window.remove(login);
        window.revalidate();
        window.repaint();
        clicked = true;
      }
    });
    
    String nameEntered = user.getText();
    String passEntered = pass.getText();
  }
}