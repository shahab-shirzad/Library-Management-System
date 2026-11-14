package ir.shirzaddevelopmentteam.librarymanagementsystem.mapper;

import ir.shirzaddevelopmentteam.librarymanagementsystem.dto.UserDto;
import ir.shirzaddevelopmentteam.librarymanagementsystem.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity convertToEntity(UserDto userDto);

    @Mapping(target = "password", ignore = true)
    UserDto convertToDto(UserEntity userEntity);

    List<UserDto> convertToDto(List<UserEntity> userEntities);



}
