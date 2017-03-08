package com.me.builder;

import com.me.domain.Geo;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.data.elasticsearch.core.query.IndexQuery;

/**
 * Created by hotbody on 17/3/8.
 */
public class GeoBuilder {

    private Geo geo;

    public GeoBuilder(String id){
        geo = new Geo();
        geo.setId(id);
    }

    public GeoBuilder name(String name){
        geo.setName(name);
        return this;
    }

    public GeoBuilder location(Double lat,Double lon){
        GeoPoint geoPoint = new GeoPoint(lat,lon);
        geo.setLoaction(geoPoint);
        return this;
    }

    public Geo build(){
        return geo;
    }

    public IndexQuery buildIndex() {
        IndexQuery indexQuery = new IndexQuery();
        indexQuery.setId(geo.getId());
        indexQuery.setObject(geo);
        return indexQuery;
    }
}
