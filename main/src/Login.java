import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.*;

public class Login {
    public JTextField Emailtxt, Passtxt, usertxt;

    JFrame frameR, frameL, frameA;
    String email, pass, user;

    public static void main(String[] args) {
        new Login();
    }

    void Admin(){
        JButton loginbtn = new JButton("Login");
        loginbtn.setFont(new Font("Arial", Font.PLAIN, 18));
        loginbtn.setForeground(new Color(106, 128, 160)); // Set text color
        loginbtn.setBackground(new Color(217, 217, 217)); // Set background color
        loginbtn.setFocusable(false);
        loginbtn.setBounds(25,200,150,50);

        JButton registraionbtn = new JButton("Register");
        registraionbtn.setFont(new Font("Arial", Font.PLAIN, 18));
        registraionbtn.setForeground(new Color(106, 128, 160)); // Set text color
        registraionbtn.setBackground(new Color(217, 217, 217)); // Set background color
        registraionbtn.setFocusable(false);
        registraionbtn.setBounds(25,310,150,50);



        JLabel log = new JLabel();
        log.setText("Admin Login");
        log.setFont(new Font("Arial", Font.BOLD, 28));
        log.setBounds(50,50,200,35);

        JLabel logEmail = new JLabel();
        logEmail.setText("Email: ");
        logEmail.setFont(new Font("Arial", Font.BOLD, 28));
        logEmail.setBounds(50,200,100,35);

        Emailtxt = new JTextField();
        Emailtxt.setBounds(200, 200,250,30);
        Emailtxt.setFont(new Font("Arial", Font.PLAIN, 18));
        Emailtxt.setForeground(Color.GRAY); // Set text color
        Emailtxt.setBackground(Color.white); // Set background color

        JLabel User = new JLabel();
        User.setText("User: ");
        User.setFont(new Font("Arial", Font.BOLD, 28));
        User.setBounds(50,250,100,35);

        usertxt = new JTextField();
        usertxt.setBounds(200, 250,250,30);
        usertxt.setFont(new Font("Arial", Font.PLAIN, 18));
        usertxt.setForeground(Color.GRAY); // Set text color
        usertxt.setBackground(Color.white); // Set background color

        JLabel logPass = new JLabel();
        logPass.setText("Password: ");
        logPass.setFont(new Font("Arial", Font.BOLD, 28));
        logPass.setBounds(50,300,200,35);

        Passtxt = new JTextField();
        Passtxt.setBounds(200, 300,250,30);
        Passtxt.setFont(new Font("Arial", Font.PLAIN, 18));
        Passtxt.setForeground(Color.GRAY); // Set text color
        Passtxt.setBackground(Color.white); // Set background color

        JButton Loginright= new JButton("Login");
        Loginright.setFont(new Font("Arial", Font.PLAIN, 18));
        Loginright.setForeground(new Color(217, 217, 217)); // Set text color
        Loginright.setBackground(new Color(105, 127, 159)); // Set background color
        Loginright.setFocusable(false);
        Loginright.setBounds(25,400,150,50);

        JButton adminLog = new JButton("Admin");
        adminLog.setFont(new Font("Arial", Font.PLAIN, 18));
        adminLog.setForeground(new Color(106, 128, 160)); // Set text color
        adminLog.setBackground(new Color(217, 217, 217)); // Set background color
        adminLog.setFocusable(false);
        adminLog.setBounds(25,90,150,50);

        JPanel login= new JPanel();
        login.setBounds(200,0,800,600);
        login.setBackground(new Color(217, 217, 217));
        login.setLayout(null);
        login.add(log);
        login.add(logEmail);
        login.add(User);
        login.add(usertxt);
        login.add(logPass);
        login.add(Emailtxt);
        login.add(Passtxt);
        login.add(Loginright);



        JPanel left = new JPanel();
        left.setBounds(0,0,200,600);
        left.setBackground(new Color(106,128,160));
        left.setLayout(null);
        left.add(loginbtn);
        left.add(registraionbtn);
        left.add(adminLog);





        frameA = new JFrame();
        frameA.setSize(1000, 600);
        frameA.setVisible(true);
        frameA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameA.setResizable(false);
        frameA.setLayout(null);
        frameA.add(left);
        frameA.add(login);



        registraionbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameA.dispose();
                registration();
            }
        });

        Loginright.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminverify();
            }
        });

        loginbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameA.dispose();
                new Login();
            }
        });
    }

    void adminverify(){
        email = Emailtxt.getText();
        pass = Passtxt.getText();
        user = usertxt.getText();

        if(!isValidEmail(email)){
            JOptionPane.showMessageDialog(null, "Please enter a valid Email.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(pass.length() < 8 || pass.length() > 14){
            JOptionPane.showMessageDialog(null, "Password should have Minimum 8 and Maximum 14 characters.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(user.equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter User name.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(admindata(email, pass, user)){
         //admin page
            new Admin();
            frameA.dispose();

        }
        else{
            JOptionPane.showMessageDialog(null, "Invalid password or username.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

    }

    boolean admindata(String e, String p, String u) {
        String url = "jdbc:mysql://localhost:3306/loanmanagement";
        String username = "root";
        String password = "";
        String query = "SELECT * FROM _Admin WHERE Email = ? AND `User` = ? AND Password = ?";

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // Establish the connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Prepare the SQL SELECT query with both email and password
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, e);  // Set email
            preparedStatement.setString(2, u);
            preparedStatement.setString(3, p);  // Set password

            // Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Check if a result is returned
            if (resultSet.next()) {
                // Both email and password are correct
                JOptionPane.showMessageDialog(null, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);

            } else {
                // Either email doesn't exist or password is incorrect
                //JOptionPane.showMessageDialog(null, "Invalid email or password", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            // Close the connection
            connection.close();
        }catch (Exception q){
            q.printStackTrace();
        }
        return true;
    }
    Login(){
        JButton loginbtn = new JButton("Login");
        loginbtn.setFont(new Font("Arial", Font.PLAIN, 18));
        loginbtn.setForeground(new Color(106, 128, 160)); // Set text color
        loginbtn.setBackground(new Color(217, 217, 217)); // Set background color
        loginbtn.setFocusable(false);
        loginbtn.setBounds(25,200,150,50);

        JButton registraionbtn = new JButton("Register");
        registraionbtn.setFont(new Font("Arial", Font.PLAIN, 18));
        registraionbtn.setForeground(new Color(106, 128, 160)); // Set text color
        registraionbtn.setBackground(new Color(217, 217, 217)); // Set background color
        registraionbtn.setFocusable(false);
        registraionbtn.setBounds(25,310,150,50);



        JLabel log = new JLabel();
        log.setText("Login");
        log.setFont(new Font("Arial", Font.BOLD, 28));
        log.setBounds(50,50,100,35);

        JLabel logEmail = new JLabel();
        logEmail.setText("Email: ");
        logEmail.setFont(new Font("Arial", Font.BOLD, 28));
        logEmail.setBounds(50,200,100,35);

         Emailtxt = new JTextField();
        Emailtxt.setBounds(200, 200,250,30);
        Emailtxt.setFont(new Font("Arial", Font.PLAIN, 18));
        Emailtxt.setForeground(Color.GRAY); // Set text color
        Emailtxt.setBackground(Color.white); // Set background color

        JLabel logPass = new JLabel();
        logPass.setText("Password: ");
        logPass.setFont(new Font("Arial", Font.BOLD, 28));
        logPass.setBounds(50,300,200,35);

        Passtxt = new JTextField();
        Passtxt.setBounds(200, 300,250,30);
        Passtxt.setFont(new Font("Arial", Font.PLAIN, 18));
        Passtxt.setForeground(Color.GRAY); // Set text color
        Passtxt.setBackground(Color.white); // Set background color

        JButton Loginright= new JButton("Login");
        Loginright.setFont(new Font("Arial", Font.PLAIN, 18));
        Loginright.setForeground(new Color(217, 217, 217)); // Set text color
        Loginright.setBackground(new Color(105, 127, 159)); // Set background color
        Loginright.setFocusable(false);
        Loginright.setBounds(25,400,150,50);

        JButton adminLog = new JButton("Admin");
        adminLog.setFont(new Font("Arial", Font.PLAIN, 18));
        adminLog.setForeground(new Color(106, 128, 160)); // Set text color
        adminLog.setBackground(new Color(217, 217, 217)); // Set background color
        adminLog.setFocusable(false);
        adminLog.setBounds(25,90,150,50);

        JPanel login= new JPanel();
        login.setBounds(200,0,800,600);
        login.setBackground(new Color(217, 217, 217));
        login.setLayout(null);
        login.add(log);
        login.add(logEmail);
        login.add(logPass);
        login.add(Emailtxt);
        login.add(Passtxt);
        login.add(Loginright);



        JPanel left = new JPanel();
        left.setBounds(0,0,200,600);
        left.setBackground(new Color(106,128,160));
        left.setLayout(null);
        left.add(loginbtn);
        left.add(registraionbtn);
        left.add(adminLog);





        frameL = new JFrame();
        frameL.setSize(1000, 600);
        frameL.setVisible(true);
        frameL.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameL.setResizable(false);
        frameL.setLayout(null);
        frameL.add(left);
        frameL.add(login);

        Loginright.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 verifyLogin();
            }
        });



        registraionbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameL.dispose();
                registration();
            }
        });

        adminLog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameL.dispose();
                Admin();
            }
        });


    }

    void regData(String e, String p){
        String url = "jdbc:mysql://localhost:3306/loanmanagement";
        String username = "root";
        String password = "";
        String query = "INSERT INTO Log_in (email, password)" +
                "VALUES (?, ?)";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, e);
            preparedStatement.setString(2, p);
            int rowsInserted = preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLIntegrityConstraintViolationException ex) {
            // Handle duplicate key (primary key violation)
            JOptionPane.showMessageDialog(null, "Email already registered", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;

        }
        catch (Exception f){

        }

    }

    boolean logdata(String e, String p) {
        String url = "jdbc:mysql://localhost:3306/loanmanagement";
        String username = "root";
        String password = "";
        String query = "SELECT * FROM Log_in WHERE email = ? AND password = ?";

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // Establish the connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Prepare the SQL SELECT query with both email and password
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, e);  // Set email
            preparedStatement.setString(2, p);  // Set password

            // Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Check if a result is returned
            if (resultSet.next()) {
                // Both email and password are correct
                JOptionPane.showMessageDialog(null, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);

            } else {
                // Either email doesn't exist or password is incorrect
                //JOptionPane.showMessageDialog(null, "Invalid email or password", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            // Close the connection
            connection.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();  // To help debug in case of any issues
        }
        return true;
    }
    void registration(){
        JButton loginbtn = new JButton("Login");
        loginbtn.setFont(new Font("Arial", Font.PLAIN, 18));
        loginbtn.setForeground(new Color(106, 128, 160)); // Set text color
        loginbtn.setBackground(new Color(217, 217, 217)); // Set background color
        loginbtn.setFocusable(false);
        loginbtn.setBounds(25,200,150,50);

        JButton registraionbtn = new JButton("Register");
        registraionbtn.setFont(new Font("Arial", Font.PLAIN, 18));
        registraionbtn.setForeground(new Color(106, 128, 160)); // Set text color
        registraionbtn.setBackground(new Color(217, 217, 217)); // Set background color
        registraionbtn.setFocusable(false);
        registraionbtn.setBounds(25,310,150,50);

        ;

        JLabel reg = new JLabel();
        reg.setText("Registration");
        reg.setFont(new Font("Arial", Font.BOLD, 28));
        reg.setBounds(50,50,300,35);

        JLabel regEmail = new JLabel();
        regEmail.setText("Email: ");
        regEmail.setFont(new Font("Arial", Font.BOLD, 28));
        regEmail.setBounds(50,200,100,35);

        Emailtxt = new JTextField();
        Emailtxt.setBounds(200, 200,250,30);
        Emailtxt.setFont(new Font("Arial", Font.PLAIN, 18));
        Emailtxt.setForeground(Color.GRAY); // Set text color
        Emailtxt.setBackground(Color.white); // Set background color

        JLabel logPass = new JLabel();
        logPass.setText("Password: ");
        logPass.setFont(new Font("Arial", Font.BOLD, 28));
        logPass.setBounds(50,300,200,35);

        Passtxt = new JTextField();
        Passtxt.setBounds(200, 300,250,30);
        Passtxt.setFont(new Font("Arial", Font.PLAIN, 18));
        Passtxt.setForeground(Color.GRAY); // Set text color
        Passtxt.setBackground(Color.white); // Set background color

        JButton regright= new JButton("Register");
        regright.setFont(new Font("Arial", Font.PLAIN, 18));
        regright.setForeground(new Color(217, 217, 217)); // Set text color
        regright.setBackground(new Color(105, 127, 159)); // Set background color
        regright.setFocusable(false);
        regright.setBounds(25,400,150,50);

        JButton adminLog = new JButton("Admin");
        adminLog.setFont(new Font("Arial", Font.PLAIN, 18));
        adminLog.setForeground(new Color(106, 128, 160)); // Set text color
        adminLog.setBackground(new Color(217, 217, 217)); // Set background color
        adminLog.setFocusable(false);
        adminLog.setBounds(25,90,150,50);

        JPanel login= new JPanel();
        login.setBounds(200,0,800,600);
        login.setBackground(new Color(217, 217, 217));
        login.setLayout(null);
        login.add(reg);
        login.add(regEmail);
        login.add(logPass);
        login.add(Emailtxt);
        login.add(Passtxt);
        login.add(regright);



        JPanel left = new JPanel();
        left.setBounds(0,0,200,600);
        left.setBackground(new Color(106,128,160));
        left.setLayout(null);
        left.add(loginbtn);
        left.add(registraionbtn);
        left.add(adminLog);



        frameR = new JFrame();
        frameR.setSize(1000, 600);
        frameR.setVisible(true);
        frameR.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameR.setResizable(false);
        frameR.setLayout(null);
        frameR.add(left);
        frameR.add(login);

        regright.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regverify();
            }
        });

        loginbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameR.dispose();
                new Login();
            }
        });

        adminLog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameR.dispose();
                Admin();
            }
        });

    }
    void regverify(){
        email = Emailtxt.getText();
        pass = Passtxt.getText();

        if(!isValidEmail(email)){
            JOptionPane.showMessageDialog(null, "Please enter a valid Email.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(pass.length() < 8 || pass.length() > 14){
            JOptionPane.showMessageDialog(null, "Password should have Minimum 8 and Maximum 14 characters.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        regData(email, pass);
        new Login();
        frameR.dispose();
    }
    void verifyLogin(){
        email = Emailtxt.getText();
        pass  = Passtxt.getText();

        if(!isValidEmail(email)){
            JOptionPane.showMessageDialog(null, "Please enter a valid Email.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(pass.length() < 8 || pass.length() > 14){
            JOptionPane.showMessageDialog(null, "Password should have Minimum 8 and Maximum 14 characters.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(logdata(email, pass)){
            new HomePage(email);
            frameL.dispose();
        }
        else {
            JOptionPane.showMessageDialog(null, "Invalid email or password", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }



    }

    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}