package org.ny.aop;

import org.ny.aop.Board.Board;
import org.ny.aop.Board.BoardRepository;
import org.ny.aop.Board.BoardService;
import org.ny.aop.User.User;
import org.ny.aop.User.UserRepository;
import org.ny.aop.User.UserService;
import org.ny.aop.aspact.Performance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
@EnableAspectJAutoProxy
public class Application implements CommandLineRunner {

    @Autowired
    private BoardService boardService;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Bean
    public Performance performance(){
        return new Performance();
    }

    @Override
    public void run(String... args) throws Exception {

        for(int i = 1; i <= 100; i++){
            boardRepository.save(new Board(i+"번째 게시글의 제목", i+"번째 게시글의 내용"));
            userRepository.save(new User(i+"@email.com", i+"번째 사용자"));
        }
    }
//
//    @GetMapping("/boards")
//    public List<Board> getBoards(){
//        return boardService.getDataAll();
//    }
//
//    @GetMapping("/Users")
//    public List<User> getUsers(){
//        return userService.getDataAll();
//    }

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }

}
