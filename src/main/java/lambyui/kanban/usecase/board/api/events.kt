package lambyui.kanban.usecase.board.api

data class BoardCreatedEvent(
    val id: String,
    val boardName: String,
    val teamId: String
)

data class WorkflowCreatedEvent(
    val id: String,
    val workflowName: String,
    val userId: String,
    val boardId: String,
)
