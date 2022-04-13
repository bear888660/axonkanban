package lambyui.kanban.usecase.board.aggregate;


import lambyui.kanban.usecase.board.api.BoardCreatedEvent;
import lambyui.kanban.usecase.board.api.CreateBoardCommand;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import static org.axonframework.modelling.command.AggregateLifecycle.apply;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class Board {

    @AggregateIdentifier
    private String id;
    private String teamId;
    private String boardName;


    public Board(){}


    @CommandHandler
    public Board(CreateBoardCommand command){
        apply(new BoardCreatedEvent(command.getId(), command.getBoardName(), command.getTeamId()));
    }


    @EventSourcingHandler
    public void on(BoardCreatedEvent evt) {
        id = evt.getId();
        boardName = evt.getBoardName();
        teamId = evt.getTeamId();
    }
}
