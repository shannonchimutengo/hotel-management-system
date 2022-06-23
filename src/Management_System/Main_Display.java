package Management_System;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.time.LocalDate;

class Checkout_Page extends JPanel{

    ImageIcon panel_background  = new ImageIcon("src//Management images//all pages background.png");
    JLabel checkout_panel_background = new JLabel(panel_background);

    JLabel checkout_room_number = new JLabel("Room Number");
    JTextField checkout_room_field = new JTextField();

    JButton search_room = new JButton("Search");

    JLabel customer_name = new JLabel("Customer Name");
    JTextField customer_name_field = new JTextField();

    JLabel customer_date = new JLabel("Check In Date");
    JTextField customer_date_field = new JTextField();

    JLabel checkout_date = new JLabel("Check Out Date");
    JTextField checkout_date_field = new JTextField();

    JLabel customer_mobile_number = new JLabel("Customer Mobile Number");
    JTextField customer_mobile_field = new JTextField();

    JLabel customer_price = new JLabel("Price Per Day");
    JTextField customer_price_field = new JTextField();

    JLabel customer_num_days= new JLabel("Number Of Days Stay");
    JTextField customer_num_days_field = new JTextField();

    JLabel total_amount= new JLabel("Total Amount To Collect");
    JTextField total_amount_field = new JTextField();

    JLabel email= new JLabel("Customer Email");
    JTextField email_field = new JTextField();

    JButton checkout_button = new JButton("CheckOut");
    JButton clear_all_field_button = new JButton("Clear");

    ImageIcon customer_checkout_image  = new ImageIcon("src//Management images//Customer Check Out.png");
    JLabel icon = new JLabel(customer_checkout_image);
    ImageIcon close_button  = new ImageIcon("src//Management images//exit.png");
    JButton close_panel_button = new JButton(close_button);

    JTable table = new JTable();
    DefaultTableModel model = new DefaultTableModel();
    JScrollPane scrollPane = new JScrollPane(table);

    Object [] Columns = new Object[12];
    Object [] tableHeader = {
            "Name",
            "Mobile Number",
            "Nationality",
            "Gender",
            "Email",
            "ID Proof",
            "Address",
            "Check In",
            "Bed",
            "Room Number",
            "Price Per Day"

    };

LocalDate localDateTime;

    {
        localDateTime = LocalDate.now();
    }
    String username = "root";
    String password = "";
    String databaseUrl = "jdbc:mysql://localhost:3306/signup";


