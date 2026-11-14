package ir.shirzaddevelopmentteam.librarymanagementsystem.service.impl;

import ir.shirzaddevelopmentteam.librarymanagementsystem.dao.MemberTypeDao;
import ir.shirzaddevelopmentteam.librarymanagementsystem.dto.MemberTypeDto;
import ir.shirzaddevelopmentteam.librarymanagementsystem.entity.MemberTypeEntity;
import ir.shirzaddevelopmentteam.librarymanagementsystem.exception.NotFoundException;
import ir.shirzaddevelopmentteam.librarymanagementsystem.mapper.MemberTypeMapper;
import ir.shirzaddevelopmentteam.librarymanagementsystem.service.MemberTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberTypeServiceImpl implements MemberTypeService {

    @Autowired
    private MemberTypeDao memberTypeDao;

    @Autowired
    private MemberTypeMapper memberTypeMapper;


    @Override
    public MemberTypeDto create(MemberTypeDto memberTypeDto) throws Exception {

        MemberTypeEntity memberTypeEntity = memberTypeMapper.convertToEntity(memberTypeDto);

        memberTypeEntity = memberTypeDao.save(memberTypeEntity);

        return memberTypeMapper.convertToDto(memberTypeEntity);
    }


    @Override
    public MemberTypeDto findById(Long id) throws Exception {

        Optional<MemberTypeEntity> optional = memberTypeDao.findById(id);

        if (optional.isPresent()) {
            return memberTypeMapper.convertToDto(optional.get());
        } else {
            throw new NotFoundException("نوع عضویت مورد نظر یافت نشد");
        }
    }


    @Override
    public List<MemberTypeDto> findAll() {

        List<MemberTypeEntity> memberTypeEntities = memberTypeDao.findAll();

        return memberTypeMapper.convertToDto(memberTypeEntities);
    }



    @Override
    public MemberTypeDto update(MemberTypeDto memberTypeDto, Long id) throws Exception {

        Optional<MemberTypeEntity> optional = memberTypeDao.findById(id);

        if (optional.isPresent()) {

            MemberTypeEntity memberTypeEntity = optional.get();

            if (memberTypeDto.getTitle() != null && !memberTypeDto.getTitle().isBlank()) {
                memberTypeEntity.setTitle(memberTypeDto.getTitle());
            }

            if (memberTypeDto.getMaxBorrowLimit() > 0) {
                memberTypeEntity.setMaxBorrowLimit(memberTypeDto.getMaxBorrowLimit());
            }

            if (memberTypeDto.getLoanDurationDays() > 0) {
                memberTypeEntity.setLoanDurationDays(memberTypeDto.getLoanDurationDays());
            }

            return memberTypeMapper.convertToDto(memberTypeDao.save(memberTypeEntity));

        } else {
            throw new NotFoundException("نوع عضویت با آیدی " + id + " وجود ندارد");
        }
    }



    @Override
    public Boolean delete(Long id) throws Exception {

        Optional<MemberTypeEntity> optional = memberTypeDao.findById(id);

        if (optional.isPresent()) {

            memberTypeDao.deleteById(id);

            return true;

        } else {
            throw new NotFoundException("نوع عضویت با آیدی " + id + " وجود ندارد");
        }
    }

}
