package io.yaoo.web.repository.custom;

import io.yaoo.web.entity.NfLatestArticle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by yaoooo on 9/9/17.
 */
public interface NfLatestArticleRepositoryCustom {

//    @Query(
//            value = "select t from  nf_latest_article t order by t.gmt_create :order",
//            countQuery = "select count(t) from nf_latest_article t",
//            nativeQuery = true
//    )
    List<NfLatestArticle> findAllByGMTOrder(String order,int pageNum,int pageSize);
}
