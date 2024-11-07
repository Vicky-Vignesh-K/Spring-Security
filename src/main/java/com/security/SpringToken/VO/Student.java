package com.security.SpringToken.VO;

public class Student {

    private int studentId;
    private String studentName;
    private long mobile;

    public Student(int studentId, String studentName, long mobile) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.mobile = mobile;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", mobile=" + mobile +
                '}';
    }
}
