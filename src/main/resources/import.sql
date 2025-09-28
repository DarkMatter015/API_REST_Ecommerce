-- Category
insert into tb_category(name) values ('Informática');
insert into tb_category(name) values ('UD');
insert into tb_category(name) values ('Cozinha');
insert into tb_category(name) values ('Móveis');
insert into tb_category(name) values ('Eletrônico');

-- Product
insert into tb_product(name, description, price, url_image, category_id) values ('Refrigerador 429L','Refrigerador 429L Branco, duplex....',1990.0, 'https://cdn.leroymerlin.com.br/products/geladeira_brastemp_frost_free_duplex_429_litros_branca_com_tw_1552511408_5919_600x600.jpg', 2);
insert into tb_product(name, description, price, url_image, category_id) values ('Notebook Arus 15.6','Notebook Arus 15.6 Core I7, 16Gb Ram...',2449.0, 'https://m.media-amazon.com/images/I/61FDo2FhQDL._UF894,1000_QL80_.jpg',1);
insert into tb_product(name, description, price, url_image, category_id) values ('Monitor 27pol','Monitor Gamer 27pol 144Hz, 1ms',1129.99, 'https://media.pichau.com.br/media/catalog/product/cache/2f958555330323e505eba7ce930bdf27/2/7/27gn65r-bawzm2.jpg', 1);
insert into tb_product(name, description, price, url_image, category_id) values ('Kit Teclado e Mouse','Kit com teclado ABNT e mouse com 5 botões',199.0, 'https://images.tcdn.com.br/img/img_prod/406359/combo_teclado_abnt2_led_rainbow_anti_ghosting_mouse_4_botoes_2400dpi_clanm_blacknox_gamer_7167_1_06ecde1b62c217264faed7caca9a73d0.jpg', 1);
insert into tb_product(name, description, price, url_image, category_id) values ('Smartphone XYZ','Smatphone com tela de 9pol, 12GB....',9999.0, 'https://imgs.casasbahia.com.br/1570518802/1xg.jpg', 5);
insert into tb_product(name, description, price, url_image, category_id) values ('TV LCD 75pol','TV LCD 75pol, 5 HDMI...',7555.0, 'https://i.zst.com.br/thumbs/12/27/e/-1103503572.jpg', 5);
insert into tb_product(name, description, price, url_image, category_id) values ('Fogão 6 Bocas','Fogão 6 Bocas em aço inox, ...', 799.99, 'https://consul.vtexassets.com/arquivos/ids/230022-800-800?v=637976381016900000&width=800&height=800&aspect=true', 3);
insert into tb_product(name, description, price, url_image, category_id) values ('Roteador Wi-Fi 5.4GhZ','Roteador Wi-Fi 5.4GhZ, 6 antenas...',1299.0, 'https://img.kalunga.com.br/fotosdeproducts/610540z_1.jpg', 1);

-- User - password: 123
INSERT INTO tb_user(username, email, password) VALUES ('Administrador', 'admin@teste.com','$2a$10$.PVIfB07x.SfMYTcToxL0.yxcLWU0GbS2NUO1W1QAvqMm/TsFhVem');
INSERT INTO tb_user(username, email, password) VALUES ('Teste', 'test@teste.com','$2a$10$.PVIfB07x.SfMYTcToxL0.yxcLWU0GbS2NUO1W1QAvqMm/TsFhVem');

-- Adrress
insert into tb_address(user_id, street, number, complement, neighborhood, city, state, cep) values (1, 'Rua das Palmeiras', '120', 'Apto 301', 'Centro', 'Pato Branco', 'PR', '85501-000');
INSERT INTO tb_address (user_id, street, number, complement, neighborhood, city, state, cep) VALUES (1, 'Avenida Brasil', '950', NULL, 'Bela Vista', 'Curitiba', 'PR', '80010-020');
INSERT INTO tb_address (user_id, street, number, complement, neighborhood, city, state, cep) VALUES (2, 'Rua XV de Novembro', '45', 'Casa 2', 'São Cristóvão', 'Londrina', 'PR', '86010-150');
INSERT INTO tb_address (user_id, street, number, complement, neighborhood, city, state, cep) VALUES (2, 'Travessa das Acácias', '78', NULL, 'Jardim América', 'Maringá', 'PR', '87020-200');

-- Order
-- Pedido 1 do usuário 1
INSERT INTO tb_order (data, user_id) VALUES (NOW(), 1);

-- Pedido 2 do usuário 1
INSERT INTO tb_order (data, user_id) VALUES (NOW(), 1);

-- Pedido 3 do usuário 2
INSERT INTO tb_order (data, user_id) VALUES (NOW(), 2);

-- Pedido 4 do usuário 2
INSERT INTO tb_order (data, user_id) VALUES (NOW(), 2);

-- OrderItem
-- Itens do Pedido 1
INSERT INTO tb_order_item (order_id, product_id, total_price, quantity) VALUES (1, 1, 3980.00, 2); -- 2x produto 1
INSERT INTO tb_order_item (order_id, product_id, total_price, quantity) VALUES (1, 2, 2449.00, 1); -- 1x produto 2

-- Itens do Pedido 2
INSERT INTO tb_order_item (order_id, product_id, total_price, quantity) VALUES (2, 3, 225.998, 2); -- 2x produto 3

-- Itens do Pedido 3
INSERT INTO tb_order_item (order_id, product_id, total_price, quantity) VALUES (3, 4, 199.00, 1); -- 1x produto 4
INSERT INTO tb_order_item (order_id, product_id, total_price, quantity) VALUES (3, 1, 7960.00, 4); -- 4x produto 1

-- Itens do Pedido 4
INSERT INTO tb_order_item (order_id, product_id, total_price, quantity) VALUES (4, 2, 4898.00, 2); -- 2x produto 2