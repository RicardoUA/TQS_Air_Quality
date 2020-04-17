package tqs.airquality.entities;

public class Aqi {
    private String status;
    private Data_JSON data;

    public Aqi(){

    }

    public Aqi(String status, Data_JSON data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return this.status;
    }

    public Data_JSON getData() {
        return this.data;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setData(Data_JSON data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Aqi{" +
                "status='" + status + '\'' +
                ", data=" + data +
                '}';
    }
}