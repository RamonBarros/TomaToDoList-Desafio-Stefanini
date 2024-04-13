CREATE DATABASE IF NOT EXISTS stefanini_database;

\c stefanini_database;

CREATE TABLE IF NOT EXISTS tasks (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    status VARCHAR(255) NOT NULL
);