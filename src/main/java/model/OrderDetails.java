package model;

public class OrderDetails {
   public int id;
    public int orderId;//rendeles
    public int productId;
    public int price;
    public int quantity;//mennyiseg

    public OrderDetails(){}

    public OrderDetails(int id,int orderId,int productId,int price,int quantity){
        this.id=id;
        this.orderId=orderId;
        this.productId=productId;
        this.price=price;
        this.quantity=quantity;
    }

    public  OrderDetails(String proprietati){
        this.id=Integer.parseInt(proprietati.split(",")[0]);
        this.orderId=Integer.parseInt(proprietati.split(",")[1]);
        this.productId=Integer.parseInt(proprietati.split(",")[2]);
        this.price=Integer.parseInt(proprietati.split(",")[3]);
        this.quantity=Integer.parseInt(proprietati.split(",")[4]);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public  String descriere(){
        String desc="";
        desc+="\nId: "+id+"\nOrder Id: "+orderId+"\nProduct Id: "+productId+"\nPrice: "+price+"\nQuantity: "+quantity;
        return  desc;
    }

    public String toSave(){
        String text="";
        text+=id+","+orderId+","+productId+","+price+","+quantity;
        return  text;
    }
}
