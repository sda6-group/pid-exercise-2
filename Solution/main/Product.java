package se.kth.sda;
import java.util.ArrayList;
import java.util.List;


public class Product {
    private String sn;
    private String fett;
    private String energy;
    private String kolhydrater;
    private String protein;
    private String fiber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private List<Reviewer> listOfReviewer = new ArrayList<>();

    public Product() {
    }

    public Product(String name, String sn, String fett, String energy, String kolhydrater, String protein, String fiber) {
        this.name = name;
        this.fett = fett;
        this.sn = sn;
        this.energy = energy;
        this.kolhydrater = kolhydrater;
        this.protein = protein;
        this.fiber = fiber;
    }

    public String getFett() {
        return fett;
    }

    public void setFett(String fett) {
        this.fett = fett;
    }

    public String getEnergy() {
        return energy;
    }

    public void setEnergy(String energy) {
        this.energy = energy;
    }

    public String getKolhydrater() {
        return kolhydrater;
    }

    public void setKolhydrater(String kolhydrater) {
        this.kolhydrater = kolhydrater;
    }

    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    public String getFiber() {
        return fiber;
    }

    public void setFiber(String fiber) {
        this.fiber = fiber;
    }

    public List<Reviewer> getListOfReviewer() {
        return listOfReviewer;
    }

    public void setListOfReviewer(List<Reviewer> listOfReviewer) {
        this.listOfReviewer = listOfReviewer;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    @Override
    public String toString() {
        return "Product: [" + name + " ID: " + sn + " Fett: " + fett + " Energy: " + energy + " Carbs: " + kolhydrater + " Protein: " + protein + " Fiber: " + fiber + "]";
    }
}
