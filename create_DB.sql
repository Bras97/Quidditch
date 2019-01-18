CREATE TABLE druzyna (
    id_druzyny            INTEGER NOT NULL AUTO_INCREMENT,
    id_stadionu           INTEGER NOT NULL,
    nazwa                 VARCHAR(32) NOT NULL,
    narodowosc            VARCHAR(16),
    stadion_id_stadionu   INTEGER NOT NULL,
    PRIMARY KEY (id_druzyny)
);

ALTER TABLE druzyna ADD CONSTRAINT druzyna_nazwa_un UNIQUE ( nazwa );

CREATE TABLE kara (
    id_kary                 INTEGER NOT NULL AUTO_INCREMENT,
    typ_kary                VARCHAR(16) NOT NULL,
    okres_wykluczenia       INTEGER NOT NULL,
    zawodnik_id_zawodnika   INTEGER NOT NULL,
    PRIMARY KEY (id_kary)
);

CREATE TABLE miotla (
    id_miotly               INTEGER NOT NULL AUTO_INCREMENT,
    model                   VARCHAR(32) NOT NULL,
    predkosc                FLOAT(2),
    tworzywo                VARCHAR(16),
    masa                    FLOAT(2) NOT NULL,
    kolor                   VARCHAR(16),
    zawodnik_id_zawodnika   INTEGER NOT NULL,
    PRIMARY KEY (id_miotly)
);

CREATE TABLE pracownik (
    id_pracownika   INTEGER NOT NULL AUTO_INCREMENT,
    imie            VARCHAR(16) NOT NULL,
    nazwisko        VARCHAR(32) NOT NULL,
    funkcja         VARCHAR(32) NOT NULL,
    zarobki         INTEGER,
    PRIMARY KEY (id_pracownika)
);

CREATE TABLE relation_9 (
	id_rel					   INTEGER NOT NULL AUTO_INCREMENT,
    pracownicy_id_pracownika   INTEGER NOT NULL,
    druzyna_id_druzyny         INTEGER NOT NULL,
    PRIMARY KEY (id_rel)
);

CREATE TABLE rozgrywka (
    id_rozgrywki          INTEGER NOT NULL AUTO_INCREMENT,
    punkty_druzyna1       INTEGER,
    punkty_druzyna2       INTEGER,
    data                  DATE NOT NULL,
    druzyna_id_druzyny1   INTEGER NOT NULL,
    druzyna_id_druzyny2   INTEGER NOT NULL,
    znicz_id_znicza       INTEGER NOT NULL,
    sedzia_id_sedzi       INTEGER NOT NULL,
    PRIMARY KEY (id_rozgrywki)
);

CREATE TABLE sedzia (
    id_sedzi         INTEGER NOT NULL AUTO_INCREMENT,
    imie             VARCHAR(16) NOT NULL,
    nazwisko         VARCHAR(32) NOT NULL,
    data_urodzenia   DATE,
    PRIMARY KEY (id_sedzi)
);

CREATE TABLE stadion (
    id_stadionu   INTEGER NOT NULL AUTO_INCREMENT,
    nazwa         VARCHAR(32) NOT NULL,
    adres         VARCHAR(128) NOT NULL,
    pojemnosc     INTEGER NOT NULL,
    parking       VARCHAR(1),
    PRIMARY KEY (id_stadionu)
);

ALTER TABLE stadion ADD CONSTRAINT stadion_nazwa_un UNIQUE ( nazwa );

CREATE TABLE zawodnik (
    id_zawodnika         INTEGER NOT NULL AUTO_INCREMENT,
    imie                 VARCHAR(32) NOT NULL,
    nazwisko             VARCHAR(64) NOT NULL,
    pozycja              VARCHAR(16) NOT NULL,
    data_urodzenia       DATE NOT NULL,
    plec                 VARCHAR(1) NOT NULL,
    druzyna_id_druzyny   INTEGER NOT NULL,
    PRIMARY KEY (id_zawodnika)
);

CREATE TABLE znicz (
    id_znicza   INTEGER NOT NULL AUTO_INCREMENT,
    nazwa       VARCHAR(32) NOT NULL,
    masa        FLOAT(2) NOT NULL,
    predkosc    FLOAT(2) NOT NULL,
    producent   VARCHAR(64),
    PRIMARY KEY (id_znicza)
);

ALTER TABLE znicz ADD CONSTRAINT znicz_nazwa_un UNIQUE ( nazwa );

ALTER TABLE druzyna
    ADD CONSTRAINT druzyna_stadion_fk FOREIGN KEY ( stadion_id_stadionu )
        REFERENCES stadion ( id_stadionu );

ALTER TABLE kara
    ADD CONSTRAINT kara_zawodnik_fk FOREIGN KEY ( zawodnik_id_zawodnika )
        REFERENCES zawodnik ( id_zawodnika );

ALTER TABLE miotla
    ADD CONSTRAINT miotla_zawodnik_fk FOREIGN KEY ( zawodnik_id_zawodnika )
        REFERENCES zawodnik ( id_zawodnika );

ALTER TABLE relation_9
    ADD CONSTRAINT relation_9_druzyna_fk FOREIGN KEY ( druzyna_id_druzyny )
        REFERENCES druzyna ( id_druzyny );

ALTER TABLE relation_9
    ADD CONSTRAINT relation_9_pracownicy_fk FOREIGN KEY ( pracownicy_id_pracownika )
        REFERENCES pracownik ( id_pracownika );
		
ALTER TABLE rozgrywka
    ADD CONSTRAINT rozgrywka_druzyna_fk1 FOREIGN KEY ( druzyna_id_druzyny1 )
        REFERENCES druzyna ( id_druzyny );
        
ALTER TABLE rozgrywka
    ADD CONSTRAINT rozgrywka_druzyna_fk2 FOREIGN KEY ( druzyna_id_druzyny2 )
        REFERENCES druzyna ( id_druzyny );

ALTER TABLE rozgrywka
    ADD CONSTRAINT rozgrywka_sedzia_fk FOREIGN KEY ( sedzia_id_sedzi )
        REFERENCES sedzia ( id_sedzi );

ALTER TABLE rozgrywka
    ADD CONSTRAINT rozgrywka_znicz_fk FOREIGN KEY ( znicz_id_znicza )
        REFERENCES znicz ( id_znicza );

ALTER TABLE zawodnik
    ADD CONSTRAINT zawodnik_druzyna_fk FOREIGN KEY ( druzyna_id_druzyny )
        REFERENCES druzyna ( id_druzyny );