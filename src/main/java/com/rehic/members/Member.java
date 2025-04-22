package com.rehic.members;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Document(collection = "members")
public class Member {
    private final UUID recordId;
    private final String branchName;
    private final AttendanceStaus status;
    private final LocalDate registrationDate;
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
    private final Boolean agreeWithBibleIsInspiredWord;
    private final Boolean agreeWithSalvationThroughFaith;
    private final Boolean agreeWithJesusSonOfGod;
    private final Boolean commitmentAttendServices;
    private final Boolean commitmentSupportActivities;
    private final Boolean commitmentTithe;
    private final Boolean commitmentLiveChristianValues;
    private final LocalDate signatureDate;
    private final Boolean consentContactPermission;
    private final Boolean consentPhotoUse;
    private final LocalDate consentSignatureDate;
    private final String specialNeeds;
    private final String howDidYouHear;
    private final Boolean isDeleted;

    private Member(Builder builder) {
        this.recordId = builder.recordId;
        this.branchName = builder.branchName;
        this.status = builder.status;
        this.registrationDate = builder.registrationDate;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.preferredName = builder.preferredName;
        this.dateOfBirth = builder.dateOfBirth;
        this.gender = builder.gender;
        this.maritalStatus = builder.maritalStatus;
        this.residingAddress = builder.residingAddress;
        this.primaryPhone = builder.primaryPhone;
        this.secondaryPhone = builder.secondaryPhone;
        this.emailAddress = builder.emailAddress;
        this.occupation = builder.occupation;
        this.employer = builder.employer;
        this.spouseName = builder.spouseName;
        this.spousePhone = builder.spousePhone;
        this.fatherName = builder.fatherName;
        this.fatherHometown = builder.fatherHometown;
        this.fatherContact = builder.fatherContact;
        this.motherName = builder.motherName;
        this.motherHometown = builder.motherHometown;
        this.motherContact = builder.motherContact;
        this.emergencyContactPhone = builder.emergencyContactPhone;
        this.emergencyContactRelationship = builder.emergencyContactRelationship;
        this.dateJoinedChurch = builder.dateJoinedChurch;
        this.baptizedWithHolySpirit = builder.baptizedWithHolySpirit;
        this.dateOfSalvation = builder.dateOfSalvation;
        this.baptismDate = builder.baptismDate;
        this.previousChurchAffiliation = builder.previousChurchAffiliation;
        this.yearsAttended = builder.yearsAttended;
        this.ministriesOfInterest = builder.ministriesOfInterest;
        this.spiritualGifts = builder.spiritualGifts;
        this.skills = builder.skills;
        this.agreeWithBibleIsInspiredWord = builder.agreeWithBibleIsInspiredWord;
        this.agreeWithSalvationThroughFaith = builder.agreeWithSalvationThroughFaith;
        this.agreeWithJesusSonOfGod = builder.agreeWithJesusSonOfGod;
        this.commitmentAttendServices = builder.commitmentAttendServices;
        this.commitmentSupportActivities = builder.commitmentSupportActivities;
        this.commitmentTithe = builder.commitmentTithe;
        this.commitmentLiveChristianValues = builder.commitmentLiveChristianValues;
        this.signatureDate = builder.signatureDate;
        this.consentContactPermission = builder.consentContactPermission;
        this.consentPhotoUse = builder.consentPhotoUse;
        this.consentSignatureDate = builder.consentSignatureDate;
        this.specialNeeds = builder.specialNeeds;
        this.howDidYouHear = builder.howDidYouHear;
        this.isDeleted = builder.isDeleted;
    }

    // Builder class
    public static class Builder {
        private UUID recordId = UUID.randomUUID();
        private String branchName;
        private AttendanceStaus status = AttendanceStaus.ACTIVE;
        private LocalDate registrationDate = LocalDate.now();
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
        private LocalDate dateJoinedChurch;
        private Boolean baptizedWithHolySpirit;
        private LocalDate dateOfSalvation;
        private LocalDate baptismDate;
        private String previousChurchAffiliation;
        private Integer yearsAttended;
        private List<String> ministriesOfInterest;
        private List<String> spiritualGifts;
        private List<String> skills;
        private Boolean agreeWithBibleIsInspiredWord = true;
        private Boolean agreeWithSalvationThroughFaith = true;
        private Boolean agreeWithJesusSonOfGod = true;
        private Boolean commitmentAttendServices = true;
        private Boolean commitmentSupportActivities = true;
        private Boolean commitmentTithe = true;
        private Boolean commitmentLiveChristianValues = true;
        private LocalDate signatureDate = LocalDate.now();
        private Boolean consentContactPermission = true;
        private Boolean consentPhotoUse = true;
        private LocalDate consentSignatureDate = LocalDate.now();
        private String specialNeeds;
        private String howDidYouHear;
        private Boolean isDeleted = false;

