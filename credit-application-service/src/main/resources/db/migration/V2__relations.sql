ALTER TABLE credit_applications
    ADD CONSTRAINT fk_credit_applications_affiliate
        FOREIGN KEY (affiliate_id) REFERENCES affiliates (id);

ALTER TABLE credit_applications
    ADD CONSTRAINT fk_credit_applications_risk_evaluation
        FOREIGN KEY (risk_evaluation_id) REFERENCES risk_evaluations (id);

ALTER TABLE user_roles
    ADD CONSTRAINT fk_user_roles_user
        FOREIGN KEY (user_id) REFERENCES users (id);

CREATE INDEX idx_affiliates_document_number
    ON affiliates (document_number);

CREATE INDEX idx_credit_applications_status
    ON credit_applications (status);

CREATE INDEX idx_credit_applications_affiliate
    ON credit_applications (affiliate_id);
