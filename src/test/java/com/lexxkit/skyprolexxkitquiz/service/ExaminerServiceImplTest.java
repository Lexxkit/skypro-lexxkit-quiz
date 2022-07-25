package com.lexxkit.skyprolexxkitquiz.service;

import com.lexxkit.skyprolexxkitquiz.domain.Question;
import com.lexxkit.skyprolexxkitquiz.exception.BadAmountOfQuestionsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static com.lexxkit.skyprolexxkitquiz.QuestionServiceTestConstants.TEST_QUESTION_1;
import static com.lexxkit.skyprolexxkitquiz.QuestionServiceTestConstants.TEST_QUESTION_3;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    private JavaQuestionService javaQuestionService;

    @Mock
    private MathQuestionService mathQuestionService;

    @InjectMocks
    private ExaminerServiceImpl out;

    @BeforeEach
    void init() {
        out = new ExaminerServiceImpl(List.of(javaQuestionService, mathQuestionService));
    }

    @Test
    void shouldThrowBadAmountOfQuestionsExceptionWhenAmountEqualsZero() {
        assertThatExceptionOfType(BadAmountOfQuestionsException.class)
                .isThrownBy(() -> out.getQuestions(0));
    }

    @Test
    void shouldReturnCollectionOfRandomQuestionsWithSizeTwoWhenAmountIsTwo() {
        when(javaQuestionService.getRandomQuestion()).thenReturn(TEST_QUESTION_1);
        when(mathQuestionService.getRandomQuestion()).thenReturn(TEST_QUESTION_3);

        Collection<Question> result = out.getQuestions(2);
        assertThat(result).hasSize(2);
        assertThat(result).containsExactlyInAnyOrder(TEST_QUESTION_1, TEST_QUESTION_3);
        assertThat(result).isUnmodifiable();
        assertThat(result).isInstanceOf(Set.class);
    }
}