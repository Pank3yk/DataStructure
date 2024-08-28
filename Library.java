package LibraryManagementSystem;

public class Library {
    private Book[] books;
    private int size;

    public Library(int capacity) {
        books = new Book[capacity];
        size = 0;
    }


    public void add(Book book) {
        if (size == books.length) {
            resize();
        }
        books[size] = book;
        size++;
    }

    public void insert(int index, Book book) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (size == books.length) {
            resize();
        }
        for (int i = size; i > index; i--) {
            books[i] = books[i - 1];
        }
        books[index] = book;
        size++;
    }


    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        for (int i = index; i < size - 1; i++) {
            books[i] = books[i + 1];
        }
        books[size - 1] = null;
        size--;
    }


    public Book get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return books[index];
    }


    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }


    private void resize() {
        Book[] newBooks = new Book[books.length * 2];
        System.arraycopy(books, 0, newBooks, 0, books.length);
        books = newBooks;
    }


    public void displayBooks() {
        for (int i = 0; i < size; i++) {
            System.out.println(books[i]);
        }
    }
}

