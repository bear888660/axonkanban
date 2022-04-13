package lambyui.kanban.usecase.board.api

import org.axonframework.modelling.command.TargetAggregateIdentifier

class CreateBoardCommand(
    @TargetAggregateIdentifier
    val id: String,
    val boardName: String,
    val teamId: String,
)

class CreateWorkflowCommand(
    @TargetAggregateIdentifier
    val id: String,
    val workflowName: String,
    val userId: String,
    val boardId: String,
)

