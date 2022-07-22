package com.lexxkit.skyprolexxkitquiz.service;

import com.lexxkit.skyprolexxkitquiz.domain.Question;
import com.lexxkit.skyprolexxkitquiz.exception.*;
import com.lexxkit.skyprolexxkitquiz.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.server.MethodNotAllowedException;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
@Qualifier("mathQuestionService")
public class MathQuestionService implements QuestionService {
    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        return add(newQuestion);
    }

    @Override
    public Question add(Question question) {
        throw new CustomMethodNotAllowedException();
    }

    @Override
    public Question remove(Question question) {
        throw new CustomMethodNotAllowedException();
    }

    @Override
    public Collection<Question> getAll() {
        throw new CustomMethodNotAllowedException();
    }

    @Override
    public Question getRandomQuestion() {
//        int repositorySize = questionRepository.getAll().size();
//        if (repositorySize == 0) {
//            throw new MathQuestionsIsEmptyException();
//        }
//        int index = new Random().nextInt(repositorySize);
//        return getQuestionByIndex(index);
        return null;
    }
//
//    private Question getQuestionByIndex(int index) {
//        if (index < 0 || index >= questionRepository.getAll().size()) {
//            throw new IndexOutOfBoundsException();
//        }
//        return new ArrayList<>(questionRepository.getAll()).get(index);
//    }
}
