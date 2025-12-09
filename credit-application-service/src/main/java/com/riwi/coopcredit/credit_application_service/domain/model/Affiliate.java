package com.riwi.coopcredit.credit_application_service.domain.model;

import java.util.List;

public class Affiliate {

    private Long id;
    private String documentNumber;
    private String fullName;
    private Double salary;
    private boolean active;

    private List<CreditApplication> creditApplications;

    public Affiliate() {
    }

    public Affiliate(Long id, String documentNumber, String fullName,
                     Double salary, boolean active,
                     List<CreditApplication> creditApplications) {
        this.id = id;
        this.documentNumber = documentNumber;
        this.fullName = fullName;
        this.salary = salary;
        this.active = active;
        this.creditApplications = creditApplications;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<CreditApplication> getCreditApplications() {
        return creditApplications;
    }

    public void setCreditApplications(List<CreditApplication> creditApplications) {
        this.creditApplications = creditApplications;
    }
}
