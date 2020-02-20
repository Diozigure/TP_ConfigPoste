CREATE TABLE Recette (
ID NUMBER(10) PRIMARY KEY NOT NULL,
NAME VARCHAR2(100),
DESCRIPTION VARCHAR2(100)
);

INSERT INTO Recette (ID, NAME, DESCRIPTION) VALUES (1, "Tarte aux pommes", "Une délicieuse tarte aux pommes");
INSERT INTO Recette (ID, NAME, DESCRIPTION) VALUES (2, "Tarte aux abricots", "Une délicieuse tarte aux abricots");
INSERT INTO Recette (ID, NAME, DESCRIPTION) VALUES (3, "Tarte aux fraises", "Une délicieuse tarte aux fraises");

commit;