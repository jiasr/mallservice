package com.us.example.service;

import com.us.example.bean.GoodsCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;


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

    public List<GoodsCatalog> getAllCatalog(Map<String, Object> params){
        // 计算起始位置

        int currentpage =  params.get("currentPage")== null ? 1: Integer.parseInt((String) params.get("currentPage"));
        int paageSize = params.get("pageSize")== null ? 10: Integer.parseInt((String) params.get("pageSize"));
        int firstResult = (currentpage - 1) * paageSize;
        TypedQuery<GoodsCatalog> query = entityManager.createQuery("SELECT t FROM GoodsCatalog t", GoodsCatalog.class);
        // 设置分页参数
        query.setFirstResult(firstResult);
        query.setMaxResults(paageSize);

        return query.getResultList();

    }

    public void deleteCatalog(){
        jdbcTemplate.execute("delete from mall_goods_catalog where 1=1");
    }

}
