import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CarLoanpage1 {

    public String F_name, midName, lastname, DOB, Phone_num, Email, JobTitle, MonthlyIncome, Address ;
    public JTextField firstName, middleName,lastName, dobField, address, Phone, mail, Job, monI;

    private JFrame frame;


    CarLoanpage1(String m){

        JLabel Borrow = new JLabel();
        Borrow.setForeground(new Color(217,217,217));
        Borrow.setText("Borrower's Details");
        Borrow.setVerticalAlignment(JLabel.CENTER);
        Borrow.setFont(new Font("JetBrains Mono", Font.BOLD, 28));
        Borrow.setHorizontalAlignment(JLabel.CENTER);

        JLabel fname = new JLabel("First name");
        fname.setForeground(new Color(106,128,160));
        fname.setFont(new Font("JetBrains Mono", Font.BOLD, 24));
        fname.setBounds(20, 20, 150, 30); // Set x, y, width, height

         firstName = new JTextField();
        firstName.setBounds(220, 20, 200, 30); // Set x, y, width, height
        firstName.setFont(new Font("Arial", Font.PLAIN, 18)); // Set font style and size
        firstName.setForeground(Color.GRAY); // Set text color
        firstName.setBackground(Color.white); // Set background color

        JLabel midname = new JLabel("Middle name");
        midname.setForeground(new Color(106,128,160));
        midname.setFont(new Font("JetBrains Mono", Font.BOLD, 24));
        midname.setBounds(20, 120, 150, 30); // Set x, y, width, height

         middleName = new JTextField();
        middleName.setBounds(220, 120, 200, 30); // Set x, y, width, height
        middleName.setFont(new Font("Arial", Font.PLAIN, 18));
        middleName.setForeground(Color.GRAY); // Set text color
        middleName.setBackground(Color.white); // Set background color

        JLabel lname = new JLabel("Last name");
        lname.setForeground(new Color(106,128,160));
        lname.setFont(new Font("JetBrains Mono", Font.BOLD, 24));
        lname.setBounds(20, 220, 150, 30); // Set x, y, width, height

         lastName = new JTextField();
        lastName.setBounds(220, 220, 200, 30); // Set x, y, width, height
        lastName.setFont(new Font("Arial", Font.PLAIN, 18));
        lastName.setForeground(Color.GRAY); // Set text color
        lastName.setBackground(Color.white); // Set background color

        JLabel dob = new JLabel("Date of Birth ");
        dob.setForeground(new Color(106,128,160));
        dob.setFont(new Font("JetBrains Mono", Font.BOLD, 24));
        dob.setBounds(20, 320, 150, 30); // Set x, y, width, height

         dobField = new JTextField();
         dobField.setText("YYYY-MM-DD");
        dobField.setBounds(220, 320, 200, 30); // Set x, y, width, height
        dobField.setFont(new Font("Arial", Font.PLAIN, 18));
        dobField.setForeground(Color.GRAY); // Set text color
        dobField.setBackground(Color.white); // Set background color

        JLabel adress  = new JLabel("Address");
        adress.setForeground(new Color(106,128,160));
        adress.setFont(new Font("JetBrains Mono", Font.BOLD, 24));
        adress.setBounds(20,410,200,30);

         address = new JTextField();
        address.setBounds(220,410,500,30);
        address.setFont(new Font("Arial", Font.PLAIN, 18));
        address.setForeground(Color.GRAY); // Set text color
        address.setBackground(Color.white); // Set background color

        JLabel Pnum = new JLabel("Phone Number");
        Pnum.setForeground(new Color(106,128,160));
        Pnum.setFont(new Font("JetBrains Mono", Font.BOLD, 24));
        Pnum.setBounds(520,20,200,30);

         Phone = new JTextField();
        Phone.setBounds(720, 20,200,30);
        Phone.setFont(new Font("Arial", Font.PLAIN, 18));
        Phone.setForeground(Color.GRAY); // Set text color
        Phone.setBackground(Color.white); // Set background color

        JLabel Email = new JLabel("Email: ");
        Email.setForeground(new Color(106,128,160));
        Email.setFont(new Font("JetBrains Mono", Font.BOLD, 24));
        Email.setBounds(520,120,200,30);

         mail = new JTextField(m);
        mail.setBounds(720, 120,200,30);
        mail.setFont(new Font("Arial", Font.PLAIN, 18));
        mail.setForeground(Color.GRAY); // Set text color
        mail.setBackground(Color.white); // Set background color
        mail.setEditable(false);

        JLabel JobT = new JLabel("Job Title");
        JobT.setForeground(new Color(106,128,160));
        JobT.setFont(new Font("JetBrains Mono", Font.BOLD, 24));
        JobT.setBounds(520,220,200,30);

         Job = new JTextField();
        Job.setBounds(720, 220,200,30);
        Job.setFont(new Font("Arial", Font.PLAIN, 18));
        Job.setForeground(Color.GRAY); // Set text color
        Job.setBackground(Color.white); // Set background color

        JLabel monIncome = new JLabel("Monthly Income");
        monIncome.setForeground(new Color(106,128,160));
        monIncome.setFont(new Font("JetBrains Mono", Font.BOLD, 24));
        monIncome.setBounds(520,320,200,30);

         monI = new JTextField();
        monI.setBounds(720, 320,200,30);
        monI.setFont(new Font("Arial", Font.PLAIN, 18));
        monI.setForeground(Color.GRAY); // Set text color
        monI.setBackground(Color.white); // Set background color

        JButton nextBtn = new JButton("Next");
        nextBtn.setBounds(770,410,150,30);
        nextBtn.setFont(new Font("Arial", Font.PLAIN, 18));
        nextBtn.setForeground(new Color(217,217,217)); // Set text color
        nextBtn.setBackground(new Color(106,128,160)); // Set background color
        nextBtn.setFocusable(false);





        JPanel upperMenu = new JPanel();
        upperMenu.setBounds(0, 0, 1000, 100);
        upperMenu.setBackground(new Color(106,128,160));
        upperMenu.setLayout(new BorderLayout());
        upperMenu.add(Borrow);

        JPanel lowerMenuL = new JPanel();
        lowerMenuL.setBounds(0, 100, 1000, 500);
        lowerMenuL.setBackground(new Color(217,217,217));
        lowerMenuL.setLayout(null); // Use null layout for absolute positioning

        lowerMenuL.add(fname);
        lowerMenuL.add(firstName);
        lowerMenuL.add(midname);
        lowerMenuL.add(middleName);
        lowerMenuL.add(lname);
        lowerMenuL.add(lastName);
        lowerMenuL.add(dob);
        lowerMenuL.add(dobField);
        lowerMenuL.add(adress);
        lowerMenuL.add(address);
        lowerMenuL.add(Pnum);
        lowerMenuL.add(Phone);
        lowerMenuL.add(Email);
        lowerMenuL.add(mail);
        lowerMenuL.add(JobT);
        lowerMenuL.add(Job);
        lowerMenuL.add(monIncome);
        lowerMenuL.add(monI);
        lowerMenuL.add(nextBtn);


         frame = new JFrame();
        frame.setSize(1000, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.add(upperMenu);
        frame.add(lowerMenuL);

        nextBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Next();
            }
        });
    }

    public void Next() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

         F_name = firstName.getText();
         midName = middleName.getText();
         lastname = lastName.getText();
         DOB = dobField.getText();
         Phone_num = Phone.getText();
         Email = mail.getText();
         JobTitle = Job.getText();
         MonthlyIncome = monI.getText();
         Address = address.getText();

        if (F_name.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter your First name.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return; // Stop further processing
        }

        if (midName.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter your Middle name.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (lastname.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter your Last name.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (DOB.equals("") || DOB.equals("YYYY-MM-DD")) {
            JOptionPane.showMessageDialog(null, "Please enter your date of birth.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            LocalDate birthdate = LocalDate.parse(DOB, formatter);
            int age = Period.between(birthdate, LocalDate.now()).getYears();

            if (age < 18 || age > 99) {
                JOptionPane.showMessageDialog(null, "Please enter a valid age (between 18 and 99)!", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (DateTimeException e) {
            JOptionPane.showMessageDialog(null, "Please enter the date in the correct format (YYYY-MM-DD)!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (Phone_num.equals("") || Phone_num.length() != 10) {
            JOptionPane.showMessageDialog(null, "Please enter a valid Phone number.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!isValidEmail(Email)) {
            JOptionPane.showMessageDialog(null, "Please enter a valid Email.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (JobTitle.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter your Job Title.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (MonthlyIncome.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter your Monthly Income.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
            int monI;
            try {
                 monI = Integer.parseInt(MonthlyIncome);

            }
            catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Please Enter Valid Income.", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (monI <= 0){
                JOptionPane.showMessageDialog(null, "Income cannot be zero.", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }

        }

        if (Address.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter your Address.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }


        new Carloanpage2(F_name, midName, lastname, DOB, Phone_num, Email, JobTitle, MonthlyIncome, Address);
        frame.dispose();
    }
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
