package io.yaoo.web.vo;

import com.fasterxml.jackson.annotation.JsonView;
import io.yaoo.web.jsonview.Views;

/**
 * Created by yaoooo on 9/9/17.
 */
public class SourceCount {

    @JsonView(Views.Public.class)
    private String sourceName;

    @JsonView(Views.Public.class)
    private long sourceCount;

    public SourceCount(){

    }

    public SourceCount(String sourceName, long sourceCount) {
        this.sourceName = sourceName;
        this.sourceCount = sourceCount;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public long getSourceCount() {
        return sourceCount;
    }

    public void setSourceCount(long sourceCount) {
        this.sourceCount = sourceCount;
    }

    @Override
    public String toString() {
        return "SourceCount{" +
                "sourceName='" + sourceName + '\'' +
                ", sourceCount=" + sourceCount +
                '}';
    }
}
