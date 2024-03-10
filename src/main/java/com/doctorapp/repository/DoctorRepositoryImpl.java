package com.doctorapp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.doctorapp.exception.IdNotFoundException;
import com.doctorapp.model.Doctor;
import com.doctorapp.util.DoctorDB;
import com.doctorapp.util.Queries;

public class DoctorRepositoryImpl implements IDoctorRepository{

    @Override
    public void addDoctor(Doctor doctor) {
        try (
            Scanner sc =  new Scanner(System.in);
            Connection connection = DoctorDB.openConnetion();
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.INSERTQUERY)
        ) {
            preparedStatement.setString(1, doctor.getDoctorName());   
            preparedStatement.setString(2, doctor.getSpeciality());   
            preparedStatement.setInt(3, doctor.getExperience());   
            preparedStatement.setInt(4, doctor.getRatings());   
            preparedStatement.setDouble(5, doctor.getConsultationFees());
            boolean resultSet = preparedStatement.execute();
            System.out.println("1 row inserted "+!resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDoctor(double consultationFees, int doctorId) {
        try (
            Connection connection = DoctorDB.openConnetion();
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.UPDATEQUERY)
        ) {   
            preparedStatement.setDouble(1, consultationFees);
            preparedStatement.setInt(2, doctorId);  

                boolean resultSet = preparedStatement.execute();
                System.out.println("1 row updated "+!resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void daleteDoctor(int doctorId) {
        try (
            Connection connection = DoctorDB.openConnetion();
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.DELETEQUERY)
        ) {   
            preparedStatement.setInt(1, doctorId);  

                boolean resultSet = preparedStatement.execute();
                System.out.println("1 row deleted "+!resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Doctor findDoctorById(int doctorId) {
        Doctor doctor = new Doctor();
        try (
            Connection connection = DoctorDB.openConnetion();
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.FINDBYID)
        ) {   
            preparedStatement.setInt(1, doctorId);  
                try (
                    ResultSet resultSet = preparedStatement.executeQuery();
                ) {
                    while (resultSet.next()) {
                        doctor.setDoctorId(doctorId);
                        // doctor.setDoctorId(resultSet.getInt("doctor_id"));
                        doctor.setDoctorName(resultSet.getString("doctor_name"));
                        doctor.setSpeciality(resultSet.getString("speciality"));
                        doctor.setExperience(resultSet.getInt("experience"));
                        doctor.setRatings(resultSet.getInt("ratings"));
                        doctor.setConsultationFees(resultSet.getDouble("consultation_fees"));
                    }
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doctor;
    }

    @Override
    public List<Doctor> findAll() {
        List<Doctor> doctors = new ArrayList<>();
        try (
            Connection connection = DoctorDB.openConnetion();
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.SELECTALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            ) {
            while (resultSet.next()) {
                Doctor doctor = new Doctor();
                doctor.setDoctorId(resultSet.getInt("doctor_id"));
                doctor.setDoctorName(resultSet.getString("doctor_name"));
                doctor.setSpeciality(resultSet.getString("speciality"));
                doctor.setExperience(resultSet.getInt("experience"));
                doctor.setRatings(resultSet.getInt("ratings"));
                doctor.setConsultationFees(resultSet.getDouble("consultation_fees"));
                doctors.add(doctor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doctors;
    }

    @Override
    public List<Doctor> findBySpeciality(String speciality) {
        List<Doctor> doctorsBySpeciality = new ArrayList<>();
        try (
            Connection connection = DoctorDB.openConnetion();
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.FINDBYSPECIALITY);
            ) {
                preparedStatement.setString(1, speciality);
                try (ResultSet resultSet = preparedStatement.executeQuery();) {
                    while (resultSet.next()) {
                        Doctor doctor = new Doctor();
                        doctor.setDoctorId(resultSet.getInt("doctor_id"));
                        doctor.setDoctorName(resultSet.getString("doctor_name"));
                        doctor.setSpeciality(speciality);
                        doctor.setExperience(resultSet.getInt("experience"));
                        doctor.setRatings(resultSet.getInt("ratings"));
                        doctor.setConsultationFees(resultSet.getDouble("consultation_fees"));
                        doctorsBySpeciality.add(doctor);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doctorsBySpeciality;
    }

    @Override
    public List<Doctor> findBySpecialityAndExp(String speciality, int experience) {
       List<Doctor> doctorsBySpecAndExp = new ArrayList<>();
       try (
            Connection connection = DoctorDB.openConnetion();
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.FINDBYSPECANDEXP);
            ) {
                preparedStatement.setString(1, speciality);
                preparedStatement.setInt(2, experience);
                try (ResultSet resultSet = preparedStatement.executeQuery();) {
                    while (resultSet.next()) {
                        Doctor doctor = new Doctor();
                        doctor.setDoctorId(resultSet.getInt("doctor_id"));
                        doctor.setDoctorName(resultSet.getString("doctor_name"));
                        doctor.setSpeciality(speciality);
                        doctor.setExperience(resultSet.getInt("experience"));
                        doctor.setRatings(resultSet.getInt("ratings"));
                        doctor.setConsultationFees(resultSet.getDouble("consultation_fees"));
                        doctorsBySpecAndExp.add(doctor);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       return doctorsBySpecAndExp;
    }

    @Override
    public List<Doctor> findBySpecialityAndLessFees(String speciality, double fees) {
        List<Doctor> doctorsBySpecAndFeesLessThan = new ArrayList<>();
       try (
            Connection connection = DoctorDB.openConnetion();
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.FINDBYSPECANDFEES);
            ) {
                preparedStatement.setString(1, speciality);
                preparedStatement.setDouble(2, fees);
                try (ResultSet resultSet = preparedStatement.executeQuery();) {
                    while (resultSet.next()) {
                        Doctor doctor = new Doctor();
                        doctor.setDoctorId(resultSet.getInt("doctor_id"));
                        doctor.setDoctorName(resultSet.getString("doctor_name"));
                        doctor.setSpeciality(speciality);
                        doctor.setExperience(resultSet.getInt("experience"));
                        doctor.setRatings(resultSet.getInt("ratings"));
                        doctor.setConsultationFees(resultSet.getDouble("consultation_fees"));
                        doctorsBySpecAndFeesLessThan.add(doctor);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       return doctorsBySpecAndFeesLessThan;
    }

    @Override
    public List<Doctor> findBySpecialityAndRatings(String speciality, int ratings) {
        List<Doctor> doctorsBySpecAndRatings = new ArrayList<>();
       try (
            Connection connection = DoctorDB.openConnetion();
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.FINDBYSPECANDRATINGS);
            ) {
                preparedStatement.setString(1, speciality);
                preparedStatement.setInt(2, ratings);
                try (ResultSet resultSet = preparedStatement.executeQuery();) {
                    while (resultSet.next()) {
                        Doctor doctor = new Doctor();
                        doctor.setDoctorId(resultSet.getInt("doctor_id"));
                        doctor.setDoctorName(resultSet.getString("doctor_name"));
                        doctor.setSpeciality(speciality);
                        doctor.setExperience(resultSet.getInt("experience"));
                        doctor.setRatings(resultSet.getInt("ratings"));
                        doctor.setConsultationFees(resultSet.getDouble("consultation_fees"));
                        doctorsBySpecAndRatings.add(doctor);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       return doctorsBySpecAndRatings;
    }

    @Override
    public List<Doctor> findBySpecialityAndNameContains(String speciality, String doctorName) {
        List<Doctor> doctorsBySpecAndNameContains = new ArrayList<>();
       try (
            Connection connection = DoctorDB.openConnetion();
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.FINDBYSPECANDNAMECONTAINS);
            ) {
                preparedStatement.setString(1, speciality);
                preparedStatement.setString(2, "%"+doctorName+"%");
                try (ResultSet resultSet = preparedStatement.executeQuery();) {
                    while (resultSet.next()) {
                        Doctor doctor = new Doctor();
                        doctor.setDoctorId(resultSet.getInt("doctor_id"));
                        doctor.setDoctorName(resultSet.getString("doctor_name"));
                        doctor.setSpeciality(speciality);
                        doctor.setExperience(resultSet.getInt("experience"));
                        doctor.setRatings(resultSet.getInt("ratings"));
                        doctor.setConsultationFees(resultSet.getDouble("consultation_fees"));
                        doctorsBySpecAndNameContains.add(doctor);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       return doctorsBySpecAndNameContains;
    }
    
}
