package com.lexxkit.skyprolexxkitquiz.repository;

import com.lexxkit.skyprolexxkitquiz.domain.Question;

import java.util.Collection;

public interface QuestionRepository {
    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

// TODO: 19.07.2022 Maybe unnecessary code
//    Question getQuestionByIndex(int index);
//    int getSize();
}
