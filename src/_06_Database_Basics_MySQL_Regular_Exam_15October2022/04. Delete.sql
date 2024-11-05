SELECT
    w.`id`,
    (SELECT COUNT(*) FROM `orders` WHERE `waiter_id` = w.`id`) AS `o_count`
    FROM `waiters` AS w
    HAVING `o_count` = 0;

DELETE FROM `waiters` AS w
WHERE  (SELECT COUNT(*) FROM `orders` WHERE `waiter_id` = w.`id`) = 0;