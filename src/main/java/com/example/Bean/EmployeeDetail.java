package com.example.Bean;

public class EmployeeDetail {
    private String id;
    private String fname;
    private String lname;
    private String start_date;
    private String branch_name;
    private String branch_address;
    private String branch_city;
    private String branch_state;
    private String branch_zip;
    private String supervisor_fname;
    private String supervisor_lname;
    private String title;
    private String department;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EmployeeDetail(String fname, String lname, String start_date, String branch_name, String branch_address, String branch_city, String branch_state, String branch_zip, String supervisor_fname, String supervisor_lname, String title) {
        this.fname = fname;
        this.lname = lname;
        this.start_date = start_date;
        this.branch_name = branch_name;
        this.branch_address = branch_address;
        this.branch_city = branch_city;
        this.branch_state = branch_state;
        this.branch_zip = branch_zip;
        this.supervisor_fname = supervisor_fname;
        this.supervisor_lname = supervisor_lname;
        this.title = title;
    }

    public EmployeeDetail() {
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

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getBranch_name() {
        return branch_name;
    }

    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }

    public String getBranch_address() {
        return branch_address;
    }

    public void setBranch_address(String branch_address) {
        this.branch_address = branch_address;
    }

    public String getBranch_city() {
        return branch_city;
    }

    public void setBranch_city(String branch_city) {
        this.branch_city = branch_city;
    }

    public String getBranch_state() {
        return branch_state;
    }

    public void setBranch_state(String branch_state) {
        this.branch_state = branch_state;
    }

    public String getBranch_zip() {
        return branch_zip;
    }

    public void setBranch_zip(String branch_zip) {
        this.branch_zip = branch_zip;
    }

    public String getSupervisor_fname() {
        return supervisor_fname;
    }

    public void setSupervisor_fname(String supervisor_fname) {
        this.supervisor_fname = supervisor_fname;
    }

    public String getSupervisor_lname() {
        return supervisor_lname;
    }

    public void setSupervisor_lname(String supervisor_lname) {
        this.supervisor_lname = supervisor_lname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
