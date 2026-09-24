import java.util.*;

public class BusReservationSystem {
    Scanner sc = new Scanner(System.in);
    // Console UI helpers
    void printHeader(String title) {
        System.out.println("\n========================================");
        System.out.println("        " + title);
        System.out.println("========================================");
    }
    void printSeparator() {
        System.out.println("----------------------------------------");
    }
    void pause() {
        System.out.print("\nPress Enter to continue...");
        sc.nextLine();
    }

    public static void main(String[] args) {
        BusReservationSystem system = new BusReservationSystem();
        system.startMenu();
    }

    void startMenu() {
        while (true) {
            printHeader("Welcome to Bus Reservation System");
            System.out.println("1. Admin Login");
            System.out.println("2. Customer Login");
            System.out.println("3. Customer Registration");
            System.out.println("4. Exit");
            printSeparator();
            System.out.print("Enter choice: ");
            String input = sc.nextLine();
            int choice = -1;
            try { choice = Integer.parseInt(input); } catch (Exception e) {}
            switch (choice) {
                case 1: adminLogin(); break;
                case 2: customerLogin(); break;
                case 3: registerCustomer(); break;
                case 4: System.out.println("Thank you for using the system!"); System.exit(0);
                default: System.out.println("Invalid choice! Please enter 1-4."); pause();
            }
        }
    }

    void adminLogin() {
        printHeader("Admin Login");
        System.out.print("Enter admin username: ");
        String username = sc.nextLine();
        System.out.print("Enter admin password: ");
        String password = sc.nextLine();
        if (Admin.login(username, password)) {
            System.out.println("\nAdmin login successful!");
            pause();
            adminMenu();
        } else {
            System.out.println("Invalid admin credentials!");
            pause();
        }
    }

    void adminMenu() {
        while (true) {
            printHeader("Admin Menu");
            System.out.println("1. Register Bus");
            System.out.println("2. View All Reservations");
            System.out.println("3. Show All Customers (LIFO Stack)");
            System.out.println("4. Show All Buses");
            System.out.println("5. Show Customers by Age (Bubble Sort)");
            System.out.println("6. Show Customers by Age (Quick Sort)");
            System.out.println("7. Clear All Data");
            System.out.println("8. Logout");
            printSeparator();
            System.out.print("Enter choice: ");
            String input = sc.nextLine();
            int choice = -1;
            try { choice = Integer.parseInt(input); } catch (Exception e) {}
            switch (choice) {
                case 1: registerBus(); break;
                case 2: displayReservations(); break;
                case 3: showAllCustomersStack(); break;
                case 4: showAllBuses(); break;
                case 5: showCustomersByAgeBubble(); break;
                case 6: showCustomersByAgeQuick(); break;
                case 7: clearAllData(); break;
                case 8: return;
                default: System.out.println("Invalid choice! Please enter 1-8."); pause();
            }
        }
    }

    void displayReservations() {
        if (Database.reservations.isEmpty()) {
            System.out.println("No reservations found.");
            return;
        }
        for (Reservation r : Database.reservations) {
            System.out.println(r);
        }
    }

    void clearAllData() {
        Database.clearAll();
        System.out.println("All data cleared.");
    }

    void customerLogin() {
        printHeader("Customer Login");
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();
        Customer customer = null;
        for (Customer c : Database.customers) {
            if (c.getEmail().equalsIgnoreCase(email) && c.getPassword().equals(password)) {
                customer = c;
                break;
            }
        }
        if (customer == null) {
            System.out.println("Invalid email or password! Please register first if you don't have an account.");
            pause();
            return;
        }
        System.out.println("\nWelcome, " + customer.getName() + "!");
        pause();
        customerMenu(customer);
    }

