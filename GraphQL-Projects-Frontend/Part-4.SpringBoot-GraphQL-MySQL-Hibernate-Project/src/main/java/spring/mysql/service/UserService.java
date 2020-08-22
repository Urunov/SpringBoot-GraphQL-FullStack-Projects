//package spring.mysql.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import spring.mysql.entity.User;
//import spring.mysql.exception.UserException;
//import spring.mysql.repository.UserRepository;
//
//import java.util.List;
//import java.util.Optional;
//
///**
// * @Author: apple
// * @created on 21/08/2020
// * @Project is SpringGraphQLMySQL
// */
//
//@Service
//public class UserService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    public List<User> getAll() {
//        return userRepository.findAll();
//    }
//
//    public User getById(Long id) {
//        Optional<User> user = userRepository.findById(id);
//        if (!user.isPresent()) {
//            throw new UserException(404, "User with id " + id + " cannot be found");
//        }
//        return user.get();
//    }
//
//    public User create(String username, String email) {
//        User user = User.create(username, email);
//        return userRepository.save(user);
//    }
//
//    public User update(Long id, String username, String email) {
//        User user = getById(id);
//        user.updateFields(username, email);
//        return userRepository.save(user);
//    }
//
//    public boolean delete(Long id) {
//        User user = getById(id);
//        userRepository.delete(user);
//        return true;
//    }
//}
