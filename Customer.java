public class Customer {
    private String name;
    private String mobile;
    private String email;
    private String password;
    private String city;
    private int age;
    private int id;
    private static int idCounter = 1;

    public Customer(String name, String mobile, String email, String password, String city, int age) {
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.password = password;
        this.city = city;
        this.age = age;
        this.id = idCounter++;
    }

    public String getName() { return name; }
    public String getMobile() { return mobile; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getCity() { return city; }
    public int getAge() { return age; }
    public int getId() { return id; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n----------------------------------------\n");
        sb.append(String.format("%-12s: %s\n", "Customer ID", id));
        sb.append(String.format("%-12s: %s\n", "Name", name));
        sb.append(String.format("%-12s: %s\n", "Mobile", mobile));
        sb.append(String.format("%-12s: %s\n", "Email", email));
        sb.append(String.format("%-12s: %s\n", "City", city));
        sb.append(String.format("%-12s: %d\n", "Age", age));
        sb.append("----------------------------------------");
        return sb.toString();
    }
}
