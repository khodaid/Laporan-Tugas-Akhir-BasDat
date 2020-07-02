create tablespace il_sogno
datafile 'D:\irul\BERKAS\kuliah\praktikum\basis data\modul 1\IL_SOGNO.dbf'
size 30M;

create user khoirul_huda_06990
identified by khoirulhuda 
default tablespace IL_SOGNO
quota 30M on IL_SOGNO; 

grant dba to khoirul_huda_06990; 

create table Marketing
(
Id_Marketing int,
Nama_Marketing varchar(30),
No_Telp number(9),
constraint pk_marketing primary key (Id_Marketing)
);

create table Profil_Aluminium
(
Id_Profil int,
Nama_Profil varchar(30),
Warna varchar (50),
constraint pk_profil primary key (Id_Profil)
); 

create table Arsitek
(
Id_Arsitek integer not null,
Nama_Arsitek varchar(30),
Telp_Kantor number(9),
constraint pk_Arsitek primary key(Id_Arsitek)
); 

create table Proyek
(
Nama_Owner varchar(30),
Alamat_Proyek Varchar(50),
Alamat_Penyuratan varchar(50),
No_Telp number(9),
Id_Arsitek integer,
Id_Marketing integer,
Id_Profil integer,
constraint pk_Proyek primary key(Alamat_Proyek)
);

alter table Proyek
add constraint fk_Marketing foreign key (Id_Marketing) references Marketing (Id_Marketing)
add constraint fk_Arsitek foreign key (Id_Arsitek) references Arsitek (Id_Arsitek)
add constraint fk_Profil foreign key (Id_Profil) references Profil_Aluminium (Id_Profil)
;

alter table Marketing
rename column Nama_Marketing to O6990_Nama_Marketing;

alter table Proyek modify (Id_Profil number(12));

ALTER TABLE Proyek
add UNIQUE (No_Telp);

create sequence Id_Marketing
minvalue 1
maxvalue 9999
start with 1
increment by 1
cache 20;

insert table profil_aluminium
-----------------------------
insert into profil_aluminium
(id_profil, nama_profil, warna)
values (1, 'strandart', 'iron grey');
insert into profil_aluminium
(id_profil, nama_profil, warna)
values (2, 'standart', 'white');

insert all
into profil_aluminium (id_profil, nama_profil, warna)
values (3, 'standart', 'black sahara')
into profil_aluminium (id_profil, nama_profil, warna)
values (4, 'penta 40', 'iron grey')
into profil_aluminium (id_profil, nama_profil, warna)
values (5, 'penta 40', 'white')
select 1 from dual;

---------------------------
insert table marketing
---------------------------
insert into marketing
(id_marketing, nama_marketing, no_telp)
values (id_marketing.nextval, 'rahmad', '123456789');
insert into marketing
(id_marketing, nama_marketing, no_telp)
values (id_marketing.nextval, 'artani', '234567891');

CREATE FUNCTION get_seq RETURN NUMBER IS
BEGIN
  RETURN id_marketing.nextval;
END;
/

insert all
into marketing (id_marketing, nama_marketing, no_telp)
values (get_seq, 'hendro', '345678912')
into marketing 
(id_marketing, nama_marketing, no_telp)
values (get_seq, 'france', '456789123')
into marketing (id_marketing, nama_marketing, no_telp)
values (get_seq, 'yudha', '567891234')
select 1 from dual;

DROP FUNCTION khoirul_huda_06990.get_seq; 

--------------------------
insert table arsitek
--------------------------
insert into arsitek
(id_arsitek, nama_arsitek, telp_kantor)
values (1, 'santoso', '111111111');
insert into arsitek
(id_arsitek, nama_arsitek, telp_kantor)
values (2, 'budi kurniawan', '222222222');

insert all
into arsitek
(id_arsitek, nama_arsitek, telp_kantor)
values (3, 'bambang handoko', '333333333')
into arsitek
(id_arsitek, nama_arsitek, telp_kantor)
values (4, 'margono', '444444444')
into arsitek
(id_arsitek, nama_arsitek, telp_kantor)
values (5, 'yudha prasetya', '555555555')
select 1 from dual;

--------------------------
insert table proyek
--------------------------
insert into proyek
(nama_owner, alamat_proyek, alamat_penyuratan, no_telp, id_arsitek, id_marketing, id_profil)
values ('kardono', 'graha family blok-k 62', 'Dusan', '111111111', 1, 2, 2);
insert into proyek
(nama_owner, alamat_proyek, alamat_penyuratan, no_telp, id_arsitek, id_marketing, id_profil)
values ('sudarmono', 'graha family blok-h 18', 'graha family blok-h 18', '222222222', 5, 1, 1);

