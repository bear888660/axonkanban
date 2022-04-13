package lambyui.kanban.usecase.board.aggregate;

import lambyui.kanban.usecase.board.api.CreateWorkflowCommand;
import lambyui.kanban.usecase.board.api.WorkflowCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

public class Workflow {
    @AggregateIdentifier
    private String id;
    private String workflowName;
    private String userId;
    private String boardId;


    public Workflow(){}


    @CommandHandler
    public Workflow(CreateWorkflowCommand command){
        apply(new WorkflowCreatedEvent(command.getId(), command.getWorkflowName(), command.getUserId(), command.getBoardId()));
    }


    @EventSourcingHandler
    public void on(WorkflowCreatedEvent evt) {
        id = evt.getId();
        workflowName = evt.getWorkflowName();
        userId = evt.getUserId();
        boardId = evt.getBoardId();
    }
}