        public Builder() {
        }

        public Builder fromRegistrationForm(MembershipRegistrationForm form) {
            this.branchName = form.branchName();
            this.firstName = form.firstName();
            this.lastName = form.lastName();
            this.preferredName = form.preferredName();
            this.dateOfBirth = form.dateOfBirth();
            this.gender = form.gender();
            this.maritalStatus = form.maritalStatus();
            this.residingAddress = form.residingAddress();
            this.primaryPhone = form.primaryPhone();
            this.secondaryPhone = form.secondaryPhone();
            this.emailAddress = form.emailAddress();
            this.occupation = form.occupation();
            this.employer = form.employer();
            this.spouseName = form.spouseName();
            this.spousePhone = form.spousePhone();
            this.fatherName = form.fatherName();
            this.fatherHometown = form.fatherHometown();
            this.fatherContact = form.fatherContact();
            this.motherName = form.motherName();
            this.motherHometown = form.motherHometown();
            this.motherContact = form.motherContact();
            this.emergencyContactPhone = form.emergencyContactPhone();
            this.emergencyContactRelationship = form.emergencyContactRelationship();
            this.dateJoinedChurch = form.dateJoinedChurch();
            this.baptizedWithHolySpirit = form.baptizedWithHolySpirit();
            this.dateOfSalvation = form.dateOfSalvation();
            this.baptismDate = form.baptismDate();
            this.previousChurchAffiliation = form.previousChurchAffiliation();
            this.yearsAttended = form.yearsAttended();
            this.ministriesOfInterest = form.ministriesOfInterest();
            this.spiritualGifts = form.spiritualGifts();
            this.skills = form.skills();
            this.specialNeeds = form.specialNeeds();
            this.howDidYouHear = form.howDidYouHear();
            if (form.isDeleted() != null) {
                this.isDeleted = form.isDeleted();
            }
            return this;
        }

        public Builder recordId(UUID recordId) {
            this.recordId = recordId;
            return this;
        }

        public Builder branchName(String branchName) {
            this.branchName = branchName;
            return this;
        }

        public Builder status(AttendanceStaus status) {
            this.status = status;
            return this;
        }

