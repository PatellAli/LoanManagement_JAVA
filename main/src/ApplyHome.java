import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
class ApplyHome extends HomeLoanDBS{
    public JLabel CDS;
    String FirstName, LastName, MiddleName, dob, Phonenum, Email, JobT, Address, AccountNum, Account_Holder, HouseTy, Location;
    double interestRate, overall_payment, dti_Ratio, Monthly_payment;
    int MonthlyIncome, Loan_Amt, Duration, Monthly_Debt, CreditScore, SqrFeet, Hprice  ;

    ApplyHome(String Fname, String L_name, String M_name, String Dob, String Phone, String mail, String Job, String Addrss, String AccNUM, String AccHolder, int MonInc, int Loan_amt, int duraation, int MonDebt, int CreaditSCR, String HTy, int SqrF, String Loc, int Hpr, double dti){
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
        Hprice = Hpr;
        Location = Loc;
        HouseTy = HTy;
        SqrFeet = SqrF;

        dti_Ratio = dti;
        interest_cal(dti_Ratio,CreditScore);
        Monthly_payment  = calculateMonthlyPayment(Loan_Amt, interestRate, Duration);

        overall_payment = Monthly_payment*Duration;
        Math.round(overall_payment);


        //End...........................................................................................................

        JLabel Details = new JLabel();
        Details.setBounds(450,-30,300,100);
        Details.setForeground(new Color(217,217,217));
        Details.setText("Details");
        Details.setVerticalAlignment(JLabel.CENTER);
        Details.setFont(new Font("JetBrains Mono", Font.BOLD, 28));
        Details.setHorizontalAlignment(JLabel.CENTER);

        //Fname.........................................................................................................
        JLabel fname = new JLabel();
        fname.setText("First Name : "+ FirstName);
        fname.setForeground(new Color(106,128,160));
        fname.setFont(new Font("JetBrains Mono", Font.BOLD, 20));
        fname.setBounds(20, 20, 150, 60);

//        JLabel fnametxt = new JLabel();
//        fnametxt.setText(FirstName);
//        fnametxt.setForeground(new Color(0, 0, 0));
//        fnametxt.setFont(new Font("JetBrains Mono", Font.BOLD, 20));
//        fnametxt.setBounds(150, 20, 150, 60);

        //Mname.........................................................................................................
        JLabel Mname = new JLabel();
        Mname.setText("Middle Name : "+MiddleName);
        Mname.setForeground(new Color(106,128,160));
        Mname.setFont(new Font("JetBrains Mono", Font.BOLD, 20));
        Mname.setBounds(20, 60, 150, 60);

//        JLabel Mnametxt = new JLabel();
//        Mnametxt.setText(MiddleName);
//        Mnametxt.setForeground(new Color(0, 0, 0));
//        Mnametxt.setFont(new Font("JetBrains Mono", Font.BOLD, 20));
//        Mnametxt.setBounds(170, 60, 150, 60);

        //Lname.........................................................................................................
        JLabel lname = new JLabel();
        lname.setText("Last Name : "+ LastName);
        lname.setForeground(new Color(106,128,160));
        lname.setFont(new Font("JetBrains Mono", Font.BOLD, 20));
        lname.setBounds(20, 100, 150, 60);

//        JLabel lnametxt = new JLabel();
//        lnametxt.setText(LastName);
//        lnametxt.setForeground(new Color(0, 0, 0));
//        lnametxt.setFont(new Font("JetBrains Mono", Font.BOLD, 20));
//        lnametxt.setBounds(150, 100, 150, 60);

        //DOB...........................................................................................................
        JLabel DOB  = new JLabel();
        DOB.setText("DOB : "+dob);
        DOB.setForeground(new Color(106,128,160));
        DOB.setFont(new Font("JetBrains Mono", Font.BOLD, 20));
        //DOB.setBounds(20, 140, 0, 0);

//        JLabel DOBtxt = new JLabel();
//        DOBtxt.setText(dob);
//        DOBtxt.setForeground(new Color(0, 0, 0));
//        DOBtxt.setFont(new Font("JetBrains Mono", Font.BOLD, 20));
//        DOBtxt.setBounds(100, 140, 150, 60);

        //PhoneNum......................................................................................................
        JLabel phonenum = new JLabel();
        phonenum.setText("Phone : "+Phonenum);
        phonenum.setForeground(new Color(106,128,160));
        phonenum.setFont(new Font("JetBrains Mono", Font.BOLD, 20));
        phonenum.setBounds(20, 180, 150, 60);

//        JLabel Phonenumtxt  = new JLabel();
//        Phonenumtxt.setText(Phonenum);
//        Phonenumtxt.setForeground(new Color(0, 0, 0));
//        Phonenumtxt.setFont(new Font("JetBrains Mono", Font.BOLD, 20));
//        Phonenumtxt.setBounds(120, 180, 150, 60);

        //Email.........................................................................................................
        JLabel email = new JLabel();
        email.setText("Email : "+Email);
        email.setForeground(new Color(106,128,160));
        email.setFont(new Font("JetBrains Mono", Font.BOLD, 20));
        email.setBounds(20, 220, 150, 60);

//        JLabel emailtxt = new JLabel();
//        emailtxt.setText(Email);
//        emailtxt.setForeground(new Color(0, 0, 0));
//        emailtxt.setFont(new Font("JetBrains Mono", Font.BOLD, 20));
//        emailtxt.setBounds(100, 220, 280, 60);

        //Job...........................................................................................................
        JLabel job = new JLabel();
        job.setText("Job : "+ JobT);
        job.setForeground(new Color(106,128,160));
        job.setFont(new Font("JetBrains Mono", Font.BOLD, 20));
        job.setBounds(20, 260, 150, 60);

//        JLabel jobtxt = new JLabel();
//        jobtxt.setText(JobT);
//        jobtxt.setForeground(new Color(0, 0, 0));
//        jobtxt.setFont(new Font("JetBrains Mono", Font.BOLD, 20));
//        jobtxt.setBounds(80, 260, 280, 60);
        //Address.......................................................................................................
//        JLabel addressLabel = new JLabel();
//        addressLabel.setText("Address : ");
//        addressLabel.setForeground(new Color(106,128,160));
//        addressLabel.setFont(new Font("JetBrains Mono", Font.BOLD, 20));
//        addressLabel.setBounds(20, 300, 150, 60);

        JTextArea addresstxt = new JTextArea();
        addresstxt.setText("Address: "+ Address);
        addresstxt.setForeground(new Color(106, 128, 160));
        addresstxt.setFont(new Font("JetBrains Mono", Font.BOLD, 20));
        addresstxt.setBounds(120, 400, 300, 150);
        addresstxt.setBackground(new Color(217,217,217)); // Set background color
        addresstxt.setLineWrap(true);  // Enable line wrapping
        addresstxt.setWrapStyleWord(true);  // Wrap at word boundaries
        addresstxt.setEditable(false);  // Make it behave like a label

        JLabel Accountnum = new JLabel();
        Accountnum.setText("Account No : "+ AccountNum);
        Accountnum.setForeground(new Color(106,128,160));
        Accountnum.setFont(new Font("JetBrains Mono", Font.BOLD, 20));
        Accountnum.setBounds(20, 20, 150, 60);

        JLabel AccH = new JLabel();
        AccH.setText("Account Holder : "+ Account_Holder);
        AccH.setForeground(new Color(106,128,160));
        AccH.setFont(new Font("JetBrains Mono", Font.BOLD, 20));
        AccH.setBounds(20, 20, 150, 60);

        JLabel MonI = new JLabel();
        MonI.setText("Monthly Income: "+ MonthlyIncome);
        MonI.setForeground(new Color(106,128,160));
        MonI.setFont(new Font("JetBrains Mono", Font.BOLD, 20));
        MonI.setBounds(20, 20, 150, 60);

        JLabel LoanAmT = new JLabel();
        LoanAmT.setText("Loan Amount : "+ Loan_Amt);
        LoanAmT.setForeground(new Color(106,128,160));
        LoanAmT.setFont(new Font("JetBrains Mono", Font.BOLD, 20));
        LoanAmT.setBounds(20, 20, 0, 0);

        JLabel duration = new JLabel();
        duration.setText("Duration : "+ Duration);
        duration.setForeground(new Color(106,128,160));
        duration.setFont(new Font("JetBrains Mono", Font.BOLD, 20));
        duration.setBounds(20, 20, 150, 60);

        JLabel MonD = new JLabel();
        MonD.setText("Monthly Debt: "+ Monthly_Debt);
        MonD.setForeground(new Color(106,128,160));
        MonD.setFont(new Font("JetBrains Mono", Font.BOLD, 20));
        MonD.setBounds(20, 20, 150, 60);

        CDS = new JLabel();
        CDS.setText("Creadit Score : "+ CreditScore);
        CDS.setForeground(new Color(106,128,160));
        CDS.setFont(new Font("JetBrains Mono", Font.BOLD, 20));
        CDS.setBounds(20, 20, 150, 60);
        CDS.setVisible(false);
        if(CreditScore != -1){
            CDS.setVisible(true);
        }

        JLabel Htype = new JLabel();
        Htype.setText("House Type : "+ HouseTy);
        Htype.setForeground(new Color(106,128,160));
        Htype.setFont(new Font("JetBrains Mono", Font.BOLD, 20));
        Htype.setBounds(20, 20, 150, 60);

        JLabel Hpri = new JLabel();
        Hpri.setText("House Price : "+ Hprice);
        Hpri.setForeground(new Color(106,128,160));
        Hpri.setFont(new Font("JetBrains Mono", Font.BOLD, 20));
        Hpri.setBounds(20, 20, 150, 60);



        JLabel Sqrf = new JLabel();
        Sqrf.setText("Square Feet : "+ SqrFeet);
        Sqrf.setForeground(new Color(106,128,160));
        Sqrf.setFont(new Font("JetBrains Mono", Font.BOLD, 20));
        Sqrf.setBounds(20, 20, 150, 60);

        JLabel interestR = new JLabel();
        interestR.setText("Interest Rate: "+ interestRate);
        interestR.setForeground(new Color(106,128,160));
        interestR.setFont(new Font("JetBrains Mono", Font.BOLD, 20));
        interestR.setBounds(20, 20, 150, 60);

        JLabel MonP = new JLabel();
        MonP.setText("Monthly Payment : "+ Math.round(Monthly_payment));
        MonP.setForeground(new Color(106,128,160));
        MonP.setFont(new Font("JetBrains Mono", Font.BOLD, 20));
        MonP.setBounds(20, 20, 150, 60);

        JLabel ovrP = new JLabel();
        ovrP.setText("Full Payment : "+ Math.round(overall_payment));
        ovrP.setForeground(new Color(106,128,160));
        ovrP.setFont(new Font("JetBrains Mono", Font.BOLD, 20));
        ovrP.setBounds(20, 20, 150, 60);

        JTextArea Loctxt = new JTextArea();
        Loctxt.setText("Location: "+ Location);
        Loctxt.setForeground(new Color(106, 128, 160));
        Loctxt.setFont(new Font("JetBrains Mono", Font.BOLD, 20));
        Loctxt.setBounds(120, 400, 300, 150);
        Loctxt.setBackground(new Color(217,217,217)); // Set background color
        Loctxt.setLineWrap(true);  // Enable line wrapping
        Loctxt.setWrapStyleWord(true);  // Wrap at word boundaries
        Loctxt.setEditable(false);  // Make it behave like a label

        JButton Applybtn = new JButton("Apply");
        Applybtn.setBounds(950, 0, 150, 50);
        Applybtn.setFont(new Font("Arial", Font.PLAIN, 18));
        Applybtn.setForeground(new Color(106, 128, 160)); // Set text color
        Applybtn.setBackground(new Color(217, 217, 217)); // Set background color
        Applybtn.setFocusable(false);



        JPanel upperMenu = new JPanel();
        upperMenu.setBounds(0, 0, 1300, 50);
        upperMenu.setBackground(new Color(106,128,160));
        upperMenu.setLayout(null);
        upperMenu.add(Details);
        upperMenu.add(Applybtn);

        JPanel lowerMenuL = new JPanel();
        lowerMenuL.setBounds(0, 50, 1300, 600);
        lowerMenuL.setBackground(new Color(217,217,217));
        lowerMenuL.setLayout(new GridLayout(7,3,5,0 ));

        lowerMenuL.add(fname);
        // lowerMenuL.add(fnametxt);
        lowerMenuL.add(lname);
        // lowerMenuL.add(lnametxt);
        lowerMenuL.add(Mname);
        //lowerMenuL.add(Mnametxt);
        lowerMenuL.add(DOB);
        //lowerMenuL.add(DOBtxt);
        lowerMenuL.add(phonenum);
        //lowerMenuL.add(Phonenumtxt);

        // lowerMenuL.add(emailtxt);
        lowerMenuL.add(job);
        // lowerMenuL.add(jobtxt);
        //lowerMenuL.add(addressLabel);
        lowerMenuL.add(addresstxt);
        lowerMenuL.add(Accountnum);
        lowerMenuL.add(AccH);
        lowerMenuL.add(MonI);
        lowerMenuL.add(LoanAmT);
        lowerMenuL.add(duration);
        lowerMenuL.add(MonD);

        lowerMenuL.add(Htype);
        lowerMenuL.add(Hpri);
        lowerMenuL.add(Sqrf);
        lowerMenuL.add(ovrP);
        lowerMenuL.add(interestR);
        lowerMenuL.add(MonP);
        lowerMenuL.add(email);
        lowerMenuL.add(Loctxt);
        lowerMenuL.add(CDS);

        lowerMenuL.add(Applybtn);



        JFrame frame = new JFrame();
        frame.setSize(1300,650);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(lowerMenuL);
        frame.add(upperMenu);

        Applybtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(JOptionPane.showConfirmDialog(null, "Do you want to apply for this loan?", "Comformation", JOptionPane.YES_NO_OPTION) == 0){

                    HomeJdbcinsert(FirstName, LastName, MiddleName,dob ,Phonenum, Email, JobT,  Address, AccountNum,  Account_Holder, MonthlyIncome, Loan_Amt, Duration, Monthly_Debt, CreditScore, HouseTy,  Hprice,  Location,  SqrFeet, interestRate, overall_payment, Monthly_payment);
                    JOptionPane.showConfirmDialog(null, "Loan Appield!", "Succesfull!", JOptionPane.PLAIN_MESSAGE);
                    new HomePage(Email);
                    frame.dispose();
                }
                else{
                    return;
                }
            }
        });

    }

    void interest_cal(double DTI, int creditScore){
        if(DTI <= 43 && DTI >= 36.40){
            interestRate = 10.50;
        } else if (DTI <= 36.39 && DTI >= 26.50) {
            interestRate = 10.00;
        } else if (DTI <= 26.49 && DTI >= 20.59) {
            interestRate = 9.60;
        } else if (DTI <= 20.58  && DTI >= 15.99) {
            interestRate = 9.00;
        } else if (DTI <= 15.98 && DTI >= 10.99) {
            interestRate  = 8.30;
        } else if (DTI <= 10.98 && DTI >= 5.00) {
            interestRate = 7.80;
        }
        else {
            interestRate = 7.00;
        }

        if(creditScore!=-1) {
            if (creditScore >= 300 && creditScore <= 400) {
                interestRate -= 0.5;
            } else if (creditScore >= 401 && creditScore <= 500) {
                interestRate -= 0.85;
            } else if (creditScore >= 501 && creditScore <= 600) {
                interestRate -= 1.00;
            } else if (creditScore >= 601 && creditScore <= 700) {
                interestRate -= 1.70;
            } else if (creditScore >= 701 && creditScore <= 800) {
                interestRate -= 2.20;
            } else {
                interestRate-=2.50;
            }
        }


    }

    double calculateMonthlyPayment(double loanAmount, double annualInterestRate, int loanTermInMonths) {
        double monthlyInterestRate = annualInterestRate / 12 / 100;  // Convert annual interest rate to a monthly rate
        if (monthlyInterestRate > 0) {
            return (loanAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, loanTermInMonths)) /
                    (Math.pow(1 + monthlyInterestRate, loanTermInMonths) - 1);
        } else {
            return loanAmount / loanTermInMonths;  // No interest case
        }
    }

}

//class Apply{
//    public static void main(String[] args) {
//         new applyForm("Ali", "Patel", "Kayyum", "2000-01-01", "1234567890", "mdalipatel150@gmail.com", "Lawyer", "Rosevilla dsfsdffkshgfkjshgdfkjsghdf", "12345678901", "Ali", 85000, 520000, 25, 34000, 500, "Honda", "city", "SUV", 2400000, 48);
//    }
//}

