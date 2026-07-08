CREATE TABLE outbox
(
    id           UUID PRIMARY KEY,
    aggregate_id UUID    NOT NULL,
    type         VARCHAR NOT NULL,
    event_type   VARCHAR NOT NULL,
    payload      VARCHAR NOT NULL
);

CREATE TABLE payment
(
    id       UUID PRIMARY KEY
);