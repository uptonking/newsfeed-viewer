package io.yaoo.web.repository;

import io.yaoo.web.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * question表crud
 */
public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Query(value = "SELECT * FROM question t WHERE t.user_id = :id ",
            nativeQuery=true
    )
    List<Question> findByUser(@Param("id") Long id);

    @Query("select t from Question t where t.id = :id")
    Question findById(@Param("id") Long id);


    @Query(value = "SELECT q.* FROM question q, question_tag qt, tag t WHERE qt.question_id = q.id AND qt.tag_id = t.id AND t.id = :id",
            nativeQuery=true
    )
    List<Question> findByTag(@Param("id") Long id);

}
