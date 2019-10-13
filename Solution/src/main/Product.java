package main;
import java.util.ArrayList;
import java.util.List;


public class Product {
    private String fett;
    private String sn;
    private String energy;
    private String kolhydrater;
    private String protein;
    private String fiber;
    private List<Reviewer> listOfReviewer = new ArrayList<>();

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
        return "Product: [" + sn + " " + fett + " " + energy + " " + kolhydrater + " " + protein + " " + fiber + "]";
    }
}
