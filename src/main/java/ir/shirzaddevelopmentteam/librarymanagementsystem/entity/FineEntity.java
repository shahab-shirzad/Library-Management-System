package ir.shirzaddevelopmentteam.librarymanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "fine_tbl")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Data
//جریمه
public class FineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //شناسه یکتای جریمه
    private Long id;

    @NotNull(message = " فیلد شناسه امانت مرتبط با جریمه را پر کنید")
    //شناسه امانت مرتبط با جریمه
    private int rentId;

    @NotNull(message = " فیلد شناسه عضوی که جریمه برای او ثبت شده است را پر کنید")
    //شناسه عضوی که جریمه برای او ثبت شده است
    private int memberId;

    @NotNull(message = " فیلد مبلغ کل جریمه محاسبه شده را پر کنید")
    //مبلغ کل جریمه محاسبه ‌شده
    private Long fineAmount;

    @NotNull(message = " فیلد مجموع مبلغ پرداخت شده از جریمه را پر کنید")
    //مجموع مبلغ پرداخت‌شده از جریمه
    private Long paidAmount;

    @NotNull(message = " فیلد تعداد روزهای تأخیر در بازگرداندن کتاب را پر کنید")
    //تعداد روزهای تأخیر در بازگرداندن کتاب
    private int delayDays;

    @NotNull(message = " فیلد وضعیت جریمه را پر کنید")
    //وضعیت جریمه: UNPAID پرداخت‌نشده، PARTIALLY_PAID پرداخت‌شده به‌صورت جزئی، PAID تسویه‌شد
    private String status;

    //تاریخ ثبت جریمه
    private LocalDateTime createdAt;

    //تاریخ آخرین تغییر اطلاعات جریمه
    private LocalDateTime updatedAt;
}
