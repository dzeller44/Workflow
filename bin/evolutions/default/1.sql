# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table audit_log (
  id                            integer auto_increment not null,
  user_id                       varchar(255),
  email                         varchar(255),
  role                          varchar(255),
  context                       varchar(255),
  screen                        varchar(255),
  field                         varchar(255),
  value                         varchar(255),
  ip                            varchar(255),
  path                          varchar(255),
  host                          varchar(255),
  created                       datetime(6),
  constraint pk_audit_log primary key (id)
);

create table card (
  id                            bigint auto_increment not null,
  name                          varchar(255),
  team                          varchar(255),
  teamkey                       varchar(255),
  position                      varchar(255),
  cardmaker                     varchar(255),
  year                          integer,
  uniquekey                     varchar(255),
  userkey                       varchar(255),
  editkey                       varchar(255),
  updatedby                     varchar(255),
  datecreated                   datetime(6),
  dateupdated                   datetime(6),
  constraint pk_card primary key (id)
);

create table card_audit (
  id                            bigint auto_increment not null,
  cardkey                       varchar(255),
  editor                        varchar(255),
  editoremail                   varchar(255),
  editorkey                     varchar(255),
  editdate                      datetime(6),
  fieldname                     varchar(255),
  fielddisplay                  varchar(255),
  oldvalue                      varchar(255),
  newvalue                      varchar(255),
  auditkey                      varchar(255),
  constraint pk_card_audit primary key (id)
);

create table card_edit (
  id                            bigint auto_increment not null,
  editkey                       varchar(255),
  name                          varchar(255),
  team                          varchar(255),
  position                      varchar(255),
  cardmaker                     varchar(255),
  year                          integer,
  datecreated                   datetime(6),
  cardkey                       varchar(255),
  userkey                       varchar(255),
  updatedby                     varchar(255),
  dateupdated                   datetime(6),
  constraint pk_card_edit primary key (id)
);

create table comment (
  id                            bigint auto_increment not null,
  author                        varchar(255),
  authoremail                   varchar(255),
  comment                       varchar(255),
  cardkey                       varchar(255),
  uniquekey                     varchar(255),
  userkey                       varchar(255),
  datecreated                   datetime(6),
  constraint pk_comment primary key (id)
);

create table lookup (
  id                            bigint auto_increment not null,
  lookuptype                    varchar(255),
  name                          varchar(255),
  description                   varchar(255),
  datecreated                   datetime(6),
  lookupkey                     varchar(255),
  updatedby                     varchar(255),
  dateupdated                   datetime(6),
  userkey                       varchar(255),
  constraint pk_lookup primary key (id)
);

create table removed_card (
  id                            bigint auto_increment not null,
  name                          varchar(255),
  team                          varchar(255),
  teamkey                       varchar(255),
  position                      varchar(255),
  cardmaker                     varchar(255),
  year                          integer,
  uniquekey                     varchar(255),
  userkey                       varchar(255),
  editkey                       varchar(255),
  updatedby                     varchar(255),
  datecreated                   datetime(6),
  dateupdated                   datetime(6),
  removed_by                    varchar(255),
  removedbyuserkey              varchar(255),
  date_removed                  datetime(6),
  constraint pk_removed_card primary key (id)
);

create table removed_user (
  id                            bigint auto_increment not null,
  email                         varchar(255),
  fullname                      varchar(255),
  agency                        varchar(255),
  confirmation_token            varchar(255),
  password_hash                 varchar(255),
  date_creation                 datetime(6),
  validated                     tinyint(1) default 0,
  role                          integer,
  rolename                      varchar(255),
  approved                      varchar(255),
  active                        varchar(255),
  userkey                       varchar(255),
  updated_by                    varchar(255),
  date_updated                  datetime(6),
  removed_by                    varchar(255),
  removedbyuserkey              varchar(255),
  date_removed                  datetime(6),
  constraint ck_removed_user_role check (role in ('0','2','1')),
  constraint uq_removed_user_email unique (email),
  constraint uq_removed_user_fullname unique (fullname),
  constraint pk_removed_user primary key (id)
);

create table session (
  id                            integer auto_increment not null,
  hash                          varchar(255),
  user_id                       varchar(255),
  email                         varchar(255),
  expiration_date               datetime(6),
  data                          varchar(255),
  userkey                       varchar(255),
  role                          integer,
  rolename                      varchar(255),
  constraint ck_session_role check (role in ('0','2','1')),
  constraint pk_session primary key (id)
);

create table team (
  id                            bigint auto_increment not null,
  name                          varchar(255),
  uniquekey                     varchar(255),
  userkey                       varchar(255),
  editkey                       varchar(255),
  updatedby                     varchar(255),
  datecreated                   datetime(6),
  dateupdated                   datetime(6),
  constraint pk_team primary key (id)
);

create table token (
  token                         varchar(255) not null,
  user_id                       bigint,
  type                          varchar(8),
  date_creation                 datetime(6),
  email                         varchar(255),
  constraint ck_token_type check (type in ('password','email','admin','user')),
  constraint pk_token primary key (token)
);

