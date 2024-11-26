import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Admin {

    JFrame frame;
    JTable loantable;
    DefaultTableModel tableModel;
    String url = "jdbc:mysql://localhost:3306/loanmanagement";
    String username = "root";
    String password = "";
    String query = "SELECT * FROM car_loan WHERE Loan_Status = 'NA'";

    public static void main(String[] args) {
        new Admin();
    }

    public Admin() {
        // Define columns in the same order as the data fetched
        String[] columns = {
                "Customer_id", "First_Name", "Middle_Name", "Last_Name", "DOB",
                "Phone_no", "Job", "Address", "Account_no", "Account_holder",
                "Monthly_income", "Loan_amount", "Duration", "Monthly_debt",
                "car_brand", "car_type", "car_model", "car_price", "Full_payment",
                "interest_rate", "Monthly_payment", "Email", "Loan_Status"
        };

        // Initialize the table model with columns
        tableModel = new DefaultTableModel(columns, 0);
        loantable = new JTable(tableModel);

        // Set column auto resize mode off to allow horizontal scrolling
        loantable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        // Fetch loan data and fill the table
        fetchLoanData();

        // Add the table to a scroll pane
        JScrollPane tableScrollPane = new JScrollPane(loantable);
        tableScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        tableScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Create buttons for approving and disapproving loans
        JButton approveBTN = new JButton("Approve");
        JButton disapproveBTN = new JButton("Disapprove");
        JButton HomeLoanBtn = new JButton("Home Laon");
        JButton CarLoanBtn = new JButton("Car Laon");


        JPanel leftbtnPanel=new JPanel();
        leftbtnPanel.setLayout(new FlowLayout());
        leftbtnPanel.add(HomeLoanBtn);
        leftbtnPanel.add(CarLoanBtn);


        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(approveBTN);
        buttonPanel.add(disapproveBTN);

        // Frame setup
        frame = new JFrame("ADMIN");
        frame.setSize(1500, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.add(tableScrollPane, BorderLayout.CENTER);
        frame.add(leftbtnPanel,BorderLayout.WEST);
        frame.setVisible(true);

        // Action listeners for buttons
        approveBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateLoanStatus("Approved");
            }
        });

        disapproveBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateLoanStatus("Disapproved");
            }
        });
        HomeLoanBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminHome();
                frame.dispose();
            }
        });
    }

    public void fetchLoanData() {
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            // Fetch each row and add to the table model in the same order as columns
            while (resultSet.next()) {
                int customerID = resultSet.getInt("customer_ID");
                String firstName = resultSet.getString("First_name");
                String middleName = resultSet.getString("Middle_name");
                String lastName = resultSet.getString("Last_name");
                String dob = resultSet.getString("DOB");
                String phoneNum = resultSet.getString("Phone_no");
                String jobT = resultSet.getString("Job");
                String address = resultSet.getString("Address");
                long accountNo = resultSet.getLong("Account_no");
                String accountHolder = resultSet.getString("Account_holder");
                int monthlyIncome = resultSet.getInt("Monthly_income");
                int loanAmount = resultSet.getInt("Loan_amount");
                int duration = resultSet.getInt("Duration");
                int monthlyDebt = resultSet.getInt("Monthly_debt");
                String carBrand = resultSet.getString("car_brand");
                String carType = resultSet.getString("car_type");
                String carModel = resultSet.getString("car_model");
                int carPrice = resultSet.getInt("car_price");
                double fullPayment = resultSet.getDouble("full_payment");
                double interestRate = resultSet.getDouble("interest_rate");
                int monthlyPayment = resultSet.getInt("Monthly_payment");
                String email = resultSet.getString("Email");
                String status = resultSet.getString("Loan_Status");

                // Add the row to the table model in the same order as columns
                tableModel.addRow(new Object[]{
                        customerID, firstName, middleName, lastName, dob,
                        phoneNum, jobT, address, accountNo, accountHolder,
                        monthlyIncome, loanAmount, duration, monthlyDebt,
                        carBrand, carType, carModel, carPrice, fullPayment,
                        interestRate, monthlyPayment, email, status
                });
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();  // Print the error stack trace for debugging
        }
    }

    void updateLoanStatus(String newStatus) {
        int selectedRow = loantable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a loan to update.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Retrieve the customer ID from the first column (index 0)
        int customerID = (int) tableModel.getValueAt(selectedRow, 0);

        // Correct the query to update the loan status based on customer ID
        String updateQuery = "UPDATE car_loan SET Loan_Status = ? WHERE Customer_ID = ?";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = conn.prepareStatement(updateQuery);
            statement.setString(1, newStatus);
            statement.setInt(2, customerID);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                // Update the loan status in the table model (Loan_Status is the 23rd column, index 22)
                tableModel.setValueAt(newStatus, selectedRow, 22);
                JOptionPane.showMessageDialog(null, "Loan status updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();  // Print the stack trace for debugging
        }
    }
}