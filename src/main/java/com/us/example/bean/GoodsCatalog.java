package com.us.example.bean;


import site.common.persist.ManagedIdentityDomainObject;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "mall_goods_catalog")
public class GoodsCatalog  extends ManagedIdentityDomainObject<GoodsCatalog> {

    private int level =0;//规格级别 0 1 2 3 4
    private long parantId = 0 ;
    private String name;
    private String thumbnail = "";


    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public long getParantId() {
        return parantId;
    }

    public void setParantId(long parantId) {
        this.parantId = parantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }




}
