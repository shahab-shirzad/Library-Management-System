package ir.shirzaddevelopmentteam.librarymanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.time.LocalDateTime;
import ir.shirzaddevelopmentteam.librarymanagementsystem.enums.UserRole;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "user_tbl")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Data
//کاربر
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //شناسه یکتای کاربر
    private Long id;

    @NotBlank(message = "فیلد نام کاربری را پر کنید")
    //نام کاربری برای ورود به سامانه
    private String username;

    @NotBlank(message = "فیلد رمز عبور را پر کنید")
    //رمز عبور هش‌ شده کاربر
    private String password;

    @NotBlank(message = "فیلد نام را پر کنید")
    //نام
    private String firstName;

    @NotBlank(message = "فیلد نام خانوادگی را پر کنید")
    //نام خانوادگی
    private String lastName;

    //آدرس ایمیل کاربر'
    private String email;

    @Size(min = 11, max = 11, message = "شماره تماس وارد شده باید 11 رقم باشد")
    //شماره تماس کاربر
    private String phoneNumber;

    @NotNull(message = "فیلد نقش کاربر را پر کنید")
    @Enumerated(EnumType.STRING)
    //نقش کاربر: ADMIN مدیر، LIBRARIAN کتابدار، MEMBER عضو عادی
    private UserRole role;

//    @NotNull(message = "فیلد وضعیت فعال یا غیرفعال بودن حساب کاربری را پر کنید")
    //وضعیت فعال یا غیرفعال بودن حساب کاربری
    private boolean isActive = true;

    //تاریخ و زمان ایجاد حساب
    private LocalDateTime createdAt;

    //تاریخ و زمان آخرین ویرایش اطلاعات
    private LocalDateTime updatedAt;

}
