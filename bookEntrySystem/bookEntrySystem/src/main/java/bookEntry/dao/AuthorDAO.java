package bookEntry.dao;

import java.sql.*;

import bookEntrySystem.entity.Author;
import bookEntrySystem.util.DBConnection;



public class AuthorDAO {

    public void addAuthor(Author a) {

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO author(name, country) VALUES (?, ?)"
            );

            ps.setString(1, a.getName());
            ps.setString(2, a.getCountry());

            ps.executeUpdate();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Author getAuthor(int id) {

        Author a = null;

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM author WHERE id=?"
            );

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                a = new Author(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("country")
                );
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return a;
    }

    public void displayAuthors() {

        try {
            Connection con = DBConnection.getConnection();

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM author");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getString("country")
                );
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}