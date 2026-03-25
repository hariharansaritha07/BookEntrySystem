package bookEntrySystem.service;

import bookEntry.dao.BookDAO;
import bookEntrySystem.entity.Book;

public class BookService {

    BookDAO dao = new BookDAO();

    public void addBook(Book b) {
        dao.addBook(b);
    }

    public Book getBook(int id) {
        return dao.getBook(id);
    }

    public void deleteBook(int id) {
        dao.deleteBook(id);
    }

    public void displayBooksWithAuthor() {
        dao.displayBooksWithAuthor();
    }
}