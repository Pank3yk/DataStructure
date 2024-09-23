package LibraryManagementSystem;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField addTitleField;
    private JTextField addAuthorField;
    private JTextField addIsbnField;
    private Library library;  
    private JTextField textFieldIndex;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                GUI frame = new GUI();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public GUI() {
        library = new Library(10);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1025, 697);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(SystemColor.inactiveCaption);
        panel.setBounds(0, 0, 1373, 113);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Library Management System");
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 36));
        lblNewLabel.setBounds(259, 27, 549, 62);
        panel.add(lblNewLabel);

        JPanel addBookPanel = new JPanel();
        addBookPanel.setBackground(SystemColor.inactiveCaption);
        addBookPanel.setBounds(49, 123, 323, 537);
        contentPane.add(addBookPanel);
        addBookPanel.setLayout(null);

        JLabel addBookLabel = new JLabel("Add books here!");
        addBookLabel.setBounds(76, 30, 307, 26);
        addBookPanel.add(addBookLabel);
        addBookLabel.setFont(new Font("Tahoma", Font.BOLD, 20));

        addTitleField = new JTextField();
        addTitleField.setBackground(SystemColor.control);
        addTitleField.setBounds(36, 107, 234, 39);
        addBookPanel.add(addTitleField);
        addTitleField.setColumns(10);

        JLabel lblTitle = new JLabel("Book Title");
        lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblTitle.setBounds(113, 84, 116, 13);
        addBookPanel.add(lblTitle);

        addAuthorField = new JTextField();
        addAuthorField.setBackground(SystemColor.control);
        addAuthorField.setColumns(10);
        addAuthorField.setBounds(36, 192, 234, 39);
        addBookPanel.add(addAuthorField);

        addIsbnField = new JTextField();
        addIsbnField.setBackground(SystemColor.control);
        addIsbnField.setColumns(10);
        addIsbnField.setBounds(36, 283, 234, 39);
        addBookPanel.add(addIsbnField);

        JLabel lblAuthor = new JLabel("Book Author");
        lblAuthor.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblAuthor.setBounds(113, 169, 116, 13);
        addBookPanel.add(lblAuthor);

        JLabel lblIsbn = new JLabel("Book ISBN");
        lblIsbn.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblIsbn.setBounds(113, 260, 116, 13);
        addBookPanel.add(lblIsbn);
        
        JButton btnAddBook = new JButton("Add Book");
        btnAddBook.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnAddBook.addActionListener(e -> {
            String title = addTitleField.getText();
            String author = addAuthorField.getText();
            String isbn = addIsbnField.getText();

            if (!title.isEmpty() && !author.isEmpty() && !isbn.isEmpty()) {
                Book book = new Book(title, author, isbn);
                library.push(book);
                JOptionPane.showMessageDialog(null, "Book Added Successfully!");
                clearAddBookFields();
            } else {
                JOptionPane.showMessageDialog(null, "Please Fill in All Fields!");
            }
        });
        btnAddBook.setBounds(36, 358, 234, 39);
        addBookPanel.add(btnAddBook);
        
        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(10, 506, 85, 21);
        addBookPanel.add(btnExit);
        btnExit.addActionListener(e -> System.exit(0));
        btnExit.setFont(new Font("Tahoma", Font.BOLD, 16));

        JPanel additionalOptionsPanel = new JPanel();
        additionalOptionsPanel.setBackground(SystemColor.inactiveCaption);
        additionalOptionsPanel.setBounds(648, 123, 323, 537);
        contentPane.add(additionalOptionsPanel);
        additionalOptionsPanel.setLayout(null);

        JLabel lblAdditionalOptions = new JLabel("Additional Options");
        lblAdditionalOptions.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblAdditionalOptions.setBounds(49, 29, 234, 25);
        additionalOptionsPanel.add(lblAdditionalOptions);

        JButton btnRemoveBook = new JButton("Remove Last Book");
        btnRemoveBook.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnRemoveBook.addActionListener(e -> {
            try {
                Book removedBook = library.pop();
                JOptionPane.showMessageDialog(null, "Removed the last added book: " + removedBook.getTitle());
            } catch (IllegalStateException ex) {
                JOptionPane.showMessageDialog(null, "No more books to undo.", "Undo Error", JOptionPane.WARNING_MESSAGE);
            }
        });
        btnRemoveBook.setBounds(35, 155, 234, 39);
        additionalOptionsPanel.add(btnRemoveBook);

        JButton btnDisplayBooks = new JButton("Display Books");
        btnDisplayBooks.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnDisplayBooks.addActionListener(e -> {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < library.size(); i++) {
                sb.append("Index ").append(i).append(": ")
                  .append(library.get(i).toString()).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        });
        btnDisplayBooks.setBounds(35, 204, 234, 39);
        additionalOptionsPanel.add(btnDisplayBooks);

        JButton btnGetTotalBooks = new JButton("Get Total Books");
        btnGetTotalBooks.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnGetTotalBooks.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Total number of books: " + library.size());
        });
        btnGetTotalBooks.setBounds(35, 253, 234, 39);
        additionalOptionsPanel.add(btnGetTotalBooks);

        textFieldIndex = new JTextField();
        textFieldIndex.setBackground(SystemColor.control);
        textFieldIndex.setBounds(35, 106, 234, 39);
        additionalOptionsPanel.add(textFieldIndex);
        textFieldIndex.setColumns(10);

        JLabel lblIndex = new JLabel("Enter Index");
        lblIndex.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblIndex.setBounds(107, 82, 109, 13);
        additionalOptionsPanel.add(lblIndex);
        
        JButton btnNewButton = new JButton("Sort");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		library.sortBooksByTitle();
        		JOptionPane.showMessageDialog(null, "Books sorted by title.");
        		
        	}
        });
        btnNewButton.setBounds(35, 302, 85, 21);
        additionalOptionsPanel.add(btnNewButton);
    }

    private void clearAddBookFields() {
        addTitleField.setText("");
        addAuthorField.setText("");
        addIsbnField.setText("");
    }
}
