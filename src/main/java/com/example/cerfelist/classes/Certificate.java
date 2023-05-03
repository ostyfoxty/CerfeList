package com.example.cerfelist.classes;

public class Certificate {
    private int number;
    private String series;
    private String institutionOfCertificate;
    private String reason;
    private String dateOfCertificate;
    private String workerName;
    private String workerSurname;
    private int workerID;

    //getters
    public int getNumber() {
        return number;
    }
    public String getSeries() {return series;}
    public String getInstitution() {
        return institutionOfCertificate;
    }
    public String getReason() {
        return reason;
    }
    public String getDate() {
        return dateOfCertificate;
    }
    public String getWorkerName() {
        return workerName;
    }
    public String getWorkerSurname() {
        return workerSurname;
    }
    public int getWorkerID() {
        return workerID;
    }

    //setters
    public void setNumber(int number) {
        this.number = number;
    }
    public void setSeries(String series) {
        this.series = series;
    }
    public void setInstitution(String institutionOfCertificate) {
        this.institutionOfCertificate = institutionOfCertificate;
    }
    public void setReason(String reason) {
        this.reason = reason;
    }
    public void setDate(String dateOfCertificate) {
        this.dateOfCertificate = dateOfCertificate;
    }
    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }
    public void setWorkerSurname(String workerSurname) {
        this.workerSurname = workerSurname;
    }
    public void setWorkerID(int workerID) {
        this.workerID = workerID;
    }

    //constructors and functions
    public Certificate(int number,String series,String dateOfCertificate,int workerID)
    {
        this.number=number;
        this.series=series;
        this.dateOfCertificate=dateOfCertificate;
        this.workerID=workerID;
    }

    public Certificate(int number,String series,String institutionOfCertificate,String reason,
                       String dateOfCertificate,int workerID, String workerName,String workerSurname)
    {
        this.number=number;
        this.series=series;
        this.dateOfCertificate=dateOfCertificate;
        this.workerID=workerID;
        this.institutionOfCertificate=institutionOfCertificate;
        this.workerName=workerName;
        this.workerSurname=workerSurname;
        this.reason=reason;
    }

}