    void customerMenu(Customer customer) {
        while (true) {
            printHeader("Customer Menu");
            System.out.println("1. Search Buses");
            System.out.println("2. Reserve Seat");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Request New Seat (Wait in Queue)");
            System.out.println("5. View My Reservations");
            System.out.println("6. Logout");
            printSeparator();
            System.out.print("Enter choice: ");
            String input = sc.nextLine();
            int choice = -1;
            try { choice = Integer.parseInt(input); } catch (Exception e) {}
            switch (choice) {
                case 1: searchBuses(); break;
                case 2: this.reserveSeatForCustomer(customer); break;
                case 3: this.cancelReservationForCustomer(customer); break;
                case 4: this.requestNewSeatForCustomer(customer); break;
                case 5: displayCustomerReservations(customer); break;
                case 6: return;
                default: System.out.println("Invalid choice! Please enter 1-6."); pause();
            }
        }
    }

    void registerCustomer() {
        printHeader("Customer Registration");
        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Mobile Number: ");
        String mobile = sc.nextLine();
        System.out.print("Enter Email ID: ");
        String email = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();
        System.out.print("Enter City: ");
        String city = sc.nextLine();
        System.out.print("Enter Age: ");
        String ageInput = sc.nextLine();
        int age = -1;
        try { age = Integer.parseInt(ageInput); } catch (Exception e) {}
        if (age < 0) {
            System.out.println("Invalid age! Please enter a valid number.");
            pause();
            return;
        }
        // Check for duplicate email
        for (Customer c : Database.customers) {
            if (c.getEmail().equalsIgnoreCase(email)) {
                System.out.println("Email already registered!");
                pause();
                return;
            }
        }
        Customer customer = new Customer(name, mobile, email, password, city, age);
        Database.customers.add(customer);
        System.out.println("Customer registered successfully! You can now login with your email and password.");
        pause();
    }

    void registerBus() {
        printHeader("Register New Bus");
        System.out.print("Enter Bus Number: ");
        String busNumber = sc.nextLine();
        for (Bus b : Database.buses) {
            if (b.getBusNumber().equalsIgnoreCase(busNumber)) {
                System.out.println("Bus number already exists!");
                pause();
                return;
            }
        }
        System.out.print("Enter Total Seats: ");
        String seatsInput = sc.nextLine();
        int totalSeats = -1;
        try { totalSeats = Integer.parseInt(seatsInput); } catch (Exception e) {}
        if (totalSeats <= 0) {
            System.out.println("Invalid number of seats!");
            pause();
            return;
        }
        System.out.print("Enter Starting Point: ");
        String startPoint = sc.nextLine();
        System.out.print("Enter Ending Point: ");
        String endPoint = sc.nextLine();
        System.out.print("Enter Starting Time: ");
        String startTime = sc.nextLine();
        System.out.print("Enter Fare: ");
        String fareInput = sc.nextLine();
        double fare = 0;
        try { fare = Double.parseDouble(fareInput); } catch (Exception e) {}
        if (fare <= 0) {
            System.out.println("Invalid fare!");
            pause();
            return;
        }
        Bus bus = new Bus(busNumber, totalSeats, startPoint, endPoint, startTime, fare);
        Database.buses.add(bus);
        System.out.println("Bus registered successfully!");
        pause();
    }

