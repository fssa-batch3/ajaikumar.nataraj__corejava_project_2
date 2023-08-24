package com.fssa.rishi.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.fssa.rishi.utils.ConnectionUtil;

public class TestReadBuyerFeature {

    public static void main(String[] args) {
        try {
			Connection connection = ConnectionUtil.getConnection();

            String selectQuery = "SELECT * FROM rishi_agri_market.user";
            PreparedStatement statement = connection.prepareStatement(selectQuery);

            ResultSet resultSet = statement.executeQuery();
			String Query = "User Attributes  username = ?, password = ?, phone_number = ?, district = ?, state = ?, address = ?, dob = ?, pincode = ?, gender = ?, id = ?, is_seller = ? WHERE email = ?";
  
            while (resultSet.next()) {
                if (resultSet.getInt("is_seller") == 0) {
                String name = resultSet.getString("username");
                String password = resultSet.getString("password");
                String price = resultSet.getString("phone_number");
                String district = resultSet.getString("district");
                String state = resultSet.getString("state");
                String address = resultSet.getString("address");
                Date dob = resultSet.getDate("dob");
                String pincode = resultSet.getString("pincode");
                String gender = resultSet.getString("gender");
                String userId = resultSet.getString("id");
                String email = resultSet.getString("email");

                System.out.println("UserName: " + name);
                System.out.println("Password: " + password);
                System.out.println("Price: " + price);
                System.out.println("District: " + district);
                System.out.println("State: " + state);
                System.out.println("Address: " + address);
                System.out.println("Dob: " + dob);
                System.out.println("Pincode: " + pincode);
                System.out.println("Gender: " + gender);
                System.out.println("User ID: " + userId);
                System.out.println("Email: " + email);
                System.out.println("------------------------------------");
                System.out.println("------------------------------------");
                System.out.println("------------------------------------");
            }
        }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

