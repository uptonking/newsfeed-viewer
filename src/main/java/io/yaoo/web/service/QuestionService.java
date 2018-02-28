package io.yaoo.web.service;

import io.yaoo.web.entity.Question;
import io.yaoo.web.entity.Tag;
import io.yaoo.web.entity.User;

import java.util.List;

public interface QuestionService {
    Question addQuestion(Question question);
    void delete(long id);
    List<Question> getByUser(User user);
    List<Question> getByTag(Tag tag);
    Question getById(Long id);
    Question editQuestion(Question question);
    List<Question> getAll();
}