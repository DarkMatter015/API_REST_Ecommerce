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
insert into tb_product(name, description, price, url_image, quantity_available_in_stock, category_id) values ('Contrabaixo Yamaha TRBX174','Contrabaixo Yamaha TRBX174 com corpo em nato e captadores PJ versáteis.',1890.00,'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTaNg13-r_F73rUWCPFj9pCeS_b-fUULGpwfA&s',10,2);
insert into tb_product(name, description, price, url_image, quantity_available_in_stock, category_id) values ('Ukulele Shelby Su23M','Ukulele Shelby Su23M soprano em mahogany com timbre suave e equilibrado.',299.00,'https://serenata.vteximg.com.br/arquivos/ids/3107713-1000-1000/UKULELE-SHELBY-SU23M-STNT-CONC_IMG2.jpg?v=638525159417570000',25,1);
insert into tb_product(name, description, price, url_image, quantity_available_in_stock, category_id) values ('Amplificador Fender Mustang LT25','Amplificador Fender Mustang LT25 com presets integrados e Bluetooth.',1490.00,'https://serenata.vteximg.com.br/arquivos/ids/3114647-500-500/COMBO-FENDER-MUSTANG-LT25_IMG14.jpg?v=638665382573770000',7,5);
insert into tb_product(name, description, price, url_image, quantity_available_in_stock, category_id) values ('Cajón Pearl Primero','Cajón Pearl Primero com corpo em MDF e tapa em birch, som percussivo definido.',899.00,'https://m.media-amazon.com/images/I/81nga0JGW7L.jpg',13,3);
insert into tb_product(name, description, price, url_image, quantity_available_in_stock, category_id) values ('Baquetas Vic Firth 5A','Par de baquetas Vic Firth 5A de Hickory, equilíbrio clássico para todos os estilos.',89.90,'https://izzomusical.vtexassets.com/arquivos/ids/157436-800-auto?v=637595587390630000&width=800&height=auto&aspect=true',60,5);
insert into tb_product(name, description, price, url_image, quantity_available_in_stock, category_id) values ('Pedal Guitarra Mooer Shimverb Reverb','Pedal Mooer Shimverb com modos Room, Spring e Shimmer.',529.00,'https://images.tcdn.com.br/img/img_prod/1402804/pedal_guitarra_mooer_twin_shimverb_pro_digital_reverb_trv1_1189_1_e596407f4863ef73409338c952f64a99.jpg',18,5);
insert into tb_product(name, description, price, url_image, quantity_available_in_stock, category_id) values ('Teclado Workstation Korg Kross 2','Workstation Korg Kross 2 com sampling, sequencer e 1075 timbres.',7590.00,'https://images.tcdn.com.br/img/img_prod/1033692/teclado_workstation_korg_kross_2_61_8387_1_861ed511aae416fc2a7cb3f4b65e15d1.jpg',5,4);
insert into tb_product(name, description, price, url_image, quantity_available_in_stock, category_id) values ('Guitarra Tagima T635','Guitarra Tagima T635 estilo Stratocaster, captadores single coil e braço em maple.',1690.00,'https://harmoniamusical.com.br/media/catalog/product/cache/7c65d8a16c1a9fa15447e0ab5eeb833b/1/9/195523_68111f0bbb451.webp',14,2);
insert into tb_product(name, description, price, url_image, quantity_available_in_stock, category_id) values ('Kit Palhetas Dunlop Variety Pack','Kit com 12 palhetas Dunlop de várias espessuras, ideal para testes de timbre.',59.90,'https://http2.mlstatic.com/D_NQ_NP_758506-MLA96870004757_102025-O.webp',80,5);
insert into tb_product(name, description, price, url_image, quantity_available_in_stock, category_id) values ('Tamborim Contemporânea 6”','Tamborim Contemporânea 6” com afinação precisa e casco em alumínio.',89.00,'https://images.tcdn.com.br/img/img_prod/635998/tamborim_contemporanea_06_alum_frisado_6_tarraxas_ny_429c_251_4_20190411122937.jpg',30,3);
insert into tb_product(name, description, price, url_image, quantity_available_in_stock, category_id) values ('Teclado Infantil Casio SA-76','Teclado Casio SA-76 com 44 teclas, 100 timbres e modo educativo para iniciantes.',499.00,'https://images.tcdn.com.br/img/img_prod/638642/teclado_infantil_casio_sa_76_78_2017_variacao_293_1_fafbd46744e9422f7be087815cf04d8b.png',22,4);
insert into tb_product(name, description, price, url_image, quantity_available_in_stock, category_id) values ('Capa Acolchoada para Violão Folk','Capa acolchoada 12mm com alças reforçadas e bolsos frontais.',119.00,'https://cdn.awsli.com.br/600x450/55/55384/produto/11894507/45e822c9ee.jpg',27,5);


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
INSERT INTO tb_order (data, user_id, address_street, address_number, address_complement, address_neighborhood, address_city, address_state, address_cep, payment_id) VALUES (NOW(), 1, 'Avenida Brasil', '950', NULL, 'Bela Vista', 'Curitiba', 'PR', '80010020', 2);
INSERT INTO tb_order (data, user_id, address_street, address_number, address_complement, address_neighborhood, address_city, address_state, address_cep, payment_id) VALUES (NOW(), 1, 'Avenida Brasil', '950', NULL, 'Bela Vista', 'Curitiba', 'PR', '80010020', 2);
INSERT INTO tb_order (data, user_id, address_street, address_number, address_complement, address_neighborhood, address_city, address_state, address_cep, payment_id) VALUES (NOW(), 1, 'Avenida Brasil', '950', NULL, 'Bela Vista', 'Curitiba', 'PR', '80010020', 2);
INSERT INTO tb_order (data, user_id, address_street, address_number, address_complement, address_neighborhood, address_city, address_state, address_cep, payment_id) VALUES (NOW(), 1, 'Avenida Brasil', '950', NULL, 'Bela Vista', 'Curitiba', 'PR', '80010020', 2);
INSERT INTO tb_order (data, user_id, address_street, address_number, address_complement, address_neighborhood, address_city, address_state, address_cep, payment_id) VALUES (NOW(), 1, 'Avenida Brasil', '950', NULL, 'Bela Vista', 'Curitiba', 'PR', '80010020', 2);
INSERT INTO tb_order (data, user_id, address_street, address_number, address_complement, address_neighborhood, address_city, address_state, address_cep, payment_id) VALUES (NOW(), 1, 'Avenida Brasil', '950', NULL, 'Bela Vista', 'Curitiba', 'PR', '80010020', 2);
INSERT INTO tb_order (data, user_id, address_street, address_number, address_complement, address_neighborhood, address_city, address_state, address_cep, payment_id) VALUES (NOW(), 1, 'Avenida Brasil', '950', NULL, 'Bela Vista', 'Curitiba', 'PR', '80010020', 2);
INSERT INTO tb_order (data, user_id, address_street, address_number, address_complement, address_neighborhood, address_city, address_state, address_cep, payment_id) VALUES (NOW(), 1, 'Avenida Brasil', '950', NULL, 'Bela Vista', 'Curitiba', 'PR', '80010020', 2);
INSERT INTO tb_order (data, user_id, address_street, address_number, address_complement, address_neighborhood, address_city, address_state, address_cep, payment_id) VALUES (NOW(), 1, 'Avenida Brasil', '950', NULL, 'Bela Vista', 'Curitiba', 'PR', '80010020', 2);
INSERT INTO tb_order (data, user_id, address_street, address_number, address_complement, address_neighborhood, address_city, address_state, address_cep, payment_id) VALUES (NOW(), 1, 'Avenida Brasil', '950', NULL, 'Bela Vista', 'Curitiba', 'PR', '80010020', 2);
INSERT INTO tb_order (data, user_id, address_street, address_number, address_complement, address_neighborhood, address_city, address_state, address_cep, payment_id) VALUES (NOW(), 1, 'Avenida Brasil', '950', NULL, 'Bela Vista', 'Curitiba', 'PR', '80010020', 2);
INSERT INTO tb_order (data, user_id, address_street, address_number, address_complement, address_neighborhood, address_city, address_state, address_cep, payment_id) VALUES (NOW(), 1, 'Avenida Brasil', '950', NULL, 'Bela Vista', 'Curitiba', 'PR', '80010020', 2);
INSERT INTO tb_order (data, user_id, address_street, address_number, address_complement, address_neighborhood, address_city, address_state, address_cep, payment_id) VALUES (NOW(), 1, 'Avenida Brasil', '950', NULL, 'Bela Vista', 'Curitiba', 'PR', '80010020', 2);
INSERT INTO tb_order (data, user_id, address_street, address_number, address_complement, address_neighborhood, address_city, address_state, address_cep, payment_id) VALUES (NOW(), 1, 'Avenida Brasil', '950', NULL, 'Bela Vista', 'Curitiba', 'PR', '80010020', 2);
INSERT INTO tb_order (data, user_id, address_street, address_number, address_complement, address_neighborhood, address_city, address_state, address_cep, payment_id) VALUES (NOW(), 1, 'Avenida Brasil', '950', NULL, 'Bela Vista', 'Curitiba', 'PR', '80010020', 2);
INSERT INTO tb_order (data, user_id, address_street, address_number, address_complement, address_neighborhood, address_city, address_state, address_cep, payment_id) VALUES (NOW(), 1, 'Avenida Brasil', '950', NULL, 'Bela Vista', 'Curitiba', 'PR', '80010020', 2);
INSERT INTO tb_order (data, user_id, address_street, address_number, address_complement, address_neighborhood, address_city, address_state, address_cep, payment_id) VALUES (NOW(), 1, 'Avenida Brasil', '950', NULL, 'Bela Vista', 'Curitiba', 'PR', '80010020', 2);
INSERT INTO tb_order (data, user_id, address_street, address_number, address_complement, address_neighborhood, address_city, address_state, address_cep, payment_id) VALUES (NOW(), 1, 'Avenida Brasil', '950', NULL, 'Bela Vista', 'Curitiba', 'PR', '80010020', 2);
INSERT INTO tb_order (data, user_id, address_street, address_number, address_complement, address_neighborhood, address_city, address_state, address_cep, payment_id) VALUES (NOW(), 1, 'Avenida Brasil', '950', NULL, 'Bela Vista', 'Curitiba', 'PR', '80010020', 2);
INSERT INTO tb_order (data, user_id, address_street, address_number, address_complement, address_neighborhood, address_city, address_state, address_cep, payment_id) VALUES (NOW(), 1, 'Avenida Brasil', '950', NULL, 'Bela Vista', 'Curitiba', 'PR', '80010020', 2);
INSERT INTO tb_order (data, user_id, address_street, address_number, address_complement, address_neighborhood, address_city, address_state, address_cep, payment_id) VALUES (NOW(), 1, 'Avenida Brasil', '950', NULL, 'Bela Vista', 'Curitiba', 'PR', '80010020', 2);
INSERT INTO tb_order (data, user_id, address_street, address_number, address_complement, address_neighborhood, address_city, address_state, address_cep, payment_id) VALUES (NOW(), 1, 'Avenida Brasil', '950', NULL, 'Bela Vista', 'Curitiba', 'PR', '80010020', 2);
INSERT INTO tb_order (data, user_id, address_street, address_number, address_complement, address_neighborhood, address_city, address_state, address_cep, payment_id) VALUES (NOW(), 1, 'Avenida Brasil', '950', NULL, 'Bela Vista', 'Curitiba', 'PR', '80010020', 2);
INSERT INTO tb_order (data, user_id, address_street, address_number, address_complement, address_neighborhood, address_city, address_state, address_cep, payment_id) VALUES (NOW(), 1, 'Avenida Brasil', '950', NULL, 'Bela Vista', 'Curitiba', 'PR', '80010020', 2);
INSERT INTO tb_order (data, user_id, address_street, address_number, address_complement, address_neighborhood, address_city, address_state, address_cep, payment_id) VALUES (NOW(), 1, 'Avenida Brasil', '950', NULL, 'Bela Vista', 'Curitiba', 'PR', '80010020', 2);
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
