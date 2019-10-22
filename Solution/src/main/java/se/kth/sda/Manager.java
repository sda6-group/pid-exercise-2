package se.kth.sda;
import java.util.*;
import java.util.stream.Collectors;

public class Manager {
    private Parser p;
    private DomParser dp;
    private List<Item> listOfConfig;
    private List<Product> listOfProducts;

    public Manager(String path) {
        p = new Parser();
        listOfConfig = p.readConfig("resources/config.xml");
        dp = new DomParser(path);
        listOfProducts = readInFile(path);
    }

    /**
     * Read in the file specified in the path.
     * @param path This is the path to the file which we want to read.
     * @return A list of products which is a datastructure.
     */
    private List<Product> readInFile(String path) {
        dp.parse();
        return dp.getList();
    }

    /**
     * Getter method
     * @return this returns the list of Products
     */
    public List<Product> getListOfProducts() {
        return listOfProducts;
    }

    /**
     * A setter method for listOfProducts.
     */
    public void setListOfProducts(List<Product> listOfProducts) {
        this.listOfProducts = listOfProducts;
    }

    /**
     * Returns the a list of Strings with the bars ID.
     * @return A list of String.
     */
    public List<String> getProductNames() {
        return listOfProducts.stream().map(Product::getName).collect(Collectors.toList());
    }

    /**
     * This method sorts the list by protein.
     * @return A list of Products which is sorted by protein
     */
    public List<Product> sortByProtein() {
        return listOfProducts.stream().sorted(Comparator.comparing(Product::getDProtein)).collect(Collectors.toList());
    }

    /**
     * This method sorts the list by Fett.
     * @return A list of Products which is sorted by fett.
     */
    public List<Product> sortByFett() {
        return listOfProducts.stream().sorted(Comparator.comparing(Product::getDFett)).collect(Collectors.toList());
    }

    /**
     * This method filters the list by fiber. If a Product has less than param it is included within the list
     * @param fiberThreshold the threshold for fiber.
     * @return the list of Products which we have filtered.
     */
    public List<Product> filterByFiber(double fiberThreshold) {
        return listOfProducts.stream().filter(product -> Double.parseDouble(product.getFiber()) < fiberThreshold).collect(Collectors.toList());
    }

    public void printReviewer() {
        Product p = listOfProducts.get(0);
        System.out.println(p.toString());
        for (Reviewer r:
                p.getListOfReviewer()) {
            System.out.println(r.toString());
        }
    }

    /**
    This method returns a list filtered by reviewer and protein.
    @param userID This is the user id for reviewer.
     @param protein this is where we specify the threshold for protein
     @return The list of sorted bars by reviewer and protein
     */
    public List<Product> getListOfProductsReviewedByUser(String userID, double protein) {
        List<Product> productList = new ArrayList<>();
        for (Product p :
                listOfProducts) {
            if (Double.parseDouble(p.getProtein()) > protein) {
                for (Reviewer r :
                        p.getListOfReviewer()) {
                    if (r.getId().equals(userID)) {
                        productList.add(p);
                    }
                }
            }
        }
        return productList;
    }
}
