package com.luv2code.springmvc.models;

public interface Grade {


    int getId();

    void setId(int id);

    int getStudentId();

    void setStudentId(int studentId);

    void setGrade(double grade);

    double getGrade();
}
