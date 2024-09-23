package LibraryManagementSystem;

public class Library {
    private Book[] books;
    private int size;

    public Library(int capacity) {
        books = new Book[capacity];
        size = 0;
    }

    public void push(Book book) {
        if (size == books.length) {
            resize();
        }
        books[size] = book;
        size++;
    }

    public Book pop() {
        if (isEmpty()) {
            throw new IllegalStateException("No books to remove.");
        }
        Book removedBook = books[size - 1];
        books[size - 1] = null; 
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

    public Book get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index.");
        }
        return books[index];
    }

    public void sortBooksByTitle() {
        if (isEmpty()) {
            throw new IllegalStateException("No books to sort.");
        }
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
