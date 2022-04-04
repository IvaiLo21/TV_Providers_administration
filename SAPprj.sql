DROP DATABASE IF EXISTS TV_Provider_administration;
CREATE DATABASE TV_Provider_administration;
USE TV_Provider_administration;

create table providers(
id int auto_increment not null primary key,
NoP varchar(255) not null,
service_cost double,
contract_numb varchar (12) not null unique,
contract_exp date not null
);

create table customers(
id int auto_increment not null primary key,
custm_name varchar (255) not null,
address varchar (255) not null
);

create table channels(
id int auto_increment not null primary key,
NoC varchar (255) not null,
c_cost double
);

create table channel_category(
id int auto_increment not null primary key,
c_category ENUM('efirni', 'sportni', 'nauchni', 'filmovi', 'muzikalni', 'detski', 'others'),
c_pckg_cost double,
c_cat_id int not null unique,
constraint foreign key (c_cat_id) references channels(id),
Unique key (c_cat_id,c_category, c_pckg_cost)
);

create table contracts(
id int auto_increment not null primary key,
contract_pckg ENUM('1', '2', '3', '4', '5', '6', '7'),
prvd_cntr int not null,
constraint foreign key (prvd_cntr) references providers(id),
custm_cntr int not null,
constraint foreign key (custm_cntr) references customers(id),
chnl_cntr int not null,
constraint foreign key (chnl_cntr) references channels(id)
);

create table taxes(
id int auto_increment not null primary key,
monthly_paid double,
custm_taxes int not null,
constraint foreign key (custm_taxes) references customers(id),
unique key(monthly_paid, custm_taxes)
);