package lambyui.kanban.usecase.board;

import lambyui.kanban.usecase.board.api.BoardCreatedEvent;
import lambyui.kanban.usecase.board.api.CreateBoardCommand;
import lambyui.kanban.usecase.board.aggregate.Board;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreateBoardCommandTest {

    private FixtureConfiguration<Board> fixture;

    @BeforeEach
    public void setUp() {
        fixture = new AggregateTestFixture<>(Board.class);
    }

    @Test
    public void testCreateBoardCommand() {
        fixture.given()
            .when(new CreateBoardCommand("boardId", "Scrum board", "teamId"))
            .expectSuccessfulHandlerExecution()
            .expectEvents(new BoardCreatedEvent("boardId", "Scrum board", "teamId"));
    }
}
