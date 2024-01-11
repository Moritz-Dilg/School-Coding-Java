package carparts;

public class Part {
    int nItem;
    String description;
    int stock;

    Part(int nItem, String description, int stock) {
        this.nItem = nItem;
        this.description = description;
        this.stock = stock;
    }

    public void print() {
        System.out.printf("%9s | %-30s |%6s\n", this.nItem, this.description, this.stock);
    }

    public static Part parsePart(String line) {
        String[] parts = line.split(" ");
        int nItem = Integer.parseInt(parts[0]);
        String description = line.substring(line.indexOf('"') + 1, line.lastIndexOf('"'));
        int stock = Integer.parseInt(parts[parts.length - 1]);
        return new Part(nItem, description, stock);
    }
}
