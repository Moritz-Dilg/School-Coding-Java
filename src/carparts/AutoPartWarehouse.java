package carparts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AutoPartWarehouse {
    private final Part[] parts;
    private final Order[] orders;

    AutoPartWarehouse(String parts, String orders) throws FileNotFoundException {
        Scanner s = new Scanner(new FileInputStream(parts));
        int count = s.nextInt();
        s.nextLine();
        this.parts = new Part[count];
        for (int i = 0; i < count; i++) {
            String line = s.nextLine();
            this.parts[i] = Part.parsePart(line);
        }

        s = new Scanner(new FileInputStream(orders));
        count = s.nextInt();
        s.nextLine();
        this.orders = new Order[count];
        for (int i = 0; i < count; i++) {
            String line = s.nextLine();
            String[] orderSplitted = line.split(" ");
            int countOrders = Integer.parseInt(orderSplitted[0]);
            Order order = new Order();
            order.items = new Order.Item[countOrders];
            for (int j = 0; j < countOrders; j++) {
                String[] item = orderSplitted[j + 1].split(",");
                order.items[j] = new Order.Item(getPartByIndex(Integer.parseInt(item[0])), Integer.parseInt(item[1]));
            }
            this.orders[i] = order;
        }
    }

    private Part getPartByIndex(int idx) {
        for (Part part : parts) {
            if (part.nItem == idx)
                return part;
        }
        return null;
    }

    public void processOrders() {
        for (Order order : orders) {
            if (order.isFulfillable()) {
                order.processOrder();
                order = null;
            }
        }
    }

    public void print() {
        System.out.println("\n\nParts:");
        System.out.printf("%9s | %-30s |%6s\n", "Part no.", "Description", "Stock");
        System.out.println("---------------------------------------------------");
        for (Part part : parts) {
            part.print();
        }

        /* --Print Orders--*/
        System.out.println("\n\nOrders:");
        System.out.printf("%9s | %-30s |%6s | QTD.\n", "Part no.", "Description", "Stock");
        System.out.println("----------------------------------------------------------");
        for (Order order : orders) {
            if (order != null) {
                order.print();
                System.out.println("----------------------------------------------------------");
            }
        }

    }
}
