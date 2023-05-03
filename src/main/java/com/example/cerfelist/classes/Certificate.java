package com.example.cerfelist.classes;

public class Certificate {
    private String number;
    private String series;
    private String institutionOfCertificate;
    private String reason;
    private String dateOfCertificate;

    private String daysOfIllness;
    private String workerName;
    private String workerSurname;
    private int workerID;

    //getters
    public String getNumber() {
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
    public String getAmount(){return daysOfIllness;}
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
    public void setNumber(String number) {
        this.number = number;
    }
    public void setSeries(String series) {
        this.series = series;
    }
    public void setInstitution(String institutionOfCertificate) { this.institutionOfCertificate = institutionOfCertificate;}
    public void setAmount(String daysOfIllness){this.daysOfIllness=daysOfIllness;}
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

    public Certificate(String number,String series,String institutionOfCertificate,String reason,
                       String dateOfCertificate, String workerName,String workerSurname, String daysOfIllness)
    {
        this.number=number;
        this.series=series;
        this.dateOfCertificate=dateOfCertificate;
        this.institutionOfCertificate=institutionOfCertificate;
        this.workerName=workerName;
        this.workerSurname=workerSurname;
        this.reason=reason;
        this.daysOfIllness=daysOfIllness;
    }

    public Certificate()
    {
        this.number=null;
        this.series=null;
        this.dateOfCertificate=null;
        this.institutionOfCertificate=null;
        this.workerName=null;
        this.workerSurname=null;
        this.reason=null;
        this.daysOfIllness=null;
    }

}
