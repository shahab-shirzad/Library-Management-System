package ir.shirzaddevelopmentteam.librarymanagementsystem.controller;

import ir.shirzaddevelopmentteam.librarymanagementsystem.dto.MemberTypeDto;
import ir.shirzaddevelopmentteam.librarymanagementsystem.service.MemberTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.List;


@RestController
@RequestMapping("/memberType")
public class MemberTypeController {

    @Autowired
    private MemberTypeService memberTypeService;


    @PostMapping("/create")
    public ResponseEntity create(@RequestBody MemberTypeDto memberTypeDto) throws Exception {
        return ResponseEntity.ok(memberTypeService.create(memberTypeDto));
    }

    @PostMapping("/findById/{id}")
    public ResponseEntity findById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(memberTypeService.findById(id));
    }

    @PostMapping("/findAll")
    public ResponseEntity<List<MemberTypeDto>> findAll() {
        return ResponseEntity.ok(memberTypeService.findAll());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@RequestBody MemberTypeDto memberTypeDto, @PathVariable Long id) throws Exception {

        return ResponseEntity.ok(memberTypeService.update(memberTypeDto, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(memberTypeService.delete(id));
    }

}
