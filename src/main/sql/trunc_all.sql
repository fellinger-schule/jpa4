TRUNCATE ticket CASCADE;
TRUNCATE show CASCADE;
TRUNCATE movie CASCADE;
TRUNCATE hall CASCADE;
TRUNCATE customer CASCADE;
TRUNCATE employee CASCADE;

ALTER SEQUENCE hibernate_sequence RESTART 1000;
ALTER SEQUENCE hibernate_sequence START 1000;
ALTER SEQUENCE hibernate_sequence MINVALUE 1000;