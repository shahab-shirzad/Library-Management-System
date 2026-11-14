package ir.shirzaddevelopmentteam.librarymanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "book_copy_tbl")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Data
//نسخه فیزیکی کتاب
public class BookCopyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //شناسه یکتای نسخه فیزیکی
    private Long id;

    @NotNull(message = "فیلد شناسه عنوان کتاب مربوط به این نسخه را پر کنید")
    //شناسه عنوان کتاب مربوط به این نسخه
    private int bookId;

    @NotNull(message = "فیلد بارکد اختصاصی نسخه فیزیکی را پر کنید")
    //بارکد اختصاصی نسخه فیزیکی
    private String barcode;

    @NotNull(message = "فیلد وضعیت نسخه را پر کنید")
    //وضعیت نسخه: AVAILABLE قابل امانت، BORROWED امانت‌داده‌شده، RESERVED رزروشده، DAMAGED آسیب‌دیده، LOST مفقودشده
    private String status;

    //قیمت خرید نسخه فیزیکی کتاب
    private Long price;

    //توضیحات مربوط به وضعیت یا مشخصات نسخه
    private String description;

    //تاریخ ثبت نسخه
    private LocalDateTime createdAt;

    //تاریخ آخرین تغییر اطلاعات نسخه
    private LocalDateTime updatedAt;
}
