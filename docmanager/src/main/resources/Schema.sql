create table IF NOT EXISTS document
(
   id integer not null,
   file clob not null,
   primary key(id)
);