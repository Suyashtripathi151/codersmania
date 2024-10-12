//package com.jestersClub.codersMania.service;
//
//import com.jestersClub.codersMania.entity.Users;
//import com.jestersClub.codersMania.repositories.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//
//@Service
//public class UserService {
//    @Autowired
//    private  UserRepository userRepository;
//
//
//    public List<Users> getAllUsers(){
//        return userRepository.findAll();
//    }
//
//    public Users getUser(String email){
//        return userRepository.findByEmail(email);
//    }
//
//    public boolean deleteUser(String username){
//        userRepository.deleteById(username);
//        return true;
//    }
//
//    public String updateUser (Users users){
//        if( users.getName()==null){
//            return "Empty";
//        }
//        else {
//            userRepository.save(users);
//            return "Not Empty";
//        }
//
//    }
//
//
//
//}
