import model.Administrator;
import model.Client;
import org.junit.Test;
import repository.RepositoryCostumers;

import java.util.List;

public class RepositoryCostumersTest {

    RepositoryCostumers repositoryCostumers = new RepositoryCostumers();

    @Test
    public void insertCustomer(){
        Administrator administrator = new Administrator();
        administrator.setType("administrator");
        administrator.setBillingAdress("str George Cosbuc");
        administrator.setFullName("Emilia Raducu");
        administrator.setEmail("emi@yahoo.com");
        administrator.setPassword("123");
        administrator.setCategorie("televizor");

        repositoryCostumers.insertCostumer(administrator);
    }

    @Test
    public void stergeCustomerById(){
        repositoryCostumers.stergeCostumerById(5);
    }

    @Test
    public void getAdministratorById(){
        Administrator administrator = repositoryCostumers.getAdministratorById(2);
        assert administrator != null;
    }

    @Test
    public void getClientById(){
        Client client = repositoryCostumers.getClientById(1);
        assert client != null;
    }

    @Test
    public void udateCategorieAdministrator(){
         repositoryCostumers.udateCategorieAdministrator(2,"televizor");
    }

    @Test
    public void udatePassword(){
        repositoryCostumers.updatePassword(2,"123");
    }

    @Test
    public void udateEmail(){
        repositoryCostumers.updateEmail(2,"titi@yahoo.com");
    }

    @Test
    public void getAllClients(){
        List<String> clients = repositoryCostumers.getAllClients();
        for (String client : clients){
            System.out.println(client);
        }
    }

    @Test
    public void getAllAdministrators(){
        List<String> admins = repositoryCostumers.getAllAdministrators();
        for (String admin : admins){
            System.out.println(admin);
        }
    }
}
