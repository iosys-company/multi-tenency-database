CREATE TABLE language (
  id              INT     UNSIGNED    NOT NULL    AUTO_INCREMENT,
  name            VARCHAR(100)        NOT NULL,
  code            VARCHAR(50)         NOT NULL,
  lcid            VARCHAR(50)         NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO language (name, code, lcid)
VALUES
('English - United States', 'en', 'en-us'),
('French - Switzerland', 'fr', 'fr-ch'),
('Korean', 'ko', 'ko'),
('Spanish - Mexico', 'es', 'es-mx');