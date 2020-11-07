import java.sql.*;
import java.lang.Exception;
import javax.swing.JOptionPane;
class DynamicInsertPST {
 public static void main(String[] args) throws Exception {
 Class.forName("com.mysql.jdbc.Driver").newInstance();
 Connection con =
DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?user=root&password=3115");

 String n=JOptionPane.showInputDialog("Enter Name:");
 String i1=JOptionPane.showInputDialog("Enter item 1:");
 String i2=JOptionPane.showInputDialog("Enter item 2:");
 String i3=JOptionPane.showInputDialog("Enter item 3:");
 String s=JOptionPane.showInputDialog("Enter Estimated Budget:");
 float fs=Float.parseFloat(s);
String p=JOptionPane.showInputDialog("Enter Phone no:");
long d=Long.parseLong(p);
String a=JOptionPane.showInputDialog("Enter Address:");
 //NOTE: recommended
 // ? : place holder or parameter (parameterized query)
 String sql = "INSERT INTO Shoppin1(name,item1,item2,item3,Budget,phone_no,address) VALUE(?,?,?,?,?,?,?)";
 PreparedStatement st = con.prepareStatement(sql);
 //bind data in PST
 st.setString(1, n);
 st.setString(2, i1);
 st.setString(3, i2);
 st.setString(4, i3);
 st.setFloat(5, fs);
 st.setLong(6, d);
 st.setString(7, a);
 st.executeUpdate(); //no agrument
 st.close();
 con.close();
 System.out.println("---SQL executed successfully---");
 }
}