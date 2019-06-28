/*
 Author: Hilton W. Silva
 Description: Create movies table with a csv data
*/

-- Poderia ter adicionar um ID mas ficaria desnecessario para o projeto
CREATE TABLE MOVIES AS SELECT * FROM CSVRead('target/classes/db/migration/h2/movielist.csv',null , 'fieldSeparator=;');
--- Nos dados enviados há apenas um com mais de 2 prêmios, então ele é o maior e o menor
alter table MOVIES add column id bigint default nextVal('HIBERNATE_SEQUENCE');