    void searchBuses() {
        try {
            System.out.println("Enter Starting Point:");
            String start = sc.nextLine();
            System.out.println("Enter Ending Point:");
            String end = sc.nextLine();
            List<Bus> foundBuses = new ArrayList<>();
            for (Bus bus : Database.buses) {
                if (bus.getStartPoint().equalsIgnoreCase(start) && bus.getEndPoint().equalsIgnoreCase(end)) {
                    foundBuses.add(bus);
                }
            }
            if (foundBuses.isEmpty()) {
                System.out.println("No buses found for the given route.");
                return;
            }
            System.out.println("\n--- Buses Found ---");
            for (int i = 0; i < foundBuses.size(); i++) {
                Bus bus = foundBuses.get(i);
                System.out.println((i+1) + ". " + bus);
            }
            System.out.print("Do you want to reserve seats on one of these buses? (yes/no): ");
            String reserveAns = sc.nextLine().trim().toLowerCase();
            if (reserveAns.equals("yes")) {
                System.out.print("Enter the number of the bus to reserve: ");
                int busChoice = sc.nextInt();
                sc.nextLine();
                if (busChoice < 1 || busChoice > foundBuses.size()) {
                    System.out.println("Invalid bus selection.");
                    return;
                }
                Bus selectedBus = foundBuses.get(busChoice - 1);
                // Show available seats
                List<Integer> availableSeats = new ArrayList<>();
                for (int i = 1; i <= selectedBus.getTotalSeats(); i++) {
                    if (!selectedBus.seatReservations.containsKey(i)) {
                        availableSeats.add(i);
                    }
                }
                System.out.println("Available seats: " + availableSeats);
                // Ask for customer email/password to identify
                Customer customer = getCustomerByLogin();
                if (customer == null) return;
                // Prevent duplicate reservation for same customer and bus
                for (Reservation r : Database.reservations) {
                    if (r.getCustomer().getId() == customer.getId() && r.getBus().getBusNumber().equalsIgnoreCase(selectedBus.getBusNumber()) && r.getStatus().equals("Reserved")) {
                        System.out.println("You already have a reservation on this bus.");
                        return;
                    }
                }
                if (availableSeats.isEmpty()) {
                    System.out.println("All seats are fully booked. You will be added to the waiting list.");
                    // Prevent duplicate waiting
                    for (Reservation r : Database.reservations) {
                        if (r.getCustomer().getId() == customer.getId() && r.getBus().getBusNumber().equalsIgnoreCase(selectedBus.getBusNumber()) && r.getStatus().equals("Waiting")) {
                            System.out.println("You are already in the waiting queue for this bus.");
                            return;
                        }
                    }
                    Reservation waiting = new Reservation(customer, selectedBus, -1, "Waiting");
                    selectedBus.waitingQueue.enqueue(waiting);
                    Database.reservations.add(waiting);
                    System.out.println("You are added to the waiting queue. Notification will be sent when a seat is available.");
                    return;
                }
                System.out.print("How many seats do you want to reserve? ");
                int numSeats = sc.nextInt();
                sc.nextLine();
                if (numSeats <= 0) {
                    System.out.println("Invalid number of seats.");
                    return;
                }
                int availableCount = availableSeats.size();
                int toBook = Math.min(numSeats, availableCount);
                List<Integer> bookedSeats = new ArrayList<>();
                for (int i = 0; i < toBook; i++) {
                    int seatNumber = availableSeats.get(i);
                    Reservation reservation = new Reservation(customer, selectedBus, seatNumber, "Reserved");
                    selectedBus.seatReservations.put(seatNumber, reservation);
                    Database.reservations.add(reservation);
                    bookedSeats.add(seatNumber);
                }
                int waitingCount = numSeats - toBook;
                if (waitingCount > 0) {
                    // Add one waiting reservation for the customer
                    Reservation waiting = new Reservation(customer, selectedBus, -1, "Waiting");
                    selectedBus.waitingQueue.enqueue(waiting);
                    Database.reservations.add(waiting);
                }
                // Show confirmation
                System.out.println("\n--- Reservation Summary ---");
                System.out.println("Customer: " + customer.getName() + " (ID: " + customer.getId() + ")");
                System.out.println("Bus: " + selectedBus.getBusNumber() + " | Route: " + selectedBus.getStartPoint() + " -> " + selectedBus.getEndPoint());
                System.out.println("Time: " + selectedBus.getStartTime());
                System.out.println("Fare per seat: Rs. " + selectedBus.getFare());
                if (!bookedSeats.isEmpty()) {
                    System.out.println("Reserved Seat Numbers: " + bookedSeats);
                }
                if (waitingCount > 0) {
                    System.out.println("Requested " + numSeats + " seat(s), but only " + toBook + " were available and reserved.");
                    System.out.println("You have been added to the waiting list for the remaining " + waitingCount + " seat(s). You will be notified when seats become available.");
                } else {
                    System.out.println("All requested seats have been reserved successfully.");
                }
                System.out.println("Status: " + (waitingCount > 0 ? "Partially Reserved + Waiting" : "Reserved"));
                System.out.println("--------------------------------------");
            }
        } catch (Exception e) {
            System.out.println("An error occurred. Please try again. Details: " + e.getMessage());
        }
    }

