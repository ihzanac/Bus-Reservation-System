import java.util.List;

public class CustomerSorter {
    // Bubble Sort: Youngest to Oldest
    public static void bubbleSortByAge(List<Customer> customers) {
        int n = customers.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (customers.get(j).getAge() > customers.get(j + 1).getAge()) {
                    Customer temp = customers.get(j);
                    customers.set(j, customers.get(j + 1));
                    customers.set(j + 1, temp);
                }
            }
        }
    }

    // Quick Sort: Youngest to Oldest
    public static void quickSortByAge(List<Customer> customers, int low, int high) {
        if (low < high) {
            int pi = partition(customers, low, high);
            quickSortByAge(customers, low, pi - 1);
            quickSortByAge(customers, pi + 1, high);
        }
    }

    private static int partition(List<Customer> customers, int low, int high) {
        int pivot = customers.get(high).getAge();
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (customers.get(j).getAge() < pivot) {
                i++;
                Customer temp = customers.get(i);
                customers.set(i, customers.get(j));
                customers.set(j, temp);
            }
        }
        Customer temp = customers.get(i + 1);
        customers.set(i + 1, customers.get(high));
        customers.set(high, temp);
        return i + 1;
    }
}
