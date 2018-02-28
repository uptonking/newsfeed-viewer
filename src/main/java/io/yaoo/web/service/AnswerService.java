package io.yaoo.web.service;

import io.yaoo.web.entity.Answer;
import io.yaoo.web.entity.User;

import java.util.List;

public interface AnswerService {
    Answer addAnswer(Answer answer);
    void delete(long id);
    List<Answer> getByUser(User user);
    Answer getById(Long id);
    Answer editAnswer(Answer answer);
    List<Answer> getAll();
}
