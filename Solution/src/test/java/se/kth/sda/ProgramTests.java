package se.kth.sda;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ProgramTests {
    Manager manager = null;
    List<Product> fettList = null;
//    List<Product>
    @Before
    public void setUp() {
        manager = new Manager("resources/products.xml");
        fettList = manager.getListOfProducts();
    }

    @Test
    public void sortByFett() {
        Assert.assertTrue(fettList.get(0).getFett().equals("27.19"));
        Assert.assertTrue(fettList.get(1).getFett().equals("6.14"));
    }
}
