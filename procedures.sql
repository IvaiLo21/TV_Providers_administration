DELIMITER $$
DROP PROCEDURE IF EXISTS increase_cost_of_services$$
CREATE DEFINER=`root`@`localhost` PROCEDURE increase_cost_of_services(IN prov_name VARCHAR(64), IN increase_amount DOUBLE)
BEGIN
	UPDATE providers SET service_cost= service_cost + (service_cost * (increase_amount)/100) where name_of_provider=prov_name;
END$$
DELIMITER ;


DELIMITER $$
DROP PROCEDURE IF EXISTS decrease_cost_of_services$$
CREATE DEFINER=`root`@`localhost` PROCEDURE decrease_cost_of_services(IN prov_name VARCHAR(64), IN decrease_amount DOUBLE)
BEGIN
	UPDATE providers SET service_cost= service_cost - (service_cost * (decrease_amount)/100) where name_of_provider=prov_name;
END$$
DELIMITER ;
