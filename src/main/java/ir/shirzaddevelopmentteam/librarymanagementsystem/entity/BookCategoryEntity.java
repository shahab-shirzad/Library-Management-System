package ir.shirzaddevelopmentteam.librarymanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Entity
@Table(name = "book_category_tbl")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Data
//جدول واسط کتاب و دسته‌بندی
public class BookCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //شناسه یکتای ارتباط
    private Long id;

    @NotNull
    //شناسه کتاب
    private int bookId;

    @NotNull
    //شناسه دسته‌بندی
    private int categoryId;
}
