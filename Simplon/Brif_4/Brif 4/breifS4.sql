PGDMP         '                z           BrifProduct    14.3    14.3                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16403    BrifProduct    DATABASE     o   CREATE DATABASE "BrifProduct" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Arabic_Saudi Arabia.1256';
    DROP DATABASE "BrifProduct";
                postgres    false            ?            1259    16409    admine    TABLE       CREATE TABLE public.admine (
    id_admin integer NOT NULL,
    nom_admin character varying(25),
    prenom_admin character varying(25),
    ville_admin character varying(25),
    email_admin character varying(25),
    password_admin character varying(25)
);
    DROP TABLE public.admine;
       public         heap    postgres    false            ?            1259    16404    client    TABLE     	  CREATE TABLE public.client (
    id_client integer NOT NULL,
    nom_client character varying(25),
    prenom_client character varying(25),
    ville_client character varying(25),
    email_client character varying(25),
    password_client character varying(25)
);
    DROP TABLE public.client;
       public         heap    postgres    false            ?            1259    16414    produit    TABLE     ?   CREATE TABLE public.produit (
    id_produit integer NOT NULL,
    nom_produit character varying(25),
    prix_produit double precision,
    qte_stock integer,
    id_admin integer
);
    DROP TABLE public.produit;
       public         heap    postgres    false            ?            1259    16424    vote    TABLE     ?   CREATE TABLE public.vote (
    id_client integer NOT NULL,
    id_produit integer NOT NULL,
    date_v date,
    rate integer
);
    DROP TABLE public.vote;
       public         heap    postgres    false            ?          0    16409    admine 
   TABLE DATA           m   COPY public.admine (id_admin, nom_admin, prenom_admin, ville_admin, email_admin, password_admin) FROM stdin;
    public          postgres    false    210   ?       ?          0    16404    client 
   TABLE DATA           s   COPY public.client (id_client, nom_client, prenom_client, ville_client, email_client, password_client) FROM stdin;
    public          postgres    false    209   ]       ?          0    16414    produit 
   TABLE DATA           ]   COPY public.produit (id_produit, nom_produit, prix_produit, qte_stock, id_admin) FROM stdin;
    public          postgres    false    211   ?                  0    16424    vote 
   TABLE DATA           C   COPY public.vote (id_client, id_produit, date_v, rate) FROM stdin;
    public          postgres    false    212   *       j           2606    16413    admine admine_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.admine
    ADD CONSTRAINT admine_pkey PRIMARY KEY (id_admin);
 <   ALTER TABLE ONLY public.admine DROP CONSTRAINT admine_pkey;
       public            postgres    false    210            h           2606    16408    client client_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.client
    ADD CONSTRAINT client_pkey PRIMARY KEY (id_client);
 <   ALTER TABLE ONLY public.client DROP CONSTRAINT client_pkey;
       public            postgres    false    209            l           2606    16418    produit produit_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.produit
    ADD CONSTRAINT produit_pkey PRIMARY KEY (id_produit);
 >   ALTER TABLE ONLY public.produit DROP CONSTRAINT produit_pkey;
       public            postgres    false    211            n           2606    16428    vote vote_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public.vote
    ADD CONSTRAINT vote_pkey PRIMARY KEY (id_client, id_produit);
 8   ALTER TABLE ONLY public.vote DROP CONSTRAINT vote_pkey;
       public            postgres    false    212    212            o           2606    16419    produit produit_id_admin_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.produit
    ADD CONSTRAINT produit_id_admin_fkey FOREIGN KEY (id_admin) REFERENCES public.admine(id_admin);
 G   ALTER TABLE ONLY public.produit DROP CONSTRAINT produit_id_admin_fkey;
       public          postgres    false    210    211    3178            p           2606    16429    vote vote_id_client_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.vote
    ADD CONSTRAINT vote_id_client_fkey FOREIGN KEY (id_client) REFERENCES public.client(id_client);
 B   ALTER TABLE ONLY public.vote DROP CONSTRAINT vote_id_client_fkey;
       public          postgres    false    212    3176    209            q           2606    16434    vote vote_id_produit_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.vote
    ADD CONSTRAINT vote_id_produit_fkey FOREIGN KEY (id_produit) REFERENCES public.produit(id_produit);
 C   ALTER TABLE ONLY public.vote DROP CONSTRAINT vote_id_produit_fkey;
       public          postgres    false    212    211    3180            ?   z   x?3?t?ϫJ?I??O?)I-????K?σ??`?鹉?9z??????f?&?F?\F?N?y??@??TT???Y????$V*???@?`j?a??Q?错??????]???y?bU???? \?9      ?   l   x?3???,???H,?L-??ML)?L????R鹉?9z?????F?&?f??\F???99?>?y)??~??
??E??H?&cΠļ?DN?ĜJ?]?X
??=... ??3)      ?   A   x?3??L?/?N??420 bNC.#NǢ???	P??(b??????????R?ih
Vk????? ??e          1   x?3?4?4202?50?52?4?2?4Bp?pqCLt?L?=... ???     