ALTER TABLE `cnpj`.`cnpj` 
CHANGE COLUMN `tipo_logradouro` `tipo_logradouro` CHAR(25) NULL DEFAULT NULL ,
CHANGE COLUMN `uf` `uf` CHAR(5) NULL DEFAULT NULL ,
ADD INDEX `idx_cnpj_muni` (`uf` ASC, `municipio` ASC),
ADD INDEX `idx_cnpj_cnae` (`cnae` ASC),
ADD INDEX `idx_cnpj_situ_cada` (`situacao_cadastral` ASC, `porte` ASC);
;

