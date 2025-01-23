CREATE TABLE outbox (
    id           UUID PRIMARY KEY,
    aggregate_id UUID    NOT NULL,
    type         VARCHAR NOT NULL,
    event_type   VARCHAR NOT NULL,
    payload      VARCHAR   NOT NULL
);

CREATE TABLE student (
    id   UUID PRIMARY KEY,
    name VARCHAR(100)
);