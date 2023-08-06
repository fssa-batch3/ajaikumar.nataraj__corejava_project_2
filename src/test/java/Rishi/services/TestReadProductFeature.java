package Rishi.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class TestReadProductFeature {

    public static void main(String[] args) {
        try {
    		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rishi_agri_market", "root", "123456");

            String selectQuery = "SELECT * FROM rishi_agri_market.productdetails";
            PreparedStatement statement = connection.prepareStatement(selectQuery);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                int quantity = resultSet.getInt("quantity");
                String description = resultSet.getString("description");
                String url = resultSet.getString("url");
                String district = resultSet.getString("district");
                String type = resultSet.getString("type");
                String city = resultSet.getString("city");
                int userId = resultSet.getInt("userId");
                int pincode = resultSet.getInt("pincode");
                Date uploadDate = resultSet.getDate("uploadDate");

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
