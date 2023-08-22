package com.fssa.rishi.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.fssa.rishi.utils.ConnectionUtil;

public class TestReadProductFeature {

    public static void main(String[] args) {
        try {
			Connection connection = ConnectionUtil.getConnection();

            String selectQuery = "SELECT * FROM rishi_agri_market.product_details";
            PreparedStatement statement = connection.prepareStatement(selectQuery);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                int quantity = resultSet.getInt("quantity");
                String description = resultSet.getString("description");
                String url = resultSet.getString("url");
                String district = resultSet.getString("district");
                String type = resultSet.getString("type");
                String city = resultSet.getString("city");
                long userId = resultSet.getLong("seller_id");
                int pincode = resultSet.getInt("pincode");
                Date uploadDate = resultSet.getDate("upload_date");
   
                System.out.println("Product ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Price: " + price);
                System.out.println("Quantity: " + quantity);
                System.out.println("Description: " + description);
                System.out.println("URL: " + url);
                System.out.println("District: " + district);
                System.out.println("Type: " + type);
                System.out.println("City: " + city);
                System.out.println("User ID: " + userId);
                System.out.println("Pincode: " + pincode);
                System.out.println("Upload Date: " + uploadDate);
                System.out.println("------------------------------------");
                System.out.println("------------------------------------");
                System.out.println("------------------------------------");
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
