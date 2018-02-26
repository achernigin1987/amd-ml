CREATE SCHEMA IF NOT EXISTS ml;

CREATE TABLE IF NOT EXISTS ml.vendor (
  id SERIAL,
  name VARCHAR NOT NULL,
  CONSTRAINT pk_vendor PRIMARY KEY (id),
  CONSTRAINT uq_vendor_name UNIQUE (name)
);

CREATE TABLE IF NOT EXISTS ml.device_type (
  id SERIAL,
  vendor_id INTEGER,
  name VARCHAR NOT NULL,
  description VARCHAR,
  CONSTRAINT pk_device_type PRIMARY KEY (id),
  CONSTRAINT fk_vendor_id FOREIGN KEY (vendor_id) REFERENCES ml.vendor(id) ON DELETE RESTRICT,
  CONSTRAINT uq_device_type_vendor_id_name UNIQUE (vendor_id, name)
);

CREATE TABLE IF NOT EXISTS ml.device (
  id  BIGSERIAL,
  device_type_id INTEGER,
  location VARCHAR,
  CONSTRAINT pk_device PRIMARY KEY (id),
  CONSTRAINT fk_device_type_id FOREIGN KEY (device_type_id) REFERENCES ml.device_type(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS ml.user (
  id BIGSERIAL,
  name VARCHAR(255) NOT NULL,
  role VARCHAR(255) DEFAULT 'USER',
  password VARCHAR(1024) NOT NULL,
  enabled BOOLEAN NOT NULL,
  CONSTRAINT pk_user PRIMARY KEY (id),
  CONSTRAINT uq_name UNIQUE (name)
);

CREATE TABLE IF NOT EXISTS ml.feature (
  id BIGSERIAL,
  name VARCHAR NOT NULL,
  path VARCHAR NOT NULL,
  CONSTRAINT pk_feature PRIMARY KEY (id),
  CONSTRAINT uq_feature_path UNIQUE (path)
);

CREATE TABLE IF NOT EXISTS ml.model_info (
  id BIGSERIAL,
  source_code_path VARCHAR NOT NULL,
  description VARCHAR,
  CONSTRAINT pk_model_info PRIMARY KEY (id),
  CONSTRAINT uq_model_info_source_code_path UNIQUE (source_code_path)
);

CREATE TABLE IF NOT EXISTS ml.model_info_feature (
  model_info_id BIGINT,
  feature_id BIGINT,
  CONSTRAINT fk_model_info_id FOREIGN KEY (model_info_id) REFERENCES ml.model_info(id) ON DELETE CASCADE,
  CONSTRAINT fk_feature_id FOREIGN KEY (feature_id) REFERENCES ml.feature(id) ON DELETE RESTRICT
);

CREATE INDEX ix_model_info_feature_model_info_id ON ml.model_info_feature (model_info_id);

CREATE TYPE training_status AS ENUM ('DRAFT', 'IN_PROGRESS', 'FINISHED', 'CANCELED', 'FAILED');

CREATE TABLE IF NOT EXISTS ml.training (
  id BIGSERIAL,
  model_info_id BIGINT,
  model_params VARCHAR NOT NULL,
  created_at TIMESTAMP NOT NULL,
  started_at TIMESTAMP,
  finished_at TIMESTAMP,
  status training_status NOT NULL,
  user_id BIGINT,
  description VARCHAR,
  CONSTRAINT pk_training PRIMARY KEY (id),
  CONSTRAINT fk_model_info_id FOREIGN KEY (model_info_id) REFERENCES ml.model_info(id) ON DELETE RESTRICT,
  CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES ml.user(id) ON DELETE RESTRICT
);

CREATE TABLE IF NOT EXISTS ml.training_device (
  training_id BIGINT,
  device_id BIGINT,
  CONSTRAINT fk_training_id FOREIGN KEY (training_id) REFERENCES ml.training(id) ON DELETE CASCADE,
  CONSTRAINT fk_device_id FOREIGN KEY (device_id) REFERENCES ml.device(id) ON DELETE RESTRICT
);

CREATE TABLE IF NOT EXISTS ml.model (
  id BIGSERIAL,
  model_info_id BIGINT,
  training_id BIGINT,
  path VARCHAR NOT NULL,
  CONSTRAINT pk_model PRIMARY KEY (id),
  CONSTRAINT fk_model_info_id FOREIGN KEY (model_info_id) REFERENCES ml.model_info(id) ON DELETE RESTRICT,
  CONSTRAINT fk_training_id FOREIGN KEY (training_id) REFERENCES ml.training(id) ON DELETE RESTRICT
);

CREATE INDEX ix_training_device_training_id ON ml.training_device (training_id);