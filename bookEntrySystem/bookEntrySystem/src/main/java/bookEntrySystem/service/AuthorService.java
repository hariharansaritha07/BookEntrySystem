package bookEntrySystem.service;

import bookEntry.dao.AuthorDAO;
import bookEntrySystem.entity.Author;

public class AuthorService {

    AuthorDAO dao = new AuthorDAO();

    public void addAuthor(Author a) {
        dao.addAuthor(a);
    }

    public Author getAuthor(int id) {
        return dao.getAuthor(id);
    }

    public void displayAuthors() {
        dao.displayAuthors();
    }
}