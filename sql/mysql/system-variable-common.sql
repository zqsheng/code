SHOW  VARIABLES LIKE 'innodb_flush_log_at_trx_commit' ;

SET GLOBAL innodb_flush_log_at_trx_commit =0;

use mysql;
DROP DATABASE MINSTANCE;

CREATE DATABASE MINSTANCE DEFAULT CHARACTER SET gbk ;

USE MINSTANCE;
