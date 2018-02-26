INSERT INTO ml.user (name, role, password, enabled)
    VALUES ('ml_admin', 'admin', 'admin', true);

INSERT INTO ml.vendor (name)
    VALUES ('AMD'), ('NVIDIA');

INSERT INTO ml.device_type (vendor_id, name, description)
    VALUES (2, 'GeForce GTX 1080', 'Architecture: NVIDIA Pascal');

INSERT INTO ml.device (device_type_id, location)
    VALUES (1, 'Luxoft NN');