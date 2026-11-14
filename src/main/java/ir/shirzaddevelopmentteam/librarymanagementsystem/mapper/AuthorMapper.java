package ir.shirzaddevelopmentteam.librarymanagementsystem.mapper;

import ir.shirzaddevelopmentteam.librarymanagementsystem.entity.AuthorEntity;
import ir.shirzaddevelopmentteam.librarymanagementsystem.dto.AuthorDto;
import org.mapstruct.Mapper;
import java.util.List;


@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorEntity convertToEntity(AuthorDto authorDto);

    AuthorDto convertToDto(AuthorEntity authorEntity);

    List<AuthorDto> convertToDto(List<AuthorEntity> authorEntities);
}
