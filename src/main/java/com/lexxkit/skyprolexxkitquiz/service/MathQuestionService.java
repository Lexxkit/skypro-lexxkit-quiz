package com.lexxkit.skyprolexxkitquiz.service;

import com.lexxkit.skyprolexxkitquiz.constant.MathSigns;
import com.lexxkit.skyprolexxkitquiz.domain.Question;
import com.lexxkit.skyprolexxkitquiz.exception.CustomMethodNotAllowedException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Random;

@Service
@Qualifier("mathQuestionService")
public class MathQuestionService implements QuestionService {
    private final int LIMIT = 10;
    @Override
    public Question add(String question, String answer) {
        throw new CustomMethodNotAllowedException();
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
        Random rand = new Random();
        char mathSign = MathSigns.MATH_SIGNS[rand.nextInt(MathSigns.MATH_SIGNS.length)];
        int numA = rand.nextInt(LIMIT) + 1;
        int numB = rand.nextInt(LIMIT) + 1;
        int result = 0;
        switch (mathSign) {
            case '+':
                result = numA + numB;
                break;
            case '-':
                result = numA - numB;
                break;
            case '*':
                result = numA * numB;
                break;
            case '/':
                result = numA / numB;
            default:
                break;
        }

        String question = String.format("%d %c %d", numA, mathSign, numB);
        String answer = String.valueOf(result);
        return new Question(question, answer);
    }
}
