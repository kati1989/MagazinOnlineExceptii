package repository;

import model.Administrator;
import model.Client;
import model.OrderDetails;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RepositoryOrderDetails extends Repository {
    public RepositoryOrderDetails() {
        super();
    }

    public void insertOrderDetails(OrderDetails orderDetails) {
        String insertTo = "";

            insertTo = ("insert into order_details (order_id, product_id, price, quantity) values (");
            insertTo += String.format("'%d', '%d', %d, '%d'",
                    orderDetails.getOrderId(),
                    orderDetails.getProductId(),
                    orderDetails.getPrice(),
                    orderDetails.getQuantity());
            insertTo += ")";
            executeStatement(insertTo);
    }

    public void stergeOrderDetailsById(int id) {
        String sterge = String.format("delete from order_details where id= %d", id);
        executeStatement(sterge);
    }

    public OrderDetails getOrderDetailsById(int id) {
        String login = String.format("select * from order_details where id = %d", id);
        executeStatement(login);
        try {
            ResultSet result = statement.getResultSet();
            if (result != null) {
                result.next();
                return new OrderDetails(result.getInt(1),
                        result.getInt(2),
                        result.getInt(3),
                        result.getInt(4),
                        result.getInt(5));
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("Nu s-a executat schita");
            return null;
        }
    }

    public void udatePrice(int id, int price) {
        String update = "";
        update += String.format("update order_details set price = '%d'  where id= %d", price, id);
        executeStatement(update);
    }

    public List<OrderDetails> getAllOrderDetails() {
        executeStatement("select * from order_details");
        try {
            ResultSet set = statement.getResultSet();
            ArrayList<OrderDetails> orderDetails = new ArrayList<>();
            while (set.next()) {
                OrderDetails order =  new OrderDetails(set.getInt(1),
                        set.getInt(2),
                        set.getInt(3),
                        set.getInt(4),
                        set.getInt(5));
                orderDetails.add(order);
            }
            return orderDetails;
        } catch (Exception e) {
            System.out.println("Nu s-a executat schita");
            return null;
        }
    }
}
