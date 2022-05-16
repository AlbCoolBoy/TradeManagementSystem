package com.example.Bean;

public class Employee {
    private String id;
    private String name;
    private String dapartment;
    private String title;
    private String start_date;

    public Employee() {
    }

    public Employee(String name, String dapartment, String title, String start_date) {
        this.name = name;
        this.dapartment = dapartment;
        this.title = title;
        this.start_date = start_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDapartment() {
        return dapartment;
    }

    public void setDapartment(String dapartment) {
        this.dapartment = dapartment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
