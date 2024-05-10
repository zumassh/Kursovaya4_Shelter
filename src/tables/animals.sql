CREATE TABLE Animals(
    id bigint PRIMARY KEY AUTO_INCREMENT,
    user_id bigint,
    type VARCHAR(10),
    name VARCHAR(255) NOT NULL,
    age TINYINT,
    sex CHAR(1),
    photo_id BIGINT,
    description VARCHAR(500),
    FOREIGN KEY (user_id) references Users(id),
    FOREIGN KEY (photo_id) references images(id)
);