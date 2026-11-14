package ir.shirzaddevelopmentteam.librarymanagementsystem.mapper;

import ir.shirzaddevelopmentteam.librarymanagementsystem.dto.MemberTypeDto;
import ir.shirzaddevelopmentteam.librarymanagementsystem.entity.MemberTypeEntity;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface MemberTypeMapper {

    MemberTypeEntity convertToEntity(MemberTypeDto memberTypeDto);

    MemberTypeDto convertToDto(MemberTypeEntity memberTypeEntity);

    List<MemberTypeDto> convertToDto(List<MemberTypeEntity> memberTypeEntities);

}
