package com.lexxkit.skyprolexxkitquiz.repository;

import com.lexxkit.skyprolexxkitquiz.domain.Question;
import org.springframework.stereotype.Repository;

import java.util.Collection;
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

    @Override
    public Question add(Question question) {
        return null;
    }

    @Override
    public Question remove(Question question) {
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        return null;
    }
}
