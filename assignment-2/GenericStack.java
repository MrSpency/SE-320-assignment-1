public class GenericStack<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 5; 

    //constructor with default initial capacity
    @SuppressWarnings("unchecked") //necessary because Java’s type system does not allow creating generic arrays directly.
    public GenericStack() {
        elements = (E[]) new Object[DEFAULT_CAPACITY]; // Create array with default capacity
    }

    //constructor with specified initial capacity
    @SuppressWarnings("unchecked")
    public GenericStack(int initialCapacity) {
        try {
            if (initialCapacity <= 0) {
                throw new IllegalArgumentException("Capacity must be greater than zero");
            }
            elements = (E[]) new Object[initialCapacity]; // Create array with specified capacity
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("Creating array with default size: " + DEFAULT_CAPACITY);
            elements = (E[]) new Object[DEFAULT_CAPACITY];
        }
    }

    public int getSize() {
        return size;
    }

    public E peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return elements[size - 1]; //index of the most recently added element
    }

    public void push(E o) {
        if (size == elements.length) {
            expandCapacity(); //expand capacity if the stack is full
        }
        elements[size++] = o; //store element o at index size + 1
    }

    public E pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        E o = elements[--size];  // Decrement size first, then get the top element
        elements[size] = null;    // Remove the top element by setting it to null
        return o;
    }    

    public boolean isEmpty() {
        return size == 0; //returns true when size is equal to 0
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("stack: ["); //start of the string
        for (int i = 0; i < size; i++) { //run through all elements
            sb.append(elements[i]); //append each element 
            if (i < size - 1) { //if not the last element, 
                sb.append(", "); //append space
            }
        }
        sb.append("]"); //end of the string 
        return sb.toString(); //return the whole string
    }

    // method to expand the array capacity
    @SuppressWarnings("unchecked")
    private void expandCapacity() {
        E[] newElements = (E[]) new Object[elements.length * 2]; //double the array size
        System.arraycopy(elements, 0, newElements, 0, size); //copies elements from index 0 through size to newElements
        elements = newElements; //updates the reference of elements to point to newElements
    }
}
