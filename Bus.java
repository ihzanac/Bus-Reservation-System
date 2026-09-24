import java.util.*;
import queue.Queue;

public class Bus {
    private String busNumber;
    private int totalSeats;
    private String startPoint;
    private String endPoint;
    private String startTime;
    private double fare;
    public Map<Integer, Reservation> seatReservations = new HashMap<>();
    public Queue<Reservation> waitingQueue = new Queue<>(100); // Set a reasonable max size

    public Bus(String busNumber, int totalSeats, String startPoint, String endPoint, String startTime, double fare) {
        this.busNumber = busNumber;
        this.totalSeats = totalSeats;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.startTime = startTime;
        this.fare = fare;
    }

    public String getBusNumber() { return busNumber; }
    public int getTotalSeats() { return totalSeats; }
    public String getStartPoint() { return startPoint; }
    public String getEndPoint() { return endPoint; }
    public String getStartTime() { return startTime; }
    public double getFare() { return fare; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n----------------------------------------\n");
        sb.append(String.format("%-14s: %s\n", "Bus Number", busNumber));
        sb.append(String.format("%-14s: %d\n", "Total Seats", totalSeats));
        sb.append(String.format("%-14s: %s -> %s\n", "Route", startPoint, endPoint));
        sb.append(String.format("%-14s: %s\n", "Start Time", startTime));
        sb.append(String.format("%-14s: Rs. %.2f\n", "Fare", fare));
        sb.append("----------------------------------------");
        return sb.toString();
    }
}
