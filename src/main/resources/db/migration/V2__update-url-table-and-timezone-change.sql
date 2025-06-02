ALTER DATABASE urlshortener SET timezone to 'UTC';

ALTER TABLE url
ADD COLUMN use_count INTEGER,
ADD COLUMN lifetime INTEGER,
ADD COLUMN created_at TIMESTAMPTZ;

UPDATE url SET use_count = 0 WHERE use_count IS NULL;
UPDATE url SET lifetime = 0 WHERE lifetime IS NULL;
UPDATE url SET created_at = NOW() WHERE created_at IS NULL;

ALTER TABLE url ALTER COLUMN lifetime SET NOT NULL;
ALTER TABLE url ALTER COLUMN created_at SET NOT NULL;