package com.rehic.members;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;


public interface MemberService {
    MemberSummaryDto addMember(MembershipRegistrationForm member);
     Page<MemberSummaryDto> getMembers(Pageable pageable);
    MemberDto getMember(UUID recordId);
    MemberDto updateMember(UUID recordId, MemberDto dto);
     void deleteMember(UUID recordId);
    Page<MemberDto> searchByName(String name, Pageable pageable);

}
