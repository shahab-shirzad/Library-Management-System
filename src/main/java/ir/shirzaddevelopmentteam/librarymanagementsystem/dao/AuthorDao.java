package ir.shirzaddevelopmentteam.librarymanagementsystem.dao;

import ir.shirzaddevelopmentteam.librarymanagementsystem.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorDao extends JpaRepository<AuthorEntity,Long> {
}
