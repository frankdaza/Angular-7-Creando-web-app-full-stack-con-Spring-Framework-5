insert into personas (nombres, apellidos) values ('frank edward', 'daza gonzález');
insert into personas (nombres, apellidos) values ('vanessa', 'porras');
insert into personas (nombres, apellidos) values ('obed', 'daza martínez');
insert into personas (nombres, apellidos) values ('martha belly', 'gonzález hernández');

insert into usuarios (enabled, password, username) values (true, '$2a$10$ZCTO/T2y7NpYO6IRlBvYFOzB7QH74o0ZaN66uI4rCs6uNcnx6M8F.', 'frank');
insert into usuarios (enabled, password, username) values (true, '$2a$10$GHXeOt1m3nspMOQOdxYL1OZdNONaPOtYU/6fZxRPwSZqajNTy1S6i', 'vanessa');

insert into roles (nombre) values ('ROLE_USER');
insert into roles (nombre) values ('ROLE_ADMIN');

insert into usuarios_roles (usuario_id, roles_id) values (1, 1);
insert into usuarios_roles (usuario_id, roles_id) values (1, 2);
insert into usuarios_roles (usuario_id, roles_id) values (2, 2);