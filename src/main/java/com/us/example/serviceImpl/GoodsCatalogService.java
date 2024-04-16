package com.us.example.serviceImpl;

import com.us.example.bean.GoodsCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
@Repository
public class GoodsCatalogService {

    @Autowired
    EntityManager entityManager;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void saveCatalog(GoodsCatalog catalog) {
        entityManager.persist(catalog);
    }

    public List<GoodsCatalog> getAllCatalog(){
        TypedQuery<GoodsCatalog> query = entityManager.createQuery("SELECT t FROM GoodsCatalog t", GoodsCatalog.class);
        return query.getResultList();
    }

    public void deleteCatalog(){
        jdbcTemplate.execute("delete from mall_goods_catalog where 1=1");
    }

}