    // Helper for login during reservation
    Customer getCustomerByLogin() {
        System.out.print("Enter your email: ");
        String email = sc.nextLine();
        System.out.print("Enter your password: ");
        String password = sc.nextLine();
        for (Customer c : Database.customers) {
            if (c.getEmail().equalsIgnoreCase(email) && c.getPassword().equals(password)) {
                return c;
            }
        }
        System.out.println("Invalid email or password!");
        return null;
    }

    void reserveSeat() {
        System.out.println("Enter Customer ID:");
        int customerId = sc.nextInt();
        sc.nextLine();
        Customer customer = null;
        for (Customer c : Database.customers) {
            if (c.getId() == customerId) {
                customer = c;
                break;
            }
        }
        if (customer == null) {
            System.out.println("Customer not found!");
            return;
        }
        System.out.println("Enter Bus Number:");
        String busNumber = sc.nextLine();
        Bus bus = null;
        for (Bus b : Database.buses) {
            if (b.getBusNumber().equalsIgnoreCase(busNumber)) {
                bus = b;
                break;
            }
        }
        if (bus == null) {
            System.out.println("Bus not found!");
            return;
        }
        // Prevent duplicate reservation for same customer and bus
        for (Reservation r : Database.reservations) {
            if (r.getCustomer().getId() == customerId && r.getBus().getBusNumber().equalsIgnoreCase(busNumber) && r.getStatus().equals("Reserved")) {
                System.out.println("You already have a reservation on this bus.");
                return;
            }
        }
        // Find first available seat
        int seat = -1;
        for (int i = 1; i <= bus.getTotalSeats(); i++) {
            if (!bus.seatReservations.containsKey(i)) {
                seat = i;
                break;
            }
        }
        if (seat == -1) {
            System.out.println("No seats available. You can request to wait in queue.");
            return;
        }
        Reservation reservation = new Reservation(customer, bus, seat, "Reserved");
        bus.seatReservations.put(seat, reservation);
        Database.reservations.add(reservation);
        System.out.println("Reservation successful! Seat Number: " + seat);
        System.out.println("Notification sent to customer: " + customer.getName());
    }

    void cancelReservation() {
        System.out.println("Enter Customer ID:");
        int customerId = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Bus Number:");
        String busNumber = sc.nextLine();
        System.out.println("Enter Seat Number:");
        int seatNumber = sc.nextInt();
        sc.nextLine();
        Bus bus = null;
        for (Bus b : Database.buses) {
            if (b.getBusNumber().equalsIgnoreCase(busNumber)) {
                bus = b;
                break;
            }
        }
        if (bus == null) {
            System.out.println("Bus not found!");
            return;
        }
        Reservation reservation = bus.seatReservations.get(seatNumber);
        if (reservation == null || reservation.getCustomer().getId() != customerId) {
            System.out.println("Reservation not found!");
            return;
        }
        reservation.setStatus("Cancelled");
        bus.seatReservations.remove(seatNumber);
        System.out.println("Reservation cancelled. Notification sent to customer: " + reservation.getCustomer().getName());
        // Notify next in queue using OOP Queue
        if (!bus.waitingQueue.isEmpty()) {
            Reservation next = bus.waitingQueue.dequeue();
            if (next != null) {
                next.setStatus("Reserved");
                next.setSeatNumber(seatNumber);
                bus.seatReservations.put(seatNumber, next);
                System.out.println("Notification sent to next customer in queue: " + next.getCustomer().getName() + " (Seat " + seatNumber + ")");
            }
        }
    }

