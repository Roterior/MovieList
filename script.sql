CREATE TABLE Movie (
imdbId NVARCHAR2(255) PRIMARY KEY,
mType NVARCHAR2(255) NOT NULL,
title NVARCHAR2(255) NOT NULL,
genre NVARCHAR2(255) NOT NULL,
isAdult CHAR(1) CHECK (isAdult IN ('N','Y')) NOT NULL,
releaseYear NUMBER(4,0) NOT NULL,
rating NUMBER(2,1) NOT NULL,
mDescription NVARCHAR2(255) NULL
);

CREATE TABLE Review (
rId NUMBER PRIMARY KEY,
imdbId NVARCHAR2(255) NOT NULL,
login NVARCHAR2(255) NOT NULL,
dateCreate DATE NOT NULL,
rating NUMBER(2,1) NOT NULL,
rDescription NVARCHAR2(255) NOT NULL
);

CREATE TABLE CUSTOMER (
login NVARCHAR2(255) PRIMARY KEY,
pass NVARCHAR2(255) NOT NULL,
fName NVARCHAR2(255) NULL
);

CREATE TABLE TitleType (
TitleType NVARCHAR2(255) PRIMARY KEY
);

CREATE TABLE Genre (
GENRE NVARCHAR2(255) PRIMARY KEY
);

ALTER TABLE REVIEW
ADD CONSTRAINT REVIEW_IMDBID_FK
FOREIGN KEY (IMDBID) REFERENCES MOVIE (IMDBID);

ALTER TABLE REVIEW
ADD CONSTRAINT REVIEW_LOGIN_FK
FOREIGN KEY (LOGIN) REFERENCES "USER" (LOGIN);

CREATE SEQUENCE REVIEW_RID_SEQ START WITH 1;

INSERT INTO CUSTOMER (LOGIN,PASS,FNAME) VALUES ('admin','123','Alexander');
INSERT INTO CUSTOMER (LOGIN,PASS,FNAME) VALUES ('moder','qwerty','Vadim');
INSERT INTO CUSTOMER (LOGIN,PASS,FNAME) VALUES ('ed12','cat33','Edward');

INSERT INTO MOVIE (IMDBID,MTYPE,TITLE,GENRE,ISADULT,RELEASEYEAR,RATING,MDESCRIPTION) VALUES ('tt1270797', 'Movie', 'Venom', 'Thriller', 'Y', 2018, 7.0, 'Marvel Comics character');
INSERT INTO MOVIE (IMDBID,MTYPE,TITLE,GENRE,ISADULT,RELEASEYEAR,RATING,MDESCRIPTION) VALUES ('tt1520211', 'TV Series', 'The Walking Dead', 'Apocalypse', 'Y', 2010, 8.4, 'American post-apocalyptic horror');
INSERT INTO MOVIE (IMDBID,MTYPE,TITLE,GENRE,ISADULT,RELEASEYEAR,RATING,MDESCRIPTION) VALUES ('tt0111161', 'Movie', 'The Shawshank Redemption', 'Drama', 'Y', 1994, 9.3, 'Fear can hold you prisoner');
INSERT INTO MOVIE (IMDBID,MTYPE,TITLE,GENRE,ISADULT,RELEASEYEAR,RATING,MDESCRIPTION) VALUES ('tt0910970', 'Movie', 'WALL-E', 'Adventure', 'N', 2008, 8.4, 'The newest sensation in waste allocation');
INSERT INTO MOVIE (IMDBID,MTYPE,TITLE,GENRE,ISADULT,RELEASEYEAR,RATING,MDESCRIPTION) VALUES ('tt1049413', 'Movie', 'Up', 'Adventure', 'N', 2009, 8.3, 'Fly Up to Venezuela');
INSERT INTO MOVIE (IMDBID,MTYPE,TITLE,GENRE,ISADULT,RELEASEYEAR,RATING,MDESCRIPTION) VALUES ('tt0185906', 'TV Series', 'Band of Brothers', 'Action', 'Y', 2001, 9.5, 'Ordinary men. Extraordinary times.');

INSERT INTO REVIEW (IMDBID,LOGIN,DATECREATE,RATING,RDESCRIPTION) VALUES ('tt1270797','admin','12-10-2018',6.1,'hello');

INSERT INTO GENRE (GENRE) VALUES ('Thriller');
INSERT INTO GENRE (GENRE) VALUES ('Apocalypse');
INSERT INTO GENRE (GENRE) VALUES ('Drama');
INSERT INTO GENRE (GENRE) VALUES ('Adventure');
INSERT INTO GENRE (GENRE) VALUES ('Action');

INSERT INTO TITLETYPE (TITLETYPE) VALUES ('Movie');
INSERT INTO TITLETYPE (TITLETYPE) VALUES ('TV Series');
