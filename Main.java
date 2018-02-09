import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    static Connection conn;
    static ResultSet rs;
    static Statement stmt;

    static Connection conn2;
    static ResultSet rs2;
    static Statement stmt2;

    public static void main(String[] args) {
        String host = "jdbc:mysql://turing.cs.missouriwestern.edu:3306/misc";
        String user = "csc254";
        String password = "age126";

        Scanner input = new Scanner(System.in);

        System.out.println("Please Enter a valid zipcode");
        int zip = input.nextInt();
        System.out.println("Selected Zip code: " + zip);

        System.out.println("Please enter a distance from zipcode");
        double distance = input.nextDouble();
        System.out.println("Selected Distance:" + distance);

        String queryString = "SELECT city, state_prefix, country, population, housingunits, lat, lon FROM zips WHERE zip_code = '" + zip + "' ";
        String queryString2 = "SELECT DISTINCT city, state, zipcode, country, estimatedpopulation, locationtype, lat, zips2.long FROM zips2 WHERE locationtype = 'PRIMARY'";

        try {
            conn = DriverManager.getConnection(host, user, password);

            if (conn == null)
                System.out.println("Connect Failed:");
            else
                System.out.println("Connect Successful");

            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryString);

            stmt2 = conn.createStatement();
            rs2 = stmt2.executeQuery(queryString2);

            double haversine = 0;
            Place place2 = null;


            while (rs.next()) {
                String city = rs.getString("city");
                String state = rs.getString("state_prefix");
                String country = rs.getString("country");
                int population = rs.getInt("population");
                int housing = rs.getInt("housingunits");
                double lat1 = rs.getDouble("lat");
                double lon1 = rs.getDouble("lon");


                while (rs2.next()) {
                    String city2 = rs2.getString("city");
                    String state2 = rs2.getString("state");
                    String zipcode = rs2.getString("zipcode");
                    String country2 = rs2.getString("country");
                    int estpopulat = rs2.getInt("estimatedpopulation");
                    double lat2 = rs2.getDouble("lat");
                    double lon2 = rs2.getDouble("long");


                    haversine = haversine(lat1, lon1, lat2, lon2);
                    place2 = new Place(city2, zipcode, state2, country2, estpopulat, housing, lat2, lon2, haversine);

                    if(distance >= haversine)
                    System.out.println("Points withing distance" + place2);


                }
            }


            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static double haversine(double lat1, double lon1, double lat2, double lon2) {
        final double r = 6372.8;
        double dlat = Math.toRadians(lat2 - lat1);
        double dlon = Math.toRadians(lon2 - lon1);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        double a = Math.pow(Math.sin(dlat / 2), 2) + Math.pow(Math.sin(dlon / 2), 2) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.asin(Math.sqrt(a));
        return r * c;
    }


    public static double miles(double toMiles) {
        return toMiles * 0.621371;
    }

    public static double kilometers(double toKilo) {
        return toKilo * 1.60934;
    }
}