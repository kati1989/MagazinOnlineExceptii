package model;

public class Electrocasnice extends Products{
    private String  marca;
    private String functii;

    public Electrocasnice(){}

    public Electrocasnice(int id,String name,int pret,int stock,String marca,String functii){
        super(id,name,pret,stock);
        this.marca=marca;
        this.functii=functii;

    }

    public Electrocasnice(String proprietati){
        super(Integer.parseInt(proprietati.split(",")[0]),proprietati.split(",")[1],Integer.parseInt(proprietati.split(",")[2]),Integer.parseInt(proprietati.split(",")[3]));
   this.marca=proprietati.split(",")[4];
   this.functii=proprietati.split(",")[5];
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getFunctii() {
        return functii;
    }

    public void setFunctii(String functii) {
        this.functii = functii;
    }

    @Override
    public String descriere(){
        String desc="";
        desc+="\nId: "+super.getId()+"\nName: "+super.getName()+"\nPrice: "+super.getPrice()+"\nStock: "+getStock()+"\nMarca: "+marca+"\nFuctii:  "+functii;
        return  desc;
    }

    @Override

    public String toSave(){
        String text="";
        text+=super.getId()+","+super.getName()+","+super.getPrice()+","+super.getStock()+","+marca+","+functii;
        return text;

    }
}
