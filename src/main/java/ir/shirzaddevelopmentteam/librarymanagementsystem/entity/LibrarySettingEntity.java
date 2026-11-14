package ir.shirzaddevelopmentteam.librarymanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "library_setting_tbl")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Data
//تنظیمات کتابخانه
public class LibrarySettingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //شناسه یکتای تنظیمات
    private Long id;

    @NotNull(message = " فیلد کلید یکتای تنظیم را پر کنید")
    //کلید یکتای تنظیم مانند: DAILY_FINE_AMOUNT
    private String settingKey;

    @NotNull(message = " فیلد مقدار تنظیم مربوطه را پر کنید")
    //مقدار تنظیم مربوطه
    private String settingValue;

    //توضیحات مربوط به تنظیم
    private String description;

    //تاریخ آخرین ویرایش تنظیم
    private LocalDateTime updatedAt;
}
