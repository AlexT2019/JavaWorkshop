package sample;

import java.lang.annotation.Target;
import java.net.URL;
import java.util.ResourceBundle;

import data.AgencyDB;
import data.AgentDB;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.Agency;
import model.Agent;


public class Controller {

private ObservableList<Agent> agents = FXCollections.observableArrayList();
private ObservableList<Agency> agencies = FXCollections.observableArrayList();

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

    @FXML // fx:id="tblSuppliers"
    private TableView<?> tblSuppliers; // Value injected by FXMLLoader


    @FXML // fx:id="tblProducts"
    private TableView<?> tblProducts; // Value injected by FXMLLoader

    @FXML // fx:id="btnAddProd"
    private Button btnAddProd; // Value injected by FXMLLoader

    @FXML // fx:id="btnUpdateProd"
    private Button btnUpdateProd; // Value injected by FXMLLoader

    @FXML // fx:id="btnClearProd"
    private Button btnClearProd; // Value injected by FXMLLoader

    @FXML // fx:id="tfProdId"
    private TextField tfProdId; // Value injected by FXMLLoader

    @FXML // fx:id="tfProdName"
    private TextField tfProdName; // Value injected by FXMLLoader


    @FXML // fx:id="tfProdId1"
    private TextField tfProdId1; // Value injected by FXMLLoader

    @FXML // fx:id="tfProdName1"
    private TextField tfProdName1; // Value injected by FXMLLoader

    @FXML // fx:id="btnAddSupplier"
    private Button btnAddSupplier; // Value injected by FXMLLoader

    @FXML // fx:id="btnUpdateSupplier"
    private Button btnUpdateSupplier; // Value injected by FXMLLoader

    @FXML // fx:id="btnClearSupplier"
    private Button btnClearSupplier; // Value injected by FXMLLoader


    @FXML // fx:id="btnUpdate3"
    private Button btnUpdate3; // Value injected by FXMLLoader


    @FXML // fx:id="tabSandP"
    private Tab tabSandP; // Value injected by FXMLLoader

    @FXML // fx:id="anpEmp2"
    private AnchorPane anpEmp2; // Value injected by FXMLLoader

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField tfUserPass;

    @FXML
    private AnchorPane anpEmp, apControls, anpEmp1, apCredentials, apControls1, anpEmp11, anpEmp3, apControls3;

    @FXML
    private TableView tblAgents, tblAgencies;

    @FXML
    private TableColumn<String, Agent> colAgentId, colAgtFirstName, colAgtMiddleInitial, colAgtLastName, colAgtBusPhone, colAgtEmail, colAgtPosition, colAgencyId;

    @FXML
    private ImageView imageViewAgentPhoto;

    @FXML
    private TableColumn<String, Agency> colAgncyId1, colAgncyAddress, colAgncyCity,colAgncyProv, colAgncyPostal, colAgncyCountry,
   colAgncyPhone, colAgncyFax;

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
    private TextField tfCustId, tfCustFirstName, tfCustMiddleInitial, tfCustLastName, tfCustPhone, tfCustEmail, tfCustNotes, tf6,tf7, tf8,
            tf13, tf23,  tf33,  tf43, tf53,  tf63, tf73, tf83, tf93, tfPkgBasePrice, tfAgencyCommission, tfPkgName, tfUserName, tfAgentId, tfAgtFirstName,
            tfAgtMiddleInitial, tfAgtLastName, tfAgtBusPhone, tfAgtEmail, tfAgtPosition, tfAgencyId;



    @FXML
    private Label lblID1,  lbl11, lbl21,lbl31, lbl41,lbl71,  lbl51, lbl311, lblID11, lbl211, lbl711, lblID,  lbl1, lbl2, lbl3, lbl4, lbl7,
            lbl5, lbl64, lblID3,  lbl13, lbl23, lbl33, lbl43, lbl73, lbl53,  lbl6, lbl63, lbl83, lbl93;


    @FXML
    private Button btnUpdatePackage,btnAddPackage, btnClearPackageTF, btnApplyPackageChanges,
    btnDeletePkg, btnExit, btnInsertCustomer,  btnSaveCustomer, btnUpdateCustomer, btnUpdate,
    btnClearAgent, btnDeleteAgent, btnInsertAgent, btnInsert3,  btnClear3, btnApply3, btnLogin, btnLogOut;


    @FXML
    private DatePicker datepicker13,  datepicker23, dateStartDate, dateEndDate;



    @FXML
    private ComboBox<?> cbPackageId;

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
    void btnAddProdOnMouseClick(MouseEvent event) {

    }

    @FXML
    void btnAddSupplierOnMouseClick(MouseEvent event) {

    }

    @FXML
    void btnClearProdOnMouseClick(MouseEvent event) {

    }

