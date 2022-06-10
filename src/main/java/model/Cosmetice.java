package model;

public class Cosmetice extends Products {

    String fullName;
    private String culoare;
    private int varsta;

    public Cosmetice(){}
    public Cosmetice(int id,String name,int price,int stock,String fullName,String culoare,int varsta){
        super(id,name,price,stock);
        this.fullName=fullName;
        this.culoare=culoare;
        this.varsta=varsta;
    }
    public  Cosmetice(String proprietati){
        super(Integer.parseInt(proprietati.split(",")[0]),proprietati.split(",")[1],Integer.parseInt(proprietati.split(",")[2]),Integer.parseInt(proprietati.split(",")[3]));
        this.fullName=proprietati.split(",")[4];
        this.culoare=proprietati.split(",")[5];
        this.varsta=Integer.parseInt(proprietati.split(",")[6]);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCuloare() {
        return culoare;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }
    @Override
    public String descriere(){
        String desc=super.descriere();
        desc+="\nFull Name: "+fullName+"\nCuloare: "+culoare+"\nVarsta: "+varsta;
        return  desc;
    }

    @Override

    public String toSave(){
        String text=super.toSave();
        text+=fullName+","+culoare+","+varsta;
        return text;

    }
}
