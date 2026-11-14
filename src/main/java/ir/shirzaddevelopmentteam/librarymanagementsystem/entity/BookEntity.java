package ir.shirzaddevelopmentteam.librarymanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "book_tbl")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Data
//کتاب
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //شناسه یکتای کتاب
    private Long id;

    @NotNull(message = "فیلد عنوان کتاب را پر کنید")
    //عنوان کتاب
    private String title;

    //سال انتشار کتاب
    private int publicationYear;

    //زبان اصلی کتاب
    private String language;

    //توضیحات و معرفی کتاب
    private String description;

    //تاریخ ثبت کتاب در سامانه
    private LocalDateTime createdAt;

    //تاریخ آخرین ویرایش اطلاعات کتاب
    private LocalDateTime updatedAt;
}
