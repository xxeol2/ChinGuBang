INSERT INTO user (email, nickname, is_deleted, created_at, modified_at)
VALUES ('test1@email.com', 'test1', false, now(), now()),
       ('test2@email.com', 'test2', false, now(), now());

INSERT INTO category (name, is_deleted, created_at, modified_at)
VALUES ('자유게시판', false, now(), now()),
       ('컴공게시판', false, now(), now());

INSERT INTO community (created_at, is_deleted, modified_at, content, category_id, user_id)
VALUES (now(), false, now(), 'Hello Community1', 1, 1),
       (now(), false, now(), 'Hello Community2', 1, 2);

INSERT INTO comment (created_at, is_deleted, modified_at, content, community_id, user_id)
VALUES (now(), false, now(), '댓글1', 1, 1),
       (now(), false, now(), '댓글2', 1, 2);
