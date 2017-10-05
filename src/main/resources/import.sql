-- polls
INSERT INTO poll (id, name, address, postcode) VALUES ('1', 'main', '3 main street', 'M2P 2H1')
INSERT INTO poll (id, name, address, postcode) VALUES ('2', 'park', '3 park road', 'M3C 0C1')

-- parties
INSERT INTO party (id, name) VALUES ('1', 'fun')
INSERT INTO party (id, name) VALUES ('2', 'serious')

-- candidates
INSERT INTO candidate (id, name, party_id) VALUES ('1', 'Sam', '1')
INSERT INTO candidate (id, name, party_id) VALUES ('2', 'Joe', '2')