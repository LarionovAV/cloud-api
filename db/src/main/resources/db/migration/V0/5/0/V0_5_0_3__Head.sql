-- Заголовок запроса
CREATE TABLE header
(
    id                    SERIAL       NOT NULL PRIMARY KEY,
    head                  VARCHAR(512)
);

ALTER TABLE request ADD COLUMN head_id INTEGER;

