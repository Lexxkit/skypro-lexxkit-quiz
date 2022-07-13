package com.lexxkit.skyprolexxkitquiz.service;

import com.lexxkit.skyprolexxkitquiz.exception.BadAmountOfQuestionsException;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

import static com.lexxkit.skyprolexxkitquiz.service.QuestionServiceTestConstants.TEST_SET_SIZE_2;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    // TODO: 12.07.2022 Add mock for QuestionService and Inject it to ExaminerServiceImpl
    @Mock
    private QuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl out;

    // TODO: 13.07.2022 Probably this lines of code could be deleted or each test case should contain this line.
//    @Before
//    void setUp() {
//        when(questionService.getRandomQuestion())
//                .thenReturn(Lists.newArrayList(TEST_SET_SIZE_2).get(new Random().nextInt(TEST_SET_SIZE_2.size())));
//    }

    // TODO: 13.07.2022 Think about parametrized test with -1, 0;
    @Test
    void shouldThrowBadAmountOfQuestionsExceptionWhenAmountEqualsZero() {
        Assertions.assertThatExceptionOfType(BadAmountOfQuestionsException.class)
                .isThrownBy(() -> out.getQuestions(0));
    }
}