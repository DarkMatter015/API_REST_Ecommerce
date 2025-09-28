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
insert into tb_product(name, description, price, url_image, category_id) values ('Smartphone XYZ','Smatphone com tela de 9pol, 12GB....',9999.0, 'https://s2-techtudo.glbimg.com/O7AOSNYb2EtOPT3GjTid4is_P2Q=/282x82:913x590/984x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_08fbf48bc0524877943fe86e43087e7a/internal_photos/bs/2020/T/j/HtgpWLQmK54IhYlw9icQ/samsung-galaxy-note-20-renders-1200x675.jpg', 5);
insert into tb_product(name, description, price, url_image, category_id) values ('TV LCD 75pol','TV LCD 75pol, 5 HDMI...',7555.0, 'https://i.zst.com.br/thumbs/12/27/e/-1103503572.jpg', 5);
insert into tb_product(name, description, price, url_image, category_id) values ('Fogão 6 Bocas','Fogão 6 Bocas em aço inox, ...', 799.99, 'https://consul.vtexassets.com/arquivos/ids/230022-800-800?v=637976381016900000&width=800&height=800&aspect=true', 3);
insert into tb_product(name, description, price, url_image, category_id) values ('Roteador Wi-Fi 5.4GhZ','Roteador Wi-Fi 5.4GhZ, 6 antenas...',1299.0, 'https://img.kalunga.com.br/fotosdeproducts/610540z_1.jpg', 1);
-- User - password: 123
INSERT INTO tb_user(username, email, password) VALUES ('Administrador', 'admin@teste.com','$2a$10$.PVIfB07x.SfMYTcToxL0.yxcLWU0GbS2NUO1W1QAvqMm/TsFhVem');
INSERT INTO tb_user(username, email, password) VALUES ('Teste', 'test@teste.com','$2a$10$.PVIfB07x.SfMYTcToxL0.yxcLWU0GbS2NUO1W1QAvqMm/TsFhVem');