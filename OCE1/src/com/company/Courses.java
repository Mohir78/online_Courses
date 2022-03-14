package com.company;

public class Courses {
    int id;
    String nomi;
    int narxi;
    String davomiyligi;
    String oqituchi;

    public Courses(int id,String nomi, int narxi, String davomiyligi, String oqituchi) {
        this.id = id;
        this.nomi = nomi;
        this.narxi = narxi;
        this.davomiyligi = davomiyligi;
        this.oqituchi = oqituchi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomi() {
        return nomi;
    }

    public void setNomi(String nomi) {
        this.nomi = nomi;
    }

    public int getNarxi() {
        return narxi;
    }

    public void setNarxi(int narxi) {
        this.narxi = narxi;
    }

    public String getDavomiyligi() {
        return davomiyligi;
    }

    public void setDavomiyligi(String davomiyligi) {
        this.davomiyligi = davomiyligi;
    }

    public String getOqituchi() {
        return oqituchi;
    }

    public void setOqituchi(String oqituchi) {
        this.oqituchi = oqituchi;
    }

    public void showCourses() {
        System.out.println("Nomi: " + this.getNomi());
        System.out.println("Narxi: " + this.getNarxi());
        System.out.println("Davomiyligi: " + this.getDavomiyligi());
        System.out.println("O'qituvchi: " + this.getOqituchi());
        System.out.println("---------------------------------------");
    }
}
