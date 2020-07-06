ALTER TABLE customer DROP COLUMN name;

DROP TRIGGER IF EXISTS synchronize_name_trigger ON customer;

DROP FUNCTION IF EXISTS synchronize_name;


