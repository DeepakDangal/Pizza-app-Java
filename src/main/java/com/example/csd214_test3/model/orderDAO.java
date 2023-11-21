package com.example.csd214_test3.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class orderDAO {
    ObservableList<order> list = FXCollections.observableArrayList();

    public ObservableList<order> populateTable() {
// Establish a database connection
        String jdbcUrl = "jdbc:mysql://localhost:3306/csd214_test3";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
// Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM tbl_order";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
// Populate the table with data from the database
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                String size =resultSet.getString("size");
                int toppings = resultSet.getInt("toppings");
                double total = resultSet.getDouble("total");

                list.add(new order(id,name,size,toppings,total));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void InsertData(String name, String size,int toppings,double total) {
// Establish a database connection
        String jdbcUrl = "jdbc:mysql://localhost:3306/csd214_test3";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl,
                dbUser,
                dbPassword)) {
// Execute a SQL query to insert data in the database
            String query = "INSERT INTO `tbl_order`(`name`, `size`, `toppings`, `total`)  VALUES ('"+name+"','"+size+"','"+toppings+"','"+total+"')";

            Statement statement = connection.createStatement();
            statement.execute(query);
// Populate the table with data from the database
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void UpdateData(int id, String name, String size, int toppings, double total) {
// Establish a database connection
        String jdbcUrl = "jdbc:mysql://localhost:3306/csd214_test3";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
// Execute a SQL query to Upataing data in the database
            String query = "UPDATE `tbl_order` SET`name`='"+name+"',`size`='"+size+"'`toppings`='"+toppings+"' WHERE id ='"+id+"'";
            Statement statement = connection.createStatement();
            statement.execute(query);
// Populate the table with data from the database
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void DeleteData(int id) {
// Establish a database connection
        String jdbcUrl = "jdbc:mysql://localhost:3306/csd214_test3";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl,
                dbUser,
                dbPassword)) {
// Execute a SQL query to Upataing data in the database
            String query = "DELETE FROM `tbl_order` WHERE id ='"+id+"'";
            Statement statement = connection.createStatement();
            statement.execute(query);
// Populate the table with data from the database
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

