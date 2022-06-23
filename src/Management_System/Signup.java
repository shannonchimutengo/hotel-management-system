package Management_System;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

/**

 @author Shannon

 */

class SignUpPage implements MouseListener  {

    //   labels
    JFrame signup = new JFrame("HOTEL MANAGEMENT");
    JLabel   name   =       new JLabel("Name");
    JLabel   password  =       new JLabel("Password");
    JLabel   email   =       new JLabel("Email");
    JLabel   securityQuestion   =       new JLabel("Security Question");
    JLabel   answer   =       new JLabel("Answer");
    JLabel   address  =       new JLabel("Address");
    ImageIcon background =   new ImageIcon("src//Management images//signup.png");
    ImageIcon close_button  = new ImageIcon("src//Management images//exit.png");

    JLabel   Icon  =  new JLabel(background);
    JLabel close_icon =   new JLabel(close_button);
    //Button

    JButton signup_Button = new JButton("Signup");
    JButton login_Button = new JButton("Signup");
    JButton forgot_password_Button = new JButton("Signup");

    //TextField
    JTextField forName  = new JTextField();
    JTextField forPassword = new JTextField();
    JTextField forEmail  = new JTextField();
    JTextField forAnswer = new JTextField();
    JTextArea forAddress = new JTextArea();
    String [] questions = {
            "What is the name of your first pet?",
            "what was your first car?",
            "What elementary school did you attend?",
            "What is the name of the town where you were born?"
    };
    JComboBox forSecurityQuestion  = new JComboBox(questions);


    //form variables
    String name_entered;
    String email_entered;
    String password_entered;
    String question_selected;
    String  answer_entered;
    String  address_entered;
    String changePasswordEntered;

