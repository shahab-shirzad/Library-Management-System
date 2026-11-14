package ir.shirzaddevelopmentteam.librarymanagementsystem.service;

import ir.shirzaddevelopmentteam.librarymanagementsystem.dto.MemberTypeDto;

import java.util.List;


public interface MemberTypeService {

    MemberTypeDto create(MemberTypeDto memberTypeDto) throws Exception;

    MemberTypeDto findById(Long id) throws Exception;

    List<MemberTypeDto> findAll();

    MemberTypeDto update(MemberTypeDto memberTypeDto, Long id) throws Exception;

    Boolean delete(Long id) throws Exception;

}