        public Builder registrationDate(LocalDate registrationDate) {
            this.registrationDate = registrationDate;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder preferredName(String preferredName) {
            this.preferredName = preferredName;
            return this;
        }

        public Builder dateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder gender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public Builder maritalStatus(MaritalStatus maritalStatus) {
            this.maritalStatus = maritalStatus;
            return this;
        }

        public Builder residingAddress(String residingAddress) {
            this.residingAddress = residingAddress;
            return this;
        }

        public Builder primaryPhone(String primaryPhone) {
            this.primaryPhone = primaryPhone;
            return this;
        }

        public Builder secondaryPhone(String secondaryPhone) {
            this.secondaryPhone = secondaryPhone;
            return this;
        }

        public Builder emailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        public Builder occupation(String occupation) {
            this.occupation = occupation;
            return this;
        }

        public Builder employer(String employer) {
            this.employer = employer;
            return this;
        }

        public Builder spouseName(String spouseName) {
            this.spouseName = spouseName;
            return this;
        }

        public Builder spousePhone(String spousePhone) {
            this.spousePhone = spousePhone;
            return this;
        }

        public Builder fatherName(String fatherName) {
            this.fatherName = fatherName;
            return this;
        }

        public Builder fatherHometown(String fatherHometown) {
            this.fatherHometown = fatherHometown;
            return this;
        }

        public Builder fatherContact(String fatherContact) {
            this.fatherContact = fatherContact;
            return this;
        }

        public Builder motherName(String motherName) {
            this.motherName = motherName;
            return this;
        }

        public Builder motherHometown(String motherHometown) {
            this.motherHometown = motherHometown;
            return this;
        }

        public Builder motherContact(String motherContact) {
            this.motherContact = motherContact;
            return this;
        }

        public Builder emergencyContactPhone(String emergencyContactPhone) {
            this.emergencyContactPhone = emergencyContactPhone;
            return this;
        }

        public Builder emergencyContactRelationship(String emergencyContactRelationship) {
            this.emergencyContactRelationship = emergencyContactRelationship;
            return this;
        }

        public Builder dateJoinedChurch(LocalDate dateJoinedChurch) {
            this.dateJoinedChurch = dateJoinedChurch;
            return this;
        }

        public Builder baptizedWithHolySpirit(Boolean baptizedWithHolySpirit) {
            this.baptizedWithHolySpirit = baptizedWithHolySpirit;
            return this;
        }

        public Builder dateOfSalvation(LocalDate dateOfSalvation) {
            this.dateOfSalvation = dateOfSalvation;
            return this;
        }

        public Builder baptismDate(LocalDate baptismDate) {
            this.baptismDate = baptismDate;
            return this;
        }

        public Builder previousChurchAffiliation(String previousChurchAffiliation) {
            this.previousChurchAffiliation = previousChurchAffiliation;
            return this;
        }

        public Builder yearsAttended(Integer yearsAttended) {
            this.yearsAttended = yearsAttended;
            return this;
        }

        public Builder ministriesOfInterest(List<String> ministriesOfInterest) {
            this.ministriesOfInterest = ministriesOfInterest;
            return this;
        }

        public Builder spiritualGifts(List<String> spiritualGifts) {
            this.spiritualGifts = spiritualGifts;
            return this;
        }

        public Builder skills(List<String> skills) {
            this.skills = skills;
            return this;
        }

        public Builder agreeWithBibleIsInspiredWord(Boolean agreeWithBibleIsInspiredWord) {
            this.agreeWithBibleIsInspiredWord = agreeWithBibleIsInspiredWord;
            return this;
        }

        public Builder agreeWithSalvationThroughFaith(Boolean agreeWithSalvationThroughFaith) {
            this.agreeWithSalvationThroughFaith = agreeWithSalvationThroughFaith;
            return this;
        }

        public Builder agreeWithJesusSonOfGod(Boolean agreeWithJesusSonOfGod) {
            this.agreeWithJesusSonOfGod = agreeWithJesusSonOfGod;
            return this;
        }

        public Builder commitmentAttendServices(Boolean commitmentAttendServices) {
            this.commitmentAttendServices = commitmentAttendServices;
            return this;
        }

        public Builder commitmentSupportActivities(Boolean commitmentSupportActivities) {
            this.commitmentSupportActivities = commitmentSupportActivities;
            return this;
        }

        public Builder commitmentTithe(Boolean commitmentTithe) {
            this.commitmentTithe = commitmentTithe;
            return this;
        }

        public Builder commitmentLiveChristianValues(Boolean commitmentLiveChristianValues) {
            this.commitmentLiveChristianValues = commitmentLiveChristianValues;
            return this;
        }

        public Builder signatureDate(LocalDate signatureDate) {
            this.signatureDate = signatureDate;
            return this;
        }

        public Builder consentContactPermission(Boolean consentContactPermission) {
            this.consentContactPermission = consentContactPermission;
            return this;
        }

        public Builder consentPhotoUse(Boolean consentPhotoUse) {
            this.consentPhotoUse = consentPhotoUse;
            return this;
        }

        public Builder consentSignatureDate(LocalDate consentSignatureDate) {
            this.consentSignatureDate = consentSignatureDate;
            return this;
        }

        public Builder specialNeeds(String specialNeeds) {
            this.specialNeeds = specialNeeds;
            return this;
        }

        public Builder howDidYouHear(String howDidYouHear) {
            this.howDidYouHear = howDidYouHear;
            return this;
        }

        public Builder isDeleted(Boolean isDeleted) {
            this.isDeleted = isDeleted;
            return this;
        }

        public Member build() {
            return new Member(this);
        }
    }

    // Static factory method for creating a builder
    public static Builder builder() {
        return new Builder();
    }
    
