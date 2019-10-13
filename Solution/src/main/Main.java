package main;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final String path = "resources/products.xml";
        Program program = new Program(path);
        List<Product> products = program.getListOfProducts();

//        List<String> names = program.getProductNames();
//        for (String s :
//                names) {
//            System.out.println(s);
//        }
//
//        System.out.println("Sorted by Protein");
//        List<Product> sortedByProtein = program.sortByProtein();
//        for (Product p :
//                sortedByProtein) {
//            System.out.println(p.getProtein());
//        }
//
//        System.out.println("Sorted by Fett");
//        List<Product> sortedByFett = program.sortByFett();
//        for (Product p :
//                sortedByFett) {
//            System.out.println(p.getFett());
//        }
//        System.out.println("Filter by score");
//        List<Product> filteredByScore = program.filterByScore(4);
//        for (Product p :
//                filteredByScore) {
//            System.out.println(p);
//        }
//
//        System.out.println("Filter by reviewer");
//        List<Product> filtedByReviewer = program.getListOfProductsReviewedByUser("k6Y", 30);
//        for (Product p :
//             filtedByReviewer) {
//            System.out.println(p.getSn());
//        }
        program.printReviewer();
    }
}
