INSERT INTO user_details (id, birth_date, name)
VALUES (10001, CURRENT_DATE(), 'Caio');

INSERT INTO user_details (id, birth_date, name)
VALUES (10002, CURRENT_DATE(), 'Carlos');

INSERT INTO user_details (id, birth_date, name)
VALUES (10003, CURRENT_DATE(), 'James');


INSERT INTO POST(id,description,user_id)
values (101, 'This is a post', 10001);

INSERT INTO POST(id,description,user_id)
values (102, 'This is another post', 10001);

INSERT INTO POST(id,description,user_id)
values (103, 'Yet another post', 10002);
