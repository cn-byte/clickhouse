CREATE TABLE `order` (
  `id` UInt64,
  `user_id` UInt64,
  `title` String,
  `price` Float64,
  `create_time` Date DEFAULT CAST(now(),'Date'),
  `update_time` Nullable(DateTime)  -- 注意：这里的主键是不可以包含空值的，如果把主键也加Nullable会报错
) ENGINE = MergeTree(create_time,intHash32(id), 8192)

INSERT INTO `order`
  (id,user_id,title,price)
VALUES
  (1,1,'苹果Test手机',1000.88),
  (2,1,'华为Bbc手机',1560.99),
  (3,1,'void手机',1000.00),
  (3,2,'电信Vvo手机',1305.15),
  (3,3,'联想Abc手机',1450.66),
  (3,3,'爱立信ROv手机',1809.22);

SELECT * FROM `order` ;
SELECT * FROM `order` WHERE title='smile' AND title='234';
SELECT * FROM `order` WHERE user_id IN (1,2);
SELECT * FROM `order` WHERE id=1 OR id=2 OR id=3;