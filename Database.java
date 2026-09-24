import java.util.*;

public class Database {
    public static List<Customer> customers = new ArrayList<>();
    public static List<Bus> buses = new ArrayList<>();
    public static List<Reservation> reservations = new ArrayList<>();

    static {
        // Dummy Customers (Sri Lanka)
        customers.add(new Customer("Nimal Perera", "0771234567", "nimal@gmail.com", "pass123", "Colombo", 32));
        customers.add(new Customer("Kumari Silva", "0712345678", "kumari@yahoo.com", "kumari@2024", "Kandy", 28));
        customers.add(new Customer("Saman Fernando", "0759876543", "samanf@gmail.com", "samanpw", "Galle", 40));
        customers.add(new Customer("Ruwan Jayasuriya", "0724567890", "ruwanj@outlook.com", "ruwanpw", "Jaffna", 35));
        customers.add(new Customer("Tharushi Dissanayake", "0761122334", "tharushi@gmail.com", "tharu321", "Matara", 22));

        // Dummy Buses (Sri Lanka)
        buses.add(new Bus("NB-1234", 40, "Colombo", "Kandy", "06:00", 1200.0));
        buses.add(new Bus("NC-5678", 45, "Kandy", "Jaffna", "08:30", 2500.0));
        buses.add(new Bus("ND-4321", 38, "Galle", "Colombo", "07:15", 1000.0));
        buses.add(new Bus("NE-8765", 50, "Matara", "Colombo", "05:45", 1500.0));
        buses.add(new Bus("NF-2468", 42, "Colombo", "Galle", "09:00", 1100.0));
    }

    // Utility: Clear all data (for admin/testing)
    public static void clearAll() {
        customers.clear();
        buses.clear();
        reservations.clear();
    }
}
