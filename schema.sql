CREATE TABLE IF NOT EXISTS songs (
    notes       VARCHAR(10) NOT NULL,
    title       VARCHAR(50) NOT NULL,

    CONSTRAINT pk_songs
        PRIMARY KEY (notes)
);

INSERT IGNORE INTO songs (notes, title) VALUES
    ('awdawd', 'Zelda''s Lullaby'),
    ('wadwad', 'Epona''s Song'),
    ('kdakda', 'Saria''s Song'),
    ('dkwdkw', 'Sun''s Song'),
    ('djkdjk', 'Song of Time'),
    ('jkwjkw', 'Song of Storms'),
    ('jwakwa', 'Minuet of the Forest'),
    ('wdwdaw', 'Prelude of Light'),
    ('kjkjdkdk', 'Bolero of Fire'),
    ('jkdda', 'Serenade of Water'),
    ('addjadk', 'Nocturne of Shadow'),
    ('jkjdkj', 'Requiem of Spirit');