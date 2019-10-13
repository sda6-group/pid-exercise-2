package main;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {
    private Parser p;
    private List<Item> listOfConfig;
    private List<Product> listOfProducts;
    private Scanner scan;

    public Program(String path) {
        p = new Parser();
        listOfConfig = p.readConfig("resources/config.xml");
        listOfProducts = readInFile(path);
        scan = new Scanner(System.in);
    }

    private List<Product> readInFile(String path) {
       return p.readProducts(path);
    }
    // This method is suppose to sort the read in list.
    public List<Item> sortByMode() {
        List<Item> sortedList = listOfConfig.stream().sorted(Comparator.comparing(Item::getMode).reversed()).collect(Collectors.toList());
        return sortedList;
    }

    public List<Item> sortByUnit() {
        List<Item> sortedList = listOfConfig.stream().sorted(Comparator.comparing(Item::getUnit)).collect(Collectors.toList());
       return sortedList;
    }

    public List<Item> filterByCurrent() {
        List<Item> filteredList = listOfConfig.stream().filter(item -> Integer.parseInt(item.getMode()) > 4).collect(Collectors.toList());
        return filteredList;
    }

    public List<Item> filterByReview() {
        return null;
    }

    public List<Product> getListOfProducts() {
        return listOfProducts;
    }

    public void setListOfProducts(List<Product> listOfProducts) {
        this.listOfProducts = listOfProducts;
    }

    public List<String> getProductNames() {
        List<String> listName = new ArrayList<>();
        listName = listOfProducts.stream().map(Product::getSn).collect(Collectors.toList());
        return listName;
    }

    public List<Product> sortByProtein() {
        List<Product> sorted = new ArrayList<>();
        sorted = listOfProducts.stream().sorted(Comparator.comparing(Product::getProtein)).collect(Collectors.toList());
        return sorted;
    }

    public List<Product> sortByFett() {
        return listOfProducts.stream().sorted(Comparator.comparing(Product::getFett)).collect(Collectors.toList());
    }

    public List<Product> filterByScore(int param) {
        List<Product> filteredScore = new ArrayList<>();
        int sum = 0;
        for (Product p :
                listOfProducts) {
            for (Reviewer r :
                    p.getListOfReviewer()) {
                sum += Integer.parseInt(r.getScore());
                if ((sum / p.getListOfReviewer().size()) > param) {
                   filteredScore.add(p);
                }
            }
        }
        return filteredScore;
    }

    public List<Product> getListOfProductsReviewedByUser(String userID, int protein) {
        List<Product> productList = new ArrayList<>();
        for (Product p :
                listOfProducts) {
            for (Reviewer r :
                    p.getListOfReviewer()) {
                if (r.getId().equals(userID)) {
                    productList.add(p);
                }
            }
        }
        return productList;
    }

    public void printReviewer() {
        Product p = listOfProducts.get(0);
        System.out.println(p.toString());
        for (Reviewer r:
             p.getListOfReviewer()) {
            System.out.println(r.toString());
        }
    }
}
