package ir.shirzaddevelopmentteam.librarymanagementsystem.dao;

import ir.shirzaddevelopmentteam.librarymanagementsystem.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<UserEntity,Long> {
    Boolean existsByUsernameEquals(String username);

    List<UserEntity> findAllByIsActiveTrue();

    Optional<UserEntity> findByIdAndIsActiveTrue(Long id);

}
