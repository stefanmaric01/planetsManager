insert into planets( id,name,average_surface_temperature, distance_from_sun, mass, surface_area)
VALUES ( 6756,'Earth', 500000, 1230000, 250000, 20);
insert into planets(id, name,average_surface_temperature, distance_from_sun, mass,  surface_area)
VALUES (111, 'Jupiter', 500000, 12300000, 2500000, -50);
insert into planets(id,name, average_surface_temperature, distance_from_sun, mass,  surface_area)
VALUES (22, 'Venus', 5000, 200000, 1000000, 150);
insert into planets(id, name,average_surface_temperature, distance_from_sun, mass, surface_area)
VALUES (33, 'Saturn', 500000, 1230000, 14000000, -120);
insert into planets(id,name, average_surface_temperature, distance_from_sun, mass,  surface_area)
VALUES (44, 'Mercury', 50000, 220000, 900000, 220);
insert into planets(id,name, average_surface_temperature, distance_from_sun, mass,  surface_area)
VALUES (90, 'Mars', 50000, 220000, 900000, 220);

insert into satellites(id,name,planet_id, mass,natural_satellite, surface_area)
VALUES (44, 'MercuryMoon', 44, 220000, true, 22024);
insert into satellites(id,name,planet_id, mass,natural_satellite, surface_area)
VALUES (45, 'MercuryMoon2', 44, 220001, false, 2201);
insert into satellites(id,name,planet_id, mass,natural_satellite, surface_area)
VALUES (46, 'MercuryMoon3', 44, 220002, true, 220220);
insert into satellites(id,name,planet_id, mass,natural_satellite, surface_area)
VALUES (47, 'SaturnMoon', 33, 220000, true, 22024);
insert into satellites(id,name,planet_id, mass,natural_satellite, surface_area)
VALUES (2937, 'SaturnMoon2', 33, 220001, false, 2201);
insert into satellites(id,name,planet_id, mass,natural_satellite, surface_area)
VALUES (83482, 'SaturnMoon3', 33, 220002, true, 220220);
insert into satellites(id,name,planet_id, mass,natural_satellite, surface_area)
VALUES (891, 'VenusMoon', 22, 220000, true, 22024);
insert into satellites(id,name,planet_id, mass,natural_satellite, surface_area)
VALUES (4829, 'VenusMoon2', 22, 220001, false, 2201);
insert into satellites(id,name,planet_id, mass,natural_satellite, surface_area)
VALUES (1140, 'VenusMoon3', 22, 220002, true, 220220);
insert into satellites(id,name,planet_id, mass,natural_satellite, surface_area)
VALUES (8391, 'JupiterMoon', 111, 220000, true, 22024);
insert into satellites(id,name,planet_id, mass,natural_satellite, surface_area)
VALUES (489, 'JupiterMoon2', 111, 220001, false, 2201);
insert into satellites(id,name,planet_id, mass,natural_satellite, surface_area)
VALUES (140, 'JupiterMoon3', 111, 220002, true, 220220);
insert into satellites(id,name,planet_id, mass,natural_satellite, surface_area)
VALUES (833, 'Moon', 6756, 220000, true, 22024);
insert into satellites(id,name,planet_id, mass,natural_satellite, surface_area)
VALUES (482, 'Moon2', 6756, 220001, false, 2201);
insert into satellites(id,name,planet_id, mass,natural_satellite, surface_area)
VALUES (1160, 'Moon3', 6756, 220002, true, 220220);