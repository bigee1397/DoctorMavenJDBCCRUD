package com.doctorapp.repository;

import java.util.List;

import com.doctorapp.model.Doctor;

public interface IDoctorRepository {
    public void addDoctor(Doctor doctor);
    public void updateDoctor(double consultationFees, int doctorId);
    public void daleteDoctor(int doctorId);
    public Doctor findDoctorById(int doctorId);
    public List<Doctor> findAll();
    public List<Doctor> findBySpeciality(String speciality);
    public List<Doctor> findBySpecialityAndExp(String speciality, int experience);
    public List<Doctor> findBySpecialityAndLessFees(String speciality, double fees);
    public List<Doctor> findBySpecialityAndRatings(String speciality, int ratings);
    public List<Doctor> findBySpecialityAndNameContains(String speciality, String doctorName);
}
