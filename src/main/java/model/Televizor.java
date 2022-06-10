package model;

public class Televizor  extends Products{
    private String marca;
    private String dimensiune;
    private String sistemDeOperare;

    public Televizor(){}
    public Televizor(int id,String name,int price,int stock,String marca,String dimensiune,String sistemDeOperare){
        super(id,name,price,stock);
        this.marca=marca;
        this.dimensiune=dimensiune;
        this.sistemDeOperare=sistemDeOperare;

    }
    public Televizor(String proprietati){
        super(Integer.parseInt(proprietati.split(",")[0]),proprietati.split(",")[1],Integer.parseInt(proprietati.split(",")[2]),Integer.parseInt(proprietati.split(",")[3]));
        this.marca=proprietati.split(",")[4];
        this.dimensiune=proprietati.split(",")[5];
        this.sistemDeOperare=proprietati.split(",")[6];
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDimensiune() {
        return dimensiune;
    }

    public void setDimensiune(String dimensiune) {
        this.dimensiune = dimensiune;
    }

    public String getSistemDeOperare() {
        return sistemDeOperare;
    }

    public void setSistemDeOperare(String sistemDeOperare) {
        this.sistemDeOperare = sistemDeOperare;
    }

    @Override
    public String descriere(){
        String desc=super.descriere();
        desc+="\nMarca: "+marca+"\nDimensiune: "+dimensiune+"\nSistem de operare:  "+sistemDeOperare;
        return  desc;
    }

    @Override

    public String toSave(){
        String text=super.toSave();

        text+=marca+","+dimensiune+","+sistemDeOperare;
        return text;

    }
}
