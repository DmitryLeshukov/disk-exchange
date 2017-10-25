INSERT INTO public.ROLE
(name, created_date)
VALUES
  ('USER', NOW());

INSERT INTO public.USER
(login, last_name, first_name, middle_name, created_date, password, role_id)
VALUES
  ('vasin', 'Vasin', 'Vasiliy', 'Vasilievich', NOW(), '$2a$10$xFySs5RrscGbeKF7K6.WG.5WxFvxs3tCKbv3G.6leyMITsW53beAi', 1),
  ('petrov', 'Petrov', 'Petr', 'Petrovich', NOW(), '$2a$10$xFySs5RrscGbeKF7K6.WG.5WxFvxs3tCKbv3G.6leyMITsW53beAi', 1),
  ('dmitriev', 'Dmitirev', 'Dmitriy', 'Dmitrievich', NOW(), '$2a$10$xFySs5RrscGbeKF7K6.WG.5WxFvxs3tCKbv3G.6leyMITsW53beAi', 1),
  ('georgiev', 'Georgiev', 'Georgiy', 'Georgievich', NOW(), '$2a$10$xFySs5RrscGbeKF7K6.WG.5WxFvxs3tCKbv3G.6leyMITsW53beAi', 1),
  ('andreev', 'Andreev', 'Andrey', 'Andreevich', NOW(), '$2a$10$xFySs5RrscGbeKF7K6.WG.5WxFvxs3tCKbv3G.6leyMITsW53beAi', 1);

INSERT INTO public.DISK
(title, description, year, owner_id, created_date)
VALUES
  ('title1', 'description1', '2017', 1, NOW()),
  ('title2', 'description2', '2017', 2, NOW()),
  ('title3', 'description3', '2017', 3, NOW()),
  ('title4', 'description4', '2017', 4, NOW()),
  ('title5', 'description5', '2017', 5, NOW());