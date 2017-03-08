package com.me;

import com.me.builder.GeoBuilder;
import com.me.domain.Geo;
import com.me.main.ElasticApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hotbody on 17/3/8.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ElasticApplication.class)
public class GeoTests {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Test
    public void dataAdd(){
        elasticsearchTemplate.createIndex(Geo.class);
        elasticsearchTemplate.refresh(Geo.class);
        elasticsearchTemplate.putMapping(Geo.class);

        List<IndexQuery> indexQueries = new ArrayList<IndexQuery>();
        indexQueries.add(new GeoBuilder("1").name("北京").location(45.7806d, 3.0875d).buildIndex());
        indexQueries.add(new GeoBuilder("2").name("上海").location(51.5171d, 0.1062d).buildIndex());
        indexQueries.add(new GeoBuilder("3").name("天津").location(51.5171d, 0.1062d).buildIndex());
        elasticsearchTemplate.bulkIndex(indexQueries);
        System.out.println("success done");
    }

    @Test
    public void geoSearch(){
        CriteriaQuery geoLocationCriteriaQuery = new CriteriaQuery(
                new Criteria("loaction").within(new GeoPoint(45.7806d, 3.0875d), "20km")
        );
        List<Geo> geos = elasticsearchTemplate.queryForList(geoLocationCriteriaQuery,Geo.class);
        for (Geo geo : geos) {
            System.out.println(geo.toString());
        }
    }
}
