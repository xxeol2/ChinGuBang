package kr.co.chingubang.community.dto.response;

public record CommunityCreateResponse(
	Long communityId,
	String content,
	Long userId
) {
}
