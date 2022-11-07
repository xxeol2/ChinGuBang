package kr.co.chingubang.community.dto.request;

public record CommunityCreateRequest(
	Long communityId,
	String content,
	Long userId
) {
}