    // Factory method to create a builder from an existing member
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.recordId = this.recordId;
        builder.branchName = this.branchName;
        builder.status = this.status;
        builder.registrationDate = this.registrationDate;
        builder.firstName = this.firstName;
        builder.lastName = this.lastName;
        builder.preferredName = this.preferredName;
        builder.dateOfBirth = this.dateOfBirth;
        builder.gender = this.gender;
        builder.maritalStatus = this.maritalStatus;
        builder.residingAddress = this.residingAddress;
        builder.primaryPhone = this.primaryPhone;
        builder.secondaryPhone = this.secondaryPhone;
        builder.emailAddress = this.emailAddress;
        builder.occupation = this.occupation;
        builder.employer = this.employer;
        builder.spouseName = this.spouseName;
        builder.spousePhone = this.spousePhone;
        builder.fatherName = this.fatherName;
        builder.fatherHometown = this.fatherHometown;
        builder.fatherContact = this.fatherContact;
        builder.motherName = this.motherName;
        builder.motherHometown = this.motherHometown;
        builder.motherContact = this.motherContact;
        builder.emergencyContactPhone = this.emergencyContactPhone;
        builder.emergencyContactRelationship = this.emergencyContactRelationship;
        builder.dateJoinedChurch = this.dateJoinedChurch;
        builder.baptizedWithHolySpirit = this.baptizedWithHolySpirit;
        builder.dateOfSalvation = this.dateOfSalvation;
        builder.baptismDate = this.baptismDate;
        builder.previousChurchAffiliation = this.previousChurchAffiliation;
        builder.yearsAttended = this.yearsAttended;
        builder.ministriesOfInterest = this.ministriesOfInterest;
        builder.spiritualGifts = this.spiritualGifts;
        builder.skills = this.skills;
        builder.agreeWithBibleIsInspiredWord = this.agreeWithBibleIsInspiredWord;
        builder.agreeWithSalvationThroughFaith = this.agreeWithSalvationThroughFaith;
        builder.agreeWithJesusSonOfGod = this.agreeWithJesusSonOfGod;
        builder.commitmentAttendServices = this.commitmentAttendServices;
        builder.commitmentSupportActivities = this.commitmentSupportActivities;
        builder.commitmentTithe = this.commitmentTithe;
        builder.commitmentLiveChristianValues = this.commitmentLiveChristianValues;
        builder.signatureDate = this.signatureDate;
        builder.consentContactPermission = this.consentContactPermission;
        builder.consentPhotoUse = this.consentPhotoUse;
        builder.consentSignatureDate = this.consentSignatureDate;
        builder.specialNeeds = this.specialNeeds;
        builder.howDidYouHear = this.howDidYouHear;
        builder.isDeleted = this.isDeleted;
        return builder;
    }

    // Method to create a new member with isDeleted set to the given value
    public Member withIsDeleted(boolean isDeleted) {
        return this.toBuilder().isDeleted(isDeleted).build();
    }

    // Getters
    public UUID getRecordId() {
        return recordId;
    }

    public String getBranchName() {
        return branchName;
    }

    public AttendanceStaus getStatus() {
        return status;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPreferredName() {
        return preferredName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public String getResidingAddress() {
        return residingAddress;
    }

    public String getPrimaryPhone() {
        return primaryPhone;
    }

    public String getSecondaryPhone() {
        return secondaryPhone;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getEmployer() {
        return employer;
    }

    public String getSpouseName() {
        return spouseName;
    }

    public String getSpousePhone() {
        return spousePhone;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getFatherHometown() {
        return fatherHometown;
    }

    public String getFatherContact() {
        return fatherContact;
    }

    public String getMotherName() {
        return motherName;
    }

    public String getMotherHometown() {
        return motherHometown;
    }

    public String getMotherContact() {
        return motherContact;
    }

    public String getEmergencyContactPhone() {
        return emergencyContactPhone;
    }

    public String getEmergencyContactRelationship() {
        return emergencyContactRelationship;
    }

    public LocalDate getDateJoinedChurch() {
        return dateJoinedChurch;
    }

    public Boolean getBaptizedWithHolySpirit() {
        return baptizedWithHolySpirit;
    }

    public LocalDate getDateOfSalvation() {
        return dateOfSalvation;
    }

    public LocalDate getBaptismDate() {
        return baptismDate;
    }

    public String getPreviousChurchAffiliation() {
        return previousChurchAffiliation;
    }

    public Integer getYearsAttended() {
        return yearsAttended;
    }

    public List<String> getMinistriesOfInterest() {
        return ministriesOfInterest;
    }

    public List<String> getSpiritualGifts() {
        return spiritualGifts;
    }

    public List<String> getSkills() {
        return skills;
    }

    public Boolean getAgreeWithBibleIsInspiredWord() {
        return agreeWithBibleIsInspiredWord;
    }

    public Boolean getAgreeWithSalvationThroughFaith() {
        return agreeWithSalvationThroughFaith;
    }

    public Boolean getAgreeWithJesusSonOfGod() {
        return agreeWithJesusSonOfGod;
    }

    public Boolean getCommitmentAttendServices() {
        return commitmentAttendServices;
    }

    public Boolean getCommitmentSupportActivities() {
        return commitmentSupportActivities;
    }

    public Boolean getCommitmentTithe() {
        return commitmentTithe;
    }

    public Boolean getCommitmentLiveChristianValues() {
        return commitmentLiveChristianValues;
    }

    public LocalDate getSignatureDate() {
        return signatureDate;
    }

    public Boolean getConsentContactPermission() {
        return consentContactPermission;
    }

    public Boolean getConsentPhotoUse() {
        return consentPhotoUse;
    }

    public LocalDate getConsentSignatureDate() {
        return consentSignatureDate;
    }

    public String getSpecialNeeds() {
        return specialNeeds;
    }

    public String getHowDidYouHear() {
        return howDidYouHear;
    }

    public Boolean isDeleted() {
        return isDeleted;
    }
}
