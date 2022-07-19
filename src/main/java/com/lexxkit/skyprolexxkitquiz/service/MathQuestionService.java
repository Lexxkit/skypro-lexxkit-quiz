package com.lexxkit.skyprolexxkitquiz.service;

import com.lexxkit.skyprolexxkitquiz.domain.Question;
import com.lexxkit.skyprolexxkitquiz.exception.JavaQuestionsIsEmptyException;
import com.lexxkit.skyprolexxkitquiz.exception.MathQuestionsIsEmptyException;
import com.lexxkit.skyprolexxkitquiz.exception.QuestionAlreadyAddedException;
import com.lexxkit.skyprolexxkitquiz.exception.QuestionNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MathQuestionService implements QuestionService {
    private final Set<Question> questions;

    public MathQuestionService() {
        this.questions = new HashSet<>();
    }

    public MathQuestionService(Set<Question> questions) {
        this.questions = questions;
    }

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        return add(newQuestion);
    }

    @Override
    public Question add(Question question) {
        boolean isAdded = questions.add(question);
        if (!isAdded) {
            throw new QuestionAlreadyAddedException();
        }
        return question;
    }

    @Override
    public Question remove(Question question) {
        boolean isRemoved = questions.remove(question);
        if (!isRemoved) {
            throw new QuestionNotFoundException();
        }
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.size() == 0) {
            throw new MathQuestionsIsEmptyException();
        }
        int index = new Random().nextInt(questions.size());
        return getQuestionByIndex(index);
    }

    private Question getQuestionByIndex(int index) {
        if (index < 0 || index >= questions.size()) {
            throw new IndexOutOfBoundsException();
        }
        return new ArrayList<>(questions).get(index);
    }
}
