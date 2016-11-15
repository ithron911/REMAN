CREATE DATABASE REMAN;
USE REMAN;

CREATE USER "RemanDeveloper"@"localhost" IDENTIFIED BY "RemanPass";

GRANT *.* TO "RemanDeveloper"@"localhost";