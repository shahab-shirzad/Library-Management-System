package ir.shirzaddevelopmentteam.librarymanagementsystem.dto;

import lombok.Data;
import java.util.Date;
import java.time.LocalDateTime;

@Data
public class MemberDto {

    private Long id;

    private Long userId;

    private Long memberTypeId;

    private String nationalCode;

    private String membershipNumber;

    private Date membershipStartDate;

    private Date membershipEndDate;

    private String status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
