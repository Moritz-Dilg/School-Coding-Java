package inheritance.ticketForEvents;

public class TicketMain {
    public static void main(String[] args) {
        WalkupTicket walkupTicket1 = new WalkupTicket(1);
        WalkupTicket walkupTicket2 = new WalkupTicket(2);
        AdvanceTicket advanceTicket1 = new AdvanceTicket(3, 5);
        AdvanceTicket advanceTicket2 = new AdvanceTicket(4, 10);
        StudentAdvanceTicket studentAdvanceTicket1 = new StudentAdvanceTicket(5, 5);
        StudentAdvanceTicket studentAdvanceTicket2 = new StudentAdvanceTicket(6, 10);

        System.out.println(walkupTicket1);
        System.out.println(walkupTicket2);
        System.out.println(advanceTicket1);
        System.out.println(advanceTicket2);
        System.out.println(studentAdvanceTicket1);
        System.out.println(studentAdvanceTicket2);
    }


    private static class Ticket {
        int number;

        Ticket(int number) {
            this.number = number;
        }

        int getPrice() {
            return 50;
        }

        public String toString() {
            return "Number " + number + ", Price 50$";
        }
    }

    private static class WalkupTicket extends Ticket {

        WalkupTicket(int number) {
            super(number);
        }
    }

    private static class AdvanceTicket extends Ticket {
        int daysInAdvance;

        AdvanceTicket(int number, int daysInAdvance) {
            super(number);
            this.daysInAdvance = daysInAdvance;
        }

        int getPrice() {
            return this.daysInAdvance >= 10 ? 30 : 40;
        }

        public String toString() {
            return "Number " + number + ", Price " + getPrice() + "$";
        }
    }

    private static class StudentAdvanceTicket extends AdvanceTicket {

        StudentAdvanceTicket(int number, int daysInAdvance) {
            super(number, daysInAdvance);
        }

        int getPrice() {
            return super.getPrice() / 2;
        }

        public String toString() {
            return super.toString() + " (ID required)";
        }
    }
}
