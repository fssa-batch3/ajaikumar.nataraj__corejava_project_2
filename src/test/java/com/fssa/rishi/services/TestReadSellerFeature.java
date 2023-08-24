package com.fssa.rishi.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.fssa.rishi.utils.ConnectionUtil;

public class TestReadSellerFeature {

    public static void main(String[] args) {
        try {
			Connection connection = ConnectionUtil.getConnection();

            //String selectQuery = "SELECT * FROM rishi_agri_market.seller";
            String selectQuery = "SELECT * FROM rishi_agri_market.user INNER JOIN rishi_agri_market.seller ON rishi_agri_market.user.email = rishi_agri_market.seller.email";
          //  SELECT columns
          //  FROM table1 
          //  INNER JOIN table2 ON table1.column = table2.column;
            PreparedStatement statement = connection.prepareStatement(selectQuery);

            ResultSet resultSet = statement.executeQuery();
			String Query = "Seller Attributes id = ?, username = ?, password = ?, phone_number = ?, district = ?, state = ?, address = ?, land_address = ?, dob = ?, pincode = ?, gender = ?, land_type = ? WHERE email = ?";
 
            while (resultSet.next()) {   
                String userId = resultSet.getString("id");
                String name = resultSet.getString("username");
                String password = resultSet.getString("password");
                String phoneNumber = resultSet.getString("phone_number");
                String district = resultSet.getString("district");
                String state = resultSet.getString("state");
                String homeAddress = resultSet.getString("address");
                String landAddress = resultSet.getString("land_address");
                Date dob = resultSet.getDate("dob");
                String pincode = resultSet.getString("pincode");
                String gender = resultSet.getString("gender");
                String landType = resultSet.getString("land_type");
                String email = resultSet.getString("email");

                System.out.println("User ID: " + userId);
                System.out.println("UserName: " + name);
                System.out.println("Password: " + password);
                System.out.println("Phone Number: " + phoneNumber);
                System.out.println("District: " + district);
                System.out.println("State: " + state);
                System.out.println("Home Address: " + homeAddress);
                System.out.println("Land Address: " + landAddress);
                System.out.println("Dob: " + dob);
                System.out.println("Pincode: " + pincode);
                System.out.println("Gender: " + gender);
                System.out.println("Land Type: " + landType);
                System.out.println("Email: " + email);
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

