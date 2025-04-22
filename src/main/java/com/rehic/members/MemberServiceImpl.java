package com.rehic.members;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@Transactional
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public MemberDto addMember(MembershipRegistrationForm form) {
        String email = form.emailAddress();
        return memberRepository.findById(email)
                .map(existing -> {
                    if (existing.isDeleted()) {
                        Member reactivated = Member.builder()
                                .fromRegistrationForm(form)
                                .isDeleted(false)
                                .build();
                        return new MemberDto(memberRepository.save(reactivated));
                    } else {
                        throw new ResponseStatusException(HttpStatus.CONFLICT, "Member already exists");
                    }
                })
                .orElseGet(() -> {
                    Member newMember = Member.builder()
                            .fromRegistrationForm(form)
                            .isDeleted(false)
                            .build();
                    return new MemberDto(memberRepository.save(newMember));
                });
    }

    @Override
    public Page<MemberSummaryDto> getMembers(Pageable pageable) {
        return memberRepository.findAllByIsDeletedFalse(pageable)
                .map(MemberSummaryDto::new);
    }

    @Override
    public MemberDto getMember(String email) {
        return memberRepository.findById(email).map(MemberDto::new).orElse(null);
    }

    @Override
    public void deleteMember(String email) {
        Member member = memberRepository.findById(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        memberRepository.save(member.withIsDeleted(true));
    }

    @Override
    public MemberDto updateMember(String email, MemberDto dto) {
        Member existing = memberRepository.findById(email)
                .filter(m -> !m.isDeleted())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        Member updated = updateFromDto(existing, dto);
        return new MemberDto(memberRepository.save(updated));
    }

    private Member updateFromDto(Member existing, MemberDto dto) {
        return Member.builder()
                .recordId(existing.getRecordId())
                .branchName(dto.getBranchName() != null ? dto.getBranchName() : existing.getBranchName())
                .status(existing.getStatus())
                .registrationDate(dto.getRegistrationDate() != null ? dto.getRegistrationDate() : existing.getRegistrationDate())
                .firstName(dto.getFirstName() != null ? dto.getFirstName() : existing.getFirstName())
                .lastName(dto.getLastName() != null ? dto.getLastName() : existing.getLastName())
                .preferredName(dto.getPreferredName() != null ? dto.getPreferredName() : existing.getPreferredName())
                .dateOfBirth(dto.getDateOfBirth() != null ? dto.getDateOfBirth() : existing.getDateOfBirth())
                .gender(dto.getGender() != null ? dto.getGender() : existing.getGender())
                .maritalStatus(dto.getMaritalStatus() != null ? dto.getMaritalStatus() : existing.getMaritalStatus())
                .residingAddress(dto.getResidingAddress() != null ? dto.getResidingAddress() : existing.getResidingAddress())
                .primaryPhone(dto.getPrimaryPhone() != null ? dto.getPrimaryPhone() : existing.getPrimaryPhone())
                .secondaryPhone(dto.getSecondaryPhone() != null ? dto.getSecondaryPhone() : existing.getSecondaryPhone())
                .emailAddress(existing.getEmailAddress())
                .occupation(dto.getOccupation() != null ? dto.getOccupation() : existing.getOccupation())
                .employer(dto.getEmployer() != null ? dto.getEmployer() : existing.getEmployer())
                .spouseName(dto.getSpouseName() != null ? dto.getSpouseName() : existing.getSpouseName())
                .spousePhone(dto.getSpousePhone() != null ? dto.getSpousePhone() : existing.getSpousePhone())
                .fatherName(dto.getFatherName() != null ? dto.getFatherName() : existing.getFatherName())
                .fatherHometown(dto.getFatherHometown() != null ? dto.getFatherHometown() : existing.getFatherHometown())
                .fatherContact(dto.getFatherContact() != null ? dto.getFatherContact() : existing.getFatherContact())
                .motherName(dto.getMotherName() != null ? dto.getMotherName() : existing.getMotherName())
                .motherHometown(dto.getMotherHometown() != null ? dto.getMotherHometown() : existing.getMotherHometown())
                .motherContact(dto.getMotherContact() != null ? dto.getMotherContact() : existing.getMotherContact())
                .emergencyContactPhone(dto.getEmergencyContactPhone() != null ? dto.getEmergencyContactPhone() : existing.getEmergencyContactPhone())
                .emergencyContactRelationship(dto.getEmergencyContactRelationship() != null ? dto.getEmergencyContactRelationship() : existing.getEmergencyContactRelationship())
                .dateJoinedChurch(dto.getDateJoinedChurch() != null ? dto.getDateJoinedChurch() : existing.getDateJoinedChurch())
                .baptizedWithHolySpirit(dto.getBaptizedWithHolySpirit() != null ? dto.getBaptizedWithHolySpirit() : existing.getBaptizedWithHolySpirit())
                .dateOfSalvation(dto.getDateOfSalvation() != null ? dto.getDateOfSalvation() : existing.getDateOfSalvation())
                .baptismDate(dto.getBaptismDate() != null ? dto.getBaptismDate() : existing.getBaptismDate())
                .previousChurchAffiliation(dto.getPreviousChurchAffiliation() != null ? dto.getPreviousChurchAffiliation() : existing.getPreviousChurchAffiliation())
                .yearsAttended(dto.getYearsAttended() != null ? dto.getYearsAttended() : existing.getYearsAttended())
                .ministriesOfInterest(dto.getMinistriesOfInterest() != null ? dto.getMinistriesOfInterest() : existing.getMinistriesOfInterest())
                .spiritualGifts(dto.getSpiritualGifts() != null ? dto.getSpiritualGifts() : existing.getSpiritualGifts())
                .skills(dto.getSkills() != null ? dto.getSkills() : existing.getSkills())
                .agreeWithBibleIsInspiredWord(existing.getAgreeWithBibleIsInspiredWord())
                .agreeWithSalvationThroughFaith(existing.getAgreeWithSalvationThroughFaith())
                .agreeWithJesusSonOfGod(existing.getAgreeWithJesusSonOfGod())
                .commitmentAttendServices(existing.getCommitmentAttendServices())
                .commitmentSupportActivities(existing.getCommitmentSupportActivities())
                .commitmentTithe(existing.getCommitmentTithe())
                .commitmentLiveChristianValues(existing.getCommitmentLiveChristianValues())
                .signatureDate(existing.getSignatureDate())
                .consentContactPermission(existing.getConsentContactPermission())
                .consentPhotoUse(existing.getConsentPhotoUse())
                .consentSignatureDate(existing.getConsentSignatureDate())
                .specialNeeds(dto.getSpecialNeeds() != null ? dto.getSpecialNeeds() : existing.getSpecialNeeds())
                .howDidYouHear(existing.getHowDidYouHear())
                .isDeleted(existing.isDeleted())
                .build();
    }

    @Override
    public Page<MemberDto> searchByName(String name, Pageable pageable) {
        return memberRepository.searchByName(name, pageable)
                .map(MemberDto::new);
    }
}
