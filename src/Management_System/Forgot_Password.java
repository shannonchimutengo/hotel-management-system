package Management_System;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.sql.*;


@SuppressWarnings("ALL")

public class Forgot_Password  extends Thread{

    JFrame forgot_password  = new JFrame();
    ImageIcon background;
    JLabel  Icon;

    JButton search = new JButton();
    JButton save = new JButton("Search");
    JButton signup = new JButton();
    JButton login = new JButton();

    JTextField email_field = new JTextField();
    JTextField security_question_field  = new JTextField();
    JTextField answer_field  = new JTextField();
    JTextField new_password_field = new JTextField();
    JTextField confirm_password_field = new JTextField();

    JLabel email = new JLabel("Email");
    JLabel security_question = new JLabel("Security Question");
    JLabel answer = new JLabel("Answer");
    JLabel new_password = new JLabel("new Password");
    JLabel confirm_password = new JLabel("Confirm Password");
    JLabel display_text = new JLabel("Reset Password");

    Forgot_Password(){
        background = new ImageIcon("C://Users//Shannon//IdeaProjects//Hotel Management//src//Management images//admin Home.png");
        Icon = new JLabel(background);
        Icon.setBounds(0,0,1366,768);

        display_text.setBounds(310,20,200,50);
        display_text.setFont(new Font("Tahoma",Font.BOLD,20));

        search.setFocusable(false);
        search.setText("SEARCH");
        search.setBackground(Color.GRAY);
        search.setForeground(Color.WHITE);
        search.setBorder(new LineBorder(Color.RED,2));
        search.setBounds(550,80,80,30);

        save.setFocusable(false);
        save.setText("SAVE");
        save.setBackground(Color.GRAY);
        save.setForeground(Color.WHITE);
        save.setBorder(new LineBorder(Color.RED,2));
        save.setBounds(100,320,80,30);

        signup.setFocusable(false);
        signup.setText("SIGNUP");
        signup.setBackground(Color.GRAY);
        signup.setForeground(Color.WHITE);
        signup.setBorder(new LineBorder(Color.RED,2));
        signup.setBounds(480,320,80,30);

        signup.addActionListener(onclick->{

            forgot_password.dispose();
        });

        login.setFocusable(false);
        login.setText("LOGIN");
        login.setBackground(Color.GRAY);
        login.setForeground(Color.WHITE);
        login.setBorder(new LineBorder(Color.RED,2));
        login.setBounds(270,320,80,30);

        login.addActionListener(onclick->{
            Login login = new Login();
            login.start();
            forgot_password.dispose();
        });
        search.addActionListener(onclick -> searchEmail());

        security_question.setBounds(0,120,300,35);
        security_question.setFont(new Font("Tahoma",Font.BOLD,20));
        security_question.setForeground(Color.WHITE);

        security_question_field.setBounds(250,120,250,20);
        security_question_field.setSize(385,30);
        security_question_field.setBackground(Color.lightGray);
        security_question_field.setForeground(Color.WHITE);
        security_question_field.setBorder(new LineBorder(Color.RED,2));
        security_question_field.setFont(new Font("Tahoma",Font.BOLD,18));
        email.setBounds(80,80,100,15);
        email.setFont(new Font("Tahoma",Font.BOLD,20));
        email.setForeground(Color.WHITE);
        //Answer
        answer.setBounds(20,160,300,35);
        answer.setFont(new Font("Tahoma",Font.BOLD,20));
        answer.setForeground(Color.WHITE);

        answer_field.setBounds(200,160,250,20);
        answer_field.setSize(385,30);
        answer_field.setBackground(Color.lightGray);
        answer_field.setForeground(Color.WHITE);
        answer_field.setBorder(new LineBorder(Color.RED,2));
        answer_field.setFont(new Font("Tahoma",Font.BOLD,18));

        new_password.setBounds(20,200,300,35);
        new_password.setFont(new Font("Tahoma",Font.BOLD,20));
        new_password.setForeground(Color.WHITE);

        new_password_field.setBounds(200,200,250,20);
        new_password_field.setSize(385,30);
        new_password_field.setBackground(Color.lightGray);
        new_password_field.setForeground(Color.WHITE);
        new_password_field.setBorder(new LineBorder(Color.RED,2));
        new_password_field.setFont(new Font("Tahoma",Font.BOLD,8));


        confirm_password.setBounds(0,240,300,35);
        confirm_password.setFont(new Font("Tahoma",Font.BOLD,20));
        confirm_password.setForeground(Color.WHITE);

        confirm_password_field.setBounds(250,240,250,20);
        confirm_password_field.setSize(385,30);
        confirm_password_field.setBackground(Color.lightGray);
        confirm_password_field.setForeground(Color.WHITE);
        confirm_password_field.setBorder(new LineBorder(Color.RED,2));
        confirm_password_field.setFont(new Font("Tahoma",Font.BOLD,8));

        email.setBounds(20,80,100,15);
        email.setFont(new Font("Tahoma",Font.BOLD,20));

        email_field.setBounds(200,80,250,20);
        email_field.setSize(340,30);
        email_field.setBackground(Color.lightGray);
        email_field.setForeground(Color.WHITE);
        email_field.setBorder(new LineBorder(Color.RED,2));
        email_field.setFont(new Font("Tahoma",Font.BOLD,18));

        forgot_password.setLayout(null);
        forgot_password.add(Icon);
        Icon.add(email);
        Icon.add(display_text);
        Icon.add(email_field);
        Icon.add(security_question);
        Icon.add(security_question_field);
        Icon.add(answer);
        Icon.add(answer_field);
        Icon.add(new_password);
        Icon.add(new_password_field);
        Icon.add(confirm_password);
        Icon.add(confirm_password_field);
        Icon.add(search);
        Icon.add(save);
        Icon.add(signup);
        Icon.add(login);

        //forgot_password.setResizable(false);
        forgot_password.setSize(700,400);
       forgot_password.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       forgot_password.setResizable(false);
        forgot_password.setVisible(true);

        login.addActionListener(onclick->{
            Login login = new Login();
            login.start();
            forgot_password.dispose();
        });
        /**
         * serch button action listener:
         * to retrive the security question
         *
         */
        search.addActionListener(onclick -> searchEmail());

        /**
         * Save ActionListener to Validate
         *
         * */
        save.addActionListener(onclick -> {

            if(new_password_field.getText().equals(confirm_password_field.getText())){

               resettingPassword();

            }else{

                JOptionPane.showMessageDialog(null,
                        "Error: Password didnot match",
                        "Login",JOptionPane.ERROR_MESSAGE);
            }
                });
    }
    /**
     *
     * Function to retrive security Question
     * from the database and to auto populate the security JTextField
     *
     * */

