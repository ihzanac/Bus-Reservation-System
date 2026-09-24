

public class CustomerStack {
    private int max = 1000;
    private int top;
    private Customer[] a = new Customer[max];

    public CustomerStack() {
        this.top = -1;
    }

    public boolean isEmpty() {
        return (top < 0);
    }

    public boolean isFull() {
        return (top >= max - 1);
    }

    public boolean push(Customer data) {
        if (isFull()) {
            System.out.println("Stack overflow");
            return false;
        } else {
            a[++top] = data;
            return true;
        }
    }

    public Customer pop() {
        if (isEmpty()) {
            System.err.println("Stack underflow");
            return null;
        } else {
            return a[top--];
        }
    }

    public Customer peek() {
        if (isEmpty()) {
            System.err.println("Stack underflow");
            return null;
        } else {
            return a[top];
        }
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("No customers in stack.");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.println(a[i]);
        }
    }
}
