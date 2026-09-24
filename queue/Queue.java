package queue;

public class Queue<T> {
    private int front, rear, capacity;
    private Object[] q;

    public Queue(int c) {
        capacity = c;
        front = rear = 0;
        q = new Object[capacity];
    }

    public boolean isFull() {
        return (capacity == rear);
    }

    public boolean isEmpty() {
        return (front == rear);
    }

    public void enqueue(T data) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            q[rear] = data;
            rear++;
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        } else {
            @SuppressWarnings("unchecked")
            T item = (T) q[front];
            for (int i = 0; i < rear - 1; i++) {
                q[i] = q[i + 1];
            }
            if (rear < capacity) {
                q[rear - 1] = null;
            }
            rear--;
            return item;
        }
    }

    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        for (int i = front; i < rear; i++) {
            System.out.println(q[i]);
        }
    }

    public int size() {
        return rear - front;
    }
}
