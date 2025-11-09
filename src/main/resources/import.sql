-- Category
insert into tb_category(name) values ('Violões');
insert into tb_category(name) values ('Guitarras');
insert into tb_category(name) values ('Baterias');
insert into tb_category(name) values ('Teclados');
insert into tb_category(name) values ('Acessórios');

-- Payment
insert into tb_payment(name) values ('PIX');
insert into tb_payment(name) values ('CREDITO');
insert into tb_payment(name) values ('DEBITO');
insert into tb_payment(name) values ('BOLETO');


-- Product
insert into tb_product(name, description, price, url_image, quantity_available_in_stock, category_id) values ('Guitarra Fender Stratocaster','Guitarra Fender Stratocaster American Standard, corpo em alder, 3 captadores single coil.',8990.00,'https://images.tcdn.com.br/img/img_prod/1205809/guitarra_fender_american_professional_ii_stratocaster_olympic_white_731_1_eb6cd520bbc637dbda3e197f067b3aea_20230816083715.jpg',8,2);
insert into tb_product(name, description, price, url_image, quantity_available_in_stock, category_id) values ('Violão Yamaha C40','Violão clássico Yamaha C40II com tampo em spruce e encordoamento de nylon, ideal para iniciantes e estudantes.',1049.00,'https://m.media-amazon.com/images/I/71vm3UsQ+qL._AC_UF1000,1000_QL80_.jpg',15,1);
insert into tb_product(name, description, price, url_image, quantity_available_in_stock, category_id) values ('Teclado Yamaha PSR-E373','Teclado portátil de 61 teclas sensíveis ao toque, com 622 timbres, modos de aprendizagem e conexão USB-MIDI.',2199.99,'https://m.media-amazon.com/images/I/61UqsfhAdIL._AC_UF1000,1000_QL80_.jpg',12,4);
insert into tb_product(name, description, price, url_image, quantity_available_in_stock, category_id) values ('Teclado Controlador MIDI AKAI MPK Mini MK3','Controlador MIDI com 25 teclas, 8 pads MPC e knobs programáveis, ideal para produção musical.',1299.00,'https://m.media-amazon.com/images/I/71VEzfezCsL._AC_UF1000,1000_QL80_.jpg',18,4);
insert into tb_product(name, description, price, url_image, quantity_available_in_stock, category_id) values ('Cabo P10 Santo Angelo 5m','Cabo P10 mono 5 metros, blindagem dupla e conectores banhados a níquel, ideal para instrumentos e amplificadores.',119.90,'https://http2.mlstatic.com/D_NQ_NP_964650-MLB83680679021_042025-O-cabo-instrumento-musical-santo-angelo-5m-p10-machomacho.webp',35,5);
insert into tb_product(name, description, price, url_image, quantity_available_in_stock, category_id) values ('Pedal Boss DS-1 Distortion','Pedal de distorção clássico Boss DS-1 com controles de tone, level e distortion, som icônico do rock.',599.00,'https://m.media-amazon.com/images/I/610ZtA187JL._AC_UF1000,1000_QL80_.jpg',20,5);
insert into tb_product(name, description, price, url_image, quantity_available_in_stock, category_id) values ('Bateria Acústica Pearl Export','Bateria acústica Pearl Export EXX705 com 5 peças e ferragens completas, acabamento Jet Black.',7899.99,'https://cdnbatera.bateraclube.com.br/files/122/MED_bateria-pearl-export-exx-series-mahogany-pure-white-228101216-shell-pack2.jpg',6,3);
insert into tb_product(name, description, price, url_image, quantity_available_in_stock, category_id) values ('Bateria Eletrônica Roland TD-1DMK','Bateria eletrônica Roland TD-1DMK com pads de dupla malha, sons realistas e conexão USB MIDI.',6490.00,'https://www.lojafiladelfia.com.br/img/products/1000469/000.jpg',10,3);

-- User - password: 123456
INSERT INTO tb_user(display_name, email, password) VALUES ('Administrador', 'admin@teste.com','$2a$10$LOqePml/koRGsk2YAIOFI.1YNKZg7EsQ5BAIuYP1nWOyYRl21dlne');
INSERT INTO tb_user(display_name, email, password) VALUES ('Teste', 'test@teste.com','$2a$10$LOqePml/koRGsk2YAIOFI.1YNKZg7EsQ5BAIuYP1nWOyYRl21dlne');

