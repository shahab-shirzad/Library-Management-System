package ir.shirzaddevelopmentteam.librarymanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import javax.xml.stream.events.DTD;
import java.time.LocalDateTime;

@Entity
@Table(name = "rent_tbl")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Data
//امانت
public class RentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //شناسه یکتای عملیات امانت
    private Long id;

    @NotNull(message = "فیلد شناسه کاربری کتابداری که عملیات امانت را ثبت کرده است را پر کنید")
    //شناسه کاربری کتابداری که عملیات امانت را ثبت کرده است
    private int librarianId;

    @NotNull(message = "فیلد شناسه عضوی که کتاب را امانت گرفته است را پر کنید")
    //شناسه عضوی که کتاب را امانت گرفته است
    private int memberId;

    @NotNull
    //تاریخ و زمان ثبت عملیات امانت
    private LocalDateTime rentDate;

    @NotNull(message = "فیلد وضعیت امانت را پر کنید")
    //وضعیت امانت: ACTIVE فعال، COMPLETED تکمیل‌شده، CANCELLED لغوشده
    private String status;

    //تاریخ ایجاد رکورد امانت
    private LocalDateTime createdAt;

}
