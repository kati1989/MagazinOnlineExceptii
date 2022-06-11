package model;
//order=rendeles,ammount==osszeg
public class Orders {
    private int id;
    //penz osszeg
    private int costumerId;
    private int ammount;
    //kiszallitasi cim
    private String  shippingAddress;

public  Orders(){}
    public Orders(int id,int costumerId,int ammount,String shippingAddress){
        this.id=id;
        this.costumerId=costumerId;
        this.ammount=ammount;
        this.shippingAddress=shippingAddress;
    }
    public Orders(String proprietati){
        this.id=Integer.parseInt(proprietati.split(",")[0]);
        this.costumerId=Integer.parseInt(proprietati.split(",")[1]);
        this.ammount=Integer.parseInt(proprietati.split(",")[2]);
        this.shippingAddress=proprietati.split(",")[3];
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCostumerId() {
        return costumerId;
    }

    public void setCostumerId(int costumerId) {
        this.costumerId = costumerId;
    }

    public int getAmmount() {
        return ammount;
    }

    public void setAmmount(int ammount) {
        this.ammount = ammount;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String descriere(){
        String desc="";
        desc+="\nId: "+id+"\nCostumerId: "+costumerId+"\nAmmount: "+ammount+"\nShipping Adress: "+shippingAddress;
        return  desc;
    }

    public String toSave(){
        String text="";
        text+=id+","+costumerId+","+ammount+","+shippingAddress;
        return  text;
    }

}
