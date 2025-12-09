CREATE TABLE affiliates (
    id BIGSERIAL PRIMARY KEY,
    document_number VARCHAR(50) NOT NULL UNIQUE,
    full_name VARCHAR(150) NOT NULL,
    salary DOUBLE PRECISION NOT NULL,
    active BOOLEAN NOT NULL
);

CREATE TABLE risk_evaluations (
    id BIGSERIAL PRIMARY KEY,
    document_number VARCHAR(50) NOT NULL,
    risk_score INTEGER NOT NULL,
    risk_level VARCHAR(50) NOT NULL
);

CREATE TABLE credit_applications (
    id BIGSERIAL PRIMARY KEY,
    affiliate_id BIGINT NOT NULL,
    amount DOUBLE PRECISION NOT NULL,
    installments INTEGER NOT NULL,
    monthly_installment DOUBLE PRECISION NOT NULL,
    status VARCHAR(20) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    risk_evaluation_id BIGINT
);

CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(80) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE user_roles (
    user_id BIGINT NOT NULL,
    role VARCHAR(50) NOT NULL
);
