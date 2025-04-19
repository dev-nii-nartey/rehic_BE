package com.rehic.members;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberSummaryDto {
    private String firstName;
    private String lastName;
    private String primaryPhone;
    private LocalDate dateJoinedChurch;
    private String emailAddress;
    private String status; // Add this field if it doesn't exist in Member entity
    
    public MemberSummaryDto(Member member) {
        this.firstName = member.firstName();
        this.lastName = member.lastName();
        this.primaryPhone = member.primaryPhone();
        this.dateJoinedChurch = member.dateJoinedChurch();
        this.emailAddress = member.emailAddress();
        // Map status if needed
    }
}
