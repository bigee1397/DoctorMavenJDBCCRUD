package com.doctorapp.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DoctorDB {

    static Connection connection;
    private static String url = "jdbc:mysql://localhost:3306/doctormavenjdbc";
    private static String username = "root";
    private static String password = "root";
    public static Connection openConnetion() {
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

}
