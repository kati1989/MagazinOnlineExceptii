package repository;

import model.Administrator;
import model.Client;
import model.Costumer;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RepositoryCostumers extends Repository {

    public RepositoryCostumers() {
        super();
    }

    public void insertCostumer(Costumer costumer) {
        String insertTo = "";

        if (costumer.getType().equals( "administrator")) {
            insertTo = ("insert into costumers( email, password, full_name, billing_address, type,  categorie) values  (");
            insertTo += String.format(" '%s', '%s', '%s', '%s', '%s', '%s'", costumer.getEmail(), costumer.getPassword(), costumer.getFullName(), costumer.getBillingAdress(), costumer.getType(), ((Administrator) costumer).getCategorie());
            insertTo += ")";
            executeStatement(insertTo);
        } else if (costumer.getType().equals("client")) {
            insertTo = ("insert into  costumers( email, password, full_name, billing_address, type, categorie, nr_de_comenzi)  values(");
            insertTo += String.format("'%s','%s','%s','%s','%s',%d", costumer.getEmail(), costumer.getPassword(), costumer.getFullName(), costumer.getBillingAdress(), costumer.getType(), ((Client) costumer).getNrDeComenzi());
            insertTo += " ) ";
            executeStatement(insertTo);
        }
    }

    public void stergeCostumerById(int id) {
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

    public Administrator getAdministratorById(int id) {
        String login = String.format("select * from costumers where id = %d", id);
        executeStatement(login);
        try {
            ResultSet result = statement.getResultSet();
            if (result != null) {
                result.next();
                return new Administrator(result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getString(6),
                        result.getString(6));

            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("Nu s-a executat schita");
            return null;
        }
    }

    public void udateCategorieAdministrator(int id, String categorie) {
        String update = "";
        update += String.format("update costumers set categorie = '%s'  where id= %d", categorie, id);
        executeStatement(update);
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

    public List<String> getAllClients() {
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

    public List<String> getAllAdministrators() {
        executeStatement("select full_name from costumers where type='administrator'");
        try {
            ResultSet set = statement.getResultSet();
            ArrayList<String> numeAdministrator = new ArrayList<>();
            while (set.next()) {
                numeAdministrator.add(set.getString(1) );
            }
            return numeAdministrator;
        } catch (Exception e) {
            System.out.println("Nu s-a executat schita");
            return null;
        }
    }

}

