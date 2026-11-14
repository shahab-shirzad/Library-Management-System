package ir.shirzaddevelopmentteam.librarymanagementsystem.service;

import ir.shirzaddevelopmentteam.librarymanagementsystem.dto.MemberDto;

import java.util.List;

public interface MemberService {

    MemberDto create(MemberDto memberDto) throws Exception;

    MemberDto findById(Long id) throws Exception;

    List<MemberDto> findAll();

    MemberDto update(MemberDto memberDto, Long id) throws Exception;

    Boolean delete(Long id) throws Exception;

}
