package repository;

import model.*;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RepositoryProducts extends Repository {
    public RepositoryProducts() {
        super();
    }

    public void insertProduct(Products products) {
        String insertTo = "";
        if (products.getName().equals("televizor")) {
            Televizor televizor = (Televizor)products;
            insertTo = ("insert into products (name, price, stock, marca_tv, dimensiune, sistem_de_operare " +"" +
                    ") values  (");
            insertTo += String.format(" '%s', %d, %d,'%s', '%s', '%s'",
                    televizor.getName(),
                    televizor.getPrice(),
                    televizor.getStock(),
                    televizor.getMarca(),
                    televizor.getDimensiune(),
                    televizor.getSistemDeOperare());
            insertTo += ")";
            executeStatement(insertTo);
        } else if (products.getName().equals("cosmestice")){
            Cosmetice cosmetice = (Cosmetice) products;
            insertTo = ("insert into products (name, price, stock, marca_tv, dimensiune, sistem_de_operare " +"" +
                    ") values  (");
            insertTo += String.format(" '%s', %d, %d,'%s', %d, '%s'",
                    cosmetice.getName(),
                    cosmetice.getPrice(),
                    cosmetice.getStock(),
                    cosmetice.getCuloare(),
                    cosmetice.getVarsta(),
                    cosmetice.getFullName());
            insertTo += ")";
            executeStatement(insertTo);
        }
        else if(products.getName().equals("electrocasnice"))
        {
           Electrocasnice electrocasnice=(Electrocasnice) products;
           insertTo=("insert into products( name, price, stock,  marca_electrocasnice, functii)  values(");
           insertTo+=String.format("'%s',%d,%d,'%s','%s'",
            electrocasnice.getName(),
            electrocasnice.getPrice(),
            electrocasnice.getStock(),
            electrocasnice.getMarca(),
            electrocasnice.getFunctii());
            insertTo += ")";
            executeStatement(insertTo);
        }
    }

    public void stergeProductById(int id) {
        String sterge = String.format("delete from products where id= %d", id);
        executeStatement(sterge);
    }

    public Televizor getTelevizorById(int id) {
        String login = String.format("select id, name, price, stock, marca_tv, dimensiune, sistem_de_operare from products where id = %d", id);
        executeStatement(login);
        try {
            ResultSet result = statement.getResultSet();
            if (result != null) {
                result.next();
                return new Televizor(result.getInt(1),
                        result.getString(2),
                        result.getInt(3),
                        result.getInt(4),
                        result.getString(5),
                        result.getString(6),
                        result.getString(7));

            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("Nu s-a executat schita");
            return null;
        }
    }

    public Cosmetice getCosmeticeById(int id) {
        String login = String.format("select id, name, price, stock, full_name, culoare, varsta from products where id = %d", id);
        executeStatement(login);
        try {
            ResultSet result = statement.getResultSet();
            if (result != null) {
                result.next();
                return new Cosmetice(result.getInt(1),
                        result.getString(2),
                        result.getInt(3),
                        result.getInt(4),
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


    public void updatePrice(int id, int price) {
        String update = "";
        update += String.format(" update products set price = %d  where id= %d", price, id);
        executeStatement(update);
    }

    public void updateStock(int id, int stock) {
        String update = "";
        update += String.format(" update products set stock = %d  where id= %d", stock, id);
        executeStatement(update);
    }

    public List<String> getAllTelevizor() {
        executeStatement("select marca from products where name='televizor'");
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


    public List<String> getAllCosmetice() {
        executeStatement("select full_name from products where name='cosmetice'");
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
