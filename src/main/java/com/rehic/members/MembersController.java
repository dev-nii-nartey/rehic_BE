package com.rehic.members;


import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.bind.annotation.*;


import java.util.UUID;

@RestController
@RequestMapping("/api/v1/rehic/members")
@AllArgsConstructor
@EnableSpringDataWebSupport
public class MembersController {

    private MemberService memberService;

    @PostMapping
    public MemberSummaryDto addMember(@RequestBody MembershipRegistrationForm memberRegistrationForm) {
        return memberService.addMember(memberRegistrationForm);
    }

    @GetMapping("/{id}")
    public MemberDto getMember(@PathVariable UUID id)  {
        return memberService.getMember(id) ;
    }

    @GetMapping
    public Page<MemberSummaryDto> getAllMembers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return memberService.getMembers(PageRequest.of(page, size));
    }


    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable UUID id) {
        memberService.deleteMember(id);
    }

    @PutMapping
    public MemberDto updateMember( @RequestBody MemberDto dto) {
        return memberService.updateMember(dto.getRecordId(), dto);
    }


    @GetMapping("/search")
    public Page<MemberDto> searchMembers(
            @RequestParam String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return memberService.searchByName(name, PageRequest.of(page, size));
    }

}