    @FXML
    void btnClearSupplierOnMouseClick(MouseEvent event) {

    }

    @FXML
    void btnUpdateProdOnMouseClick(MouseEvent event) {

    }

    @FXML
    void btnUpdateSupplierOnMouseClick(MouseEvent event) {

    }




    Agent _selectedAgent;
    Agency _selectedAgency;

    int _selectedAgentIndex;
    int _selectedAgencyIndex;
    int sendThisIndex = 1;

    AgentDB _agentDb;
    AgencyDB _agencyDb;


    private void initRestService() {
        _agentDb = new AgentDB(new data.dummy.AgentData());
        _agencyDb = new AgencyDB(new data.dummy.AgencyData());
    }

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
    void onUpdateAgentBtnClick(MouseEvent event) {
        UpdateAgent();
        refreshAgentTableView();
    }
    @FXML
    void onClearAgentBtnClick(MouseEvent event) {
        ClearAgentInputData();
    }

    public void onDeleteAgentBtnClick(MouseEvent mouseEvent) {
        DeleteSelectedAgent();
        ClearAgentInputData();
        refreshAgentTableView();
       Alert a = new Alert(Alert.AlertType.INFORMATION, "You're fired!");
       a.show();
    }

    @FXML
    void onInsertAgentBtnClick(MouseEvent event) {
        InsertAgent();
    }




  public void ClearAgentInputData(){
      tfAgentId.setText("");
      tfAgtPosition.setText("");
      tfAgtEmail.setText("");
      tfAgtBusPhone.setText("");
      tfAgtLastName.setText("");
      tfAgtFirstName.setText("");
      tfAgtMiddleInitial.setText("");
      tfAgencyId.setText("");
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
        assert imageViewAgentPhoto != null : "fx:id=\"imageViewAgentPhoto\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert tblAgencies != null : "fx:id=\"tblAgencies\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert apControls != null : "fx:id=\"apControls\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert tfAgentId != null : "fx:id=\"tfAgentId\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert tfAgtFirstName != null : "fx:id=\"tfAgtFirstName\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert tfAgtMiddleInitial != null : "fx:id=\"tfAgtMiddleInitial\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert tfAgtLastName != null : "fx:id=\"tfAgtLastName\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert tfAgtBusPhone != null : "fx:id=\"tfAgtBusPhone\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert lblID != null : "fx:id=\"lblID\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert lbl1 != null : "fx:id=\"lbl1\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert lbl2 != null : "fx:id=\"lbl2\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert lbl3 != null : "fx:id=\"lbl3\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert lbl4 != null : "fx:id=\"lbl4\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert lbl7 != null : "fx:id=\"lbl7\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert lbl5 != null : "fx:id=\"lbl5\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert lbl64 != null : "fx:id=\"lbl64\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert tfAgtEmail != null : "fx:id=\"tfAgtEmail\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert tfAgtPosition != null : "fx:id=\"tfAgtPosition\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert tfAgencyId != null : "fx:id=\"tfAgencyId\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert btnUpdate != null : "fx:id=\"btnUpdate\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert btnInsertAgent != null : "fx:id=\"btnInsertAgent\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert btnClearAgent != null : "fx:id=\"btnClearAgent\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert btnDeleteAgent != null : "fx:id=\"btnDeleteAgent\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert tabCustomers != null : "fx:id=\"tabCustomers\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert anpEmp1 != null : "fx:id=\"anpEmp1\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
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
        assert tabSandP != null : "fx:id=\"tabSandP\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert anpEmp2 != null : "fx:id=\"anpEmp2\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert tblSuppliers != null : "fx:id=\"tblSuppliers\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert imageViewAgentPhoto1 != null : "fx:id=\"imageViewAgentPhoto1\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert tblProducts != null : "fx:id=\"tblProducts\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert btnAddProd != null : "fx:id=\"btnAddProd\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert btnUpdateProd != null : "fx:id=\"btnUpdateProd\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert btnClearProd != null : "fx:id=\"btnClearProd\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert tfProdId != null : "fx:id=\"tfProdId\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert tfProdName != null : "fx:id=\"tfProdName\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert tfProdId1 != null : "fx:id=\"tfProdId1\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert tfProdName1 != null : "fx:id=\"tfProdName1\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert btnAddSupplier != null : "fx:id=\"btnAddSupplier\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert btnUpdateSupplier != null : "fx:id=\"btnUpdateSupplier\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert btnClearSupplier != null : "fx:id=\"btnClearSupplier\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";
        assert btnExit != null : "fx:id=\"btnExit\" was not injected: check your FXML file 'ExampleLayoutAlex.fxml'.";


        loadAgents();
        LoadAgencies();

        tblAgents.setOnMouseClicked((MouseEvent event) -> {
                    if (event.getButton().equals(MouseButton.PRIMARY)) {
                        int index = tblAgents.getSelectionModel().getSelectedIndex();
                        _selectedAgent = (Agent) tblAgents.getItems().get(index);
                        _selectedAgentIndex = index;

                        System.out.println("Selected Agent" + _selectedAgent.toString());
                        System.out.println("Selected AgentIndex" + _selectedAgentIndex);

                        tfAgentId.setText(String.valueOf(_selectedAgent.getAgentId()));
                        tfAgtFirstName.setText(_selectedAgent.getAgtFirstName());
                        tfAgtMiddleInitial.setText(_selectedAgent.getAgtMiddleInitial());
                        tfAgtLastName.setText(_selectedAgent.getAgtLastName());
                        tfAgtBusPhone.setText(_selectedAgent.getAgtBusPhone());
                        tfAgtEmail.setText(_selectedAgent.getAgtEmail());
                        tfAgtPosition.setText(_selectedAgent.getAgtPosition());
                        tfAgencyId.setText(String.valueOf(_selectedAgent.getAgencyId()));
                        sendThisIndex = Integer.valueOf(_selectedAgent.getAgencyId());
                      //  LoadAgency(sendThisIndex);
                        RefreshAgencyTableViewSingle(sendThisIndex);
                    }
                }
        );

        tblAgencies.setOnMouseClicked((MouseEvent event) -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
           sendThisIndex =  Integer.valueOf(_selectedAgent.getAgencyId());
//input code to show only the agents who are in that agency

            }
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

        _agentDb = new AgentDB(new data.dummy.AgentData());
        agents = FXCollections.observableArrayList( _agentDb.getAgentList());

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
        colAgencyId.setCellValueFactory(new PropertyValueFactory<>("agencyId"));

        tblAgents.getColumns().add(colAgentId);
        tblAgents.getColumns().add(colAgtFirstName);
        tblAgents.getColumns().add(colAgtMiddleInitial);
        tblAgents.getColumns().add(colAgtLastName);
        tblAgents.getColumns().add(colAgtBusPhone);
        tblAgents.getColumns().add(colAgtEmail);
        tblAgents.getColumns().add(colAgtPosition);
        tblAgents.getColumns().add(colAgencyId);

        refreshAgentTableView();
            RefreshAgencyTableView();
        //RefreshAgencyTableViewSingle(sendThisIndex);
    }

