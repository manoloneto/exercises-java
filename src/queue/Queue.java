package queue;

import exceptions.OverflowException;
import exceptions.UnderflowException;

public interface Queue<E> {

    public boolean isEmpty();

    public boolean isFull();

    public int numElements();

    public void enqueue(E element) throws OverflowException;

    public E dequeue() throws UnderflowException;

    public E front() throws UnderflowException;

    public E back() throws UnderflowException;
}