    Checkout_Page(){


        checkout_panel_background.setBounds(0,0,1250,580);
        this.setLayout(null);

        icon.setSize(200,80);
        icon.setBounds(0,0,300,80);
        icon.setText("CUSTOMER CHECK OUT");
        icon.setFont(new Font("Tahoma",Font.BOLD,14));

        checkout_room_number.setBounds(420,60,120,20);
        checkout_room_number.setFont(new Font("Tahoma",Font.BOLD,15));
        checkout_room_field.setBounds(420,100,150,30);
        checkout_room_field.setFont(new Font("Tahoma",Font.BOLD,15));

        search_room.setBounds(640,100,100,20);
        search_room.setFont(new Font("Tahoma",Font.BOLD,15));
        search_room.setFocusable(false);

        checkout_room_number.setBounds(420,60,120,20);
        checkout_room_number.setFont(new Font("Tahoma",Font.BOLD,15));
        checkout_room_field.setBounds(420,100,200,20);
        checkout_room_field.setFont(new Font("Tahoma",Font.BOLD,15));

        customer_name.setBounds(20,160,200,20);
        customer_name.setFont(new Font("Tahoma",Font.BOLD,15));
        customer_name_field.setBounds(20,190,200,20);
        customer_name_field.setFont(new Font("Tahoma",Font.BOLD,15));

        customer_date.setBounds(250,160,200,20);
        customer_date.setFont(new Font("Tahoma",Font.BOLD,15));
        customer_date_field.setBounds(250,190,200,20);
        customer_date_field.setFont(new Font("Tahoma",Font.BOLD,15));

        checkout_date.setBounds(500,160,200,20);
        checkout_date.setFont(new Font("Tahoma",Font.BOLD,15));
        checkout_date_field.setBounds(500,190,200,20);
        checkout_date_field.setFont(new Font("Tahoma",Font.BOLD,15));
        checkout_date_field.setText(localDateTime.toString());

        customer_mobile_number.setBounds(800,160,200,20);
        customer_mobile_number.setFont(new Font("Tahoma",Font.BOLD,15));
        customer_mobile_field.setBounds(800,190,200,20);
        customer_mobile_field.setFont(new Font("Tahoma",Font.BOLD,15));

        customer_price.setBounds(20,240,200,20);
        customer_price.setFont(new Font("Tahoma",Font.BOLD,15));
        customer_price_field.setBounds(20,280,200,20);
        customer_price_field.setFont(new Font("Tahoma",Font.BOLD,15));

        customer_num_days.setBounds(250,240,200,20);
        customer_num_days.setFont(new Font("Tahoma",Font.BOLD,15));
        customer_num_days_field.setBounds(250,280,200,20);
        customer_num_days_field.setFont(new Font("Tahoma",Font.BOLD,15));

        total_amount.setBounds(500,240,300,20);
        total_amount.setFont(new Font("Tahoma",Font.BOLD,15));
        total_amount_field .setBounds(500,280,200,20);
        total_amount_field.setFont(new Font("Tahoma",Font.BOLD,15));

        email.setBounds(800,240,300,20);
        email.setFont(new Font("Tahoma",Font.BOLD,15));
        email_field .setBounds(800,280,200,20);
        email_field.setFont(new Font("Tahoma",Font.BOLD,15));

        checkout_button.setBounds(1020,280,100,25);
        checkout_button.setBorder(new LineBorder(Color.red,2));
        checkout_button.setForeground(Color.white);
        checkout_button.setFocusable(false);
        checkout_button.setBackground(Color.GRAY);

        clear_all_field_button.setBounds(1150,280,100,25);
        clear_all_field_button.setBorder(new LineBorder(Color.red,2));
        clear_all_field_button.setForeground(Color.white);
        clear_all_field_button.setFocusable(false);
        clear_all_field_button.setBackground(Color.GRAY);

        model.setColumnIdentifiers(tableHeader);
        table.setModel(model);
        table.setRowHeight(30);
        table.setAutoCreateRowSorter(true);
        table.setSize(1000,210);
        scrollPane.setBounds(0,310,1250,210);


        this.setVisible(false);
        this.setBounds(80,100,1250,580);
        this.add(checkout_panel_background);

        close_panel_button.setBounds(0,1200,20,20);

        checkout_panel_background.add(icon);
        checkout_panel_background.add(checkout_room_number);
        checkout_panel_background.add(checkout_room_field);

        checkout_panel_background.add(search_room);
        checkout_panel_background.add(customer_name);
        checkout_panel_background.add(customer_name_field);

        checkout_panel_background.add(customer_date);
        checkout_panel_background.add(customer_date_field);

        checkout_panel_background.add(checkout_date);
        checkout_panel_background.add(checkout_date_field);

        checkout_panel_background.add(customer_mobile_number);
        checkout_panel_background.add(customer_mobile_field);

        checkout_panel_background.add(customer_price);
        checkout_panel_background.add(customer_price_field);

        checkout_panel_background.add(customer_num_days);
        checkout_panel_background.add(customer_num_days_field);

        checkout_panel_background.add(total_amount);
        checkout_panel_background.add(total_amount_field);

        checkout_panel_background.add(email);
        checkout_panel_background.add(email_field);

        checkout_panel_background.add(scrollPane);
        checkout_panel_background.add(close_panel_button);

        checkout_panel_background.add(checkout_button);
        checkout_panel_background.add(clear_all_field_button);

        customer_name_field.setEditable(false);
        customer_mobile_field.setEditable(false);
        customer_price_field.setEditable(false);

        total_amount_field.setEditable(false);
        email_field.setEditable(false);



    }

