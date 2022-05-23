package Management_System;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class adminLogin extends SignUpPage implements Runnable {

    JFrame adminPage = new JFrame();
    JPasswordField passwordField = new JPasswordField();
    JLabel passwordLabel = new JLabel("Enter Password");
    JButton createAccount = new JButton("CREATE ACCOUNT");
    JLabel displayText = new JLabel("For Administrator Use Only");

@Override
  public void   run (){

        adminPage.setLayout(null);
        passwordLabel.setBounds(0,80,300,25);
        passwordLabel.setFont(new Font("Copperplate Gothic Bold",Font.BOLD,15));
        passwordLabel.setForeground(Color.white);

        displayText.setBounds(200,10,300,25);
        displayText.setFont(new Font("Copperplate Gothic Bold",Font.BOLD,15));
        displayText.setForeground(Color.white);

        passwordField.setBounds(200,80,200,25);
        passwordField.setSize(400,30);
        passwordField.setForeground(Color.black);

        createAccount.setFocusable(false);
        createAccount.setBackground(Color.WHITE);
        createAccount.setForeground(Color.black);
        createAccount.setBorder(new LineBorder(Color.RED,2));
        createAccount.setBounds(280,215,200,40);
 //events
    createAccount.addActionListener(onclick->{

     final String pass = "hotel@2021";
       String  password = new String(passwordField.getPassword()) ;

        if(password.equals(pass)){

          JOptionPane.showMessageDialog(null,
                   "Account Successfully Created",
                   "Thank you",
                   JOptionPane.INFORMATION_MESSAGE
           );
            adminPage.dispose();

        }else{

            JOptionPane.showMessageDialog(null,
                    "Failed to Create an Account !!\nPlease contact the System Administrator ",
                    "ACCOUNT FAILURE",
                    JOptionPane.ERROR_MESSAGE

            );
            adminPage.setVisible(false);

        }

    });

        adminPage.add(passwordField);
        adminPage.add(passwordLabel);
        adminPage.add(createAccount);
        adminPage.add(displayText);
        adminPage.setSize(650,350);
        adminPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        adminPage.getContentPane().setBackground(Color.darkGray);
        adminPage.setVisible(true);

    }
}
