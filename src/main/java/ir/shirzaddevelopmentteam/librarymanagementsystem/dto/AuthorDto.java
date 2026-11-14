package ir.shirzaddevelopmentteam.librarymanagementsystem.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AuthorDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String biography;

    private LocalDateTime createdAt;
}