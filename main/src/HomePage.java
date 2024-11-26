import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class HomePage {
    JFrame frame;
    JTable table;
    JScrollPane scrollPane;

    public static void main(String[] args) {
        new HomePage("xpay1200@gmail.com");
    }
     HomePage(String mail){
         String m = mail;
         JButton Carloan = new JButton("Carloan");
         Carloan.setBounds(10, 210, 180, 50);
         Carloan.setFont(new Font("Arial", Font.PLAIN, 18));
         Carloan.setForeground(new Color(106, 128, 160)); // Set text color
         Carloan.setBackground(new Color(217, 217, 217)); // Set background color
         Carloan.setFocusable(false);

         JButton HomeLoan = new JButton("Home Loan");
         HomeLoan.setBounds(10, 280, 180, 50);
         HomeLoan.setFont(new Font("Arial", Font.PLAIN, 18));
         HomeLoan.setForeground(new Color(106, 128, 160)); // Set text color
         HomeLoan.setBackground(new Color(217, 217, 217)); // Set background color
         HomeLoan.setFocusable(false);

         JButton SignOut = new JButton("Log-out");
         SignOut.setBounds(10, 350, 180, 50);
         SignOut.setFont(new Font("Arial", Font.PLAIN, 18));
         SignOut.setForeground(new Color(106, 128, 160)); // Set text color
         SignOut.setBackground(new Color(217, 217, 217)); // Set background color
         SignOut.setFocusable(false);



         JLabel email = new JLabel(mail);
         email.setFont(new Font("Arial", Font.PLAIN, 18));
         email.setForeground(new Color(106, 128, 160));
         email.setFont(new Font("JetBrains Mono", Font.BOLD, 14));
         email.setBounds(730, 460, 900, 150);




         JPanel left = new JPanel();
         left.setBounds(0,0,200,600);
         left.setBackground(new Color(106,128,160));
         left.setLayout(null);
         left.add(Carloan);
         left.add(HomeLoan);
          left.add(SignOut);

         JLabel wel = new JLabel();
         wel.setText("<html>Welcome to Loan Management System, <br> what for loan do you want to apply? </html>");
         wel.setFont(new Font("Arial", Font.PLAIN, 18));
         wel.setForeground(new Color(106, 128, 160));
         wel.setFont(new Font("JetBrains Mono", Font.BOLD, 24));
         wel.setBounds(400, 20, 900, 150);


         frame = new JFrame();
         frame.setSize(1000, 600);
         frame.setBackground(new Color(217,217,217));
         frame.setVisible(true);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setResizable(false);
         frame.setLayout(null);
         frame.add(left);
         frame.add(wel);
         frame.add(email);

         Carloan.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 new CarLoanpage1(m);
                 frame.dispose();
             }
         });
         HomeLoan.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 new HomeLoanPage1(m);
                 frame.dispose();
             }
         });
         SignOut.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 new Login();
                 frame.dispose();
             }
         });
     }
}
