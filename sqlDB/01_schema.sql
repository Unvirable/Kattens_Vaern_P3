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
    gender varchar(50) NOT NULL CHECK ( gender IN ('HAN','HUN') ),
    cat_type varchar(50) NOT NULL CHECK ( cat_type IN ('INDE_UDE', 'KUN_INDE', 'KUN_UDE')),
    description varchar(500) NOT NULL,
    located_in varchar(50) NOT NULL CHECK ( located_in IN ('BROENDBY', 'RINGSTED', 'BILLUND', 'AALBORG', 'RINGE') ),
    availability varchar(50) NOT NULL CHECK ( availability IN ('LEDIG', 'RESERVERET', 'ADOPTERET') ),
    date_created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE catimages(
    cat_id INT PRIMARY KEY REFERENCES cats(cat_id) ON DELETE CASCADE,
    content_type varchar(50) NOT NULL,
    data BYTEA NOT NULL
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

CREATE TABLE appointments(
    appointment_id   SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL references users (user_id) ON DELETE CASCADE,
    cat_id INTEGER NOT NULL references cats (cat_id) ON DELETE CASCADE,
    appointment_time TIMESTAMP NOT NULL,
    date_created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE UNIQUE INDEX one_appointment_per_cat_per_day ON appointments(
    cat_id,((appointment_time):: date)
);
