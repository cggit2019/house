package com.team.house.util;

public class SelHouse{
    private String title;
    private Integer streetId;
    private Integer typeId;
    private Double lowPrice;
    private Double topPrice;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getStreetId() {
        return streetId;
    }

    public void setStreetId(Integer streetId) {
        this.streetId = streetId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Double getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(Double lowPrice) {
        this.lowPrice = lowPrice;
    }

    public Double getTopPrice() {
        return topPrice;
    }

    public void setTopPrice(Double topPrice) {
        this.topPrice = topPrice;
    }

    @Override
    public String toString() {
        return "SelHouse{" +
                "title='" + title + '\'' +
                ", streetId=" + streetId +
                ", typeId=" + typeId +
                ", lowPrice=" + lowPrice +
                ", topPrice=" + topPrice +
                '}';
    }
}
