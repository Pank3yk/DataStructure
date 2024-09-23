package LibraryManagementSystem;

public class Library {
    private Book[] books;
    private int size;

    public Library(int capacity) {
        books = new Book[capacity];
        size = 0;
    }

    // Add a new book at the end
    public void add(Book book) {
        if (size == books.length) {
            resize();
        }
        books[size] = book;
        size++;
    }

    // Insert a book at a specific index
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


    // Remove a book from a specific index
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

    // Get a book from a specific index
    public Book get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return books[index];
    }


    public Book pop() {
        if (size == 0) {
            throw new IllegalStateException("No books to remove.");
        }
        Book removedBook = books[size - 1];
        books[size - 1] = null; // Clear the reference to help garbage collection
        size--;
        return removedBook;
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
    
    public void sortBooksByTitle() {
        insertionSort();
    }
    private void insertionSort() {
        for (int i = 1; i < size; i++) {
            Book key = books[i];
            int j = i - 1;
          
            while (j >= 0 && books[j].getTitle().compareTo(key.getTitle()) > 0) {
                books[j + 1] = books[j];
                j = j - 1;
            }
            books[j + 1] = key;
        }
    }
}
