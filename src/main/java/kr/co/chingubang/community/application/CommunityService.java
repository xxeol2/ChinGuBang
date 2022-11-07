package kr.co.chingubang.community.application;

import org.springframework.stereotype.Service;

import kr.co.chingubang.community.infrastructure.CommunityRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommunityService {
	private final CommunityRepository communityRepository;
}
