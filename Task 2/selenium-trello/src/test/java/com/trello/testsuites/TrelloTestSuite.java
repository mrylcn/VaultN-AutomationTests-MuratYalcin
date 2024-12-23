package com.trello.testsuites;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import com.trello.tests.AddCardsTest;
import com.trello.tests.BoardCreationTest;
import com.trello.tests.DeleteBoardTest;
import com.trello.tests.ListManagementTest;
import com.trello.tests.LoginTest;
import com.trello.tests.MoveCardsTest;

@Suite
@SelectClasses({
    LoginTest.class,
    BoardCreationTest.class,
    ListManagementTest.class,
    AddCardsTest.class,
    MoveCardsTest.class,
    DeleteBoardTest.class
})
public class TrelloTestSuite {
    static {
        System.out.println("Test suite is being executed...");
    }
}
