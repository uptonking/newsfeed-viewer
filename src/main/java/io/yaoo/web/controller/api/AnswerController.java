package io.yaoo.web.controller.api;

import com.fasterxml.jackson.annotation.JsonView;
import io.yaoo.web.entity.Answer;
import io.yaoo.web.entity.Question;
import io.yaoo.web.entity.User;
import io.yaoo.web.jsonview.Views;
import io.yaoo.web.model.AjaxResponseBody;
import io.yaoo.web.model.AnswerModel;
import io.yaoo.web.service.AnswerService;
import io.yaoo.web.service.QuestionService;
import io.yaoo.web.service.UserService;
import io.yaoo.web.util.AuthService;
import io.yaoo.web.util.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Objects;

/**
 * 回答控制器
 */
@RestController
@RequestMapping("/api")
public class AnswerController {
    public static final Logger logger = LoggerFactory.getLogger(QuestionController.class);

    @Value("${jwt.secret}")
    private String key;

    @Autowired
    QuestionService questionService;

    @Autowired
    AnswerService answerService;

    @Autowired
    UserService userService;

    @JsonView(Views.Public.class)
    @RequestMapping(value = "/answers", method = RequestMethod.GET)
    public ResponseEntity<List<Answer>> listAllAnswers() {
        List<Answer> answers = answerService.getAll();
        if (answers.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Answer>>(answers, HttpStatus.OK);
    }

    @JsonView(Views.Public.class)
    @RequestMapping(value = "/answer/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getAnswer(@PathVariable("id") long id) {
        logger.info("Fetching Answer with id {}", id);
        Answer answer = answerService.getById(id);
        if (answer == null) {
            logger.error("Answer with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Answer with id " + id
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Answer>(answer, HttpStatus.OK);
    }

    @JsonView(Views.Public.class)
    @RequestMapping(value = "/answer/user/{name}", method = RequestMethod.GET)
    public ResponseEntity<?> getAnswersByUser(@PathVariable("name") String name) {

        User user = userService.getByUsername(name);

        if (user == null) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        List<Answer> answers = answerService.getByUser(user);
        if (answers.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Answer>>(answers, HttpStatus.OK);
    }

    /**
     * 添加回答
     * @param data
     * @param ucBuilder
     * @return
     */
    @JsonView(Views.Public.class)
    @RequestMapping(value = "/answer", method = RequestMethod.POST)
    public AjaxResponseBody createQuestion(@RequestBody AnswerModel data, UriComponentsBuilder ucBuilder) {
        logger.info("Creating Answer : {}", data);
        AjaxResponseBody result = new AjaxResponseBody();

        AuthService authService = new AuthService(data.getToken(), key);
        if (authService.getUserName() == null) {
            result.setCode("404");
            result.setMsg(authService.getMessage());
            return result;
        }
        //OK, we can trust this JWT
        String userName = authService.getUserName();

        User user = userService.getByUsername(userName);

        Question question = questionService.getById(data.getQuestion_id());

        // prevent error of two instance of one object
        if (Objects.equals(question.getUser().getUsername(), user.getUsername())) {
            user = question.getUser();
        }

        Answer answer = new Answer(data.getMessage(), user, question);
        answer = answerService.addAnswer(answer);

        result.setCode("201");
        result.setMsg(Long.toString(answer.getId()));

        return result;
    }



}
