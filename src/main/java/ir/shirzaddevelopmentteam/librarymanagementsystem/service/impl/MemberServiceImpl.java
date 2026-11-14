package ir.shirzaddevelopmentteam.librarymanagementsystem.service.impl;

import ir.shirzaddevelopmentteam.librarymanagementsystem.dao.MemberDao;
import ir.shirzaddevelopmentteam.librarymanagementsystem.dto.MemberDto;
import ir.shirzaddevelopmentteam.librarymanagementsystem.entity.MemberEntity;
import ir.shirzaddevelopmentteam.librarymanagementsystem.exception.NotFoundException;
import ir.shirzaddevelopmentteam.librarymanagementsystem.mapper.MemberMapper;
import ir.shirzaddevelopmentteam.librarymanagementsystem.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;

    @Autowired
    private MemberMapper memberMapper;


    @Override
    public MemberDto create(MemberDto memberDto) throws Exception {

        MemberEntity memberEntity = memberMapper.convertToEntity(memberDto);

        memberEntity = memberDao.save(memberEntity);

        return memberMapper.convertToDto(memberEntity);
    }


    @Override
    public MemberDto findById(Long id) throws Exception {

        Optional<MemberEntity> optional = memberDao.findById(id);

        if (optional.isPresent()) {
            return memberMapper.convertToDto(optional.get());
        } else {
            throw new NotFoundException("عضو کتابخانه با شناسه مورد نظر یافت نشد");
        }
    }


    @Override
    public List<MemberDto> findAll() {

        List<MemberEntity> memberEntities = memberDao.findAll();

        return memberMapper.convertToDto(memberEntities);
    }


    @Override
    public MemberDto update(MemberDto memberDto, Long id) throws Exception {

        Optional<MemberEntity> optional = memberDao.findById(id);

        if (optional.isPresent()) {

            MemberEntity memberEntity = optional.get();

            if (memberDto.getUserId() != null) {
                memberEntity.setUserId(memberDto.getUserId());
            }

            if (memberDto.getMemberTypeId() != null) {
                memberEntity.setMemberTypeId(memberDto.getMemberTypeId());
            }

            if (memberDto.getNationalCode() != null && !memberDto.getNationalCode().isBlank()) {
                memberEntity.setNationalCode(memberDto.getNationalCode());
            }

            if (memberDto.getMembershipNumber() != null && !memberDto.getMembershipNumber().isBlank()) {
                memberEntity.setMembershipNumber(memberDto.getMembershipNumber());
            }

            if (memberDto.getMembershipStartDate() != null) {
                memberEntity.setMembershipStartDate(memberDto.getMembershipStartDate());
            }

            if (memberDto.getMembershipEndDate() != null) {
                memberEntity.setMembershipEndDate(memberDto.getMembershipEndDate());
            }

            if (memberDto.getStatus() != null && !memberDto.getStatus().isBlank()) {
                memberEntity.setStatus(memberDto.getStatus());
            }

            return memberMapper.convertToDto(memberDao.save(memberEntity));

        } else {
            throw new NotFoundException("عضو کتابخانه با آیدی " + id + " وجود ندارد");
        }
    }


    @Override
    public Boolean delete(Long id) throws Exception {

        Optional<MemberEntity> optional = memberDao.findById(id);

        if (optional.isPresent()) {

            memberDao.deleteById(id);

            return true;

        } else {
            throw new NotFoundException("عضو کتابخانه با آیدی " + id + " وجود ندارد");
        }
    }

}
