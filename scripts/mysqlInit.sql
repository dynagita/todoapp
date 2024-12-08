-- Create the keycloak database (if it doesn't exist already)
CREATE DATABASE IF NOT EXISTS keycloak;

-- Create the todoapp database (if it doesn't exist already)
CREATE DATABASE IF NOT EXISTS todoapp;

-- Grant all privileges for the 'mysql' user on both databases
GRANT ALL PRIVILEGES ON keycloak.* TO 'mysql'@'%';
GRANT ALL PRIVILEGES ON todoapp.* TO 'mysql'@'%';

-- Apply the privilege changes
FLUSH PRIVILEGES;
