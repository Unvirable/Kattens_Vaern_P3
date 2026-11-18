
-- =============================================
-- USERS
-- =============================================

INSERT INTO users (user_type) VALUES
                                  ('admin'),
                                  ('member'),
                                  ('member'),
                                  ('member'),
                                  ('member');


-- =============================================
-- USER INFO
-- =============================================

INSERT INTO userInfo
(user_id, name, email, phonenumber, age, address)
VALUES
    (1, 'Emma Nielsen', 'emma.nielsen@example.com', '+4512345678', 32, 'Nørregade 12, 9000 Aalborg'),
    (2, 'Oliver Hansen', 'oliver.hansen@example.com', '+4523456789', 27, 'Vesterbro 45, 9000 Aalborg'),
    (3, 'Sofie Larsen', 'sofie.larsen@example.com', '+4534567890', 24, 'Algade 18, 9000 Aalborg'),
    (4, 'William Jensen', 'william.jensen@example.com', '+4545678901', 41, 'Boulevarden 22, 9000 Aalborg'),
    (5, 'Freja Andersen', 'freja.andersen@example.com', '+4556789012', 29, 'Kastetvej 31, 9000 Aalborg');


-- =============================================
-- MEMBERSHIPS
-- =============================================

INSERT INTO membership
(is_member, membership_number, user_id)
VALUES
    (TRUE, 'KV-2024-001', 1),
    (TRUE, 'KV-2024-002', 2),
    (TRUE, 'KV-2024-003', 3),
    (FALSE, 'KV-2024-004', 4),
    (TRUE, 'KV-2024-005', 5);


-- =============================================
-- CATS
-- =============================================

