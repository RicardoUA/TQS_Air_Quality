package tqs.airquality.entities;


public class Data_JSON {
    private int aqi;
    private int idx;


    public Data_JSON(){

    }

    public Data_JSON(int aqi, int idx){
        this.aqi = aqi;
        this.idx = idx;
    }

    public int getAqi() {
        return this.aqi;
    }

    public int getIdx() {
        return this.idx;
    }

    public void setAqi(int aqi) {
        this.aqi = aqi;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    @Override
    public String toString() {
        return "Data_JSON{" +
                "aqi='" + aqi + '\'' +
                ", idx=" + idx +
                '}';
    }
}
