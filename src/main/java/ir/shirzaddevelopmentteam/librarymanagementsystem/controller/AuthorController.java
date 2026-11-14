package ir.shirzaddevelopmentteam.librarymanagementsystem.controller;

import ir.shirzaddevelopmentteam.librarymanagementsystem.dto.AuthorDto;
import ir.shirzaddevelopmentteam.librarymanagementsystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;


@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;


    @PostMapping("/create")
    public ResponseEntity create(@RequestBody AuthorDto authorDto) throws Exception {
        return ResponseEntity.ok(authorService.create(authorDto));
    }

    @PostMapping("/findById/{id}")
    public ResponseEntity findById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(authorService.findById(id));
    }

    @PostMapping("/findAll")
    public ResponseEntity<List<AuthorDto>> findAll() {
        return ResponseEntity.ok(authorService.findAll());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AuthorDto> update(
            @RequestBody AuthorDto authorDto,
            @PathVariable Long id) throws Exception {
        return ResponseEntity.ok(authorService.update(authorDto, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(authorService.delete(id));
    }

}