create table user (
  id                            bigint auto_increment not null,
  email                         varchar(255),
  fullname                      varchar(255),
  agency                        varchar(255),
  confirmation_token            varchar(255),
  password_hash                 varchar(255),
  date_creation                 datetime(6),
  date_password_remind          datetime(6),
  date_remind                   datetime(6),
  validated                     tinyint(1) default 0,
  role                          integer,
  rolename                      varchar(255),
  approved                      varchar(255),
  active                        varchar(255),
  userkey                       varchar(255),
  updated_by                    varchar(255),
  date_updated                  datetime(6),
  constraint ck_user_role check (role in ('0','2','1')),
  constraint uq_user_email unique (email),
  constraint uq_user_fullname unique (fullname),
  constraint pk_user primary key (id)
);

create table workflow_audit_record (
  id                            bigint auto_increment not null,
  author                        varchar(255),
  author_email                  varchar(255),
  authorkey                     varchar(255),
  message                       varchar(255),
  parent_key                    varchar(255),
  unique_key                    varchar(255),
  date_created                  datetime(6),
  constraint pk_workflow_audit_record primary key (id)
);

create table workflow_lookup (
  id                            bigint auto_increment not null,
  lookup_type                   varchar(255),
  name                          varchar(255),
  description                   varchar(255),
  date_created                  datetime(6),
  lookup_key                    varchar(255),
  updated_by                    varchar(255),
  user_key                      varchar(255),
  date_updated                  datetime(6),
  constraint pk_workflow_lookup primary key (id)
);

create table workflow_profile (
  id                            bigint auto_increment not null,
  app_name                      varchar(255),
  app_desc                      varchar(255),
  app_initial_step              varchar(255),
  app_owner                     varchar(255),
  app_owner_email               varchar(255),
  app_agency                    varchar(255),
  app_key                       varchar(255),
  edit_key                      varchar(255),
  updated_by                    varchar(255),
  date_created                  datetime(6),
  date_updated                  datetime(6),
  constraint pk_workflow_profile primary key (id)
);

create table workflow_profile_edit (
  id                            bigint auto_increment not null,
  app_name                      varchar(255),
  app_desc                      varchar(255),
  app_initial_step              varchar(255),
  app_owner                     varchar(255),
  app_owner_email               varchar(255),
  app_agency                    varchar(255),
  app_key                       varchar(255),
  edit_key                      varchar(255),
  updated_by                    varchar(255),
  date_created                  datetime(6),
  date_updated                  datetime(6),
  constraint pk_workflow_profile_edit primary key (id)
);

create table workflow_routing (
  id                            bigint auto_increment not null,
  app_name                      varchar(255),
  app_key                       varchar(255),
  route_name                    varchar(255),
  route_seq                     integer,
  route_type                    varchar(255),
  route_is_final_step           varchar(255),
  route_next_step               varchar(255),
  route_next_step_key           varchar(255),
  route_prev_step               varchar(255),
  route_prev_key                varchar(255),
  route_notify                  varchar(255),
  route_message                 varchar(255),
  route_key                     varchar(255),
  edit_key                      varchar(255),
  updated_by                    varchar(255),
  date_created                  datetime(6),
  date_updated                  datetime(6),
  constraint pk_workflow_routing primary key (id)
);

create table workflow_session (
  id                            integer auto_increment not null,
  hash                          varchar(255),
  user_id                       varchar(255),
  email                         varchar(255),
  expiration_date               datetime(6),
  data                          varchar(255),
  userkey                       varchar(255),
  role                          integer,
  rolename                      varchar(255),
  constraint ck_workflow_session_role check (role in ('0','9','1','2')),
  constraint pk_workflow_session primary key (id)
);

create table workflow_user (
  id                            bigint auto_increment not null,
  email                         varchar(255),
  full_name                     varchar(255),
  role                          integer,
  role_name                     varchar(255),
  app_name                      varchar(255),
  app_key                       varchar(255),
  active                        varchar(255),
  user_key                      varchar(255),
  date_creation                 datetime(6),
  updated_by                    varchar(255),
  date_updated                  datetime(6),
  constraint ck_workflow_user_role check (role in ('0','9','1','2')),
  constraint uq_workflow_user_email unique (email),
  constraint uq_workflow_user_full_name unique (full_name),
  constraint pk_workflow_user primary key (id)
);


# --- !Downs

drop table if exists audit_log;

drop table if exists card;

drop table if exists card_audit;

drop table if exists card_edit;

drop table if exists comment;

drop table if exists lookup;

drop table if exists removed_card;

drop table if exists removed_user;

drop table if exists session;

drop table if exists team;

drop table if exists token;

drop table if exists user;

drop table if exists workflow_audit_record;

drop table if exists workflow_lookup;

drop table if exists workflow_profile;

drop table if exists workflow_profile_edit;

drop table if exists workflow_routing;

drop table if exists workflow_session;

drop table if exists workflow_user;

