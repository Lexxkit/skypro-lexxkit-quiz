package com.lexxkit.skyprolexxkitquiz.repository;

import com.lexxkit.skyprolexxkitquiz.domain.Question;
import com.lexxkit.skyprolexxkitquiz.exception.QuestionAlreadyAddedException;
import com.lexxkit.skyprolexxkitquiz.exception.QuestionNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Repository
public class MathQuestionRepository implements QuestionRepository {
    private final Set<Question> questions;

    public MathQuestionRepository() {
        questions = new HashSet<>();
    }

    public MathQuestionRepository(Set<Question> questions) {
        this.questions = questions;
    }

    @PostConstruct
    private void init() {
        questions.add(new Question("Math Test 1", "Math Answer Test 1"));
        questions.add(new Question("Math Test 2", "Math Answer Test 2"));
        questions.add(new Question("Math Test 3", "Math Answer Test 3"));
        questions.add(new Question("Math Test 4", "Math Answer Test 4"));
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
}
