package springboot.pp_3_1_1_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.pp_3_1_1_2.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
