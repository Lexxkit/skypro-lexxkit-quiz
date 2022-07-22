package com.lexxkit.skyprolexxkitquiz.service;

import com.lexxkit.skyprolexxkitquiz.domain.Question;
import com.lexxkit.skyprolexxkitquiz.exception.BadAmountOfQuestionsException;
import com.lexxkit.skyprolexxkitquiz.exception.NotEnoughQuestionsException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final List<QuestionService> questionServiceList;

    public ExaminerServiceImpl(List<QuestionService> questionServiceList) {
        this.questionServiceList = questionServiceList;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount <= 0) {
            throw new BadAmountOfQuestionsException();
        }

        int numOfAllQuestions = questionServiceList.stream().mapToInt(e -> e.getAll().size()).sum();

        if (amount > numOfAllQuestions) {
            throw new NotEnoughQuestionsException();
        }

        Set<Question> randomQuestions = new HashSet<>();

        while (randomQuestions.size() < amount) {
            QuestionService randQuestionService = questionServiceList.get(new Random().nextInt(questionServiceList.size()));
            randomQuestions.add(randQuestionService.getRandomQuestion());
        }
        return Collections.unmodifiableSet(randomQuestions);
    }
}
