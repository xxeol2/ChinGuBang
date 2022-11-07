package kr.co.chingubang.comment.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentContent {

	@Column(nullable = false)
	private String content;

	public CommentContent(String content) {
		this.content = content;
	}
}
