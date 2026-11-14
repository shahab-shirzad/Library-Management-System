package ir.shirzaddevelopmentteam.librarymanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

//نویسنده
@Entity
@Table(name = "author_tbl")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Data
public class AuthorEntity {

    //شناسه یکتای نویسنده
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //نام نویسنده
    @NotBlank(message = "فیلد نام نویسنده را پر کنید")
    private String firstName;

    //نام خانوادگی نویسنده
    @NotBlank(message = "فیلد نام خانوادگی نویسنده را پر کنید")
    private String lastName;

    //زندگی‌نامه و توضیحات مربوط به نویسنده
    private String biography;

    //تاریخ ثبت نویسنده
    @CreationTimestamp
    private LocalDateTime createdAt;


}