   public void checkinDatabaseConnection(){
 

        try{
            Class.forName("com.mysql.jdbc.Driver");

            Connection connection = DriverManager.getConnection(databaseUrl,username,password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from checkin_info");

            model.setRowCount(0);

            while(resultSet.next()){

                Columns[0] = resultSet.getString(1);
                Columns[1] = resultSet.getString(2);
                Columns[2] = resultSet.getString(3);
                Columns[3] = resultSet.getString(4);
                Columns[4] = resultSet.getString(5);
                Columns[5] = resultSet.getString(6);
                Columns[6] = resultSet.getString(7);
                Columns[7] = resultSet.getString(8);
                Columns[8] = resultSet.getString(9);
                Columns[9] = resultSet.getString(10);
                Columns[10] = resultSet.getString(11);

                model.addRow(Columns);

            }

        }catch (ClassNotFoundException | SQLException  e){
        JOptionPane.showMessageDialog(null,
                "Error Occured",
                "SEACH ERROR",
                JOptionPane.ERROR_MESSAGE);

            e.printStackTrace();

        }


    }
    public void clearFields(){

        customer_name_field.setText(null);
        customer_date_field.setText(null);
        customer_mobile_field.setText(null);
        customer_price_field.setText(null);
        total_amount_field.setText(null);
        email_field.setText(null);
    }

    public void  autoPopulateFields(){


        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(databaseUrl,username,password);
            Statement statement = connection.createStatement();

            ResultSet resultSet  =  statement.executeQuery("select name," +
                    " mobile_number," +
                    "nationality, " +
                    "gender," +
                    "email," +
                    "id_proof," +
                    "address," +
                    "checkin_date," +
                    "bed," +
                    "room_number," +
                    "price from checkin_info where room_number = "+
                    checkout_room_field.getText().replace(" ",""));

            while(resultSet.next()){
                customer_name_field.setText(resultSet.getString(1));
                customer_mobile_field.setText(resultSet.getString(2));
                customer_price_field.setText(resultSet.getString(11));
                email_field.setText(resultSet.getString(5));
                customer_date_field.setText(resultSet.getString(8));
            }

        } catch (ClassNotFoundException | SQLException e) {

            JOptionPane.showMessageDialog(null,
                    "Error Occured! Type Error -> 'String is not allowed'",
                    "RETRIVAL ERROR",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();

        }

    }

}

public class Main_Display{

/**
 * frame components declaration
 *
 * */
    JFrame display_menu = new JFrame();
    ImageIcon background_image =   new ImageIcon("src//Management images//home.png");
    ImageIcon close_button  = new ImageIcon("src//Management images//exit.png");
    ImageIcon checkin_close_button  = new ImageIcon("src//Management images//close.png");
    ImageIcon manage_room_image  = new ImageIcon("src//Management images//manage room.png");
    ImageIcon customer_checkin_image  = new ImageIcon("src//Management images//Customer Registration & Check IN.png");
    ImageIcon customer_checkout_image  = new ImageIcon("src//Management images//Customer Check Out.png");
    ImageIcon customer_bill  = new ImageIcon("src//Management images//Customer Details Bill.png");
    ImageIcon logout_image  = new ImageIcon("src//Management images//logout.png");
    ImageIcon panel_background  = new ImageIcon("src//Management images//all pages background.png");


    JButton manage_room  = new JButton (manage_room_image);
    JButton customer_checkin  = new JButton(customer_checkin_image);
    JButton customer_checkout  = new JButton(customer_checkout_image);
    JButton customer_details_bill  = new JButton(customer_bill);
    JButton logout  = new JButton(logout_image);
    JButton exit  = new JButton(close_button);
    JButton checkin_exit = new JButton(checkin_close_button);
    JLabel background  = new JLabel(background_image);
    JLabel manage_panel_background  = new JLabel(panel_background);
    JLabel checkin_panel_background  = new JLabel(panel_background);
    JPanel customer_checkin_panel = new JPanel();


