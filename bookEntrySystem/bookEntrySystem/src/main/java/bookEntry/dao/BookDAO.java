package bookEntry.dao;



import java.sql.*;

import bookEntrySystem.entity.Book;
import bookEntrySystem.util.DBConnection;



public class BookDAO {

    public void addBook(Book b) {

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO book(title, author_id, publisher, year) VALUES (?, ?, ?, ?)"
            );

            ps.setString(1, b.getTitle());
            ps.setInt(2, b.getAuthorId());
            ps.setString(3, b.getPublisher());
            ps.setInt(4, b.getYear());

            ps.executeUpdate();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Book getBook(int id) {

        Book b = null;

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM book WHERE id=?"
            );

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                b = new Book(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getInt("author_id"),
                    rs.getString("publisher"),
                    rs.getInt("year")
                );
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return b;
    }

    public void deleteBook(int id) {

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM book WHERE id=?"
            );

            ps.setInt(1, id);
            ps.executeUpdate();

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔥 JOIN
    public void displayBooksWithAuthor() {

        try {
            Connection con = DBConnection.getConnection();

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(
                "SELECT b.id, b.title, a.name, b.publisher, b.year " +
                "FROM book b JOIN author a ON b.author_id = a.id"
            );

            while (rs.next()) {
                System.out.println(
                    rs.getInt(1) + " | " +
                    rs.getString(2) + " | " +
                    rs.getString(3) + " | " +
                    rs.getString(4) + " | " +
                    rs.getInt(5)
                );
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}