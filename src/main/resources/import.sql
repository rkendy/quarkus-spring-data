-- Default data to be loaded into database.
-- Place file in classpath.
-- For data-${platform}.sql: set spring.datasource.platform
-- Check spring.jpa.hibernate.ddl-auto for conflict. Set to 'none' or 'validate'
-- To use hibernate initialization, use import.sql
INSERT INTO Produto
    (nome,valor,criacao,atualizacao)
VALUES
    ('Desktop', 10.5, sysdate(), sysdate());
INSERT INTO Produto
    (nome,valor,criacao,atualizacao)
VALUES
    ('Roteador', 5.2, sysdate(), sysdate());
INSERT INTO Produto
    (nome,valor,criacao,atualizacao)
VALUES
    ('Impressora', 5.89, sysdate(), sysdate());
INSERT INTO Produto
    (nome,valor,criacao,atualizacao)
VALUES
    ('Monitor 29', 23.00, sysdate(), sysdate());