package springboot.pp_3_1_1_2.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.pp_3_1_1_2.model.User;
import springboot.pp_3_1_1_2.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> allUsers() {

        return userRepository.findAll();
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void update(User user) {
        userRepository.save(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public User getById(Long id) {
        return userRepository.getById(id);
    }
}
