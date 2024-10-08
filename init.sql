-- DROP TABLE IF EXISTS public."PRUEBACLASE";

BEGIN;

CREATE TABLE IF NOT EXISTS public."PRUEBACLASE"
(
    "Nombre" character varying(50) COLLATE pg_catalog."default" NOT NULL,
    "Horario" character varying(50) COLLATE pg_catalog."default",
    "Aula" character varying(50) COLLATE pg_catalog."default",
    CONSTRAINT "PRUEBACLASE_pkey" PRIMARY KEY ("Nombre")
    );

CREATE TABLE IF NOT EXISTS public."PRUEBAESTUDIANTE"
(
    "Eid" bigint NOT NULL,
    "Nombre" character varying(50) COLLATE pg_catalog."default",
    "Especialidad" character varying(50) COLLATE pg_catalog."default",
    "Grado" character varying(50) COLLATE pg_catalog."default",
    CONSTRAINT "PRUEBAESTUDIANTE_pkey" PRIMARY KEY ("Eid")
    );

CREATE TABLE IF NOT EXISTS public."PRUEBAINSCRIPCION"
(
    "Eid" bigint NOT NULL,
    "NombreClase" character varying(50) COLLATE pg_catalog."default" NOT NULL,
    "Posicion" integer
    );

ALTER TABLE IF EXISTS public."PRUEBAINSCRIPCION"
    ADD FOREIGN KEY ("Eid")
    REFERENCES public."PRUEBAESTUDIANTE" ("Eid") MATCH SIMPLE
    ON UPDATE NO ACTION
       ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."PRUEBAINSCRIPCION"
    ADD FOREIGN KEY ("NombreClase")
    REFERENCES public."PRUEBACLASE" ("Nombre") MATCH SIMPLE
    ON UPDATE NO ACTION
       ON DELETE NO ACTION
    NOT VALID;

INSERT INTO public."PRUEBAESTUDIANTE"(
    "Eid", "Nombre", "Especialidad", "Grado")
VALUES
    (100, 'JONES', 'HISTORIA', 'GR'),
    (150, 'PARKS', 'CONTABILIDAD', 'SO'),
    (200, 'BAKER', 'MATEMATICAS', 'GR'),
    (250, 'GLASS', 'HISTORIA', 'SN'),
    (300, 'BAKER', 'CONTABILIDAD', 'SN'),
    (350, 'RUSSELL', 'MATEMATICAS', 'JR'),
    (400, 'REY', 'CONTABILIDAD', 'FR'),
    (450, 'JONES', 'HISTORIA', 'SN');

INSERT INTO public."PRUEBACLASE"(
    "Nombre", "Horario", "Aula")
VALUES
    ('BA200', 'M-F9', 'SC110'),
    ('BD445', 'MWF3', 'SC213'),
    ('BF410', 'MWF8', 'SC213'),
    ('CS150', 'MWF3', 'EA204');

INSERT INTO public."PRUEBAINSCRIPCION"(
    "Eid", "NombreClase", "Posicion")
VALUES
    (100, 'BD445', 1),
    (150, 'BA200', 1),
    (200, 'BD445', 2),
    (200, 'CS150', 1),
    (300, 'CS150', 1),
    (400, 'BA200', 2),
    (400, 'BF410', 1),
    (400, 'CS150', 2),
    (450, 'BA200', 3);

END;