INSERT INTO cats
(name, birthday, gender, cat_type, description, located_in, availability)
VALUES
    ('Polly', '2022-01-01', 'HUN', 'INDE_UDE', 'Rolig og kærlig hunkat, som sætter pris på nus og søger et hjem, hvor hun kan blive forkælet og få ro.', 'BROENDBY', 'LEDIG'),
    ('Margit', '2026-06-22', 'HUN', 'INDE_UDE', 'Lidt forsigtig killing, der gerne vil nusses, når hun har lært mennesker at kende. Hun holder også af leg og lange lure.', 'BROENDBY', 'LEDIG'),
    ('Polle', '2026-06-22', 'HAN', 'INDE_UDE', 'Opsøgende og kælen killing med masser af personlighed. Han trives bedst som eneste kat i hjemmet.', 'BROENDBY', 'LEDIG'),
    ('Fiki', '2026-08-11', 'HAN', 'INDE_UDE', 'Nysgerrig killing, der først ser nye mennesker an og derefter gerne søger kontakt, nus og leg.', 'BROENDBY', 'LEDIG'),
    ('Fregne', '2024-06-01', 'HAN', 'INDE_UDE', 'Stor og lidt forsigtig hankat, som stadig vænner sig til internatet. Han viser mere af sin kærlige personlighed dag for dag.', 'BROENDBY', 'LEDIG'),
    ('DJ', '2022-04-20', 'HAN', 'INDE_UDE', 'Hankat, der ankom afkræftet og stadig er ved at falde til. Han spiser godt og nyder en god omgang nus.', 'BROENDBY', 'LEDIG'),
    ('Autumn', '2026-02-01', 'HUN', 'INDE_UDE', 'Nysgerrig og kontaktsøgende ungkat, der hurtigt begynder at spinde ved nus og har vist sig glad for andre katte.', 'BROENDBY', 'ADOPTERET'),
    ('Mario', '2026-06-11', 'HAN', 'INDE_UDE', 'Legesyg og kælen killing, som nyder selskabet med andre killinger og især holder af opmærksomhed og nus.', 'BROENDBY', 'LEDIG'),
    ('Sigga', '2026-05-23', 'HUN', 'INDE_UDE', 'Kærlig ungkat, som skal se nye ting an først. Hun søger et hjem med have og uden andre katte.', 'AALBORG', 'LEDIG'),
    ('Sommerfugl', '2025-10-21', 'HUN', 'INDE_UDE', 'Sød, voksen hunkat, der holder af nus og mad. Hun søger et hjem med have uden andre dyr.', 'AALBORG', 'LEDIG'),
    ('Muffe', '2026-08-06', 'HAN', 'INDE_UDE', 'Kærlig killing, der blev opfostret hos en plejemor efter at være fundet alene. Han søger et hjem med have uden andre katte.', 'AALBORG', 'LEDIG'),
    ('T-Rex', '2026-08-06', 'HAN', 'INDE_UDE', 'Meget kærlig og livlig killing, som søger et hjem uden andre katte.', 'AALBORG', 'LEDIG'),
    ('Teletubby', '2026-11-09', 'HUN', 'INDE_UDE', 'Sød killing, der er klar til et nyt hjem. Hun skal kunne komme ud, når hun er blevet gammel nok.', 'AALBORG', 'LEDIG'),
    ('Trille', '2026-11-09', 'HUN', 'INDE_UDE', 'Sød og skøn killing, der passer bedst i et hjem uden andre katte og senere skal have mulighed for udeliv.', 'AALBORG', 'LEDIG'),
    ('Tutsi', '2026-11-09', 'HUN', 'INDE_UDE', 'Kærlig killing, der holder af både nus og leg. Hun søger et hjem uden andre katte med mulighed for udeliv senere.', 'AALBORG', 'LEDIG'),
    ('Uldtot', '2026-08-06', 'HAN', 'INDE_UDE', 'Sød og kærlig hankilling.', 'AALBORG', 'LEDIG'),
    ('Yatzy', '2025-08-07', 'HUN', 'INDE_UDE', 'Lidt forsigtig hunkat, der bliver kærlig, når hun føler sig tryg. Hun nyder nus og at putte i små huler.', 'BILLUND', 'LEDIG'),
    ('Egone', '2024-05-01', 'HUN', 'INDE_UDE', 'Sød og kærlig kat, der nyder opmærksomhed og nus. Hun skal have mulighed for at komme ud i en have.', 'BILLUND', 'LEDIG'),
    ('Chicago', '2026-07-11', 'HUN', 'INDE_UDE', 'Killing, der har været i pleje sammen med sine kuldsøskende og nu er klar til et nyt hjem.', 'BILLUND', 'LEDIG'),
    ('Gøg og Silas', '2025-05-26', 'HAN', 'INDE_UDE', 'To hankatte, der ikke er søskende, men er blevet tæt knyttet og skal adopteres sammen. De finder tryghed i hinanden.', 'BILLUND', 'LEDIG'),
    ('Helga von katzenjammer', '2024-05-29', 'HUN', 'INDE_UDE', 'Kærlig og opsøgende hunkat, som gerne beder om nus. Hun har klare præferencer for en stor kattebakke og elsker udeliv.', 'BILLUND', 'LEDIG'),
    ('Duffy', '2026-07-01', 'HUN', 'INDE_UDE', 'Forsigtig killing, der har brug for et roligt hjem og tålmodige mennesker. Hun nyder at holde øje fra høje steder.', 'BILLUND', 'LEDIG'),
    ('Kiki', '2026-04-28', 'HUN', 'INDE_UDE', 'Sød, lidt forsigtig ungkat, som har brug for tid til at blive tryg ved nye mennesker. Hun skal have adgang til have.', 'BILLUND', 'LEDIG'),
    ('Gitte', '2025-04-28', 'HUN', 'INDE_UDE', 'Lidt forsigtig hunkat, der nyder nus, når hun føler sig tryg. Små huler og godbidder hjælper hende med at åbne sig.', 'BILLUND', 'LEDIG'),
    ('Izakaya', '2026-06-01', 'HUN', 'INDE_UDE', 'Sød og rolig killing, der er forsigtig ved nye mennesker, men gerne vil nusses, når hun er tryg. Ikke til små børn.', 'RINGSTED', 'LEDIG'),
    ('Alekto', '2026-05-30', 'HUN', 'INDE_UDE', 'Skøn, men forsigtig killing, der elsker at lege og gerne ligger højt for at holde øje med omgivelserne. Ikke til små børn.', 'RINGSTED', 'LEDIG'),
    ('Hiro', '2026-05-29', 'HUN', 'INDE_UDE', 'Sød, rolig og nysgerrig killing, der gerne vil nusses og lege.', 'RINGSTED', 'LEDIG'),
    ('Cramer', '2026-05-17', 'HAN', 'INDE_UDE', 'Sød og rolig killing, som er lidt forsigtig og har brug for at lære nye mennesker at kende. Han bliver kælen, når han er tryg.', 'RINGSTED', 'LEDIG'),
    ('Snoop', '2026-07-21', 'HUN', 'INDE_UDE', 'Sød og forsigtig killing, som også er meget kælen. Hun har brug for tålmodighed og senere adgang til udeliv.', 'RINGSTED', 'LEDIG'),
    ('Yougi', '2026-05-25', 'HUN', 'INDE_UDE', 'Profilen indeholder endnu ingen nærmere beskrivelse. Katten er markeret som adopteret på Kattens Værns side.', 'RINGSTED', 'ADOPTERET'),
    ('Lily Rose', '2026-05-11', 'HUN', 'INDE_UDE', 'Sød og rolig killing, som godt kan lide huler. Hun er lidt forsigtig ved nye mennesker og har brug for en rolig start.', 'RINGSTED', 'LEDIG'),
    ('Loulou', '2024-05-01', 'HUN', 'INDE_UDE', 'Sød og opsøgende hunkat, der gerne selv kommer hen for at hilse og blive kælet med.', 'RINGSTED', 'LEDIG'),
    ('Konrad', '2025-05-05', 'HAN', 'INDE_UDE', 'Sort/hvid hankat med masser af charme. Han elsker opmærksomhed og nus og skal på sigt have adgang til udeliv.', 'RINGE', 'LEDIG'),
    ('Mr Flapjack', '2026-05-09', 'HAN', 'INDE_UDE', 'Kælen og legesyg ungkat, som kan være forsigtig i store rum. Han trives bedst med ro og tid til at falde til.', 'RINGE', 'LEDIG'),
    ('Milo', '2026-05-20', 'HAN', 'INDE_UDE', 'Tidligere meget sky killing, som er blevet glad for nus og opmærksomhed, men stadig kan være lidt forsigtig i starten.', 'RINGE', 'ADOPTERET'),
    ('Amalie', '2026-06-15', 'HUN', 'INDE_UDE', 'Forsigtig killing, der gradvist er blevet mere nysgerrig og gerne vil nusses, når hun føler sig tryg.', 'RINGE', 'ADOPTERET'),
    ('Anne-Lise', '2024-05-20', 'HUN', 'INDE_UDE', 'Sky hunkat, der har brug for et roligt hjem og tålmodighed. Når hun er tryg, er hun meget kælen og mild.', 'RINGE', 'LEDIG'),
    ('Simba', '2025-07-09', 'HUN', 'INDE_UDE', 'Kælen og nysgerrig hunkat, der holder af opmærksomhed. Hun søger et hjem, hvor hun kan være både inde og ude.', 'RINGE', 'LEDIG'),
    ('Maude', '2023-10-16', 'HUN', 'INDE_UDE', 'Meget kælen over for mennesker, hun kender. Hun skal bo som eneste kat og på sigt have adgang til udeliv.', 'RINGE', 'ADOPTERET'),
    ('Anton', '2026-06-15', 'HAN', 'INDE_UDE', 'Killing, der er gået fra at være meget bange til at være kælen og selvsikker. Han nyder nus og opmærksomhed.', 'RINGE', 'ADOPTERET');



