package com.lexxkit.skyprolexxkitquiz.service;

import com.lexxkit.skyprolexxkitquiz.domain.Question;

import java.util.HashSet;
import java.util.Set;

public class QuestionServiceTestConstants {
    public static final Question TEST_QUESTION_1 = new Question("Test 1", "Test 1");
    public static final Question TEST_QUESTION_2 = new Question("Test 2", "Test 2");
    public static final Question NEW_TEST_QUESTION = new Question("New test", "New test");
    public static final Question NON_EXISTENT_QUESTION_1 = new Question("Non existent", "Non existent");
    public static final String TEST_QUESTION_STRING = "Test question string";
    public static final String TEST_ANSWER_STRING = "Test answer string";
    public static final Question TEST_QUESTION_FROM_STRINGS = new Question(TEST_QUESTION_STRING, TEST_ANSWER_STRING);
    public static final Set<Question> TEST_SET_SIZE_2 = new HashSet<>(Set.of(TEST_QUESTION_1, TEST_QUESTION_2));

}
