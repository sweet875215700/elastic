package com.me.repository;

import com.me.domain.Geo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by hotbody on 17/3/8.
 */
public interface GeoReposiitory extends ElasticsearchRepository<Geo,String>{
}
