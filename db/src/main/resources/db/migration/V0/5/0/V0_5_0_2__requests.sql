-- Пользователь системы
CREATE TABLE request
(
    id                    SERIAL       NOT NULL PRIMARY KEY,
    active                BOOLEAN      NOT NULL DEFAULT TRUE,

    name                  VARCHAR(128) NOT NULL DEFAULT 'NO_NAME',
    url                   VARCHAR(255) NOT NULL,
    http_status           INTEGER,
    request_type          VARCHAR(10)  NOT NULL DEFAULT 'GET',
    priority              SMALLINT     DEFAULT 0
);


