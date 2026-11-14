package ir.shirzaddevelopmentteam.librarymanagementsystem.controller;

import ir.shirzaddevelopmentteam.librarymanagementsystem.dto.UserDto;
import ir.shirzaddevelopmentteam.librarymanagementsystem.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/create")
    public ResponseEntity addUser(@Valid @RequestBody UserDto userDto)throws Exception {
        return ResponseEntity.ok(userService.create(userDto));
    }

    @PostMapping("/findById/{id}")
    public ResponseEntity findById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping("/findAll")
    public ResponseEntity<List<UserDto>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody UserDto userDto) throws Exception {
        return ResponseEntity.ok(userService.update(userDto, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(userService.delete(id));
    }
}
