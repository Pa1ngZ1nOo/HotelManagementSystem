/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import hotelmanagementsystem.model.Company;
import hotelmanagementsystem.model.Currency;
import hotelmanagementsystem.model.Customer;
import hotelmanagementsystem.model.Floor;
import hotelmanagementsystem.model.Group;
import hotelmanagementsystem.model.Room;
import hotelmanagementsystem.model.RoomRate;
import hotelmanagementsystem.model.User;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.DateCell;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.StringConverter;

/**
 *
 * @author Lenovo
 */
public class dashBoardController implements Initializable {

    @FXML
    private Label username;

    @FXML
    private AnchorPane SRoomData_Form;

    @FXML
    private AnchorPane SRoomView_Form;

    @FXML
    private AnchorPane SRoomRate_Form;

    @FXML
    private AnchorPane SFloorData_Form;

    @FXML
    private AnchorPane SGroupInfo_Form;

    @FXML
    private AnchorPane SCompanyInfo_Form;

    @FXML
    private AnchorPane SCustomerInfo_Form;

    @FXML
    private AnchorPane SUserInfo_Form;

    @FXML
    private AnchorPane SCurrencyRate_Form;

    @FXML
    private JFXButton FloorData_btn;

    @FXML
    private JFXButton GroupInfo_btn;

    @FXML
    private JFXButton CompanyInfo_btn;

    @FXML
    private JFXButton CustomerInfo_btn;

    @FXML
    private JFXButton UserData_btn;

    @FXML
    private JFXButton CurrencyRate_btn;

    @FXML
    private JFXButton Logout_btn;

    @FXML
    private JFXButton RoomData_btn;

    @FXML
    private JFXButton RoomView_btn;

    @FXML
    private JFXButton RoomRate_btn;

    @FXML
    private AnchorPane roomData_Form;

    @FXML
    private TextField RoomData_roomNo;

    @FXML
    private ComboBox<String> RoomData_FloorNo;

    @FXML
    private ComboBox<String> RoomData_roomType;

    @FXML
    private ComboBox<String> RoomData_RoomStatus;

    @FXML
    private TextField RoomData_RoomPrice;

    @FXML
    private JFXDatePicker RoomData_LastUpdated;

    @FXML
    private JFXButton RoomData_addBtn;

    @FXML
    private JFXButton RoomData_UpdateBtn;

    @FXML
    private JFXButton RoomData_ClearBtn;

    @FXML
    private JFXButton RoomData_DeleteBtn;

    @FXML
    private JFXButton RoomData_DeleteAllBtn;

    @FXML
    private TableView<Room> RoomData_TableView;

    @FXML
    private TableColumn<Room, String> RoomData_col_RoomNo;

    @FXML
    private TableColumn<Room, String> RoomData_col_RoomType;

    @FXML
    private TableColumn<Room, String> RoomData_col_RoomStatus;

    @FXML
    private TableColumn<Room, String> RoomData_col_RoomPrice;

    @FXML
    private TableColumn<Room, String> RoomData_col_FloorNo;

    @FXML
    private TableColumn<Room, String> RoomData_col_LastUpdated;

    @FXML
    private TextField RoomData_search;

    @FXML
    private Label roomView_totalCount;

    @FXML
    private Label roomView_RESVCount;

    @FXML
    private Label roomView_VCCount;

    @FXML
    private Label roomView_OCCount;

    @FXML
    private Label roomView_HUCount;

    @FXML
    private Label roomView_SOCount;

    @FXML
    private Label roomView_COCount;

    @FXML
    private Label roomView_VDCount;

    @FXML
    private Label roomView_CIPCount;

    @FXML
    private Label roomView_OOOCount;

    @FXML
    private TableView<RoomRate> roomRate_TableView;

    @FXML
    private TableColumn<RoomRate, String> roomRate_col_rateCode;

    @FXML
    private TableColumn<RoomRate, String> roomRate_col_rateCodeNm;

    @FXML
    private TableColumn<RoomRate, String> roomRate_col_roomType;

    @FXML
    private TableColumn<RoomRate, String> roomRate_col_priceMMR;

    @FXML
    private TableColumn<RoomRate, String> roomRate_col_priceDollar;

    @FXML
    private TableColumn<RoomRate, String> roomRate_col_lastUpdated;

    @FXML
    private TextField roomRate_search;

    @FXML
    private TextField roomRate_rateCode;

    @FXML
    private TextField roomRate_rateCodeNm;

    @FXML
    private TextField roomRate_priceMMR;

    @FXML
    private TextField roomRate_priceDollar;

    @FXML
    private JFXDatePicker roomRate_lastUpdated;

    @FXML
    private JFXButton roomRate_saveBtn;

    @FXML
    private JFXButton roomRate_clearBtn;

    @FXML
    private JFXButton roomRate_updateBtn;

    @FXML
    private JFXButton roomRate_deleteBtn;

    @FXML
    private ComboBox<String> roomRate_roomType;

    @FXML
    private AnchorPane SfloorData_Form;

    @FXML
    private TableView<Floor> FloorInformation_TableView;

    @FXML
    private TableColumn<Floor, String> FloorInformation_col_floorNo;

    @FXML
    private TableColumn<Floor, String> FloorInformation_col_roomCount;

    @FXML
    private TableColumn<Floor, String> FloorInformation_col_roomType;

    @FXML
    private TextField FloorInformation_Search;

    @FXML
    private Label FloorInformation_floor;

    @FXML
    private Label FloorInformation_roomG;

    @FXML
    private Label FloorInformation_standardRoomG;

    @FXML
    private Label FloorInformation_doubleRoomG;

    @FXML
    private Label FloorInformation_deluxRoomG;

    @FXML
    private Label FloorInformation_executiveRoomG;

    @FXML
    private Label FloorInformation_roomF;

    @FXML
    private Label FloorInformation_standardRoomF;

    @FXML
    private Label FloorInformation_doubleRoomF;

    @FXML
    private Label FloorInformation_deluxRoomF;

    @FXML
    private Label FloorInformation_executiveRoomF;

    @FXML
    private Label FloorInformation_roomS;

    @FXML
    private Label FloorInformation_standardRoomS;

    @FXML
    private Label FloorInformation_doubleRoomS;

    @FXML
    private Label FloorInformation_deluxRoomS;

    @FXML
    private Label FloorInformation_executiveRoomS;

    @FXML
    private Label FloorInformation_roomT;

    @FXML
    private Label FloorInformation_standardRoomT;

    @FXML
    private Label FloorInformation_doubleRoomT;

    @FXML
    private Label FloorInformation_deluxRoomT;

    @FXML
    private Label FloorInformation_executiveRoomT;

    @FXML
    private Label FloorInformation_roomFo;

    @FXML
    private Label FloorInformation_standardRoomFou;

    @FXML
    private Label FloorInformation_doubleRoomFou;

    @FXML
    private Label FloorInformation_deluxRoomFou;

    @FXML
    private Label FloorInformation_executiveRoomFou;

    @FXML
    private Label FloorInformation_roomFif;

    @FXML
    private Label FloorInformation_standardRoomFif;

    @FXML
    private Label FloorInformation_doubleRoomFif;

    @FXML
    private Label FloorInformation_deluxRoomFif;

    @FXML
    private Label FloorInformation_executiveRoomFif;

    @FXML
    private TableView<Group> groupInfo_TableView;

    @FXML
    private TableColumn<Group, String> groupInfo_col_groupID;

    @FXML
    private TableColumn<Group, String> groupInfo_col_groupNm;

    @FXML
    private TableColumn<Group, String> groupInfo_col_email;

    @FXML
    private TableColumn<Group, String> groupInfo_col_phoneNo;

    @FXML
    private TableColumn<Group, String> groupInfo_col_address;

    @FXML
    private TableColumn<Group, String> groupInfo_col_specialRemark;

    @FXML
    private TableColumn<Group, String> groupInfo_col_lastUpdated;

    @FXML
    private TextField groupInfo_search;

    @FXML
    private TableView<Company> companyInfo_TableView;

    @FXML
    private TableColumn<Company, String> companyInfo_col_comID;

    @FXML
    private TableColumn<Company, String> companyInfo_col_comNm;

    @FXML
    private TableColumn<Company, String> companyInfo_col_email;

    @FXML
    private TableColumn<Company, String> companyInfo_col_phoneNo;

    @FXML
    private TableColumn<Company, String> companyInfo_col_address;

    @FXML
    private TableColumn<Company, String> companyInfo_col_specialRemark;

    @FXML
    private TableColumn<Company, String> companyInfo_col_date;

    @FXML
    private TextField companyInfo_search;

    @FXML
    private AnchorPane ScustomerData_Form;

    @FXML
    private TableView<Customer> CustomerData_TableView;

    @FXML
    private TableColumn<?, ?> CustomerData_col_customerID;

    @FXML
    private TableColumn<?, ?> CustomerData_col_firstName;

    @FXML
    private TableColumn<?, ?> CustomerData_col_lastName;

    @FXML
    private TableColumn<?, ?> CustomerData_col_nrcNo;

    @FXML
    private TableColumn<?, ?> CustomerData_col_passportNo;

    @FXML
    private TableColumn<?, ?> CustomerData_col_gender;

    @FXML
    private TableColumn<?, ?> CustomerData_col_address;

    @FXML
    private TableColumn<?, ?> CustomerData_col_country;

    @FXML
    private TableColumn<?, ?> CustomerData_col_nationality;

    @FXML
    private TableColumn<?, ?> CustomerData_col_telephoneNo;

    @FXML
    private TableColumn<?, ?> CustomerData_col_birthday;

    @FXML
    private TableColumn<?, ?> CustomerData_col_specialRemark;

    @FXML
    private TextField CustomerData_search;

    @FXML
    private AnchorPane SuserInfo_Form;

    @FXML
    private TableView<User> userData_TableView;

    @FXML
    private TableColumn<User, String> userData_col_userId;

    @FXML
    private TableColumn<User, String> userData_col_userName;

    @FXML
    private TableColumn<User, String> userData_col_position;

    @FXML
    private TableColumn<User, String> userData_col_phoneNo;

    @FXML
    private JFXButton userData_addBtn;

    @FXML
    private JFXButton userData_clearBtn;

    @FXML
    private JFXButton userData_updateBtn;

    @FXML
    private JFXButton userData_deleteBtn;

    @FXML
    private TextField userData_search;

    @FXML
    private TextField userData_userName;

    @FXML
    private TextField userData_position;

    @FXML
    private TextField userData_birthday;

    @FXML
    private TextField userData_phoneNo;

    @FXML
    private JFXDatePicker userData_startDate;

    @FXML
    private AnchorPane ScurrencyRate_Form;

    @FXML
    private Label currencyRate_mmr;

    @FXML
    private TextField currencyRate_todayDate;

