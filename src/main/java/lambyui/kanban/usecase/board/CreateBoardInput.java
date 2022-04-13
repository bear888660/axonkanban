package lambyui.kanban.usecase.board;

public class CreateBoardInput {

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    private String boardName;
    private String teamId;

}
