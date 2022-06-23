# hotel-management-system
*This project was developed using java programming lunguage and however most of the code was written using imperative programming.

**Imperative programming** is a software development paradigm where functions are implicitly coded in every step required to solve a problem. In imperative programming, every operation is coded and the code itself specifies how the problem is to be solved, which means that pre-coded models are not called on 
[www.techtarget.com](https://www.techtarget.com/whatis/definition/imperative-programming#:~:text=Imperative%20programming%20is%20a%20software,models%20are%20not%20called%20on.).

## Piece of Code

- add_room.addActionListener(onclick ->{
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
