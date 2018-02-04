import java.util.Objects;

public class Place {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Place)) return false;
        Place place = (Place) o;
        return Objects.equals(city, place.city) &&
                Objects.equals(state_prefix, place.state_prefix);
    }


    String city;
    String state_prefix;
    String country;
    String population;
    int housingUnits;
    double latitude;
    double longitude;
    double distanceFromOrigin;

    public Place(String city, String state_prefix, String country, String population,
                 int housingUnits, double latitude, double longitude) {
        this.city = city;
        this.state_prefix = state_prefix;
        this.country = country;
        this.population = population;
        this.housingUnits = housingUnits;
        this.latitude = latitude;
        this.longitude = longitude;
        this.distanceFromOrigin = distanceFromOrigin;


    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState_prefix() {
        return state_prefix;
    }

    public void setState_prefix(String state_prefix) {
        this.state_prefix = state_prefix;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public int getHousingUnits() {
        return housingUnits;
    }

    public void setHousingUnits(int housingUnits) {
        this.housingUnits = housingUnits;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getDistanceFromOrigin() {
        return distanceFromOrigin;
    }

    public void setDistanceFromOrigin(double distanceFromOrigin) {
        this.distanceFromOrigin = distanceFromOrigin;
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, state_prefix);
    }

    @Override
    public String toString() {
        return "Place{" +
                "city='" + city + '\'' +
                ", state_prefix='" + state_prefix + '\'' +
                ", country='" + country + '\'' +
                ", population=" + population +
                ", housingUnits=" + housingUnits +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", distanceFromOrigin=" + distanceFromOrigin +
                '}';
    }
}
