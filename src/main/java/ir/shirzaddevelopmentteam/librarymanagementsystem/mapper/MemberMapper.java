package ir.shirzaddevelopmentteam.librarymanagementsystem.mapper;

import ir.shirzaddevelopmentteam.librarymanagementsystem.dto.MemberDto;
import ir.shirzaddevelopmentteam.librarymanagementsystem.entity.MemberEntity;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface MemberMapper {

    MemberEntity convertToEntity(MemberDto memberDto);

    MemberDto convertToDto(MemberEntity memberEntity);

    List<MemberDto> convertToDto(List<MemberEntity> memberEntities);

}