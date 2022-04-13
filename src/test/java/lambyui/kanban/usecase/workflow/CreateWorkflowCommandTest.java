package lambyui.kanban.usecase.workflow;

import lambyui.kanban.usecase.board.api.CreateWorkflowCommand;
import lambyui.kanban.usecase.board.api.WorkflowCreatedEvent;
import lambyui.kanban.usecase.board.aggregate.Workflow;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreateWorkflowCommandTest {

    private FixtureConfiguration<Workflow> fixture;

    @BeforeEach
    public void setUp() {
        fixture = new AggregateTestFixture<>(Workflow.class);
    }

    @Test
    public void testCreateBoardCommand() {
        fixture.given()
            .when(new CreateWorkflowCommand("workflowId", "workflowName", "userId", "teamId"))
            .expectSuccessfulHandlerExecution()
            .expectEvents(new WorkflowCreatedEvent("workflowId", "workflowName", "userId", "teamId"));
    }
}
