import model.Administrator;
import model.Client;
import model.Cosmetice;
import model.Televizor;
import org.junit.Test;
import repository.RepositoryCostumers;
import repository.RepositoryProducts;

import java.util.List;

public class RepositoryProductsTest {


    RepositoryProducts repositoryProducts = new RepositoryProducts();

    @Test
    public void insertProduct() {


        Televizor televizor = new Televizor();

        televizor.setName("televizor");
        televizor.setPrice(4444);
        televizor.setStock(4);
        televizor.setMarca("Samsung");
        televizor.setDimensiune("127inch");
        televizor.setSistemDeOperare("windows");
        repositoryProducts.insertProduct(televizor);


    }

    @Test
    public void stergeProductById() {
        repositoryProducts.stergeProductById(19);
    }

    @Test
    public void getTelevizorById() {
        Televizor televizor = repositoryProducts.getTelevizorById(13);
        assert televizor != null;
    }

    @Test
    public void getCozmeticaById() {
        Cosmetice cosmetice = repositoryProducts.getCosmeticeById(16);
        assert cosmetice != null;
    }

    @Test
    public void udatePrice() {
        repositoryProducts.updatePrice(16, 2222);
    }

    @Test
    public void udateStock() {
        repositoryProducts.updateStock(16, 12);
    }


    @Test
    public void getAllProducts() {
        List<String> cosmetics = repositoryProducts.getAllCosmetice();
        for (String cos : cosmetics) {
            System.out.println(cos);
        }
    }

    @Test
    public void getAllTv() {
        List<String> televizoare = repositoryProducts.getAllTelevizor();
        for (String tel : televizoare) {
            System.out.println(televizoare);
        }
    }
}

