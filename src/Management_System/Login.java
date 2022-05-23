package Management_System;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.sql.*;

public class Login  extends Thread{

    JFrame login = new JFrame();

    JLabel   password  =       new JLabel("Password");
    JLabel login_message  = new JLabel("LOGIN");

    JLabel   email_login   =       new JLabel("Email");
    JTextField forPassword = new JTextField();
    JTextField for_email_login  = new JTextField();
    JButton confirm_login = new JButton("Signup");
    JButton forgot_password = new JButton("Signup");
    JLabel Icon ;
    ImageIcon background;


    Login(){

        login.setLayout(null);
        login.setResizable(true);
        login_message.setFont(new Font("Tahoma",Font.BOLD,25));
        login_message.setBounds(300,25,300,40);

        background  =  new ImageIcon("C://Users//Shannon//IdeaProjects//Hotel Management//src//Management images//admin Home.png");
        Icon =  new JLabel(background);
        Icon.setSize(1366,768);
        Icon.setBounds(0,0,1366,768);


        email_login.setBounds(80,100,100,15);
        for_email_login.setBounds(250,100,250,20);
        email_login.setFont(new Font("Tahoma",Font.BOLD,20));
        email_login.setForeground(Color.WHITE);


        for_email_login.setSize(350,30);
        for_email_login.setBackground(Color.lightGray);
        for_email_login.setForeground(Color.WHITE);
        for_email_login.setBorder(new LineBorder(Color.RED,2));
        for_email_login.setFont(new Font("Tahoma",Font.BOLD,18));

        password.setFont(new Font("Tahoma",Font.BOLD,20));
        password.setBounds(80,150,300 ,15);
        password.setForeground(Color.WHITE);
        forPassword.setBounds(250,150,200,20);

        forPassword.setSize(350,30);
        forPassword.setBackground(Color.lightGray);
        forPassword.setForeground(Color.WHITE);
        forPassword.setBorder(new LineBorder(Color.RED,2));
        forPassword.setFont(new Font("Tahoma",Font.BOLD,5));


        confirm_login.setFocusable(false);
        confirm_login.setText("LOGIN");
        confirm_login.setBackground(Color.GRAY);
        confirm_login.setForeground(Color.WHITE);
        confirm_login.setBorder(new LineBorder(Color.RED,2));
        confirm_login.setBounds(100,215,100,40);

        forgot_password.setFocusable(false);
        forgot_password.setText("FORGOT PASSWORD?");
        forgot_password.setBackground(Color.GRAY);
        forgot_password.setForeground(Color.WHITE);
        forgot_password.setBorder(new LineBorder(Color.RED,2));
        forgot_password.setBounds(350,215,200,40);

        forgot_password.addActionListener(onclick->{
            login.dispose();
            new Forgot_Password();

        });
        confirm_login.addActionListener(confirm_login-> loginDatabaseConnection());

        login.add(Icon);
        Icon.add(login_message);
        Icon.add(email_login);
        Icon.add(for_email_login);
        Icon.add(forPassword);
        Icon.add(password);
        Icon.add(confirm_login);
        Icon.add(forgot_password);

        login.setSize(700,400);
        login.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        login.setVisible(true);

    }
    /**
     * connecting to the database:
     * validating password for login
     *
     * */
    private void loginDatabaseConnection()

    {
        String username = "root";
        String password = "";
        String databaseUrl = "jdbc:mysql://localhost:3306/signup";
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(databaseUrl,username,password);
            Statement statement = connection.createStatement();
            ResultSet retrived =   statement.executeQuery("select user_password from signup_users where email = '"+for_email_login.getText() +"'");
            String retrived_password ="";
            while(retrived.next()){
                retrived_password = retrived.getString(1);

            }
            connection.close();
            // validating password
            if(retrived_password.equals(forPassword.getText())){
                JOptionPane.showMessageDialog(null,
                        "successful",
                        "Login",JOptionPane.INFORMATION_MESSAGE);
                login.dispose();
        new Main_Display();

            }else {

                System.out.println(forPassword.getText()+" this password is wrong");
                JOptionPane.showMessageDialog(null,
                        "Error: password did not match or user does not exist ",
                        "Login",JOptionPane.ERROR_MESSAGE);
            }

        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();

            JOptionPane.showMessageDialog(null,
                    "Error: Check your Database connectivity",
                    "Login",JOptionPane.ERROR_MESSAGE);
        }
    }
}