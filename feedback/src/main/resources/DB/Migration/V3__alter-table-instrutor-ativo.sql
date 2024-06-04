
alter table instrutor add column ativo bool not null;
update instrutor set ativo = 1;
