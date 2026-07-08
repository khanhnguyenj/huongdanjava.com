CREATE TABLE outbox
(
    id           UUID PRIMARY KEY,
    aggregate_id UUID    NOT NULL,
    type         VARCHAR NOT NULL,
    event_type   VARCHAR NOT NULL,
    payload      VARCHAR NOT NULL
);

CREATE TABLE orders
(
    id     UUID PRIMARY KEY,
    status VARCHAR(30)
);

CREATE TABLE saga_instance
(
    id       UUID PRIMARY KEY,
    order_id UUID,
    state    VARCHAR(30)
);