insert all
into proyek
(nama_owner, alamat_proyek, alamat_penyuratan, no_telp, id_arsitek, id_marketing, id_profil)
values ('yunus', 'BDG N-45', 'BK', '333333333', 2, 1, 1)
into proyek
(nama_owner, alamat_proyek, alamat_penyuratan, no_telp, id_arsitek, id_marketing, id_profil)
values ('alex', 'Citraland blok-i4 20', 'embong malang', '444444444', 1, 2, 1)
into proyek
(nama_owner, alamat_proyek, alamat_penyuratan, no_telp, id_arsitek, id_marketing, id_profil)
values ('yos tanoyo', 'Citraland blok-h2 1', 'embong malang', '555555555', 1, 2, 2)
select 1 from dual;

-----------------
update
-----------------

update marketing set no_telp = '111111111' where id_marketing >= 1;

update profil_aluminium set nama_profil = 'penta 50' , warna = 'antico brown' where id_profil = 4;
update profil_aluminium set nama_profil = 'penta 50' , warna = 'black sahara' where id_profil = 5;
update marketing set no_telp = '999999999' where nama_marketing = 'france';
update arsitek set telp_kantor = '999999999' where nama_arsitek like '%y%';
update proyek set alamat_penyuratan = 'Dusan' where nama_owner = 'yos tanoyo' AND id_marketing = 2 OR alamat_proyek = 'Citraland blok-h2 1';

delete from marketing
where nama_marketing != 'rahmad'
AND nama_marketing != 'artani'
OR id_marketing > 2;

savepoint pertama;
commit;
rollback to savepoint pertama;

select nama_owner, alamat_penyuratan from proyek order by id_marketing;

select warna, count(nama_profil) AS "banyak"
from profil_aluminium
group by warna;

select nama_owner,
max (id_marketing) as "terbanyak",
min (id_marketing) as "terendah"
from proyek
group by nama_owner;

select warna, count(nama_profil) AS "banyak"
from profil_aluminium
where nama_profil = 'standart'
and warna != 'white'
group by warna;

select id_arsitek,
sum (id_profil) as "jumlah"
from proyek
group by id_arsitek;

select id_arsitek,
avg(id_profil) as "rata2"
from proyek
group by id_arsitek;

select id_marketing, nama_marketing, no_telp
from marketing where id_marketing =
(select max(id_marketing)
from marketing);

select id_marketing, nama_marketing, no_telp
from marketing where id_marketing =
(select min(id_marketing)
from marketing);

select nama_owner from proyek
where id_marketing != (select min(id_marketing) as minimal from proyek)
and id_marketing = (select max(id_marketing) as maksimal from proyek)
group by nama_owner;

select id_profil,rata2 from proyek,
(select sum (rata) as rata2 from
(select avg(id_profil) as rata from proyek
group by id_profil));

select warna, count(nama_profil) AS "banyak"
from profil_aluminium
where warna = any (select warna from profil_aluminium
where warna = any (select warna from profil_aluminium
where warna !='white'))
group by warna;

select id_marketing, count (id_arsitek) as banyak from proyek
where id_arsitek < (select avg(id_arsitek) as rata from proyek)
and id_arsitek != (select sum(id_arsitek) as jumlah from proyek)
group by id_marketing;

select m.nama_marketing, py.nama_owner
from proyek py join
marketing m
on py.id_marketing = m.id_marketing
where py.id_marketing = 2;

select m.nama_marketing, py.nama_owner, a.nama_arsitek
from proyek py left join
marketing m
on py.id_marketing = m.id_marketing
left join arsitek a
on py.id_arsitek = a.id_arsitek
where py.id_marketing = 
(select id_marketing from marketing
where nama_marketing = 'rahmad')
;

select m.nama_marketing, pr.nama_profil,
count(m.nama_marketing) as jumlah
from proyek py
right join profil_aluminium pr
on pr.id_profil = py.id_profil
right join marketing m
on m.id_marketing = py.id_marketing
where pr.nama_profil = 'standart'
and pr.warna = 'iron grey'
group by m.nama_marketing, pr.nama_profil
;

select * from arsitek;
select * from marketing;
select * from profil_aluminium;

create view kepemilikan_proyek
as select m.nama_marketing, py.nama_owner
from proyek py join
marketing m
on py.id_marketing = m.id_marketing
where py.id_marketing = 2;

create view kepemilikan_proyek_arsitek
as select m.nama_marketing, py.nama_owner, a.nama_arsitek
from proyek py left join
marketing m
on py.id_marketing = m.id_marketing
left join arsitek a
on py.id_arsitek = a.id_arsitek
where py.id_marketing = 
(select id_marketing from marketing
where nama_marketing = 'rahmad')
;

create view jumlah_profil_digunakan
as select m.nama_marketing, pr.nama_profil,
count(m.nama_marketing) as jumlah
from proyek py
right join profil_aluminium pr
on pr.id_profil = py.id_profil
right join marketing m
on m.id_marketing = py.id_marketing
where pr.nama_profil = 'standart'
and pr.warna = 'iron grey'
group by m.nama_marketing, pr.nama_profil
;

select * from kepemilikan_proyek;
select * from kepemilikan_proyek_arsitek;
select * from jumlah_profil_digunakan;