    JLabel room_number = new JLabel("Room Number");
    JTextField room_number_field = new JTextField();
    JLabel bed = new JLabel("Bed");
    String [] types_of_beds = {"Single Bed","Twin Beds","Double Bed","Triple Beds"};
    JComboBox bed_field = new JComboBox(types_of_beds);
    JLabel price = new JLabel("Price");
    JTextField price_field = new JTextField();
    JButton add_room = new JButton("Add Room");
    String bed_data;
    String room_status = "Not booked";
    

    JTable table =new JTable();
    DefaultTableModel model = new DefaultTableModel();
    Object [] tableHeader  = {"Room number","Bed","Price","Status"};
    Object [] cols = new Object[6];
    JPanel manage_panel = new JPanel();
    ImageIcon panel_exit  = new ImageIcon("src//Management images//close.png");
    JButton close_panel_button = new JButton(panel_exit);

    JLabel customer_name = new JLabel("Name");
    JTextField customer_name_field = new JTextField();
    JLabel customer_mobile = new JLabel("Mobile Number");
    JTextField customer_mobile_field = new JTextField();
    JLabel customer_nationality = new JLabel("Nationality");
    JTextField customer_nationality_field = new JTextField();
    String [] gender_choice  = {"Male","Female"};
    JLabel gender = new JLabel("Gender");
    JComboBox gender_combo = new JComboBox(gender_choice);
    JLabel email = new JLabel("Email");
    JTextField email_field = new JTextField();
    JLabel ID_proof = new JLabel("ID proof");
    JTextField ID_proof_field = new JTextField();
    JLabel Address = new JLabel("Address");
    JTextField Address_field = new JTextField();
    JLabel checkin_date = new JLabel("Checkin Date");
    JTextField checkin_date_field = new JTextField();
    JLabel customer_bed = new JLabel("Bed");
    JComboBox customer_bed_combo;

    {
        customer_bed_combo = new JComboBox(types_of_beds);
    }

    JLabel customer_room_number = new JLabel("Room Number");
    JComboBox customer_room_number_field = new JComboBox();
    JLabel customer_price = new JLabel("Price");
    JTextField customer_price_field = new JTextField();
    JButton allocate_customer = new  JButton("Allocate room");
    JButton clear_customer_data = new JButton("Clear");
    String gender_data;
    String customer_bed_data;
    String customer_room_data;

    String username = "root";
    String password = "";
    String databaseUrl = "jdbc:mysql://localhost:3306/signup";

    Checkout_Page checkout_page =  new Checkout_Page();



