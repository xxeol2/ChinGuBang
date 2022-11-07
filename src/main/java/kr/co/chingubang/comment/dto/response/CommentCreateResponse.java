package kr.co.chingubang.comment.dto.response;

public record CommentCreateResponse(
	Long commentId,
	Long communityId,
	String content,
	Long userId
) {
}
