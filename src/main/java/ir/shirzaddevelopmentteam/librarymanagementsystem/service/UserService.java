package ir.shirzaddevelopmentteam.librarymanagementsystem.service;

import ir.shirzaddevelopmentteam.librarymanagementsystem.dto.UserDto;
import java.util.List;

public interface UserService {

    Boolean findUsernameExists(String username)throws Exception;

    UserDto create(UserDto userDto) throws Exception;

    UserDto findById(Long id) throws Exception;

    List<UserDto> findAll();

    UserDto update(UserDto userDto, Long id) throws Exception;

    Boolean delete(Long id) throws Exception;
}