-- User Roles
-- Atribui a role 'ADMIN' para o usuário com id 1 (admin@teste.com)
INSERT INTO tb_user_roles(user_id, role) VALUES (1, 'ADMIN');
-- Atribui a role 'USER' para o usuário com id 2 (test@teste.com)
INSERT INTO tb_user_roles(user_id, role) VALUES (2, 'USER');

-- Adrress
insert into tb_address(user_id, street, number, complement, neighborhood, city, state, cep) values (1, 'Rua das Palmeiras', '120', 'Apto 301', 'Centro', 'Pato Branco', 'PR', '85501000');
INSERT INTO tb_address (user_id, street, number, complement, neighborhood, city, state, cep) VALUES (1, 'Avenida Brasil', '950', NULL, 'Bela Vista', 'Curitiba', 'PR', '80010020');
INSERT INTO tb_address (user_id, street, number, complement, neighborhood, city, state, cep) VALUES (2, 'Rua XV de Novembro', '45', 'Casa 2', 'São Cristóvão', 'Londrina', 'PR', '86010150');
INSERT INTO tb_address (user_id, street, number, complement, neighborhood, city, state, cep) VALUES (2, 'Travessa das Acácias', '78', NULL, 'Jardim América', 'Maringá', 'PR', '87020200');


-- Order
-- Pedido 1 do usuário 1 (usando o endereço 'Rua das Palmeiras')
INSERT INTO tb_order (data, user_id, address_street, address_number, address_complement, address_neighborhood, address_city, address_state, address_cep, payment_id) VALUES (NOW(), 1, 'Rua das Palmeiras', '120', 'Apto 301', 'Centro', 'Pato Branco', 'PR', '85501000', 1);

-- Pedido 2 do usuário 1 (usando o endereço 'Avenida Brasil')
INSERT INTO tb_order (data, user_id, address_street, address_number, address_complement, address_neighborhood, address_city, address_state, address_cep, payment_id) VALUES (NOW(), 1, 'Avenida Brasil', '950', NULL, 'Bela Vista', 'Curitiba', 'PR', '80010020', 2);

-- Pedido 3 do usuário 2 (usando o endereço 'Rua XV de Novembro')
INSERT INTO tb_order (data, user_id, address_street, address_number, address_complement, address_neighborhood, address_city, address_state, address_cep, payment_id) VALUES (NOW(), 2, 'Rua XV de Novembro', '45', 'Casa 2', 'São Cristóvão', 'Londrina', 'PR', '86010150', 3);

-- Pedido 4 do usuário 2 (usando o endereço 'Travessa das Acácias')
INSERT INTO tb_order (data, user_id, address_street, address_number, address_complement, address_neighborhood, address_city, address_state, address_cep, payment_id) VALUES (NOW(), 2, 'Travessa das Acácias', '78', NULL, 'Jardim América', 'Maringá', 'PR', '87020200', 4);


-- OrderItem
-- Itens do Pedido 1
INSERT INTO tb_order_item (order_id, product_id, total_price, quantity) VALUES (1, 1, 3980.00, 2); -- 2x produto 1
INSERT INTO tb_order_item (order_id, product_id, total_price, quantity) VALUES (1, 2, 2449.00, 1); -- 1x produto 2

-- Itens do Pedido 2
INSERT INTO tb_order_item (order_id, product_id, total_price, quantity) VALUES (2, 3, 2259.98, 2); -- 2x produto 3

-- Itens do Pedido 3
INSERT INTO tb_order_item (order_id, product_id, total_price, quantity) VALUES (3, 4, 199.00, 1); -- 1x produto 4
INSERT INTO tb_order_item (order_id, product_id, total_price, quantity) VALUES (3, 1, 7960.00, 4); -- 4x produto 1

-- Itens do Pedido 4
INSERT INTO tb_order_item (order_id, product_id, total_price, quantity) VALUES (4, 2, 4898.00, 2); -- 2x produto 2
