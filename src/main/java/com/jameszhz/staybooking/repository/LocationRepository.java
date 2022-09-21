package com.jameszhz.staybooking.repository;

import com.jameszhz.staybooking.model.Location;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository //IOC spring will implement this interface (manage the bean)
public interface LocationRepository extends ElasticsearchRepository<Location, Long>, CustomLocationRepository { //只能 接口 多继承

}
