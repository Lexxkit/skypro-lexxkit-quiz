package com.lexxkit.skyprolexxkitquiz.service;

import com.lexxkit.skyprolexxkitquiz.domain.Question;
import com.lexxkit.skyprolexxkitquiz.exception.MathQuestionsIsEmptyException;
import com.lexxkit.skyprolexxkitquiz.exception.QuestionAlreadyAddedException;
import com.lexxkit.skyprolexxkitquiz.exception.QuestionNotFoundException;
import com.lexxkit.skyprolexxkitquiz.repository.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import static com.lexxkit.skyprolexxkitquiz.QuestionServiceTestConstants.*;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MathQuestionServiceTest {

    @Mock
    private QuestionRepository repository;

    @InjectMocks
    private MathQuestionService out;

    @Test
    void shouldAddQuestionWithFieldsNotInSetAndReturnIt() {
        when(repository.add(TEST_QUESTION_FROM_STRINGS)).thenReturn(TEST_QUESTION_FROM_STRINGS);

        Question result = out.add(TEST_QUESTION_STRING, TEST_ANSWER_STRING);
        assertThat(result).isEqualTo(TEST_QUESTION_FROM_STRINGS);
    }

    @Test
    void shouldThrowQuestionAlreadyAddedExceptionWhenAddSameQuestionWithFields() {
        when(repository.add(TEST_QUESTION_1)).thenThrow(QuestionAlreadyAddedException.class);
        assertThatThrownBy(() -> out.add(TEST_QUESTION_1.getQuestion(), TEST_QUESTION_1.getAnswer())).isInstanceOf(QuestionAlreadyAddedException.class);
    }


    @Test
    void shouldAddQuestionNotInSetAndReturnIt() {
        when(repository.add(NEW_TEST_QUESTION)).thenReturn(NEW_TEST_QUESTION);

        Question result = out.add(NEW_TEST_QUESTION);
        assertThat(result).isEqualTo(NEW_TEST_QUESTION);
    }

    @Test
    void shouldThrowQuestionAlreadyAddedExceptionWhenAddSameQuestion() {
        when(repository.add(TEST_QUESTION_1)).thenThrow(QuestionAlreadyAddedException.class);
        assertThatThrownBy(() -> out.add(TEST_QUESTION_1)).isInstanceOf(QuestionAlreadyAddedException.class);
    }

    @Test
    void shouldRemoveQuestionFromSetAndReturnIt() {
        when(repository.remove(TEST_QUESTION_2)).thenReturn(TEST_QUESTION_2);

        Question result = out.remove(TEST_QUESTION_2);
        assertThat(result).isEqualTo(TEST_QUESTION_2);
    }

    @Test
    void shouldThrowQuestionNotFoundExceptionWhenRemoveNonExistentQuestion() {
        when(repository.remove(NON_EXISTENT_QUESTION_1)).thenThrow(QuestionNotFoundException.class);
        assertThatExceptionOfType(QuestionNotFoundException.class).isThrownBy(() -> out.remove(NON_EXISTENT_QUESTION_1));
    }

    @Test
    void shouldReturnSetWithAllQuestions() {
        when(repository.getAll()).thenReturn(TEST_SET_SIZE_2);

        Collection<Question> result = out.getAll();

        assertThat(result).hasSize(TEST_SET_SIZE_2.size());
        assertThat(result).containsAll(TEST_SET_SIZE_2);
        assertThat(result).isInstanceOf(Set.class);
    }

    @Test
    void shouldReturnRandomQuestionFromSet() {
        when(repository.getAll()).thenReturn(TEST_SET_SIZE_2);

        Question result = out.getRandomQuestion();

        assertThat(result).isInstanceOf(Question.class);
        assertThat(result).isIn(TEST_SET_SIZE_2);
    }

    @Test
    void shouldThrowMathQuestionsIsEmptyExceptionWhenSetIsEmpty() {
        when(repository.getAll()).thenReturn(Collections.emptySet());
        assertThatThrownBy(() -> out.getRandomQuestion()).isInstanceOf(MathQuestionsIsEmptyException.class);
    }
}