    @FXML
    private ComboBox<?> currencyRate_currency;

    @FXML
    private ComboBox<?> currencyRate_status;

    @FXML
    private JFXButton currencyRate_clearBtn;

    @FXML
    private JFXButton currencyRate_addBtn;

    @FXML
    private JFXButton currencyRate_updateBtn;

    @FXML
    private JFXButton currencyRate_deleteBtn;

    @FXML
    private TextField currencyRate_amount;

    @FXML
    private TableView<Currency> currencyRate_tableView;

    @FXML
    private JFXDatePicker currencyRate_validStart;

    @FXML
    private JFXDatePicker currencyRate_validEnd;

    @FXML
    private TableColumn<Currency, String> currencyRate_col_date;

    @FXML
    private TableColumn<Currency, String> currencyRate_col_amount;

    @FXML
    private TableColumn<Currency, String> currencyRate_col_validStart;

    @FXML
    private TableColumn<Currency, String> currencyRate_col_validEnd;

    @FXML
    private TextField currencyRate_search;

    @FXML
    private AnchorPane Spane_roomView;

    @FXML
    private HBox roomView_groundFloor;

    @FXML
    private HBox roomView_firstFloor;

    @FXML
    private HBox roomView_secondFloor;

    @FXML
    private HBox roomView_thirdFloor;

    @FXML
    private HBox roomView_fourthFloor;

    @FXML
    private HBox roomView_fifthFloor;

    @FXML
    private HBox roomView_standardRooms;

    @FXML
    private HBox roomView_doubleRooms;

    @FXML
    private HBox roomView_deluxRooms;

    @FXML
    private HBox roomView_executiveRooms;

    private Button selectedBtn = null;

    private ObservableList<Room> roomDataList = null;
    private ObservableList<Room> roomCountList = null;
    private ObservableList<RoomRate> roomRateDataList = null;
    private ObservableList<Floor> floorDataList = null;
    private ObservableList<Group> groupDataList = null;
    private ObservableList<Company> companyDataList = null;
    private ObservableList<Customer> customerDataList = null;
    private ObservableList<User> userDataList = null;
    private ObservableList<Currency> currencyDataList = null;

    private final String[] typeList = {"Standard Room", "Double Room", "Delux Room", "Executive Room"};
    private final String[] floorList = {"Ground", "First", "Second", "Third", "Fourth", "Fifth"};
    private final String[] statusList = {"Reservation", "Vacant Clean", "Occupied", "House Use", "Sleep Out", "Check Out", "Vacant Dirty", "Cleaning in progress", "Out of Service"};

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Disable Past Date
//        RoomData_LastUpdated.setDayCellFactory(picker -> new DateCell(){
//            public void updateItem(LocalDate date, boolean empty){
//                super.updateItem(date, true);
//                LocalDate today = LocalDate.now();
//                
//                setDisable(empty || date.compareTo(today) < 0);
//            }
//        });        

