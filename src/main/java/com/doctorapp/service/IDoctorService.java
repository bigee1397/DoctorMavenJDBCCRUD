package com.doctorapp.service;

import java.util.List;

import com.doctorapp.exception.DoctorNotFoundException;
import com.doctorapp.exception.IdNotFoundException;
import com.doctorapp.model.Doctor;

public interface IDoctorService {
    public void addDoctor(Doctor doctor);
    public void updateDoctor(double consultationFees, int doctorId);
    public void deleteDoctor(int doctorId);    
    public Doctor getDoctorById(int doctorId) throws IdNotFoundException;
    public List<Doctor> getAll() throws DoctorNotFoundException;
    public List<Doctor> getBySpeciality(String speciality) throws DoctorNotFoundException;
    public List<Doctor> getBySpecialityAndExp(String speciality, int experience) throws DoctorNotFoundException;
    public List<Doctor> getBySpecialityAndLessFees(String speciality, double fees) throws DoctorNotFoundException;
    public List<Doctor> getBySpecialityAndRatings(String speciality, int ratings) throws DoctorNotFoundException;
    public List<Doctor> getBySpecialityAndNameContains(String speciality, String doctorName) throws DoctorNotFoundException;
}
