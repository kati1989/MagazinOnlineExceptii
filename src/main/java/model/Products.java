package model;

public class Products {
    private  int id;
    private String name;
    private int price;
    private int stock;

    public Products(){}

    public Products(int id,String name,int price,int stock){
        this.id=id;
        this.name=name;
        this.price=price;
        this.stock=stock;
    }

    public Products(String proprietati){
        this.id=Integer.parseInt(proprietati.split(",")[0]);
        this.name=proprietati.split(",")[1];
        this.price=Integer.parseInt(proprietati.split(",")[2]);
        this.stock=Integer.parseInt(proprietati.split(",")[3]);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public  String descriere(){
        String desc="";
        desc+="\nId: "+id+"\nName: "+name+"\nPrice: "+price+"\nStock: "+stock;
        return  desc;
    }

    public String toSave(){
        String text="";
        text+=id+","+name+","+price+","+stock;
        return  text;
    }
}
