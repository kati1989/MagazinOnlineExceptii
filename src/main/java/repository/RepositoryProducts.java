package repository;

import model.Administrator;
import model.Client;
import model.Products;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RepositoryProducts extends Repository{
    public RepositoryProducts() {
        super();
    }

    public void insertProduct(Products products) {
        String insertTo = "";

        insertTo = ("insert into products (name, price, stock, marca_tv, dimensiune, sistem_de_operare, " +
                "full_name, culoare, varsta, " +
                "marca_electrocasnice, functii) values  (");
        insertTo += String.format(" '%s', '%d', '%d', %s, '%s', '%s', '%s', '%s', '%d', '%s', '%s'",
                products.getName(),
                products.getPrice());
        insertTo += ")";
        executeStatement(insertTo);
    }

    public void stergeProductById(int id) {
        String sterge = String.format("delete from costumers where id= %d", id);
        executeStatement(sterge);
    }

    public Client getClientById(int id) {
        String login = String.format("select * from costumers where id = %d", id);
        executeStatement(login);
        try {
            ResultSet result = statement.getResultSet();
            if (result != null) {
                result.next();
                return new Client(result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getString(6),
                        result.getInt(7));

            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("Nu s-a executat schita");
            return null;
        }
    }


    public void updatePassword(int id, String newParola) {
        String update = "";
        update += String.format(" update costumers set password = '%s'  where id= %d", newParola, id);
        executeStatement(update);
    }

    public void updateEmail(int id, String email) {
        String update = "";
        update += String.format(" update costumers set email = '%s'  where id= %d", email, id);
        executeStatement(update);
    }

    public List<String> getAllProducts() {
        executeStatement("select full_name from costumers where type='client'");
        try {
            ResultSet set = statement.getResultSet();
            ArrayList<String> numeClient = new ArrayList<>();
            while (set.next()) {
                numeClient.add(set.getString(1));
            }
            return numeClient;
        } catch (Exception e) {
            System.out.println("Nu s-a executat schita");
            return null;
        }
    }
}
