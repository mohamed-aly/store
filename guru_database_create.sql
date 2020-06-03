create table address (id bigint not null auto_increment, apartment integer, building integer, city varchar(255), special_marque varchar(255), state varchar(255), street_details varchar(255), user_id bigint, primary key (id)) engine=InnoDB
create table cart (id bigint not null auto_increment, primary key (id)) engine=InnoDB
create table cart_item (id bigint not null auto_increment, quantity integer, product_id bigint, cart_id bigint, primary key (id)) engine=InnoDB
create table category (id bigint not null auto_increment, description varchar(255), image_url varchar(255), name varchar(255), primary key (id)) engine=InnoDB
create table classified_product (id bigint not null auto_increment, quantity integer, grade_id bigint, product_id bigint, primary key (id)) engine=InnoDB
create table grade (id bigint not null auto_increment, grade_number integer, grade_level bigint, primary key (id)) engine=InnoDB
create table grade_level (id bigint not null auto_increment, level varchar(255), primary key (id)) engine=InnoDB
create table offers (id bigint not null auto_increment, discount double precision, end_date datetime, start_date datetime, product_id bigint, primary key (id)) engine=InnoDB
create table order_details (id bigint not null auto_increment, address_id bigint, order_id bigint, user_id bigint, primary key (id)) engine=InnoDB
create table order_item (id bigint not null auto_increment, price_per_unit double precision, quantity integer, classified_product_id bigint, order_id bigint, product_id bigint, primary key (id)) engine=InnoDB
create table order_status (id bigint not null auto_increment, status varchar(255), primary key (id)) engine=InnoDB
create table orders (id bigint not null auto_increment, delivery_date datetime, estimated_days integer, last_status_update_date datetime, submit_date datetime, order_status_id bigint, shipper_id bigint, primary key (id)) engine=InnoDB
create table product (id bigint not null auto_increment, description varchar(255), min_stock integer, name varchar(255), category_id bigint, primary key (id)) engine=InnoDB
create table product_images (id bigint not null auto_increment, image_url varchar(255), product_id bigint, primary key (id)) engine=InnoDB
create table product_patch (id bigint not null auto_increment, date_in date, purchasing_price double precision, quantity integer, selling_price double precision, product_id bigint, user_id bigint, primary key (id)) engine=InnoDB
create table shipper (id bigint not null auto_increment, status bit, name varchar(255), phone_number varchar(255), shipping_fees double precision, primary key (id)) engine=InnoDB
create table user (id bigint not null auto_increment, email varchar(255), first_name varchar(255), last_name varchar(255), password varchar(255), phone_number1 varchar(255), phone_number2 varchar(255), cart_id bigint, user_type_id bigint, primary key (id)) engine=InnoDB
create table user_type (id bigint not null auto_increment, user_type varchar(255), primary key (id)) engine=InnoDB
alter table address add constraint FKda8tuywtf0gb6sedwk7la1pgi foreign key (user_id) references user (id)
alter table cart_item add constraint FKjcyd5wv4igqnw413rgxbfu4nv foreign key (product_id) references product (id)
alter table cart_item add constraint FK1uobyhgl1wvgt1jpccia8xxs3 foreign key (cart_id) references cart (id)
alter table classified_product add constraint FKi6nd8uiywrmo5qpx53f66e64q foreign key (grade_id) references grade (id)
alter table classified_product add constraint FKk0luccqk895q6ac612goa90s2 foreign key (product_id) references product (id)
alter table grade add constraint FKt9ng6d43us6n47ha3r3cj8l6f foreign key (grade_level) references grade_level (id)
alter table offers add constraint FKr6laelux55x74wkku2jn3krt3 foreign key (product_id) references product (id)
alter table order_details add constraint FK27vqmwve30hvoewnwtxyjnx4g foreign key (address_id) references address (id)
alter table order_details add constraint FKjyu2qbqt8gnvno9oe9j2s2ldk foreign key (order_id) references orders (id)
alter table order_details add constraint FKosrffjv6k8mr7ipsmmq7o7u1e foreign key (user_id) references user (id)
alter table order_item add constraint FK2mt791acwgdnhm5s1seaxam9x foreign key (classified_product_id) references classified_product (id)
alter table order_item add constraint FKt4dc2r9nbvbujrljv3e23iibt foreign key (order_id) references orders (id)
alter table order_item add constraint FK551losx9j75ss5d6bfsqvijna foreign key (product_id) references product (id)
alter table orders add constraint FK2n7p8t83wo7x0lep1q06a6cvy foreign key (order_status_id) references order_status (id)
alter table orders add constraint FKcw9s4yihuqduodjn391d630i8 foreign key (shipper_id) references shipper (id)
alter table product add constraint FK1mtsbur82frn64de7balymq9s foreign key (category_id) references category (id)
alter table product_images add constraint FKi8jnqq05sk5nkma3pfp3ylqrt foreign key (product_id) references product (id)
alter table product_patch add constraint FK5rvussdc7aofr4s2hy6xmv0fc foreign key (product_id) references product (id)
alter table product_patch add constraint FKcryv50b83q1ye4s3a3go5i8cw foreign key (user_id) references user (id)
alter table user add constraint FKtqa69bib34k2c0jhe7afqsao6 foreign key (cart_id) references cart (id)
alter table user add constraint FKlrk9xrdps0emd6d5rx5x3ib6h foreign key (user_type_id) references user_type (id)
create table address (id bigint not null auto_increment, apartment integer, building integer, city varchar(255), special_marque varchar(255), state varchar(255), street_details varchar(255), user_id bigint, primary key (id)) engine=InnoDB
create table cart (id bigint not null auto_increment, primary key (id)) engine=InnoDB
create table cart_item (id bigint not null auto_increment, quantity integer, product_id bigint, cart_id bigint, primary key (id)) engine=InnoDB
create table category (id bigint not null auto_increment, description varchar(255), image_url varchar(255), name varchar(255), primary key (id)) engine=InnoDB
create table classified_product (id bigint not null auto_increment, quantity integer, grade_id bigint, product_id bigint, primary key (id)) engine=InnoDB
create table grade (id bigint not null auto_increment, grade_number integer, grade_level bigint, primary key (id)) engine=InnoDB
create table grade_level (id bigint not null auto_increment, level varchar(255), primary key (id)) engine=InnoDB
create table offers (id bigint not null auto_increment, discount double precision, end_date datetime, start_date datetime, product_id bigint, primary key (id)) engine=InnoDB
create table order_details (id bigint not null auto_increment, address_id bigint, order_id bigint, user_id bigint, primary key (id)) engine=InnoDB
create table order_item (id bigint not null auto_increment, price_per_unit double precision, quantity integer, classified_product_id bigint, order_id bigint, product_id bigint, primary key (id)) engine=InnoDB
create table order_status (id bigint not null auto_increment, status varchar(255), primary key (id)) engine=InnoDB
create table orders (id bigint not null auto_increment, delivery_date datetime, estimated_days integer, last_status_update_date datetime, submit_date datetime, order_status_id bigint, shipper_id bigint, primary key (id)) engine=InnoDB
create table product (id bigint not null auto_increment, description varchar(255), min_stock integer, name varchar(255), category_id bigint, primary key (id)) engine=InnoDB
create table product_images (id bigint not null auto_increment, image_url varchar(255), product_id bigint, primary key (id)) engine=InnoDB
create table product_patch (id bigint not null auto_increment, date_in date, purchasing_price double precision, quantity integer, selling_price double precision, product_id bigint, user_id bigint, primary key (id)) engine=InnoDB
create table shipper (id bigint not null auto_increment, status bit, name varchar(255), phone_number varchar(255), shipping_fees double precision, primary key (id)) engine=InnoDB
create table user (id bigint not null auto_increment, email varchar(255), first_name varchar(255), last_name varchar(255), password varchar(255), phone_number1 varchar(255), phone_number2 varchar(255), cart_id bigint, user_type_id bigint, primary key (id)) engine=InnoDB
create table user_type (id bigint not null auto_increment, user_type varchar(255), primary key (id)) engine=InnoDB
alter table address add constraint FKda8tuywtf0gb6sedwk7la1pgi foreign key (user_id) references user (id)
alter table cart_item add constraint FKjcyd5wv4igqnw413rgxbfu4nv foreign key (product_id) references product (id)
alter table cart_item add constraint FK1uobyhgl1wvgt1jpccia8xxs3 foreign key (cart_id) references cart (id)
alter table classified_product add constraint FKi6nd8uiywrmo5qpx53f66e64q foreign key (grade_id) references grade (id)
alter table classified_product add constraint FKk0luccqk895q6ac612goa90s2 foreign key (product_id) references product (id)
alter table grade add constraint FKt9ng6d43us6n47ha3r3cj8l6f foreign key (grade_level) references grade_level (id)
alter table offers add constraint FKr6laelux55x74wkku2jn3krt3 foreign key (product_id) references product (id)
alter table order_details add constraint FK27vqmwve30hvoewnwtxyjnx4g foreign key (address_id) references address (id)
alter table order_details add constraint FKjyu2qbqt8gnvno9oe9j2s2ldk foreign key (order_id) references orders (id)
alter table order_details add constraint FKosrffjv6k8mr7ipsmmq7o7u1e foreign key (user_id) references user (id)
alter table order_item add constraint FK2mt791acwgdnhm5s1seaxam9x foreign key (classified_product_id) references classified_product (id)
alter table order_item add constraint FKt4dc2r9nbvbujrljv3e23iibt foreign key (order_id) references orders (id)
alter table order_item add constraint FK551losx9j75ss5d6bfsqvijna foreign key (product_id) references product (id)
alter table orders add constraint FK2n7p8t83wo7x0lep1q06a6cvy foreign key (order_status_id) references order_status (id)
alter table orders add constraint FKcw9s4yihuqduodjn391d630i8 foreign key (shipper_id) references shipper (id)
alter table product add constraint FK1mtsbur82frn64de7balymq9s foreign key (category_id) references category (id)
alter table product_images add constraint FKi8jnqq05sk5nkma3pfp3ylqrt foreign key (product_id) references product (id)
alter table product_patch add constraint FK5rvussdc7aofr4s2hy6xmv0fc foreign key (product_id) references product (id)
alter table product_patch add constraint FKcryv50b83q1ye4s3a3go5i8cw foreign key (user_id) references user (id)
alter table user add constraint FKtqa69bib34k2c0jhe7afqsao6 foreign key (cart_id) references cart (id)
alter table user add constraint FKlrk9xrdps0emd6d5rx5x3ib6h foreign key (user_type_id) references user_type (id)
create table address (id bigint not null auto_increment, apartment integer, building integer, city varchar(255), special_marque varchar(255), state varchar(255), street_details varchar(255), user_id bigint, primary key (id)) engine=InnoDB
create table cart (id bigint not null auto_increment, primary key (id)) engine=InnoDB
create table cart_item (id bigint not null auto_increment, quantity integer, product_id bigint, cart_id bigint, primary key (id)) engine=InnoDB
create table category (id bigint not null auto_increment, description varchar(255), image_url varchar(255), name varchar(255), primary key (id)) engine=InnoDB
create table classified_product (id bigint not null auto_increment, quantity integer, grade_id bigint, product_id bigint, primary key (id)) engine=InnoDB
create table grade (id bigint not null auto_increment, grade_number integer, grade_level bigint, primary key (id)) engine=InnoDB
create table grade_level (id bigint not null auto_increment, level varchar(255), primary key (id)) engine=InnoDB
create table offers (id bigint not null auto_increment, discount double precision, end_date datetime, start_date datetime, product_id bigint, primary key (id)) engine=InnoDB
create table order_details (id bigint not null auto_increment, address_id bigint, order_id bigint, user_id bigint, primary key (id)) engine=InnoDB
create table order_item (id bigint not null auto_increment, price_per_unit double precision, quantity integer, classified_product_id bigint, order_id bigint, product_id bigint, primary key (id)) engine=InnoDB
create table order_status (id bigint not null auto_increment, status varchar(255), primary key (id)) engine=InnoDB
create table orders (id bigint not null auto_increment, delivery_date datetime, estimated_days integer, last_status_update_date datetime, submit_date datetime, order_status_id bigint, shipper_id bigint, primary key (id)) engine=InnoDB
create table product (id bigint not null auto_increment, description varchar(255), min_stock integer, name varchar(255), category_id bigint, primary key (id)) engine=InnoDB
create table product_images (id bigint not null auto_increment, image_url varchar(255), product_id bigint, primary key (id)) engine=InnoDB
create table product_patch (id bigint not null auto_increment, date_in date, purchasing_price double precision, quantity integer, selling_price double precision, product_id bigint, user_id bigint, primary key (id)) engine=InnoDB
create table shipper (id bigint not null auto_increment, status bit, name varchar(255), phone_number varchar(255), shipping_fees double precision, primary key (id)) engine=InnoDB
create table user (id bigint not null auto_increment, email varchar(255), first_name varchar(255), last_name varchar(255), password varchar(255), phone_number1 varchar(255), phone_number2 varchar(255), cart_id bigint, user_type_id bigint, primary key (id)) engine=InnoDB
create table user_type (id bigint not null auto_increment, user_type varchar(255), primary key (id)) engine=InnoDB
alter table address add constraint FKda8tuywtf0gb6sedwk7la1pgi foreign key (user_id) references user (id)
alter table cart_item add constraint FKjcyd5wv4igqnw413rgxbfu4nv foreign key (product_id) references product (id)
alter table cart_item add constraint FK1uobyhgl1wvgt1jpccia8xxs3 foreign key (cart_id) references cart (id)
alter table classified_product add constraint FKi6nd8uiywrmo5qpx53f66e64q foreign key (grade_id) references grade (id)
alter table classified_product add constraint FKk0luccqk895q6ac612goa90s2 foreign key (product_id) references product (id)
alter table grade add constraint FKt9ng6d43us6n47ha3r3cj8l6f foreign key (grade_level) references grade_level (id)
alter table offers add constraint FKr6laelux55x74wkku2jn3krt3 foreign key (product_id) references product (id)
alter table order_details add constraint FK27vqmwve30hvoewnwtxyjnx4g foreign key (address_id) references address (id)
alter table order_details add constraint FKjyu2qbqt8gnvno9oe9j2s2ldk foreign key (order_id) references orders (id)
alter table order_details add constraint FKosrffjv6k8mr7ipsmmq7o7u1e foreign key (user_id) references user (id)
alter table order_item add constraint FK2mt791acwgdnhm5s1seaxam9x foreign key (classified_product_id) references classified_product (id)
alter table order_item add constraint FKt4dc2r9nbvbujrljv3e23iibt foreign key (order_id) references orders (id)
alter table order_item add constraint FK551losx9j75ss5d6bfsqvijna foreign key (product_id) references product (id)
alter table orders add constraint FK2n7p8t83wo7x0lep1q06a6cvy foreign key (order_status_id) references order_status (id)
alter table orders add constraint FKcw9s4yihuqduodjn391d630i8 foreign key (shipper_id) references shipper (id)
alter table product add constraint FK1mtsbur82frn64de7balymq9s foreign key (category_id) references category (id)
alter table product_images add constraint FKi8jnqq05sk5nkma3pfp3ylqrt foreign key (product_id) references product (id)
alter table product_patch add constraint FK5rvussdc7aofr4s2hy6xmv0fc foreign key (product_id) references product (id)
alter table product_patch add constraint FKcryv50b83q1ye4s3a3go5i8cw foreign key (user_id) references user (id)
alter table user add constraint FKtqa69bib34k2c0jhe7afqsao6 foreign key (cart_id) references cart (id)
alter table user add constraint FKlrk9xrdps0emd6d5rx5x3ib6h foreign key (user_type_id) references user_type (id)
