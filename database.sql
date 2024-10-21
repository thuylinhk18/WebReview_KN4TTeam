-- T?o c? s? d? li?u
CREATE DATABASE travel_review_website;

-- S? d?ng c? s? d? li?u v?a t?o
USE travel_review_website;

-- T?o b?ng User
CREATE TABLE Users (
    user_id INT IDENTITY(1,1) PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    fullname VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    roles VARCHAR(50) DEFAULT 'user',
    avt VARCHAR(255) DEFAULT NULL
);
select *  from Users
select userName,password,roles from Users
select userName,password,roles from Users 
                    where userName = 'sum' and password = '123'
insert into Users values ('se','JohnSon','123','johnse@gmail.com','user' ,'avt');
insert into Users values ('sum','JohnSon','123','sum@gmail.com','user' ,'avt');
insert into Users values ('se','JohnSon','123','johnse@gmail.com','user' ,'avt');
-- T?o b?ng Post
CREATE TABLE Post (
    post_id INT IDENTITY(1,1) PRIMARY KEY,
    user_id INT NOT NULL,
    title VARCHAR(255) NOT NULL,
    post_content TEXT NOT NULL,
   created_at DATETIME DEFAULT GETDATE(),
    post_img VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE CASCADE
);

-- T?o b?ng Comment
CREATE TABLE Comment (
    cmt_id INT IDENTITY(1,1) PRIMARY KEY,
    user_id INT NOT NULL,
    post_id INT NOT NULL,
    cmt_content TEXT NOT NULL,
    created_at DATETIME DEFAULT GETDATE(),
    cmt_img VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE NO ACTION,
    FOREIGN KEY (post_id) REFERENCES Post(post_id) ON DELETE NO ACTION
);

-- T?o b?ng Favorite_Post
CREATE TABLE Favorite_Post (
    favorite_id INT IDENTITY(1,1) PRIMARY KEY,
    user_id INT NOT NULL,
    post_id INT NOT NULL,
    created_at DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE NO ACTION,
    FOREIGN KEY (post_id) REFERENCES Post(post_id) ON DELETE NO ACTION
);