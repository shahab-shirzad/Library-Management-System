package ir.shirzaddevelopmentteam.librarymanagementsystem.service.impl;

import ir.shirzaddevelopmentteam.librarymanagementsystem.dao.AuthorDao;
import ir.shirzaddevelopmentteam.librarymanagementsystem.dto.AuthorDto;
import ir.shirzaddevelopmentteam.librarymanagementsystem.entity.AuthorEntity;
import ir.shirzaddevelopmentteam.librarymanagementsystem.exception.NotFoundException;
import ir.shirzaddevelopmentteam.librarymanagementsystem.mapper.AuthorMapper;
import ir.shirzaddevelopmentteam.librarymanagementsystem.service.AuthorService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDao authorDao;

    @Autowired
    private AuthorMapper authorMapper;



    @Override
    public AuthorDto create(AuthorDto authorDto) throws Exception {
        AuthorEntity authorEntity = authorMapper.convertToEntity(authorDto);
        authorEntity = authorDao.save(authorEntity);
        return authorMapper.convertToDto(authorEntity);
    }



    @Override
    public AuthorDto findById(Long id) throws Exception {
        Optional<AuthorEntity> optional = authorDao.findById(id);

        if (optional.isPresent()) {
            return authorMapper.convertToDto(optional.get());
        } else {
            throw new NotFoundException("نویسنده با شناسه مورد نظر یافت نشد");
        }
    }



    @Override
    public List<AuthorDto> findAll() {
        List<AuthorEntity> authorEntities = authorDao.findAll();
        return authorMapper.convertToDto(authorEntities);
    }



    @Override
    public AuthorDto update(AuthorDto authorDto, Long id) throws Exception {
        Optional<AuthorEntity> optional = authorDao.findById(id);

        if (optional.isPresent()) {
            AuthorEntity authorEntity = optional.get();

            if (authorDto.getFirstName() != null && !authorDto.getFirstName().isBlank()) {
                authorEntity.setFirstName(authorDto.getFirstName());
            }

            if (authorDto.getLastName() != null && !authorDto.getLastName().isBlank()) {
                authorEntity.setLastName(authorDto.getLastName());
            }

            if (authorDto.getBiography() != null) {
                authorEntity.setBiography(authorDto.getBiography());
            }

            return authorMapper.convertToDto(authorDao.save(authorEntity));

        } else {
            throw new NotFoundException("نویسنده با آیدی " + id + " وجود ندارد");
        }
    }



    @Override
    public Boolean delete(Long id) throws Exception {
        Optional<AuthorEntity> optional = authorDao.findById(id);

        if (optional.isPresent()) {
            authorDao.deleteById(id);
            return true;
        } else {
            throw new NotFoundException("نویسنده با آیدی " + id + " وجود ندارد");
        }
    }
}
