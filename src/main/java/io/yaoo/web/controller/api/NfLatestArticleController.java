package io.yaoo.web.controller.api;

import com.fasterxml.jackson.annotation.JsonView;
import io.yaoo.web.entity.NfLatestArticle;
import io.yaoo.web.jsonview.Views;
import io.yaoo.web.service.NfLatestArticleService;
import io.yaoo.web.util.CustomErrorType;
import io.yaoo.web.vo.SourceCount;
import io.yaoo.web.vo.TagCount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 文章列表控制器
 */
@RestController
@RequestMapping("/api")
public class NfLatestArticleController {

    public static final Logger logger = LoggerFactory.getLogger(NfLatestArticleController.class);

    @Autowired
    NfLatestArticleService latestArticleService;


    /**
     * 获取最新文章
     * 包含摘要信息
     *
     * @param pageNum  第N页，从1开始
     * @param pageSize 每页数量
     * @return
     */
    @JsonView(Views.Summary.class)
    @RequestMapping(value = "/article/all/latest/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public ResponseEntity<List<NfLatestArticle>> listAllArticleLatest(@PathVariable int pageNum, @PathVariable int pageSize) {
        List<NfLatestArticle> articles = latestArticleService.getAllLatest(pageNum, pageSize).getContent();
        if (articles.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<NfLatestArticle>>(articles, HttpStatus.OK);
    }

    @JsonView(Views.Public.class)
    @RequestMapping(value = "/article/all/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public ResponseEntity<List<NfLatestArticle>> listAllArticle(@PathVariable int pageNum, @PathVariable int pageSize) {
        List<NfLatestArticle> list = latestArticleService.getAll("gmtCreate", false, pageNum, pageSize).getContent();
        if (list.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<NfLatestArticle>>(list, HttpStatus.OK);
    }


    @Deprecated
    @JsonView(Views.Summary.class)
    @RequestMapping(value = "/article/all/{order}/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public ResponseEntity<List<NfLatestArticle>> listAllArticleByDateOrder(@PathVariable String order, @PathVariable int pageNum, @PathVariable int pageSize) {

        String orderRequired = order.trim().toLowerCase();

        //默认降序排列
        if (!(orderRequired.equals("desc") || orderRequired.equals("asc"))) {
            orderRequired = "desc";
        }

        List<NfLatestArticle> list = latestArticleService.getAllByGMTOrder(orderRequired, pageNum, pageSize);
        if (list.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<NfLatestArticle>>(list, HttpStatus.OK);
    }

    @JsonView(Views.Public.class)
    @RequestMapping(value = "/article/id/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getArticleById(@PathVariable("id") long id) {
        logger.info("Fetching LatestArticle with id {}", id);
        NfLatestArticle article = latestArticleService.getById(id);
        if (article == null) {
            logger.error("LatestArticle with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("LatestArticle with id " + id
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<NfLatestArticle>(article, HttpStatus.OK);
    }

    @RequestMapping(value = "/article/tag/all/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public ResponseEntity<List<TagCount>> listAllTagCount(@PathVariable int pageNum, @PathVariable int pageSize) {
        List<TagCount> list = latestArticleService.getAllTagCount(pageNum, pageSize).getContent();

        List<TagCount> list2 = new ArrayList<>();
        for (TagCount item:list){
            if (item!=null&&item.getTagName()!=null &&item.getTagName().trim()!=""){
                list2.add(item);
            }

        }

        return new ResponseEntity<List<TagCount>>(list2, HttpStatus.OK);
    }

    @JsonView(Views.Public.class)
    @RequestMapping(value = "/article/tag/{tag}/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public ResponseEntity<List<NfLatestArticle>> listAllArticleByTag(@PathVariable String tag, @PathVariable int pageNum, @PathVariable int pageSize) {
        List<NfLatestArticle> article = latestArticleService.getAllByTag(tag, pageNum, pageSize).getContent();
        if (article.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<NfLatestArticle>>(article, HttpStatus.OK);
    }

    @RequestMapping(value = "/article/source/all/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public ResponseEntity<List<SourceCount>> listAllSourceCount(@PathVariable int pageNum, @PathVariable int pageSize) {
        List<SourceCount> list = latestArticleService.getAllSourceCount(pageNum, pageSize).getContent();
        return new ResponseEntity<List<SourceCount>>(list, HttpStatus.OK);
    }

    @JsonView(Views.Public.class)
    @RequestMapping(value = "/article/source/{source}/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public ResponseEntity<List<NfLatestArticle>> listAllArticleBySourceName(@PathVariable String source, @PathVariable int pageNum, @PathVariable int pageSize) {
        List<NfLatestArticle> article = latestArticleService.getAllBySourceName(source, pageNum, pageSize).getContent();
        if (article.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<NfLatestArticle>>(article, HttpStatus.OK);
    }

    @RequestMapping(value = "/hello")
    public ResponseEntity<List<TagCount>> helloString() {

        TagCount tagCount1 = new TagCount("java", 49);
        TagCount tagCount2 = new TagCount("java2", 9);

        List<TagCount> list = new ArrayList<>();
        list.add(tagCount1);
        list.add(tagCount2);

//        System.out.println("==============================");
//        System.out.println("");
//        System.out.println(list.getClass().getName());
//        System.out.println(list.get(0).getClass().getName());
//        System.out.println("==============================");
//        System.out.println("");

        return new ResponseEntity<List<TagCount>>(list, HttpStatus.OK);
    }


}