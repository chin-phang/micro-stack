-- liquibase formatted sql

-- changeset aaron:1
use `micro-stack`;

CREATE TABLE `merchants` (
    `merchant_id` bigint NOT NULL AUTO_INCREMENT,
    `merchant_name` nvarchar(100) NOT NULL,
    `merchant_code` nvarchar(10) NOT NULL,
    `merchant_status` nvarchar(20) NOT NULL,
    `parent_merchant_id` bigint NULL DEFAULT NULL,
    `hierarchy_level` smallint NOT NULL DEFAULT '1',
    `created_by` nvarchar(100) NOT NULL,
    `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `last_modified_by` nvarchar(100) DEFAULT NULL,
    `last_modified_at` datetime DEFAULT NULL,
    PRIMARY KEY (`merchant_id`),
    UNIQUE KEY `uq_merchants_code` (`merchant_code`)
);

CREATE TABLE `users` (
    `user_id` bigint NOT NULL AUTO_INCREMENT,
    `username` nvarchar(100) NOT NULL,
    `password` nvarchar(50) NOT NULL,
    `user_status` nvarchar(20) NOT NULL,
    `created_by` nvarchar(100) NOT NULL,
    `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `last_modified_by` nvarchar(100) DEFAULT NULL,
    `last_modified_at` datetime DEFAULT NULL,
    PRIMARY KEY (`user_id`),
    UNIQUE KEY `uq_users_username` (`username`)
);

CREATE TABLE `roles` (
    `role_id` bigint NOT NULL AUTO_INCREMENT,
    `role_name` nvarchar(50) NOT NULL,
    PRIMARY KEY (`role_id`),
    UNIQUE KEY `uq_roles_name` (`role_name`)
);

insert into roles (`role_name`) values
('ROLE_SUPPORT_L3'),
('ROLE_SUPPORT_L2'),
('ROLE_MERCHANT_ADMIN'),
('ROLE_MERCHANT_USER'),
('ROLE_APP_USER');

CREATE TABLE `users_roles` (
    `user_id` bigint NOT NULL,
    `role_id` bigint NOT NULL,
    `created_by` nvarchar(100) NOT NULL,
    `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `last_modified_by` nvarchar(100) DEFAULT NULL,
    `last_modified_at` datetime DEFAULT NULL,
    PRIMARY KEY (`user_id`,`role_id`),
    CONSTRAINT `fk_users_roles_role_id` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`),
    CONSTRAINT `fk_users_roles_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
);

CREATE TABLE `accounts` (
    `account_id` bigint NOT NULL AUTO_INCREMENT,
    `account_no` nvarchar(20) NOT NULL,
    `account_status` nvarchar(20) NOT NULL,
    `user_id` bigint NOT NULL,
    `created_by` nvarchar(100) NOT NULL,
    `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `last_modified_by` nvarchar(100) DEFAULT NULL,
    `last_modified_at` datetime DEFAULT NULL,
    PRIMARY KEY (`account_id`),
    UNIQUE KEY `uq_accounts_account_no` (`account_no`)
);

CREATE TABLE `account_profiles` (
    `account_profile_id` bigint NOT NULL AUTO_INCREMENT,
    `account_id` bigint NOT NULL,
    `first_name` nvarchar(100) DEFAULT NULL,
    `last_name` nvarchar(100) DEFAULT NULL,
    `email` nvarchar(100) NOT NULL,
    `mobile_phone` nvarchar(20) NOT NULL,
    `address_line_1` nvarchar(255) DEFAULT NULL,
    `address_line_2` nvarchar(255) DEFAULT NULL,
    `city` nvarchar(50) DEFAULT NULL,
    `state` nvarchar(50) DEFAULT NULL,
    `postal_code` nvarchar(10) DEFAULT NULL,
    `country` nvarchar(50) DEFAULT NULL,
    `created_by` nvarchar(100) NOT NULL,
    `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `last_modified_by` nvarchar(100) DEFAULT NULL,
    `last_modified_at` datetime DEFAULT NULL,
    PRIMARY KEY (`account_profile_id`),
    UNIQUE KEY `uq_user_profiles_email` (`email`),
    UNIQUE KEY `uq_user_profiles_mobile_phone` (`mobile_phone`),
    CONSTRAINT `fk_account_profiles_account_id` FOREIGN KEY (`account_id`) REFERENCES `accounts` (`account_id`)
);

CREATE TABLE `account_balances` (
    `account_balance_id` bigint NOT NULL AUTO_INCREMENT,
    `account_id` bigint NOT NULL,
    `currency_code` nvarchar(10) NOT NULL,
    `balance_amount` bigint NOT NULL DEFAULT '0',
    `locked_balance_amount` bigint NULL DEFAULT '0',
    `available_balance_amount` bigint NOT NULL DEFAULT '0',
    `created_by` nvarchar(100) NOT NULL,
    `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `last_modified_by` nvarchar(100) DEFAULT NULL,
    `last_modified_at` datetime DEFAULT NULL,
    PRIMARY KEY (`account_balance_id`),
    CONSTRAINT `fk_account_balances_account_id` FOREIGN KEY (`account_id`) REFERENCES `accounts` (`account_id`)
);

