package sample;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import data.AgentDB;
import data.BookingDB;
import data.CustomerDB;
import data.PackageDB;
import data.dummy.BookingData;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.Agent;

import model.Booking;
import model.Customer;
import model.Package;


public class Controller {

private ObservableList<Agent> agents = FXCollections.observableArrayList();
    private ObservableList<Customer> customers = FXCollections.observableArrayList();
    private ObservableList<Booking> bookings = FXCollections.observableArrayList();

    private Customer selectedCustomer ; //contain the selected customer
    private ObservableList<Package> packages = FXCollections.observableArrayList(); //the list of all packages
    private Package selectedpackage ; //contain the selected package

    private String REGEX_NAME="([a-zA-Z\\s])+";
    private String REGEX_POSTAL="[A-Z][0-9][A-Z][ ][0-9][A-Z][0-9]" ;

    private String REGEX_PHONE="[0-9]{10}";
    private String REGEX_EMAIL="[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]+";// "[A-Z0-9+_.-]+@[A-Z0-9.-]+";
    private String REGEX_NUMBER= "[0-9]+";
    private String REGEX_USERNAME="[a-zA-Z0-9_-]+";
    private String REGEX_PASSWORD="[a-zA-Z0-9@#$%^&+=]+";
    private String ALERT_TITLE="Travel Expert Db Maintenance";


    @FXML // fx:id="tabAgents"
    private Tab tabAgents; // Value injected by FXMLLoader

    @FXML // fx:id="tabCustomers"
    private Tab tabCustomers; // Value injected by FXMLLoader


    @FXML // fx:id="tabReview"
    private Tab tabReview; // Value injected by FXMLLoader

    @FXML // fx:id="tabFuture"
    private Tab tabFuture; // Value injected by FXMLLoader

    @FXML // fx:id="tabPackages"
    private Tab tabPackages; // Value injected by FXMLLoader

    @FXML // fx:id="tabEmployees"
    private Tab tabEmployees; // Value injected by FXMLLoader


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane apCredentials;

    @FXML
    private PasswordField tfUserPass;

    @FXML
    private TextField tfUserName;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnLogOut;

    @FXML
    private AnchorPane anpEmp;

    @FXML
    private TableView tblAgents;

    @FXML
    private TableColumn<String, Agent> colAgentId, colAgtFirstName, colAgtMiddleInitial, colAgtLastName, colAgtBusPhone, colAgtEmail, colAgtPosition, colAgencyId;

    @FXML
    private TableColumn<String, Customer> colCustomerId, colCustFirstName, colCustLastName, colCustAddress, colCustCity,
            colCustProv,colCustPostal, colCustCountry, colCustHomePhone,colCustBusPhone,colCustAgentId ,colCustEmail,colCustusername,colCustpassword;

    @FXML
    private TableColumn<String, Booking> colBookingId,colBookingDate, colBookingNo,colTravelerCount, colTripTypeId,colPackageIdBooking;
    @FXML
    private TextField tfAgentId,  tfAgtFirstName, tfAgtMiddleInitial, tfAgtLastName, tfAgtBusPhone, tfAgtEmail, tfAgtPosition, tfAgencyId;


    @FXML
    private ImageView imageViewAgentPhoto;

    @FXML
    private TableView<?> tblAgencies;

    @FXML
    private TableColumn<?, ?> colAgncyAddress;

    @FXML
    private TableColumn<?, ?> colAgncyCity;

    @FXML
    private TableColumn<?, ?> colAgncyProv;

    @FXML
    private TableColumn<?, ?> colAgncyPostal;

    @FXML
    private TableColumn<?, ?> colAgncyCountry;

    @FXML
    private TableColumn<?, ?> colAgncyPhone;

    @FXML
    private TableColumn<?, ?> colAgncyFax;

    @FXML
    private AnchorPane apControls;


    @FXML
    private Label lblID;

    @FXML
    private Label lbl1;

    @FXML
    private Label lbl2;

    @FXML
    private Label lbl3;

    @FXML
    private Label lbl4;

    @FXML
    private Label lbl7;

    @FXML
    private Label lbl5;

    @FXML
    private Label lbl64;

    @FXML
    private TextField tf6;

    @FXML
    private TextField tf7;

    @FXML
    private TextField tf8;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnInsert;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnApply;



    @FXML
    private TableView tblBookings;

    @FXML
    private TableColumn<?, ?> colAgentId1;

    @FXML
    private TableColumn<?, ?> colAgtFirstName1;

    @FXML
    private TableColumn<?, ?> colAgtMiddleInitial1;

    @FXML
    private TableColumn<?, ?> colAgtLastName1;

    @FXML
    private TableColumn<?, ?> colAgtBusPhone1;

    @FXML
    private TableColumn<?, ?> colAgtEmail1;

