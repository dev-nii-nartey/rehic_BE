package com.rehic.members;

import java.time.LocalDate;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberSummaryDto {
    private UUID id;
    private String firstName;
    private String lastName;
    private String primaryPhone;
    private LocalDate dateJoinedChurch;
    private String emailAddress;
    private AttendanceStaus attendanceStatus;
    private LocalDate lastAttendance;

    public MemberSummaryDto(Member member) {
        this.id = member.getRecordId();
        this.firstName = member.getFirstName();
        this.lastName = member.getLastName();
        this.primaryPhone = member.getPrimaryPhone();
        this.dateJoinedChurch = member.getDateJoinedChurch();
        this.emailAddress = member.getEmailAddress();
        this.attendanceStatus = member.getAttendanceStatus();
        this.lastAttendance = LocalDate.now();
    }
}
