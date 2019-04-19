package go.core.dashboard;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class LoginInterface {
    public static void Login(){
        JFrame frame=new JFrame("Login");   
        JPanel p1=new JPanel();   
        JPanel cards=new JPanel(new CardLayout());   
        p1.add(new JTextField("Username",30));
        p1.add(new JTextField("Password",30));
        JButton buttomLogin = new JButton("Login");
        p1.add(buttomLogin);
        // Open Register Interface
        JButton buttomRegister = new JButton("Register");
        buttomRegister.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                Register();
            }
        });
        p1.add(buttomRegister);
        cards.add(p1,"card1");   
        CardLayout cl=(CardLayout)(cards.getLayout());
        cl.show(cards,"card1");   
        frame.add(cards);
        frame.setBounds(300,200,400,150);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void Register(){
        JFrame frame=new JFrame("Register"); 
        JPanel p1=new JPanel();   
        JPanel cards=new JPanel(new CardLayout());   
        p1.add(new JTextField("Username",30));
        p1.add(new JTextField("Password",30));
        p1.add(new JTextField("Repeat Password",30));
        p1.add(new JButton("Register"));
        cards.add(p1,"card1");   
        CardLayout cl=(CardLayout)(cards.getLayout());
        cl.show(cards,"card1");   
        frame.add(cards);
        frame.setBounds(300,200,400,180);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String args[]) {
        Login();
    }
}

