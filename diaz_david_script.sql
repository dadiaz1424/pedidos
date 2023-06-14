--
-- PostgreSQL database dump
--

-- Dumped from database version 13.11
-- Dumped by pg_dump version 13.11

-- Started on 2023-06-14 00:24:04

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE pedido;
--
-- TOC entry 3022 (class 1262 OID 17075)
-- Name: pedido; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE pedido WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Mexico.1252';


ALTER DATABASE pedido OWNER TO postgres;

\connect pedido

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 204 (class 1259 OID 17170)
-- Name: cliente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cliente (
    cliente_id integer NOT NULL,
    descuento integer NOT NULL,
    limite_credito integer NOT NULL,
    saldo numeric(5,2) NOT NULL
);


ALTER TABLE public.cliente OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 17175)
-- Name: cliente_direccion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cliente_direccion (
    cliente_id integer NOT NULL,
    direccion_id integer NOT NULL,
    numero integer NOT NULL,
    barrio character varying(60) NOT NULL,
    calle character varying(60) NOT NULL,
    ciudad character varying(60) NOT NULL
);


ALTER TABLE public.cliente_direccion OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 17162)
-- Name: cliente_direccion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cliente_direccion_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cliente_direccion_seq OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 17164)
-- Name: cliente_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cliente_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cliente_seq OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 17180)
-- Name: detalle_pedido; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.detalle_pedido (
    cantidad integer NOT NULL,
    cliente_id integer NOT NULL,
    pedido_id integer NOT NULL,
    fecha timestamp(6) without time zone NOT NULL
);


ALTER TABLE public.detalle_pedido OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 17166)
-- Name: detalle_pedido_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.detalle_pedido_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.detalle_pedido_seq OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 17185)
-- Name: pedido_articulo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pedido_articulo (
    articulo_id integer NOT NULL,
    pedido_id integer NOT NULL,
    descripcion character varying(200) NOT NULL
);


ALTER TABLE public.pedido_articulo OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 17168)
-- Name: pedido_articulo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pedido_articulo_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pedido_articulo_seq OWNER TO postgres;

--
-- TOC entry 3013 (class 0 OID 17170)
-- Dependencies: 204
-- Data for Name: cliente; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3014 (class 0 OID 17175)
-- Dependencies: 205
-- Data for Name: cliente_direccion; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3015 (class 0 OID 17180)
-- Dependencies: 206
-- Data for Name: detalle_pedido; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3016 (class 0 OID 17185)
-- Dependencies: 207
-- Data for Name: pedido_articulo; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3023 (class 0 OID 0)
-- Dependencies: 200
-- Name: cliente_direccion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cliente_direccion_seq', 1, false);


--
-- TOC entry 3024 (class 0 OID 0)
-- Dependencies: 201
-- Name: cliente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cliente_seq', 1, false);


--
-- TOC entry 3025 (class 0 OID 0)
-- Dependencies: 202
-- Name: detalle_pedido_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.detalle_pedido_seq', 1, false);


--
-- TOC entry 3026 (class 0 OID 0)
-- Dependencies: 203
-- Name: pedido_articulo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pedido_articulo_seq', 1, false);


--
-- TOC entry 2871 (class 2606 OID 17179)
-- Name: cliente_direccion cliente_direccion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente_direccion
    ADD CONSTRAINT cliente_direccion_pkey PRIMARY KEY (direccion_id);


--
-- TOC entry 2869 (class 2606 OID 17174)
-- Name: cliente cliente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (cliente_id);


--
-- TOC entry 2873 (class 2606 OID 17184)
-- Name: detalle_pedido detalle_pedido_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detalle_pedido
    ADD CONSTRAINT detalle_pedido_pkey PRIMARY KEY (pedido_id);


--
-- TOC entry 2875 (class 2606 OID 17189)
-- Name: pedido_articulo pedido_articulo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido_articulo
    ADD CONSTRAINT pedido_articulo_pkey PRIMARY KEY (articulo_id);


--
-- TOC entry 2877 (class 2606 OID 17195)
-- Name: detalle_pedido fk1gwvx5qxu9e51ix4kuditalfv; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detalle_pedido
    ADD CONSTRAINT fk1gwvx5qxu9e51ix4kuditalfv FOREIGN KEY (cliente_id) REFERENCES public.cliente(cliente_id);


--
-- TOC entry 2876 (class 2606 OID 17190)
-- Name: cliente_direccion fkj9uspp5ag60c1d3qxw95j1h2j; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente_direccion
    ADD CONSTRAINT fkj9uspp5ag60c1d3qxw95j1h2j FOREIGN KEY (cliente_id) REFERENCES public.cliente(cliente_id);


--
-- TOC entry 2878 (class 2606 OID 17200)
-- Name: pedido_articulo fkla9ktuxpa8qkahu99yj8bsi2b; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido_articulo
    ADD CONSTRAINT fkla9ktuxpa8qkahu99yj8bsi2b FOREIGN KEY (pedido_id) REFERENCES public.detalle_pedido(pedido_id);


-- Completed on 2023-06-14 00:24:04

--
-- PostgreSQL database dump complete
--

