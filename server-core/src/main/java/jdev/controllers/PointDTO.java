package jdev.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PointDTO {
    private double lat;
    private double lon;
    private String autoId;
    private long time;
    private double azimuth;
    private int instaSpeed;

    public PointDTO(double lat,double lon,String autoId,long time,double azimuth,int instaSpeed){
        this.lat = lat;
        this.lon=lon;
        this.autoId = autoId;
        this.time = time;
        this.azimuth = azimuth;
        this.instaSpeed= instaSpeed;

    }



    public int getInstaSpeed() {
        return instaSpeed;
    }

    public void setInstaSpeed(int instaSpeed) {
        this.instaSpeed = instaSpeed;
    }

    public double getAzimuth() {
        return azimuth;
    }

    public void setAzimuth(double azimuth) {
        this.azimuth = azimuth;
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

    public String getAutoId() {
        return autoId;
    }

    public void setAutoId(String autoId) {
        this.autoId = autoId;
    }

    public String toJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }

    @Override
    public String toString() {
        return "PointDTO{" +
                "lat=" + lat +
                ", lon=" + lon +
                ",azim="+azimuth+
                ",instaSpeed"+instaSpeed+
                ", autoId='" + autoId + '\'' +
                '}';
    }

    public void setTime(long time) {
        this.time=time;
    }
    public long getTime(){
        return time;
    }


}