package com.lexxkit.skyprolexxkitquiz.service;

import com.lexxkit.skyprolexxkitquiz.domain.Question;
import com.lexxkit.skyprolexxkitquiz.exception.BadAmountOfQuestionsException;
import com.lexxkit.skyprolexxkitquiz.exception.NotEnoughQuestionsException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.Set;

import static com.lexxkit.skyprolexxkitquiz.QuestionServiceTestConstants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    private QuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl out;

    // TODO: 13.07.2022 Think about parametrized test with -1, 0;
    @Test
    void shouldThrowBadAmountOfQuestionsExceptionWhenAmountEqualsZero() {
        assertThatExceptionOfType(BadAmountOfQuestionsException.class)
                .isThrownBy(() -> out.getQuestions(0));
    }

    @Test
    void shouldThrowNotEnoughQuestionsExceptionWhenAmountGreaterThanQuestionsSize() {
        when(questionService.getAll()).thenReturn(TEST_SET_SIZE_2);
        assertThatExceptionOfType(NotEnoughQuestionsException.class)
                .isThrownBy(() -> out.getQuestions(TEST_SET_SIZE_2.size() + 1));
    }

    @Test
    void shouldReturnCollectionOfRandomQuestionsWithSizeTwoWhenAmountIsTwo() {
        when(questionService.getAll()).thenReturn(TEST_SET_SIZE_4);
        when(questionService.getRandomQuestion())
                .thenReturn(TEST_QUESTION_1)
                .thenReturn(TEST_QUESTION_1)
                .thenReturn(TEST_QUESTION_3);

        Collection<Question> result = out.getQuestions(2);
        assertThat(result).hasSize(2);
        assertThat(result).containsExactlyInAnyOrder(TEST_QUESTION_1, TEST_QUESTION_3);
        assertThat(result).isUnmodifiable();
        assertThat(result).isInstanceOf(Set.class);
    }
}