    @FXML
    private TableColumn<?, ?> colAgtPosition1;

    @FXML
    private ImageView imageViewAgentPhoto1;

    @FXML
    private TableView<?> tblAgencies1;

    @FXML
    private TableColumn<?, ?> colAgencyId1;

    @FXML
    private TableColumn<?, ?> colAgncyAddress1;

    @FXML
    private TableColumn<?, ?> colAgncyCity1;

    @FXML
    private TableColumn<?, ?> colAgncyProv1;

    @FXML
    private TableColumn<?, ?> colAgncyPostal1;

    @FXML
    private TableColumn<?, ?> colAgncyCountry1;

    @FXML
    private TableColumn<?, ?> colAgncyPhone1;

    @FXML
    private TableColumn<?, ?> colAgncyFax1;

    @FXML
    private AnchorPane apControls1;


    @FXML
    private AnchorPane anpEmp1;


    @FXML
    private TableView tblCustomers;

    @FXML
    private TextField tfCustomerId;

    @FXML
    private TextField tfCustFirstName;

    @FXML
    private TextField tfCustLastName;

    @FXML
    private TextField tfCustAddress;

    @FXML
    private TextField tfCustCity;

    @FXML
    private TextField tfCustProv;

    @FXML
    private TextField tfCustPostal;

    @FXML
    private TextField tfCustCountry;

    @FXML
    private TextField tfCustHomePhone;

    @FXML
    private TextField tfCustBusPhone;

    @FXML
    private TextField tfCustEmail;

    @FXML
    private TextField tfCustUsername;

    @FXML
    //private PasswordField tfCustPassword = new PasswordField();
    private TextField tfCustPassword;

    @FXML
    private Button btnEditCustomer;

    @FXML
    private Button btnAddCustomer;

    @FXML
    private Button btnUpdateCustomer;

    @FXML
    private Button btnCancelCustomer;
    @FXML
    private AnchorPane anpEmp11;

    @FXML
    private Label lbl311;

    @FXML
    private Button btnUpdatePackage;

    @FXML
    private Button btnAddPackage;

    @FXML
    private Button btnClearPackageTF;

    @FXML
    private Button btnApplyPackageChanges;

    @FXML
    private Button btnDeletePkg;

    @FXML
    private Label lblID11;

    @FXML
    private Label lbl211;

    @FXML
    private Label lbl711;

    @FXML
    private TextField tfPkgBasePrice;

    @FXML
    private TextField tfAgencyCommission;

    @FXML
    private DatePicker dateStartDate;

    @FXML
    private DatePicker dateEndDate;

    @FXML
    private ComboBox<?> cbPackageId;

    @FXML
    private TextField tfPkgName;

    @FXML
    private TextArea taPkgDesc;

    @FXML
    private TableView  tblPackages;

    @FXML
    private TableColumn< String, Package> colPackageId, colPkgName,colPkgStartDate,colPkgEndDate,colPkgDescription, colPkgBasePrice , colPkgAgencyComm;


    @FXML
    private AnchorPane anpEmp3;

    @FXML
    private AnchorPane apControls3;

    @FXML
    private TextField tf13;

    @FXML
    private TextField tf23;

    @FXML
    private TextField tf33;

    @FXML
    private TextField tf43;

    @FXML
    private TextField tf53;

    @FXML
    private Button btnUpdate3;

    @FXML
    private Button btnInsert3;

    @FXML
    private Button btnClear3;

    @FXML
    private DatePicker datepicker13;

    @FXML
    private Label lblID3;

    @FXML
    private Button btnApply3;

    @FXML
    private Label lbl13;

    @FXML
    private Label lbl23;

    @FXML
    private Label lbl33;

    @FXML
    private Label lbl43;

    @FXML
    private Label lbl73;

    @FXML
    private Label lbl53;

    @FXML
    private Label lbl6;

    @FXML
    private Label lbl63;

    @FXML
    private Label lbl83;

    @FXML
    private TextField tf63;

    @FXML
    private TextField tf73;

    @FXML
    private TextField tf83;

    @FXML
    private TextField tf93;

    @FXML
    private Label lbl93;

    @FXML
    private DatePicker datepicker23;

    @FXML
    private Button btnExit;


