package queue;

import exceptions.OverflowException;
import exceptions.UnderflowException;

public class StaticQueue<E> implements Queue<E> {
    protected int first;
    protected int last;
    protected E elements[];

    public StaticQueue(int maxSize) {
        elements = (E[]) new Object[maxSize];
        first = last = -1;
    }

    public boolean isEmpty() {
        return first == -1;
    }

    public boolean isFull() {
        return first == ((last + 1) % elements.length);
    }

    public int numElements() {
        if (isEmpty())
            return 0;
        else {
            int n = elements.length;
            return ((n + last - first) % n) + 1;
        }
    }

    public void enqueue(E element) throws OverflowException {
        if (isFull())
            throw new OverflowException();
        else {
            if (last == -1)
                first = last = 0;
            else
                last = (last + 1) % elements.length;
            elements[last] = element;
        }

    }

    public E dequeue() throws UnderflowException {
        if (isEmpty())
            throw new UnderflowException();
        E element = elements[first];
        elements[first] = null;
        if (first == last)
            first = last = -1;
        else
            first = (first + 1) % elements.length;

        return element;
    }

    public E front() throws UnderflowException {
        if (isEmpty())
            throw new UnderflowException();
        return elements[first];
    }

    public E back() throws UnderflowException {
        if (isEmpty())
            throw new UnderflowException();
        return elements[last];
    }

    public String toString() {
        if (isEmpty())
            return "[Empty]";
        else {
            String s = "[" + elements[first];
            int n = numElements();
            for (int i = 1; i < n; i++) {
                int k = (first + i) % elements.length;
                s += ", " + elements[k];
            }
            s += "]";
            return s;
        }
    }

    /**
     * Implemente o método contains, definido abaixo, que informa se a fila contém
     * determinado elemento.
     */
    public boolean contains(E element) {
        for (E e : elements) {
            if (e.equals(element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Implemente um método que inverte a ordem dos elementos da fila.
     */
    public void flip() {
        E[] aux = (E[]) new Object[elements.length];
        int size = numElements() - 1;
        int cont = 0;
        for (int i = size; i >= 0; i++) {
            aux[cont] = elements[i];
            cont++;
        }
    }

    /**
     * Implemente uma sobrecarga do método enqueue que recebe como parâmetro uma fila,
     * em vez de um elemento. Esse método deve adicionar ao final da fila corrente os
     * elementos da fila passada como parâmetro, mantendo a ordem original.
     */
    public void enqueue(Queue<E> elements) {
        if (isFull()) {
            throw new OverflowException();
        } else {
            while (!elements.isEmpty()) {
                enqueue(elements.dequeue());
            }
        }
    }

    /**
     * Implemente o método abaixo, que insere um elemento na primeira posição da fila.
     */
    public void enqueueWithPriority(E element) {
        if (isFull()) {
            throw new OverflowException();
        } else {
            int size = numElements();
            enqueue(element);
            for (int i = 0; i < size; i++) {
                E aux = dequeue();
                enqueue(aux);
            }
        }
    }

    /**
     * Implemente um método equals para a fila. Uma fila será igual a outra se contiver os
     * mesmos elementos, dispostos na mesma ordem. Para comparar os elementos, use
     * também o método equals.
     */
    public boolean equals(Queue<E> queueToCompare) {
        for (int i = 0; i < numElements(); i++) {
            E aux = queueToCompare.dequeue();
            if (elements[i] != aux) {
                return false;
            }
        }
        return true;
    }

    /**
     * Implemente um método clone para a fila. Esse método deve retornar uma nova fila
     * contendo os mesmos elementos da atual. Os elementos em si não devem ser
     * duplicados.
     */
    public Queue<E> clone() {
        Queue<E> clone = new StaticQueue<E>(numElements());
        for (int i = 0; i < numElements(); i++) {
            clone.enqueue(elements[i]);
        }
        return clone;
    }

}