package dio.tempo_diario.model;

import jakarta.persistence.*;

@Entity
public class WeatherLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String region;
    private String country;
    private double lat;
    private double lon;
    private String tzId;
    @Column(name = "localtime_epoch")
    private int localtimeEpoch;
    @Column(name = "local_time")
    private String localtime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getTzId() {
        return tzId;
    }

    public void setTzId(String tzId) {
        this.tzId = tzId;
    }

    public int getLocaltimeEpoch() {
        return localtimeEpoch;
    }

    public void setLocaltimeEpoch(int localtimeEpoch) {
        this.localtimeEpoch = localtimeEpoch;
    }

    public String getLocaltime() {
        return localtime;
    }

    public void setLocaltime(String localtime) {
        this.localtime = localtime;
    }
}
