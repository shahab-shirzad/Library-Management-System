package ir.shirzaddevelopmentteam.librarymanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import jakarta.validation.constraints.Min;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "MemberType_tbl")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Data
//نوع عضویت
public class MemberTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //شناسه یکتای نوع عضویت
    private Long id;

    @NotBlank(message = "فیلد عنوان نوع عضویت مانند: دانشجو، استاد یا کارمند، را پر کنید")
    //عنوان نوع عضویت مانند دانشجو، استاد یا کارمند
    private String title;

    @Min(value = 1, message = "حداقل تعداد کتاب قابل امانت باید 1 باشد")
    //حداکثر تعداد کتاب قابل امانت به‌صورت هم‌زمان
    private int maxBorrowLimit;

    @Min(value = 1, message = "مدت امانت باید حداقل یک روز باشد")
    //مدت مجاز اولیه امانت بر حسب روز
    private int loanDurationDays;

    @CreationTimestamp
    //تاریخ ایجاد نوع عضویت
    private LocalDateTime createdAt;

    @UpdateTimestamp
    //تاریخ آخرین ویرایش نوع عضویت
    private LocalDateTime updatedAt;

}
