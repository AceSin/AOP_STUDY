package org.ny.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ny.aop.Board.BoardService;
import org.ny.aop.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired
    private BoardService boardService;

    @Autowired
    private UserService userService;

    @Test
    public void findBoards() throws Exception{
        assertThat(boardService.getBoards().size()).isEqualTo(100);
    }

    @Test
    public void  findUsers() throws Exception{
        assertThat(userService.getUsers().size()).isEqualTo(100);
    }
}
