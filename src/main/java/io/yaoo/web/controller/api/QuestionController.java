package io.yaoo.web.controller.api;

import com.fasterxml.jackson.annotation.JsonView;
import io.yaoo.web.entity.Tag;
import io.yaoo.web.entity.User;
import io.yaoo.web.model.AjaxResponseBody;
import io.yaoo.web.model.QuestionModel;
import io.yaoo.web.service.TagService;
import io.yaoo.web.service.UserService;
import io.yaoo.web.util.AuthService;
import io.yaoo.web.util.CustomErrorType;
import io.yaoo.web.entity.Question;
import io.yaoo.web.jsonview.Views;
import io.yaoo.web.service.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.*;

/**
 * 问题控制器
 */
@RestController
@RequestMapping("/api")
public class QuestionController {
    public static final Logger logger = LoggerFactory.getLogger(QuestionController.class);

    @Value("${jwt.secret}")
    private String key;

    @Autowired
    QuestionService questionService; //Service which will do all data retrieval/manipulation work

    @Autowired
    UserService userService;

    @Autowired
    TagService tagService;

    @JsonView(Views.Public.class)
    @RequestMapping(value = "/questions", method = RequestMethod.GET)
    public ResponseEntity<List<Question>> listAllQuestions() {
        List<Question> questions = questionService.getAll();
        if (questions.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Question>>(questions, HttpStatus.OK);
    }

    @JsonView(Views.Public.class)
    @RequestMapping(value = "/question/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getQuestion(@PathVariable("id") long id) {
        logger.info("Fetching Question with id {}", id);
        Question question = questionService.getById(id);
        if (question == null) {
            logger.error("Question with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Question with id " + id
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Question>(question, HttpStatus.OK);
    }

    @JsonView(Views.Public.class)
    @RequestMapping(value = "/questions/user/{name}", method = RequestMethod.GET)
    public ResponseEntity<?> getQuestionsByUser(@PathVariable("name") String name) {

        User user = userService.getByUsername(name);

        if (user == null) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        List<Question> questions = questionService.getByUser(user);
        if (questions.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Question>>(questions, HttpStatus.OK);
    }

    @JsonView(Views.Public.class)
    @RequestMapping(value = "/questions/tag/{name}", method = RequestMethod.GET)
    public ResponseEntity<?> getQuestionsByTag(@PathVariable("name") String name) {

        Tag tag = tagService.getByName(name);

        if (tag == null) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        List<Question> questions = questionService.getByTag(tag);
        if (questions.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Question>>(questions, HttpStatus.OK);
    }

    @JsonView(Views.Public.class)
    @RequestMapping(value = "/question", method = RequestMethod.POST)
    public AjaxResponseBody createQuestion(@RequestBody QuestionModel data, UriComponentsBuilder ucBuilder) {
        logger.info("Creating Question : {}", data);
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

        String[] tagNames = data.getTags().split(",");
        Set<Tag> tags = new HashSet<>();

        for (String name : tagNames) {
            Tag tag = tagService.getByName(name);

            if (tag != null) {
                tag.setPopular(tag.getPopular() + 1);
                tag = tagService.editTag(tag);
            } else {
                tag = new Tag(name, null, user);
                tag = tagService.addTag(tag);
            }
            tags.add(tag);
        }

        Question question = new Question(data.getTitle(), data.getComment(), user, tags);
        question = questionService.addQuestion(question);

        //

        result.setCode("201");
        result.setMsg(Long.toString(question.getId()));

        return result;
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(ucBuilder.path("/api/question/{id}").buildAndExpand(question.getId()).toUri());
//        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }



}