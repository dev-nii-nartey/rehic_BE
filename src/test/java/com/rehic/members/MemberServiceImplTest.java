import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MemberServiceImplTest {
    private MemberServiceImpl memberService;
    private MemberRepository memberRepository;

    @BeforeEach
    void setUp() {
        memberRepository = mock(MemberRepository.class);
        memberService = new MemberServiceImpl(memberRepository);
    }

    @Test
    void testHelloWorld() {
        assertEquals("Hello, World!", memberService.helloWorld());
    }
}