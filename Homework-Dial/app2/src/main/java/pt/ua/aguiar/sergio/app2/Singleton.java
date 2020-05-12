package pt.ua.aguiar.sergio.app2;

public class Singleton {

    private static Singleton instance = null;

    private String cityName;

    private Singleton() {
        cityName = "";
    }

    public static Singleton getInstance() {
        if(instance == null) instance = new Singleton();
        return instance;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }
}
