import javax.swing.*;
import java.sql.*;
public class HomeLoanDBS {

    void HomeJdbcinsert(String Fname, String L_name, String M_name, String Dob, String Phone, String mail, String Job, String Addrss, String AccNUM, String AccHolder, int MonInc, int Loan_amt, int duraation, int MonDebt, int CreaditSCR, String HT, int HP, String Loc, int Sqr, double interestrate, double overAll_payment, double Monthly_paymennt) {
        String url = "jdbc:mysql://localhost:3306/loanmanagement";
        String username = "root";
        String password = "";
        String query = "INSERT INTO home_loan (First_Name, Middle_Name, Last_Name, DOB, Phone_no, Job, Address, Account_no, " +
                "Account_holder, Monthly_income, Loan_amount, Duration, Monthly_debt, House_Type, House_price, Location, " +
                "Square_feet, full_payment, interest_rate, Monthly_payment, Email) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, Fname);
            preparedStatement.setString(2, M_name);
            preparedStatement.setString(3, L_name);
            preparedStatement.setDate(4, Date.valueOf(Dob));  // Format: "YYYY-MM-DD"
            preparedStatement.setString(5, Phone);
            preparedStatement.setString(6, Job);
            preparedStatement.setString(7, Addrss);
            preparedStatement.setString(8, AccNUM);
            preparedStatement.setString(9, AccHolder);
            preparedStatement.setInt(10, MonInc);
            preparedStatement.setInt(11, Loan_amt);
            preparedStatement.setInt(12, duraation);
            preparedStatement.setInt(13, MonDebt);
            preparedStatement.setString(14, HT);
            preparedStatement.setInt(15, HP);
            preparedStatement.setString(16, Loc);
            preparedStatement.setInt(17, Sqr);
            preparedStatement.setDouble(18, overAll_payment);
            preparedStatement.setDouble(19, interestrate);
            preparedStatement.setDouble(20, Monthly_paymennt);
            preparedStatement.setString(21, mail);


            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "A new Home loan record was inserted successfully!", "Insertion Successful", JOptionPane.INFORMATION_MESSAGE);
            }


            connection.close();


        } catch (Exception e) {
            System.out.println(e);
        }
    }
}


