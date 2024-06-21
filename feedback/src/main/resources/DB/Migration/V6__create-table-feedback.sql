    create table feedback (
        id integer not null auto_increment,
        date_time datetime(6),
        aprendiz_id integer,
        instrutor_id integer,
        primary key (id)
    );

    alter table feedback 
       add constraint FK6k6ym49aml2dr4nqs0dgruh9p 
       foreign key (aprendiz_id) 
       references aprendiz (id);

    alter table feedback 
       add constraint FKsi93i8r324c3verjjdjgkp3kt 
       foreign key (instrutor_id) 
       references instrutor (id);
