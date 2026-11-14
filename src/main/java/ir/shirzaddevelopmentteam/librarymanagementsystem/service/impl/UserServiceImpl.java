package ir.shirzaddevelopmentteam.librarymanagementsystem.service.impl;

import ir.shirzaddevelopmentteam.librarymanagementsystem.dao.UserDao;
import ir.shirzaddevelopmentteam.librarymanagementsystem.dto.UserDto;
import ir.shirzaddevelopmentteam.librarymanagementsystem.entity.UserEntity;
import ir.shirzaddevelopmentteam.librarymanagementsystem.exception.AlreadyExistsException;
import ir.shirzaddevelopmentteam.librarymanagementsystem.exception.NotFoundException;
import ir.shirzaddevelopmentteam.librarymanagementsystem.mapper.UserMapper;
import ir.shirzaddevelopmentteam.librarymanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.time.LocalDateTime;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public Boolean findUsernameExists(String username)throws Exception{
        if (userDao.existsByUsernameEquals(username))
            return true;
        else
            return false;
    }


    @Override
    public UserDto create(UserDto userDto) throws Exception {

        if (userDto.getUsername() == null) {
            throw new NullPointerException("فیلد نام کاربری را پر کنید");
        }

        if (!this.findUsernameExists(userDto.getUsername())) {

            // رمزنگاری رمز عبور
            userDto.setPassword(
                    passwordEncoder.encode(userDto.getPassword())
            );

            UserEntity userEntity =
                    userDao.save(userMapper.convertToEntity(userDto));

            return userMapper.convertToDto(userEntity);

        } else {
            throw new AlreadyExistsException(
                    "نام کاربری " + userDto.getUsername() + " در سامانه وجود دارد"
            );
        }
    }
    /*public UserDto create(UserDto userDto) throws Exception {
        if (userDto.getUsername() == null){
            throw new NullPointerException("فیلد نام کاربری را پر کنید");
        } else {
            if (!this.findUsernameExists(userDto.getUsername())){

                UserEntity userEntity = userMapper.convertToEntity(userDto);
                System.out.println("DTO Username: " + userDto.getUsername());
                System.out.println("Entity Username: " + userEntity.getUsername());

                userEntity = userDao.save(userMapper.convertToEntity(userDto));
                return userMapper.convertToDto(userEntity);
            }else {
                throw new AlreadyExistsException(" نام کاربری " + userDto.getUsername() + " در سامانه وجود دارد");
            }
        }
    }*/


    @Override
    public UserDto findById(Long id) throws Exception {

        Optional<UserEntity> optional = userDao.findByIdAndIsActiveTrue(id);

        if (optional.isPresent()) {
            return userMapper.convertToDto(optional.get());
        } else {
            throw new NotFoundException("کاربر مورد نظر یافت نشد");
        }
    }
    @Override
    public List<UserDto> findAll(){
        return userMapper.convertToDto(userDao.findAllByIsActiveTrue());
    }

    @Override
    public UserDto update(UserDto userDto, Long id) throws Exception{
        if (userDao.existsById(id)) {
            Optional<UserEntity> entity = userDao.findByIdAndIsActiveTrue(id);
            UserEntity userEntity = entity.get();
            userEntity.setUpdatedAt(LocalDateTime.now());
            if (userDto.getFirstName() != null)
                userEntity.setFirstName(userDto.getFirstName());

            if (userDto.getLastName() != null)
                userEntity.setLastName(userDto.getLastName());

            if (userDto.getEmail() != null)
                userEntity.setEmail(userDto.getEmail());

            if (userDto.getPhoneNumber() != null)
                userEntity.setPhoneNumber(userDto.getPhoneNumber());

            if (userDto.getRole() != null)
                userEntity.setRole(userDto.getRole());

            if (userDto.getPassword() != null && !userDto.getPassword().isBlank())
                userEntity.setPassword(passwordEncoder.encode(userDto.getPassword()));

            return userMapper.convertToDto(userDao.save(userEntity));

        }else throw new NotFoundException("کاربری با آیدی"+ id + "وجود ندارد");
    }

    @Override
    public Boolean delete(Long id) throws Exception {

        Optional<UserEntity> entity = userDao.findById(id);

        if (entity.isPresent()) {

            UserEntity userEntity = entity.get();

            userEntity.setActive(false);
            userEntity.setUpdatedAt(LocalDateTime.now());

            userDao.save(userEntity);

            return true;

        } else {
            throw new NotFoundException("کاربری با آیدی " + id + " وجود ندارد");
        }
    }



}
