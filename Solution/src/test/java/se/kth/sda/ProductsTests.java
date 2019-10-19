package se.kth.sda;

import main.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProductsTests {
    private Product p1 = new Product(); // This is used to test positive test
    private Product p2 = new Product(); // This is used to test negative test

    @Before
    public void setUp() {
        p1.setFett("2");
        p1.setEnergy("3");
        p1.setFiber("5");
        p1.setProtein("10");
        p1.setSn("Whey");
        p1.setKolhydrater("23");

        p2.setSn("Rock");
        p2.setKolhydrater("2");
        p2.setProtein("10");
        p2.setFiber("5");
        p2.setEnergy("3");
        p2.setFett("6");
    }

    @Test
    public void testGetSn() {
        Assert.assertTrue(p1.getSn().equals("Whey"));
        Assert.assertFalse(p2.getSn().equals("Bool"));
    }

    @Test
    public void testGetFett() {
        Assert.assertTrue(p1.getFett().equals("2"));
        Assert.assertFalse(p2.getFett().equals("100"));
    }

    @Test
    public void testGetProtein() {
        Assert.assertTrue(p1.getProtein().equals("10"));
        Assert.assertFalse(p2.getProtein().equals("515"));
    }
}
