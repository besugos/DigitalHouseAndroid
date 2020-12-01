CREATE TABLE Cliente (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nome VARCHAR(255)
);

CREATE TABLE Produto (
    sku INTEGER PRIMARY KEY,
    descricao VARCHAR(255)
);

CREATE TABLE Compra (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    data VARCHAR(10),
    id_cliente REFERENCES Cliente(id),
    sku_produto REFERENCES Produto(sku),
    quantidade INTEGER
);

INSERT INTO Cliente (nome) VALUES ('Jose');
INSERT INTO Cliente (nome) VALUES ('Joao');
INSERT INTO Cliente (nome) VALUES ('Maria');
INSERT INTO Cliente (nome) VALUES ('Paula');

INSERT INTO Produto VALUES (123, 'Celular');
INSERT INTO Produto VALUES (124, 'Tablet');
INSERT INTO Produto VALUES (137, 'Notebook');
INSERT INTO Produto VALUES (228, 'Desktop');

INSERT INTO Compra (data, id_cliente, sku_produto, quantidade) VALUES ('30/11/2020', 1, 123, 2);
INSERT INTO Compra (data, id_cliente, sku_produto, quantidade) VALUES ('30/11/2020', 1, 137, 1);
INSERT INTO Compra (data, id_cliente, sku_produto, quantidade) VALUES ('01/12/2020', 2, 123, 1);
INSERT INTO Compra (data, id_cliente, sku_produto, quantidade) VALUES ('01/12/2020', 2, 124, 1);
INSERT INTO Compra (data, id_cliente, sku_produto, quantidade) VALUES ('01/12/2020', 3, 228, 1);
INSERT INTO Compra (data, id_cliente, sku_produto, quantidade) VALUES ('01/12/2020', 4, 137, 4);

SELECT * FROM Compra;

SELECT * FROM Compra INNER JOIN Cliente ON Compra.id_cliente = Cliente.id;

SELECT u.nome, c.data, c.quantidade, c.sku_produto FROM Compra c INNER JOIN Cliente u ON c.id_cliente = u.id WHERE u.id=2;
