package com.example.ManagerInfo;

public class Employee {
    private String emp_id;
    private String fname;
    private String lname;
    private String bitrth_date;
    private String title;

    public Employee() {
    }

    public Employee(String emp_id, String fname, String lname, String bitrth_date, String title) {
        this.emp_id = emp_id;
        this.fname = fname;
        this.lname = lname;
        this.bitrth_date = bitrth_date;
        this.title = title;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getBitrth_date() {
        return bitrth_date;
    }

    public void setBitrth_date(String bitrth_date) {
        this.bitrth_date = bitrth_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
