# hotel-management-system

![Menu](https://scontent.fhre1-1.fna.fbcdn.net/v/t39.30808-6/276168155_140734838439715_2106096023964622113_n.jpg?_nc_cat=103&ccb=1-7&_nc_sid=8bfeb9&_nc_ohc=pPtmAemtuy0AX8AP8hb&_nc_ht=scontent.fhre1-1.fna&oh=00_AT8gyZA7a_GAmz3SMuz8i2nYBdV_dJM1yyKIfey3z6s1jw&oe=62B93498)

*This project was developed using java programming lunguage and however most of the code was written using imperative programming.

**Imperative programming** is a software development paradigm where functions are implicitly coded in every step required to solve a problem. In imperative programming, every operation is coded and the code itself specifies how the problem is to be solved, which means that pre-coded models are not called on 
[www.techtarget.com](https://www.techtarget.com/whatis/definition/imperative-programming#:~:text=Imperative%20programming%20is%20a%20software,models%20are%20not%20called%20on.).

## Piece of Code

### room.addActionListener(onclick ->{
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

   ###     }); // actionListener
   
   ## Database Details 
   **The database used in this project is Maria Db  through [Xampp](https://www.apachefriends.org/)**
   - String username = "root";
   - String password = "";
   -  String databaseUrl = "jdbc:mysql://localhost:3306/signup";

