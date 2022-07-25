package com.lexxkit.skyprolexxkitquiz.service;

import com.lexxkit.skyprolexxkitquiz.exception.CustomMethodNotAllowedException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.lexxkit.skyprolexxkitquiz.QuestionServiceTestConstants.TEST_QUESTION_1;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(MockitoExtension.class)
class MathQuestionServiceTest {

    private MathQuestionService out = new MathQuestionService();

    @Test
    void shouldThrowCustomMethodNotAllowedExceptionWhenAddQuestionWithFields() {
        assertThatThrownBy(() -> out.add(TEST_QUESTION_1.getQuestion(), TEST_QUESTION_1.getAnswer())).isInstanceOf(CustomMethodNotAllowedException.class);
    }

    @Test
    void shouldThrowCustomMethodNotAllowedExceptionWhenAddQuestion() {
        assertThatThrownBy(() -> out.add(TEST_QUESTION_1)).isInstanceOf(CustomMethodNotAllowedException.class);
    }

    @Test
    void shouldThrowCustomMethodNotAllowedExceptionWhenRemoveQuestion() {
        assertThatExceptionOfType(CustomMethodNotAllowedException.class).isThrownBy(() -> out.remove(TEST_QUESTION_1));
    }

    @Test
    void shouldThrowCustomMethodNotAllowedExceptionWhenGetAllQuestions() {
        assertThatExceptionOfType(CustomMethodNotAllowedException.class).isThrownBy(() -> out.getAll());
    }
}