package se.kth.sda;

import java.util.List;
import java.util.Scanner;

public class View {
    private Scanner scan;
    private int welcomeMessage;
    public View() {
        scan = new Scanner(System.in);
        welcomeMessage = 0;
    }

    public void printMainMenu() {

        if (welcomeMessage == 0) {
            welcomeMessage();
            welcomeMessage++;
        }

        System.out.println("Choose an option: ");
        System.out.println("1) Show all protein bars");
        System.out.println("2) Filter bars by fiber");
        System.out.println("3) Sort by reviewer and protein");
        System.out.println("4) Exit the program");
    }

    private void welcomeMessage() {
        System.out.println("Welcome to proteinbar application");
    }

    public void showAllBars(List<Product> list) {
        list.stream().forEach(System.out::println);
    }

    public String getUserInput() {
        return scan.nextLine();
    }

    public void showAllSubMenu() {
        System.out.println("1) Sort by highest protein content");
        System.out.println("2) Sort by highest fat content");
        System.out.println("3) Show all name");
        System.out.println("4) Show All");
    }

    public void showName(List<String> list) {
        list.stream().forEach(System.out::println);
    }

    public void enterReviewer() {
        System.out.println("Enter reviewer id");
    }

    public void enterProtein() {
        System.out.println("Enter protein number");
    }

    public void enterFiber() {
        System.out.println("Enter fiber number");
    }

    public void errorMessage() {
        System.out.println("Enter a valid option");
    }
}
