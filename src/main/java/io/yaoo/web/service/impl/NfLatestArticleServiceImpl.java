package io.yaoo.web.service.impl;

import io.yaoo.web.entity.NfLatestArticle;
import io.yaoo.web.repository.NfLatestArticleRepository;
import io.yaoo.web.service.NfLatestArticleService;
import io.yaoo.web.vo.SourceCount;
import io.yaoo.web.vo.TagCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NfLatestArticleServiceImpl implements NfLatestArticleService {

    @Autowired
    private NfLatestArticleRepository NfLatestArticleRepository;

//    @Override
//    public NfLatestArticle addNfLatestArticle(NfLatestArticle tag) {
//        NfLatestArticle savedTag = NfLatestArticleRepository.saveAndFlush(tag);
//
//        return savedTag;
//    }

    @Override
    public void delete(long id) {
        NfLatestArticleRepository.delete(id);
    }

    @Override
    public NfLatestArticle getById(Long id) {
        return NfLatestArticleRepository.findById(id);
    }


    @Override
    public Page<NfLatestArticle> getAllLatest(int pageNum, int pageSize) {
        Sort sort = new Sort(Direction.DESC, "gmtCreate");
        Pageable pageRequest = new PageRequest(pageNum - 1, pageSize, sort);
        return NfLatestArticleRepository.findAllLatest(pageRequest);
    }


    @Override
    public Page<NfLatestArticle> getAll(String orderBy, boolean ascTrue, int pageNum, int pageSize) {
        Sort sort = new Sort(ascTrue ? Direction.ASC : Direction.DESC, orderBy);
        Pageable pageRequest = new PageRequest(pageNum - 1, pageSize, sort);
        return NfLatestArticleRepository.findAll(pageRequest);
    }

    /**
     * 实现在自定义JpaRepositoryCustom
     *
     * @param order
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<NfLatestArticle> getAllByGMTOrder(String order, int pageNum, int pageSize) {
        return NfLatestArticleRepository.findAllByGMTOrder(order, pageNum - 1, pageSize);
    }


    @Override
    public Page<TagCount> getAllTagCount(int pageNum, int pageSize) {

        Pageable pageRequest = new PageRequest(pageNum - 1, pageSize);

        return NfLatestArticleRepository.findAllTagCount(pageRequest);
    }

    @Override
    public Page<NfLatestArticle> getAllByTag(String tag, int pageNum, int pageSize) {
        Sort sort = new Sort(Direction.DESC, "gmtCreate");
        Pageable pageRequest = new PageRequest(pageNum - 1, pageSize, sort);
        return NfLatestArticleRepository.findAllByTag(tag, pageRequest);
    }

    @Override
    public Page<SourceCount> getAllSourceCount(int pageNum, int pageSize) {

        Pageable pageRequest = new PageRequest(pageNum - 1, pageSize);

        return NfLatestArticleRepository.findAllSourceCount(pageRequest);
    }

    @Override
    public Page<NfLatestArticle> getAllBySourceName(String tag, int pageNum, int pageSize) {
        Sort sort = new Sort(Direction.DESC, "gmtCreate");

        Pageable pageRequest = new PageRequest(pageNum - 1, pageSize,sort);
        return NfLatestArticleRepository.findAllBySourceName(tag, pageRequest);
    }


}
