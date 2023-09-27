/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

import hotelmanagementsystem.model.Company;
import hotelmanagementsystem.model.Currency;
import hotelmanagementsystem.model.Customer;
import hotelmanagementsystem.model.Floor;
import hotelmanagementsystem.model.Group;
import hotelmanagementsystem.model.Room;
import hotelmanagementsystem.model.RoomRate;
import hotelmanagementsystem.model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Lenovo
 */
public class DataAccessDB {
    public static Connection getDBConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        try {
            String DriverName = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/hms";
            String user = "root";
            String pass = "root";
            Class.forName(DriverName);
            
            connection = DriverManager.getConnection(url, user, pass);
            
        }catch(ClassNotFoundException cnf){
            System.out.println(cnf.getMessage());
            System.exit(1);
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.exit(1);
        }
        return connection;
    }
    
    public static ResultSet SQLSelect(String sql)throws ClassNotFoundException, SQLException {
        ResultSet rs = null;
        try {
            Statement stmt = getDBConnection().createStatement();
            rs = stmt.executeQuery(sql);            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException cnf){
            System.out.println(cnf.getMessage());
        }
        return rs;
    }
    
    //Get All Room Data FROM DB
    public ObservableList<Room> RetrieveAllRoomsListData() throws ClassNotFoundException, SQLException{
        String sql = "SELECT * FROM room ORDER BY roomNumber";
        ResultSet rs = SQLSelect(sql);
        ObservableList<Room> listdata = FXCollections.observableArrayList();
        
        while(rs.next()){
            listdata.add(new Room(
                    rs.getString("roomNumber"),
                    rs.getString("roomType"),
                    rs.getString("floorNo"),
                    rs.getString("status"),
                    rs.getDouble("price"),
                    rs.getDate("lastUpdated").toLocalDate()
            ));
        }
        rs.close();
        return listdata;
    }  
    
    //Get All Room Data FROM DB
    public ObservableList<RoomRate> RetrieveAllRoomRateData() throws ClassNotFoundException, SQLException{
        String sql = "SELECT * FROM room_rate ORDER BY rate_code";
        ResultSet rs = SQLSelect(sql);
        ObservableList<RoomRate> listdata = FXCollections.observableArrayList();
        
        while(rs.next()){
            listdata.add(new RoomRate(
                    rs.getString("rate_code"),
                    rs.getString("rate_code_nm"),
                    rs.getString("roomType"),
                    rs.getDouble("price_mmr"),
                    rs.getDouble("price_dollar"),
                    rs.getDate("lastUpdated").toLocalDate()
            ));
        }
        rs.close();
        return listdata;
    }
    
    //Get All Floor Data FROM DB
    public ObservableList<Floor> RetrieveAllFloorInfo() throws ClassNotFoundException, SQLException{
        String sql = "SELECT floorNo, count(roomNumber) AS count, roomType from room group by floorNo, roomType ORDER BY floorNo;";
        ResultSet rs = SQLSelect(sql);
        ObservableList<Floor> listdata = FXCollections.observableArrayList();
        
        while(rs.next()){
            listdata.add(new Floor(
                    rs.getString("floorNo"),
                    rs.getInt("count"),
                    rs.getString("roomType")
            ));
        }
        rs.close();
        return listdata;
    }
    
    //Get All Company Data FROM DB
    public ObservableList<Group> RetrieveAllGroupsData() throws ClassNotFoundException, SQLException{
        String sql = "SELECT * FROM group_info ORDER BY groupID";
        ResultSet rs = SQLSelect(sql);
        ObservableList<Group> listdata = FXCollections.observableArrayList();
        
        while(rs.next()){
            listdata.add(new Group(
                    rs.getString("groupID"),
                    rs.getString("groupNm"),
                    rs.getString("email"),
                    rs.getString("phoneNo"),
                    rs.getString("address"),
                    rs.getString("specialRemark"),
                    rs.getDate("lastUpdated").toLocalDate()
            ));
        }
        rs.close();
        return listdata;
    } 
    
    //Get All Company Data FROM DB
    public ObservableList<Company> RetrieveAllCompanyData() throws ClassNotFoundException, SQLException{
        String sql = "SELECT * FROM company_info ORDER BY companyID";
        ResultSet rs = SQLSelect(sql);
        ObservableList<Company> listdata = FXCollections.observableArrayList();
        
        while(rs.next()){
            listdata.add(new Company(
                    rs.getString("companyID"),
                    rs.getString("companyNm"),
                    rs.getString("email"),
                    rs.getString("phoneNo"),
                    rs.getString("address"),
                    rs.getString("specialRemark"),
                    rs.getDate("lastUpdated").toLocalDate()
            ));
        }
        rs.close();
        return listdata;
    } 
    
    public ObservableList<User> RetrieveAllUsersData() throws ClassNotFoundException, SQLException{
        String sql = "SELECT * FROM user ORDER BY user_id";
        ResultSet rs = SQLSelect(sql);
        ObservableList<User> listdata = FXCollections.observableArrayList();
        
        while(rs.next()){
            listdata.add(new User(
                    rs.getInt("user_id"),
                    rs.getString("user_nm"),
                    rs.getString("position"),
                    rs.getString("phoneNo")
            ));
        }
        rs.close();
        return listdata;
    } 
    
    //Get All Customer Data FROM DB
    public ObservableList<Customer> RetrieveAllCustomersListData() throws ClassNotFoundException, SQLException{
        String sql = "SELECT * FROM customer ORDER BY customer_id";
        ResultSet rs = SQLSelect(sql);
        ObservableList<Customer> listdata = FXCollections.observableArrayList();
        
        while(rs.next()){
            listdata.add(new Customer(
                    rs.getInt("customer_id"),
                    rs.getString("firstName"),
                    rs.getString("lastName"),
                    rs.getString("nrcNo"),
                    rs.getString("passportNo"),
                    rs.getString("gender"),
                    rs.getString("address"),
                    rs.getString("country"),
                    rs.getString("nationality"),
                    rs.getString("telephoneNo"),                                  
                    rs.getDate("birthday").toLocalDate(),
                    rs.getString("specialRemark")
            ));
        }
        rs.close();
        return listdata;
    } 
    
    public ObservableList<Currency> RetrieveAllCurrencyListData() throws ClassNotFoundException, SQLException{
        String sql = "SELECT * FROM currency_rate ORDER BY id";
        ResultSet rs = SQLSelect(sql);
        ObservableList<Currency> listdata = FXCollections.observableArrayList();
        
        while(rs.next()){
            listdata.add(new Currency(
                    rs.getDate("date").toLocalDate(),                    
                    rs.getDouble("amount"),
                    rs.getDate("validity_start_date").toLocalDate(),
                    rs.getDate("validity_end_date").toLocalDate()
            ));
        }
        rs.close();
        return listdata;
    }
    
    public ObservableList<Room> RetrieveRoomCount() throws ClassNotFoundException, SQLException {
        String sql = "SELECT COUNT(status) AS count, status FROM room GROUP BY status";
        ResultSet rs = SQLSelect(sql);
        ObservableList<Room> roomCountList = FXCollections.observableArrayList();
        while(rs.next()){
            roomCountList.add(new Room(
                    rs.getInt("count"),
                    rs.getString("status")
            ));
        }
        rs.close();
        return roomCountList;
    }
    
    public Currency RetrieveCurrencyData() throws ClassNotFoundException, SQLException{
        String sql = "SELECT id, date, amount,validity_end_date FROM currency_rate ORDER BY id DESC LIMIT 1;";
        ResultSet rs = SQLSelect(sql);
        Currency currency = new Currency();
        rs.next();
        currency.setDate(rs.getDate("date").toLocalDate());
        currency.setAmt(rs.getDouble("amount"));
        currency.setValidEndDate(rs.getDate("validity_end_date").toLocalDate());
        rs.close();
        return currency;
    }
    
    public boolean SaveRoomData(Room room)throws ClassNotFoundException, SQLException{
        String query = "INSERT INTO room(roomNumber,roomType,floorNo,status,price,lastupdated) VALUES ('"+room.getRoomNumber()+"','"+room.getRoomType()+"','"+room.getFloorNumber()+"','"+room.getRoomStatus()+"','"+room.getPrice()+"','"+room.getLastUpdated()+"')";
        boolean chk = ExecuteSQL(query);
        return chk;
    }
    
    public boolean SaveRoomRateData(RoomRate rate)throws ClassNotFoundException, SQLException{
        String query = "INSERT INTO room_rate(rate_code,rate_code_nm,roomType,price_mmr,price_dollar,lastupdated) VALUES ('"+rate.getRateCd()+"','"+rate.getRateCdNm()+"','"+rate.getRoomType()+"','"+rate.getPriceMMR()+"','"+rate.getPriceDollar()+"','"+rate.getLastUpdated()+"')";
        boolean chk = ExecuteSQL(query);
        return chk;
    }
    
    public boolean SaveUserData(User usr)throws ClassNotFoundException, SQLException{
        String query = "INSERT INTO user(user_nm,position,phoneNo) VALUES ('"+usr.getUserName()+"','"+usr.getPosition()+"','"+usr.getPhoneNo()+"')";
        boolean chk = ExecuteSQL(query);
        return chk;
    }
    
    public boolean SaveCurrencyData(Currency cur)throws ClassNotFoundException, SQLException{
        String query = "INSERT INTO currency_rate(date,amount,validity_start_date,validity_end_date) VALUES ('"+cur.getDate()+"','"+cur.getAmt()+"','"+cur.getValidStartDate()+"','"+cur.getValidEndDate()+"')";
        boolean chk = ExecuteSQL(query);
        return chk;
    }
    
    public boolean ExecuteSQL(String sql)throws ClassNotFoundException, SQLException{
        try{
            Statement stmt = getDBConnection().createStatement();
            stmt.executeUpdate(sql);
            return true;
        }catch(SQLException ex){
            throw ex;
        }catch(ClassNotFoundException cnf){
            System.out.println(cnf.getMessage());
            System.exit(1);
        }
        return false;
    }
    
    public boolean UpdateRoomData(Room room) throws ClassNotFoundException, SQLException{
        String sql = "UPDATE room SET roomType='"+room.getRoomType()+"', floorNo='"+room.getFloorNumber()+"', status='"+room.getRoomStatus()+"', price='"+room.getPrice()+"', lastUpdated='"+room.getLastUpdated()+"' WHERE roomNumber='"+room.getRoomNumber()+"'";
        boolean chk = ExecuteSQL(sql) ;
        return chk;        
    }
    
    public boolean UpdateRoomRateData(RoomRate rate) throws ClassNotFoundException, SQLException{
        String sql = "UPDATE room_rate SET rate_code_nm='"+rate.getRateCdNm()+"', roomType='"+rate.getRoomType()+"', price_mmr='"+rate.getPriceMMR()+"', price_dollar='"+rate.getPriceDollar()+"', lastUpdated='"+rate.getLastUpdated()+"' WHERE rate_code='"+rate.getRateCd()+"'";
        boolean chk = ExecuteSQL(sql) ;
        return chk;        
    }
    
    public boolean UpdateUserData(User usr) throws ClassNotFoundException, SQLException{
        String sql = "UPDATE user SET user_nm='"+usr.getUserName()+"', position='"+usr.getPosition()+"', phoneNo='"+usr.getPhoneNo()+"' WHERE user_id='"+usr.getUserId()+"'";
        boolean chk = ExecuteSQL(sql) ;
        return chk;        
    }
    
    public boolean UpdateCurrencyData(Currency currency) throws ClassNotFoundException, SQLException{
        String sql = "UPDATE currency_rate SET amount='"+currency.getAmt()+"', validity_start_date='"+currency.getValidStartDate()+"', validity_end_date='"+currency.getValidEndDate()+"' WHERE date='"+currency.getDate()+"'";
        boolean chk = ExecuteSQL(sql) ;
        return chk;        
    }
    
    public boolean DeleteRoomData(String roomNo) throws ClassNotFoundException, SQLException{
        String sql = "DELETE FROM room WHERE roomNumber='"+roomNo+"'";
        boolean chk = ExecuteSQL(sql);
        return chk;
    }
    
    public boolean DeleteRoomRateData(String rateCd) throws ClassNotFoundException, SQLException{
        String sql = "DELETE FROM room_rate WHERE rate_code='"+rateCd+"'";
        boolean chk = ExecuteSQL(sql);
        return chk;
    }
    
    public boolean DeleteUserData(int id) throws ClassNotFoundException, SQLException{
        String sql = "DELETE FROM user WHERE user_id='"+id+"'";
        boolean chk = ExecuteSQL(sql);
        return chk;
    }
    
    public boolean DeleteCurrencyData(LocalDate currentdate) throws ClassNotFoundException, SQLException{
        String sql = "DELETE FROM currency_rate WHERE date='"+currentdate+"'";
        boolean chk = ExecuteSQL(sql);
        return chk;
    }
    
    public boolean DeleteAllRoomsData() throws ClassNotFoundException, SQLException{
        String sql = "DELETE FROM room";
        boolean chk = ExecuteSQL(sql);
        return chk;
    }
}
