create table authorities
(
  id integer not null
    constraint authorities_pkey
    primary key,
  authority varchar(255),
  username varchar(255)
)
;

create index ix_auth_username
  on authorities (username, authority)
;

create table client
(
  id integer not null
    constraint client_pkey
    primary key,
  client_id integer
)
;

create table client_details
(
  id integer not null
    constraint client_details_pkey
    primary key,
  birthday date,
  created_at date not null,
  email varchar(64),
  name varchar(64) not null,
  phone varchar(64),
  sex varchar(4) not null,
  updated_at date not null,
  client_id integer
    constraint fk_clients
    references client
)
;

alter table client
  add constraint fk_client_details
foreign key (client_id) references client_details
;

create table client_old
(
  id integer not null
    constraint client_old_pkey
    primary key,
  name varchar(255)
)
;

create table flow
(
  id integer not null
    constraint flow_pkey
    primary key,
  expected_executed varchar(255),
  input_output varchar(255),
  item_name varchar(255),
  value double precision,
  client_old_id integer
    constraint fk_client_old
    references client_old,
  item_id integer,
  period_id integer
)
;

create table item
(
  id integer not null
    constraint item_pkey
    primary key,
  active boolean not null,
  name varchar(255) not null,
  value double precision not null
)
;

alter table flow
  add constraint fk_item
foreign key (item_id) references item
;

create table period
(
  id integer not null
    constraint period_pkey
    primary key,
  balance_final double precision,
  balance_period double precision,
  month integer not null,
  year integer not null
)
;

alter table flow
  add constraint fk_period
foreign key (period_id) references period
;

create table product
(
  id integer not null
    constraint product_pkey
    primary key,
  active boolean,
  created_at date,
  description varchar(255),
  name varchar(255) not null,
  price double precision not null,
  updated_at date
)
;

create table users
(
  username varchar(255) not null
    constraint users_pkey
    primary key,
  account_non_expired boolean not null,
  account_non_locked boolean not null,
  credentials_non_expired boolean not null,
  enabled boolean not null,
  password varchar(255) not null
)
;

alter table authorities
  add constraint fk_users
foreign key (username) references users
;

create sequence hibernate_sequence start 1 increment 1;