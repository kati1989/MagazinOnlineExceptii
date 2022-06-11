package repository;

import model.Administrator;
import model.Client;
import model.Orders;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RepositoryOrders extends Repository{

    public RepositoryOrders() {
        super();
    }

    public void insertOrder(Orders orders) {
        String insertTo = "";

        insertTo = ("insert into orders ( costumer_id, ammount, shipping_adress) values  (");
        insertTo += String.format("'%d', '%d', '%s'", orders.getCostumerId(), orders.getAmmount(), orders.getShippingAddress());
        insertTo += ")";
        executeStatement(insertTo);
    }

    public void stergeOrderById(int id) {
        String sterge = String.format("delete from orders where id= %d", id);
        executeStatement(sterge);
    }

    public Orders getOrderById(int id) {
        String login = String.format("select * from orders where id = %d", id);
        executeStatement(login);
        try {
            ResultSet result = statement.getResultSet();
            if (result != null) {
                result.next();
                return new Orders(result.getInt(1),
                        result.getInt(2),
                        result.getInt(3),
                        result.getString(4));

            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("Nu s-a executat schita");
            return null;
        }
    }

    public void udateAmmount(int id, int ammount) {
        String update = "";
        update += String.format("update orders set ammount = '%d'  where id= %d", ammount, id);
        executeStatement(update);
    }

    public void updateShippingAddress(int id, String shipping_adress) {
        String update = "";
        update += String.format(" update orders set shipping_adress = '%s'  where id= %d", shipping_adress, id);
        executeStatement(update);
    }

    public List<String> getAllOrders() {
        executeStatement("select id, costumer_id, ammount, shipping_adress from orders");
        try {
            ResultSet set = statement.getResultSet();
            ArrayList<String> numeClient = new ArrayList<>();
            while (set.next()) {
                numeClient.add(set.getInt(1) + " " +set.getString(2)  +
                         " " + set.getString(3) + " " + set.getString(4) );
            }
            return numeClient;
        } catch (Exception e) {
            System.out.println("Nu s-a executat schita");
            return null;
        }
    }

}
