import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarloanPage3 {
    String FirstName, LastName, MiddleName, dob, Phonenum, Email, JobT, Address, AccountNum, Account_Holder;
    int MonthlyIncome, Loan_Amt, Duration, Monthly_Debt, CreditScore;
    public String car_brand, car_model, car_type, car_price;
    public int car_priceInt;
    public JTextField carBrand, carModel, carPrice;

    public JComboBox<String> carTy  ;

    // String[] carT = {"NEW","USED"};
    public String[] carT = {"SEDAN", "SUV", "HATCHBACK", "HYBRID", "GOODS CARRIER", "TRANSPORT VEHICAL"};

    public boolean isSelect = false;
    public JCheckBox check;
    private JFrame frame;

    public double dtiR;



    CarloanPage3(String Fname, String L_name, String M_name, String Dob, String Phone, String mail, String Job, String Addrss, String AccNUM, String AccHolder, int MonInc, int Loan_amt, int duraation, int MonDebt, int CreaditSCR, double dti) {
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
        dtiR = dti;

        JLabel Borrow = new JLabel();
        Borrow.setForeground(new Color(217, 217, 217));
        Borrow.setText("Borrower's Details");
        Borrow.setVerticalAlignment(JLabel.CENTER);
        Borrow.setFont(new Font("JetBrains Mono", Font.BOLD, 28));
        Borrow.setHorizontalAlignment(JLabel.CENTER);

        JLabel car_Brand = new JLabel("Car Brand");
        car_Brand.setForeground(new Color(106, 128, 160));
        car_Brand.setFont(new Font("JetBrains Mono", Font.BOLD, 24));
        car_Brand.setBounds(20, 20, 150, 30); // Set x, y, width, height

        carBrand = new JTextField();
        carBrand.setBounds(220, 20, 200, 30); // Set x, y, width, height
        carBrand.setFont(new Font("Arial", Font.PLAIN, 18)); // Set font style and size
        carBrand.setForeground(Color.GRAY); // Set text color
        carBrand.setBackground(Color.white); // Set background color

        JLabel car_Model = new JLabel("Car Model");
        car_Model.setForeground(new Color(106, 128, 160));
        car_Model.setFont(new Font("JetBrains Mono", Font.BOLD, 24));
        car_Model.setBounds(20, 120, 150, 30); // Set x, y, width, height

        carModel = new JTextField();
        carModel.setBounds(220, 120, 200, 30); // Set x, y, width, height
        carModel.setFont(new Font("Arial", Font.PLAIN, 18));
        carModel.setForeground(Color.GRAY); // Set text color
        carModel.setBackground(Color.white); // Set background color

//        JLabel car_Type = new JLabel("Car Type");
//        car_Type.setForeground(new Color(106,128,160));
//        car_Type.setFont(new Font("JetBrains Mono", Font.BOLD, 24));
//        car_Type.setBounds(550, 20, 150, 30); // Set x, y, width, height
//
//        carType = new JTextField();
//        carType.setBounds(700, 20, 200, 30); // Set x, y, width, height
//        carType.setFont(new Font("Arial", Font.PLAIN, 18));
//        carType.setForeground(Color.GRAY); // Set text color
//        carType.setBackground(Color.white); // Set background color

        JLabel car_Condition = new JLabel("Car Type");
        car_Condition.setForeground(new Color(106, 128, 160));
        car_Condition.setFont(new Font("JetBrains Mono", Font.BOLD, 24));
        car_Condition.setBounds(530, 20, 200, 30); // Set x, y, width, height

//        carCondition = new JTextField();
//        carCondition.setBounds(700, 120, 200, 30); // Set x, y, width, height
//        carCondition.setFont(new Font("Arial", Font.PLAIN, 18));
//        carCondition.setForeground(Color.GRAY); // Set text color
//        carCondition.setBackground(Color.white); // Set background color

        carTy = new JComboBox<>(carT);
        carTy.setBounds(700, 20, 200, 30); // Set x, y, width, height
        carTy.setFont(new Font("Arial", Font.PLAIN, 18));
        carTy.setForeground(Color.GRAY); // Set text color
        carTy.setBackground(Color.white); // Set background color

        JLabel car_Price = new JLabel("Car Price");
        car_Price.setForeground(new Color(106, 128, 160));
        car_Price.setFont(new Font("JetBrains Mono", Font.BOLD, 24));
        car_Price.setBounds(530, 120, 200, 30);

        carPrice = new JTextField();
        carPrice.setBounds(700, 120, 200, 30);
        carPrice.setFont(new Font("Arial", Font.PLAIN, 18));
        carPrice.setForeground(Color.GRAY); // Set text color
        carPrice.setBackground(Color.white); // Set background color

        JLabel req = new JLabel();
        req.setText("Documents Required: Aadhar Card, Valid Passport, Voter's ID, Driving License.");
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


        JButton nextBtn = new JButton("Next");
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
        lowerMenuL.setLayout(null); // Use null layout for absolute positioning

        lowerMenuL.add(car_Brand);
        lowerMenuL.add(carBrand);
        lowerMenuL.add(car_Model);
        lowerMenuL.add(carModel);
        lowerMenuL.add(carTy);
        //lowerMenuL.add(carType);
        lowerMenuL.add(car_Condition);
        lowerMenuL.add(car_Price);
        lowerMenuL.add(carPrice);
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
        car_brand = carBrand.getText();
        car_model = carModel.getText();
        car_type = (String) carTy.getSelectedItem();
        car_price = carPrice.getText();

        if (car_brand.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter car brand!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (car_model.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter Car model!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (car_price.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter Car Price!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            try {
                car_priceInt = Integer.parseInt(car_price);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid numeric car price.", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
            }


        if(isSelect == false){
            JOptionPane.showMessageDialog(null, "Please check the documents if you have else you cannot apply for car loan.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        new applyForm(FirstName, LastName, MiddleName, dob, Phonenum, Email, JobT, Address, AccountNum, Account_Holder,MonthlyIncome, Loan_Amt, Duration, Monthly_Debt, CreditScore, car_brand, car_model, car_type, car_priceInt,dtiR);
        frame.dispose();
    }
}

