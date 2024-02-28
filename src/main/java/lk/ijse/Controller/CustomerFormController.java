package lk.ijse.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.DataBase.DB;
import lk.ijse.Entity.Customer;

public class CustomerFormController {



    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnUpdate;

    public void initialize(){

        getAllCustomers();
    }

    @FXML
    private TableColumn<?, ?> colCustomerADDRESS;

    @FXML
    private TableColumn<?, ?> colCustomerID;

    @FXML
    private TableColumn<?, ?> colCustomerNAME;

    @FXML
    private TableView<Customer> tableCustomer;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    void btnAddOnAction(ActionEvent event) {
      String ID = txtId.getText();
      String NAME = txtName.getText();
      String ADDRESS = txtAddress.getText();

        Customer customer = new Customer();
        customer.setID(ID);
        customer.setNAME(NAME);
        customer.setADDRESS(ADDRESS);

        DB.customerArrayList.add(customer);
        getAllCustomers();

        System.out.println(customer);
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String ID = txtId.getText();
        int index = 0;
        for (Customer customer : DB.customerArrayList) {
            if(customer.getID().equals(ID)){
                DB.customerArrayList.remove(index);
                break;

            }
            index++;
            System.out.println(customer);

        }
        getAllCustomers();
        clearTextFiled();

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
         String id = txtId.getText();
         String Name = txtName.getText();
         String Address = txtAddress.getText();
         int index = 0;

         for(Customer customer : DB.customerArrayList){
            if(customer.getID().equals(id)){
                DB.customerArrayList.set(index,new Customer(id,Name,Address));
                break;
            }
            index++;
         }
    }
    public void getAllCustomers(){
        colCustomerID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        colCustomerNAME.setCellValueFactory(new PropertyValueFactory<>("NAME"));
        colCustomerADDRESS.setCellValueFactory(new PropertyValueFactory<>("ADDRESS"));

        ObservableList<Customer> customerObservableList = FXCollections.observableArrayList();
        for(Customer customer :DB.customerArrayList){
            customerObservableList.add(new Customer(customer.getID(),customer.getNAME(),customer.getADDRESS()));
        }
        tableCustomer.setItems(customerObservableList);
    }
    public void clearTextFiled(){
        txtAddress.clear();
        txtId.clear();
        txtName.clear();
    }


    public void rowClickOnAction(MouseEvent mouseEvent) {
     int index = tableCustomer.getSelectionModel().getSelectedIndex();
     if (index<= -1){
         return;
     }
        String id = colCustomerID.getCellData(index).toString();
        String Name = colCustomerNAME.getCellData(index).toString();
        String Address = colCustomerADDRESS.getCellData(index).toString();

        txtId.setText(id);
        txtName.setText(Name);
        txtAddress.setText(Address);

    }


}
