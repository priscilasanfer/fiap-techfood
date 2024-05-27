INSERT INTO tb_products (id, category, price, description, imageurl, name) VALUES
-- SNACK ("Lanche", 1)
('f47ac10b-58cc-4372-a567-0e02b2c3d479', 1, 10.50, 'Delicioso x-burguer com queijo e alface', 'http://example.com/images/xburguer.jpg', 'X-Burguer'),
('c9bf9e57-1685-4c89-bafb-ff5af830be8a', 1, 12.00, 'Sanduíche natural de frango com salada', 'http://example.com/images/sanduiche_natural.jpg', 'Sanduíche Natural'),
('9f8b66d0-e68e-4a34-9df7-4b6325cda63e', 1, 15.00, 'Hambúrguer vegetariano com queijo', 'http://example.com/images/veggie_burger.jpg', 'Veggie Burger'),

-- SIDE_DISH ("Acompanhamento", 2)
('1c6e2b6d-8c21-4b75-8eae-00564b4d6f8f', 2, 5.50, 'Porção de batatas fritas crocantes', 'http://example.com/images/batatas_fritas.jpg', 'Batatas Fritas'),
('3b8a2f1e-d9c4-4926-832f-3aef5f3c2f12', 2, 4.00, 'Porção de anéis de cebola', 'http://example.com/images/aneis_cebola.jpg', 'Anéis de Cebola'),
('59f0b4f2-2f3a-4ed7-965b-1b5cbda26e1b', 2, 6.00, 'Porção de nuggets de frango', 'http://example.com/images/nuggets.jpg', 'Nuggets de Frango'),

-- DRINK ("Bebida", 3)
('5d5c2b17-1b6c-4ed3-9f6d-6f767a9d720e', 3, 3.00, 'Refrigerante de cola 350ml', 'http://example.com/images/refrigerante_cola.jpg', 'Refrigerante Cola'),
('7c0b68d7-2d1a-426d-945a-414dc56b1df1', 3, 3.50, 'Suco de laranja natural 300ml', 'http://example.com/images/suco_laranja.jpg', 'Suco de Laranja'),
('a28d3f54-dc4c-44a0-8c9b-0c4db7b5732a', 3, 4.00, 'Milkshake de chocolate 400ml', 'http://example.com/images/milkshake_chocolate.jpg', 'Milkshake de Chocolate'),

-- DESSERT ("Sobremesa", 4)
('c4dcb339-908e-4b29-9264-47cf57613402', 4, 6.50, 'Sorvete de baunilha com calda de chocolate', 'http://example.com/images/sorvete_baunilha.jpg', 'Sorvete de Baunilha'),
('f9ae6dcd-6891-4a3a-90f1-78a7377e4c7a', 4, 7.00, 'Brownie de chocolate com nozes', 'http://example.com/images/brownie.jpg', 'Brownie de Chocolate'),
('e6bf8692-c8b0-40d8-8c5c-1ff54944d20d', 4, 5.00, 'Torta de maçã com canela', 'http://example.com/images/torta_maca.jpg', 'Torta de Maçã');

INSERT INTO tb_clients (id, name, cpf, email) VALUES
('6bb12546-bcf0-4e4a-90a4-9c30e6d094bb', 'Eduarda Brenda Jennifer Nascimento', '426.169.392-58', 'eduarda_nascimento@dominatto.ind.br'),
('4a260740-e8cb-4f89-90db-33e48345beae', 'Julia Bernardes', '551.539.817-38', 'julia-bernardes94@live.se'),
('f7a0491d-cfb0-4891-9d50-f0a2f95eb788', 'Vinicius Martin Tiago da Rocha', '136.992.179-90', 'vinicius_darocha@easytechconsultoria.com.br');