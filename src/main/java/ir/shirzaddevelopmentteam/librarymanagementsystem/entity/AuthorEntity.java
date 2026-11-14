package ir.shirzaddevelopmentteam.librarymanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "author_tbl")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Data
//نویسنده
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //شناسه یکتای نویسنده
    private Long id;

    @NotBlank(message = "فیلد نام نویسنده را پر کنید")
    //نام نویسنده
    private String firstName;

    @NotBlank(message = "فیلد نام خانوادگی نویسنده را پر کنید")
    //نام خانوادگی نویسنده
    private String lastName;

    //زندگی‌نامه و توضیحات مربوط به نویسنده
    private String biography;

    @CreationTimestamp
    //تاریخ ثبت نویسنده
    private LocalDateTime createdAt;


}
