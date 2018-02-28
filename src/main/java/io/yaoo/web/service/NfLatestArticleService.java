package io.yaoo.web.service;

import io.yaoo.web.entity.NfLatestArticle;
import io.yaoo.web.vo.SourceCount;
import io.yaoo.web.vo.TagCount;
import org.springframework.data.domain.Page;

import java.util.List;

public interface NfLatestArticleService {

    void delete(long id);

    NfLatestArticle getById(Long id);

    //    NfLatestArticle editVote(NfLatestArticle article);
    Page<NfLatestArticle> getAllLatest(int pageNum, int pageSize);

    Page<NfLatestArticle> getAll(String orderBy, boolean ascTrue, int pageNum, int pageSize);

    List<NfLatestArticle> getAllByGMTOrder(String order, int pageNum, int pageSize);


    Page<TagCount> getAllTagCount(int pageNum, int pageSize);


    Page<NfLatestArticle> getAllByTag(String tag, int pageNum, int pageSize);

    Page<SourceCount> getAllSourceCount(int pageNum, int pageSize);

    Page<NfLatestArticle> getAllBySourceName(String source, int pageNum, int pageSize);


}