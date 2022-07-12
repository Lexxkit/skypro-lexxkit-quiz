package com.lexxkit.skyprolexxkitquiz.controller;

import com.lexxkit.skyprolexxkitquiz.domain.Question;
import com.lexxkit.skyprolexxkitquiz.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(path = "/java")
public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public Collection<Question> getQuestions() {
        return questionService.getAll();
    }

    @GetMapping(path = "/add")
    public Question addQuestion(@RequestParam String question,
                                @RequestParam String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping(path = "/remove")
    public Question removeQuestion(@RequestParam String question,
                                   @RequestParam String answer) {
        Question requestedQuestion = new Question(question, answer);
        return questionService.remove(requestedQuestion);
    }
}
