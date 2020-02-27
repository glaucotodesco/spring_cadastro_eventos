#System.out.println("PWD 123 = " + new BCryptPasswordEncoder().encode("123"));


insert into usuario values ('admin', 'admin','$2a$10$skw/VSgglzy2AYQ8JY83xuTnBK9N.ZYXCYklzHg6ePu4LFMQg9szq');
insert into usuario values ('user', 'user','$2a$10$skw/VSgglzy2AYQ8JY83xuTnBK9N.ZYXCYklzHg6ePu4LFMQg9szq';)
insert into role values ('ROLE_ADMIN');
insert into role values ('ROLE_USER');
insert into usuarios_roles values ('admin','ROLE_ADMIN');
insert into usuarios_roles values ('user','ROLE_USER');