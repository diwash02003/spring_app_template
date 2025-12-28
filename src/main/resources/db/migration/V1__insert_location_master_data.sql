INSERT INTO country (name, code)
VALUES ('Nepal', 'NP');

INSERT INTO province (name, code)
VALUES ('Koshi Province', 'KOP'),
       ('Madhesh Province', 'MP'),
       ('Bagmati Province', 'BP'),
       ('Gandaki Province', 'GP'),
       ('Lumbini Province', 'LP'),
       ('Karnali Province', 'KAP'),
       ('Sudurpashchim Province', 'SPP');

INSERT INTO district (name, code, province_id)
VALUES ('Bhojpur', 'BJP', (SELECT id FROM province WHERE code = 'KOP')),
       ('Dhankuta', 'DNK', (SELECT id FROM province WHERE code = 'KOP')),
       ('Ilam', 'ILM', (SELECT id FROM province WHERE code = 'KOP')),
       ('Jhapa', 'JHP', (SELECT id FROM province WHERE code = 'KOP')),
       ('Khotang', 'KHT', (SELECT id FROM province WHERE code = 'KOP')),
       ('Morang', 'MRG', (SELECT id FROM province WHERE code = 'KOP')),
       ('Okhaldhunga', 'OKH', (SELECT id FROM province WHERE code = 'KOP')),
       ('Panchthar', 'PCH', (SELECT id FROM province WHERE code = 'KOP')),
       ('Sankhuwasabha', 'SKS', (SELECT id FROM province WHERE code = 'KOP')),
       ('Solukhumbu', 'SLK', (SELECT id FROM province WHERE code = 'KOP')),
       ('Sunsari', 'SNS', (SELECT id FROM province WHERE code = 'KOP')),
       ('Taplejung', 'TPL', (SELECT id FROM province WHERE code = 'KOP')),
       ('Terhathum', 'TRH', (SELECT id FROM province WHERE code = 'KOP')),
       ('Udayapur', 'UDP', (SELECT id FROM province WHERE code = 'KOP'));

INSERT INTO district (name, code, province_id)
VALUES ('Bara', 'BRA', (SELECT id FROM province WHERE code = 'MP')),
       ('Dhanusha', 'DHS', (SELECT id FROM province WHERE code = 'MP')),
       ('Mahottari', 'MHT', (SELECT id FROM province WHERE code = 'MP')),
       ('Parsa', 'PRS', (SELECT id FROM province WHERE code = 'MP')),
       ('Rautahat', 'RTH', (SELECT id FROM province WHERE code = 'MP')),
       ('Saptari', 'SPT', (SELECT id FROM province WHERE code = 'MP')),
       ('Sarlahi', 'SRL', (SELECT id FROM province WHERE code = 'MP')),
       ('Siraha', 'SRH', (SELECT id FROM province WHERE code = 'MP'));

INSERT INTO district (name, code, province_id)
VALUES ('Bhaktapur', 'BKP', (SELECT id FROM province WHERE code = 'BP')),
       ('Chitwan', 'CTW', (SELECT id FROM province WHERE code = 'BP')),
       ('Dhading', 'DHD', (SELECT id FROM province WHERE code = 'BP')),
       ('Dolakha', 'DLK', (SELECT id FROM province WHERE code = 'BP')),
       ('Kathmandu', 'KTM', (SELECT id FROM province WHERE code = 'BP')),
       ('Kavrepalanchok', 'KVR', (SELECT id FROM province WHERE code = 'BP')),
       ('Lalitpur', 'LTP', (SELECT id FROM province WHERE code = 'BP')),
       ('Makwanpur', 'MKW', (SELECT id FROM province WHERE code = 'BP')),
       ('Nuwakot', 'NWK', (SELECT id FROM province WHERE code = 'BP')),
       ('Ramechhap', 'RMC', (SELECT id FROM province WHERE code = 'BP')),
       ('Rasuwa', 'RSW', (SELECT id FROM province WHERE code = 'BP')),
       ('Sindhuli', 'SDL', (SELECT id FROM province WHERE code = 'BP')),
       ('Sindhupalchok', 'SDP', (SELECT id FROM province WHERE code = 'BP'));

