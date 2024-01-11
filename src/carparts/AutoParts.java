package carparts;

import java.io.FileNotFoundException;

public class AutoParts {
    public static void main(String[] args) throws FileNotFoundException {
        AutoPartWarehouse warehouse = new AutoPartWarehouse("./src/carparts/Autoparts_update.txt",
                "./src/carparts/Orders.txt");
        warehouse.print();
        warehouse.processOrders();
        System.out.println("\n*** Warehouse after processing orders ***");
        warehouse.print();
    }
}