    @FXML
    void OnMouseClickedCusttable(MouseEvent event) {
        //look for the booking list of selected customer
        //and build a new list in the booking list
        buildBookingForCustomerSelected();
    }
    void buildBookingForCustomerSelected()
    {
        //get the new selected customer
        selectedCustomer = (Customer) tblCustomers.getSelectionModel().getSelectedItem();
        //get all the bookings of the customer selected and refresh the bookings table with the values of a list of bookings
        ObservableList<Booking> bookingList= GetBookingsOfCustomer(selectedCustomer.getCustomerId());
        if (bookingList!=null)
            System.out.println(bookingList);
        //build the booking table view
        buildBookingstable(bookingList);


    }
    void createBookingTableColumns()
    {
        //table Column definition
        colBookingId = new TableColumn<>("Id");
        colBookingId.setCellValueFactory(new PropertyValueFactory<>("BookingId"));

        colBookingDate = new TableColumn<>("Booking Date");
        colBookingDate.setCellValueFactory(new PropertyValueFactory<>("BookingDate"));


        colBookingNo = new TableColumn<>("Booking No");
        colBookingNo.setCellValueFactory(new PropertyValueFactory<>("BookingNo"));

        colTravelerCount = new TableColumn("Number of Travelers");
        colTravelerCount.setCellValueFactory(new PropertyValueFactory("TravelerCount"));

        colTripTypeId = new TableColumn<>("Trip Type");
        colTripTypeId.setCellValueFactory(new PropertyValueFactory<>("TripTypeId"));

        colPackageIdBooking= new TableColumn<>("PackageId");
        colPackageIdBooking.setCellValueFactory(new PropertyValueFactory<>("PackageId"));


        tblBookings.getColumns().add( colBookingId );
        tblBookings.getColumns().add(colBookingDate);
        tblBookings.getColumns().add(colBookingNo);
        tblBookings.getColumns().add(colTravelerCount);
        tblBookings.getColumns().add(colTripTypeId);
        tblBookings.getColumns().add(colPackageIdBooking);


    }
    //build the booking list table from given list
    void buildBookingstable(ObservableList<Booking> bookingList)
    {

        tblBookings.setItems(bookingList);
        tblBookings.refresh();

    }
    //get all the booking of a given customer id
    private ObservableList<Booking> GetBookingsOfCustomer(int CustId)
    {
        ObservableList <Booking> resultlist= FXCollections.observableArrayList() ;
        //get all the bookinglist
        BookingDB bookingDB = new BookingDB(new data.dummy.BookingData());
        bookings = FXCollections.observableArrayList( bookingDB.getBookingList());

        for(Booking booking:bookings)
        {
            if (booking.getCustomerId()==CustId)
            {
                resultlist.add(booking);
            }
        }

        return resultlist;
    }











    Agent _selectedAgent;
    int _selectedAgentIndex;

    @FXML
    void OnMouseEnteredLoginBtn(MouseEvent event) {

    }

    @FXML
    void onActionBtnExit(ActionEvent event) {
        Platform.exit();

    }

    @FXML
    void onActionBtnLoginClick(ActionEvent event) {

        //if login was successful, then set this after login was ran
        DisableLoginEnableLogout();

    }

    @FXML
    void onActionBtnLogoutClick(ActionEvent event) {
        EnableLoginDisableLogout();
    }



