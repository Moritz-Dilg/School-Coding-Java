package carparts;

public class Order {
    public Item[] items;

    public void print() {
        for (Item item : items) {
            item.print();
        }
    }

    public boolean isFulfillable() {
        for (Item item : items) {
            if (!item.isFulfillable()) return false;
        }
        return true;
    }

    public void processOrder() {
        for (Item item : items) {
            item.processOrder();
        }
    }

    public static class Item {
        Part part;
        int quantity;

        Item(Part part, int quantity) {
            this.part = part;
            this.quantity = quantity;
        }

        public void print() {
            System.out.printf("%9s | %-30s |%6s | %s\n", this.part.nItem, this.part.description, this.part.stock, this.quantity);
        }

        public boolean isFulfillable() {
            return this.quantity <= this.part.stock;
        }

        public void processOrder() {
            this.part.stock -= this.quantity;
        }
    }
}
