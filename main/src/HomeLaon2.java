import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



class HomeLoan2 {
    public JFrame frame;
    public JTextField BankName_Field, AccountNumber_Field, LoanAmount_Field, MonthlyDebt_Field,AccountHolder_Field, Duration_Field, CreaditCard_Field ;
    public JCheckBox creditCardCheckBox;
    public int LoanAmountInt, MonthlyDebtInt,CreaditScoreInt, DurationInt, Monthly_inc;
    public boolean isSelected;
    public double dti_ratio;
    final int MIN_CREDIT_SCORE = 200;
    final int MAX_CREDIT_SCORE = 850;

    public String AccountNumber,AccountHolder,LoanAmount,MonthlyDebt, Duration, CreaditScore, F_Name, M_name, L_name, DOB, Phone_no, E_mail,Job, Adress ;

    HomeLoan2(String Firstname,String middlename,String lastname,String dob ,String Phone_num, String Email,String JobTitle,String MonthlyIncome,String Address ){

        F_Name = Firstname;
        M_name = middlename;
        L_name = lastname;
        DOB = dob;
        Phone_no = Phone_num;
        E_mail = Email;
        Job = JobTitle;
        Monthly_inc = Integer.parseInt(MonthlyIncome);
        Adress = Address;




        JLabel Borrow = new JLabel();
        Borrow.setForeground(new Color(217,217,217));
        Borrow.setText("Borrower's Details");
        Borrow.setVerticalAlignment(JLabel.CENTER);
        Borrow.setFont(new Font("JetBrains Mono", Font.BOLD, 28));
        Borrow.setHorizontalAlignment(JLabel.CENTER);

        JLabel accountNum = new JLabel("<html>Account<br> Number<html>");
        accountNum.setForeground(new Color(106,128,160));
        accountNum.setFont(new Font("JetBrains Mono", Font.BOLD, 24));
        accountNum.setBounds(20, 20, 150, 60); // Set x, y, width, height

        AccountNumber_Field = new JTextField();
        AccountNumber_Field.setBounds(220, 20, 200, 30); // Set x, y, width, height
        AccountNumber_Field.setFont(new Font("Arial", Font.PLAIN, 18));
        AccountNumber_Field.setForeground(Color.GRAY); // Set text color
        AccountNumber_Field.setBackground(Color.white); // Set background color

        JLabel loanAmount = new JLabel("<html>Loan <br>Amount</html>");
        loanAmount.setForeground(new Color(106,128,160));
        loanAmount.setFont(new Font("JetBrains Mono", Font.BOLD, 24));
        loanAmount.setBounds(20, 120, 150, 55); // Set x, y, width, height

        LoanAmount_Field = new JTextField();
        LoanAmount_Field.setBounds(220, 120, 200, 30); // Set x, y, width, height
        LoanAmount_Field.setFont(new Font("Arial", Font.PLAIN, 18));
        LoanAmount_Field.setForeground(Color.GRAY); // Set text color
        LoanAmount_Field.setBackground(Color.white); // Set background color

        JLabel monthlydebt = new JLabel("<html>Monthly Debt <br> Payments</html>");
        monthlydebt.setForeground(new Color(106,128,160));
        monthlydebt.setFont(new Font("JetBrains Mono", Font.BOLD, 24));
        monthlydebt.setBounds(20, 220, 155, 60); // Set x, y, width, height

        MonthlyDebt_Field = new JTextField();
        MonthlyDebt_Field.setBounds(220, 220, 200, 30); // Set x, y, width, height
        MonthlyDebt_Field.setFont(new Font("Arial", Font.PLAIN, 18));
        MonthlyDebt_Field.setForeground(Color.GRAY); // Set text color
        MonthlyDebt_Field.setBackground(Color.white); // Set background color

        //Credit Card

        JLabel accountHolderName = new JLabel("<html>Account <br>Holder Name</html>");
        accountHolderName.setForeground(new Color(106,128,160));
        accountHolderName.setFont(new Font("JetBrains Mono", Font.BOLD, 24));
        accountHolderName.setBounds(520,20,200,55);

        AccountHolder_Field = new JTextField();
        AccountHolder_Field.setBounds(720, 20,200,30);
        AccountHolder_Field.setFont(new Font("Arial", Font.PLAIN, 18));
        AccountHolder_Field.setForeground(Color.GRAY); // Set text color
        AccountHolder_Field.setBackground(Color.white); // Set background color

        JLabel duration = new JLabel("Duration");
        duration.setForeground(new Color(106,128,160));
        duration.setFont(new Font("JetBrains Mono", Font.BOLD, 24));
        duration.setBounds(520,120,200,30);

        Duration_Field = new JTextField();
        Duration_Field.setText("(In Months)");
        Duration_Field.setBounds(720, 120,200,30);
        Duration_Field.setFont(new Font("Arial", Font.PLAIN, 18));
        Duration_Field.setForeground(Color.GRAY);
        Duration_Field.setBackground(Color.white);

        creditCardCheckBox = new JCheckBox("Do you have Credit Card?");
        creditCardCheckBox.setBounds(350, 320, 350, 30);
        creditCardCheckBox.setFont(new Font("JetBrains Mono", Font.BOLD, 24));
        creditCardCheckBox.setForeground(new Color(106, 128, 160));
        creditCardCheckBox.setBackground(new Color(217, 217, 217));
        creditCardCheckBox.setFocusable(false);


        JLabel creditCard = new JLabel("Credit Score");
        creditCard.setForeground(new Color(106,128,160));
        creditCard.setFont(new Font("JetBrains Mono", Font.BOLD, 24));
        creditCard.setBounds(520, 220, 200, 30);
        creditCard.setVisible(false);

        CreaditCard_Field = new JTextField();
        //CreaditCard_Field.setText("001");
        CreaditCard_Field.setBounds(720, 220, 200, 30);
        CreaditCard_Field.setFont(new Font("Arial", Font.PLAIN, 18));
        CreaditCard_Field.setForeground(Color.GRAY);
        CreaditCard_Field.setBackground(Color.white);
        CreaditCard_Field.setVisible(false);



        JButton Apply = new JButton("Apply");
        Apply.setBounds(770,410,150,30);
        Apply.setFont(new Font("Arial", Font.PLAIN, 18));
        Apply.setForeground(new Color(217,217,217));
        Apply.setBackground(new Color(106,128,160));
        Apply.setFocusable(false);



        JPanel upperMenu = new JPanel();
        upperMenu.setBounds(0, 0, 1000, 100);
        upperMenu.setBackground(new Color(106,128,160));
        upperMenu.setLayout(new BorderLayout());
        upperMenu.add(Borrow);

        JPanel lowerMenuL = new JPanel();
        lowerMenuL.setBounds(0, 100, 1000, 500);
        lowerMenuL.setBackground(new Color(217,217,217));
        lowerMenuL.setLayout(null); // Use null layout for absolute positioning

//        lowerMenuL.add(BankName);
//        lowerMenuL.add(BankName_Field);
        lowerMenuL.add(accountNum);
        lowerMenuL.add(AccountNumber_Field);
        lowerMenuL.add(loanAmount);
        lowerMenuL.add(LoanAmount_Field);
        lowerMenuL.add(monthlydebt);
        lowerMenuL.add(MonthlyDebt_Field);
        lowerMenuL.add(accountHolderName);
        lowerMenuL.add(AccountHolder_Field);
        lowerMenuL.add(duration);
        lowerMenuL.add(Duration_Field);
        lowerMenuL.add(creditCardCheckBox);
        lowerMenuL.add(creditCard);
        lowerMenuL.add(CreaditCard_Field);
        lowerMenuL.add(Apply);


        frame = new JFrame();
        frame.setSize(1000, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.add(upperMenu);
        frame.add(lowerMenuL);

        creditCardCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isSelected = creditCardCheckBox.isSelected();
                creditCard.setVisible(isSelected);
                CreaditCard_Field.setVisible(isSelected);
            }
        });

        Apply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoanRes();
            }
        });
    }



    void LoanRes(){
        // String Bank = BankName_Field.getText();
        AccountNumber = AccountNumber_Field.getText();
        AccountHolder = AccountHolder_Field.getText();
        LoanAmount = LoanAmount_Field.getText();
        MonthlyDebt = MonthlyDebt_Field.getText();
        Duration = Duration_Field.getText();
        boolean Check = isSelected;
        CreaditScore = CreaditCard_Field.getText();
        final int MAX_DURATION = 84;
        //Account number Validation
        if(AccountNumber.equals("")){
            JOptionPane.showMessageDialog(null, "Please enter Account Number!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else if (AccountNumber.length() != 11) {
            JOptionPane.showMessageDialog(null, "Account Number should be equal to 11 digits (numbers) and should not contain Characters ie. A-Z, a-z and also Symbols !", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;

        } else {
            for (int i = 0; i < AccountNumber.length(); i++) {
                if (!Character.isDigit(AccountNumber.charAt(i))) {
                    JOptionPane.showMessageDialog(null, "Please enter Valid Account Number.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        }
        //validation end
        //Account Holder Name validation
        if (AccountHolder.equals("")){
            JOptionPane.showMessageDialog(null, "Please enter Account Holder Name!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //validation end
        //Loan Amount Validation
        if (LoanAmount.equals("")){
            JOptionPane.showMessageDialog(null, "Please enter Loan Amount!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else {
            for (int i = 0; i < LoanAmount.length(); i++) {
                if (!Character.isDigit(LoanAmount.charAt(i))) {
                    JOptionPane.showMessageDialog(null, "Please enter Valid Loan Amount.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            if(LoanAmount.length() >= 10){
                JOptionPane.showMessageDialog(null, "Please enter Valid Loan Amount.", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        LoanAmountInt  = Integer.parseInt(LoanAmount);
        //Validation ends
        //Monthly debt Validation
        if (MonthlyDebt.equals("")){
            JOptionPane.showMessageDialog(null, "Please enter Monthly Debt Payment.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else {
            for (int i = 0; i < MonthlyDebt.length(); i++) {
                if (!Character.isDigit(MonthlyDebt.charAt(i))) {
                    JOptionPane.showMessageDialog(null, "Please enter Valid Monthly Debt.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        }
        MonthlyDebtInt = Integer.parseInt(MonthlyDebt);
        //Validation Ends

        //Duration Validdation

        if (Duration.equals("")){
            JOptionPane.showMessageDialog(null, "Please enter Loan Duration!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
            for (int i = 0; i < Duration.length(); i++) {
                if (!Character.isDigit(Duration.charAt(i))) {
                    JOptionPane.showMessageDialog(null, "Please enter Valid Duration.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            if (Duration.length() > 2){
                JOptionPane.showMessageDialog(null, "Please enter Valid Duration.", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }

        }

        DurationInt = Integer.parseInt(Duration);

        if (Check == true){
            if(CreaditScore.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter Credit Score.", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                for (int i = 0; i < CreaditScore.length(); i++) {
                    if (!Character.isDigit(CreaditScore.charAt(i))) {
                        JOptionPane.showMessageDialog(null, "Please enter valid Credit Score.", "ERROR", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            }
            CreaditScoreInt = Integer.parseInt(CreaditScore);

            if (CreaditScoreInt < MIN_CREDIT_SCORE || CreaditScoreInt > MAX_CREDIT_SCORE) {
                JOptionPane.showMessageDialog(null, "Credit Score must be between 200 and 850.", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else {
            CreaditScoreInt = -1;
        }



            dti_ratio = dti_cal(MonthlyDebtInt,Monthly_inc);
            if(dti_ratio > 44.00){
                JOptionPane.showMessageDialog(null, "Your DTI Ratio is: "+Math.round(dti_ratio)+". it should be less than 44% to apply for a loan. ", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }

            new HomeLoan3( F_Name,  L_name,  M_name,  DOB,  Phone_no,  E_mail,  Job,  Adress,  AccountNumber,  AccountHolder, Monthly_inc, LoanAmountInt, DurationInt, MonthlyDebtInt, CreaditScoreInt,dti_ratio);
            frame.dispose();




    }

    double dti_cal(int monthly_d, int monI){
        double d;
        d= ((double) monthly_d/monI)*100;
        return d;
    }
}

