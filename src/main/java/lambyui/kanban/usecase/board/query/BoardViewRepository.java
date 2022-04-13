package lambyui.kanban.usecase.board.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BoardViewRepository {


    List<BoardView> store;

    public BoardViewRepository() {
        store = new ArrayList<>();
    }


    public void save(BoardView boardView) {
        store.add(boardView);

    }

    public Optional<BoardView> getById(String id) {
        return store.stream().filter(x -> x.getId().equals(id)).findAny();
    }
}
