package se.kth.sda;

public class Program {

    private String path;
    private View view;
    private Manager manager;
    private boolean isRunning;

    public Program(String path) {
        this.path = path;
        this.view = new View();
        this.manager = new Manager(path);
        isRunning = false;
    }

    public void run() {

        while (!isRunning) {
            view.printMainMenu();
            String input = view.getUserInput();

            switch (input) {
                case "1":
                    showBarsWithSort();
                    break;
                case "2":
                    showBarsWithFilter();
                    break;
                case "3":
                    showBarsByReviewerAndProtein();
                    break;
                case "4":
                    isRunning = true;
                    break;
                default:
                    view.errorMessage();
            }

        }
    }

    private void showBarsWithSort() {
        view.showAllSubMenu();
        String input = view.getUserInput();

        switch (input) {
            case "1": // sort by protein
                view.showAllBars(manager.sortByProtein());
                break;
            case "2": // Sort by fett
                view.showAllBars(manager.sortByFett());
                break;
            case "3":
                view.showName(manager.getProductNames());
                break;
            case "4":
                view.showAllBars(manager.getListOfProducts());
                break;
            default:
                view.errorMessage();
        }
    }


    private void showBarsWithFilter() {
        view.enterFiber();
        String input = view.getUserInput();

        if (input.matches("[a-zA-Z]+")) view.errorMessage();
        else view.showAllBars(manager.filterByFiber(Double.parseDouble(input)));
    }

    private void showBarsByReviewerAndProtein() {
        view.enterReviewer();
        String review = view.getUserInput();
        view.enterProtein();
        String protein = view.getUserInput();

        if (protein.matches("[a-zA-Z]+")) {
            view.errorMessage();
        } else {
            view.showAllBars(manager.getListOfProductsReviewedByUser(review, Integer.parseInt(protein)));
        }
    }
}
