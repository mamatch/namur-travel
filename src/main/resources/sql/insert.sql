insert into end_user (first_name, last_name, number)
values ('Reidar', 'Beels', '467-667-9180');
insert into end_user (first_name, last_name, number)
values ('Ellsworth', 'Fessier', '472-400-0763');
insert into end_user (first_name, last_name, number)
values ('Doe', 'Tythe', '229-312-1916');
insert into end_user (first_name, last_name, number)
values ('Lyell', 'Farmloe', '347-176-2562');
insert into end_user (first_name, last_name, number)
values ('Enrique', 'Furlow', '767-796-2376');
insert into end_user (first_name, last_name, number)
values ('Meridith', 'Safont', '697-455-4080');
insert into end_user (first_name, last_name, number)
values ('Delaney', 'Grogona', '694-634-0205');
insert into end_user (first_name, last_name, number)
values ('Blancha', 'Muncer', '627-354-8460');
insert into end_user (first_name, last_name, number)
values ('Jessalyn', 'Maltman', '522-311-2735');
insert into end_user (first_name, last_name, number)
values ('Mackenzie', 'Duffit', '947-555-7436');
insert into end_user (first_name, last_name, number)
values ('Katleen', 'Nunson', '491-511-7744');
insert into end_user (first_name, last_name, number)
values ('Hodge', 'Orrill', '842-362-1946');
insert into end_user (first_name, last_name, number)
values ('Chaunce', 'Golda', '106-902-9798');
insert into end_user (first_name, last_name, number)
values ('Mike', 'Santacrole', '413-832-9706');
insert into end_user (first_name, last_name, number)
values ('Marice', 'Kilbourn', '422-720-9947');
insert into end_user (first_name, last_name, number)
values ('Freddie', 'Dutt', '815-717-3380');
insert into end_user (first_name, last_name, number)
values ('Ellie', 'Mansion', '658-282-0899');
insert into end_user (first_name, last_name, number)
values ('Titus', 'McLaggan', '615-357-7577');
insert into end_user (first_name, last_name, number)
values ('Tiffanie', 'Brownlee', '243-515-2097');
insert into end_user (first_name, last_name, number)
values ('Amie', 'Riolfi', '340-785-4636');


insert into city (name)
values ('Douala');
insert into city (name)
values ('Yaounde');

insert into airport (name, city_id)
values ('Douala Airport', 1);
insert into airport (name, city_id)
values ('Yaounde Airport', 2);
insert into flight (departure_airport_id, arrival_airport_id, departure_date, arrival_date, weight_available, price,
                    user_contact_id)
values (1, 2, now(), now(), 12.5, 15, 10);
