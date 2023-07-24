package final_backend.Member.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import final_backend.Member.model.User;
import final_backend.Member.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    //환경 변수 가져오기

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User findByNickName(String name) {
        return userRepository.findByNickName(name);
    }

    public boolean deleteUser(Long userId) {
        User user = userRepository.findByUid(userId);
        if (user != null) {
            userRepository.delete(user);
            return true;
        }
        return false;
    }

    public User updateUser(Long userId, User updatedUser) {
        User user = userRepository.findByUid(userId);
        if (user != null) {
            user.setUserName(updatedUser.getUserName());
            user.setEmail(updatedUser.getEmail());
            return userRepository.save(user);
        }
        return null;
    }



}
