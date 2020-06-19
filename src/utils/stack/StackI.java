package utils.stack;

public interface StackI<E> {

    E push(E item);

    E pop();

    E peek();

    boolean empty();


}
