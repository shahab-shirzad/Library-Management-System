package ir.shirzaddevelopmentteam.librarymanagementsystem.service;

import ir.shirzaddevelopmentteam.librarymanagementsystem.dto.AuthorDto;

import java.util.List;

public interface AuthorService {

    AuthorDto create(AuthorDto authorDto) throws Exception;

    AuthorDto findById(Long id) throws Exception;

    List<AuthorDto> findAll();

    AuthorDto update(AuthorDto authorDto, Long id) throws Exception;

    Boolean delete(Long id) throws Exception;
}
