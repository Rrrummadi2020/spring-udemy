package com.example.firstproject.DTO;

import java.io.Serializable;
import java.util.Objects;

public class WeatherDTO implements Serializable {
    private String cod;
    private String message;
    private String cnt;

    public WeatherDTO(){    }

    public WeatherDTO(String cod, String message, String cnt) {
        this.cod = cod;
        this.message = message;
        this.cnt = cnt;
    }

    public String getCod() {
        return cod;
    }

    public String getMessage() {
        return message;
    }

    public String getCnt() {
        return cnt;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCnt(String cnt) {
        this.cnt = cnt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherDTO weather = (WeatherDTO) o;
        return Objects.equals(cod, weather.cod) && Objects.equals(message, weather.message) && Objects.equals(cnt, weather.cnt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cod, message, cnt);
    }

}