CREATE TABLE `currencies` (
    `currency_id` bigint NOT NULL AUTO_INCREMENT,
    `currency_country` nvarchar(50) NOT NULL,
    `currency_name` nvarchar(100) NOT NULL,
    `currency_code` nvarchar(5) NOT NULL,
    `currency_decimals` smallint NOT NULL,
    `currency_symbol` nvarchar(5) NULL,
    PRIMARY KEY (`currency_id`),
    UNIQUE KEY `uq_currencies_code` (`currency_code`)
);

INSERT INTO `currencies` (`currency_country`, `currency_name`, `currency_code`, `currency_decimals`, `currency_symbol`)
VALUES
('Cambodia', 'Riel', 'KHR', 2, '៛'),
('China', 'Yuan Renminbi', 'CNY', 2, '¥'),
('Hong Kong', 'Hong Kong Dollar', 'HKD', 2, '$'),
('Macao', 'Pataca', 'MOP', 2, NULL),
('Malaysia', 'Malaysian Ringgit', 'MYR', 2, 'RM'),
('Philippines', 'Philippine Peso', 'PHP', 2, '₱'),
('Singapore', 'Singapore Dollar', 'SGD', 2, '$'),
('Thailand', 'Baht', 'THB', 2, '฿'),
('United States Of America', 'US Dollar', 'USD', 2, '$'),
('Vietnam', 'Dong', 'VND', 0, '₫');

/*CREATE TABLE `transactions` (
    `transaction_id` bigint NOT NULL AUTO_INCREMENT,
    `transaction_ref_no` nvarchar(50) NOT NULL,
    `transaction_type` nvarchar(20) NOT NULL,
    `transaction_amount` decimal(10,2) NOT NULL,
    `currency_code` nvarchar(10) NOT NULL,
    `transaction_status` nvarchar(20) NOT NULL,
    `transaction_send_user_id` bigint NOT NULL,
    `transaction_receive_user_id` bigint NOT NULL,
    `transaction_send_wallet_id` bigint NOT NULL,
    `transaction_receive_wallet_id` bigint NOT NULL,
    `created_by` nvarchar(100) NOT NULL,
    `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `last_modified_by` nvarchar(100) DEFAULT NULL,
    `last_modified_at` datetime DEFAULT NULL,
    PRIMARY KEY (`transaction_id`),
    UNIQUE KEY `uq_transaction_ref_no_type_currency_code` (`transaction_ref_no`, `transaction_type`, `transaction_currency_code`),
    CONSTRAINT `fk_transactions_sender_user_id` FOREIGN KEY (`transaction_send_user_id`) REFERENCES `users` (`user_id`),
    CONSTRAINT `fk_transactions_receive_user_id` FOREIGN KEY (`transaction_receive_user_id`) REFERENCES `users` (`user_id`),
    CONSTRAINT `fk_transactions_send_wallet_id` FOREIGN KEY (`transaction_send_wallet_id`) REFERENCES `wallets` (`wallet_id`),
    CONSTRAINT `fk_transactions_receive_wallet_id` FOREIGN KEY (`transaction_receive_wallet_id`) REFERENCES `wallets` (`wallet_id`)
);*/
