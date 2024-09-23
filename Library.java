import java.util.ArrayList;
import java.util.Stack;

public class Library {
    private String[] categories; // Fixed categories
    private ArrayList<Book> books; // Dynamic list of books
    private Stack<Action> actionStack; // Stack for undo operations

    public Library(String[] categories) {
        this.categories = categories;
        this.books = new ArrayList<>();
        this.actionStack = new Stack<>();
    }

    public void addBook(Book book) {
        books.add(book);
        actionStack.push(new Action("ADD", book)); // Push action for undo
    }

    public void removeBook(int index) {
        if (index >= 0 && index < books.size()) {
            Book removedBook = books.remove(index);
            actionStack.push(new Action("REMOVE", removedBook)); // Push action for undo
        }
    }

    public void undoLastAction() {
        if (!actionStack.isEmpty()) {
            Action lastAction = actionStack.pop();
            if (lastAction.getType().equals("ADD")) {
                books.remove(lastAction.getBook());
            } else if (lastAction.getType().equals("REMOVE")) {
                books.add(lastAction.getBook());
            }
        }
    }

    public void sortBooks() {
        Book[] bookArray = books.toArray(new Book[0]);
        shellSort(bookArray); // Sort using Shell Sort
        books.clear();
        for (Book book : bookArray) {
            books.add(book);
        }
    }

    private void shellSort(Book[] array) {
        int n = array.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                Book temp = array[i];
                int j;
                for (j = i; j >= gap && array[j - gap].getTitle().compareTo(temp.getTitle()) > 0; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
        }
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
