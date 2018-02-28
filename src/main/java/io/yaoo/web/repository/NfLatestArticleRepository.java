package io.yaoo.web.repository;

import io.yaoo.web.entity.NfLatestArticle;
import io.yaoo.web.repository.custom.NfLatestArticleRepositoryCustom;
import io.yaoo.web.vo.SourceCount;
import io.yaoo.web.vo.TagCount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by yaoooo on 9/8/17.
 */
public interface NfLatestArticleRepository extends JpaRepository<NfLatestArticle, Long>, NfLatestArticleRepositoryCustom {

    @Query(value = "select * from nf_latest_article t where id = :id",
            nativeQuery = true)
    NfLatestArticle findById(@Param("id") Long id);

    @Query(value = "select t from NfLatestArticle t",
            countQuery = "select count(t) from NfLatestArticle t ")
    Page<NfLatestArticle> findAllLatest(Pageable pageable);


    @Query(
            value = "select t from NfLatestArticle t",
            countQuery = "select count(t) from NfLatestArticle t "
    )
    Page<NfLatestArticle> findAll(Pageable pageable);


    @Query(
            value = "select new io.yaoo.web.vo.TagCount(t.tag ,count(t.tag)) from NfLatestArticle t group by t.tag order by count(t.tag) desc",
            countQuery = "select count(distinct t.tag) from NfLatestArticle t "
    )
    Page<TagCount> findAllTagCount(Pageable pageable);


    @Query(
            value = "select t from nf_latest_article t where t.tag= :tag ",
            countQuery = "select count(t) from nf_latest_article t where t.tag= :tag",
            nativeQuery = true
    )
    Page<NfLatestArticle> findAllByTag(String tag, Pageable pageable);


    @Query(
            value = "select new io.yaoo.web.vo.SourceCount(t.sourceName ,count(t.sourceName)) from NfLatestArticle t group by t.sourceName order by count(t.sourceName) desc",
            countQuery = "select count(distinct t.sourceName) from NfLatestArticle t "
    )
    Page<SourceCount> findAllSourceCount(Pageable pageable);


    @Query(
            value = "select t from nf_latest_article t where t.sourceName= :source ",
            countQuery = "select count(t) from nf_latest_article t where t.sourceName= :source",
            nativeQuery = true
    )
    Page<NfLatestArticle> findAllBySourceName(String source, Pageable pageable);

}
