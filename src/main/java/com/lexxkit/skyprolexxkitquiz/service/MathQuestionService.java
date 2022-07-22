package com.lexxkit.skyprolexxkitquiz.service;

import com.lexxkit.skyprolexxkitquiz.domain.Question;
import com.lexxkit.skyprolexxkitquiz.exception.JavaQuestionsIsEmptyException;
import com.lexxkit.skyprolexxkitquiz.exception.MathQuestionsIsEmptyException;
import com.lexxkit.skyprolexxkitquiz.exception.QuestionAlreadyAddedException;
import com.lexxkit.skyprolexxkitquiz.exception.QuestionNotFoundException;
import com.lexxkit.skyprolexxkitquiz.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
@Qualifier("mathQuestionService")
public class MathQuestionService implements QuestionService {
    private final QuestionRepository questionRepository;

    public MathQuestionService(@Qualifier("mathQuestionRepository") QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        return add(newQuestion);
    }

    @Override
    public Question add(Question question) {
        return questionRepository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return questionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return questionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        int repositorySize = questionRepository.getAll().size();
        if (repositorySize == 0) {
            throw new MathQuestionsIsEmptyException();
        }
        int index = new Random().nextInt(repositorySize);
        return getQuestionByIndex(index);
    }

    private Question getQuestionByIndex(int index) {
        if (index < 0 || index >= questionRepository.getAll().size()) {
            throw new IndexOutOfBoundsException();
        }
        return new ArrayList<>(questionRepository.getAll()).get(index);
    }
}
