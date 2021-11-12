package lab5.generickiRed;

public class Queue<T> {
    private Node<T> first;
    private Node<T> last;
    private int count;

    public Queue() {
        this.first = null;
        this.last = null;
        this.count = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(T element) {
        if (first == null) {
            first = new Node<>(element);
            last = first;
        } else {
            last.setNext(new Node<>(element));
            last = last.getNext();
        }

        count++;
    }

    public T dequeue() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }

        Node<T> node = first;
        first = first.getNext();

        if (first == null) {
            last = null;
        }

        count--;

        return node.getElement();
    }

    public T peek() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }

        return first.getElement();
    }

    public T inspect() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }

        return last.getElement();
    }

    public int count() {
        return count;
    }
}