INSERT INTO district (name, code, province_id)
VALUES ('Baglung', 'BGL', (SELECT id FROM province WHERE code = 'GP')),
       ('Gorkha', 'GRK', (SELECT id FROM province WHERE code = 'GP')),
       ('Kaski', 'KSK', (SELECT id FROM province WHERE code = 'GP')),
       ('Lamjung', 'LMJ', (SELECT id FROM province WHERE code = 'GP')),
       ('Manang', 'MNG', (SELECT id FROM province WHERE code = 'GP')),
       ('Mustang', 'MST', (SELECT id FROM province WHERE code = 'GP')),
       ('Myagdi', 'MYG', (SELECT id FROM province WHERE code = 'GP')),
       ('Nawalpur', 'NWP', (SELECT id FROM province WHERE code = 'GP')),
       ('Parbat', 'PRB', (SELECT id FROM province WHERE code = 'GP')),
       ('Syangja', 'SYJ', (SELECT id FROM province WHERE code = 'GP')),
       ('Tanahun', 'TNH', (SELECT id FROM province WHERE code = 'GP'));

INSERT INTO district (name, code, province_id)
VALUES ('Arghakhanchi', 'ARG', (SELECT id FROM province WHERE code = 'LP')),
       ('Banke', 'BNK', (SELECT id FROM province WHERE code = 'LP')),
       ('Bardiya', 'BRD', (SELECT id FROM province WHERE code = 'LP')),
       ('Dang', 'DNG', (SELECT id FROM province WHERE code = 'LP')),
       ('Gulmi', 'GLM', (SELECT id FROM province WHERE code = 'LP')),
       ('Kapilvastu', 'KPL', (SELECT id FROM province WHERE code = 'LP')),
       ('Nawalparasi East', 'NPE', (SELECT id FROM province WHERE code = 'LP')),
       ('Nawalparasi West', 'NPW', (SELECT id FROM province WHERE code = 'LP')),
       ('Palpa', 'PLP', (SELECT id FROM province WHERE code = 'LP')),
       ('Pyuthan', 'PYT', (SELECT id FROM province WHERE code = 'LP')),
       ('Rolpa', 'RLP', (SELECT id FROM province WHERE code = 'LP')),
       ('Rukum East', 'RKE', (SELECT id FROM province WHERE code = 'LP'));

INSERT INTO district (name, code, province_id)
VALUES ('Dailekh', 'DLH', (SELECT id FROM province WHERE code = 'KAP')),
       ('Dolpa', 'DLP', (SELECT id FROM province WHERE code = 'KAP')),
       ('Humla', 'HML', (SELECT id FROM province WHERE code = 'KAP')),
       ('Jajarkot', 'JJK', (SELECT id FROM province WHERE code = 'KAP')),
       ('Jumla', 'JML', (SELECT id FROM province WHERE code = 'KAP')),
       ('Kalikot', 'KLT', (SELECT id FROM province WHERE code = 'KAP')),
       ('Mugu', 'MGU', (SELECT id FROM province WHERE code = 'KAP')),
       ('Rukum West', 'RKW', (SELECT id FROM province WHERE code = 'KAP')),
       ('Salyan', 'SLY', (SELECT id FROM province WHERE code = 'KAP')),
       ('Surkhet', 'SRK', (SELECT id FROM province WHERE code = 'KAP'));

INSERT INTO district (name, code, province_id)
VALUES ('Achham', 'ACH', (SELECT id FROM province WHERE code = 'SPP')),
       ('Baitadi', 'BTD', (SELECT id FROM province WHERE code = 'SPP')),
       ('Bajhang', 'BJH', (SELECT id FROM province WHERE code = 'SPP')),
       ('Bajura', 'BJR', (SELECT id FROM province WHERE code = 'SPP')),
       ('Dadeldhura', 'DDL', (SELECT id FROM province WHERE code = 'SPP')),
       ('Darchula', 'DRC', (SELECT id FROM province WHERE code = 'SPP')),
       ('Doti', 'DTI', (SELECT id FROM province WHERE code = 'SPP')),
       ('Kailali', 'KLI', (SELECT id FROM province WHERE code = 'SPP')),
       ('Kanchanpur', 'KCP', (SELECT id FROM province WHERE code = 'SPP'));

