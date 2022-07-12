package com.lexxkit.skyprolexxkitquiz.service;

import com.lexxkit.skyprolexxkitquiz.domain.Question;
import com.lexxkit.skyprolexxkitquiz.exception.AmountOfQuestionsLessThanNeededException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;
    private final Set<Question> randomQuestions;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.randomQuestions = new HashSet<>();
        this.questionService = questionService;
    }

    // TODO: 12.07.2022 Delete Set field; find while with stream
    @Override
    public Collection<Question> getQuestions(int amount) {
        int questionsSize = questionService.getAll().size();
        if (questionsSize < amount) {
            throw new AmountOfQuestionsLessThanNeededException();
        }
        while (randomQuestions.size() <= amount) {
            randomQuestions.add(questionService.getRandomQuestion());
        }
        return Collections.unmodifiableSet(randomQuestions);
    }
}
