CREATE TABLE users(
    user_id SERIAL PRIMARY KEY,
    user_type varchar(50) NOT NULL DEFAULT 'user',
    password_hash VARCHAR(255) NOT NULL,
    enabled BOOLEAN NOT NULL DEFAULT TRUE
    
);

CREATE TABLE cats(
    cat_id SERIAL PRIMARY KEY,
    name varchar(50) NOT NULL,
    birthday DATE NOT NULL,
    gender varchar(50) NOT NULL,
    catType varchar(50) NOT NULL,
    description varchar(500) NOT NULL,
    located_in varchar(50) NOT NULL,
    availability varchar(50) NOT NULL,
    date_created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE userInfo(
    user_info_id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL UNIQUE references users (user_id),
    name varchar(80) NOT NULL,
    email varchar(200) NOT NULL UNIQUE,
    phonenumber varchar(20) NOT NULL UNIQUE,
    age integer NOT NULL,
    address varchar(200) NOT NULL,
    date_created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE membership(
    membership_id SERIAL PRIMARY KEY,
    is_member BOOLEAN NOT NULL,
    membership_number varchar(200) NOT NULL,
    user_id INTEGER NOT NULL UNIQUE references users (user_id),
    date_created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE adoptionRecord(
    adoption_record_id SERIAL PRIMARY KEY,
    user_id INTEGER references users(user_id),
    cat_id INTEGER references cats(cat_id),
    date_created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE medicalRecord(
    medical_record_id SERIAL PRIMARY KEY,
    cat_id INTEGER references cats(cat_id),
    record_type varchar(200) NOT NULL,
    description varchar(500) NOT NULL,
    next_dueDate DATE NOT NULL,
    date_created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE newsArticles(
    news_article_id SERIAL PRIMARY KEY,
    title varchar(200) NOT NULL,
    content TEXT NOT NULL,
    published_by varchar(200) NOT NULL,
    date_created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);