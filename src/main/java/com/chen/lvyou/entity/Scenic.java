package com.chen.lvyou.entity;

public class Scenic {
    private Integer scenicId;

    private String cityId;

    private Integer scenicTypeId;

    private String scenicLevel;

    private String scenicName;

    private String scenicPhoto;

    private String scenicDesc;

    private String price;

    private String openTime;

    private String address;

    public Integer getScenicId() {
        return scenicId;
    }

    public void setScenicId(Integer scenicId) {
        this.scenicId = scenicId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId == null ? null : cityId.trim();
    }

    public Integer getScenicTypeId() {
        return scenicTypeId;
    }

    public void setScenicTypeId(Integer scenicTypeId) {
        this.scenicTypeId = scenicTypeId;
    }

    public String getScenicLevel() {
        return scenicLevel;
    }

    public void setScenicLevel(String scenicLevel) {
        this.scenicLevel = scenicLevel == null ? null : scenicLevel.trim();
    }

    public String getScenicName() {
        return scenicName;
    }

    public void setScenicName(String scenicName) {
        this.scenicName = scenicName == null ? null : scenicName.trim();
    }

    public String getScenicPhoto() {
        return scenicPhoto;
    }

    public void setScenicPhoto(String scenicPhoto) {
        this.scenicPhoto = scenicPhoto == null ? null : scenicPhoto.trim();
    }

    public String getScenicDesc() {
        return scenicDesc;
    }

    public void setScenicDesc(String scenicDesc) {
        this.scenicDesc = scenicDesc == null ? null : scenicDesc.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime == null ? null : openTime.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
}