
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
(name, birthday, gender, catType, description, located_in, availability)
VALUES
    (
        'Milo',
        '2025-10-05',
        'Han',
        'Inde/ude Kat',
        'A playful and affectionate cat who loves attention and cuddles.',
        'Aalborg Shelter',
        'Available'
    ),
    (
        'Luna',
        '2022-11-17',
        'Hun',
        'Inde/ude Kat',
        'A calm and gentle female cat who enjoys relaxing in sunny spots.',
        'Aalborg Shelter',
        'Available'
    ),
    (
        'Oliver',
        '2025-11-17',
        'Han',
        'Inde/ude Kat',
        'A curious and energetic young cat who loves playing with toys.',
        'Aarhus Shelter',
        'Available'
    ),
    (
        'Bella',
        '2020-11-17',
        'Hun',
        'Inde/ude Kat',
        'A sweet and quiet cat who would thrive in a peaceful home.',
        'Odense Shelter',
        'Available'
    ),
    (
        'Charlie',
        '2023-11-17',
        'Han',
        'Inde/ude Kat',
        'A friendly and social cat who gets along well with other cats.',
        'Aalborg Shelter',
        'Available'
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
