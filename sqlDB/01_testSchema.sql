CREATE TABLE testtest(
    id SERIAL PRIMARY KEY,
    testName VARCHAR(100) NOT NULL,
    testMail VARCHAR(50) NOT NULL,
    testPhone VARCHAR(11) NOT NULL
);

CREATE TABLE catsTest(
    id SERIAL PRIMARY KEY,
    name varchar(100) NOT NULL,
    age integer NOT NULL,
    city varchar(100) NOT NULL,
    description varchar(500) NOT NULL
);

CREATE TABLE NewsArticles(
    id SERIAL PRIMARY KEY,
    title varchar(100) NOT NULL,
    content TEXT NOT NULL, -- tror det er sådan man viser texten/nyhedsteksten
    date DATE NOT NULL,
    imageUrl varchar(500) -- vis billede
);                     