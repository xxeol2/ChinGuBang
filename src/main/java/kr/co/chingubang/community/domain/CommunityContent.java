package kr.co.chingubang.community.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommunityContent {

	@Column(nullable = false)
	private String content;

	public CommunityContent(String content) {
		this.content = content;
	}
}
