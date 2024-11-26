import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeLoan3 {
    int square_feet,prc;
    public JTextField Home_Type, Squarefeet, Location, Price;
    String FirstName, LastName, MiddleName, dob, Phonenum, Email, JobT, Address, AccountNum, Account_Holder;
    int MonthlyIncome, Loan_Amt, Duration, Monthly_Debt, CreditScore;
    public String HouseType;
    public String home_Type, Square_feet, location, price;
    public JComboBox<String> HbTy;
    public String[] HbT = {"Flat", "Apartment", "Bungalow", "Villa", "Mansion"};
    public boolean isSelect = false;
    public JCheckBox check;
    private JFrame frame;


    public double dtiR;

//        public static void main(String[] args)
//    {
//        new HomeLoan3();
//    }


    HomeLoan3( String Fname, String L_name, String M_name, String Dob, String Phone, String mail, String Job, String Addrss, String AccNUM, String AccHolder, int MonInc, int Loan_amt, int duraation, int MonDebt, int CreaditSCR, double dt) {
        FirstName = Fname;
        LastName = L_name;
        MiddleName = M_name;
        dob = Dob;
        Phonenum = Phone;
        Email = mail;
        JobT = Job;
        Address = Addrss;
        AccountNum = AccNUM;
        Account_Holder = AccHolder;
        MonthlyIncome = MonInc;
        Loan_Amt = Loan_amt;
        Duration = duraation;
        Monthly_Debt = MonDebt;
        CreditScore = CreaditSCR;
        dtiR = dt;

        JLabel Borrow = new JLabel();
        Borrow.setForeground(new Color(217, 217, 217));
        Borrow.setText("House details");
        Borrow.setVerticalAlignment(JLabel.CENTER);
        Borrow.setFont(new Font("JetBrains Mono", Font.BOLD, 28));
        Borrow.setHorizontalAlignment(JLabel.CENTER);

        JLabel HomeType = new JLabel("Home Type");
        HomeType.setForeground(new Color(106, 128, 160));
        HomeType.setFont(new Font("JetBrains Mono", Font.BOLD, 24));
        HomeType.setBounds(20, 20, 150, 30);

        HbTy = new JComboBox<>(HbT);
        HbTy.setBounds(220, 20, 200, 30); // Set x, y, width, height
        HbTy.setFont(new Font("Arial", Font.PLAIN, 18));
        HbTy.setForeground(Color.GRAY); // Set text color
        HbTy.setBackground(Color.white); // Set background color

        JLabel square_feet = new JLabel("Square feet");
        square_feet.setForeground(new Color(106, 128, 160));
        square_feet.setFont(new Font("JetBrains Mono", Font.BOLD, 24));
        square_feet.setBounds(20, 120, 150, 30);

        Squarefeet = new JTextField();
        Squarefeet.setBounds(220, 120, 200, 30); // Set x, y, width, height
        Squarefeet.setFont(new Font("Arial", Font.PLAIN, 18)); // Set font style and size
        Squarefeet.setForeground(Color.GRAY); // Set text color
        Squarefeet.setBackground(Color.white); // Set background color

        JLabel Loc = new JLabel("Location");
        Loc.setForeground(new Color(106, 128, 160));
        Loc.setFont(new Font("JetBrains Mono", Font.BOLD, 24));
        Loc.setBounds(20, 230, 150, 30);

        Location = new JTextField();
        Location.setBounds(220, 230, 200, 30); // Set x, y, width, height
        Location.setFont(new Font("Arial", Font.PLAIN, 18)); // Set font style and size
        Location.setForeground(Color.GRAY); // Set text color
        Location.setBackground(Color.white); // Set background color

        JLabel price = new JLabel("Price");
        price.setForeground(new Color(106, 128, 160));
        price.setFont(new Font("JetBrains Mono", Font.BOLD, 24));
        price.setBounds(520, 20, 150, 30);

        Price = new JTextField();
        Price.setBounds(620, 20, 200, 30); // Set x, y, width, height
        Price.setFont(new Font("Arial", Font.PLAIN, 18)); // Set font style and size
        Price.setForeground(Color.GRAY); // Set text
        Price.setBackground(Color.white); // Set background color

        JLabel req = new JLabel();
        req.setText("Documents Required: Adhar Card, Valid Passport, Voter's ID, House agreement.");
        req.setFont(new Font("Arial", Font.PLAIN, 18));
        req.setForeground(new Color(255, 67, 67));
        req.setFont(new Font("JetBrains Mono", Font.BOLD, 24));
        req.setBounds(20, 300, 940, 30);

        check = new JCheckBox("I have these Documents.");
        check.setBounds(350, 380, 350, 30);
        check.setFont(new Font("JetBrains Mono", Font.BOLD, 24));
        check.setForeground(new Color(106, 128, 160));
        check.setBackground(new Color(217, 217, 217));
        check.setFocusable(false);

        JButton nextBtn = new JButton("Apply");
        nextBtn.setBounds(770, 410, 150, 30);
        nextBtn.setFont(new Font("Arial", Font.PLAIN, 18));
        nextBtn.setForeground(new Color(217, 217, 217)); // Set text color
        nextBtn.setBackground(new Color(106, 128, 160)); // Set background color
        nextBtn.setFocusable(false);

        JPanel upperMenu = new JPanel();
        upperMenu.setBounds(0, 0, 1000, 100);
        upperMenu.setBackground(new Color(106, 128, 160));
        upperMenu.setLayout(new BorderLayout());
        upperMenu.add(Borrow);

        JPanel lowerMenuL = new JPanel();
        lowerMenuL.setBounds(0, 100, 1000, 500);
        lowerMenuL.setBackground(new Color(217, 217, 217));
        lowerMenuL.setLayout(null);
        lowerMenuL.add(HomeType);
        lowerMenuL.add(HbTy);
        lowerMenuL.add(square_feet);
        lowerMenuL.add(Squarefeet);
        lowerMenuL.add(Loc);
        lowerMenuL.add(Location);
        lowerMenuL.add(price);
        lowerMenuL.add(Price);
        lowerMenuL.add(req);
        lowerMenuL.add(check);
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
                verify();
            }
        });

        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isSelect = check.isSelected();
            }
        });
    }

    void verify() {
        home_Type = (String) HbTy.getSelectedItem();
        Square_feet = Squarefeet.getText();
        location = Location.getText();
        price = Price.getText();

        if (Square_feet.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter square foot!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else
        {
            try
            {
                square_feet = Integer.parseInt(Square_feet);
            }
            catch (NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(null, "Please enter a valid numeric square feet.", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        if (location.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter location!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (price.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter the price of your home!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else
        {
            try
            {
                prc = Integer.parseInt(price);
            }
            catch (NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(null, "Please enter a valid numeric house price.", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        if(!isSelect){
            JOptionPane.showMessageDialog(null, "Please check the Documents, if don't have these document you cannot apply for Laon.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
       new ApplyHome(FirstName,LastName,MiddleName,dob,Phonenum,Email,JobT,Address,AccountNum,Account_Holder,MonthlyIncome,Loan_Amt,Duration,Monthly_Debt,CreditScore,home_Type,square_feet,location,prc,dtiR);
        frame.dispose();
    }
}



