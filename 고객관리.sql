/*고객 관리 */
create table customer {
id  varchar2{50},
name varchar2{50} not null,
gender varchar{3} default '남' not null,
email varchar{50},
phone varchar{13},
constraint customer_id_pk primary key(id)
};