public class Main {
    public static void main(String[] args) {
        String[] categories = {"Fiction", "Non-Fiction", "Science", "History"};
        Library library = new Library(categories);

        // Adding books
        library.addBook(new Book("1984", "George Orwell", "123456789"));
        library.addBook(new Book("Brave New World", "Aldous Huxley", "987654321"));
        library.addBook(new Book("The Art of War", "Sun Tzu", "123123123"));

        System.out.println("Books before sorting:");
        library.displayBooks();

        // Sorting books
        library.sortBooks();
        System.out.println("Books after sorting:");
        library.displayBooks();

        // Removing a book
        library.removeBook(1); // Remove "Brave New World"
        System.out.println("Books after removal:");
        library.displayBooks();

        // Undo last action
        library.undoLastAction();
        System.out.println("Books after undo:");
        library.displayBooks();
    }
}
