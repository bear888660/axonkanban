package lambyui.kanban.usecase.board;

import lambyui.kanban.usecase.board.api.CreateBoardCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;

import java.util.UUID;

public class CreateBoardUseCase {

    private final CommandGateway commandGateway;

    public CreateBoardUseCase(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    public void execute(CreateBoardInput input, CreateBoardOutput output) {

        String uuid = UUID.randomUUID().toString();
        CreateBoardCommand command = new CreateBoardCommand(
            uuid,
            input.getBoardName(),
            input.getTeamId()
        );

        commandGateway.sendAndWait(command);


        output.setId(uuid);
    }
}
