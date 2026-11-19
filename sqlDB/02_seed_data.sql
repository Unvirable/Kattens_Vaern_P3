
-- =============================================
-- USERS
-- =============================================

INSERT INTO users (user_type, password_hash) VALUES
                                  ('admin', '$2a$10$Ws9vpJXcqkBxgZnoCAApAuqIvknUVjZtRCF7Ls29DhP/9b21H3/ky'),
                                  ('user', '$2a$10$trk0GFGnPwIyz4EI2TiMKeuc2Jox4iKGndSzVrPLqlRgjwncRyXhu'),
                                  ('user', '$2a$10$trk0GFGnPwIyz4EI2TiMKeuc2Jox4iKGndSzVrPLqlRgjwncRyXhu'),
                                  ('user', '$2a$10$trk0GFGnPwIyz4EI2TiMKeuc2Jox4iKGndSzVrPLqlRgjwncRyXhu'),
                                  ('user', '$2a$10$trk0GFGnPwIyz4EI2TiMKeuc2Jox4iKGndSzVrPLqlRgjwncRyXhu');


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
(name, birthday, gender, catType, description, located_in, availability)
VALUES
    (
        'Polly',
        '2022-01-01',
        'Hun',
        'Hus-/havekat',
        'Rolig og kærlig hunkat, som sætter pris på nus og søger et hjem, hvor hun kan blive forkælet og få ro.',
        'Brøndby Shelter',
        'Available'
    ),
    (
        'Margit',
        '2026-06-22',
        'Hun',
        'Hus-/havekat',
        'Lidt forsigtig killing, der gerne vil nusses, når hun har lært mennesker at kende. Hun holder også af leg og lange lure.',
        'Brøndby Shelter',
        'Available'
    ),
    (
        'Polle',
        '2026-06-22',
        'Han',
        'Hus-/havekat',
        'Opsøgende og kælen killing med masser af personlighed. Han trives bedst som eneste kat i hjemmet.',
        'Brøndby Shelter',
        'Available'
    ),
    (
        'Fiki',
        '2026-08-11',
        'Han',
        'Hus-/havekat',
        'Nysgerrig killing, der først ser nye mennesker an og derefter gerne søger kontakt, nus og leg.',
        'Brøndby Shelter',
        'Available'
    ),
    (
        'Fregne',
        '2024-06-01',
        'Han',
        'Hus-/havekat',
        'Stor og lidt forsigtig hankat, som stadig vænner sig til internatet. Han viser mere af sin kærlige personlighed dag for dag.',
        'Brøndby Shelter',
        'Available'
    ),
    (
        'DJ',
        '2022-04-20',
        'Han',
        'Hus-/havekat',
        'Hankat, der ankom afkræftet og stadig er ved at falde til. Han spiser godt og nyder en god omgang nus.',
        'Brøndby Shelter',
        'Available'
    ),
    (
        'Autumn',
        '2026-02-01',
        'Hun',
        'Hus-/havekat',
        'Nysgerrig og kontaktsøgende ungkat, der hurtigt begynder at spinde ved nus og har vist sig glad for andre katte.',
        'Brøndby Shelter',
        'Adopted'
    ),
    (
        'Mario',
        '2026-06-11',
        'Han',
        'Hus-/havekat',
        'Legesyg og kælen killing, som nyder selskabet med andre killinger og især holder af opmærksomhed og nus.',
        'Brøndby Shelter',
        'Available'
    ),
    (
        'Sigga',
        '2026-05-23',
        'Hun',
        'Hus-/havekat',
        'Kærlig ungkat, som skal se nye ting an først. Hun søger et hjem med have og uden andre katte.',
        'Aalborg Shelter',
        'Available'
    ),
    (
        'Sommerfugl',
        '2025-10-21',
        'Hun',
        'Hus-/havekat',
        'Sød, voksen hunkat, der holder af nus og mad. Hun søger et hjem med have uden andre dyr.',
        'Aalborg Shelter',
        'Available'
    ),
    (
        'Muffe',
        '2026-08-06',
        'Han',
        'Hus-/havekat',
        'Kærlig killing, der blev opfostret hos en plejemor efter at være fundet alene. Han søger et hjem med have uden andre katte.',
        'Aalborg Shelter',
        'Available'
    ),
    (
        'T-Rex',
        '2026-08-06',
        'Han',
        'Hus-/havekat',
        'Meget kærlig og livlig killing, som søger et hjem uden andre katte.',
        'Aalborg Shelter',
        'Available'
    ),
    (
        'Teletubby',
        '2026-11-09',
        'Hun',
        'Hus-/havekat',
        'Sød killing, der er klar til et nyt hjem. Hun skal kunne komme ud, når hun er blevet gammel nok.',
        'Aalborg Shelter',
        'Available'
    ),
    (
        'Trille',
        '2026-11-09',
        'Hun',
        'Hus-/havekat',
        'Sød og skøn killing, der passer bedst i et hjem uden andre katte og senere skal have mulighed for udeliv.',
        'Aalborg Shelter',
        'Available'
    ),
    (
        'Tutsi',
        '2026-11-09',
        'Hun',
        'Hus-/havekat',
        'Kærlig killing, der holder af både nus og leg. Hun søger et hjem uden andre katte med mulighed for udeliv senere.',
        'Aalborg Shelter',
        'Available'
    ),
    (
        'Uldtot',
        '2026-08-06',
        'Han',
        'Hus-/havekat',
        'Sød og kærlig hankilling.',
        'Aalborg Shelter',
        'Available'
    ),
    (
        'Yatzy',
        '2025-08-07',
        'Hun',
        'Hus-/havekat',
        'Lidt forsigtig hunkat, der bliver kærlig, når hun føler sig tryg. Hun nyder nus og at putte i små huler.',
        'Billund Shelter',
        'Available'
    ),
    (
        'Egone',
        '2024-05-01',
        'Hun',
        'Hus-/havekat',
        'Sød og kærlig kat, der nyder opmærksomhed og nus. Hun skal have mulighed for at komme ud i en have.',
        'Billund Shelter',
        'Available'
    ),
    (
        'Chicago',
        '2026-07-11',
        'Hun',
        'Hus-/havekat',
        'Killing, der har været i pleje sammen med sine kuldsøskende og nu er klar til et nyt hjem.',
        'Billund Shelter',
        'Available'
    ),
    (
        'Gøg og Silas',
        '2025-05-26',
        'Han',
        'Hus-/havekat',
        'To hankatte, der ikke er søskende, men er blevet tæt knyttet og skal adopteres sammen. De finder tryghed i hinanden.',
        'Billund Shelter',
        'Available'
    ),
    (
        'Helga von katzenjammer',
        '2024-05-29',
        'Hun',
        'Hus-/havekat',
        'Kærlig og opsøgende hunkat, som gerne beder om nus. Hun har klare præferencer for en stor kattebakke og elsker udeliv.',
        'Billund Shelter',
        'Available'
    ),
    (
        'Duffy',
        '2026-07-01',
        'Hun',
        'Hus-/havekat, Gårdkat',
        'Forsigtig killing, der har brug for et roligt hjem og tålmodige mennesker. Hun nyder at holde øje fra høje steder.',
        'Billund Shelter',
        'Available'
    ),
    (
        'Kiki',
        '2026-04-28',
        'Hun',
        'Hus-/havekat',
        'Sød, lidt forsigtig ungkat, som har brug for tid til at blive tryg ved nye mennesker. Hun skal have adgang til have.',
        'Billund Shelter',
        'Available'
    ),
    (
        'Gitte',
        '2025-04-28',
        'Hun',
        'Hus-/havekat',
        'Lidt forsigtig hunkat, der nyder nus, når hun føler sig tryg. Små huler og godbidder hjælper hende med at åbne sig.',
        'Billund Shelter',
        'Available'
    ),
    (
        'Izakaya',
        '2026-06-01',
        'Hun',
        'Hus-/havekat',
        'Sød og rolig killing, der er forsigtig ved nye mennesker, men gerne vil nusses, når hun er tryg. Ikke til små børn.',
        'Ringsted Shelter',
        'Available'
    ),
    (
        'Alekto',
        '2026-05-30',
        'Hun',
        'Hus-/havekat',
        'Skøn, men forsigtig killing, der elsker at lege og gerne ligger højt for at holde øje med omgivelserne. Ikke til små børn.',
        'Ringsted Shelter',
        'Available'
    ),
    (
        'Hiro',
        '2026-05-29',
        'Hun',
        'Hus-/havekat',
        'Sød, rolig og nysgerrig killing, der gerne vil nusses og lege.',
        'Ringsted Shelter',
        'Available'
    ),
    (
        'Cramer',
        '2026-05-17',
        'Han',
        'Hus-/havekat',
        'Sød og rolig killing, som er lidt forsigtig og har brug for at lære nye mennesker at kende. Han bliver kælen, når han er tryg.',
        'Ringsted Shelter',
        'Available'
    ),
    (
        'Snoop',
        '2026-07-21',
        'Hun',
        'Hus-/havekat',
        'Sød og forsigtig killing, som også er meget kælen. Hun har brug for tålmodighed og senere adgang til udeliv.',
        'Ringsted Shelter',
        'Available'
    ),
    (
        'Yougi',
        '2026-05-25',
        'Hun',
        'Hus-/havekat',
        'Profilen indeholder endnu ingen nærmere beskrivelse. Katten er markeret som adopteret på Kattens Værns side.',
        'Ringsted Shelter',
        'Adopted'
    ),
    (
        'Lily Rose',
        '2026-05-11',
        'Hun',
        'Hus-/havekat',
        'Sød og rolig killing, som godt kan lide huler. Hun er lidt forsigtig ved nye mennesker og har brug for en rolig start.',
        'Ringsted Shelter',
        'Available'
    ),
    (
        'Loulou',
        '2024-05-01',
        'Hun',
        'Hus-/havekat',
        'Sød og opsøgende hunkat, der gerne selv kommer hen for at hilse og blive kælet med.',
        'Ringsted Shelter',
        'Available'
    ),
    (
        'Konrad',
        '2025-05-05',
        'Han',
        'Hus-/havekat',
        'Sort/hvid hankat med masser af charme. Han elsker opmærksomhed og nus og skal på sigt have adgang til udeliv.',
        'Ringe Shelter',
        'Available'
    ),
    (
        'Mr Flapjack',
        '2026-05-09',
        'Han',
        'Hus-/havekat, Gårdkat',
        'Kælen og legesyg ungkat, som kan være forsigtig i store rum. Han trives bedst med ro og tid til at falde til.',
        'Ringe Shelter',
        'Available'
    ),
    (
        'Milo',
        '2026-05-20',
        'Han',
        'Hus-/havekat',
        'Tidligere meget sky killing, som er blevet glad for nus og opmærksomhed, men stadig kan være lidt forsigtig i starten.',
        'Ringe Shelter',
        'Adopted'
    ),
    (
        'Amalie',
        '2026-06-15',
        'Hun',
        'Hus-/havekat',
        'Forsigtig killing, der gradvist er blevet mere nysgerrig og gerne vil nusses, når hun føler sig tryg.',
        'Ringe Shelter',
        'Adopted'
    ),
    (
        'Anne-Lise',
        '2024-05-20',
        'Hun',
        'Hus-/havekat',
        'Sky hunkat, der har brug for et roligt hjem og tålmodighed. Når hun er tryg, er hun meget kælen og mild.',
        'Ringe Shelter',
        'Available'
    ),
    (
        'Simba',
        '2025-07-09',
        'Hun',
        'Hus-/havekat',
        'Kælen og nysgerrig hunkat, der holder af opmærksomhed. Hun søger et hjem, hvor hun kan være både inde og ude.',
        'Ringe Shelter',
        'Available'
    ),
    (
        'Maude',
        '2023-10-16',
        'Hun',
        'Hus-/havekat',
        'Meget kælen over for mennesker, hun kender. Hun skal bo som eneste kat og på sigt have adgang til udeliv.',
        'Ringe Shelter',
        'Adopted'
    ),
    (
        'Anton',
        '2026-06-15',
        'Han',
        'Hus-/havekat',
        'Killing, der er gået fra at være meget bange til at være kælen og selvsikker. Han nyder nus og opmærksomhed.',
        'Ringe Shelter',
        'Adopted'
    );


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
