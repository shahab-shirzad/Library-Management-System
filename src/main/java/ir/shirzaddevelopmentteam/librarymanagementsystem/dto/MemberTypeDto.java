package ir.shirzaddevelopmentteam.librarymanagementsystem.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class MemberTypeDto {

    private Long id;

    private String title;

    private int maxBorrowLimit;

    private int loanDurationDays;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
