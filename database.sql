-- T?o c? s? d? li?u
CREATE DATABASE travel_review_website;

-- S? d?ng c? s? d? li?u v?a t?o
USE travel_review_website;

-- T?o b?ng User
CREATE TABLE Users (
    user_id INT IDENTITY(1,1) PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    fullname NVARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    roles VARCHAR(50) DEFAULT 'user',
    avt VARCHAR(255) 
);
drop table Users

-- T?o b?ng Post
CREATE TABLE Posts (
    post_id INT IDENTITY(1,1) PRIMARY KEY,
    user_id INT NOT NULL,
    title NVARCHAR(255) NOT NULL,
    post_content  NVARCHAR(MAX) NOT NULL,
   created_at DATETIME DEFAULT GETDATE(),
    post_img VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE CASCADE
);
drop table Posts
-- T?o b?ng Comment
CREATE TABLE Comments (
    cmt_id INT IDENTITY(1,1) PRIMARY KEY,
    user_id INT NOT NULL,
    post_id INT NOT NULL,
    cmt_content TEXT NOT NULL,
    created_at DATETIME DEFAULT GETDATE(),
    cmt_img VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE NO ACTION,
    FOREIGN KEY (post_id) REFERENCES Post(post_id) ON DELETE NO ACTION
);
drop table Comment
-- T?o b?ng Favorite_Post
CREATE TABLE Favorite_Posts (
    favorite_id INT IDENTITY(1,1) PRIMARY KEY,
    user_id INT NOT NULL,
    post_id INT NOT NULL,
    created_at DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE NO ACTION,
    FOREIGN KEY (post_id) REFERENCES Post(post_id) ON DELETE NO ACTION
);
drop table  Favorite_Post
select * from Users
select * from Posts
insert into Users(username,fullname,password,email,roles) values
('admin','admin','admin','linhpttde181042@fpt.edu.vn','admin');
('user1',N'Thùy Linh','admin','linhpttde181042@fpt.edu.vn','admin')
insert into Posts(user_id,title,post_content,post_img) 
values (2,N'Quảng Bình - Thiên đường hang động',N'Quảng Bình, một vùng đất vô cùng tuyệt vời của khu vực miền Trung. Đến với Quảng Bình, các bạn như được bước chân vào một bức tranh sơn thủy hữu tình, nhưng vẫn mang đậm nét mộc mạc giản dị của một miền quê. Quảng Bình không chỉ nổi tiếng với phong cảnh tuyệt vời mà còn có rất nhiều món ăn vô cùng thơm ngon và hấp dẫn, bên cạnh đó
một vài địa danh vô cùng nổi tiếng của vùng đất Quảng Bình: động Phong Nha – Kẻ Bàng,hang Đại Tướng, hang Én, hang Sơn Đoòng, động Thiên Đường, biển Nhật Lệ, biển Bảo Ninh, cồn cát Quang Phú…. Bên cạnh đó còn rất nhiều địa điểm khác vô cùng tuyệt vời.','https://ticotravel.com.vn/wp-content/uploads/2023/10/quang-binh-thang-10-1.jpg');

