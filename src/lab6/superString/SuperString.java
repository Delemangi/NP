package lab6.superString;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;
import java.util.stream.Collectors;

public class SuperString {
    private LinkedList<String> list;
    private Stack<String> stack;

    public SuperString() {
        this.list = new LinkedList<>();
        this.stack = new Stack<>();
    }

    public void append(String s) {
        list.addLast(s);
        stack.push(s);
    }

    public void insert(String s) {
        list.addFirst(s);
        stack.push(s);
    }

    public boolean contains(String s) {
        return toString().contains(s);
    }

    public void reverse() {
        Collections.reverse(list);

        list = list.stream().map(i -> new StringBuilder(i).reverse().toString()).collect(Collectors.toCollection(LinkedList::new));
    }

    public void removeLast(int k) {
        for (int i = 0; i < k; i++) {
            StringBuilder sb = new StringBuilder(stack.pop());

            list.remove(sb.toString());
            list.remove(sb.reverse().toString());
        }
    }

    @Override
    public String toString() {
        return String.join("", list);
    }
}