        //Input Type to Integer beta.2 START
        RoomData_RoomPrice.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("\\d*")) {
                RoomData_RoomPrice.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        
        roomRate_priceMMR.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue)-> {
            if(!newValue.matches("\\d*")){
                roomRate_priceMMR.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        
        roomRate_priceDollar.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue)-> {
            if(!newValue.matches("\\d*")){
                roomRate_priceDollar.setText(newValue.replaceAll("[\\d]", ""));
            }
        });
        //Input Type to Integer beta.2 END
        

        //Initialize Default Selected Button
        RoomData_btn.getStyleClass().add("btn-menu-selected");

        //For Room Dropdown Data
        RoomType();
        FloorNumber();
        RoomStatus();

        //For Currency Dropdown Data        
        displayCurrencyTodayDate();
        displayCurrencyToday();

        //Formating Default DatePicker
        formatDatePicker(RoomData_LastUpdated);
        formatDatePicker(roomRate_lastUpdated);
        formatDatePicker(currencyRate_validStart);
        formatDatePicker(currencyRate_validEnd);

        try {
            //For Room
            ShowRoomsData();
            ShowRoomsView();
            RoomsDataSearch();

            //For Room Rate
            ShowRoomRatesData();
            RoomRatesDataSearch();

            //For Floor
            ShowFloorData();
            FloorsDataSearch();

            //For Group
            ShowGroupsData();
            GroupsDataSearch();

            //For Company
            ShowCompanyData();
            CompanyDataSearch();

            //For Customer
            ShowCustomersData();
            CustomersDataSearch();

            //For User
            ShowUsersData();
            UsersDataSearch();

            //For Currency
            ShowCurrencyData();
            CurrencyDataSearch();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void formatDatePicker(JFXDatePicker datepicker) {
        datepicker.setDayCellFactory(picker -> new DateCell() {
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, true);
                LocalDate today = LocalDate.now();

                setDisable(empty || date.compareTo(today) < 0);
            }
        });

        String pattern = "dd/MM/yyyy";
        datepicker.setPromptText(pattern.toLowerCase());
        datepicker.setConverter(new StringConverter<LocalDate>() {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);

            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dtf.format(date);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dtf);
                } else {
                    return null;
                }
            }
        });
        datepicker.setEditable(false);
    }

    public void RoomType() {
        List<String> listdata = new ArrayList<>();
        for (String data : typeList) {
            listdata.add(data);
        }
        ObservableList list = FXCollections.observableArrayList(listdata);
        RoomData_roomType.setItems(list);
        roomRate_roomType.setItems(list);
    }

    public void FloorNumber() {
        List<String> listdata = new ArrayList<>();
        for (String data : floorList) {
            listdata.add(data);
        }
        ObservableList list = FXCollections.observableArrayList(listdata);
        RoomData_FloorNo.setItems(list);
    }

    public void RoomStatus() {
        List<String> listdata = new ArrayList<>();
        for (String data : statusList) {
            listdata.add(data);
        }
        ObservableList list = FXCollections.observableArrayList(listdata);
        RoomData_RoomStatus.setItems(list);
    }

    public void displayCurrencyTodayDate() {
        DateFormat formatD = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        currencyRate_todayDate.setText(formatD.format(date));
        currencyRate_validStart.setValue(LocalDate.now());
        currencyRate_validEnd.setValue(LocalDate.now());
        currencyRate_todayDate.setDisable(true);
    }

    public void displayCurrencyToday() {
        try {
            DataAccessDB da = new DataAccessDB();
            Currency currency = da.RetrieveCurrencyData();
            String input = currencyRate_todayDate.getText();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate ltCurrency = LocalDate.parse(input, formatter);
//            Date formattedDate = new SimpleDateFormat("yyyy-MM-dd").parse(input);
            if (currency.getValidEndDate() != null) {
                if (currency.getValidEndDate().compareTo(ltCurrency) >= 0) {
                    currencyRate_mmr.setText(String.valueOf(currency.getAmt()));
                } else {
                    currencyRate_mmr.setText("0.0");
                }
            }
//            else if(currency.getValidEndDate()==null){
//                if(currency.getDate().compareTo(ltCurrency) == 0){
//                    currencyRate_todayDate.setText(String.valueOf(currency.getAmt()));
//                }else{
//                    currencyRate_todayDate.setText("0.0");
//                }
//            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void switchSubForm(ActionEvent event) throws ClassNotFoundException, SQLException {
        //Hightlight Color
        Button clickedButton = (Button) event.getSource();
        RoomData_btn.getStyleClass().remove("btn-menu-selected");

        if (selectedBtn != null) {
            selectedBtn.getStyleClass().remove("btn-menu-selected");
        }

        clickedButton.getStyleClass().add("btn-menu-selected");

        selectedBtn = clickedButton;

        //Switch Form
        if (event.getSource() == RoomData_btn) {
            SRoomData_Form.setVisible(true);
            SRoomView_Form.setVisible(false);
            SRoomRate_Form.setVisible(false);
            SFloorData_Form.setVisible(false);
            SGroupInfo_Form.setVisible(false);
            SCompanyInfo_Form.setVisible(false);
            SCustomerInfo_Form.setVisible(false);
            SUserInfo_Form.setVisible(false);
            SCurrencyRate_Form.setVisible(false);
            ShowRoomsData();
            RoomsDataSearch();
        } else if (event.getSource() == RoomView_btn) {
            SRoomData_Form.setVisible(false);
            SRoomView_Form.setVisible(true);
            SRoomRate_Form.setVisible(false);
            SFloorData_Form.setVisible(false);
            SGroupInfo_Form.setVisible(false);
            SCompanyInfo_Form.setVisible(false);
            SCustomerInfo_Form.setVisible(false);
            SUserInfo_Form.setVisible(false);
            SCurrencyRate_Form.setVisible(false);
            ShowRoomsView();
        } else if (event.getSource() == RoomRate_btn) {
            SRoomData_Form.setVisible(false);
            SRoomView_Form.setVisible(false);
            SRoomRate_Form.setVisible(true);
            SFloorData_Form.setVisible(false);
            SGroupInfo_Form.setVisible(false);
            SCompanyInfo_Form.setVisible(false);
            SCustomerInfo_Form.setVisible(false);
            SUserInfo_Form.setVisible(false);
            SCurrencyRate_Form.setVisible(false);
            ShowRoomRatesData();
            RoomRatesDataSearch();
        } else if (event.getSource() == FloorData_btn) {
            SRoomData_Form.setVisible(false);
            SRoomView_Form.setVisible(false);
            SRoomRate_Form.setVisible(false);
            SFloorData_Form.setVisible(true);
            SGroupInfo_Form.setVisible(false);
            SCompanyInfo_Form.setVisible(false);
            SCustomerInfo_Form.setVisible(false);
            SUserInfo_Form.setVisible(false);
            SCurrencyRate_Form.setVisible(false);
            ShowFloorData();
            FloorsDataSearch();
        } else if (event.getSource() == GroupInfo_btn) {
            SRoomData_Form.setVisible(false);
            SRoomView_Form.setVisible(false);
            SRoomRate_Form.setVisible(false);
            SFloorData_Form.setVisible(false);
            SGroupInfo_Form.setVisible(true);
            SCompanyInfo_Form.setVisible(false);
            SCustomerInfo_Form.setVisible(false);
            SUserInfo_Form.setVisible(false);
            SCurrencyRate_Form.setVisible(false);
            ShowGroupsData();
            GroupsDataSearch();
        } else if (event.getSource() == CompanyInfo_btn) {
            SRoomData_Form.setVisible(false);
            SRoomView_Form.setVisible(false);
            SRoomRate_Form.setVisible(false);
            SFloorData_Form.setVisible(false);
            SGroupInfo_Form.setVisible(false);
            SCompanyInfo_Form.setVisible(true);
            SCustomerInfo_Form.setVisible(false);
            SUserInfo_Form.setVisible(false);
            SCurrencyRate_Form.setVisible(false);
            ShowCompanyData();
            CompanyDataSearch();
        } else if (event.getSource() == CustomerInfo_btn) {
            SRoomData_Form.setVisible(false);
            SRoomView_Form.setVisible(false);
            SRoomRate_Form.setVisible(false);
            SFloorData_Form.setVisible(false);
            SGroupInfo_Form.setVisible(false);
            SCompanyInfo_Form.setVisible(false);
            SCustomerInfo_Form.setVisible(true);
            SUserInfo_Form.setVisible(false);
            SCurrencyRate_Form.setVisible(false);
            ShowCustomersData();
            CustomersDataSearch();
        } else if (event.getSource() == UserData_btn) {
            SRoomData_Form.setVisible(false);
            SRoomView_Form.setVisible(false);
            SRoomRate_Form.setVisible(false);
            SFloorData_Form.setVisible(false);
            SGroupInfo_Form.setVisible(false);
            SCompanyInfo_Form.setVisible(false);
            SCustomerInfo_Form.setVisible(false);
            SUserInfo_Form.setVisible(true);
            SCurrencyRate_Form.setVisible(false);
            ShowUsersData();
            UsersDataSearch();
        } else if (event.getSource() == CurrencyRate_btn) {
            SRoomData_Form.setVisible(false);
            SRoomView_Form.setVisible(false);
            SRoomRate_Form.setVisible(false);
            SFloorData_Form.setVisible(false);
            SGroupInfo_Form.setVisible(false);
            SCompanyInfo_Form.setVisible(false);
            SCustomerInfo_Form.setVisible(false);
            SUserInfo_Form.setVisible(false);
            SCurrencyRate_Form.setVisible(true);
            ShowCurrencyData();
            CurrencyDataSearch();
        }
    }

    public void Logout(ActionEvent event) throws IOException {
        try {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            Stage owner = Stage.class.cast(Control.class.cast(event.getSource()).getScene().getWindow());
            alert.initOwner(owner);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {
                Parent root = FXMLLoader.load(getClass().getResource("LOGINFXML.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Hotel Management System");
                stage.getIcons().add(new Image("/image/LOGO.png"));
                stage.setResizable(false);
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

                Logout_btn.getScene().getWindow().hide();
            } else {
                return;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public double ParseDouble(String str) {
        if (str != null && str.length() > 0) {
            try {
                return Double.parseDouble(str);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return -1;
            }
        } else {
            return 0;
        }
    }

    public void ShowRoomsView() throws ClassNotFoundException, SQLException {
        List<Button> btnGroundFloorList = new ArrayList<>();
        List<Button> btnFirstFloorList = new ArrayList<>();
        List<Button> btnSecondFloorList = new ArrayList<>();
        List<Button> btnThirdFloorList = new ArrayList<>();
        List<Button> btnFourthFloorList = new ArrayList<>();
        List<Button> btnFifthFloorList = new ArrayList<>();

        //Count
//        int totalCount = 0;
        int resCount = 0;
        int vcCount = 0;
        int ocCount = 0;
        int huCount = 0;
        int soCount = 0;
        int coCount = 0;
        int vdCount = 0;
        int hkCount = 0;
        int oooCount = 0;

        DataAccessDB da = new DataAccessDB();
        roomCountList = da.RetrieveRoomCount();
        for (Room rC : roomCountList) {
            if (rC.getRoomStatus().equals("Reservation")) {
                resCount = rC.getRoomCount();
            } else if (rC.getRoomStatus().equals("Vacant Clean")) {
                vcCount = rC.getRoomCount();
            } else if (rC.getRoomStatus().equals("Occupied")) {
                ocCount = rC.getRoomCount();
            } else if (rC.getRoomStatus().equals("House Use")) {
                huCount = rC.getRoomCount();
            } else if (rC.getRoomStatus().equals("Sleep Out")) {
                soCount = rC.getRoomCount();
            } else if (rC.getRoomStatus().equals("Check Out")) {
                coCount = rC.getRoomCount();
            } else if (rC.getRoomStatus().equals("Vacant Dirty")) {
                vdCount = rC.getRoomCount();
            } else if (rC.getRoomStatus().equals("Cleaning in progress")) {
                hkCount = rC.getRoomCount();
            } else if (rC.getRoomStatus().equals("Out of Service")) {
                oooCount = rC.getRoomCount();
            }
        }

        for (Room r : roomDataList) {
            String roomType = r.getRoomType();
            String status = r.getRoomStatus();
            String roomNo = r.getRoomNumber();
            String floorNo = r.getFloorNumber();

            if (floorNo.equals("Ground")) {
                Button groundFloorBtn = new Button();
                groundFloorBtn.getStyleClass().add("room-view");

                if (status.equals("Reservation")) {
                    groundFloorBtn.getStyleClass().add("reservation-color");
                } else if (status.equals("Occupied")) {
                    groundFloorBtn.getStyleClass().add("occupied-color");
                } else if (status.equals("House Use")) {
                    groundFloorBtn.getStyleClass().add("house-use-color");
                } else if (status.equals("Sleep Out")) {
                    groundFloorBtn.getStyleClass().add("sleep-out-color");
                } else if (status.equals("Check Out")) {
                    groundFloorBtn.getStyleClass().add("check-out-color");
                } else if (status.equals("Vacant Dirty")) {
                    groundFloorBtn.getStyleClass().add("vacant-dirty-color");
                } else if (status.equals("Cleaning in progress")) {
                    groundFloorBtn.getStyleClass().add("cleaning-color");
                } else if (status.equals("Out of Service")) {
                    groundFloorBtn.getStyleClass().add("ooo-color");
                }

                if (roomType.equals("Standard Room")) {
                    groundFloorBtn.setText(roomNo + "\nSt.");

                } else if (roomType.equals("Double Room")) {
                    groundFloorBtn.setText(roomNo + "\nDo.");
                } else if (roomType.equals("Delux Room")) {
                    groundFloorBtn.setText(roomNo + "\nDx.");
                } else {
                    groundFloorBtn.setText(roomNo + "\nEx.");
                }

                btnGroundFloorList.add(groundFloorBtn);
            }

            if (floorNo.equals("First")) {
                Button firstFloorBtn = new Button();
                firstFloorBtn.getStyleClass().add("room-view");

                if (status.equals("Reservation")) {
                    firstFloorBtn.getStyleClass().add("reservation-color");
                } else if (status.equals("Occupied")) {
                    firstFloorBtn.getStyleClass().add("occupied-color");
                } else if (status.equals("House Use")) {
                    firstFloorBtn.getStyleClass().add("house-use-color");
                } else if (status.equals("Sleep Out")) {
                    firstFloorBtn.getStyleClass().add("sleep-out-color");
                } else if (status.equals("Check Out")) {
                    firstFloorBtn.getStyleClass().add("check-out-color");
                } else if (status.equals("Vacant Dirty")) {
                    firstFloorBtn.getStyleClass().add("vacant-dirty-color");
                } else if (status.equals("Cleaning in progress")) {
                    firstFloorBtn.getStyleClass().add("cleaning-color");
                } else if (status.equals("Out of Service")) {
                    firstFloorBtn.getStyleClass().add("ooo-color");
                }

                if (roomType.equals("Standard Room")) {
                    firstFloorBtn.setText(roomNo + "\nSt.");
                } else if (roomType.equals("Double Room")) {
                    firstFloorBtn.setText(roomNo + "\nDo.");
                } else if (roomType.equals("Delux Room")) {
                    firstFloorBtn.setText(roomNo + "\nDx.");
                } else {
                    firstFloorBtn.setText(roomNo + "\nEx.");
                }

                btnFirstFloorList.add(firstFloorBtn);
            }

            if (floorNo.equals("Second")) {
                Button secondFloorBtn = new Button();
                secondFloorBtn.getStyleClass().add("room-view");

                if (status.equals("Reservation")) {
                    secondFloorBtn.getStyleClass().add("reservation-color");
                } else if (status.equals("Occupied")) {
                    secondFloorBtn.getStyleClass().add("occupied-color");
                } else if (status.equals("House Use")) {
                    secondFloorBtn.getStyleClass().add("house-use-color");
                } else if (status.equals("Sleep Out")) {
                    secondFloorBtn.getStyleClass().add("sleep-out-color");
                } else if (status.equals("Check Out")) {
                    secondFloorBtn.getStyleClass().add("check-out-color");
                } else if (status.equals("Vacant Dirty")) {
                    secondFloorBtn.getStyleClass().add("vacant-dirty-color");
                } else if (status.equals("Cleaning in progress")) {
                    secondFloorBtn.getStyleClass().add("cleaning-color");
                } else if (status.equals("Out of Service")) {
                    secondFloorBtn.getStyleClass().add("ooo-color");
                }

                if (roomType.equals("Standard Room")) {
                    secondFloorBtn.setText(roomNo + "\nSt.");
                } else if (roomType.equals("Double Room")) {
                    secondFloorBtn.setText(roomNo + "\nDo.");
                } else if (roomType.equals("Delux Room")) {
                    secondFloorBtn.setText(roomNo + "\nDx.");
                } else {
                    secondFloorBtn.setText(roomNo + "\nEx.");
                }

                btnSecondFloorList.add(secondFloorBtn);
            }

            if (floorNo.equals("Third")) {
                Button thirdFloorBtn = new Button();
                thirdFloorBtn.getStyleClass().add("room-view");

                if (status.equals("Reservation")) {
                    thirdFloorBtn.getStyleClass().add("reservation-color");
                } else if (status.equals("Occupied")) {
                    thirdFloorBtn.getStyleClass().add("occupied-color");
                } else if (status.equals("House Use")) {
                    thirdFloorBtn.getStyleClass().add("house-use-color");
                } else if (status.equals("Sleep Out")) {
                    thirdFloorBtn.getStyleClass().add("sleep-out-color");
                } else if (status.equals("Check Out")) {
                    thirdFloorBtn.getStyleClass().add("check-out-color");
                } else if (status.equals("Vacant Dirty")) {
                    thirdFloorBtn.getStyleClass().add("vacant-dirty-color");
                } else if (status.equals("Cleaning in progress")) {
                    thirdFloorBtn.getStyleClass().add("cleaning-color");
                } else if (status.equals("Out of Service")) {
                    thirdFloorBtn.getStyleClass().add("ooo-color");
                }

                if (roomType.equals("Standard Room")) {
                    thirdFloorBtn.setText(roomNo + "\nSt.");
                } else if (roomType.equals("Double Room")) {
                    thirdFloorBtn.setText(roomNo + "\nDo.");
                } else if (roomType.equals("Delux Room")) {
                    thirdFloorBtn.setText(roomNo + "\nDx.");
                } else {
                    thirdFloorBtn.setText(roomNo + "\nEx.");
                }

                btnThirdFloorList.add(thirdFloorBtn);
            }

            if (floorNo.equals("Fourth")) {
                Button fourthFloorBtn = new Button();
                fourthFloorBtn.getStyleClass().add("room-view");

                if (status.equals("Reservation")) {
                    fourthFloorBtn.getStyleClass().add("reservation-color");
                } else if (status.equals("Occupied")) {
                    fourthFloorBtn.getStyleClass().add("occupied-color");
                } else if (status.equals("House Use")) {
                    fourthFloorBtn.getStyleClass().add("house-use-color");
                } else if (status.equals("Sleep Out")) {
                    fourthFloorBtn.getStyleClass().add("sleep-out-color");
                } else if (status.equals("Check Out")) {
                    fourthFloorBtn.getStyleClass().add("check-out-color");
                } else if (status.equals("Vacant Dirty")) {
                    fourthFloorBtn.getStyleClass().add("vacant-dirty-color");
                } else if (status.equals("Cleaning in progress")) {
                    fourthFloorBtn.getStyleClass().add("cleaning-color");
                } else if (status.equals("Out of Service")) {
                    fourthFloorBtn.getStyleClass().add("ooo-color");
                }

                if (roomType.equals("Standard Room")) {
                    fourthFloorBtn.setText(roomNo + "\nSt.");
                } else if (roomType.equals("Double Room")) {
                    fourthFloorBtn.setText(roomNo + "\nDo.");
                } else if (roomType.equals("Delux Room")) {
                    fourthFloorBtn.setText(roomNo + "\nDx.");
                } else {
                    fourthFloorBtn.setText(roomNo + "\nEx.");
                }

                btnFourthFloorList.add(fourthFloorBtn);
            }

            if (floorNo.equals("Fifth")) {
                Button fifthFloorBtn = new Button();
                fifthFloorBtn.getStyleClass().add("room-view");

                if (status.equals("Reservation")) {
                    fifthFloorBtn.getStyleClass().add("reservation-color");
                } else if (status.equals("Occupied")) {
                    fifthFloorBtn.getStyleClass().add("occupied-color");
                } else if (status.equals("House Use")) {
                    fifthFloorBtn.getStyleClass().add("house-use-color");
                } else if (status.equals("Sleep Out")) {
                    fifthFloorBtn.getStyleClass().add("sleep-out-color");
                } else if (status.equals("Check Out")) {
                    fifthFloorBtn.getStyleClass().add("check-out-color");
                } else if (status.equals("Vacant Dirty")) {
                    fifthFloorBtn.getStyleClass().add("vacant-dirty-color");
                } else if (status.equals("Cleaning in progress")) {
                    fifthFloorBtn.getStyleClass().add("cleaning-color");
                } else if (status.equals("Out of Service")) {
                    fifthFloorBtn.getStyleClass().add("ooo-color");
                }

                if (roomType.equals("Standard Room")) {
                    fifthFloorBtn.setText(roomNo + "\nSt.");
                } else if (roomType.equals("Double Room")) {
                    fifthFloorBtn.setText(roomNo + "\nDo.");
                } else if (roomType.equals("Delux Room")) {
                    fifthFloorBtn.setText(roomNo + "\nDx.");
                } else {
                    fifthFloorBtn.setText(roomNo + "\nEx.");
                }

                btnFifthFloorList.add(fifthFloorBtn);
            }
        }

        roomView_totalCount.setText(String.valueOf(roomDataList.size()));
        roomView_RESVCount.setText(String.valueOf(resCount));
        roomView_VCCount.setText(String.valueOf(vcCount));
        roomView_OCCount.setText(String.valueOf(ocCount));
        roomView_HUCount.setText(String.valueOf(huCount));
        roomView_SOCount.setText(String.valueOf(soCount));
        roomView_COCount.setText(String.valueOf(coCount));
        roomView_VDCount.setText(String.valueOf(vdCount));
        roomView_CIPCount.setText(String.valueOf(hkCount));
        roomView_OOOCount.setText(String.valueOf(oooCount));

        roomView_groundFloor.getChildren().clear();
        roomView_groundFloor.getChildren().addAll(btnGroundFloorList);
        roomView_groundFloor.getStyleClass().add("room-view-gap");

        roomView_firstFloor.getChildren().clear();
        roomView_firstFloor.getChildren().addAll(btnFirstFloorList);
        roomView_firstFloor.getStyleClass().add("room-view-gap");

        roomView_secondFloor.getChildren().clear();
        roomView_secondFloor.getChildren().addAll(btnSecondFloorList);
        roomView_secondFloor.getStyleClass().add("room-view-gap");

        roomView_thirdFloor.getChildren().clear();
        roomView_thirdFloor.getChildren().addAll(btnThirdFloorList);
        roomView_thirdFloor.getStyleClass().add("room-view-gap");

        roomView_fourthFloor.getChildren().clear();
        roomView_fourthFloor.getChildren().addAll(btnFourthFloorList);
        roomView_fourthFloor.getStyleClass().add("room-view-gap");

        roomView_fifthFloor.getChildren().clear();
        roomView_fifthFloor.getChildren().addAll(btnFifthFloorList);
        roomView_fifthFloor.getStyleClass().add("room-view-gap");

    }

    public void ShowRoomsData() throws ClassNotFoundException, SQLException {
        RoomData_LastUpdated.setValue(LocalDate.now()); //beta.2
        DataAccessDB da = new DataAccessDB();
        roomDataList = da.RetrieveAllRoomsListData();

        //Names From Object
        RoomData_col_RoomNo.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        RoomData_col_RoomType.setCellValueFactory(new PropertyValueFactory<>("roomType"));
        RoomData_col_RoomStatus.setCellValueFactory(new PropertyValueFactory<>("roomStatus"));
        RoomData_col_RoomPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        RoomData_col_FloorNo.setCellValueFactory(new PropertyValueFactory<>("floorNumber"));
        RoomData_col_LastUpdated.setCellValueFactory(new PropertyValueFactory<>("lastUpdated"));

        RoomData_TableView.setItems(roomDataList);
    }

    public void ShowRoomRatesData() throws ClassNotFoundException, SQLException {
        roomRate_lastUpdated.setValue(LocalDate.now()); //beta.2
        DataAccessDB da = new DataAccessDB();
        roomRateDataList = da.RetrieveAllRoomRateData();

        //Names From Object
        roomRate_col_rateCode.setCellValueFactory(new PropertyValueFactory<>("rateCd"));
        roomRate_col_rateCodeNm.setCellValueFactory(new PropertyValueFactory<>("rateCdNm"));
        roomRate_col_roomType.setCellValueFactory(new PropertyValueFactory<>("roomType"));
        roomRate_col_priceMMR.setCellValueFactory(new PropertyValueFactory<>("priceMMR"));
        roomRate_col_priceDollar.setCellValueFactory(new PropertyValueFactory<>("priceDollar"));
        roomRate_col_lastUpdated.setCellValueFactory(new PropertyValueFactory<>("lastUpdated"));

        roomRate_TableView.setItems(roomRateDataList);
    }

    public void ShowFloorData() throws ClassNotFoundException, SQLException {
        DataAccessDB da = new DataAccessDB();
        floorDataList = da.RetrieveAllFloorInfo();

        //Names From Object
        FloorInformation_col_floorNo.setCellValueFactory(new PropertyValueFactory<>("floorNo"));
        FloorInformation_col_roomCount.setCellValueFactory(new PropertyValueFactory<>("count"));
        FloorInformation_col_roomType.setCellValueFactory(new PropertyValueFactory<>("roomType"));

        FloorInformation_TableView.setItems(floorDataList);

        //Room Count according to FloorNo
        int roomCountGround = 0;
        int roomCountFirst = 0;
        int roomCountSecond = 0;
        int roomCountThird = 0;
        int roomCountFourth = 0;
        int roomCountFifth = 0;

        //Room Type according to Ground Floor
        int standardCountG = 0;
        int doubleCountG = 0;
        int deluxCountG = 0;
        int executiveCountG = 0;

        //Room Type according to First Floor
        int standardCountF = 0;
        int doubleCountF = 0;
        int deluxCountF = 0;
        int executiveCountF = 0;

        //Room Type according to Second Floor
        int standardCountS = 0;
        int doubleCountS = 0;
        int deluxCountS = 0;
        int executiveCountS = 0;

        //Room Type according to Third Floor
        int standardCountT = 0;
        int doubleCountT = 0;
        int deluxCountT = 0;
        int executiveCountT = 0;

        //Room Type according to Fouth Floor
        int standardCountFou = 0;
        int doubleCountFou = 0;
        int deluxCountFou = 0;
        int executiveCountFou = 0;

        //Room Type according to Fifth Floor
        int standardCountFif = 0;
        int doubleCountFif = 0;
        int deluxCountFif = 0;
        int executiveCountFif = 0;

        for (Floor floorData : floorDataList) {
            if (floorData.getFloorNo().equals("Ground")) {
                if (floorData.getRoomType().equals("Standard Room")) {
                    standardCountG = floorData.getCount();
                } else if (floorData.getRoomType().equals("Double Room")) {
                    doubleCountG = floorData.getCount();
                } else if (floorData.getRoomType().equals("Delux Room")) {
                    deluxCountG = floorData.getCount();
                } else if (floorData.getRoomType().equals("Executive Room")) {
                    executiveCountG = floorData.getCount();
                }

                roomCountGround = roomCountGround + floorData.getCount();
            } else if (floorData.getFloorNo().equals("First")) {
                if (floorData.getRoomType().equals("Standard Room")) {
                    standardCountF = floorData.getCount();
                } else if (floorData.getRoomType().equals("Double Room")) {
                    doubleCountF = floorData.getCount();
                } else if (floorData.getRoomType().equals("Delux Room")) {
                    deluxCountF = floorData.getCount();
                } else if (floorData.getRoomType().equals("Executive Room")) {
                    executiveCountF = floorData.getCount();
                }

                roomCountFirst = roomCountFirst + floorData.getCount();
            } else if (floorData.getFloorNo().equals("Second")) {
                if (floorData.getRoomType().equals("Standard Room")) {
                    standardCountS = floorData.getCount();
                } else if (floorData.getRoomType().equals("Double Room")) {
                    doubleCountS = floorData.getCount();
                } else if (floorData.getRoomType().equals("Delux Room")) {
                    deluxCountS = floorData.getCount();
                } else if (floorData.getRoomType().equals("Executive Room")) {
                    executiveCountS = floorData.getCount();
                }

                roomCountSecond = roomCountSecond + floorData.getCount();
            } else if (floorData.getFloorNo().equals("Third")) {
                if (floorData.getRoomType().equals("Standard Room")) {
                    standardCountT = floorData.getCount();
                } else if (floorData.getRoomType().equals("Double Room")) {
                    doubleCountT = floorData.getCount();
                } else if (floorData.getRoomType().equals("Delux Room")) {
                    deluxCountT = floorData.getCount();
                } else if (floorData.getRoomType().equals("Executive Room")) {
                    executiveCountT = floorData.getCount();
                }

                roomCountThird = roomCountThird + floorData.getCount();
            } else if (floorData.getFloorNo().equals("Fourth")) {
                if (floorData.getRoomType().equals("Standard Room")) {
                    standardCountFou = floorData.getCount();
                } else if (floorData.getRoomType().equals("Double Room")) {
                    doubleCountFou = floorData.getCount();
                } else if (floorData.getRoomType().equals("Delux Room")) {
                    deluxCountFou = floorData.getCount();
                } else if (floorData.getRoomType().equals("Executive Room")) {
                    executiveCountFou = floorData.getCount();
                }

                roomCountFourth = roomCountFourth + floorData.getCount();
            } else if (floorData.getFloorNo().equals("Fifth")) {
                if (floorData.getRoomType().equals("Standard Room")) {
                    standardCountFif = floorData.getCount();
                } else if (floorData.getRoomType().equals("Double Room")) {
                    doubleCountFif = floorData.getCount();
                } else if (floorData.getRoomType().equals("Delux Room")) {
                    deluxCountFif = floorData.getCount();
                } else if (floorData.getRoomType().equals("Executive Room")) {
                    executiveCountFif = floorData.getCount();
                }

                roomCountFifth = roomCountFifth + floorData.getCount();
            }
        }

        //For Ground Floor Info
        FloorInformation_roomG.setText(String.valueOf(roomCountGround));
        FloorInformation_standardRoomG.setText(String.valueOf(standardCountG));
        FloorInformation_doubleRoomG.setText(String.valueOf(doubleCountG));
        FloorInformation_deluxRoomG.setText(String.valueOf(deluxCountG));
        FloorInformation_executiveRoomG.setText(String.valueOf(executiveCountG));

        //For First Floor Info
        FloorInformation_roomF.setText(String.valueOf(roomCountFirst));
        FloorInformation_standardRoomF.setText(String.valueOf(standardCountF));
        FloorInformation_doubleRoomF.setText(String.valueOf(doubleCountF));
        FloorInformation_deluxRoomF.setText(String.valueOf(deluxCountF));
        FloorInformation_executiveRoomF.setText(String.valueOf(executiveCountF));

        //For Second Floor Info
        FloorInformation_roomS.setText(String.valueOf(roomCountSecond));
        FloorInformation_standardRoomS.setText(String.valueOf(standardCountS));
        FloorInformation_doubleRoomS.setText(String.valueOf(doubleCountS));
        FloorInformation_deluxRoomS.setText(String.valueOf(deluxCountS));
        FloorInformation_executiveRoomS.setText(String.valueOf(executiveCountS));

        //For Third Floor Info
        FloorInformation_roomT.setText(String.valueOf(roomCountThird));
        FloorInformation_standardRoomT.setText(String.valueOf(standardCountT));
        FloorInformation_doubleRoomT.setText(String.valueOf(doubleCountT));
        FloorInformation_deluxRoomT.setText(String.valueOf(deluxCountT));
        FloorInformation_executiveRoomT.setText(String.valueOf(executiveCountT));

        //For Fourth Floor Info
        FloorInformation_roomFo.setText(String.valueOf(roomCountFourth));
        FloorInformation_standardRoomFou.setText(String.valueOf(standardCountFou));
        FloorInformation_doubleRoomFou.setText(String.valueOf(doubleCountFou));
        FloorInformation_deluxRoomFou.setText(String.valueOf(deluxCountFou));
        FloorInformation_executiveRoomFou.setText(String.valueOf(executiveCountFou));

        //For Fifth Floor Info
        FloorInformation_roomFif.setText(String.valueOf(roomCountFifth));
        FloorInformation_standardRoomFif.setText(String.valueOf(standardCountFif));
        FloorInformation_doubleRoomFif.setText(String.valueOf(doubleCountFif));
        FloorInformation_deluxRoomFif.setText(String.valueOf(deluxCountFif));
        FloorInformation_executiveRoomFif.setText(String.valueOf(executiveCountFif));
    }

    public void ShowGroupsData() throws ClassNotFoundException, SQLException {
        DataAccessDB da = new DataAccessDB();
        groupDataList = da.RetrieveAllGroupsData();

        //Names From Object
        groupInfo_col_groupID.setCellValueFactory(new PropertyValueFactory<>("groupID"));
        groupInfo_col_groupNm.setCellValueFactory(new PropertyValueFactory<>("groupNm"));
        groupInfo_col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        groupInfo_col_phoneNo.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));
        groupInfo_col_address.setCellValueFactory(new PropertyValueFactory<>("address"));
        groupInfo_col_specialRemark.setCellValueFactory(new PropertyValueFactory<>("specialRemark"));
        groupInfo_col_lastUpdated.setCellValueFactory(new PropertyValueFactory<>("lastUpdated"));

        groupInfo_TableView.setItems(groupDataList);
    }

    public void ShowCompanyData() throws ClassNotFoundException, SQLException {
        DataAccessDB da = new DataAccessDB();
        companyDataList = da.RetrieveAllCompanyData();

        //Names From Object
        companyInfo_col_comID.setCellValueFactory(new PropertyValueFactory<>("companyID"));
        companyInfo_col_comNm.setCellValueFactory(new PropertyValueFactory<>("companyNm"));
        companyInfo_col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        companyInfo_col_phoneNo.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));
        companyInfo_col_address.setCellValueFactory(new PropertyValueFactory<>("address"));
        companyInfo_col_specialRemark.setCellValueFactory(new PropertyValueFactory<>("specialRemark"));
        companyInfo_col_date.setCellValueFactory(new PropertyValueFactory<>("lastUpdated"));

        companyInfo_TableView.setItems(companyDataList);
    }

    public void ShowCustomersData() throws ClassNotFoundException, SQLException {
        DataAccessDB da = new DataAccessDB();
        customerDataList = da.RetrieveAllCustomersListData();

        //Names From Object
        CustomerData_col_customerID.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        CustomerData_col_firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        CustomerData_col_lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        CustomerData_col_nrcNo.setCellValueFactory(new PropertyValueFactory<>("nrcNo"));
        CustomerData_col_passportNo.setCellValueFactory(new PropertyValueFactory<>("passportNo"));
        CustomerData_col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        CustomerData_col_address.setCellValueFactory(new PropertyValueFactory<>("address"));
        CustomerData_col_country.setCellValueFactory(new PropertyValueFactory<>("country"));
        CustomerData_col_nationality.setCellValueFactory(new PropertyValueFactory<>("nationality"));
        CustomerData_col_telephoneNo.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));
        CustomerData_col_birthday.setCellValueFactory(new PropertyValueFactory<>("birthday"));
        CustomerData_col_specialRemark.setCellValueFactory(new PropertyValueFactory<>("specialRemark"));

        CustomerData_TableView.setItems(customerDataList);
    }

    public void ShowUsersData() throws ClassNotFoundException, SQLException {
        DataAccessDB da = new DataAccessDB();
        userDataList = da.RetrieveAllUsersData();

        //Names From Object
        userData_col_userId.setCellValueFactory(new PropertyValueFactory<>("userId"));
        userData_col_userName.setCellValueFactory(new PropertyValueFactory<>("userName"));
        userData_col_position.setCellValueFactory(new PropertyValueFactory<>("position"));
        userData_col_phoneNo.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));

        userData_TableView.setItems(userDataList);
    }

    public void ShowCurrencyData() throws ClassNotFoundException, SQLException {
        DataAccessDB da = new DataAccessDB();
        currencyDataList = da.RetrieveAllCurrencyListData();

        //Names From Object
        currencyRate_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        currencyRate_col_amount.setCellValueFactory(new PropertyValueFactory<>("amt"));
        currencyRate_col_validStart.setCellValueFactory(new PropertyValueFactory<>("validStartDate"));
        currencyRate_col_validEnd.setCellValueFactory(new PropertyValueFactory<>("validEndDate"));

        currencyRate_tableView.setItems(currencyDataList);
    }

    public void GroupsDataSearch() {
        FilteredList<Group> filterData = new FilteredList<>(groupDataList, e -> true);

        groupInfo_search.textProperty().addListener((Observable, oldValue, newValue) -> {

            filterData.setPredicate(predicateGroup -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if (predicateGroup.getGroupID().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateGroup.getGroupNm().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateGroup.getEmail().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateGroup.getPhoneNo().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateGroup.getAddress().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateGroup.getSpecialRemark().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (String.valueOf(predicateGroup.getLastUpdated()).contains(searchKey)) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        SortedList<Group> sortedList = new SortedList<>(filterData);
        sortedList.comparatorProperty().bind(groupInfo_TableView.comparatorProperty());
        groupInfo_TableView.setItems(sortedList);
    }

    public void CompanyDataSearch() {
        FilteredList<Company> filterData = new FilteredList<>(companyDataList, e -> true);

        companyInfo_search.textProperty().addListener((Observable, oldValue, newValue) -> {

            filterData.setPredicate(predicateCompany -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if (predicateCompany.getCompanyID().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateCompany.getCompanyNm().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateCompany.getEmail().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateCompany.getPhoneNo().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateCompany.getAddress().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateCompany.getSpecialRemark().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (String.valueOf(predicateCompany.getLastUpdated()).contains(searchKey)) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        SortedList<Company> sortedList = new SortedList<>(filterData);
        sortedList.comparatorProperty().bind(companyInfo_TableView.comparatorProperty());
        companyInfo_TableView.setItems(sortedList);
    }

    public void CustomersDataSearch() {
        FilteredList<Customer> filterData = new FilteredList<>(customerDataList, e -> true);

        CustomerData_search.textProperty().addListener((Observable, oldValue, newValue) -> {

            filterData.setPredicate(predicateCustomer -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if (String.valueOf(predicateCustomer.getCustomerID()).contains(searchKey)) {
                    return true;
                } else if (predicateCustomer.getFirstName().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateCustomer.getLastName().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateCustomer.getNrcNo().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateCustomer.getPassportNo().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateCustomer.getGender().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateCustomer.getAddress().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateCustomer.getCountry().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateCustomer.getNationality().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateCustomer.getPhoneNo().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (String.valueOf(predicateCustomer.getBirthday()).contains(searchKey)) {
                    return true;
                } else if (predicateCustomer.getSpecialRemark().toLowerCase().contains(searchKey)) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        SortedList<Customer> sortedList = new SortedList<>(filterData);
        sortedList.comparatorProperty().bind(CustomerData_TableView.comparatorProperty());
        CustomerData_TableView.setItems(sortedList);
    }

    //Select Room Data from table to the textField
    public void ShowSelectRoomData() {
        Room r = RoomData_TableView.getSelectionModel().getSelectedItem();
        int num = RoomData_TableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        RoomData_roomNo.setDisable(true);
        RoomData_roomNo.setText(r.getRoomNumber());
        RoomData_roomType.getSelectionModel().select(r.getRoomType());
        RoomData_FloorNo.getSelectionModel().select(r.getFloorNumber());
        RoomData_RoomStatus.getSelectionModel().select(r.getRoomStatus());
        RoomData_RoomPrice.setText(String.valueOf(r.getPrice()));
        RoomData_LastUpdated.setValue(r.getLastUpdated());
    }

    public void ShowSelectRoomRateData() {
        RoomRate rr = roomRate_TableView.getSelectionModel().getSelectedItem();
        int num = roomRate_TableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        roomRate_rateCode.setDisable(true);
        roomRate_rateCode.setText(rr.getRateCd());
        roomRate_rateCodeNm.setText(rr.getRateCdNm());
        roomRate_roomType.getSelectionModel().select(rr.getRoomType());
        roomRate_priceMMR.setText(String.valueOf(rr.getPriceMMR()));
        roomRate_priceDollar.setText(String.valueOf(rr.getPriceDollar()));
        roomRate_lastUpdated.setValue(rr.getLastUpdated());
    }

    //Select User Data from table on the textfield
    public void ShowSelectUserData() {
        User usr = userData_TableView.getSelectionModel().getSelectedItem();
        int num = userData_TableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        userData_userName.setText(usr.getUserName());
        userData_position.setText(usr.getPosition());
        userData_phoneNo.setText(usr.getPhoneNo());

    }

    public void RoomsDataSearch() {
        FilteredList<Room> filterData = new FilteredList<>(roomDataList, e -> true);

        RoomData_search.textProperty().addListener((Observable, oldValue, newValue) -> {

            filterData.setPredicate(predicateRoom -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if (predicateRoom.getRoomNumber().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateRoom.getRoomType().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateRoom.getFloorNumber().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateRoom.getRoomStatus().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (String.valueOf(predicateRoom.getPrice()).contains(searchKey)) {
                    return true;
                } else if (String.valueOf(predicateRoom.getLastUpdated()).contains(searchKey)) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        SortedList<Room> sortedList = new SortedList<>(filterData);
        sortedList.comparatorProperty().bind(RoomData_TableView.comparatorProperty());
        RoomData_TableView.setItems(sortedList);
    }

    public void RoomRatesDataSearch() {
        FilteredList<RoomRate> filterData = new FilteredList<>(roomRateDataList, e -> true);

        roomRate_search.textProperty().addListener((Observable, oldValue, newValue) -> {

            filterData.setPredicate(predicateRoomRate -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if (predicateRoomRate.getRateCd().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateRoomRate.getRateCdNm().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateRoomRate.getRoomType().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (String.valueOf(predicateRoomRate.getPriceMMR()).toLowerCase().contains(searchKey)) {
                    return true;
                } else if (String.valueOf(predicateRoomRate.getPriceDollar()).contains(searchKey)) {
                    return true;
                } else if (String.valueOf(predicateRoomRate.getLastUpdated()).contains(searchKey)) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        SortedList<RoomRate> sortedList = new SortedList<>(filterData);
        sortedList.comparatorProperty().bind(roomRate_TableView.comparatorProperty());
        roomRate_TableView.setItems(sortedList);
    }

    public void FloorsDataSearch() {
        FilteredList<Floor> filterData = new FilteredList<>(floorDataList, e -> true);

        FloorInformation_Search.textProperty().addListener((Observable, oldValue, newValue) -> {

            filterData.setPredicate(predicateFloor -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if (predicateFloor.getFloorNo().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (String.valueOf(predicateFloor.getCount()).contains(searchKey)) {
                    return true;
                } else if (predicateFloor.getRoomType().toLowerCase().contains(searchKey)) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        SortedList<Floor> sortedList = new SortedList<>(filterData);
        sortedList.comparatorProperty().bind(FloorInformation_TableView.comparatorProperty());
        FloorInformation_TableView.setItems(sortedList);
    }

    public void UsersDataSearch() {
        FilteredList<User> filterData = new FilteredList<>(userDataList, e -> true);

        userData_search.textProperty().addListener((Observable, oldValue, newValue) -> {

            filterData.setPredicate(predicateUser -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if (String.valueOf(predicateUser.getUserId()).toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateUser.getUserName().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateUser.getPosition().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateUser.getPhoneNo().toLowerCase().contains(searchKey)) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        SortedList<User> sortedList = new SortedList<>(filterData);
        sortedList.comparatorProperty().bind(userData_TableView.comparatorProperty());
        userData_TableView.setItems(sortedList);
    }

    public void CurrencyDataSearch() {
        FilteredList<Currency> filterData = new FilteredList<>(currencyDataList, e -> true);

        currencyRate_search.textProperty().addListener((Observable, oldValue, newValue) -> {

            filterData.setPredicate(predicateCurrency -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if (String.valueOf(predicateCurrency.getDate()).contains(searchKey)) {
                    return true;
                } else if (String.valueOf(predicateCurrency.getAmt()).contains(searchKey)) {
                    return true;
                } else if (String.valueOf(predicateCurrency.getValidStartDate()).contains(searchKey)) {
                    return true;
                } else if (String.valueOf(predicateCurrency.getValidEndDate()).contains(searchKey)) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        SortedList<Currency> sortedList = new SortedList<>(filterData);
        sortedList.comparatorProperty().bind(currencyRate_tableView.comparatorProperty());
        currencyRate_tableView.setItems(sortedList);
    }

    public void SaveRoomInfo(ActionEvent event) throws ClassNotFoundException, SQLException {
        try {
            String roomNo = RoomData_roomNo.getText();
            String roomTp = String.valueOf(RoomData_roomType.getSelectionModel().getSelectedItem());
            String floorNo = String.valueOf(RoomData_FloorNo.getSelectionModel().getSelectedItem());
            String status = String.valueOf(RoomData_RoomStatus.getSelectionModel().getSelectedItem());
            double price = ParseDouble(RoomData_RoomPrice.getText());
            LocalDate lastUpdate = RoomData_LastUpdated.getValue();
            boolean check;
            Alert alert;
            if ((roomNo.isEmpty()) || (RoomData_roomType.getValue() == null) || (RoomData_FloorNo.getValue() == null) || (RoomData_RoomStatus.getValue() == null) || (lastUpdate == null)) {
                alert = new Alert(Alert.AlertType.ERROR);
                Stage owner = Stage.class.cast(Control.class.cast(event.getSource()).getScene().getWindow());
                alert.initOwner(owner);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all fields");
                alert.showAndWait();
            } else {
                //Testing START
                List<String> rNoList = new ArrayList<>();
                for (Room r : roomDataList) {
                    String rNo = r.getRoomNumber();
                    rNoList.add(rNo);
                }
                //Testing END

                if (rNoList.contains(roomNo)) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    Stage owner = Stage.class.cast(Control.class.cast(event.getSource()).getScene().getWindow());
                    alert.initOwner(owner);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Room No. " + roomNo + " has already Exist!");
                    alert.showAndWait();
                } else {
                    DataAccessDB da = new DataAccessDB();
                    Room room = new Room();
                    room.setRoomNumber(roomNo);
                    room.setRoomType(roomTp);
                    room.setFloorNumber(floorNo);
                    room.setRoomStatus(status);
                    room.setPrice(price);
                    room.setLastUpdated(lastUpdate);
                    check = da.SaveRoomData(room);
                    if (check) {
                        alert = new Alert(Alert.AlertType.INFORMATION);
                        Stage owner = Stage.class.cast(Control.class.cast(event.getSource()).getScene().getWindow());
                        alert.initOwner(owner);
                        alert.setTitle("Saving Record");
                        alert.setHeaderText(null);
                        alert.setContentText("Successfully Added!");
                        alert.showAndWait();

                        ShowRoomsData(); //To Update Data on the tableview                        
                        TextClearRoom();
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException cnf) {
            System.out.println(cnf.getMessage());
        }
    }

    public void SaveRoomRateInfo(ActionEvent event) throws ClassNotFoundException, SQLException {
        try {
            String rateCd = roomRate_rateCode.getText();
            String rateCdNm = roomRate_rateCodeNm.getText();
            String roomType = String.valueOf(roomRate_roomType.getSelectionModel().getSelectedItem());
            double pricemm = ParseDouble(roomRate_priceMMR.getText());
            double pricedollar = ParseDouble(roomRate_priceDollar.getText());
            LocalDate lastUpdate = roomRate_lastUpdated.getValue();
            boolean check;
            Alert alert;
            if ((rateCd.isEmpty()) || (rateCdNm.isEmpty()) || (roomType.isEmpty()) || (pricemm == 0.0) || (pricedollar == 0.0) || (lastUpdate == null)) {
                alert = new Alert(Alert.AlertType.ERROR);
                Stage owner = Stage.class.cast(Control.class.cast(event.getSource()).getScene().getWindow());
                alert.initOwner(owner);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all fields");
                alert.showAndWait();
            } else {
                //Testing START
                List<String> rateCdList = new ArrayList<>();
                for (RoomRate rr : roomRateDataList) {
                    String rCd = rr.getRateCd();
                    rateCdList.add(rCd);
                }
                //Testing END

                if (rateCdList.contains(rateCd)) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    Stage owner = Stage.class.cast(Control.class.cast(event.getSource()).getScene().getWindow());
                    alert.initOwner(owner);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Rate Code No. " + rateCd + " has already Existed!");
                    alert.showAndWait();
                } else {
                    DataAccessDB da = new DataAccessDB();
                    RoomRate roomrate = new RoomRate();
                    roomrate.setRateCd(rateCd);
                    roomrate.setRateCdNm(rateCdNm);
                    roomrate.setRoomType(roomType);
                    roomrate.setPriceMMR(pricemm);
                    roomrate.setPriceDollar(pricedollar);
                    roomrate.setLastUpdated(lastUpdate);
                    check = da.SaveRoomRateData(roomrate);
                    if (check) {
                        alert = new Alert(Alert.AlertType.INFORMATION);
                        Stage owner = Stage.class.cast(Control.class.cast(event.getSource()).getScene().getWindow());
                        alert.initOwner(owner);
                        alert.setTitle("Saving Record");
                        alert.setHeaderText(null);
                        alert.setContentText("Successfully Added!");
                        alert.showAndWait();

                        ShowRoomRatesData(); //To Update Data on the tableview
                        RoomRatesDataSearch();
                        TextClearRoomRate();
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException cnf) {
            System.out.println(cnf.getMessage());
        }
    }

    public void SaveUserInfo(ActionEvent event) throws ClassNotFoundException, SQLException {
        try {
//            int userId = Integer.valueOf(userData_userID.getText());
            String userNm = userData_userName.getText();
            String pos = userData_position.getText();
            String phNo = userData_phoneNo.getText();

            boolean check;
            Alert alert;
            if ((userNm.isEmpty()) || (pos.isEmpty()) || (phNo.isEmpty())) {
                alert = new Alert(Alert.AlertType.ERROR);
                Stage owner = Stage.class.cast(Control.class.cast(event.getSource()).getScene().getWindow());
                alert.initOwner(owner);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all fields");
                alert.showAndWait();
            } else {
                DataAccessDB da = new DataAccessDB();
                User user = new User();
                user.setUserName(userNm);
                user.setPosition(pos);
                user.setPhoneNo(phNo);

                check = da.SaveUserData(user);
                if (check) {
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    Stage owner = Stage.class.cast(Control.class.cast(event.getSource()).getScene().getWindow());
                    alert.initOwner(owner);
                    alert.setTitle("Saving Record");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Saved!");
                    alert.showAndWait();

                    ShowUsersData(); //To Update Data on the tableview
                    UsersDataSearch();
                    TextClearUser();
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException cnf) {
            System.out.println(cnf.getMessage());
        }
    }

    public void SaveCurrency(ActionEvent event) throws ClassNotFoundException, SQLException {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate todayDate = LocalDate.parse(currencyRate_todayDate.getText(), formatter);
            double amt = ParseDouble(currencyRate_amount.getText());
            LocalDate vsd = currencyRate_validStart.getValue();
            LocalDate ved = currencyRate_validEnd.getValue();
            boolean check;
            Alert alert;
            if ((todayDate == null) || (amt == 0.0) || (vsd == null) || (ved == null)) {
                alert = new Alert(Alert.AlertType.ERROR);
                Stage owner = Stage.class.cast(Control.class.cast(event.getSource()).getScene().getWindow());
                alert.initOwner(owner);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all fields");
                alert.showAndWait();
            } else {
                //Testing START
                List<LocalDate> dateList = new ArrayList<>();
                for (Currency c : currencyDataList) {
                    LocalDate currentDate = c.getDate();
                    dateList.add(currentDate);
                }
                //Testing END

                if (dateList.contains(todayDate)) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    Stage owner = Stage.class.cast(Control.class.cast(event.getSource()).getScene().getWindow());
                    alert.initOwner(owner);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Data already existed for " + todayDate.toString());
                    alert.showAndWait();
                } else {
                    DataAccessDB da = new DataAccessDB();
                    Currency currency = new Currency();
                    currency.setDate(todayDate);
                    currency.setAmt(amt);
                    currency.setValidStartDate(vsd);
                    currency.setValidEndDate(ved);
                    check = da.SaveCurrencyData(currency);
                    if (check) {
                        alert = new Alert(Alert.AlertType.INFORMATION);
                        Stage owner = Stage.class.cast(Control.class.cast(event.getSource()).getScene().getWindow());
                        alert.initOwner(owner);
                        alert.setTitle("Saving Record");
                        alert.setHeaderText(null);
                        alert.setContentText(amt + " has been successfully saved for " + todayDate);
                        alert.showAndWait();

                        displayCurrencyToday();
                        ShowCurrencyData(); //To Update Data on the tableview
                        TextClearCurrency();
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException cnf) {
            System.out.println(cnf.getMessage());
        }
    }

//    @FXML
//    private void onClickedBtn(ActionEvent event) {
//        Button clickedButton = (Button) event.getSource();
//
//        if (selectedBtn != null) {
//            selectedBtn.getStyleClass().remove("btn-menu-selected");
//        }
//
//        clickedButton.getStyleClass().add("btn-menu-selected");
//
//        selectedBtn = clickedButton;
//    }
    public void UpdateRoom(ActionEvent event) throws ClassNotFoundException, SQLException {
        try {
            String roomNo = RoomData_roomNo.getText();
            String roomTp = String.valueOf(RoomData_roomType.getSelectionModel().getSelectedItem());
            String floorNo = String.valueOf(RoomData_FloorNo.getSelectionModel().getSelectedItem());
            String status = String.valueOf(RoomData_RoomStatus.getSelectionModel().getSelectedItem());
            double price = ParseDouble(RoomData_RoomPrice.getText());
            LocalDate lastUpdate = RoomData_LastUpdated.getValue();
            boolean check;
            Alert alert;

            if ((roomNo.isEmpty()) || (RoomData_roomType.getValue() == null) || (RoomData_FloorNo.getValue() == null) || (RoomData_RoomStatus.getValue() == null) || (lastUpdate == null)) {
                alert = new Alert(Alert.AlertType.ERROR);
                Stage owner = Stage.class.cast(Control.class.cast(event.getSource()).getScene().getWindow());
                alert.initOwner(owner);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all fields");
                alert.showAndWait();
            } else {
                //beta.2 START
                List<String> roomList = new ArrayList<>();
                for (Room r : roomDataList) {
                    String rNo = r.getRoomNumber();
                    roomList.add(rNo);
                }

                if (!roomList.contains(roomNo)) {
                    alert = new Alert(AlertType.ERROR);
                    Stage owner = Stage.class.cast(Control.class.cast(event.getSource()).getScene().getWindow());
                    alert.initOwner(owner);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Room No. " + roomNo + " does not exist!");
                    alert.showAndWait();

                } else {
                    DataAccessDB da = new DataAccessDB();
                    Room room = new Room();
                    room.setRoomNumber(roomNo);
                    room.setRoomType(roomTp);
                    room.setFloorNumber(floorNo);
                    room.setRoomStatus(status);
                    room.setPrice(price);
                    room.setLastUpdated(lastUpdate);
                    check = da.UpdateRoomData(room);

                    if (check) {
                        alert = new Alert(Alert.AlertType.INFORMATION);
                        Stage owner = Stage.class.cast(Control.class.cast(event.getSource()).getScene().getWindow());
                        alert.initOwner(owner);
                        alert.setTitle("Updating Record");
                        alert.setHeaderText(null);
                        alert.setContentText("Successfully Updated!");
                        alert.showAndWait();

                        ShowRoomsData(); //To Update Data on the tableview
                        TextClearRoom();
                    }
                }
                //beta.2 END                
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException cnf) {
            System.out.println(cnf.getMessage());
        }
    }

    public void UpdateRoomRate(ActionEvent event) throws ClassNotFoundException, SQLException {
        try {
            String rateCd = roomRate_rateCode.getText();
            String rateCdNm = roomRate_rateCodeNm.getText();
            String roomType = String.valueOf(roomRate_roomType.getSelectionModel().getSelectedItem());
            double priceMM = ParseDouble(roomRate_priceMMR.getText());
            double priceD = ParseDouble(roomRate_priceDollar.getText());
            LocalDate lastUpdate = roomRate_lastUpdated.getValue();
            boolean check;
            Alert alert;

            if ((rateCd.isEmpty()) || (rateCdNm.isEmpty()) || (roomType.isEmpty()) || (priceMM == 0.0) || (priceD == 0.0) || (lastUpdate == null)) {
                alert = new Alert(Alert.AlertType.ERROR);
                Stage owner = Stage.class.cast(Control.class.cast(event.getSource()).getScene().getWindow());
                alert.initOwner(owner);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all fields");
                alert.showAndWait();
            } else {
                //beta.2 START
                List<String> rCdList = new ArrayList<>();
                for (RoomRate rr : roomRateDataList) {
                    String rCd = rr.getRateCd();
                    rCdList.add(rCd);
                }

                if (!rCdList.contains(rateCd)) {
                    alert = new Alert(AlertType.ERROR);
                    Stage owner = Stage.class.cast(Control.class.cast(event.getSource()).getScene().getWindow());
                    alert.initOwner(owner);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Rate Code No. " + rateCd + " does not exist!");
                    alert.showAndWait();
                } else {
                    DataAccessDB da = new DataAccessDB();
                    RoomRate r = new RoomRate();
                    r.setRateCd(rateCd);
                    r.setRateCdNm(rateCdNm);
                    r.setRoomType(roomType);
                    r.setPriceMMR(priceMM);
                    r.setPriceDollar(priceD);
                    r.setLastUpdated(lastUpdate);
                    check = da.UpdateRoomRateData(r);

                    if (check) {
                        alert = new Alert(Alert.AlertType.INFORMATION);
                        Stage owner = Stage.class.cast(Control.class.cast(event.getSource()).getScene().getWindow());
                        alert.initOwner(owner);
                        alert.setTitle("Updating Record");
                        alert.setHeaderText(null);
                        alert.setContentText(rateCd + " has been successfully Updated!");
                        alert.showAndWait();

                        ShowRoomRatesData(); //To Update Data on the tableview
                        RoomRatesDataSearch();
                        TextClearRoomRate();
                    }
                }
                //beta.2 END             
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException cnf) {
            System.out.println(cnf.getMessage());
        }
    }

    public void UpdateUser(ActionEvent event) throws ClassNotFoundException, SQLException {
        try {
            User usrId = userData_TableView.getSelectionModel().getSelectedItem();
            String userNm = userData_userName.getText();
            String position = userData_position.getText();
            String phNo = userData_phoneNo.getText();
            boolean check;
            Alert alert;

            if ((usrId == null) || (userNm.isEmpty()) || (position.isEmpty()) || (phNo.isEmpty())) {
                alert = new Alert(Alert.AlertType.ERROR);
                Stage owner = Stage.class.cast(Control.class.cast(event.getSource()).getScene().getWindow());
                alert.initOwner(owner);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all fields");
                alert.showAndWait();
            } else {
                int id = usrId.getUserId();
                DataAccessDB da = new DataAccessDB();
                User user = new User();
                user.setUserId(id);
                user.setUserName(userNm);
                user.setPosition(position);
                user.setPhoneNo(phNo);

                check = da.UpdateUserData(user);

                if (check) {
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    Stage owner = Stage.class.cast(Control.class.cast(event.getSource()).getScene().getWindow());
                    alert.initOwner(owner);
                    alert.setTitle("Updating Record");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();

                    ShowUsersData(); //To Update Data on the tableview
                    UsersDataSearch();
                    TextClearUser();
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException cnf) {
            System.out.println(cnf.getMessage());
        }
    }

    public void UpdateCurrency(ActionEvent event) throws ClassNotFoundException, SQLException {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate todayDate = LocalDate.parse(currencyRate_todayDate.getText(), formatter);
            double amt = ParseDouble(currencyRate_amount.getText());
            LocalDate vsd = currencyRate_validStart.getValue();
            LocalDate ved = currencyRate_validEnd.getValue();
            boolean check;
            Alert alert;
            if ((todayDate == null) || (amt == 0.0) || (vsd == null) || (ved == null)) {
                alert = new Alert(Alert.AlertType.ERROR);
                Stage owner = Stage.class.cast(Control.class.cast(event.getSource()).getScene().getWindow());
                alert.initOwner(owner);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all fields");
                alert.showAndWait();
            } else {
                DataAccessDB da = new DataAccessDB();
                Currency currency = new Currency();
                currency.setDate(todayDate);
                currency.setAmt(amt);
                currency.setValidStartDate(vsd);
                currency.setValidEndDate(ved);
                check = da.UpdateCurrencyData(currency);

                if (check) {
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    Stage owner = Stage.class.cast(Control.class.cast(event.getSource()).getScene().getWindow());
                    alert.initOwner(owner);
                    alert.setTitle("Updating Record");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();

                    displayCurrencyToday();
                    ShowCurrencyData(); //To Update Data on the tableview
                    TextClearCurrency();
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException cnf) {
            System.out.println(cnf.getMessage());
        }
    }

    public void DeleteUser(ActionEvent event) throws ClassNotFoundException, SQLException {
        try {
            User user = userData_TableView.getSelectionModel().getSelectedItem();
            int userId = user.getUserId();
            String userNm = user.getUserName();
            Alert alert;

            alert = new Alert(AlertType.CONFIRMATION);
            Stage owner = Stage.class.cast(Control.class.cast(event.getSource()).getScene().getWindow());
            alert.initOwner(owner);

            alert.setTitle("Deleting Record");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {
                DataAccessDB da = new DataAccessDB();
                boolean result = da.DeleteUserData(userId);
                if (result) {
                    Alert alertInfo = new Alert(Alert.AlertType.INFORMATION);
                    alertInfo.initOwner(owner);
                    alertInfo.setTitle("Deleting Record");
                    alertInfo.setHeaderText(null);
                    alertInfo.setContentText("User ID " + userId + " : " + userNm + " has been Successfully Deleted!");
                    alertInfo.showAndWait();

                    ShowUsersData(); //To Update Data on the tableview
                    UsersDataSearch();
                    TextClearUser();
                }
            } else {
                return;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException cnf) {
            System.out.println(cnf.getMessage());
        }

    }

    public void DeleteCurrency(ActionEvent event) throws ClassNotFoundException, SQLException {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate todayDate = LocalDate.parse(currencyRate_todayDate.getText(), formatter);
            Alert alert;

            //Testing START
            List<LocalDate> dateList = new ArrayList<>();
            for (Currency c : currencyDataList) {
                LocalDate date = c.getDate();
                dateList.add(date);
            }
//            if (rNoList.contains(roomNo)) {
//                System.out.println("Valid Room Number");
//            } else {
//                System.out.println("Invalid Room Number");
//            }
            //Testing END

            if (todayDate == null) {
                alert = new Alert(Alert.AlertType.ERROR);
                Stage owner = Stage.class.cast(Control.class.cast(event.getSource()).getScene().getWindow());
                alert.initOwner(owner);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Today Date Field is Empty!");
                alert.showAndWait();
            } else if (!dateList.contains(todayDate)) {
                alert = new Alert(Alert.AlertType.ERROR);
                Stage owner = Stage.class.cast(Control.class.cast(event.getSource()).getScene().getWindow());
                alert.initOwner(owner);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Date " + todayDate + " is not Found!");
                alert.showAndWait();
            } else {
                alert = new Alert(AlertType.CONFIRMATION);
                Stage owner = Stage.class.cast(Control.class.cast(event.getSource()).getScene().getWindow());
                alert.initOwner(owner);

                alert.setTitle("Deleting Record");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    DataAccessDB da = new DataAccessDB();
                    boolean result = da.DeleteCurrencyData(todayDate);
                    if (result) {
                        Alert alertInfo = new Alert(Alert.AlertType.INFORMATION);
                        alertInfo.initOwner(owner);
                        alertInfo.setTitle("Deleting Record");
                        alertInfo.setHeaderText(null);
                        alertInfo.setContentText("Successfully Deleted!");
                        alertInfo.showAndWait();

                        displayCurrencyToday();
                        ShowCurrencyData(); //To Update Data on the tableview
                        TextClearCurrency();
                    }
                } else {
                    return;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException cnf) {
            System.out.println(cnf.getMessage());
        }
    }

    public void DeleteRoom(ActionEvent event) throws ClassNotFoundException, SQLException {
        try {
            String roomNo = RoomData_roomNo.getText();
            Alert alert;

            //Testing START
            List<String> rNoList = new ArrayList<>();
            for (Room r : roomDataList) {
                String rNo = r.getRoomNumber();
                rNoList.add(rNo);
            }
//            if (rNoList.contains(roomNo)) {
//                System.out.println("Valid Room Number");
//            } else {
//                System.out.println("Invalid Room Number");
//            }
            //Testing END

            if ((roomNo.isEmpty())) {
                alert = new Alert(Alert.AlertType.ERROR);
                Stage owner = Stage.class.cast(Control.class.cast(event.getSource()).getScene().getWindow());
                alert.initOwner(owner);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Room Number is Empty!");
                alert.showAndWait();
            } else if (!rNoList.contains(roomNo)) {
                alert = new Alert(Alert.AlertType.ERROR);
                Stage owner = Stage.class.cast(Control.class.cast(event.getSource()).getScene().getWindow());
                alert.initOwner(owner);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Room No. " + roomNo + " is not Found!");
                alert.showAndWait();
            } else {
                alert = new Alert(AlertType.CONFIRMATION);
                Stage owner = Stage.class.cast(Control.class.cast(event.getSource()).getScene().getWindow());
                alert.initOwner(owner);

                alert.setTitle("Deleting Record");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    DataAccessDB da = new DataAccessDB();
                    boolean result = da.DeleteRoomData(roomNo);
                    if (result) {
                        Alert alertInfo = new Alert(Alert.AlertType.INFORMATION);
                        alertInfo.initOwner(owner);
                        alertInfo.setTitle("Deleting Record");
                        alertInfo.setHeaderText(null);
                        alertInfo.setContentText("Successfully Deleted!");
                        alertInfo.showAndWait();
                        ShowRoomsData(); //To Update Data on the tableview
                        TextClearRoom();
                    }
                } else {
                    return;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException cnf) {
            System.out.println(cnf.getMessage());
        }
    }

    public void DeleteRoomRate(ActionEvent event) throws ClassNotFoundException, SQLException {
        try {
            String rateCd = roomRate_rateCode.getText();
            Alert alert;

            //Testing START
            List<String> rateCdList = new ArrayList<>();
            for (RoomRate r : roomRateDataList) {
                String rCd = r.getRateCd();
                rateCdList.add(rCd);
            }
//            if (rNoList.contains(roomNo)) {
//                System.out.println("Valid Room Number");
//            } else {
//                System.out.println("Invalid Room Number");
//            }
            //Testing END

            if ((rateCd.isEmpty())) {
                alert = new Alert(Alert.AlertType.ERROR);
                Stage owner = Stage.class.cast(Control.class.cast(event.getSource()).getScene().getWindow());
                alert.initOwner(owner);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Rate Code No. is Empty!");
                alert.showAndWait();
            } else if (!rateCdList.contains(rateCd)) {
                alert = new Alert(Alert.AlertType.ERROR);
                Stage owner = Stage.class.cast(Control.class.cast(event.getSource()).getScene().getWindow());
                alert.initOwner(owner);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Rate Code No. " + rateCd + " is not Found!");
                alert.showAndWait();
            } else {
                alert = new Alert(AlertType.CONFIRMATION);
                Stage owner = Stage.class.cast(Control.class.cast(event.getSource()).getScene().getWindow());
                alert.initOwner(owner);

                alert.setTitle("Deleting Record");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    DataAccessDB da = new DataAccessDB();
                    boolean result = da.DeleteRoomRateData(rateCd);
                    if (result) {
                        Alert alertInfo = new Alert(Alert.AlertType.INFORMATION);
                        alertInfo.initOwner(owner);
                        alertInfo.setTitle("Deleting Record");
                        alertInfo.setHeaderText(null);
                        alertInfo.setContentText("Rate Code No. " + rateCd + " has been successfully Deleted!");
                        alertInfo.showAndWait();

                        ShowRoomRatesData(); //To Update Data on the tableview
                        RoomRatesDataSearch();
                        TextClearRoomRate();
                    }
                } else {
                    return;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException cnf) {
            System.out.println(cnf.getMessage());
        }
    }

    public void DeleteAllRooms(ActionEvent event) throws ClassNotFoundException, SQLException {
        try {
            Alert alert;
            Stage owner = Stage.class.cast(Control.class.cast(event.getSource()).getScene().getWindow());
            if (RoomData_TableView.getItems().size() != 0) {
                alert = new Alert(AlertType.CONFIRMATION);
                alert.initOwner(owner);

                alert.setTitle("Deleting All Records");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    DataAccessDB da = new DataAccessDB();
                    boolean result = da.DeleteAllRoomsData();
                    if (result) {
                        alert = new Alert(Alert.AlertType.INFORMATION);
//                Stage owner = Stage.class.cast(Control.class.cast(event.getSource()).getScene().getWindow());
                        alert.initOwner(owner);
                        alert.setTitle("Deleting All Record");
                        alert.setHeaderText(null);
                        alert.setContentText("All Data have been successfully Deleted!");
                        alert.showAndWait();

                        ShowRoomsData(); //To Update Data on the tableview
                        TextClearRoom();
                    }
                }
            } else {
                alert = new Alert(AlertType.WARNING);
                alert.initOwner(owner);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("No Data Found!");
                alert.showAndWait();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException cnf) {
            System.out.println(cnf.getMessage());
        }
    }

    public void TextClearRoom() {
        RoomData_roomNo.setDisable(false);
        RoomData_roomNo.setText("");
        RoomData_roomType.getSelectionModel().clearSelection();
        RoomData_FloorNo.getSelectionModel().clearSelection();
        RoomData_RoomStatus.getSelectionModel().clearSelection();
        RoomData_RoomPrice.setText("");
//        RoomData_LastUpdated.setValue(null); //beta.2
    }

    public void TextClearRoomRate() {
        roomRate_rateCode.setDisable(false);
        roomRate_rateCode.setText("");
        roomRate_rateCodeNm.setText("");
        roomRate_roomType.getSelectionModel().clearSelection();
        roomRate_priceMMR.setText("");
        roomRate_priceDollar.setText("");
//        roomRate_lastUpdated.setValue(null); //beta.2
    }

    public void TextClearUser() {
        userData_userName.setText("");
        userData_position.setText("");
        userData_phoneNo.setText("");
    }

    public void TextClearCurrency() {
        currencyRate_amount.setText("");
    }
}
