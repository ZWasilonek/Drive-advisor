create database driving_advisor char set utf8mb4 collate utf8mb4_unicode_ci;

INSERT INTO `roles` VALUES (1, 'ROLE_USER'), (2, 'ROLE_ADMIN');

INSERT INTO question_answers VALUES (1,1),(1,2);
INSERT INTO answers VALUES (null, 'test2', 1, 2);
