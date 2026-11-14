package ir.shirzaddevelopmentteam.librarymanagementsystem.dao;

import ir.shirzaddevelopmentteam.librarymanagementsystem.entity.MemberTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberTypeDao extends JpaRepository<MemberTypeEntity,Long> {
}
