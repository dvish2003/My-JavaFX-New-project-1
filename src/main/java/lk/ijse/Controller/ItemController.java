package lk.ijse.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.DataBase.DB;
import lk.ijse.Entity.Customer;
import lk.ijse.Entity.Item;

public class ItemController {

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private AnchorPane btnItem;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableView<Item> tableItem;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtQty;

    @FXML
    void btnAddOnAction(ActionEvent event) {
        String id = txtId.getText();
        String name = txtName.getText();
        double Price = Double.parseDouble(txtPrice.getText());
        int Qty = Integer.parseInt(txtQty.getText());

        boolean isExist = false;
        for (Item item:DB.itemArrayList) {
            if (item.getId().equals(id)){
                isExist = true;
                break;
            }
        }

        if (!isExist){
            DB.itemArrayList.add(new Item(id,name, (int) Price,Qty));
        }else {
            new Alert(Alert.AlertType.ERROR,"Duplicate Item ID").showAndWait();
        }

        System.out.println(DB.itemArrayList);
        getAllItems();
        clearTextFiled();


    }
   public void getAllItems(){
       colId.setCellValueFactory(new PropertyValueFactory<>("id"));
       colName.setCellValueFactory(new PropertyValueFactory<>("name"));
       colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
       colQty.setCellValueFactory(new PropertyValueFactory<>("Qty"));
       ObservableList<Item> itemObservableList = FXCollections.observableArrayList();

       for (Item item:DB.itemArrayList) {
           itemObservableList.add(new Item(item.getId(),item.getName(), (int) item.getPrice(),item.getQty()));
       }

       tableItem.setItems(itemObservableList);

   }



    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String ID = txtId.getText();
        int index = 0;
        for (Item item : DB.itemArrayList) {
            if(item.getId().equals(ID)){
                DB.customerArrayList.remove(index);
                break;

            }
            index++;

        }
        getAllItems();
        clearTextFiled();
        System.out.println(DB.itemArrayList);


    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id = txtId.getText();
        String name = txtName.getText();
        double Price = Double.parseDouble(txtPrice.getText());
        int Qty = Integer.parseInt(txtQty.getText());

        int index = 0;

        for(Item item : DB.itemArrayList){
            if(item.getId().equals(id)){
                DB.itemArrayList.add(new Item(id,name, (int) Price,Qty));
                break;
            }
            index++;
            System.out.println(DB.itemArrayList);
        }
        getAllItems();

    }

    @FXML
    void rowClickOnAction(MouseEvent event) {
        int index = tableItem.getSelectionModel().getSelectedIndex();

        if (index<= -1){
            return;
        }

        String id = colId.getCellData(index).toString();
        String name = colName.getCellData(index).toString();
        String Price = colPrice.getCellData(index).toString();
        String Qty = colQty.getCellData(index).toString();


        txtId.setText(id);
        txtName.setText(name);
        txtPrice.setText(Price);
        txtQty.setText(Qty);

    }
    public void clearTextFiled(){
        txtId.clear();
        txtPrice.clear();
        txtName.clear();
        txtQty.clear();
    }



}
