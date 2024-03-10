package com.doctorapp.service;

import java.util.ArrayList;
import java.util.List;

import com.doctorapp.exception.DoctorNotFoundException;
import com.doctorapp.exception.IdNotFoundException;
import com.doctorapp.model.Doctor;
import com.doctorapp.repository.*;

public class DoctorServiceImpl implements IDoctorService{
    private IDoctorRepository doctorRepository = new DoctorRepositoryImpl();
    @Override
    public void addDoctor(Doctor doctor) {
        doctorRepository.addDoctor(doctor);
    }
    @Override
    public void updateDoctor(double consultationFees, int doctorId) {
       doctorRepository.updateDoctor(consultationFees, doctorId);
    }
    @Override
    public void deleteDoctor(int doctorId) {
        doctorRepository.daleteDoctor(doctorId);
    }
    @Override
    public Doctor getDoctorById(int doctorId) throws IdNotFoundException {
        Doctor doctor = doctorRepository.findDoctorById(doctorId);
        if(doctor == null) {
            throw new IdNotFoundException("Doctor id not found");
        }
        return doctor;
    }
    @Override
    public List<Doctor> getAll() throws DoctorNotFoundException {
        List<Doctor> doctors = doctorRepository.findAll();
        if(doctors.isEmpty()) throw new DoctorNotFoundException("No doctors available in the database..");
        return doctors;
    }
    @Override
    public List<Doctor> getBySpeciality(String speciality) throws DoctorNotFoundException {
        List<Doctor> doctorsBySpeciality = doctorRepository.findBySpeciality(speciality);
        if(doctorsBySpeciality.isEmpty()) throw new DoctorNotFoundException("No doctors with the speciality available in the database..");
        return doctorsBySpeciality;
    }
    @Override
    public List<Doctor> getBySpecialityAndExp(String speciality, int experience) throws DoctorNotFoundException {
        List<Doctor> docsBySpecAndExp = doctorRepository.findBySpecialityAndExp(speciality, experience);
        if(docsBySpecAndExp.isEmpty()) throw new DoctorNotFoundException("Doctors with specialization and required experience not found...");
        return docsBySpecAndExp;
    }
    @Override
    public List<Doctor> getBySpecialityAndLessFees(String speciality, double fees) throws DoctorNotFoundException {
        List<Doctor> doctorsBySpecAndFeesLessThan = doctorRepository.findBySpecialityAndLessFees(speciality, fees);
        if(doctorsBySpecAndFeesLessThan.isEmpty()) throw new DoctorNotFoundException("Doctors with speciality and consultation fees less than what you have entered not found...");
        return doctorsBySpecAndFeesLessThan;
    }
    @Override
    public List<Doctor> getBySpecialityAndRatings(String speciality, int ratings) throws DoctorNotFoundException {
       List<Doctor> doctorsBySpecAndRatings = doctorRepository.findBySpecialityAndRatings(speciality, ratings);
       if(doctorsBySpecAndRatings.isEmpty()) throw new DoctorNotFoundException("Doctor with speciality and ratings required not found...");
       return doctorsBySpecAndRatings;
    }
    @Override
    public List<Doctor> getBySpecialityAndNameContains(String speciality, String doctorName) throws DoctorNotFoundException{
    List<Doctor> doctorsBySpecAndNameContains = doctorRepository.findBySpecialityAndNameContains(speciality, doctorName);
    if(doctorsBySpecAndNameContains.isEmpty()) throw new DoctorNotFoundException("Doctor with speciality and name containing what you are searching for is not found....");
    return doctorsBySpecAndNameContains;
    }
}
