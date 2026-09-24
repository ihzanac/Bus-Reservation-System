public class Reservation {
    private Customer customer;
    private Bus bus;
    private int seatNumber;
    private String status; // Reserved, Cancelled, Waiting

    public Reservation(Customer customer, Bus bus, int seatNumber, String status) {
        this.customer = customer;
        this.bus = bus;
        this.seatNumber = seatNumber;
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getStatus() {
        return status;
    }

    // Improved UI/UX toString below. Remove duplicate below.
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n----------------------------------------\n");
        sb.append(String.format("%-12s: %s\n", "Customer", customer.getName()));
        sb.append(String.format("%-12s: %s\n", "Email", customer.getEmail()));
        sb.append(String.format("%-12s: %s\n", "Bus", bus.getBusNumber()));
        sb.append(String.format("%-12s: %s -> %s\n", "Route", bus.getStartPoint(), bus.getEndPoint()));
        sb.append(String.format("%-12s: %s\n", "Time", bus.getStartTime()));
        sb.append(String.format("%-12s: %s\n", "Seat", seatNumber == -1 ? "Waiting" : seatNumber));
        sb.append(String.format("%-12s: %s\n", "Status", status));
        sb.append("----------------------------------------");
        return sb.toString();
    }

    public void setStatus(String status) {
        this.status = status;
    }

    //
}
