//package com.jestersClub.codersMania.controller;
//import com.jestersClub.codersMania.entity.Users;
//import com.jestersClub.codersMania.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import com.jestersClub.codersMania.service.PostService;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/post")
//public class PostController {
//    @Autowired
//    private PostService postService;
//    @Autowired
//    private UserService userService;
//    private Users users;
//
//
//    @GetMapping("/allPosts")
//    public String getAllPosts(){
//        return postService.getAllPosts();
//    }
//
//    @PostMapping("/createPosts")
//    public void createPost(@RequestBody Users users){
//        postService.createPost(users);
//    }
//
//
//    @GetMapping("/getAllUsers")
//    public List<Users> getAllUsers(){
//        return userService.getAllUsers();
//    }
//
//    @GetMapping("/user/{username}")
//    public Users getUser(@PathVariable String username){
//        return userService.getUser(username);
//    }
//
//    @DeleteMapping("/delete/{username}")
//    public boolean deleteUser(@PathVariable String username){
//        return userService.deleteUser(username);
//    }
//
//    @PutMapping("/updateUser/{username}")
//    public void updateUser(@RequestBody Users users){
//        userService.updateUser(users);
//    }
//
//
//}
