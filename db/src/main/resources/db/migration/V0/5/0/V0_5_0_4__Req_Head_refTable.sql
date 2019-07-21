create table req_head_ref
(
    request_id      INTEGER     NOT NULL    REFERENCES request,
    header_id       INTEGER     NOT NULL    REFERENCES header,
    primary key (request_id, header_id)
);

alter table request drop column head_id;
