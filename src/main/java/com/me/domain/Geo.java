package com.me.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.GeoPointField;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

/**
 * Created by hotbody on 17/3/8.
 */
@Document(indexName = "learn" , type = "geo")
public class Geo {

    @Id
    private String id;

    private String name;

    @GeoPointField
    private GeoPoint loaction;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GeoPoint getLoaction() {
        return loaction;
    }

    public void setLoaction(GeoPoint loaction) {
        this.loaction = loaction;
    }

    @Override
    public String toString() {
        return "Geo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", loaction=" + loaction +
                '}';
    }
}



