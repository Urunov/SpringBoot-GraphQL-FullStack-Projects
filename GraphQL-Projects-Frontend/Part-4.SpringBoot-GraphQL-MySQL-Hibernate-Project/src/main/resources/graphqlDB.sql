create table `language` (
   id                   int not null auto_increment,
   name                 varchar(128) not null,
   code                 varchar(200) not null,
   color                varchar(7) not null,
   language_type        varchar(25) not null,
   primary key (id)
);

create table `user` (
    id                   int not null auto_increment,
    username             varchar(25) not null,
    email                varchar(64) not null,
    primary key (id)
);

create table `project` (
    id                   int not null auto_increment,
    title                varchar(128) not null,
    description          text not null,
    language_id          int not null,
    user_id              int not null,
    primary key (id)
);

alter table `project` add constraint fk_project_language foreign key (language_id)
      references language (id) on delete restrict on update restrict;

alter table `project` add constraint fk_project_user foreign key (user_id)
      references user (id) on delete restrict on update restrict;

insert into `language` (`id`, `name`, `code`, `color`, `language_type`) values
(1, 'Java', 'java', 'B07219', 'PROGRAMMING'),
(2, 'PHP', 'php', '4F5D95', 'PROGRAMMING'),
(3, 'C#', 'csharp', '178600', 'PROGRAMMING'),
(4, 'CSS', 'css', '563D7C', 'MARKUP'),
(5, 'HTML', 'html', 'E34C26', 'MARKUP'),
(6, 'TeX', 'tex', '3D6117', 'MARKUP'),
(7, 'SQL', 'sql', 'CCCCCC', 'DATA');

insert into `user` (`id`, `username`, `email`) values
(1, 'bob.smith', 'bob.smith@email.com'),
(2, 'jake.potter', 'jake.potter@email.com'),
(3, 'sarah.thompson', 'sarah.thompson@email.com');

insert into `project` (`id`, `title`, `description`, `language_id`, `user_id`) values
(1, 'Spring Boot project', 'Simple Spring Boot project', 1, 1),
(2, 'JavaFX project', 'Simple JavaFX project', 1, 1),
(3, 'JSF project', 'Simple  JSF project', 1, 1),
(4, 'WinForms project', 'Simple WinForms project', 3, 2),
(5, 'Swing project', 'Simple Swing project', 1, 2),
(6, 'TeX project', 'Simple TeX project', 6, 3),
(7, 'PHP project', 'Simple PHP project', 2, 3),
(8, 'Dot Net project', 'Simple Dot Net project', 3, 3);