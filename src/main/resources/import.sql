insert into kitchen (id, name) values (1, 'Tailandesa');
insert into kitchen (id, name) values (2, 'Indiana');

insert into Restaurant (id, name, shipping_fee, kitchen_id) values (1, 'Thai Gourmet', 10, 1);
insert into Restaurant (id, name, shipping_fee, kitchen_id) values (2, 'Thai Delivery', 9.50, 1);
insert into Restaurant (id, name, shipping_fee, kitchen_id) values (3, 'Tuk Tuk Comida Indiana', 15,2);

insert into State (id, name) values (1, 'Minas Gerais');
insert into State (id, name) values (2, 'São Paulo');

insert into City (id, name, state_id) values (1, 'Uberlândia', 1);
insert into City (id, name, state_id) values (2, 'Belo Horizonte', 1);
insert into City (id, name, state_id) values (3, 'São Paulo', 2);

insert into Payment (id, description) values (1, 'Cartão de crédito');
insert into Payment (id, description) values (2, 'Cartão de débito');
insert into Payment (id, description) values (3, 'Dinheiro');

insert into Permission (id, name, description) values (1, 'CONSULTAR_COZINHAS', 'Permite consultar cozinhas')
insert into Permission (id, name, description) values (2, 'EDITAR_COZINHAS', 'Permite editar cozinhas');