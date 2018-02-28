package io.yaoo.web.repository;

import io.yaoo.web.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * vote表crud
 */
public interface VoteRepository extends JpaRepository<Vote, Long> {
    @Query("select t from Vote t where t.id = :id")
    Vote findById(@Param("id") Long id);
}
