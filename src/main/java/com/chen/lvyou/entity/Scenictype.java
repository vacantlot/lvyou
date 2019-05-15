package com.chen.lvyou.entity;

public class Scenictype {
    private Integer scenicTypeId;

    private String typeName;

    public Integer getScenicTypeId() {
        return scenicTypeId;
    }

    public void setScenicTypeId(Integer scenicTypeId) {
        this.scenicTypeId = scenicTypeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }
}