    public void LoadAgencies(){
        _agencyDb = new AgencyDB(new data.dummy.AgencyData());
        agencies = FXCollections.observableArrayList( _agencyDb.getAgencyList());

        colAgencyId1 = new TableColumn<>("Id");
        colAgencyId1.setCellValueFactory(new PropertyValueFactory<>("AgencyId"));

        colAgncyAddress = new TableColumn<>("Address");
        colAgncyAddress.setCellValueFactory(new PropertyValueFactory<>("AgncyAddress"));

        colAgncyCity= new TableColumn<>("City");
        colAgncyCity.setCellValueFactory(new PropertyValueFactory<>("AgncyCity"));

        colAgncyProv = new TableColumn<>("Province");
        colAgncyProv.setCellValueFactory(new PropertyValueFactory<>("AgncyProv"));

        colAgncyPostal = new TableColumn<>("Postal Code");
        colAgncyPostal.setCellValueFactory(new PropertyValueFactory<>("AgncyPostal"));

        colAgncyCountry = new TableColumn<>("Country");
        colAgncyCountry.setCellValueFactory(new PropertyValueFactory<>("AgncyCountry"));

        colAgncyPhone = new TableColumn<>("Phone");
        colAgncyPhone.setCellValueFactory(new PropertyValueFactory<>("AgncyPhone"));

        colAgncyFax= new TableColumn<>("Fax");
        colAgncyFax.setCellValueFactory(new PropertyValueFactory<>("AgncyFax"));

        tblAgencies.getColumns().add(colAgencyId1);
        tblAgencies.getColumns().add(colAgncyAddress);
        tblAgencies.getColumns().add(colAgncyCity);
        tblAgencies.getColumns().add(colAgncyProv);
        tblAgencies.getColumns().add(colAgncyPostal);
        tblAgencies.getColumns().add(colAgncyCountry);
        tblAgencies.getColumns().add(colAgncyPhone);
        tblAgencies.getColumns().add(colAgncyFax);
        RefreshAgencyTableView();
    }

//    public void LoadAgency(int X){
//        _agencyDb = new AgencyDB(new data.dummy.AgencyData());
//        agencies = FXCollections.observableArrayList( _agencyDb.getAgency(X));
//        colAgencyId1 = new TableColumn<>("Id");
//        colAgencyId1.setCellValueFactory(new PropertyValueFactory<>("AgencyId"));
//
//        colAgncyAddress = new TableColumn<>("Address");
//        colAgncyAddress.setCellValueFactory(new PropertyValueFactory<>("AgncyAddress"));
//
//        colAgncyCity= new TableColumn<>("City");
//        colAgncyCity.setCellValueFactory(new PropertyValueFactory<>("AgncyCity"));
//
//        colAgncyProv = new TableColumn<>("Province");
//        colAgncyProv.setCellValueFactory(new PropertyValueFactory<>("AgncyProv"));
//
//        colAgncyPostal = new TableColumn<>("Postal Code");
//        colAgncyPostal.setCellValueFactory(new PropertyValueFactory<>("AgncyPostal"));
//
//        colAgncyCountry = new TableColumn<>("Country");
//        colAgncyCountry.setCellValueFactory(new PropertyValueFactory<>("AgncyCountry"));
//
//        colAgncyPhone = new TableColumn<>("Phone");
//        colAgncyPhone.setCellValueFactory(new PropertyValueFactory<>("AgncyPhone"));
//
//        colAgncyFax= new TableColumn<>("Fax");
//        colAgncyFax.setCellValueFactory(new PropertyValueFactory<>("AgncyFax"));
//
//        tblAgencies.getColumns().add(colAgencyId1);
//        tblAgencies.getColumns().add(colAgncyAddress);
//        tblAgencies.getColumns().add(colAgncyCity);
//        tblAgencies.getColumns().add(colAgncyProv);
//        tblAgencies.getColumns().add(colAgncyPostal);
//        tblAgencies.getColumns().add(colAgncyCountry);
//        tblAgencies.getColumns().add(colAgncyPhone);
//        tblAgencies.getColumns().add(colAgncyFax);
//        RefreshAgencyTableView();
//    }


