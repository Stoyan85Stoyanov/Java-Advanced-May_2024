 INSERT INTO `property_transactions` (`property_id`, `buyer_id`, `transaction_date`, `bank_name`, `iban`, `is_successful`)
 SELECT p.`agent_id` + DAY(p.`offer_datetime`),
        p.`agent_id` + MONTH(p.`offer_datetime`),
        DATE(p.`offer_datetime`),
        CONCAT('Bank ', p.`agent_id`),
        CONCAT('BG', p.`price`, p.`agent_id`),
       1
 FROM `property_offers` AS p
 WHERE p.`agent_id` <= 2;