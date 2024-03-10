package com.doctorapp.util;

public class Queries {
    public static String INSERTQUERY = "insert into doctor (doctor_name, speciality, experience, ratings, consultation_fees) values (?,?,?,?,?);";
    public static String UPDATEQUERY = "update doctor set consultation_fees=? where doctor_id=?;";
    public static String DELETEQUERY = "delete from doctor where doctor_id=?";
    public static String SELECTALL = "Select * from doctor";
    
    public static String FINDBYID = "Select * from doctor where doctor_id=?";
    public static String FINDBYSPECIALITY = "Select * from doctor where speciality=?";
    public static String FINDBYSPECANDEXP = "Select * from doctor where speciality=? and experience>?";
    public static String FINDBYSPECANDFEES = "Select * from doctor where speciality=? and consultation_fees<?";
    public static String FINDBYSPECANDRATINGS = "Select * from doctor where speciality=? and ratings>?";
    public static String FINDBYSPECANDNAMECONTAINS = "Select * from doctor where speciality=? and doctor_name like ?";

}
