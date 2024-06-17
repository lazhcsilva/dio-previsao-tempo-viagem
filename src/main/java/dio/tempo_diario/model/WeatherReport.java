package dio.tempo_diario.model;

import jakarta.persistence.*;

@Entity
public class WeatherReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private WeatherLocation weatherLocation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "weatherData_id", referencedColumnName = "id")
    private WeatherData weatherData;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public WeatherLocation getLocation() {
        return weatherLocation;
    }

    public void setLocation(WeatherLocation weatherLocation) {
        this.weatherLocation = weatherLocation;
    }

    public WeatherData getWeatherData() {
        return weatherData;
    }

    public void setWeatherData(WeatherData weatherData) {
        this.weatherData = weatherData;
    }
}
