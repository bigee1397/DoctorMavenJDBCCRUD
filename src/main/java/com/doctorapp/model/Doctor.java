package com.doctorapp.model;

public class Doctor {
    private Integer doctorId;
    private String doctorName;
    private String speciality;
    private int experience;
    private int ratings;
    private double consultationFees;
    
    public Doctor() {}
    
    public Doctor(String doctorName, String speciality, int experience, int ratings, double consultationFees) {
        this.doctorName = doctorName;
        this.speciality = speciality;
        this.experience = experience;
        this.ratings = ratings;
        this.consultationFees = consultationFees;
    }

    public Doctor(Integer doctorId, String doctorName, String speciality, int experience, int ratings,
            double consultationFees) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.speciality = speciality;
        this.experience = experience;
        this.ratings = ratings;
        this.consultationFees = consultationFees;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }

    public double getConsultationFees() {
        return consultationFees;
    }

    public void setConsultationFees(double consultationFees) {
        this.consultationFees = consultationFees;
    }

    @Override
    public String toString() {
        return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", speciality=" + speciality
                + ", experience=" + experience + ", ratings=" + ratings + ", consultationFees=" + consultationFees
                + "]";
    }

}
