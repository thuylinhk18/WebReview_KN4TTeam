-- T?o c? s? d? li?u
CREATE DATABASE travel_review_website;
go

USE travel_review_website;
go

CREATE TABLE Users (
    user_id INT IDENTITY(1,1) PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    fullname NVARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    roles VARCHAR(50) DEFAULT 'user',
    avt VARCHAR(255) 
);
go


CREATE TABLE Posts (
    post_id INT IDENTITY(1,1) PRIMARY KEY,
	isFavorite bit default 0,
    user_id INT NOT NULL,
    title NVARCHAR(255) NOT NULL,
    post_content  NVARCHAR(MAX) NOT NULL,
    post_img VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE CASCADE
);
go

select * from Posts 
select * from Users  

SELECT p.post_id, p.isFavorite, p.user_id, p.title, p.post_content, p.post_img, u.username FROM Posts p 
join Users u on u.user_id = p.user_id 
where p.title like '%a%'
or p.post_content like '%a%'
ORDER BY post_id DESC;