-- =============================================
-- MEDICAL RECORDS
-- =============================================

INSERT INTO medicalRecord
(cat_id, record_type, description, next_dueDate)
VALUES
    (
        1,
        'Vaccination',
        'First vaccination completed. Booster vaccination required.',
        '2026-12-15'
    ),
    (
        2,
        'Health Check',
        'General health examination completed. Cat is healthy.',
        '2027-03-10'
    ),
    (
        3,
        'Deworming',
        'Routine deworming treatment administered.',
        '2026-12-01'
    ),
    (
        4,
        'Dental Check',
        'Dental examination completed. Minor tartar buildup observed.',
        '2027-01-20'
    ),
    (
        5,
        'Vaccination',
        'Annual vaccination completed.',
        '2027-05-15'
    );


-- =============================================
-- ADOPTION RECORDS
-- =============================================

INSERT INTO adoptionRecord
(user_id, cat_id)
VALUES
    (2, 4),
    (3, 1),
    (5, 2);


-- =============================================
-- NEWS ARTICLES
-- =============================================

INSERT INTO newsArticles
(title, content, published_by)
VALUES
    (
        'New Cats Arrive at Aalborg Shelter',
        'We are happy to announce that several new cats have arrived at our Aalborg shelter. All cats have received an initial health examination and are now looking for loving forever homes. Visit our shelter to meet your potential new family member.',
        'Kattens Værn'
    ),
    (
        'Why You Should Consider Adopting an Older Cat',
        'Older cats can make wonderful companions. They are often calmer, have established personalities, and can adapt quickly to a loving home. By adopting an older cat, you are giving an animal a second chance at a happy life.',
        'Kattens Værn'
    ),
    (
        'Thank You to Our Amazing Volunteers',
        'Our volunteers play an essential role in caring for the cats at our shelters. From feeding and cleaning to socialising cats and helping with adoptions, every contribution makes a difference. Thank you for your continued support!',
        'Kattens Værn'
    );
