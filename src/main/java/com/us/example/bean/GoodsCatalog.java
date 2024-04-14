package com.us.example.bean;


import com.us.example.persist.ManagedIdentityDomainObject;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

@Entity
@Table(name = "mall_goods_catalog")
public class GoodsCatalog  extends ManagedIdentityDomainObject<GoodsCatalog> {

    private int level =0;//规格级别 0 1 2 3 4
    private String parantId ="";
    private String name ="";
    private String thumbnail = "";



    private List<GoodsCatalog> children;


    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getParantId() {
        return parantId;
    }

    public void setParantId(String parantId) {
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

    @Transient //不生成字段
    public List<GoodsCatalog> getChildren() {
        return children;
    }

    public void setChildren(List<GoodsCatalog> children) {
        this.children = children;
    }



}
