-- Inserting data into `sound--`.`autor` table
INSERT INTO `sound--`.`autor` (`cpf`, `nome_original`, `nome_artistico`) VALUES
('12345678901', 'John Doe', 'DJ J.D.'),
('98765432101', 'Jane Smith', 'J-Smooth');

-- Inserting data into `sound--`.`categoria` table
INSERT INTO `sound--`.`categoria` (`nome`) VALUES
('Pop'),
('Rock'),
('Electronic');

-- Inserting data into `sound--`.`musica` table
INSERT INTO `sound--`.`musica` (`titulo`, `letra`, `data_lancamento`, `fk_categoria`, `duracao`) VALUES
('Catchy Tune', 'Lorem ipsum dolor sit amet', '2023-01-15', 1, 3.5),
('Guitar Riff', 'Sed ut perspiciatis unde omnis iste natus', '2023-02-20', 2, 4.2),
('Electronic Beats', 'At vero eos et accusamus et iusto odio dignissimos', '2023-03-10', 3, 5.1);

-- Inserting data into `sound--`.`autor_musica` table
INSERT INTO `sound--`.`autor_musica` (`fk_autor`, `fk_musica`) VALUES
(1, 1),
(2, 1),
(1, 2),
(2, 3);
