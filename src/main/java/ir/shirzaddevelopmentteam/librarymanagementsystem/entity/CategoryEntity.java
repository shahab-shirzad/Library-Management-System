package ir.shirzaddevelopmentteam.librarymanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "category_tbl")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Data
//دسته‌بندی کتاب
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //شناسه یکتای دسته‌بندی
    private Long id;

    @NotNull(message = "فیلد نام دسته بندی را پر کنید")
    //نام دسته‌بندی مانند برنامه‌نویسی، ادبیات یا تاریخ
    private String name;

    //توضیحات مربوط به دسته‌بندی
    private String description;

    //تاریخ ایجاد دسته‌بندی
    private LocalDateTime createdAt;
}
