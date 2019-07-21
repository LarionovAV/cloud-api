-- Пользователь системы
CREATE TABLE request
(
    id                    SERIAL       NOT NULL PRIMARY KEY,
    active                BOOLEAN      NOT NULL DEFAULT TRUE,
    person_id             INTEGER,

    name                  VARCHAR(128) NOT NULL DEFAULT 'NO_NAME',
    url                   VARCHAR(255) NOT NULL,
    http_status           INTEGER,
    request_type          VARCHAR(10),
    priority              SMALLINT     DEFAULT 0,
    content               varchar(4096)
);


