
import model.OrderDetails;
import org.junit.Test;
import repository.RepositoryOrderDetails;


import java.util.List;

public class RepositoryOrderDetailsTest {

    RepositoryOrderDetails repositoryOrderDetails = new RepositoryOrderDetails();

    @Test
    public void insertOrderDetails(){
        OrderDetails orderDetails=new OrderDetails();
        orderDetails.setOrderId(2);
        orderDetails.setProductId(14);
        orderDetails.setPrice(333);
        orderDetails.setQuantity(2);
       repositoryOrderDetails.insertOrderDetails(orderDetails);

    }

    @Test
    public void stergeOrderDetailsById(){
        repositoryOrderDetails.stergeOrderDetailsById(3);
    }

    @Test
    public void getorderDetailsById(){
        OrderDetails orderDetails = repositoryOrderDetails.getOrderDetailsById(4);
        assert orderDetails != null;//verifica daca nu este null ,daca e null arunca exception
    }




    @Test
    public void udatePrice(){
        repositoryOrderDetails.udatePrice(4,555);
    }




    @Test
    public void getAllorderDetails(){
        List<OrderDetails> orderDetails = repositoryOrderDetails.getAllOrderDetails();
        for (OrderDetails ordDetail : orderDetails){
            System.out.println(ordDetail.toString());
        }
    }


}
