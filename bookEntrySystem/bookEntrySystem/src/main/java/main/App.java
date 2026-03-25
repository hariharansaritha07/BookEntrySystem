package main;


import java.util.Scanner;

import bookEntrySystem.entity.Author;
import bookEntrySystem.entity.Book;
import bookEntrySystem.service.AuthorService;
import bookEntrySystem.service.BookService;



public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        AuthorService authorService = new AuthorService();
        BookService bookService = new BookService();

        while (true) {

            System.out.println("\n===== BOOK ENTRY SYSTEM =====");
            System.out.println("1. Add Author");
            System.out.println("2. View All Authors");
            System.out.println("3. Add Book");
            System.out.println("4. View Book by ID");
            System.out.println("5. Delete Book");
            System.out.println("6. Display All Books (with Author)");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input! Enter a number.");
                sc.nextLine(); // clear wrong input
                continue;
            }

            switch (choice) {

                case 1:
                    sc.nextLine(); // clear buffer

                    System.out.print("Enter Author Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Country: ");
                    String country = sc.nextLine();

                    authorService.addAuthor(new Author(0, name, country));
                    break;

                case 2:
                    System.out.println("\n--- Author List ---");
                    authorService.displayAuthors();
                    break;

                case 3:
                    sc.nextLine(); // clear buffer

                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author ID: ");
                    int authorId;
                    try {
                        authorId = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println("Invalid Author ID!");
                        sc.nextLine();
                        break;
                    }

                    sc.nextLine(); // clear buffer

                    System.out.print("Enter Publisher: ");
                    String publisher = sc.nextLine();

                    System.out.print("Enter Year: ");
                    int year;
                    try {
                        year = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println("Invalid Year!");
                        sc.nextLine();
                        break;
                    }

                    bookService.addBook(new Book(0, title, authorId, publisher, year));
                    break;

                case 4:
                    System.out.print("Enter Book ID: ");
                    int id;
                    try {
                        id = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println("Invalid ID!");
                        sc.nextLine();
                        break;
                    }

                    Book b = bookService.getBook(id);

                    if (b != null) {
                        System.out.println("\nBook Details:");
                        System.out.println("Title: " + b.getTitle());
                        System.out.println("Author ID: " + b.getAuthorId());
                        System.out.println("Publisher: " + b.getPublisher());
                        System.out.println("Year: " + b.getYear());
                    } else {
                        System.out.println("Book Not Found!");
                    }
                    break;

                case 5:
                    System.out.print("Enter Book ID to delete: ");
                    int deleteId;
                    try {
                        deleteId = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println("Invalid ID!");
                        sc.nextLine();
                        break;
                    }

                    bookService.deleteBook(deleteId);
                    break;

                case 6:
                    System.out.println("\n--- Book List with Author ---");
                    bookService.displayBooksWithAuthor();
                    break;

                case 7:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}