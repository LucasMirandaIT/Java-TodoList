-- Create status table
CREATE TABLE IF NOT EXISTS status (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE
);

-- Create task table
CREATE TABLE IF NOT EXISTS task (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    due_date DATE,
    status_id BIGINT,
    FOREIGN KEY (status_id) REFERENCES status(id)
);

-- Insert ENUMs as data
INSERT IGNORE INTO status (name) VALUES ('PENDING');
INSERT IGNORE INTO status (name) VALUES ('IN_PROGRESS');
INSERT IGNORE INTO status (name) VALUES ('COMPLETED');
INSERT IGNORE INTO status (name) VALUES ('CANCELED');