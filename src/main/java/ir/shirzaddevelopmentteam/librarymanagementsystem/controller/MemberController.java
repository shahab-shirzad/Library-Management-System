package ir.shirzaddevelopmentteam.librarymanagementsystem.controller;

import ir.shirzaddevelopmentteam.librarymanagementsystem.dto.MemberDto;
import ir.shirzaddevelopmentteam.librarymanagementsystem.service.MemberService;
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
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;


    @PostMapping("/create")
    public ResponseEntity create(@RequestBody MemberDto memberDto) throws Exception {
        return ResponseEntity.ok(memberService.create(memberDto));
    }

    @PostMapping("/findById/{id}")
    public ResponseEntity findById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(memberService.findById(id));
    }

    @PostMapping("/findAll")
    public ResponseEntity<List<MemberDto>> findAll() {
        return ResponseEntity.ok(memberService.findAll());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@RequestBody MemberDto memberDto, @PathVariable Long id) throws Exception {
        return ResponseEntity.ok(memberService.update(memberDto, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(memberService.delete(id));
    }

}
