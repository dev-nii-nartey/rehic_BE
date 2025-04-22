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
        this.firstName = member.getFirstName();
        this.lastName = member.getLastName();
        this.primaryPhone = member.getPrimaryPhone();
        this.dateJoinedChurch = member.getDateJoinedChurch();
        this.emailAddress = member.getEmailAddress();
        // Map status if needed
    }
}
