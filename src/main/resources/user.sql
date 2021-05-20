CREATE TABLE user (
  `id` UInt64,
  `user_name` String,
  `pass_word` String,
  `phone` String,
  `email` String,
  `create_time` Date DEFAULT CAST(now(),'Date'),
  `update_time` Nullable(DateTime)  -- 注意：这里的主键是不可以包含空值的，如果把主键也加Nullable会报错
) ENGINE = MergeTree(create_time,intHash32(id), 8192)

INSERT INTO user
  (id,user_name,pass_word,phone,email)
VALUES
  (1,'cicada','123','13923456789','123@com'),
  (2,'smile','234','13922226789','456@com'),
  (3,'spring','345','13966666789','789@com');

SELECT * FROM user ;
SELECT * FROM user WHERE user_name='smile' AND pass_word='234';
SELECT * FROM user WHERE id IN (1,2);
SELECT * FROM user WHERE id=1 OR id=2 OR id=3;