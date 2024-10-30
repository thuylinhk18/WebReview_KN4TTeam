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
    avt VARCHAR(255) DEFAULT NULL
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
drop table Post
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
insert into Posts(user_id,title,post_content,post_img) 
values (1,N'Qu?ng B�nh - Thi�n ???ng hang ??ng',N'Qu?ng B�nh, m?t v�ng ??t v� c�ng tuy?t v?i c?a khu v?c mi?n Trung. ??n v?i Qu?ng B�nh, c�c b?n nh? ???c b??c ch�n v�o m?t b?c tranh s?n th?y h?u t�nh, nh?ng v?n mang ??m n�t m?c m?c gi?n d? c?a m?t mi?n qu�. Qu?ng B�nh kh�ng ch? n?i ti?ng v?i phong c?nh tuy?t v?i m� c�n c� r?t nhi?u m�n ?n v� c�ng th?m ngon v� h?p d?n, b�n c?nh ?�
m?t v�i ??a danh v� c�ng n?i ti?ng c?a v�ng ??t Qu?ng B�nh: ??ng Phong Nha � K? B�ng,hang ??i T??ng, hang �n, hang S?n ?o�ng, ??ng Thi�n ???ng, bi?n Nh?t L?, bi?n B?o Ninh, c?n c�t Quang Ph��. B�n c?nh ?� c�n r?t nhi?u ??a ?i?m kh�c v� c�ng tuy?t v?i.','https://ticotravel.com.vn/wp-content/uploads/2023/10/quang-binh-thang-10-1.jpg');