    @FXML
    void OnActionBtnAddCust(ActionEvent event) {

        //get the value for the new customer after validating all fields
        String errorMessageTextFields =validateTextFieldsCustomer (); // contain the error message to display to the user
        if (errorMessageTextFields.isEmpty()) {
            Customer newCustomer = getNewCustomerFromTextField();
            //disable edit and textfield and save data to db
            btnEditCustomer.setDisable(true);
            setDisableTextFieldElementCustomer(true);
            //save the new value entered by user into the db
            try {

                CustomerDB customerdb = new CustomerDB(new data.dummy.CustomerData());
                String message = customerdb.insertCustomer(   newCustomer);
                //add the new customer to my list of customers
                customers.add(newCustomer);
                //refresh table with new value
                tblCustomers.refresh();
                btnUpdateCustomer.setDisable(true);
                btnEditCustomer.setDisable(false);
                System.out.println("Insert:" + message);


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else
        {

            //substring the last ","
            errorMessageTextFields= errorMessageTextFields.substring(0,errorMessageTextFields.length()-2);

            Alert alert = new Alert(Alert.AlertType.ERROR, "Check the following fields: " + errorMessageTextFields , ButtonType.OK);
            alert.setTitle(ALERT_TITLE);
            alert.setHeaderText("");
            alert.show();

        }


    }

    @FXML
    void OnActionBtnCancelCust(ActionEvent event) {
        clearCustumerTextField();
        setDisableTextFieldElementCustomer(false);
    }

    public void OnMouseClickedBooktable(MouseEvent mouseEvent) {

    }

    @FXML
    void OnActionBtnUpdateCust(ActionEvent event) {

        //call update with new customer from field
        Customer oldCustomer=selectedCustomer;

        //get the value for the new customer after validating all fields
        String errorMessageTextFields =validateTextFieldsCustomer (); // contain the error message to display to the user
        if (errorMessageTextFields.isEmpty()) {
            Customer newCustomer = getNewCustomerFromTextField();
            //disable edit and textfield and save data to db
            btnEditCustomer.setDisable(true);
            setDisableTextFieldElementCustomer(true);
            //save the new value entered by user into the db
            try {

                CustomerDB customerdb = new CustomerDB(new data.dummy.CustomerData());
                String message = customerdb.updateCustomer(  oldCustomer, newCustomer);

                oldCustomer.copy(newCustomer);
                //refresh table with new value
                tblCustomers.refresh();
                btnUpdateCustomer.setDisable(true);
                btnEditCustomer.setDisable(false);
                System.out.println("Update:" + message);


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else
        {

            //substring the last ","
            errorMessageTextFields= errorMessageTextFields.substring(0,errorMessageTextFields.length()-2);

            Alert alert = new Alert(Alert.AlertType.ERROR, "Check the following fields: " + errorMessageTextFields , ButtonType.OK);
            alert.setTitle(ALERT_TITLE);
            alert.setHeaderText("");
            alert.show();

        }

    }

    @FXML
    void OnActionClickBtnEditCust(ActionEvent event) {
        loadCustomer(selectedCustomer);
        //set unable update btn
        btnUpdate.setDisable(false);
        setDisableTextFieldElementCustomer(false);

    }

    @FXML
    void initialize() {
        assert apCredentials != null : "fx:id=\"apCredentials\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert tfUserPass != null : "fx:id=\"tfUserPass\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert tfUserName != null : "fx:id=\"tfUserName\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert btnLogin != null : "fx:id=\"btnLogin\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert btnLogOut != null : "fx:id=\"btnLogOut\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert tabAgents != null : "fx:id=\"tabAgents\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert anpEmp != null : "fx:id=\"anpEmp\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert tblAgents != null : "fx:id=\"tblAgents\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert colAgentId != null : "fx:id=\"colAgentId\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert colAgtFirstName != null : "fx:id=\"colAgtFirstName\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert colAgtMiddleInitial != null : "fx:id=\"colAgtMiddleInitial\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert colAgtLastName != null : "fx:id=\"colAgtLastName\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert colAgtBusPhone != null : "fx:id=\"colAgtBusPhone\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert colAgtEmail != null : "fx:id=\"colAgtEmail\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert colAgtPosition != null : "fx:id=\"colAgtPosition\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert colAgencyId != null : "fx:id=\"colAgencyId\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert imageViewAgentPhoto != null : "fx:id=\"imageViewAgentPhoto\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert tblAgencies != null : "fx:id=\"tblAgencies\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert colAgncyAddress != null : "fx:id=\"colAgncyAddress\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert colAgncyCity != null : "fx:id=\"colAgncyCity\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert colAgncyProv != null : "fx:id=\"colAgncyProv\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert colAgncyPostal != null : "fx:id=\"colAgncyPostal\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert colAgncyCountry != null : "fx:id=\"colAgncyCountry\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert colAgncyPhone != null : "fx:id=\"colAgncyPhone\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert colAgncyFax != null : "fx:id=\"colAgncyFax\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert apControls != null : "fx:id=\"apControls\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert lblID != null : "fx:id=\"lblID\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert lbl1 != null : "fx:id=\"lbl1\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert lbl2 != null : "fx:id=\"lbl2\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert lbl3 != null : "fx:id=\"lbl3\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert lbl4 != null : "fx:id=\"lbl4\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert lbl7 != null : "fx:id=\"lbl7\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert lbl5 != null : "fx:id=\"lbl5\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert lbl64 != null : "fx:id=\"lbl64\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert tf6 != null : "fx:id=\"tf6\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert tf7 != null : "fx:id=\"tf7\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert tf8 != null : "fx:id=\"tf8\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert btnUpdate != null : "fx:id=\"btnUpdate\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert btnInsert != null : "fx:id=\"btnInsert\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert btnApply != null : "fx:id=\"btnApply\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert tabCustomers != null : "fx:id=\"tabCustomers\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert anpEmp1 != null : "fx:id=\"anpEmp1\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert tblBookings != null : "fx:id=\"tblBookings\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert colAgentId1 != null : "fx:id=\"colAgentId1\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert colAgtFirstName1 != null : "fx:id=\"colAgtFirstName1\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert colAgtMiddleInitial1 != null : "fx:id=\"colAgtMiddleInitial1\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert colAgtLastName1 != null : "fx:id=\"colAgtLastName1\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert colAgtBusPhone1 != null : "fx:id=\"colAgtBusPhone1\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert colAgtEmail1 != null : "fx:id=\"colAgtEmail1\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert colAgtPosition1 != null : "fx:id=\"colAgtPosition1\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert imageViewAgentPhoto1 != null : "fx:id=\"imageViewAgentPhoto1\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert tblAgencies1 != null : "fx:id=\"tblAgencies1\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert colAgencyId1 != null : "fx:id=\"colAgencyId1\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert colAgncyAddress1 != null : "fx:id=\"colAgncyAddress1\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert colAgncyCity1 != null : "fx:id=\"colAgncyCity1\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert colAgncyProv1 != null : "fx:id=\"colAgncyProv1\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert colAgncyPostal1 != null : "fx:id=\"colAgncyPostal1\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert colAgncyCountry1 != null : "fx:id=\"colAgncyCountry1\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert colAgncyPhone1 != null : "fx:id=\"colAgncyPhone1\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert colAgncyFax1 != null : "fx:id=\"colAgncyFax1\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert apControls1 != null : "fx:id=\"apControls1\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";

        assert tfCustFirstName != null : "fx:id=\"tfCustFirstName\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";

        assert tfCustLastName != null : "fx:id=\"tfCustLastName\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";

        assert tfCustEmail != null : "fx:id=\"tfCustEmail\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";

        assert btnUpdateCustomer != null : "fx:id=\"btnUpdateCustomer\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";

        assert tabPackages != null : "fx:id=\"tabPackages\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert anpEmp11 != null : "fx:id=\"anpEmp11\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert lbl311 != null : "fx:id=\"lbl311\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert btnUpdatePackage != null : "fx:id=\"btnUpdatePackage\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert btnAddPackage != null : "fx:id=\"btnAddPackage\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert btnClearPackageTF != null : "fx:id=\"btnClearPackageTF\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert btnApplyPackageChanges != null : "fx:id=\"btnApplyPackageChanges\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert btnDeletePkg != null : "fx:id=\"btnDeletePkg\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert lblID11 != null : "fx:id=\"lblID11\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert lbl211 != null : "fx:id=\"lbl211\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert lbl711 != null : "fx:id=\"lbl711\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert tfPkgBasePrice != null : "fx:id=\"tfPkgBasePrice\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert tfAgencyCommission != null : "fx:id=\"tfAgencyCommission\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert dateStartDate != null : "fx:id=\"dateStartDate\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert dateEndDate != null : "fx:id=\"dateEndDate\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert cbPackageId != null : "fx:id=\"cbPackageId\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert tfPkgName != null : "fx:id=\"tfPkgName\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert taPkgDesc != null : "fx:id=\"taPkgDesc\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert tblPackages != null : "fx:id=\"tblPackages\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert colPackageId != null : "fx:id=\"colPackageId\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert colPkgName != null : "fx:id=\"colPkgName\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert colPkgStartDate != null : "fx:id=\"colPkgStartDate\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert colPkgEndDate != null : "fx:id=\"colPkgEndDate\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert colPkgDescription != null : "fx:id=\"colPkgDescription\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert colPkgBasePrice != null : "fx:id=\"colPkgBasePrice\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert colPkgAgencyComm != null : "fx:id=\"colPkgAgencyComm\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert tabEmployees != null : "fx:id=\"tabEmployees\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert anpEmp3 != null : "fx:id=\"anpEmp3\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert apControls3 != null : "fx:id=\"apControls3\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert tf13 != null : "fx:id=\"tf13\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert tf23 != null : "fx:id=\"tf23\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert tf33 != null : "fx:id=\"tf33\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert tf43 != null : "fx:id=\"tf43\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert tf53 != null : "fx:id=\"tf53\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert btnUpdate3 != null : "fx:id=\"btnUpdate3\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert btnInsert3 != null : "fx:id=\"btnInsert3\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert btnClear3 != null : "fx:id=\"btnClear3\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert datepicker13 != null : "fx:id=\"datepicker13\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert lblID3 != null : "fx:id=\"lblID3\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert btnApply3 != null : "fx:id=\"btnApply3\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert lbl13 != null : "fx:id=\"lbl13\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert lbl23 != null : "fx:id=\"lbl23\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert lbl33 != null : "fx:id=\"lbl33\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert lbl43 != null : "fx:id=\"lbl43\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert lbl73 != null : "fx:id=\"lbl73\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert lbl53 != null : "fx:id=\"lbl53\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert lbl6 != null : "fx:id=\"lbl6\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert lbl63 != null : "fx:id=\"lbl63\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert lbl83 != null : "fx:id=\"lbl83\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert tf63 != null : "fx:id=\"tf63\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert tf73 != null : "fx:id=\"tf73\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert tf83 != null : "fx:id=\"tf83\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert tf93 != null : "fx:id=\"tf93\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert lbl93 != null : "fx:id=\"lbl93\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert datepicker23 != null : "fx:id=\"datepicker23\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert tabReview != null : "fx:id=\"tabReview\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert tabFuture != null : "fx:id=\"tabFuture\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert btnExit != null : "fx:id=\"btnExit\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";

    //    AgentDB agentDb = new AgentDB(new data.dummy.AgentData());
     //   agents = FXCollections.observableArrayList( agentDb.getAgentList());
     //   tblAgents.setItems(agents);

        loadAgents();
        //load all the customers in the db
        loadCustomers();
        //load just the header of the booking table
        createBookingTableColumns();
        //load the booking of the selected customer -the first customer
        buildBookingForCustomerSelected( );

        //load all the packages in the db
        //   loadPackages();
        ////



        tblAgents.selectionModelProperty().addListener((Observable observable) -> {
                    int index = tblAgents.getSelectionModel().getSelectedIndex();
                    _selectedAgent = (Agent) tblAgents.getItems().get(index);
                    _selectedAgentIndex = index;


            tfAgentId.setText(String.valueOf(_selectedAgent.getAgentId()));
            tfAgtFirstName.setText(_selectedAgent.getAgtFirstName());
                    //setCellValueFactory(new PropertyValueFactory<>("agentId"));


                }
        );

    }
    //load all the packages into the packages table
    void loadPackages()
    {
        tblPackages.refresh();
        PackageDB packageDB = new PackageDB(new data.dummy.PackageData());
        packages = null;//FXCollections.observableArrayList( packageDB.getPackageList());

        //define the table column
        colPackageId = new TableColumn<>("Id");
        colPackageId.setCellValueFactory(new PropertyValueFactory<>("PackageId"));

        colPkgName = new TableColumn<>("Package Name");
        colPkgName.setCellValueFactory(new PropertyValueFactory<>("PkgName"));


        colPkgStartDate = new TableColumn<>("Start Date");
        colPkgStartDate.setCellValueFactory(new PropertyValueFactory<>("PkgStartDate"));

        colPkgEndDate = new TableColumn<>("End Date");
        colPkgEndDate.setCellValueFactory(new PropertyValueFactory<>("PkgEndDate"));

        colPkgDescription = new TableColumn<>("Description");
        colPkgDescription.setCellValueFactory(new PropertyValueFactory<>("PkgDescription"));

        colPkgBasePrice = new TableColumn<>("Base price");
        colPkgBasePrice.setCellValueFactory(new PropertyValueFactory<>("PkgBasePrice"));

        colPkgAgencyComm= new TableColumn<>("Commission");
        colPkgAgencyComm.setCellValueFactory(new PropertyValueFactory<>("PkgAgencyCommission"));



        tblPackages.getColumns().add(colPackageId);
        tblPackages.getColumns().add(colPkgName);
        tblPackages.getColumns().add(colPkgStartDate);
        tblPackages.getColumns().add(colPkgEndDate);
        tblPackages.getColumns().add(colPkgDescription);
        tblPackages.getColumns().add(colPkgBasePrice);
        tblPackages.getColumns().add(colPkgAgencyComm);

       /* tblPackages.setItems(packages);


        if (packages.size() != 0)
            selectedpackage=packages.get(0);
        tblPackages.getSelectionModel().select(0);

*/

    }



    //validate all the textfield return false if we find errors
    public String validateTextFieldsCustomer()
    {
        //this will verify all the user entry and return result in valid
        Validate valid =new Validate();
        String errorMessage=
                valid.validateTextField(tfCustFirstName.getText(),REGEX_NAME,2,25,"First Name") +
                        valid.validateTextField(tfCustLastName.getText(),REGEX_NAME,2,25,"Last Name")+
                        valid.validateTextFieldNoRegexp(tfCustAddress.getText(),6,75,"Address")+
                        valid.validateTextField(tfCustCity.getText(),REGEX_NAME,2,25,"City")+
                        valid.validateTextField(tfCustProv.getText(),REGEX_NAME,2,25,"Province")+
                        valid.validateTextField(tfCustPostal.getText(),REGEX_POSTAL,7,7,"Postal Code")+
                        valid.validateTextFieldNullValue(tfCustCountry.getText(),REGEX_NAME,25,"Country")+
                        valid.validateTextFieldNullValue(tfCustHomePhone.getText(),REGEX_PHONE,10,"Home Phone")+
                        valid.validateTextField(tfCustBusPhone.getText(),REGEX_PHONE,10,10,"Business Phone")+
                        valid.validateTextField(tfCustEmail.getText(),REGEX_EMAIL,6,50,"Email")+
                        valid.validateTextFieldNullValue(tfAgentId.getText(),REGEX_NUMBER,11,"Agent Id")+
                        valid.validateTextFieldNullValue(tfCustUsername.getText(),REGEX_USERNAME,20,"Username")+
                        valid.validateTextFieldNullValue(tfCustPassword.getText(),REGEX_PASSWORD,20,"Password");

        return errorMessage;
    }
    //set disable to all textfield with value in status
    public void setDisableTextFieldElementCustomer( boolean status)
    {
        tfCustomerId.setDisable(true);
        tfCustFirstName.setDisable(status);
        tfCustLastName.setDisable(status);
        tfCustAddress.setDisable(status);
        tfCustBusPhone.setDisable(status);
        tfCustHomePhone.setDisable(status);
        tfCustCity.setDisable(status);
        tfCustProv.setDisable(status);
        tfCustEmail.setDisable(status);
        tfCustPostal.setDisable(status);
        tfCustCountry.setDisable(status);
        tfAgentId.setDisable(status);
        tfCustUsername.setDisable(status);
        tfCustPassword.setDisable(status);

    }

    //get new customer from textfield after checking data entered by the user
    public Customer getNewCustomerFromTextField()
    {
        Customer newCustomer = new
                Customer( Integer.parseInt( tfCustomerId.getText().toString() ), tfCustFirstName.getText(), tfCustLastName.getText(), tfCustAddress.getText(),
                tfCustCity.getText(), tfCustProv.getText(), tfCustPostal.getText(), tfCustCountry.getText()
                ,tfCustHomePhone.getText(), tfCustBusPhone.getText(), tfCustEmail.getText(),Integer.parseInt( tfAgentId.getText()), tfCustUsername.getText(),
                tfCustPassword.getText());

        return newCustomer;
    }

    //load customer field with value in cust
    public void loadCustomer(Customer cust)
    {
        clearCustumerTextField();
        tfCustomerId.setText(cust.getCustomerId()+"");
        tfCustomerId.setDisable(true);
        tfCustFirstName.setText(cust.getCustFirstName().trim());
        tfCustLastName.setText(cust.getCustLastName().trim());
        tfCustAddress.setText(cust.getCustAddress().trim());
        tfCustBusPhone.setText(cust.getCustBusPhone().trim());
        tfCustHomePhone.setText(cust.getCustHomePhone().trim());
        tfCustCity.setText(cust.getCustCity().trim());
        tfCustProv.setText(cust.getCustProv().trim());
        tfCustEmail.setText(cust.getCustEmail().trim());
        tfCustPostal.setText(cust.getCustPostal().trim());
        tfCustCountry.setText(cust.getCustCountry().trim());
        tfAgentId.setText(cust.getAgentId()+"");
        tfCustUsername.setText(cust.getCustusername().trim());
        tfCustPassword.setText(cust.getCustpassword().trim());
        tfCustFirstName.requestFocus();

    }

    public void clearCustumerTextField()
    {
        tfCustomerId.clear();
        tfCustFirstName.clear();
        tfCustLastName.clear();
        tfCustAddress.clear();
        tfCustBusPhone.clear();
        tfCustHomePhone.clear();
        tfCustCity.clear();
        tfCustProv.clear();
        tfCustEmail.clear();
        tfCustPostal.clear();
        tfCustCountry.clear();
        tfAgentId.clear();
        tfCustUsername.clear();
        tfCustPassword.clear();

    }


    public void loadCustomers()
    {

        tblCustomers.refresh();
        CustomerDB customerDB = new CustomerDB(new data.dummy.CustomerData());
        customers = FXCollections.observableArrayList( customerDB.getCustomerList());

        //properties access method
        colCustomerId = new TableColumn<>("Id");
        colCustomerId.setCellValueFactory(new PropertyValueFactory<>("CustomerId"));

        colCustFirstName = new TableColumn<>("First Name");
        colCustFirstName.setCellValueFactory(new PropertyValueFactory<>("CustFirstName"));


        colCustLastName = new TableColumn<>("Last Name");
        colCustLastName.setCellValueFactory(new PropertyValueFactory<>("CustLastName"));

        colCustAddress = new TableColumn<>("Address");
        colCustAddress.setCellValueFactory(new PropertyValueFactory<>("CustAddress"));

        colCustCity = new TableColumn<>("City");
        colCustCity.setCellValueFactory(new PropertyValueFactory<>("CustCity"));

        colCustProv = new TableColumn<>("Province");
        colCustProv.setCellValueFactory(new PropertyValueFactory<>("CustProv"));

        colCustPostal= new TableColumn<>("Postal Code");
        colCustPostal.setCellValueFactory(new PropertyValueFactory<>("CustPostal"));

        colCustCountry= new TableColumn<>("Country");
        colCustCountry.setCellValueFactory(new PropertyValueFactory<>("CustCountry"));

        colCustHomePhone= new TableColumn<>("Home Phone");
        colCustHomePhone.setCellValueFactory(new PropertyValueFactory<>("CustHomePhone"));

        colCustBusPhone= new TableColumn<>("Business Phone");
        colCustBusPhone.setCellValueFactory(new PropertyValueFactory<>("CustBusPhone"));

        colCustEmail= new TableColumn<>("Email");
        colCustEmail.setCellValueFactory(new PropertyValueFactory<>("CustEmail"));

        colCustAgentId= new TableColumn<>("Agent Id");
        colCustAgentId.setCellValueFactory(new PropertyValueFactory<>("AgentId"));

        colCustusername= new TableColumn<>("Username");
        colCustusername.setCellValueFactory(new PropertyValueFactory<>("Custusername"));

        colCustpassword= new TableColumn<>("Password");
        colCustpassword.setCellValueFactory(new PropertyValueFactory<>("Custpassword"));



        tblCustomers.getColumns().add(colCustomerId);
        tblCustomers.getColumns().add(colCustFirstName);
        tblCustomers.getColumns().add(colCustLastName);
        tblCustomers.getColumns().add(colCustAddress);
        tblCustomers.getColumns().add(colCustCity);
        tblCustomers.getColumns().add(colCustProv);
        tblCustomers.getColumns().add(colCustPostal);
        tblCustomers.getColumns().add(colCustCountry);
        tblCustomers.getColumns().add(colCustHomePhone);
        tblCustomers.getColumns().add(colCustBusPhone);
        tblCustomers.getColumns().add(colCustEmail);
        tblCustomers.getColumns().add(colCustAgentId);
        tblCustomers.getColumns().add(colCustusername);
        tblCustomers.getColumns().add(colCustpassword);


        for (Customer a: customers ) {
            tblCustomers.getItems().add(a);
        }

        if (customers.size() != 0)
            selectedCustomer=customers.get(0);
        tblCustomers.getSelectionModel().select(0);

        //set disable the update btn  , until we click on edit then it will become enable again
        btnUpdate.setDisable(true);
        clearCustumerTextField();
        setDisableTextFieldElementCustomer(false);



    }

    //method below will enable login and disable logout button
    //run it as default or when login was NOT successful
    public void EnableLoginDisableLogout() {
        btnLogin.setDisable(false);
        btnLogOut.setDisable(true);

        tabAgents.setDisable(true);
        tabCustomers.setDisable(true);
        tabEmployees.setDisable(true);
        tabFuture.setDisable(true);
        tabPackages.setDisable(true);
        tabReview.setDisable(true);

    }
    //method below will disable login and enable logout button
    //run it when login was SUCCESSFUL
    public void DisableLoginEnableLogout() {
        btnLogin.setDisable(true);
        btnLogOut.setDisable(false);

tabAgents.setDisable(false);
tabCustomers.setDisable(false);
tabEmployees.setDisable(false);
tabFuture.setDisable(false);
tabPackages.setDisable(false);
tabReview.setDisable(false);
    }

    public void loadAgents() {

        tblAgents.refresh();
        AgentDB agentDb = new AgentDB(new data.dummy.AgentData());
        agents = FXCollections.observableArrayList( agentDb.getAgentList());

        colAgentId = new TableColumn<>("Id");
        colAgentId.setCellValueFactory(new PropertyValueFactory<>("agentId"));

        colAgtFirstName = new TableColumn<>("First Name");
        colAgtFirstName.setCellValueFactory(new PropertyValueFactory<>("agtFirstName"));

        colAgtMiddleInitial = new TableColumn<>("Middle Initial");
        colAgtMiddleInitial.setCellValueFactory(new PropertyValueFactory<>("agtMiddleInitial"));

        colAgtLastName = new TableColumn<>("Last Name");
        colAgtLastName.setCellValueFactory(new PropertyValueFactory<>("agtLastName"));

        colAgtBusPhone = new TableColumn<>("Business Phone");
        colAgtBusPhone.setCellValueFactory(new PropertyValueFactory<>("agtBusPhone"));

        colAgtEmail = new TableColumn<>("Email");
        colAgtEmail.setCellValueFactory(new PropertyValueFactory<>("agtEmail"));

        colAgtPosition = new TableColumn<>("Position");
        colAgtPosition.setCellValueFactory(new PropertyValueFactory<>("agtPosition"));

        colAgencyId= new TableColumn<>("Agency Id");
        colAgencyId.setCellValueFactory(new PropertyValueFactory<>("agtPosition"));


        tblAgents.getColumns().add(colAgentId);
        tblAgents.getColumns().add(colAgtFirstName);
        tblAgents.getColumns().add(colAgtMiddleInitial);
        tblAgents.getColumns().add(colAgtLastName);
        tblAgents.getColumns().add(colAgtBusPhone);
        tblAgents.getColumns().add(colAgtEmail);
        tblAgents.getColumns().add(colAgtPosition);
        tblAgents.getColumns().add(colAgencyId);


        for (Agent a: agents ) {
            tblAgents.getItems().add(a);
        }


    }



}
