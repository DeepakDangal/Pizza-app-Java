package com.example.csd214_test3;

import com.example.csd214_test3.model.order;
import com.example.csd214_test3.model.orderDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;


public class HelloController implements Initializable {

        public TextField iid;

        public TextField iname;
        public TextField isize;

        public TextField itoppings;



        @FXML
        private TableView<order> tableView;
        @FXML
        private TableColumn<order, Integer> id;
        @FXML
        private TableColumn<order, String> name;

        @FXML
        private TableColumn<order, Integer> size;
        @FXML
        private TableColumn<order, Integer> toppings;
        @FXML
        private TableColumn<order, Double> total;

        ObservableList<order> list = FXCollections.observableArrayList();

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
            id.setCellValueFactory(new PropertyValueFactory<>("id"));
            name.setCellValueFactory(new PropertyValueFactory<>("name"));

            size.setCellValueFactory(new PropertyValueFactory<>("size"));
            toppings.setCellValueFactory(new PropertyValueFactory<>("toppings"));
            total.setCellValueFactory(new PropertyValueFactory<>("total"));
            tableView.setItems(list);
        }
    public void orderClick(ActionEvent actionEvent) {
        orderDAO a = new orderDAO(); // creating object
        list = a.populateTable(); // calling method using object of that class
        tableView.setItems(list);//setting ObservableList list into tableview.
    }
    public void insertClick(ActionEvent actionEvent) {
        String name= iname.getText();
        String size= isize.getText();
        int toppings=Integer.parseInt(itoppings.getText());
        orderDAO a = new orderDAO(); // creating object
        double total=total_bill(size,toppings);
        a.InsertData(name,size,toppings,total); // calling method using object of that class and passing data

    }

    public void updateClick(ActionEvent actionEvent) {
        String name= iname.getText();
        String size=isize.getText();
        int toppings=Integer.parseInt(itoppings.getText());
        int id= Integer.parseInt(iid.getText());
        orderDAO a = new orderDAO(); // creating object
        double total=total_bill(size,toppings);
        a.UpdateData(id,name, size,toppings,total);
    }


    public void deleteClick(ActionEvent actionEvent) {
        int id= Integer.parseInt(iid.getText());
        orderDAO a= new orderDAO(); // creating object
        a.DeleteData(id); // calling method using object of that class and deleting data

    }
    private static double RESULT;
    private static int total_bill = 0;
public static double total_bill(String size,int topping ){
    String a = size;
    int b = topping;
    if (a == "XL") {
        total_bill = total_bill + 12;
    }
    if (a == "L") {
        total_bill = total_bill + 10;
    }
    if (a == "M") {
        total_bill = total_bill + 8;
    }
    if (a == "S") {
        total_bill = total_bill + 6;
    }
    RESULT = total_bill + (b * 1.25);

    return RESULT;
}


}
