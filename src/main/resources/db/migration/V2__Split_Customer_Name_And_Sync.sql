ALTER TABLE customer ADD first_name VARCHAR(50);
ALTER TABLE customer ADD last_name VARCHAR(50);

CREATE OR REPLACE FUNCTION extract_first_name(name VARCHAR) RETURNS VARCHAR AS $$
BEGIN
    RETURN substring(trim(name) FROM '^([^ ]+)');
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION extract_last_name(name VARCHAR) RETURNS VARCHAR AS $$
BEGIN
    RETURN substring(trim(name) FROM '([^ ]+)$');
END;
$$ LANGUAGE plpgsql;

UPDATE customer SET first_name = extract_first_name(name);
UPDATE customer SET last_name = extract_last_name(name);

CREATE OR REPLACE FUNCTION synchronize_name()
    RETURNS trigger AS
$BODY$
BEGIN
    -- If V2
    IF NEW.name IS NULL THEN
        NEW.name := NEW.first_name || ' ' || NEW.last_name;
    END IF;

    -- If V1
    IF NEW.name IS NOT NULL THEN
        NEW.first_name := extract_first_name(NEW.name);
        NEW.last_name := extract_last_name(NEW.name);
    END IF;

    RETURN NEW;
END;
$BODY$ language plpgsql;

CREATE TRIGGER syncronize_name_trigger
    BEFORE INSERT OR UPDATE
    ON customer
    FOR EACH ROW
EXECUTE PROCEDURE synchronize_name();
