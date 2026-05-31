CREATE TABLE `order`
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    order_id VARCHAR(64) UNIQUE NOT NULL,
    user_id VARCHAR(30),
    amount DECIMAL,
    status VARCHAR(16) NOT NULL
);