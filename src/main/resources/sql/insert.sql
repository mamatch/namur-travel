insert into end_user (id, first_name, last_name, number)
values ('665e13d5-0475-44f2-a75c-6b5efd0e73ab', 'Irina', 'Johns', '530-495-2503');
insert into end_user (id, first_name, last_name, number)
values ('3d37ee38-3cc4-4918-9704-22f821aa4e59', 'Jenny', 'Swaffer', '776-500-2033');
insert into end_user (id, first_name, last_name, number)
values ('f3de2f10-1c05-4491-8324-634ca3b4bf71', 'Petrina', 'Kleynen', '544-102-7836');
insert into end_user (id, first_name, last_name, number)
values ('241dce91-51bb-44b6-83f9-28ed25956dd6', 'Auberon', 'Rennison', '920-975-3129');
insert into end_user (id, first_name, last_name, number)
values ('329cf6a2-44dc-4fcf-9800-f4785413a285', 'Jonah', 'Withams', '901-508-3658');
insert into end_user (id, first_name, last_name, number)
values ('48358b2a-a69c-4a92-ad9c-beb62bd1ffaa', 'Gianina', 'Nund', '442-870-5136');
insert into end_user (id, first_name, last_name, number)
values ('0a9993bd-2783-467c-851b-cab11e14f9d9', 'Noelani', 'Hodcroft', '209-367-8119');
insert into end_user (id, first_name, last_name, number)
values ('6c1bbb1b-44a5-4eda-b768-edf86e80c6eb', 'Perceval', 'O'' Borne', '159-450-6533');
insert into end_user (id, first_name, last_name, number)
values ('8b4857c4-18c3-434d-9e20-12bdd53835a7', 'Osborne', 'Fealy', '710-286-5111');
insert into end_user (id, first_name, last_name, number)
values ('c9679e68-9a70-45ff-a900-d9f719e5eccc', 'Nicky', 'Offill', '520-905-2305');
insert into end_user (id, first_name, last_name, number)
values ('6def2662-bef9-4493-a7d7-0ff45eae3041', 'Queenie', 'Dinesen', '301-199-8421');
insert into end_user (id, first_name, last_name, number)
values ('3bcee4ce-8d87-4b07-8ac5-4dbb5c01ec69', 'Yankee', 'Hobbert', '349-709-9043');
insert into end_user (id, first_name, last_name, number)
values ('f1a9d106-0309-4d7b-b21e-029eb848a98b', 'Luke', 'Hainey', '681-455-5974');
insert into end_user (id, first_name, last_name, number)
values ('a5e7646a-25e9-4678-9c84-4196f98a38c8', 'Demetra', 'Gosnoll', '573-883-5239');
insert into end_user (id, first_name, last_name, number)
values ('0791ab7a-4a4d-44b8-85e5-47bb8d386fc6', 'Marcellina', 'Agutter', '721-680-5049');
insert into end_user (id, first_name, last_name, number)
values ('294cf3db-1a62-4ac6-bf90-bf599e2941b4', 'Cullin', 'Roseaman', '989-507-7532');
insert into end_user (id, first_name, last_name, number)
values ('52b3f41c-9920-4192-acdf-f8a7c4e4497c', 'Drucy', 'Ruvel', '543-179-7928');
insert into end_user (id, first_name, last_name, number)
values ('5955aa86-741b-47fb-8b06-69725fd4b486', 'Bernie', 'Dwelley', '882-181-9622');
insert into end_user (id, first_name, last_name, number)
values ('b7385fd7-1953-4c4c-ba73-e9cad0901a3e', 'Mira', 'Petrolli', '925-703-6492');
insert into end_user (id, first_name, last_name, number)
values ('b9357c5e-baf3-431f-8ba4-3b63de7ba61f', 'Josephine', 'Ruxton', '785-307-9204');

insert into city (id, name)
values ('b9357c5e-baf3-431f-8ba4-3b63de7ba61r', 'Douala');
insert into city (id, name)
values ('b9357c5e-baf3-431f-8ba4-3b63de7ba61y', 'Yaounde');

insert into airport (id, name, city_id)
values ('b9357c5e-baf3-431f-8ba4-3b63de7ba61ad', 'Douala Airport', 'b9357c5e-baf3-431f-8ba4-3b63de7ba61r');
insert into airport (id, name, city_id)
values ('b9357c5e-baf3-431f-8ba4-3b63de7ba61ay', 'Yaounde Airport', 'b9357c5e-baf3-431f-8ba4-3b63de7ba61y');
insert into flight (id, departure_airport_id, arrival_airport_id, departure_date, arrival_date, weight_available, price,
                    user_contact_id)
values ('b9357c5e-baf3-431f-8ba4-3b63de7ba61f1', 'b9357c5e-baf3-431f-8ba4-3b63de7ba61ad',
        'b9357c5e-baf3-431f-8ba4-3b63de7ba61ay', now(), now(), 12.5, 15, 'b7385fd7-1953-4c4c-ba73-e9cad0901a3e');
