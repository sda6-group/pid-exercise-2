package se.kth.sda;
import javax.print.DocFlavor;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Parser {
    // This is for the config.file
    static final String DATE = "date";
    static final String ITEM = "item";
    static final String MODE = "mode";
    static final String UNIT = "unit";
    static final String CURRENT = "current";
    static final String INTERACTIVE = "interactive";

    // This is for product.file
    static final String BAR = "bar";
    static final String FETT = "fett";
    static final String ENERGY = "energy";
    static final String KOLHYDRATER = "kolhydrat";
    static final String PROTEIN = "protein";
    static final String FIBER = "fiber";
    static final String REVIEW = "review";
    static final String REVIEWER = "reviewer";
    static final String SCORE = "score";
    static final String SN = "SN";

    @SuppressWarnings({ "unchecked", "null" })
    public List<Item> readConfig(String configFile) {
        List<Item> items = new ArrayList<Item>();
        try {
            // First, create a new XMLInputFactory
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            // Setup a new eventReader
            InputStream in = new FileInputStream(configFile);
            XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
            // read the XML document
            Item item = null;

            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();

                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();
                    // If we have an item element, we create a new item
                    if (startElement.getName().getLocalPart().equals(ITEM)) {
                        item = new Item();
                        // We read the attributes from this tag and add the date
                        // attribute to our object
                        Iterator<Attribute> attributes = startElement
                                .getAttributes();
                        while (attributes.hasNext()) {
                            Attribute attribute = attributes.next();
                            if (attribute.getName().toString().equals(DATE)) {
                                item.setDate(attribute.getValue());
                            }

                        }
                    }

                    if (event.isStartElement()) {
                        if (event.asStartElement().getName().getLocalPart()
                                .equals(MODE)) {
                            event = eventReader.nextEvent();
                            item.setMode(event.asCharacters().getData());
                            continue;
                        }
                    }
                    if (event.asStartElement().getName().getLocalPart()
                            .equals(UNIT)) {
                        event = eventReader.nextEvent();
                        item.setUnit(event.asCharacters().getData());
                        continue;
                    }

                    if (event.asStartElement().getName().getLocalPart()
                            .equals(CURRENT)) {
                        event = eventReader.nextEvent();
                        item.setCurrent(event.asCharacters().getData());
                        continue;
                    }

                    if (event.asStartElement().getName().getLocalPart()
                            .equals(INTERACTIVE)) {
                        event = eventReader.nextEvent();
                        item.setInteractive(event.asCharacters().getData());
                        continue;
                    }
                }
                // If we reach the end of an item element, we add it to the list
                if (event.isEndElement()) {
                    EndElement endElement = event.asEndElement();
                    if (endElement.getName().getLocalPart().equals(ITEM)) {
                        items.add(item);
                    }
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        return items;
    }

    public List<Product> readProducts(String productFile) {
        List<Product> products = new ArrayList<Product>();
        try {
            // First, create a new XMLInputFactory
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            // Setup a new eventReader
            InputStream in = new FileInputStream(productFile);
            XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
            // read the XML document
            Product product = null;
            Reviewer r = null;
            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();
                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();
                    // If we have an bar element, we create a new product
                    if (startElement.getName().getLocalPart().equals(BAR)) {
                        product = new Product();
                        // We read the attributes from this tag and add the date
                        // attribute to our object
                        Iterator<Attribute> attributes = startElement
                                .getAttributes();
                        while (attributes.hasNext()) {
                            Attribute attribute = attributes.next();
                            if (attribute.getName().toString().equals(SN)) {
                                product.setSn(attribute.getValue());
                            }
                        }
                    }
//                    System.out.println(event.asStartElement().getName().getLocalPart());
                    if (event.isStartElement()) {
                        if (event.asStartElement().getName().getLocalPart()
                                .equals(FETT)) {
                            event = eventReader.nextEvent();
                            product.setFett(event.asCharacters().getData());
                            continue;
                        }
                    }
                    if (event.asStartElement().getName().getLocalPart()
                            .equals(ENERGY)) {
                        event = eventReader.nextEvent();
                        product.setEnergy(event.asCharacters().getData());
                        continue;
                    }

                    if (event.asStartElement().getName().getLocalPart()
                            .equals(KOLHYDRATER)) {
                        event = eventReader.nextEvent();
                        product.setKolhydrater(event.asCharacters().getData());
                        continue;
                    }

                    if (event.asStartElement().getName().getLocalPart()
                            .equals(PROTEIN)) {
                        event = eventReader.nextEvent();
                        product.setProtein(event.asCharacters().getData());
                        continue;
                    }

                    if (event.asStartElement().getName().getLocalPart()
                            .equals(FIBER)) {
                        event = eventReader.nextEvent();
                        product.setFiber(event.asCharacters().getData());
                        continue;
                    }

                    // This is the nested review
                    if (event.asStartElement().getName().getLocalPart()
                            .equals(REVIEW)) {
                        r = new Reviewer();
                        Iterator<Attribute> attributes = event.asStartElement().getAttributes();
                        Attribute a = attributes.next();
                        //System.out.println(a.getValue());
                        continue;
                    }

                    if (event.asStartElement().getName().getLocalPart().equals(REVIEWER)) {
                        Iterator<Attribute> atts = event.asStartElement().getAttributes();
                        Attribute rA = atts.next();
//                        System.out.println(rA.getValue());
                        r.setId(rA.getValue());
                        continue;
                    }

                    if (event.asStartElement().getName().getLocalPart().equals(DATE)) {
                        event = eventReader.nextEvent();
                        r.setDate(event.asCharacters().getData());
                        continue;
                    }
                    /*
                    THE BUG IS HERE!
                    I cannot add the reviewer to the list of the product object. It is weird.
                     */
                    if (event.asStartElement().getName().getLocalPart().equals(SCORE)) {
                        event = eventReader.nextEvent();
                        r.setScore(event.asCharacters().getData());
//                        System.out.println("--------------------");
//                        System.out.println(product.toString());
//                        System.out.println("Added to this product");
//                        System.out.println("--------------------");
//                        System.out.println(r.getId());
//                        System.out.println(r.getScore());
//                        System.out.println(r.getDate());
//                        System.out.println(r.toString());
                        product.getListOfReviewer().add(r);
                        continue;
                    }

                }
                // If we reach the end of an item element, we add it to the list
                if (event.isEndElement()) {
                    EndElement endElement = event.asEndElement();
                    if (endElement.getName().getLocalPart().equals(BAR)) {
                        products.add(product);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        return products;
    }
}
