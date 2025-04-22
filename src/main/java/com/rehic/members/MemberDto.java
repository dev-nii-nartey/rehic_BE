package com.rehic.members;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDto implements Serializable {
    private UUID recordId;
    private String branchName;
    private LocalDate registrationDate;
    // Personal Information
    private String firstName;
    private String lastName;
    private String preferredName;
    private LocalDate dateOfBirth;
    private Gender gender;
    private MaritalStatus maritalStatus;
    private String residingAddress;
    private String primaryPhone;
    private String secondaryPhone;
    private String emailAddress;
    private String occupation;
    private String employer;
    // Family Information
    private String spouseName;
    private String spousePhone;
    private String fatherName;
    private String fatherHometown;
    private String fatherContact;
    private String motherName;
    private String motherHometown;
    private String motherContact;
    private String emergencyContactPhone;
    private String emergencyContactRelationship;
    // Spiritual Journey
    private LocalDate dateJoinedChurch;
    private Boolean baptizedWithHolySpirit;
    private LocalDate dateOfSalvation;
    private LocalDate baptismDate;
    private String previousChurchAffiliation;
    private Integer yearsAttended;
    // Ministry and Skills
    private List<String> ministriesOfInterest;
    private List<String> spiritualGifts;
    private List<String> skills;
    // Additional Information
    private String specialNeeds;
    private String howDidYouHear;


    public MemberDto(Member member) {
        this.recordId = member.getRecordId();
        this.branchName = member.getBranchName();
        this.registrationDate = member.getRegistrationDate();
        this.firstName = member.getFirstName();
        this.lastName = member.getLastName();
        this.preferredName = member.getPreferredName();
        this.dateOfBirth = member.getDateOfBirth();
        this.gender = member.getGender();
        this.maritalStatus = member.getMaritalStatus();
        this.residingAddress = member.getResidingAddress();
        this.primaryPhone = member.getPrimaryPhone();
        this.secondaryPhone = member.getSecondaryPhone();
        this.emailAddress = member.getEmailAddress();
        this.occupation = member.getOccupation();
        this.employer = member.getEmployer();
        this.spouseName = member.getSpouseName();
        this.spousePhone = member.getSpousePhone();
        this.fatherName = member.getFatherName();
        this.fatherHometown = member.getFatherHometown();
        this.fatherContact = member.getFatherContact();
        this.motherName = member.getMotherName();
        this.motherHometown = member.getMotherHometown();
        this.motherContact = member.getMotherContact();
        this.emergencyContactPhone = member.getEmergencyContactPhone();
        this.emergencyContactRelationship = member.getEmergencyContactRelationship();
        this.dateJoinedChurch = member.getDateJoinedChurch();
        this.baptizedWithHolySpirit = member.getBaptizedWithHolySpirit();
        this.dateOfSalvation = member.getDateOfSalvation();
        this.baptismDate = member.getBaptismDate();
        this.previousChurchAffiliation = member.getPreviousChurchAffiliation();
        this.yearsAttended = member.getYearsAttended();
        this.ministriesOfInterest = member.getMinistriesOfInterest();
        this.spiritualGifts = member.getSpiritualGifts();
        this.skills = member.getSkills();
        this.specialNeeds = member.getSpecialNeeds();
        this.howDidYouHear = member.getHowDidYouHear();
    }
}
