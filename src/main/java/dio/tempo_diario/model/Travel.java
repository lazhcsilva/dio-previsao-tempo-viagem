package dio.tempo_diario.model;

import jakarta.persistence.*;

@Entity
public class Travel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cityName;
    private String dateTravel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDateTravel() {
        return dateTravel;
    }

    public void setDateTravel(String dateTravel) {
        this.dateTravel = dateTravel;
    }

}
