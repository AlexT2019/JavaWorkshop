package sample;

import java.net.URL;
import java.util.ResourceBundle;

import data.AgentDB;
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


public class Controller {

private ObservableList<Agent> agents = FXCollections.observableArrayList();

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
    private AnchorPane anpEmp1;

    @FXML
    private TableView<?> tblBookings;

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
    private TextField tfCustId;

    @FXML
    private TextField tfCustFirstName;

    @FXML
    private TextField tfCustMiddleInitial;

    @FXML
    private TextField tfCustLastName;

    @FXML
    private TextField tfCustPhone;

    @FXML
    private Label lblID1;

    @FXML
    private Label lbl11;

    @FXML
    private Label lbl21;

    @FXML
    private Label lbl31;

    @FXML
    private Label lbl41;

    @FXML
    private Label lbl71;

    @FXML
    private Label lbl51;

    @FXML
    private TextField tfCustEmail;

    @FXML
    private TextField tfCustNotes;

    @FXML
    private Button btnUpdateCustomer;

    @FXML
    private Button btnInsertCustomer;

    @FXML
    private Button btnSaveCustomer;

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
    private TableView<?> tblPackages;

    @FXML
    private TableColumn<?, ?> colPackageId;

    @FXML
    private TableColumn<?, ?> colPkgName;

    @FXML
    private TableColumn<?, ?> colPkgStartDate;

    @FXML
    private TableColumn<?, ?> colPkgEndDate;

    @FXML
    private TableColumn<?, ?> colPkgDescription;

    @FXML
    private TableColumn<?, ?> colPkgBasePrice;

    @FXML
    private TableColumn<?, ?> colPkgAgencyComm;

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
        assert tfCustId != null : "fx:id=\"tfCustId\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert tfCustFirstName != null : "fx:id=\"tfCustFirstName\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert tfCustMiddleInitial != null : "fx:id=\"tfCustMiddleInitial\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert tfCustLastName != null : "fx:id=\"tfCustLastName\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert tfCustPhone != null : "fx:id=\"tfCustPhone\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert lblID1 != null : "fx:id=\"lblID1\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert lbl11 != null : "fx:id=\"lbl11\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert lbl21 != null : "fx:id=\"lbl21\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert lbl31 != null : "fx:id=\"lbl31\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert lbl41 != null : "fx:id=\"lbl41\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert lbl71 != null : "fx:id=\"lbl71\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert lbl51 != null : "fx:id=\"lbl51\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert tfCustEmail != null : "fx:id=\"tfCustEmail\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert tfCustNotes != null : "fx:id=\"tfCustNotes\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert btnUpdateCustomer != null : "fx:id=\"btnUpdateCustomer\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert btnInsertCustomer != null : "fx:id=\"btnInsertCustomer\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert btnSaveCustomer != null : "fx:id=\"btnSaveCustomer\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
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

        tblAgents.selectionModelProperty().addListener((Observable observable) -> {
                    int index = tblAgents.getSelectionModel().getSelectedIndex();
                    _selectedAgent = (Agent) tblAgents.getItems().get(index);
                    _selectedAgentIndex = index;


            tfAgentId.setText(String.valueOf(_selectedAgent.getAgentId()));
            tfAgtFirstName.setText(_selectedAgent.getAgtFirstName());
                    //setCellValueFactory(new PropertyValueFactory<>("agentId"));

//
                }
        );

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
