package dio.tempo_diario.dto;

public class WeatherResponseDTO {

    private LocationDTO location;
    private CurrentDTO current;

    public LocationDTO getLocation() {
        return location;
    }

    public void setLocation(LocationDTO location) {
        this.location = location;
    }

    public CurrentDTO getCurrent() {
        return current;
    }

    public void setCurrent(CurrentDTO current) {
        this.current = current;
    }
}
