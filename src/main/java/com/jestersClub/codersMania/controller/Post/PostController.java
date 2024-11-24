package com.jestersClub.codersMania.controller.Post;

import com.jestersClub.codersMania.entity.Questions;
import com.jestersClub.codersMania.service.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;
    @PostMapping("/create")
    private void createPost(@RequestBody Questions questions) throws Exception {

        postService.createQuestion(questions);
    }

}
