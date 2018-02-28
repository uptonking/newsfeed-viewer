package io.yaoo.web.vo;

import com.fasterxml.jackson.annotation.JsonView;
import io.yaoo.web.jsonview.Views;

/**
 * Created by yaoooo on 9/9/17.
 */
public class TagCount {

    @JsonView(Views.Public.class)
    private String tagName;

    @JsonView(Views.Public.class)
    private long tagCount;

    public TagCount(){

    }

    public TagCount(String tagName, long tagCount) {
        this.tagName = tagName;
        this.tagCount = tagCount;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public long getTagCount() {
        return tagCount;
    }

    public void setTagCount(long tagCount) {


        this.tagCount = tagCount;
    }

    @Override
    public String toString() {
        return "TagCount{" +
                "tagName='" + tagName + '\'' +
                ", tagCount=" + tagCount +
                '}';
    }

}
