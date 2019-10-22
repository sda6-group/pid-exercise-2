package se.kth.sda;
import javax.xml.parsers.ParserConfigurationException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final String path = "resources/bars.xml";
        Program program = new Program(path);
//        Manager m = new Manager(path);

//        List<Product> list = m.getListOfProducts();

//        list.stream().forEach(product -> product.getListOfReviewer().stream().forEach(System.out::println));

//        for (Product p : list) {
//            System.out.println(p);
//            for (Reviewer r:
//                 p.getListOfReviewer()) {
//                System.out.println(r);
//            }
//        }
        program.run();
    }
}