    Main_Display(){


// manage panel components
        manage_panel.setLayout(null);
        close_panel_button.setBounds(960,0,30,30);
      close_panel_button.setFocusable(false);
      manage_panel_background.setBounds(0,0,1000,550);
      manage_panel.setBounds(200,100,1000,550);
      manage_panel.setVisible(false);
      manage_panel.add(manage_panel_background);
      customer_checkin_panel.setLayout(null);


        model.setColumnIdentifiers(tableHeader);
      table.setModel(model);
      table.setAutoCreateRowSorter(true);
      table.setRowHeight(30);
      table.setBounds(0,50,500,500);
      table.setSize(580,350);
      JScrollPane pane =new JScrollPane(table);
      pane.setBounds(0,50,580,350);
        manage_panel_background.add(pane);
      /*
        main display components

        */
      display_menu.setLayout(null);
      manage_room.setBounds(0,20,200,60);
      manage_room.setBorder(new LineBorder(Color.white,5));
      manage_room.setText("Manage room");
      manage_room.setFocusable(false);
      manage_room.setBackground(Color.WHITE);

      customer_checkin.setBounds(240,20,200,60);
      customer_checkin.setBorder(new LineBorder(Color.white,5));
      customer_checkin.setText("Customer Check in");
      customer_checkin.setFocusable(false);
      customer_checkin.setBackground(Color.white);

      customer_checkout.setBounds(490,20,200,60);
      customer_checkout.setBorder(new LineBorder(Color.white,5));
      customer_checkout.setText("Customer check out");
      customer_checkout.setFocusable(false);
      customer_checkout.setBackground(Color.white);

      customer_details_bill.setBounds(710,20,200,60);
      customer_details_bill.setBorder(new LineBorder(Color.white,5));
      customer_details_bill.setText("Customer Bill");
      customer_details_bill.setFocusable(false);
      customer_details_bill.setBackground(Color.white);
      customer_checkout.setFocusable(false);
      customer_checkout.setBackground(Color.white);

      logout.setBounds(950,20,200,60);
      logout.setBorder(new LineBorder(Color.white,5));
      logout.setText("Logout");
      logout.setFocusable(false);
      logout.setBackground(Color.white);

      room_number.setBounds(640,30,200,100);
      room_number.setFont(new Font("Tahoma",Font.BOLD,15));
      room_number.setForeground(Color.BLACK);
      room_number_field.setBounds(640,110,200,200);
      room_number_field.setSize(200,40);
      room_number_field.setForeground(Color.BLACK);
      room_number_field.setFont(new Font("Tahoma",Font.BOLD,15));


      bed.setBounds(640,260,200,40);
      bed.setFont(new Font("Tahoma",Font.BOLD,15));
      bed_field.setBounds(640,300,200,40);
      bed_field.setFont(new Font("Tahoma",Font.BOLD,15));

      price.setBounds(640,350,200,40);
      price.setFont(new Font("Tahoma",Font.BOLD,15));
      price_field.setBounds(640,390,200,40);
      price_field.setFont(new Font("Tahoma",Font.BOLD,15));

      add_room.setFocusable(false);
      add_room.setBackground(Color.GRAY);
      add_room.setForeground(Color.WHITE);
      add_room.setBorder(new LineBorder(Color.RED,2,true));
      add_room.setBounds(640,460,100,40);


      exit.setBounds(1160,20,150,60);
      exit.setBorder(new LineBorder(Color.white,5));
      exit.setFocusable(false);
      exit.setBackground(Color.white);

      background.setBounds(0,0,1366,768);
      background.add(exit);
      background.add(manage_room);
      background.add(customer_checkin);
      background.add(customer_checkout);
      background.add(customer_details_bill);
      background.add(logout);
      background.add(manage_panel);
      background.add(customer_checkin_panel);
      background.add(checkout_page);

      display_menu.add(background);
      display_menu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      display_menu.setVisible(true);
      display_menu.setSize(1366,768);

      manage_panel_background.add(close_panel_button);
      manage_panel_background.add(room_number);
      manage_panel_background.add(room_number_field);
      manage_panel_background.add(bed);
      manage_panel_background.add(bed_field);
      manage_panel_background.add(price);
      manage_panel_background.add(price_field);
      manage_panel_background.add(add_room);
      //Customer  check in  components
        customer_name.setBounds(20,40,100,50);
        customer_name.setFont(new Font("Tahoma",Font.BOLD,15));
        customer_name.setForeground(Color.BLACK);
        customer_name_field.setBounds(20,90,300,20);
        customer_name_field.setFont(new Font("Tahoma",Font.BOLD,15));

        customer_mobile.setBounds(20,120,200,50);
        customer_mobile.setFont(new Font("Tahoma",Font.BOLD,15));
        customer_mobile.setForeground(Color.BLACK);
        customer_mobile_field.setBounds(20,170,300,20);
        customer_mobile_field.setFont(new Font("Tahoma",Font.BOLD,15));

        customer_nationality.setBounds(20,200,200,50);
        customer_nationality.setFont(new Font("Tahoma",Font.BOLD,15));
        customer_nationality.setForeground(Color.BLACK);
        customer_nationality_field.setBounds(20,240,300,20);
        customer_nationality_field.setFont(new Font("Tahoma",Font.BOLD,15));

        gender.setBounds(20,250,200,50);
        gender.setFont(new Font("Tahoma",Font.BOLD,15));
        gender.setForeground(Color.BLACK);
        gender_combo.setBounds(20,300,300,20);
        gender_combo.setFont(new Font("Tahoma",Font.BOLD,15));

        email.setBounds(20,340,200,50);
        email.setFont(new Font("Tahoma",Font.BOLD,15));
        email.setForeground(Color.BLACK);
        email_field.setBounds(20,400,300,20);
        email_field.setFont(new Font("Tahoma",Font.BOLD,15));

        ID_proof.setBounds(400,40,200,50);
        ID_proof.setFont(new Font("Tahoma",Font.BOLD,15));
        ID_proof.setForeground(Color.BLACK);
        ID_proof_field.setBounds(400,90,300,20);
        ID_proof_field.setFont(new Font("Tahoma",Font.BOLD,15));

        Address.setBounds(400,120,200,50);
        Address.setFont(new Font("Tahoma",Font.BOLD,15));
        Address.setForeground(Color.BLACK);
        Address_field.setBounds(400,170,300,20);
        Address_field.setFont(new Font("Tahoma",Font.BOLD,15));

        checkin_date.setBounds(400,200,200,50);
        checkin_date.setFont(new Font("Tahoma",Font.BOLD,15));
        checkin_date.setForeground(Color.BLACK);
        checkin_date_field.setBounds(400,240,300,20);
        checkin_date_field.setFont(new Font("Tahoma",Font.BOLD,15));

        customer_bed.setBounds(400,250,200,50);
        customer_bed.setFont(new Font("Tahoma",Font.BOLD,15));
        customer_bed.setForeground(Color.BLACK);
        customer_bed_combo.setBounds(400,300,300,20);
        customer_bed_combo.setFont(new Font("Tahoma",Font.BOLD,15));


        customer_room_number.setBounds(750,40,200,50);
        customer_room_number.setFont(new Font("Tahoma",Font.BOLD,15));
        customer_room_number.setForeground(Color.BLACK);
        customer_room_number_field.setBounds(750,90,250,20);
        customer_room_number_field.setFont(new Font("Tahoma",Font.BOLD,15));

        customer_price.setBounds(750,120,200,50);
        customer_price.setFont(new Font("Tahoma",Font.BOLD,15));
        customer_price_field.setForeground(Color.BLACK);
        customer_price_field.setBounds(750,170,250,20);
        customer_price_field.setFont(new Font("Tahoma",Font.BOLD,15));

        allocate_customer.setFocusable(false);
        allocate_customer.setBackground(Color.GRAY);
        allocate_customer.setForeground(Color.WHITE);
        allocate_customer.setBorder(new LineBorder(Color.RED,2,true));
        allocate_customer.setBounds(750,240,150,30);

        clear_customer_data.setFocusable(false);
        clear_customer_data.setBackground(Color.GRAY);
        clear_customer_data.setForeground(Color.WHITE);
        clear_customer_data.setBorder(new LineBorder(Color.RED,2,true));
        clear_customer_data.setBounds(750,300,150,30);

      customer_checkin_panel.setBounds(200,100,1000,550);
      customer_checkin_panel.setVisible(false);
      checkin_exit.setBounds(960,0,30,30);
      checkin_panel_background.add(checkin_exit);
      checkin_panel_background.add(customer_name);
      checkin_panel_background.add(customer_name_field);
      checkin_panel_background.add(customer_mobile);
      checkin_panel_background.add(customer_mobile_field);
      checkin_panel_background.add(customer_nationality);
      checkin_panel_background.add(customer_nationality_field);
      checkin_panel_background.add(gender);
      checkin_panel_background.add(gender_combo);
      checkin_panel_background.add(email);
      checkin_panel_background.add(email_field);
      checkin_panel_background.add(ID_proof);
      checkin_panel_background.add(ID_proof_field);
      checkin_panel_background.add(Address);
      checkin_panel_background.add(Address_field);
      checkin_panel_background.add(checkin_date);
      checkin_panel_background.add(checkin_date_field);
      checkin_panel_background.add(customer_bed);
      checkin_panel_background.add(customer_bed_combo);

      checkin_panel_background.add(customer_room_number);
      checkin_panel_background.add(customer_room_number_field);
      checkin_panel_background.add(customer_price);
      checkin_panel_background.add(customer_price_field);
      checkin_panel_background.add(allocate_customer);
      checkin_panel_background.add(clear_customer_data);

      customer_checkin_panel.add(checkin_panel_background);
      checkin_panel_background.setBounds(0,0,1000,550);


        manage_room.addActionListener(onclick->{
          manage_panel.setVisible(true);
          customer_checkin.setEnabled(true);
          manage_room.setEnabled(false);
          customer_checkin_panel.setVisible(false);
          customer_checkout.setEnabled(true);
          checkout_page.setVisible(false);

          select_all_rows();
      });
      close_panel_button.addActionListener(clicked -> {

          manage_panel.setVisible(false);
          manage_room.setEnabled(true);
          customer_checkin_panel.setVisible(false);
          customer_checkout.setEnabled(true);
          checkout_page.setVisible(false);


      });
      checkin_exit.addActionListener(onclick ->{
          customer_checkin_panel.setVisible(false);
          customer_checkin.setEnabled(true);
          customer_checkin_panel.setVisible(false);
          checkout_page.setVisible(false);
      });
      customer_checkin.addActionListener(onclick ->{
          customer_checkin_panel.setVisible(true);
          customer_checkin.setEnabled(false);
          manage_panel.setVisible(false);
          manage_room.setEnabled(true);
          customer_checkout.setEnabled(true);
          checkout_page.setVisible(false);
          checkout_page.checkout_date_field.setText(checkout_page.localDateTime.toString());


      });
      customer_checkout.addActionListener(onclick->{
          checkout_page.setVisible(true);
          customer_checkout.setEnabled(false);
          manage_panel.setVisible(false);
          manage_room.setEnabled(true);
          customer_checkin_panel.setVisible(false);
          customer_checkin.setEnabled(true);
          checkout_page.checkinDatabaseConnection();

      });

      add_room.addActionListener(onclick ->{
          if(room_number.getText().equals("")||
                  Objects.equals(bed_field.getSelectedItem(), "") ||price_field.getText().equals(""))
          {
              JOptionPane.showMessageDialog(null,
                      "Please Fill All Details",
                      "VALUE ERROR",
                      JOptionPane.ERROR_MESSAGE,panel_exit);
          }else {

              allRoomsDatabase();
              select_all_rows();
          }
      });
        allocate_customer.addActionListener(onclick ->{

                String selected_room = (String) customer_room_number_field.getSelectedItem();
                checkin_database_connection();
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection connection = DriverManager.getConnection(databaseUrl,username,password);

                    Statement statement  = connection.createStatement();
                    statement.executeUpdate("update all_rooms set status = 'booked' where room_number = '"+selected_room+"';");

                    connection.close();
                    System.out.println(selected_room);

                }catch(ClassNotFoundException | SQLException e){
                    JOptionPane.showMessageDialog(null,
                            "Failed to update room status",
                            "Table Error",
                            JOptionPane.ERROR_MESSAGE,panel_exit);

                }

                allocate_customer.setEnabled(false);

        }); // actionListener
        customer_bed_combo.addActionListener(itemListener->{

            String selected_bed = (String) customer_bed_combo.getSelectedItem();
            System.out.println(selected_bed);

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection(databaseUrl,username,password);
                Statement statement = connection.createStatement();
               ResultSet resultSet =  statement.executeQuery("select room_number from all_rooms where status = '"+
                       room_status+
                       "' and bed = '"+ selected_bed+"';");
               customer_room_number_field.removeAllItems();
               while(resultSet.next()){
                   String room = "";
                   room+=resultSet.getString(1);
                   customer_room_number_field.addItem(room);
               }

               connection.close();
            }catch (ClassNotFoundException | SQLException e){

                e.printStackTrace();
            }

        });

