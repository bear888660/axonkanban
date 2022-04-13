package lambyui.kanban.usecase.board.query;

import lambyui.kanban.usecase.board.api.BoardCreatedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Service
public class BoardViewService {

    private final BoardViewRepository boardViewRepository;

    public BoardViewService(BoardViewRepository repo)
    {
        this.boardViewRepository = repo;
    }



    @EventHandler
    public void on(BoardCreatedEvent e) {

        System.out.print("i am i commandcommandcommandcommandcommandcommandcommandcommandcommandcommand");


    }
}
