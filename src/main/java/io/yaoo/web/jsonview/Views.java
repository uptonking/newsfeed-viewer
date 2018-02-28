package io.yaoo.web.jsonview;

/**
 * 可以利用@JsonView指定对象需要序列化的属性
 * Views类可以理解为一组标识
 * 它的每个成员就是一个标识
 */
public class Views {

    /**
     * 基本序列化字段
     */
    public interface Public {
    }

    /**
     * 文章摘要及详细字段
     */
    public interface Summary extends Public {
    }
}