        clear_customer_data.addActionListener(onclick ->{
            customer_name_field.setText(null);
            customer_mobile_field.setText(null);
            customer_nationality_field.setText(null);
            gender_combo.setSelectedItem(null);
            email_field.setText(null);
            ID_proof_field.setText(null);
            Address_field.setText(null);
            checkin_date_field.setText(null);
            customer_bed_combo.setSelectedItem(null);
            room_number_field.setText(null);
            customer_price_field.setText(null);
            allocate_customer.setEnabled(true);
        });

        checkout_page.search_room.addActionListener(searchRoom -> {

            checkout_page.autoPopulateFields();
        });
        checkout_page.clear_all_field_button.addActionListener(Clear ->{

            checkout_page.clearFields();
        });
  }
    public void  allRoomsDatabase(){


         bed_data = (String) bed_field.getItemAt(bed_field.getSelectedIndex());

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(databaseUrl,username,password);

          Statement statement   = connection.createStatement();
          statement.executeUpdate("insert into all_rooms values('"+room_number_field.getText()+ "','"+
                  bed_data+"','"+
                  price_field.getText()+"','"+
                  room_status+"');"
          );
            System.out.println("succeded");

            connection.close();

        }catch (ClassNotFoundException | SQLException e){

            JOptionPane.showMessageDialog(null,
                    "Failed to Perform the operations",
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE,
                    panel_exit
            );
            System.out.println(room_number_field.getText());
            System.out.println(bed_data);
        }
    }
    private void select_all_rows(){

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(databaseUrl,username,password);

            Statement statement  = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from all_rooms");
            model.setRowCount(0);
            while(resultSet.next()){
                cols[0] = resultSet.getString(1);
                cols[1] = resultSet.getString(2);
                cols[2] = resultSet.getString(3);
                cols[3] = resultSet.getString(4);

                model.addRow(cols);
               // checkout_page.model.addRow(cols);      /**  testing the table */
            }
            connection.close();

        }catch(ClassNotFoundException | SQLException e){
          JOptionPane.showMessageDialog(null,
                  "Failed to retrive Data ",
                  "Table Error",
                  JOptionPane.ERROR_MESSAGE,panel_exit);
        }

    }
    private void checkin_database_connection(){

        gender_data = (String) gender_combo.getItemAt(gender_combo.getSelectedIndex());
        customer_bed_data = (String) customer_bed_combo.getItemAt(gender_combo.getSelectedIndex());
        customer_room_data = (String) customer_room_number_field.getItemAt(customer_room_number_field.getSelectedIndex());

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(databaseUrl,username,password);
            Statement statement = connection.createStatement();

            statement.executeUpdate("insert into checkin_info values('"+customer_name_field.getText()+"','"+
                    customer_mobile_field.getText()+"','"+
                    customer_nationality_field.getText()+"','"+
                    gender_data+"','"+
                    email_field.getText()+"','"+
                    ID_proof_field.getText()+"','"+
                    Address_field.getText()+"','"+
                    checkin_date_field.getText()+"','"+
                    customer_bed_data+"','"+
                    customer_room_data+"','"+
                    customer_price_field.getText()+"');");

            connection.close();


            JOptionPane.showMessageDialog(null,
                    "Successful",
                    "SUCCESS",
                    JOptionPane.INFORMATION_MESSAGE);

        }catch (ClassNotFoundException | SQLException e) {

            JOptionPane.showMessageDialog(null,
                    "Failed to perfom the operations",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE,panel_exit);

        }
    }

}
