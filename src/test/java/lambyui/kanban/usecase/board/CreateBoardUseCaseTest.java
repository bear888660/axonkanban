package lambyui.kanban.usecase.board;

import org.axonframework.commandhandling.SimpleCommandBus;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.commandhandling.gateway.DefaultCommandGateway;
import org.axonframework.commandhandling.gateway.IntervalRetryScheduler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CreateBoardUseCaseTest {


    private SimpleCommandBus commandBus;
    private CommandGateway commandGateway;


    @BeforeEach
    void setUp() {
        this.commandBus = SimpleCommandBus.builder().build();
    }



    @Test
    public void createBoard(){

        commandGateway = DefaultCommandGateway.builder()
            .commandBus(commandBus)
            .build();


        CreateBoardUseCase createBoardUseCase = new CreateBoardUseCase(commandGateway);

        CreateBoardInput input = new CreateBoardInput();

        input.setBoardName("Scurm Board");
        input.setTeamId("teamId");

        CreateBoardOutput output = new CreateBoardOutput();


        createBoardUseCase.execute(input, output);
        assertNotNull(output.getId());
    }
}