    private void searchEmail(){

        String username = "root";
        String password = "";
        String databaseUrl = "jdbc:mysql://localhost:3306/signup";
        String retrived_security_question = "";


        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(databaseUrl,username,password);
            Statement statement = connection.createStatement();
            Statement statement1= connection.createStatement();

            ResultSet retrived =   statement.executeQuery("select security_question from signup_users where email = '"+email_field.getText() +"'");

            //Retriving security question from database

            while (retrived.next()){

                retrived_security_question = retrived.getString(1);
            }
            security_question_field.setText(retrived_security_question);  // setting the question value after retrieving question

            connection.close();

        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Error: Check your Database connectivity",
                    "Login",JOptionPane.ERROR_MESSAGE);
        }


    }// the end of searchEmail() function
    /**
     * function to insert new password into the database.
     * function to verify the security answer provided.
     *
     * */
    private void resettingPassword(){
        String username = "root";
        String password = "";
        String databaseUrl = "jdbc:mysql://localhost:3306/signup";
        String answer_from_db  = "";

        try{
            Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(databaseUrl,username,password);
            Statement statement1= connection.createStatement();
            Statement statement2= connection.createStatement();

            //Retriving the answer in the database
            ResultSet retrived_answer =   statement1.executeQuery("select answer from signup_users where email = '"+email_field.getText() +"'");


            while(retrived_answer.next()){

                answer_from_db = retrived_answer.getString(1);
            }
            System.out.println(answer_from_db);
            System.out.println(answer_field.getText()+" :user name provided");

            if(answer_from_db.equals(answer_field.getText())){
                statement2.executeUpdate("update signup_users set userpassword = '"+
                        new_password_field.getText()+
                        "' where email = '"+
                        email_field.getText()+"';");
                connection.close();
                JOptionPane.showMessageDialog(null,
                        "Successful: successfully updated!",
                        "Updated",JOptionPane.ERROR_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(null,
                        "Error: Check your security answer!",
                        "ERROR",JOptionPane.ERROR_MESSAGE);
                connection.close();
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Error: Check your Database connectivity",
                    "Login",JOptionPane.ERROR_MESSAGE);
        }
    }

}
