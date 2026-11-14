package ir.shirzaddevelopmentteam.librarymanagementsystem.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "member_tbl")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Data
//عضو کتابخانه
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //شناسه یکتای عضویت
    private Long id;


    @NotNull(message = "فیلد شناسه کاربر مرتبط با این عضویت را پر کنید")
    //شناسه کاربر مرتبط با این عضویت
    private Long userId;

    //شناسه نوع عضویت
    @NotNull(message = "فیلد شناسه نوع عضویت را پر کنید")
    private Long memberTypeId;

    @NotBlank(message = "فیلد کد ملی عضو را پر کنید")
    //کد ملی عضو
    private String nationalCode;

    @NotBlank(message = "فیلد شماره اختصاصی عضویت در کتابخانه را پر کنید")
    //شماره اختصاصی عضویت در کتابخانه
    private String membershipNumber;

    @NotNull(message = "فیلد تاریخ شروع اعتبار عضویت را پر کنید")
    //تاریخ شروع اعتبار عضویت
    private Date membershipStartDate;

    //تاریخ پایان اعتبار عضویت
    private Date membershipEndDate;

    @NotBlank(message = "فیلد وضعیت عضویت را پر کنید")
    //وضعیت عضویت: ACTIVE فعال، INACTIVE غیرفعال، SUSPENDED تعلیق‌شده، EXPIRED منقضی‌شده
    private String status;

    @CreationTimestamp
    //تاریخ ثبت عضویت
    private LocalDateTime createdAt;

    @UpdateTimestamp
    //تاریخ آخرین ویرایش اطلاعات عضویت
    private LocalDateTime updatedAt;


}
