package com.lexxkit.skyprolexxkitquiz.service;

import com.lexxkit.skyprolexxkitquiz.domain.Question;
import com.lexxkit.skyprolexxkitquiz.exception.BadAmountOfQuestionsException;
import com.lexxkit.skyprolexxkitquiz.exception.NotEnoughQuestionsException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService javaQuestionService;

    public ExaminerServiceImpl(QuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount <= 0) {
            throw new BadAmountOfQuestionsException();
        }

        int questionsSize = javaQuestionService.getAll().size();
        if (amount > questionsSize) {
            throw new NotEnoughQuestionsException();
        }

        Set<Question> randomQuestions = new HashSet<>();

        while (randomQuestions.size() < amount) {
            randomQuestions.add(javaQuestionService.getRandomQuestion());
        }
        return Collections.unmodifiableSet(randomQuestions);
    }
}
