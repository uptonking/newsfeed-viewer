package io.yaoo.web.repository.custom;

import io.yaoo.web.entity.NfLatestArticle;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by yaoooo on 9/9/17.
 */
public class NfLatestArticleRepositoryImpl implements NfLatestArticleRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<NfLatestArticle> findAllByGMTOrder(String order, int pageNum, int pageSize) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<NfLatestArticle> criteriaQuery = criteriaBuilder.createQuery(NfLatestArticle.class);
        //配置from字句
        Root<NfLatestArticle> root = criteriaQuery.from(NfLatestArticle.class);

        CriteriaQuery<NfLatestArticle> select = criteriaQuery.select(root);
        criteriaQuery.orderBy(criteriaBuilder.desc(root.get("gmtCreate")));

        TypedQuery<NfLatestArticle> typedQuery = entityManager.createQuery(select);
        //从0开始
        typedQuery.setFirstResult((pageNum - 1) * pageSize);
        typedQuery.setMaxResults(pageSize);

        return (List<NfLatestArticle>) typedQuery.getResultList();
    }


}
