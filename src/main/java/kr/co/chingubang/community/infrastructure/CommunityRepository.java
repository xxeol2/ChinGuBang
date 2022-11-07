package kr.co.chingubang.community.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.chingubang.community.domain.Community;

@Repository
public class CommunityRepository extends JpaRepository<Community, Long> {
}