    private void refreshAgentTableView() {
        tblAgents.getItems().clear();

        for (Agent a: agents ) {
            tblAgents.getItems().add(a);
        }
    }

    private void RefreshAgencyTableView() {
        tblAgencies.getItems().clear();

        for (Agency ay: agencies) {
            tblAgencies.getItems().add(ay);
        }
    }
    private void RefreshAgencyTableViewSingle(int x) {
        tblAgencies.getItems().clear();
        Agency ay = _agencyDb.getAgency(x);
        tblAgencies.getItems().add(ay);
    }

    public void UpdateAgent(){
        try {
            // VALIDATE !!!
            if(true) {

                int agentId = Integer.parseInt(tfAgentId.getText().trim());
                Integer newAgencyId = Integer.parseInt(tfAgencyId.getText().trim());
                String newagtFirstName = tfAgtFirstName.getText().trim();
                String newagtMiddleInitial = tfAgtMiddleInitial.getText().trim();
                String newagtLastName = tfAgtLastName.getText().trim();
                String newagtBusPhone = tfAgtBusPhone.getText().trim();
                String newagtEmail = tfAgtEmail.getText().trim();
                String newagtPosition = tfAgtPosition.getText().trim();

                Agent newAgent = new Agent(agentId, newagtFirstName, newagtMiddleInitial, newagtLastName, newagtBusPhone, newagtEmail, newagtPosition, newAgencyId );

                _agentDb = new AgentDB(new data.dummy.AgentData());
                String message = _agentDb.updateAgent(_selectedAgent, newAgent);
                refreshAgentTableView();
                System.out.println("Update:" + message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void DeleteSelectedAgent(){
        int agentId = Integer.parseInt(tfAgentId.getText());
        String message = _agentDb.deleteAgent(agentId);
        refreshAgentTableView();
        System.out.println("Agent# " + agentId + " was deleted." + message);
    }



    public void InsertAgent(){
        try {
            // VALIDATE !!!
            if(true) {
                int agentId = 999;
        Integer newAgencyId = Integer.parseInt(tfAgencyId.getText().trim());
        String newagtFirstName = tfAgtFirstName.getText().trim();
        String newagtMiddleInitial = tfAgtMiddleInitial.getText().trim();
        String newagtLastName = tfAgtLastName.getText().trim();
        String newagtBusPhone = tfAgtBusPhone.getText().trim();
        String newagtEmail = tfAgtEmail.getText().trim();
        String newagtPosition = tfAgtPosition.getText().trim();

        Agent newAgent = new Agent(agentId, newagtFirstName, newagtMiddleInitial, newagtLastName, newagtBusPhone, newagtEmail, newagtPosition, newAgencyId );
        _agentDb = new AgentDB(new data.dummy.AgentData());
        String message = _agentDb.insertAgent(newAgent);
        refreshAgentTableView();
        System.out.println("Added new fresh meat#: " + message);
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Fresh meat on our team!");
                a.show();

        ClearAgentInputData();}
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
