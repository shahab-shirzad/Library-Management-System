package ir.shirzaddevelopmentteam.librarymanagementsystem.dao;
import ir.shirzaddevelopmentteam.librarymanagementsystem.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDao extends JpaRepository<MemberEntity, Long> {

}
