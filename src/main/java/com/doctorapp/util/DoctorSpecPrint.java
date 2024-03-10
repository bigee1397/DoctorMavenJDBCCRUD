package com.doctorapp.util;

import com.doctorapp.model.Specialization;

public class DoctorSpecPrint {
    public static void getSpecs() {
        System.out.print("Enter the speciality from the list of (");
        Specialization[] values1 = Specialization.values();
                    for (int i = 0; i < values1.length; i++) {
                        System.out.print(values1[i].name());
                        if (i < values1.length - 1) {
                            System.out.print(" | ");
                        }
                    }
                    System.out.print("):");
    }
}