    void requestNewSeat() {
        System.out.println("Enter Customer ID:");
        int customerId = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Bus Number:");
        String busNumber = sc.nextLine();
        Customer customer = null;
        for (Customer c : Database.customers) {
            if (c.getId() == customerId) {
                customer = c;
                break;
            }
        }
        if (customer == null) {
            System.out.println("Customer not found!");
            return;
        }
        Bus bus = null;
        for (Bus b : Database.buses) {
            if (b.getBusNumber().equalsIgnoreCase(busNumber)) {
                bus = b;
                break;
            }
        }
        if (bus == null) {
            System.out.println("Bus not found!");
            return;
        }
        // Prevent duplicate waiting for same customer and bus
        for (Reservation r : Database.reservations) {
            if (r.getCustomer().getId() == customerId && r.getBus().getBusNumber().equalsIgnoreCase(busNumber) && r.getStatus().equals("Waiting")) {
                System.out.println("You are already in the waiting queue for this bus.");
                return;
            }
        }
        Reservation waiting = new Reservation(customer, bus, -1, "Waiting");
        bus.waitingQueue.enqueue(waiting);
        Database.reservations.add(waiting);
        System.out.println("You are added to the waiting queue. Notification will be sent when a seat is available.");
    }

    void cancelReservationForCustomer(Customer customer) {
        // Step 1: Ask for email and show all reservations for that customer
        System.out.print("Enter your email: ");
        String email = sc.nextLine();
        List<Reservation> myReservations = new ArrayList<>();
        for (Reservation r : Database.reservations) {
            if (r.getCustomer().getEmail().equalsIgnoreCase(email) && r.getStatus().equals("Reserved")) {
                myReservations.add(r);
            }
        }
        if (myReservations.isEmpty()) {
            System.out.println("No active reservations found for this email.");
            return;
        }
        System.out.println("\nYour Reservations:");
        for (int i = 0; i < myReservations.size(); i++) {
            Reservation r = myReservations.get(i);
            System.out.println((i+1) + ". Bus: " + r.getBus().getBusNumber() + ", Route: " + r.getBus().getStartPoint() + " -> " + r.getBus().getEndPoint() + ", Seat: " + r.getSeatNumber());
        }
        System.out.print("Enter the number of the reservation to cancel: ");
        int resChoice = sc.nextInt();
        sc.nextLine();
        if (resChoice < 1 || resChoice > myReservations.size()) {
            System.out.println("Invalid selection.");
            return;
        }
        Reservation reservation = myReservations.get(resChoice - 1);
        Bus bus = reservation.getBus();
        int seatNumber = reservation.getSeatNumber();
        reservation.setStatus("Cancelled");
        bus.seatReservations.remove(seatNumber);
        System.out.println("Reservation cancelled for Bus: " + bus.getBusNumber() + ", Seat: " + seatNumber);
        // Step 2: Assign seat to next in waiting queue (if any)
        if (!bus.waitingQueue.isEmpty()) {
            Reservation next = bus.waitingQueue.dequeue();
            next.setStatus("Reserved");
            next.setSeatNumber(seatNumber);
            bus.seatReservations.put(seatNumber, next);
            System.out.println("\n--- Waiting List Update ---");
            System.out.println("Seat " + seatNumber + " has been automatically assigned to the next waiting customer:");
            System.out.println("Name: " + next.getCustomer().getName());
            System.out.println("Email: " + next.getCustomer().getEmail());
            System.out.println("Bus: " + bus.getBusNumber() + ", Route: " + bus.getStartPoint() + " -> " + bus.getEndPoint());
            System.out.println("Time: " + bus.getStartTime());
            System.out.println("Status: Reserved from Waiting List");
            System.out.println("-----------------------------------");
        } else {
            System.out.println("No customers in the waiting list. Seat is now available for reservation.");
        }
    }

