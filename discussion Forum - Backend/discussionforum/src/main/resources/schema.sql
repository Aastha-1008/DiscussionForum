drop table if exists discussion_tag;
drop table if exists tag;
drop table if exists discussion;
drop table if exists user;

CREATE TABLE IF NOT EXISTS user(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    mobileNumber BIGINT NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS discussion(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    text TEXT NOT NULL,
    image VARCHAR(255),
    created_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES user(id)
);

CREATE TABLE IF NOT EXISTS tag(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    tag VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS discussion_tag(
    discussion_id BIGINT,
    tag_id BIGINT,
    PRIMARY KEY(discussion_id,tag_id),
    FOREIGN KEY(discussion_id) REFERENCES discussion(id) ON DELETE CASCADE,
    FOREIGN KEY(tag_id) REFERENCES tag(id) ON DELETE CASCADE
);