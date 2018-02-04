import java.sql.*;
import java.util.Scanner;

public class Main {

    static Connection conn;
    static ResultSet rs;
    static Statement stmt;

    public static void main(String[] args) {
        String host = "jdbc:mysql://turing.cs.missouriwestern.edu:3306/misc";
        String user = "csc254";
        String password = "age126";

        Scanner input = new Scanner(System.in);

        System.out.println("Please Enter a valid zipcode");
        String s = input.next();
        String zip = s.substring(0, 5);
        Integer.parseInt(zip);
        System.out.println("Selected Zip code: " + zip);

        String queryString = "SELECT city, state_prefix, country, population, lat, lon, housingunits " +
                "FROM zips WHERE zips.zip_code = '" + zip + "' ";

        try {
            conn = DriverManager.getConnection(host, user, password);

            if (conn == null)
                System.out.println("Connect Failed:");
            else
                System.out.println("Connect Successful");

            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryString);

            while (rs.next()) {
                String city = rs.getString("city");
                String state = rs.getString("state_prefix");
                String country = rs.getString("country");
                String population = rs.getString("population");
                int housing = rs.getInt("housingunits");
                double latitude = rs.getDouble("lat");
                double longitude = rs.getDouble("lon");
                Place place = new Place(city, state, country, population, housing, latitude, longitude);
                System.out.println(place);
            }
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}