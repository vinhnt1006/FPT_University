/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import java.util.LinkedList;

/**
 *
 * @author NK
 */
public class MyStack {

    LinkedList<Object> head;

    public MyStack() {
        head = new LinkedList<>();
    }

    public void push(Object x) {
        head.addFirst(x);
    }

    public boolean isEmpty() {
        return head.isEmpty();
    }

    public Object pop() {
        if (isEmpty()) {
            return null;
        }
        return head.removeFirst();
    }

    public Object top() {
        if (isEmpty()) {
            return null;
        }
        return head.getFirst();
    }
}