    void requestNewSeatForCustomer(Customer customer) {
        System.out.println("Enter Bus Number:");
        String busNumber = sc.nextLine();
        Bus bus = null;
        for (Bus b : Database.buses) {
            if (b.getBusNumber().equalsIgnoreCase(busNumber)) {
                bus = b;
                break;
            }
        }
        if (bus == null) {
            System.out.println("Bus not found!");
            return;
        }
        // Prevent duplicate waiting for same customer and bus
        for (Reservation r : Database.reservations) {
            if (r.getCustomer().getId() == customer.getId() && r.getBus().getBusNumber().equalsIgnoreCase(busNumber) && r.getStatus().equals("Waiting")) {
                System.out.println("You are already in the waiting queue for this bus.");
                return;
            }
        }
        Reservation waiting = new Reservation(customer, bus, -1, "Waiting");
        bus.waitingQueue.enqueue(waiting);
        Database.reservations.add(waiting);
        System.out.println("You are added to the waiting queue. Notification will be sent when a seat is available.");
    }

    void displayCustomerReservations(Customer customer) {
        boolean found = false;
        for (Reservation r : Database.reservations) {
            if (r.getCustomer().getId() == customer.getId()) {
                System.out.println(r);
                found = true;
            }
        }
        if (!found) System.out.println("No reservations found for you.");
    }

    void reserveSeatForCustomer(Customer customer) {
        try {
            System.out.println("Enter Bus Number:");
            String busNumber = sc.nextLine();
            Bus bus = null;
            for (Bus b : Database.buses) {
                if (b.getBusNumber().equalsIgnoreCase(busNumber)) {
                    bus = b;
                    break;
                }
            }
            if (bus == null) {
                System.out.println("Bus not found!");
                return;
            }
            // Prevent duplicate reservation for same customer and bus
            for (Reservation r : Database.reservations) {
                if (r.getCustomer().getId() == customer.getId() && r.getBus().getBusNumber().equalsIgnoreCase(busNumber) && r.getStatus().equals("Reserved")) {
                    System.out.println("You already have a reservation on this bus.");
                    return;
                }
            }
            // Find first available seat
            int seat = -1;
            for (int i = 1; i <= bus.getTotalSeats(); i++) {
                if (!bus.seatReservations.containsKey(i)) {
                    seat = i;
                    break;
                }
            }
            if (seat == -1) {
                System.out.println("No seats available. You can request to wait in queue.");
                return;
            }
            Reservation reservation = new Reservation(customer, bus, seat, "Reserved");
            bus.seatReservations.put(seat, reservation);
            Database.reservations.add(reservation);
            System.out.println("Reservation successful! Seat Number: " + seat);
            System.out.println("Notification sent to customer: " + customer.getName());
        } catch (Exception e) {
            System.out.println("An error occurred while reserving seat. Please try again. Details: " + e.getMessage());
        }
    }

    void showAllCustomersStack() {
        CustomerStack stack = new CustomerStack();
        for (Customer c : Database.customers) {
            stack.push(c);
        }
        System.out.println("\n--- All Customers (LIFO Order) ---");
        stack.printStack();
    }

    void showAllBuses() {
        if (Database.buses.isEmpty()) {
            System.out.println("No buses found.");
            return;
        }
        System.out.println("\n--- All Buses ---");
        for (Bus bus : Database.buses) {
            System.out.println(bus);
        }
    }

    void showCustomersByAgeBubble() {
        if (Database.customers.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }
        List<Customer> copy = new ArrayList<>(Database.customers);
        CustomerSorter.bubbleSortByAge(copy);
        System.out.println("\n--- Customers by Age (Bubble Sort, Youngest to Oldest) ---");
        for (Customer c : copy) {
            System.out.println(c);
        }
    }

    void showCustomersByAgeQuick() {
        if (Database.customers.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }
        List<Customer> copy = new ArrayList<>(Database.customers);
        CustomerSorter.quickSortByAge(copy, 0, copy.size() - 1);
        System.out.println("\n--- Customers by Age (Quick Sort, Youngest to Oldest) ---");
        for (Customer c : copy) {
            System.out.println(c);
        }
    }
}
