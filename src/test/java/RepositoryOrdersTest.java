import model.OrderDetails;
import model.Orders;
import org.junit.Test;
import repository.RepositoryOrderDetails;
import repository.RepositoryOrders;

import java.util.List;

public class RepositoryOrdersTest {

    RepositoryOrders respositoryOrders = new RepositoryOrders();

    @Test
    public void insertOrder() {
        Orders orders = new Orders();
        orders.setCostumerId(1);
        orders.setAmmount(688);
        orders.setShippingAddress("Marasti nr 5");
        respositoryOrders.insertOrder(orders);

    }

    @Test
    public void stergeOrderById() {
        respositoryOrders.stergeOrderById(5);
    }

    @Test
    public void getorderById() {
        Orders order = respositoryOrders.getOrderById(4);
        assert order != null;//verifica daca nu este null ,daca e null arunca exception
    }


    @Test
    public void udateAmmount() {
        respositoryOrders.udateAmmount(1,111);
    }
    @Test
    public void udateShippingAddress(){
        respositoryOrders.updateShippingAddress(1,"Zorii nr 11");
    }


    @Test
    public void getAllOrders() {
        List<String> orders = respositoryOrders.getAllOrders();
        for (String ord : orders) {
            System.out.println(ord.toString());
        }
    }


}
