PGDMP     ,    !                |            bdclase    14.7    14.7 5    E           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            F           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            G           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            H           1262    24576    bdclase    DATABASE     c   CREATE DATABASE bdclase WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Spain.1252';
    DROP DATABASE bdclase;
             	   userclase    false            �            1259    49310    tb_categoria    TABLE     �   CREATE TABLE public.tb_categoria (
    id_categoria uuid NOT NULL,
    descripcion character varying(255) NOT NULL,
    nombre_categoria character varying(255) NOT NULL
);
     DROP TABLE public.tb_categoria;
       public         heap 	   userclase    false            �            1259    57529 
   tb_cliente    TABLE     ~  CREATE TABLE public.tb_cliente (
    id_cliente uuid NOT NULL,
    celular_cliente character varying(255) NOT NULL,
    correo_cliente character varying(255) NOT NULL,
    direccion_cliente character varying(255) NOT NULL,
    nombre_cliente character varying(255) NOT NULL,
    num_doc_cliente character varying(255) NOT NULL,
    tipo_documento character varying(255) NOT NULL
);
    DROP TABLE public.tb_cliente;
       public         heap 	   userclase    false            �            1259    57512    tb_empleado    TABLE     a  CREATE TABLE public.tb_empleado (
    id_empleado uuid NOT NULL,
    cargo character varying(255) NOT NULL,
    correo character varying(255) NOT NULL,
    fechanacimiento character varying(255) NOT NULL,
    nombre_empleado character varying(255) NOT NULL,
    telefono character varying(255) NOT NULL,
    documento_empleado character varying(255)
);
    DROP TABLE public.tb_empleado;
       public         heap 	   userclase    false            �            1259    65911    tb_facturacion    TABLE     �   CREATE TABLE public.tb_facturacion (
    id_facturacion uuid NOT NULL,
    fecha_facturacion character varying(255),
    serie_comprobante character varying(255),
    tipo_comprobante character varying(255),
    id_pedido uuid
);
 "   DROP TABLE public.tb_facturacion;
       public         heap 	   userclase    false            �            1259    49341    tb_marca    TABLE     o   CREATE TABLE public.tb_marca (
    id_marca uuid NOT NULL,
    nombre_marca character varying(255) NOT NULL
);
    DROP TABLE public.tb_marca;
       public         heap 	   userclase    false            �            1259    41182    tb_menus    TABLE     �   CREATE TABLE public.tb_menus (
    id_menu uuid NOT NULL,
    icono character varying(255) NOT NULL,
    menu_padre uuid,
    nombre character varying(255) NOT NULL,
    orden integer NOT NULL,
    url character varying(255) NOT NULL
);
    DROP TABLE public.tb_menus;
       public         heap 	   userclase    false            �            1259    66687 	   tb_modelo    TABLE     �   CREATE TABLE public.tb_modelo (
    id_modelo uuid NOT NULL,
    cantidad_modelo integer,
    nombre_modelo character varying(255)
);
    DROP TABLE public.tb_modelo;
       public         heap 	   userclase    false            �            1259    65849 	   tb_pedido    TABLE     N  CREATE TABLE public.tb_pedido (
    id_pedido uuid NOT NULL,
    cantidad integer,
    descuento double precision,
    estado character varying(255),
    fecha_pedido character varying(255),
    numero_pedido integer,
    subtotal double precision,
    total_pagar character varying(255),
    id_cliente uuid,
    id_producto uuid
);
    DROP TABLE public.tb_pedido;
       public         heap 	   userclase    false            �            1259    49351    tb_presentacion    TABLE     �   CREATE TABLE public.tb_presentacion (
    id_presentacion uuid NOT NULL,
    nombre_presentacion character varying(255) NOT NULL
);
 #   DROP TABLE public.tb_presentacion;
       public         heap 	   userclase    false            �            1259    57550    tb_producto    TABLE       CREATE TABLE public.tb_producto (
    id_producto uuid NOT NULL,
    fecha_vencimiento character varying(255) NOT NULL,
    nombre_producto character varying(255) NOT NULL,
    precio_compra double precision NOT NULL,
    precio_venta double precision NOT NULL,
    stock integer NOT NULL,
    nombre_categoria uuid,
    nombre_marca uuid,
    nombre_presentacion uuid,
    nombre_proveedor uuid,
    codigo_producto integer NOT NULL,
    id_categoria uuid,
    id_marca uuid,
    id_presentacion uuid,
    id_proveedor uuid
);
    DROP TABLE public.tb_producto;
       public         heap 	   userclase    false            �            1259    49363    tb_proveedor    TABLE     �   CREATE TABLE public.tb_proveedor (
    id_proveedor uuid NOT NULL,
    ruc character varying(255) NOT NULL,
    nombre_proveedor character varying(255) NOT NULL,
    telefono character varying(255) NOT NULL
);
     DROP TABLE public.tb_proveedor;
       public         heap 	   userclase    false            �            1259    41201    tb_usuarios    TABLE     �   CREATE TABLE public.tb_usuarios (
    id_usuario uuid NOT NULL,
    clave character varying(255) NOT NULL,
    usuario character varying(255) NOT NULL,
    nombre character varying(255) NOT NULL,
    id_empleado uuid,
    cr uuid
);
    DROP TABLE public.tb_usuarios;
       public         heap 	   userclase    false            9          0    49310    tb_categoria 
   TABLE DATA           S   COPY public.tb_categoria (id_categoria, descripcion, nombre_categoria) FROM stdin;
    public       	   userclase    false    211   wH       >          0    57529 
   tb_cliente 
   TABLE DATA           �   COPY public.tb_cliente (id_cliente, celular_cliente, correo_cliente, direccion_cliente, nombre_cliente, num_doc_cliente, tipo_documento) FROM stdin;
    public       	   userclase    false    216   XW       =          0    57512    tb_empleado 
   TABLE DATA           �   COPY public.tb_empleado (id_empleado, cargo, correo, fechanacimiento, nombre_empleado, telefono, documento_empleado) FROM stdin;
    public       	   userclase    false    215   .X       A          0    65911    tb_facturacion 
   TABLE DATA           {   COPY public.tb_facturacion (id_facturacion, fecha_facturacion, serie_comprobante, tipo_comprobante, id_pedido) FROM stdin;
    public       	   userclase    false    219   �Y       :          0    49341    tb_marca 
   TABLE DATA           :   COPY public.tb_marca (id_marca, nombre_marca) FROM stdin;
    public       	   userclase    false    212   Z       7          0    41182    tb_menus 
   TABLE DATA           R   COPY public.tb_menus (id_menu, icono, menu_padre, nombre, orden, url) FROM stdin;
    public       	   userclase    false    209   E]       B          0    66687 	   tb_modelo 
   TABLE DATA           N   COPY public.tb_modelo (id_modelo, cantidad_modelo, nombre_modelo) FROM stdin;
    public       	   userclase    false    220   x_       @          0    65849 	   tb_pedido 
   TABLE DATA           �   COPY public.tb_pedido (id_pedido, cantidad, descuento, estado, fecha_pedido, numero_pedido, subtotal, total_pagar, id_cliente, id_producto) FROM stdin;
    public       	   userclase    false    218   `       ;          0    49351    tb_presentacion 
   TABLE DATA           O   COPY public.tb_presentacion (id_presentacion, nombre_presentacion) FROM stdin;
    public       	   userclase    false    213   9a       ?          0    57550    tb_producto 
   TABLE DATA           	  COPY public.tb_producto (id_producto, fecha_vencimiento, nombre_producto, precio_compra, precio_venta, stock, nombre_categoria, nombre_marca, nombre_presentacion, nombre_proveedor, codigo_producto, id_categoria, id_marca, id_presentacion, id_proveedor) FROM stdin;
    public       	   userclase    false    217   Tb       <          0    49363    tb_proveedor 
   TABLE DATA           U   COPY public.tb_proveedor (id_proveedor, ruc, nombre_proveedor, telefono) FROM stdin;
    public       	   userclase    false    214   �d       8          0    41201    tb_usuarios 
   TABLE DATA           Z   COPY public.tb_usuarios (id_usuario, clave, usuario, nombre, id_empleado, cr) FROM stdin;
    public       	   userclase    false    210   pe       �           2606    49316    tb_categoria tb_categoria_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.tb_categoria
    ADD CONSTRAINT tb_categoria_pkey PRIMARY KEY (id_categoria);
 H   ALTER TABLE ONLY public.tb_categoria DROP CONSTRAINT tb_categoria_pkey;
       public         	   userclase    false    211            �           2606    57535    tb_cliente tb_cliente_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.tb_cliente
    ADD CONSTRAINT tb_cliente_pkey PRIMARY KEY (id_cliente);
 D   ALTER TABLE ONLY public.tb_cliente DROP CONSTRAINT tb_cliente_pkey;
       public         	   userclase    false    216            �           2606    57518    tb_empleado tb_empleado_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY public.tb_empleado
    ADD CONSTRAINT tb_empleado_pkey PRIMARY KEY (id_empleado);
 F   ALTER TABLE ONLY public.tb_empleado DROP CONSTRAINT tb_empleado_pkey;
       public         	   userclase    false    215            �           2606    65917 "   tb_facturacion tb_facturacion_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY public.tb_facturacion
    ADD CONSTRAINT tb_facturacion_pkey PRIMARY KEY (id_facturacion);
 L   ALTER TABLE ONLY public.tb_facturacion DROP CONSTRAINT tb_facturacion_pkey;
       public         	   userclase    false    219            �           2606    49345    tb_marca tb_marca_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.tb_marca
    ADD CONSTRAINT tb_marca_pkey PRIMARY KEY (id_marca);
 @   ALTER TABLE ONLY public.tb_marca DROP CONSTRAINT tb_marca_pkey;
       public         	   userclase    false    212            �           2606    41188    tb_menus tb_menus_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.tb_menus
    ADD CONSTRAINT tb_menus_pkey PRIMARY KEY (id_menu);
 @   ALTER TABLE ONLY public.tb_menus DROP CONSTRAINT tb_menus_pkey;
       public         	   userclase    false    209            �           2606    66691    tb_modelo tb_modelo_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.tb_modelo
    ADD CONSTRAINT tb_modelo_pkey PRIMARY KEY (id_modelo);
 B   ALTER TABLE ONLY public.tb_modelo DROP CONSTRAINT tb_modelo_pkey;
       public         	   userclase    false    220            �           2606    65855    tb_pedido tb_pedido_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.tb_pedido
    ADD CONSTRAINT tb_pedido_pkey PRIMARY KEY (id_pedido);
 B   ALTER TABLE ONLY public.tb_pedido DROP CONSTRAINT tb_pedido_pkey;
       public         	   userclase    false    218            �           2606    49355 $   tb_presentacion tb_presentacion_pkey 
   CONSTRAINT     o   ALTER TABLE ONLY public.tb_presentacion
    ADD CONSTRAINT tb_presentacion_pkey PRIMARY KEY (id_presentacion);
 N   ALTER TABLE ONLY public.tb_presentacion DROP CONSTRAINT tb_presentacion_pkey;
       public         	   userclase    false    213            �           2606    57556    tb_producto tb_producto_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY public.tb_producto
    ADD CONSTRAINT tb_producto_pkey PRIMARY KEY (id_producto);
 F   ALTER TABLE ONLY public.tb_producto DROP CONSTRAINT tb_producto_pkey;
       public         	   userclase    false    217            �           2606    49369    tb_proveedor tb_proveedor_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.tb_proveedor
    ADD CONSTRAINT tb_proveedor_pkey PRIMARY KEY (id_proveedor);
 H   ALTER TABLE ONLY public.tb_proveedor DROP CONSTRAINT tb_proveedor_pkey;
       public         	   userclase    false    214            �           2606    41207    tb_usuarios tb_usuarios_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.tb_usuarios
    ADD CONSTRAINT tb_usuarios_pkey PRIMARY KEY (id_usuario);
 F   ALTER TABLE ONLY public.tb_usuarios DROP CONSTRAINT tb_usuarios_pkey;
       public         	   userclase    false    210            �           2606    65723 '   tb_producto fk505d3ixi019eukymfjh8npa0d    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_producto
    ADD CONSTRAINT fk505d3ixi019eukymfjh8npa0d FOREIGN KEY (id_marca) REFERENCES public.tb_marca(id_marca);
 Q   ALTER TABLE ONLY public.tb_producto DROP CONSTRAINT fk505d3ixi019eukymfjh8npa0d;
       public       	   userclase    false    212    217    3214            �           2606    57572 '   tb_producto fk53uqo7ox21wtoutyj2eccsw0v    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_producto
    ADD CONSTRAINT fk53uqo7ox21wtoutyj2eccsw0v FOREIGN KEY (nombre_marca) REFERENCES public.tb_marca(id_marca);
 Q   ALTER TABLE ONLY public.tb_producto DROP CONSTRAINT fk53uqo7ox21wtoutyj2eccsw0v;
       public       	   userclase    false    217    212    3214            �           2606    57567 '   tb_producto fk6cs5te3kantfr3ntupy347gt7    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_producto
    ADD CONSTRAINT fk6cs5te3kantfr3ntupy347gt7 FOREIGN KEY (nombre_categoria) REFERENCES public.tb_categoria(id_categoria);
 Q   ALTER TABLE ONLY public.tb_producto DROP CONSTRAINT fk6cs5te3kantfr3ntupy347gt7;
       public       	   userclase    false    211    217    3212            �           2606    66692 '   tb_usuarios fk744j8or41b2eqj99n08c643e6    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_usuarios
    ADD CONSTRAINT fk744j8or41b2eqj99n08c643e6 FOREIGN KEY (cr) REFERENCES public.tb_empleado(id_empleado);
 Q   ALTER TABLE ONLY public.tb_usuarios DROP CONSTRAINT fk744j8or41b2eqj99n08c643e6;
       public       	   userclase    false    215    3220    210            �           2606    65718 '   tb_producto fk7tyog6khc1m2yuqvcswna17fd    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_producto
    ADD CONSTRAINT fk7tyog6khc1m2yuqvcswna17fd FOREIGN KEY (id_categoria) REFERENCES public.tb_categoria(id_categoria);
 Q   ALTER TABLE ONLY public.tb_producto DROP CONSTRAINT fk7tyog6khc1m2yuqvcswna17fd;
       public       	   userclase    false    211    217    3212            �           2606    57577 '   tb_producto fka43a0fkrocms69huustvwglmo    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_producto
    ADD CONSTRAINT fka43a0fkrocms69huustvwglmo FOREIGN KEY (nombre_presentacion) REFERENCES public.tb_presentacion(id_presentacion);
 Q   ALTER TABLE ONLY public.tb_producto DROP CONSTRAINT fka43a0fkrocms69huustvwglmo;
       public       	   userclase    false    3216    213    217            �           2606    65918 *   tb_facturacion fkcgwv2u05yw9ww9ljr4godke60    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_facturacion
    ADD CONSTRAINT fkcgwv2u05yw9ww9ljr4godke60 FOREIGN KEY (id_pedido) REFERENCES public.tb_pedido(id_pedido);
 T   ALTER TABLE ONLY public.tb_facturacion DROP CONSTRAINT fkcgwv2u05yw9ww9ljr4godke60;
       public       	   userclase    false    3226    218    219            �           2606    65728 '   tb_producto fkd2sf5dwfk2ccf2duh6mousdju    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_producto
    ADD CONSTRAINT fkd2sf5dwfk2ccf2duh6mousdju FOREIGN KEY (id_presentacion) REFERENCES public.tb_presentacion(id_presentacion);
 Q   ALTER TABLE ONLY public.tb_producto DROP CONSTRAINT fkd2sf5dwfk2ccf2duh6mousdju;
       public       	   userclase    false    213    217    3216            �           2606    65883 %   tb_pedido fkgrjo1gon9cw4n5j75t1jpy37i    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_pedido
    ADD CONSTRAINT fkgrjo1gon9cw4n5j75t1jpy37i FOREIGN KEY (id_producto) REFERENCES public.tb_producto(id_producto);
 O   ALTER TABLE ONLY public.tb_pedido DROP CONSTRAINT fkgrjo1gon9cw4n5j75t1jpy37i;
       public       	   userclase    false    3224    218    217            �           2606    65733 '   tb_producto fkit18fu4bl4kq8y2dwqy9hn2to    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_producto
    ADD CONSTRAINT fkit18fu4bl4kq8y2dwqy9hn2to FOREIGN KEY (id_proveedor) REFERENCES public.tb_proveedor(id_proveedor);
 Q   ALTER TABLE ONLY public.tb_producto DROP CONSTRAINT fkit18fu4bl4kq8y2dwqy9hn2to;
       public       	   userclase    false    217    3218    214            �           2606    57582 '   tb_producto fkiw8guj59l7udd2durpwyojkdp    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_producto
    ADD CONSTRAINT fkiw8guj59l7udd2durpwyojkdp FOREIGN KEY (nombre_proveedor) REFERENCES public.tb_proveedor(id_proveedor);
 Q   ALTER TABLE ONLY public.tb_producto DROP CONSTRAINT fkiw8guj59l7udd2durpwyojkdp;
       public       	   userclase    false    3218    217    214            �           2606    65878 %   tb_pedido fkmjqm65wiaj65gia070a45vt9w    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_pedido
    ADD CONSTRAINT fkmjqm65wiaj65gia070a45vt9w FOREIGN KEY (id_cliente) REFERENCES public.tb_cliente(id_cliente);
 O   ALTER TABLE ONLY public.tb_pedido DROP CONSTRAINT fkmjqm65wiaj65gia070a45vt9w;
       public       	   userclase    false    216    218    3222            �           2606    57524 &   tb_usuarios fkx6bfu4lx5pkt0nw27hs6n7ih    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_usuarios
    ADD CONSTRAINT fkx6bfu4lx5pkt0nw27hs6n7ih FOREIGN KEY (id_empleado) REFERENCES public.tb_empleado(id_empleado);
 P   ALTER TABLE ONLY public.tb_usuarios DROP CONSTRAINT fkx6bfu4lx5pkt0nw27hs6n7ih;
       public       	   userclase    false    215    210    3220            9   �  x��Y�vG�]��?��|?�zX��duK���&�) E ����@K/����[���(� E�^�,0�2^7��n�t͈�d�i)R�.�V�x]�1��I=�����6�W?�{ڌ[ڭ�i���ݠ�IQ�&R�^�@^$[�06)2�(���Ӷ^�����z��ШNsۭ�Nk��Ai_�-YD�`Az�Ѓ����b����³i�9��^m\j9�$���J��Hd�/9*�����v=�����ہl6��(�&��D�J��{��4o��t���m��y�C۶�֫�V/Ɩ�6�[�Z��#	ܙ)��S,F��˝��]�G8�z6m�m�Hw�H$	wm/�@�N:��k�������5��zն��|�[Y��5�zL��T��E*��vi�#�ԶZ��bX3QN�K���k'�A`u��P|��OxD�%l�Y��ZUE�^
��4�J���x>��s ���Ae��")�7MX�H]E�eL�ۻ���p+���aW�$�Ɍr���
^��(Y[a��"'rBUm����&�L�ls��!ǘ��]PqJ���1!(��J�7�������*B�B(�i�F��z���M��U��Woi}��z�7N���mږ�G5@TV���<jO��h�rM� �����q�oZ=�#�i0��Ԓ25��B��G�9��J�ts�6l�|�O�������o�,���zx}2
m�%����Xx>��/ޭ�~��_����)��Tp�p8���[Ӷ՞�#?�=�7�����(4�٠���T�!"՛%r�G]�3|�%�UI(��<6H �CR*���K	���g4�q�@���z�k$uD �(b�U���d	�}c��<e$I��_�.�Q����-ld��2��"�J=���(�|t�(�S��^j �48j�$�|-ξ�����Ӷ!��X+C($�B��zd"#t�vs��4o&��-�$Z���t#R��$z���ևs������8�b܍7)��X�G�7�.l;P6|:+��7��EwB�W�_Z��/M"�]�
-z�	_C%L*s��z(���>��=U�=�XE��p�0��*�� h���a�v�vM6�$�.�Y����9��� X����_�6�ØSH��K6���!�#���\�%�t����w�O"^\i9K�dE(�H<+2����,p����5-�nl+!X��`>(cv7'[5$�o���a?�������cF��1�BZ��w]w
i���SO��5v�>~�-#��~�n�i���O�{��Vt�3��p+c��4&w�&Э3?n{+7�����̃�Y�lu(>��-�#E��S%X��{��T��s��!�L>�sśS�"i�n2����8�]#qē��m)q�%&�f�T��n��G\�i��?��w�փT�1� ��Lkʵ'�;�UE���fn��l��jb0�nA�ی<Ɔ��	�, /�/m���7'�<�d2y�u����jV�LY=�ʻ��kL�����M��fP��u�B�"� ܛ�-Z=�������w����OdDvJ>EL"R`�	*  �m/��<��x��~ش���%C�< �H[B�Yy(tTI��f��υ[�*�)��;q�e��I	t�l�F`i��aľ��7� m� ��'_�0VlNI�u*@dW[���M���,r���?�P(��1uRG�$:,�aLb�P�{q�<oЋ�J��C�:��r�l�id+���VR(�oT�ͅ*7��&��P���D�.-��`zM�ѿ�q��(N234W�\C�'��E����&�;��y`��z�k���.�U�bUF�e|U.Q�3�U�"ڧy����y����WA/)d��'&M�F�Q� _�
X&��F�N����.�o2~���l��+�M�y`�Y�-�|�*}�w��^x�s���sZ�A��K#��l��l�:���WPc��z�L	#Fn�bbf�QO�Gp���")�dl<��:/-1?�`�.LTQ����������V�$���)�H[d2x̿�ﾤ��|�wo*��P�7�{P$Liw��q�Qı�*Dj�ӂ d�*�>Z���
#x0jW��/�{��P��h�"��$@���+��d������� �[_���B'�3ʢ��9d ��^0�3 h��E�]�7�1Ga� �ڌBi0��p)z���խp���WgN�S9�=��1����q@3:���=�vuI_����p��*�v�^��H�;�G����Yi�Y(�q���~���}��A�bX;�E��#�~�tr@�P�����n�z�rp=� `T7,�:4t!��]W`�����` ^P@��SVS�Qd���oxA�`����޴:?r1��1�({��H�U���c�H�|�s���a�=?;E�e����֦����/�Y����%�R5�:�Q���;\��y�"���r��D&&�0��6�z��O3�
i�C��A}�"��6I�LP_��n����W@]'�Zee�1�@Z��iy��v7�=�v��n{� P�`�.�\@�� i� �u�ӡj��(1#.:i�6 {��=z���=��㯬�C��۱�RE����[�����0�����*���vW����I
t  ��H��������SC�bYc��T�^�Ke!].����f�5����y��I&tIC�1�W([�x����C��^�|8���e$h�������,�-�t-C�]0�3�N�̴,�F�tz�ݐ���<���-��l�0�՛��2�?��G�뺵�%!V(!LR��s%RS:�\���$�ʞz�$���b$
���_y�$>2�X��*��m����a�|E����V2� ��yں�>���[�{z�"��Ҽ�(Zq)@7��2j
�@F��"�<o���d
YL�
r�r��nP�4e�T��*�ݸ�ߊ�g��tR4s��.$sY'!�9]
���7����hY�`���2��L���J$�����;I1�
�;	 =/o�[
����d�ʹt>�b���� �C�epP](v�����k�.���]�ee�r�<��q�a	��9:�ǘH!���ˤ�����k`�<�ӟ��)e��d3�:0��ճNF�.}�����6�Wo��6�ӲKA����VI�Z߲f���kƱ4/�w�����x�+��!	E�H� o#��<�)Ǩ�J�Q+��x�P��	黛?v�4`�u��(�΅�k���0����z��]tZo����ע��x�m�%�� �>b��S�=�S��e냇��}�)�B��H{Tx�o^�ղ��ӠU2��(\��ǼD5�9|R`��@25u�~A�Y:�-ׂt�nW����=�{�߼���X06؜F�xi�4�;��O�f.��{��:y�6�8���dp&
F��T�!c7��*f9��eK'h�@U����%C����6e|i�k� ���0ˊW��^��A�a�_T��+�C�IyY4B$����m��>�ڴт|��O?��� ���A_����D��j��o�ղ]ꛑo�LL�2��}���'�nEE	2�LR���y���m����;�v.{3�p3BI�|/��_�y��mm�!�4��"'�D�(�;�P�I�����h��ِ͞�RTג
�sT/��G��f�Im�`-��+�V9����,��7�&�zPp�EԔ֜	��3�h�A�J�d�l���9��?�1��~'f�      >   �   x�MͻN1��z�~G���� 	Q����c6R�1[���� ����K�����T�,�Z�&�&-��m�@�BO0]����?W)2�}��pܔ�O^59r���x3��q�s�&��l�����f*!�)����M��k�da��ô|
��ǵ��>/]��]SJ��Cz����~g�x��ۨ�7J�UE      =   N  x�m�AN1E��S����۵� 6Hl`)�r��1�JÀ���9�X�(���J���^��S�cBD �
����5fsQ�miOϛ�u3y��,����N�;��K{<�׽A�#��̷S�^���˝,�T5������)Qt� �JN$�T5��:��>��ƒ�3�Z��y���&��ࣹlˮ��i�n��k���A�����u~쫎�y
��_��pf�@Id���L���� K��������� ��8e��S�޵��>~-��^_��p@&�1��SB��U�3P�H�	h֊4G"_�w��/t��!�wM���g�0���      A      x���;B!@��2f�Lk�*l`����<�/K��9�H#zQ�����m��)�XyxJwth������~zڱ|�PWt���� j#�Ͳ�<�t�7(�Y�'����Ì�!	 C��y���'����@/�      :     x�=�͒�6���S���?��V�Ԫ"���ٚL���R����n�`_�$_7�9e��L �_�G��iy���xma�9������ul�DQ>��tl�����M��(8�3T�b��z�}�ӱ�suN�R��\S��BD�����%�/����Z�fg�@,U��9��|��1��¸Zh�4�΢�,��:�_��>y2��W�Z�J64�s,#�^���|.��9";Π�V��c��D�p��rd�����ӌݒq�@�������x�&c�6����,�(#�t�^;��v1�7]IL���3�����~_.���˙fUU,]V��p�@�6�O�x�]��sY�s�ɰ�]ƈL�
���z��ef��i=�3��>&�����4J��q�AUY`��^o��B�~�δJnc+%�b�j]���KE@GF��lƱݯ#�3]^麯i6���e_����YK�H��ro�L���m����x�.���A됋ΐѓp����֮��2��l�z���k�9k�oR\�Z7@��UB�B����}��߶�~ݏtt�����Ҕ��-N�Ƌ� Y��UK�M�)�8��ƨL+\r���؁�dtU�c��u�a��?��@,����%��*�֕�w���R�}�y6����;P���B-�t1w����?��v�U��:�Q�9f�{/G�|% �$|m΢CۤQ˺_�e�j?^�!3�.s�%�.��4�v���hIu�{������-�۶]���l4p���ȷ�nz�?\��{��y���:      7   #  x��T;��0��S�/��S/���6���}�+Ķ�
��J�v/JZ'���0�!���*�B��I��Y )�*�Z�ؒLW̯��6\_��t����4�B��Sݗ��{ŉ|%S��u�R�#mx5\f��C���R�a�Yv8�1��u��8�=$�t��C�I�.�A�^�+R�+��q��Ӿ��O%8/I *mWu�d�C.J(�Ά����\�~v�$�ms�6������>>����ޖ(����DU(�2��B�"��S3��Y�C�g���6�L�Y	mn2�-��M�B`kkqz�� g��Oe���\V���x���42C�^�TT�3F$\=�M�Cܓ\��lr]�>���F�k˸�N��hP�L������;��V�L������LPLUI�M�Tjj�����I����_J����v��G#xrl"���FUr�C�ڨM����{��C���*&��p��h},�"�vB�#3��$5YQq�O`i.��O�./�4l-�Ǣ��S)&(L9�l���x�����9"�F��6�ˆ������D'k9      B   z   x��A! �3��(-�j�/�hO5��߽��l̾2���0��b U���!�p�lo�y,O�����*��@�>k'#k)d��>4Rg���R�2��՚�dT�������ߎ���Oxp&�      @   '  x����n�1�gޫ�����6{�v��t���Չ2f�8H�s6e3��!.("�æ�r�!VHY���c�}�����!��~�=�~Bժ DnVO�Z��B)=�vW�s+/Q@JHf���/�q4'l2��eP�k��I1��r����Dsو������{��T����P�.��w�T��2u��Yq�X��ֵ�2��[*�\�2�`7��n�r�r�ޕ��t��I�����ZGK3��ѷ�VO�S_�|�	��PщX�m*�mq���碄��v	�&����n�u��;��      ;     x�=�=N1���)�����L\��:;q�J�3����Pr��i�������\b�;D�	{���A�8i���,j��<U%�@b�3�*
�G��=��"��Ev��[ 2C�Z@K��
�d�9�^��돭��YK�,Ԑ�2GN0R�R�ئ���i�Xƺ�����#����OhM��tw<m�"7���A�;�! Ԡz���x"*Z�[���_�qmۧ�۾ݸVji����a�i�q&$������z9K�~���*���9�te�      ?   L  x�����&5���bd;Ώ{��^�6��HHZ���A�~l�J�d4��sΌ���#`qD����0ō�������j�E�n��}n�v�O�nB�-{\�g�!�]T���d�s=�7Z����|*���&�g3S���g�9'ȶ>�qn�*����`r&��`P޺�����]��zǨJ�Ԡ��p��Y?��}y���[�6�E�ߐ�l���B8�x��� :,��=Ob�{��12��V��A0N^���X-3��
X�Js�s(S�R�ޮMv�]��E�ǐ�k�2&
��K��m�R����{��%h�ߤ��ǟ��j�VP�����t4�*��� ~l�')��l�}���RU:���B�����lyIϦ�'�`��%���.F�eV��t�i%�^�-R��zg�}G~%-O�GWڬ�L���)Բ�Z�������y<be;yݹwX���^N���+{���P]����W(T�B`�u:�������:>���8ޝ �	�9(�?ɭ����4����9���f��d2�~�C4�N��)���F� �E��ʴL��W�s���?������'��$�      <   �   x�e�1NC1 �99E/`�8����T�k'qP�>��1Vo�YR�֬���]�Gq^D�H��"���e��i���KPdɔZ��x��
d*�M�
sYN>g l*�K�^���)gaE�v��i9hJMk�.<���S��7��n�m�l߇��~>���&M�)��b��%';�      8   �   x�-�1R1C��]�ĉ��K����cg؂-���7R�ѓ�;y��@�,p@E�"��}&,����q��K��L���2P)�,�
ԦΎa.�n/��ij �{���Wب��]"��ݞ����Ф%��f`�h����ﹺa�EjU��5_�\@�W�j����L��q�]O��+�lB*�~�i�`D'B�-�߅�öm?��O�     