    SignUpPage(){
        signup.setLayout(null);

        Icon.setSize(1366,768);
        close_icon.setBounds(1250,45,100,50);
        close_icon.setSize(80,40);
        close_icon.addMouseListener(this);


        name.setBounds(560,200,200,15);
       name.setFont(new Font("Tahoma",Font.BOLD,20));
       name.setForeground(Color.WHITE);

       password.setFont(new Font("Tahoma",Font.BOLD,20));
        password.setBounds(540,250,200,15);
        password.setForeground(Color.WHITE);

        securityQuestion.setBounds(440,350,400,20);
        securityQuestion.setFont(new Font("Tahoma",Font.BOLD,20));
        securityQuestion.setForeground(Color.WHITE);

        answer.setBounds(560,400,350,20);
        answer.setFont(new Font("Tahoma",Font.BOLD,20));
        answer.setForeground(Color.white);
        address.setBounds(560,450,400,20);
        address.setFont(new Font("Tahoma",Font.BOLD,20));
        address.setForeground(Color.WHITE);

        // TextFields
        forName.setBounds(660 ,200,350,20);
        forName.setSize(300,30);
        forName.setBackground(Color.lightGray);
        forName.setForeground(Color.WHITE);
        forName.setBorder(new LineBorder(Color.RED,2));
        forName.setFont(new Font("Tahoma",Font.BOLD,18));

        forPassword.setBounds(660,250,250,20);
        forPassword.setSize(300,30);
       forPassword.setBackground(Color.lightGray);
       forPassword.setForeground(Color.WHITE);
       forPassword.setBorder(new LineBorder(Color.RED,2));
        forPassword.setFont(new Font("Tahoma",Font.BOLD,18));

        forEmail.setBounds(660,300,250,20);
        email.setBounds(560,300,300,20);
        email.setFont(new Font("Tahoma",Font.BOLD,20));
        email.setForeground(Color.blue);

        forEmail.setSize(300,30);
       forEmail.setBackground(Color.lightGray);
       forEmail.setForeground(Color.WHITE);
       forEmail.setBorder(new LineBorder(Color.RED,2));
       forEmail.setFont(new Font("Tahoma",Font.BOLD,12));

        forSecurityQuestion.setBounds(660,350,250,20);
        forSecurityQuestion.setSize(480,30);
       forSecurityQuestion.setBackground(Color.lightGray);
       forSecurityQuestion.setForeground(Color.WHITE);
       forSecurityQuestion.setBorder(new LineBorder(Color.RED,2));
        forSecurityQuestion.setFont(new Font("Tahoma",Font.BOLD,18));

        forAnswer.setBounds(660,400,250,20);
        forAnswer.setSize(300,30);
        forAnswer.setBackground(Color.darkGray);
        forAnswer.setForeground(Color.WHITE);
        forAnswer.setBorder(new LineBorder(Color.RED,2));
        forAnswer.setFont(new Font("Tahoma",Font.BOLD,18));


        forAddress.setBounds(660,450,300,80);
        forAddress.setBackground(Color.lightGray);
        forAddress.setForeground(Color.WHITE);
        forAddress.setBorder(new LineBorder(Color.RED,2));
        forAddress.setFont(new Font("Tahoma",Font.BOLD,18));

        //Buttons
        signup_Button.setFocusable(false);
        signup_Button.setText("SIGNUP");
        signup_Button.setBackground(Color.GRAY);
        signup_Button.setForeground(Color.WHITE);
        signup_Button.setBorder(new LineBorder(Color.RED,2));
        signup_Button.setBounds(500,580,100,40);

        forgot_password_Button.setFocusable(false);
        forgot_password_Button.setText("FORGOT PASSWORD?");
        forgot_password_Button.setBackground(Color.GRAY);
        forgot_password_Button.setForeground(Color.WHITE);
        forgot_password_Button.setBorder(new LineBorder(Color.RED,2));
        forgot_password_Button.setBounds(900,580,200,40);

        login_Button.setFocusable(false);
        login_Button.setText("LOGIN");
        login_Button.setBackground(Color.GRAY);
        login_Button.setForeground(Color.WHITE);
        login_Button.setBorder(new LineBorder(Color.RED,2));
        login_Button.setBounds(700,580,100,40);

        //jCombo Box
        //Action Listeners
        login_Button.addActionListener(onclick->{

                Thread login = new Login();
                //login.start();

        });
        forgot_password_Button.addActionListener(onclick->{
            Thread password_validation  = new Forgot_Password();
            password_validation.start();
        });

        signup_Button.addActionListener(validating_fields->{


  if (forName.getText().equals("") || forEmail.getText().equals("") ||
          forPassword.getText().equals("") || (forSecurityQuestion.getSelectedItem()).equals("") ||
          forAnswer.getText().equals("") || forAddress.getText().equals(""))

  {

      JOptionPane.showMessageDialog(null,
              "Please fill all details on the form: ",
              "Verifying",
              JOptionPane.INFORMATION_MESSAGE
      );
  }else{
      Runnable runnable = new adminLogin();
      Thread thread = new Thread(runnable);
      //thread.start();

      databaseConnection();
  }
        });

        signup.add(Icon);
        Icon.add(close_icon);
        Icon.add(name);
        Icon.add(forName);
        Icon.add(password);
        Icon.add(forPassword);
        Icon.add(email);
        Icon.add(forEmail);
        Icon.add(email);
        Icon.add(securityQuestion);
        Icon.add(forSecurityQuestion);
        Icon.add(answer);
        Icon.add(forAnswer);
        Icon.add(address);
        Icon.add(forAddress);
        Icon.add(signup_Button);
        Icon.add(login_Button);
        Icon.add(forgot_password_Button);

        signup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        signup.setSize(1366,700);
        signup.setVisible(true);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        int choice;
        if(e.getSource()== close_icon){

          choice =    JOptionPane.showConfirmDialog(null,
                    "Do wish to Exit ",
                    "Confirm",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);

            if(choice== 0){
                signup.dispose();
                JOptionPane.showMessageDialog(null,
                        "Application successfully closed",
                        "Thank you",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        }

    }
    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }
    @Override
    public void mouseExited(MouseEvent e) {

    }
    //  MariaDB Database Connection
       public void  databaseConnection(){

        String username = "root";
        String password = "";
        String databaseUrl = "jdbc:mysql://localhost:3306/signup";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(databaseUrl,username,password);

            Statement statement   = connection.createStatement();
            password_entered = forPassword.getText();
             changePasswordEntered = password_entered;
            question_selected = (String) forSecurityQuestion.getItemAt(forSecurityQuestion.getSelectedIndex());
            answer_entered = forAnswer.getText();
            address_entered  =  forAddress.getText();
            name_entered = forName.getText();
            email_entered = forEmail.getText();

            statement.executeUpdate("insert into signup_users values( '"+name_entered+"','"+
                    email_entered+"','"+
                    changePasswordEntered+"','"+
                    question_selected+"','"+
                    answer_entered+"','"+
                    address_entered+"');");

            JOptionPane.showMessageDialog(null,
                    "Successful to connect to the database",
                    "CONNECTION SUCCEEDED",
                    JOptionPane.INFORMATION_MESSAGE
            );
            connection.close();

        }catch (ClassNotFoundException | SQLException e){

            JOptionPane.showMessageDialog(null,
                    "Failed to connect to the database",
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
        }

}
public class Signup {

    public static void main(String[] args) {
        new SignUpPage();
         new Main_Display();

    }
}
