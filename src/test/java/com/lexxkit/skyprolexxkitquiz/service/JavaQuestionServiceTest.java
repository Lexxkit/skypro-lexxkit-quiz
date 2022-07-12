package com.lexxkit.skyprolexxkitquiz.service;

import com.lexxkit.skyprolexxkitquiz.domain.Question;
import com.lexxkit.skyprolexxkitquiz.exception.QuestionNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static com.lexxkit.skyprolexxkitquiz.service.QuestionServiceTestConstants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class JavaQuestionServiceTest {

    private QuestionService out;

    @BeforeEach
    void setUp() {
        out = new JavaQuestionService(TEST_SET_SIZE_2);
    }

    @Test
    void shouldRemoveQuestionFromSetAndReturnIt() {
        int initialSize = out.getAll().size();
        Question result = out.remove(TEST_QUESTION_2);

        assertThat(result).isEqualTo(TEST_QUESTION_2);
        assertThat(out.getAll()).hasSize(initialSize - 1);
        assertThat(out.getAll()).containsOnly(TEST_QUESTION_1);
    }

    @Test
    void shouldThrowQuestionNotFoundExceptionWhenRemoveNonExistentQuestion() {
        assertThatThrownBy(() -> out.remove(NON_EXISTENT_QUESTION_1)).isInstanceOf(QuestionNotFoundException.class);
    }

    @Test
    void shouldReturnUnmodifiableSetWithAllQuestions() {
        Collection<Question> result = out.getAll();

        assertThat(result).isUnmodifiable();
        assertThat(result).hasSize(TEST_SET_SIZE_2.size());
        assertThat(result).containsAll(TEST_SET_SIZE_2);
    }

}