package model;

public class Client extends Costumer {
    private int nrDeComenzi;

    public Client(){}
    public Client(int id,String email,String password,String fullName,String billigAdress,String type,int nrDeComenzi){
        super(id,email,password,fullName,billigAdress,type);
        this.nrDeComenzi=nrDeComenzi;

    }

    public Client(String proprietati){
        super(Integer.parseInt(proprietati.split(",")[0]),proprietati.split(",")[1],proprietati.split(",")[2],proprietati.split(",")[3],proprietati.split(",")[4],proprietati.split(",")[5]);
        this.nrDeComenzi=Integer.parseInt(proprietati.split(",")[6]);
    }

    public int getNrDeComenzi() {
        return nrDeComenzi;
    }

    public void setNrDeComenzi(int nrDeComenzi) {
        this.nrDeComenzi = nrDeComenzi;
    }

    @Override
    public String descriere(){
        String desc="";
        desc+="\nId: "+super.getId()+"\nEmail: "+super.getEmail()+"\nPassword: "+super.getPassword()+"\nFull Name: "+super.getFullName()+"\nBilling Adress: "+super.getBillingAdress()+"\ngetType: "+super.getType()+"\nNumar de comenzi: "+nrDeComenzi;
        return  desc;
    }

    @Override
    public  String toString(){
        String text="";
        text+=super.getId()+","+super.getEmail()+","+super.getPassword()+","+super.getFullName()+","+super.getBillingAdress()+","+super.getType()+","+nrDeComenzi;
        return text;
    }
}
