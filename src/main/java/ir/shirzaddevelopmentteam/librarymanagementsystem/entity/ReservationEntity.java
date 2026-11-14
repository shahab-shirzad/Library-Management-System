package ir.shirzaddevelopmentteam.librarymanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "reservation_tbl")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Data
//رزرو کتاب
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //شناسه یکتای رزرو
    private Long id;

    @NotNull(message = "فیلد شناسه عضوی که درخواست رزرو ثبت کرده است را پر کنید")
    //شناسه عضوی که درخواست رزرو ثبت کرده است
    private int memberId;

    @NotNull(message = "فیلد شناسه عنوان کتاب رزروشده را پر کنید")
    //شناسه عنوان کتاب رزروشده
    private int bookId;

    @NotNull
    //تاریخ و زمان ثبت درخواست رزرو
    private LocalDateTime reservedAt;

    //تاریخ و زمان آماده شدن کتاب برای تحویل
    private LocalDateTime readyAt;

    //تاریخ و زمان پایان اعتبار رزرو
    private LocalDateTime expiresAt;

    @NotNull(message = "فیلد وضعیت رزرو را پر کنید")
    //وضعیت رزرو: WAITING در انتظار، READY آماده تحویل، FULFILLED تحویل‌شده، EXPIRED منقضی‌شده، CANCELLED لغوشده
    private String status;

    //تاریخ و زمان نهایی شدن رزرو و تحویل کتاب
    private LocalDateTime fulfilledAt;

    //تاریخ و زمان لغو رزرو
    private LocalDateTime canceledAt;
}
