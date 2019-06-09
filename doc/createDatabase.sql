create database cnpj;
create user cnpj@localhost identified by 'cnpj';
grant all on cnpj.* to cnpj@localhost;