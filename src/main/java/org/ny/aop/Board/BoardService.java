package org.ny.aop.Board;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BoardService {

    List<Board> getBoards();

}
