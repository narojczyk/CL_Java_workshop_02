show tables ;

describe users;

INSERT INTO users(email, username, password)
VALUES ('other_user@.kiss.my.ass.com', 'other_user', 'dummy_passwd2');

SELECT COUNT(*) FROM users;
DELETE FROM users ;

SELECT * FROM users;
