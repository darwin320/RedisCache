	DROP USER REDIS_CACHE CASCADE;
	CREATE USER REDIS_CACHE IDENTIFIED BY A;
	GRANT CONNECT, RESOURCE TO REDIS_CACHE;
	GRANT UNLIMITED TABLESPACE TO REDIS_CACHE;
	CONN REDIS_CACHE/A


	/*==============================================================*/
	/* Table: 	PERSONAS                                          */
	/*==============================================================*/
	CREATE TABLE PERSONAS (
		ID_PERSONA NUMBER(10) 		not null,
		NOMBRE VARCHAR2(100)		not null,
		FECHA_NACIMIENTO DATE		,
		DIRECCION VARCHAR2(100)		,
		TELEFONO  VARCHAR2(20)		,
		constraint PK_PERSONAS primary key (ID_PERSONA)
	);
	
	/*==============================================================*/
	/* Table: 	AGENCIAS                                          */
	/*==============================================================*/
	CREATE TABLE AGENCIAS (
		ID_AGENCIA NUMBER(10) 		not null,
		NOMBRE VARCHAR2(100)		not null,
		ANIO_CREACION NUMBER(10) 	not null,
		constraint PK_AGENCIAS primary key (ID_AGENCIA)
	);
	
	/*==============================================================*/
	/* Table: 	NOTICIAS                                          */
	/*==============================================================*/
	CREATE TABLE NOTICIAS (
		ID_NOTICIA NUMBER(10) 		not null,
		FECHA DATE					not null,
		TITULAR VARCHAR2(100)		not null,
		TEXTO VARCHAR2(100)			not null,
		constraint PK_NOTICIAS primary key (ID_NOTICIA)
	);
	
	/*==============================================================*/
	/* Table: 	NOTICIAS_RELACIONADAS                                          */
	/*==============================================================*/
	CREATE TABLE NOTICIAS_RELACIONADAS (
		ID_NOTICIA 				NUMBER(10) 		not null,
		ID_NOTICIA_RELACIONADA 	NUMBER(10) 		not null,
		constraint ID_NOTICIAS_RELACIONADAS PRIMARY KEY  (ID_NOTICIA,ID_NOTICIA_RELACIONADA)
	);
	
	/*==============================================================*/
	/* Table: 	AGENCIA_NOTICIAS                                          */
	/*==============================================================*/
	CREATE TABLE AGENCIA_NOTICIAS (
		ID_AGENCIA NUMBER(10) 		not null,
		ID_NOTICIA NUMBER(10) 		not null,
		FECHA_CUBRIMIENTO DATE	 	not null,
		constraint ID_AGENCIA_NOTICIAS PRIMARY KEY  (ID_AGENCIA,ID_NOTICIA)
	);
	
	
		
	/*==============================================================*/
	/* Table: 	ENTREVISTAS                                        */
	/*==============================================================*/
	CREATE TABLE ENTREVISTAS (
		ID_ENTREVISTA NUMBER(10) 		not null,
		ID_PERIODISTA NUMBER(10) 	 	not null,
		ID_IMPLICADO  NUMBER(10) 		not null,
		ID_NOTICIA 	  NUMBER(10) 		not null,
		PREGUNTA VARCHAR2(200)		not null,
		constraint PK_ENTREVISTAS primary key (ID_ENTREVISTA)
	);
	
	
	/*==============================================================*/
	/* Table: 	IMPLICADO_NOTICIAS                                        */
	/*==============================================================*/
	CREATE TABLE IMPLICADO_NOTICIAS (
		ID_IMPLICADO  NUMBER(10) 		not null,
		ID_NOTICIA 	  NUMBER(10) 		not null,
		CALIDAD 	VARCHAR2(100)		not null,
		constraint ID_IMPLICADO_NOTICIAS PRIMARY KEY  (ID_IMPLICADO,ID_NOTICIA)
	);
	
	
	ALTER TABLE NOTICIAS_RELACIONADAS 
		ADD constraint FK_NOTICIAS_NOTICIAS FOREIGN KEY (ID_NOTICIA) REFERENCES NOTICIAS (ID_NOTICIA);
		
	ALTER TABLE NOTICIAS_RELACIONADAS 
		ADD constraint FK_NOTICIAS_NOTICIAS_RELACIONADAS FOREIGN KEY (ID_NOTICIA_RELACIONADA) REFERENCES NOTICIAS (ID_NOTICIA);
	
	ALTER TABLE AGENCIA_NOTICIAS 
		ADD constraint FK_AGENCIA_NOTICIAS_AGENCIA FOREIGN KEY (ID_AGENCIA) REFERENCES AGENCIAS (ID_AGENCIA);
		
	ALTER TABLE AGENCIA_NOTICIAS 
		ADD constraint FK_AGENCIA_NOTICIAS_NOTICIA FOREIGN KEY (ID_NOTICIA) REFERENCES NOTICIAS (ID_NOTICIA);
	
	ALTER TABLE ENTREVISTAS 
		ADD constraint FK_ENTREVISTAS_PERIODISTA FOREIGN KEY (ID_PERIODISTA) REFERENCES PERSONAS (ID_PERSONA);
		
	ALTER TABLE ENTREVISTAS 
		ADD constraint FK_ENTREVISTAS_IMPLICADO FOREIGN KEY (ID_IMPLICADO) REFERENCES PERSONAS (ID_PERSONA);
	
	ALTER TABLE ENTREVISTAS 
		ADD constraint FK_ENTREVISTAS_NOTICIAS FOREIGN KEY (ID_NOTICIA) REFERENCES NOTICIAS (ID_NOTICIA);
	
	ALTER TABLE IMPLICADO_NOTICIAS 
		ADD constraint FK_IMPLICADO_NOTICIAS_NOTICIAS FOREIGN KEY (ID_NOTICIA) REFERENCES NOTICIAS (ID_NOTICIA);

	ALTER TABLE IMPLICADO_NOTICIAS 
		ADD constraint FK_IMPLICADO_NOTICIAS_IMPLICADO FOREIGN KEY (ID_IMPLICADO) REFERENCES PERSONAS (ID_PERSONA);
		
	
	create sequence PERSON_SEQ start with 1 increment by 1 maxvalue 1000000 minvalue 1 nocycle;
	create sequence AGENCIAS_SEQ start with 1 increment by 1 maxvalue 1000000 minvalue 1 nocycle;
	create sequence NOTICIAS_SEQ start with 1 increment by 1 maxvalue 1000000 minvalue 1 nocycle;
	-- create sequence NOTICIAS_RELACIONADAS_SEQ start with 1 increment by 1 maxvalue 1000000 minvalue 1 nocycle;
	create sequence AGENCIA_NOTICIAS_SEQ start with 1 increment by 1 maxvalue 1000000 minvalue 1 nocycle;
	create sequence ENTREVISTAS_SEQ start with 1 increment by 1 maxvalue 1000000 minvalue 1 nocycle;
	-- create sequence IMPLICADO_NOTICIAS_SEQ start with 1 increment by 1 maxvalue 1000000 minvalue 1 nocycle;

	
	
	







