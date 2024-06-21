package dio.tempo_diario.dto;

public class CurrentDTO {

    private double temp_c;
    private int is_day;
    private ConditionDTO conditionDTO;
    private String wind_dir;
    private int humidity;
    private int cloud;
    private double feelslike_c;
    private int uv;

    public double getTemp_c() {
        return temp_c;
    }

    public void setTemp_c(double temp_c) {
        this.temp_c = temp_c;
    }

    public int getIs_day() {
        return is_day;
    }

    public void setIs_day(int is_day) {
        this.is_day = is_day;
    }

    public ConditionDTO getConditionDTO() {
        return conditionDTO;
    }

    public void setConditionDTO(ConditionDTO conditionDTO) {
        this.conditionDTO = conditionDTO;
    }

    public String getWind_dir() {
        return wind_dir;
    }

    public void setWind_dir(String wind_dir) {
        this.wind_dir = wind_dir;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getCloud() {
        return cloud;
    }

    public void setCloud(int cloud) {
        this.cloud = cloud;
    }

    public double getFeelslike_c() {
        return feelslike_c;
    }

    public void setFeelslike_c(double feelslike_c) {
        this.feelslike_c = feelslike_c;
    }

    public int getUv() {
        return uv;
    }

    public void setUv(int uv) {
        this.uv = uv;
    }
}
