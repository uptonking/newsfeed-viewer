package io.yaoo.web.entity;
// Generated Sep 8, 2017 1:13:23 AM by Hibernate Tools 3.2.2.GA

import com.fasterxml.jackson.annotation.JsonView;
import io.yaoo.web.jsonview.Views;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;


/**
 * NfLatestArticle generated by hbm2java
 */
@Entity
@Table(name = "nf_latest_article")
public class NfLatestArticle {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", length = 6, nullable = false)
    @JsonView(Views.Public.class)
    private Long id;

    @Column(name = "article_id")
//    @JsonView(Views.Public.class)
    private String articleId;

    @Column(name = "article_title")
    @JsonView(Views.Public.class)
    private String articleTitle;

    @Column(name = "article_url")
    @JsonView(Views.Public.class)
    private String articleUrl;

    @Column(name = "article_summary")
    @JsonView(Views.Summary.class)
    private String articleSummary;

    @Column(name = "article_author")
    @JsonView(Views.Public.class)
    private String articleAuthor;

    @Column(name = "article_author_url")
    @JsonView(Views.Public.class)
    private String articleAuthorUrl;

    @Column(name = "article_gmt_create")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonView(Views.Public.class)
    private Date articleGmtCreate;

    @Column(name = "tag")
    @JsonView(Views.Public.class)
    private String tag;

    @Column(name = "source_name")
    @JsonView(Views.Public.class)
    private String sourceName;

    @Column(name = "article_comment_num")
    @JsonView(Views.Summary.class)
    private Integer articleCommentNum;

    @Column(name = "article_view_num")
    @JsonView(Views.Summary.class)
    private Integer articleViewNum;

    @Column(name = "article_like_num")
    @JsonView(Views.Summary.class)
    private Integer articleLikeNum;

    @Column(name = "rating_score_cur")
    @JsonView(Views.Summary.class)
    private String ratingScoreCur;

    @Column(name = "article_author_avatar_url")
//    @JsonView(Views.Public.class)
    private String articleAuthorAvatarUrl;

    @Column(name = "article_thumb_url")
//    @JsonView(Views.Public.class)
    private String articleThumbUrl;

    @Column(name = "source_type")
    @JsonView(Views.Public.class)
    private String sourceType;

    @Column(name = "gmt_create")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonView(Views.Public.class)
    private Date gmtCreate;

    @Column(name = "field_placeholder")
//    @JsonView(Views.Public.class)
    private String fieldPlaceholder;

    public NfLatestArticle() {
    }


    public NfLatestArticle(String articleTitle, String articleUrl) {
        this.articleTitle = articleTitle;
        this.articleUrl = articleUrl;
    }

    public NfLatestArticle(String articleId, String articleTitle, String articleUrl, String articleSummary, String articleAuthor, String articleAuthorUrl, Date articleGmtCreate, String tag, String sourceName, Integer articleCommentNum, Integer articleViewNum, Integer articleLikeNum, String ratingScoreCur, String articleAuthorAvatarUrl, String articleThumbUrl, String sourceType, Date gmtCreate, String fieldPlaceholder) {
        this.articleId = articleId;
        this.articleTitle = articleTitle;
        this.articleUrl = articleUrl;
        this.articleSummary = articleSummary;
        this.articleAuthor = articleAuthor;
        this.articleAuthorUrl = articleAuthorUrl;
        this.articleGmtCreate = articleGmtCreate;
        this.tag = tag;
        this.sourceName = sourceName;
        this.articleCommentNum = articleCommentNum;
        this.articleViewNum = articleViewNum;
        this.articleLikeNum = articleLikeNum;
        this.ratingScoreCur = ratingScoreCur;
        this.articleAuthorAvatarUrl = articleAuthorAvatarUrl;
        this.articleThumbUrl = articleThumbUrl;
        this.sourceType = sourceType;
        this.gmtCreate = gmtCreate;
        this.fieldPlaceholder = fieldPlaceholder;
    }

    //     @Id @GeneratedValue(strategy=IDENTITY)
//    @Column(name="id", unique=true, nullable=false)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //    @Column(name="article_id", length=128)
    public String getArticleId() {
        return this.articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    //    @Column(name="article_title", nullable=false, length=65535)
    public String getArticleTitle() {
        return this.articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    //    @Column(name="article_url", nullable=false, length=512)
    public String getArticleUrl() {
        return this.articleUrl;
    }

    public void setArticleUrl(String articleUrl) {
        this.articleUrl = articleUrl;
    }

    //    @Column(name="article_summary", length=16777215)
    public String getArticleSummary() {
        return this.articleSummary;
    }

    public void setArticleSummary(String articleSummary) {
        this.articleSummary = articleSummary;
    }

    //    @Column(name="article_author", length=128)
    public String getArticleAuthor() {
        return this.articleAuthor;
    }

    public void setArticleAuthor(String articleAuthor) {
        this.articleAuthor = articleAuthor;
    }

    //    @Column(name="article_author_url", length=512)
    public String getArticleAuthorUrl() {
        return this.articleAuthorUrl;
    }

    public void setArticleAuthorUrl(String articleAuthorUrl) {
        this.articleAuthorUrl = articleAuthorUrl;
    }

    //    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name="article_gmt_create", length=19)
    public Date getArticleGmtCreate() {
        return this.articleGmtCreate;
    }

    public void setArticleGmtCreate(Date articleGmtCreate) {
        this.articleGmtCreate = articleGmtCreate;
    }

    //    @Column(name="tag", length=128)
    public String getTag() {
        return this.tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    //    @Column(name="source_name", length=48)
    public String getSourceName() {
        return this.sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    //    @Column(name="article_comment_num")
    public Integer getArticleCommentNum() {
        return this.articleCommentNum;
    }

    public void setArticleCommentNum(Integer articleCommentNum) {
        this.articleCommentNum = articleCommentNum;
    }

    //    @Column(name="article_view_num")
    public Integer getArticleViewNum() {
        return this.articleViewNum;
    }

    public void setArticleViewNum(Integer articleViewNum) {
        this.articleViewNum = articleViewNum;
    }

    //    @Column(name="article_like_num")
    public Integer getArticleLikeNum() {
        return this.articleLikeNum;
    }

    public void setArticleLikeNum(Integer articleLikeNum) {
        this.articleLikeNum = articleLikeNum;
    }

    //    @Column(name="rating_score_cur", length=24)
    public String getRatingScoreCur() {
        return this.ratingScoreCur;
    }

    public void setRatingScoreCur(String ratingScoreCur) {
        this.ratingScoreCur = ratingScoreCur;
    }

    //    @Column(name="article_author_avatar_url", length=512)
    public String getArticleAuthorAvatarUrl() {
        return this.articleAuthorAvatarUrl;
    }

    public void setArticleAuthorAvatarUrl(String articleAuthorAvatarUrl) {
        this.articleAuthorAvatarUrl = articleAuthorAvatarUrl;
    }

    //    @Column(name="article_thumb_url", length=512)
    public String getArticleThumbUrl() {
        return this.articleThumbUrl;
    }

    public void setArticleThumbUrl(String articleThumbUrl) {
        this.articleThumbUrl = articleThumbUrl;
    }

    //    @Column(name="source_type", length=24)
    public String getSourceType() {
        return this.sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    //    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name="gmt_create", length=19)
    public Date getGmtCreate() {
        return this.gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    //    @Column(name="field_placeholder", length=48)
    public String getFieldPlaceholder() {
        return this.fieldPlaceholder;
    }

    public void setFieldPlaceholder(String fieldPlaceholder) {
        this.fieldPlaceholder = fieldPlaceholder;
    }


}


