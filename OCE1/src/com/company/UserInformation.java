package com.company;

public class UserInformation {
    private int id;
    private String ismi;
    private String familiyasi;
    private String telefon;
    private String email;
    private String parol;
    private String statusi;

    public UserInformation(int id, String ismi, String familiyasi, String telefon, String email, String parol, String statusi) {
        this.id = id;
        this.ismi = ismi;
        this.familiyasi = familiyasi;
        this.telefon = telefon;
        this.email = email;
        this.parol = parol;
        this.statusi = statusi;
    }

    public UserInformation() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsmi() {
        return ismi;
    }

    public void setIsmi(String ismi) {
        this.ismi = ismi;
    }

    public String getFamiliyasi() {
        return familiyasi;
    }

    public void setFamiliyasi(String familiyasi) {
        this.familiyasi = familiyasi;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getParol() {
        return parol;
    }

    public void setParol(String parol) {
        this.parol = parol;
    }

    public String isStatusi() {
        return statusi;
    }

    public void setStatusi(String statusi) {
        this.statusi = statusi;
    }

    public void showUsersInformation() {
        System.out.println("ID:" + this.id);
        System.out.println("Ismi: " + this.getIsmi());
        System.out.println("Familiyasi: " + this.getFamiliyasi());
        System.out.println("Telefon raqami: " + this.getTelefon());
        System.out.println("Email adresi: " + this.getEmail());
        System.out.println("Paroli: " + this.getParol());
        System.out.println("Statusi: " + this.isStatusi());
        System.out.println("------------------------------");
    }
}
