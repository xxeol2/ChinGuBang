package kr.co.chingubang.community.presentation;

import org.springframework.stereotype.Controller;

import kr.co.chingubang.community.application.CommunityService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CommunityController {
	private final CommunityService communityService;
}
