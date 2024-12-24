DROP PROCEDURE if EXISTS order_delivery_sys.InsertBulkUsers;

DELIMITER //

CREATE PROCEDURE order_delivery_sys.InsertBulkUsers()
BEGIN
    DECLARE i INT DEFAULT 101;

    WHILE i <= 2000 DO
        INSERT INTO `users` (`id`, `name`, `username`, `password`, `email`, `phone_no`, `profile_photo`, `credits`) 
        VALUES (CONCAT('user', i), CONCAT('user', i), CONCAT('user', i), 'user123', 'user@gmail.com', '9999999999', '', 50000.22);
        SET i = i + 1;
    END WHILE;
END //

DELIMITER ;

call InsertBulkUsers;
