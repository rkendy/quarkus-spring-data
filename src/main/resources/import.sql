-- Default data to be loaded into database.
-- Place file in classpath.
-- For data-${platform}.sql: set spring.datasource.platform
-- Check spring.jpa.hibernate.ddl-auto for conflict. Set to 'none' or 'validate'
-- To use hibernate initialization, use import.sql
INSERT INTO Produto (nome,valor) VALUES ('Desktop', 10.5);
INSERT INTO Produto (nome,valor) VALUES ('Roteador', 5.2);
INSERT INTO Produto (nome,valor) VALUES ('Impressora', 5.89);
INSERT INTO Produto (nome,valor) VALUES ('Monitor 29', 23.00);