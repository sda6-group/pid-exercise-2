package se.kth.sda;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

//import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomParser {
    private String path;
    private File file;
    private DocumentBuilder dBuilder;
    private Document doc;
    private List<Product> productList;
    Product p = new Product();

    public DomParser(String path) {
        productList = new ArrayList<>();
        try {
            this.path = path;
            this.file = new File(path);
            this.dBuilder = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder();
            doc = (Document) dBuilder.parse(file);

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printRoot() {
        System.out.println("Root: " + doc.getDocumentElement().getNodeName());
    }

    public void printNodes(){
        if (doc.hasChildNodes()) {
            printNode(doc.getChildNodes());
        }
    }

    private void printNode(NodeList childNodes) {
        Reviewer r = new Reviewer();
        for (int count = 0; count < childNodes.getLength(); count++) {
            Node tempNode = childNodes.item(count);

            if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
                System.out.println("\nNode Name = " + tempNode.getNodeName() + " [Open]");
                System.out.println("Node Value = " + tempNode.getTextContent());

                switch (tempNode.getNodeName()) {
                    case "fett":
                        p.setFett(tempNode.getTextContent());
                        break;
                    case "energy":
                        p.setEnergy(tempNode.getTextContent());
                        break;
                    case "kolhydrat":
                        p.setKolhydrater(tempNode.getTextContent());
                        break;
                    case "protein":
                        p.setProtein(tempNode.getTextContent());
                        break;
                    case "fiber":
                        p.setFiber(tempNode.getTextContent());
                        break;
                    case "date":
                        r.setDate(tempNode.getTextContent());
                        break;
                    case "score":
                        r.setScore(tempNode.getTextContent());
                        break;
                }

                if (tempNode.hasAttributes()) {

                    NamedNodeMap nodeMap = tempNode.getAttributes();

                    for (int i = 0; i < nodeMap.getLength(); i++) {

                        Node node = nodeMap.item(i);
                        System.out.println("Attribute name " + node.getNodeName());
                        System.out.println("Attribute value " + node.getNodeValue());
                    }
                }

                if (tempNode.hasChildNodes()) {
                    printNode(tempNode.getChildNodes());
                }
                // Add the product to list
                System.out.println("Node name = " + tempNode.getNodeName() + "[Close]");
                productList.add(p);
            }
        }
    }

    public void parse() {
        doc.getDocumentElement().normalize();

//        System.out.println("Root: " + doc.getDocumentElement().getNodeName());
        NodeList nList = doc.getChildNodes().item(0).getChildNodes();

        for (int count = 0; count < nList.getLength(); count++) {
            Product p = new Product();
            Node n = nList.item(count);
            if (n.getNodeType() == Element.ELEMENT_NODE) {
                Element e = (Element) n;
//                System.out.println(e.getElementsByTagName("fett").item(0).getTextContent());
                p.setName(e.getTagName());
                p.setSn(e.getAttribute("SN"));
                p.setFett(e.getElementsByTagName("fett").item(0).getTextContent());
                p.setEnergy(e.getElementsByTagName("energy").item(0).getTextContent());
                p.setKolhydrater(e.getElementsByTagName("kolhydrat").item(0).getTextContent());
                p.setProtein(e.getElementsByTagName("protein").item(0).getTextContent());
                p.setFiber(e.getElementsByTagName("fiber").item(0).getTextContent());

                NodeList childs = ((Element) n).getElementsByTagName("reviewer");
                for (int i = 0; i < childs.getLength() ; i++) {
                    Reviewer reviewer = new Reviewer();
                    Node r = childs.item(i);
                    if (r.getNodeType() == Element.ELEMENT_NODE) {
                        Element eChild = (Element) r;
                        reviewer.setId(eChild.getAttribute("personID"));
                        reviewer.setDate(eChild.getElementsByTagName("date").item(0).getTextContent());
                        reviewer.setScore(eChild.getElementsByTagName("score").item(0).getTextContent());
                    }

                    p.getListOfReviewer().add(reviewer);
                }
                productList.add(p);
            }
//            System.out.println("--------------------------");

        }
    }

    public List<Product> getList() {
        return productList;
    }
}
