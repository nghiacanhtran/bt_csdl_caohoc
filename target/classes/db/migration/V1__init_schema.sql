-- Create the initial schema for the PostgreSQL database

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(100) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    avatar_url TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(20) DEFAULT 'active'
);

CREATE TABLE contents (
    id SERIAL PRIMARY KEY,
    creator_id INTEGER REFERENCES users(id),
    type VARCHAR(50) NOT NULL,
    title TEXT NOT NULL,
    body TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(20) DEFAULT 'active'
);

CREATE TABLE comments (
    id SERIAL PRIMARY KEY,
    content_id INTEGER REFERENCES contents(id),
    user_id INTEGER REFERENCES users(id),
    parent_id INTEGER REFERENCES comments(id) NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(20) DEFAULT 'active'
);

CREATE TABLE reactions (
    id SERIAL PRIMARY KEY,
    comment_id INTEGER REFERENCES comments(id),
    user_id INTEGER REFERENCES users(id),
    type VARCHAR(20) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UNIQUE(comment_id, user_id)
);