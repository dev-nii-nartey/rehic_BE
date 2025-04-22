package com.rehic.members;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Document(collection = "members")
@Getter
@Builder(toBuilder = true)
public class Member {
    @Builder.Default
    private final UUID recordId = UUID.randomUUID();
    private final String branchName;
    @Builder.Default
    private final AttendanceStaus status = AttendanceStaus.ACTIVE;
    @Builder.Default
    private final LocalDate registrationDate = LocalDate.now();
    private final String firstName;
    private final String lastName;
    private final String preferredName;
    private final LocalDate dateOfBirth;
    private final Gender gender;
    private final MaritalStatus maritalStatus;
    private final String residingAddress;
    private final String primaryPhone;
    private final String secondaryPhone;
    @Id
    private final String emailAddress;
    private final String occupation;
    private final String employer;
    private final String spouseName;
    private final String spousePhone;
    private final String fatherName;
    private final String fatherHometown;
    private final String fatherContact;
    private final String motherName;
    private final String motherHometown;
    private final String motherContact;
    private final String emergencyContactPhone;
    private final String emergencyContactRelationship;
    private final LocalDate dateJoinedChurch;
    private final Boolean baptizedWithHolySpirit;
    private final LocalDate dateOfSalvation;
    private final LocalDate baptismDate;
    private final String previousChurchAffiliation;
    private final Integer yearsAttended;
    private final List<String> ministriesOfInterest;
    private final List<String> spiritualGifts;
    private final List<String> skills;
    @Builder.Default
    private final Boolean agreeWithBibleIsInspiredWord = true;
    @Builder.Default
    private final Boolean agreeWithSalvationThroughFaith = true;
    @Builder.Default
    private final Boolean agreeWithJesusSonOfGod = true;
    @Builder.Default
    private final Boolean commitmentAttendServices = true;
    @Builder.Default
    private final Boolean commitmentSupportActivities = true;
    @Builder.Default
    private final Boolean commitmentTithe = true;
    @Builder.Default
    private final Boolean commitmentLiveChristianValues = true;
    @Builder.Default
    private final LocalDate signatureDate = LocalDate.now();
    @Builder.Default
    private final Boolean consentContactPermission = true;
    @Builder.Default
    private final Boolean consentPhotoUse = true;
    @Builder.Default
    private final LocalDate consentSignatureDate = LocalDate.now();
    private final String specialNeeds;
    private final String howDidYouHear;
    @Builder.Default
    private final Boolean isDeleted = false;

    // Static factory method to create a builder from a registration form
    public static MemberBuilder fromRegistrationForm(MembershipRegistrationForm form) {
        return Member.builder()
                .branchName(form.branchName())
                .firstName(form.firstName())
                .lastName(form.lastName())
                .preferredName(form.preferredName())
                .dateOfBirth(form.dateOfBirth())
                .gender(form.gender())
                .maritalStatus(form.maritalStatus())
                .residingAddress(form.residingAddress())
                .primaryPhone(form.primaryPhone())
                .secondaryPhone(form.secondaryPhone())
                .emailAddress(form.emailAddress())
                .occupation(form.occupation())
                .employer(form.employer())
                .spouseName(form.spouseName())
                .spousePhone(form.spousePhone())
                .fatherName(form.fatherName())
                .fatherHometown(form.fatherHometown())
                .fatherContact(form.fatherContact())
                .motherName(form.motherName())
                .motherHometown(form.motherHometown())
                .motherContact(form.motherContact())
                .emergencyContactPhone(form.emergencyContactPhone())
                .emergencyContactRelationship(form.emergencyContactRelationship())
                .dateJoinedChurch(form.dateJoinedChurch())
                .baptizedWithHolySpirit(form.baptizedWithHolySpirit())
                .dateOfSalvation(form.dateOfSalvation())
                .baptismDate(form.baptismDate())
                .previousChurchAffiliation(form.previousChurchAffiliation())
                .yearsAttended(form.yearsAttended())
                .ministriesOfInterest(form.ministriesOfInterest())
                .spiritualGifts(form.spiritualGifts())
                .skills(form.skills())
                .specialNeeds(form.specialNeeds())
                .howDidYouHear(form.howDidYouHear())
                .isDeleted(form.isDeleted() != null ? form.isDeleted() : false);
    }

    // Helper method to update isDeleted
    public Member withIsDeleted(boolean isDeleted) {
        return this.toBuilder().isDeleted(isDeleted).build();
    }
    
}
