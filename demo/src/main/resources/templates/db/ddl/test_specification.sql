-- Project Name : test_specification
-- Date/Time    : 2022/04/24 18:29:41
-- Author       : masshun
-- RDBMS Type   : PostgreSQL
-- Application  : A5:SQL Mk-2

/*
  << ���ӁI�I >>
  BackupToTempTable, RestoreFromTempTable�^�����߂��t������Ă��܂��B
  ����ɂ��Adrop table, create table ����f�[�^���c��܂��B
  ���̋@�\�͈ꎞ�I�� $$TableName �̂悤�Ȉꎞ�e�[�u�����쐬���܂��B
  ���̋@�\�� A5:SQL Mk-2�ł̂ݗL���ł��邱�Ƃɒ��ӂ��Ă��������B
*/

-- �^�O
--* RestoreFromTempTable
create table m_tag (
  tag_id integer not null
  , tag_name varchar(100) not null
  , constraint m_tag_PKC primary key (tag_id)
) ;

-- �A�J�E���g
--* RestoreFromTempTable
create table account (
  account_id integer not null
  , account_name varchar(100) not null
  , email varchar(255) not null
  , created_at timestamp with time zone default now() not null
  , constraint account_PKC primary key (account_id)
) ;

-- ���[��
--* RestoreFromTempTable
create table m_role (
  role_id integer not null
  , role_name varchar(100) not null
  , created_at timestamp with time zone default now() not null
  , constraint m_role_PKC primary key (role_id)
) ;

-- �e�X�g�d�l��
--* RestoreFromTempTable
create table m_test_specification (
  test_specification_id integer not null
  , title varchar(50) not null
  , tested_dt timestamp with time zone
  , test_supplement varchar(255)
  , created_at timestamp with time zone default now() not null
  , constraint m_test_specification_PKC primary key (test_specification_id)
) ;

-- �e�X�g�X�C�[�g
--* RestoreFromTempTable
create table m_test_suite (
  test_suite_id integer not null
  , test_target varchar(100) not null
  , expected varchar(255) not null
  , testSupplement varchar(255)
  , constraint m_test_suite_PKC primary key (test_suite_id)
) ;

-- �e�X�g�P�[�X
--* RestoreFromTempTable
create table m_test_case (
  test_case_id integer not null
  , target varchar(100) not null
  , expected varchar(255) not null
  , test_supplement varchar(255)
  , status integer default 0 not null
  , constraint m_test_case_PKC primary key (test_case_id)
) ;

-- �e�X�g�X�C�[�g-�e�X�g�P�[�X�����[�V����
--* RestoreFromTempTable
create table r_test_suite_test_case (
  test_suite_id integer not null
  , test_case_id integer not null
  , foreign key (test_suite_id) references m_test_suite(test_suite_id)
  on delete cascade
  , foreign key (test_case_id) references m_test_case(test_case_id)
  on delete cascade
) ;

alter table r_test_suite_test_case add constraint r_test_suite_test_case_IX1
  unique (test_case_id,test_suite_id) ;

-- �e�X�g�d�l��-�A�J�E���g�����[�V����
--* RestoreFromTempTable
create table r_test_specification_account (
  test_specification_id integer not null
  , account_id integer not null
  , foreign key (test_specification_id) references m_test_specification(test_specification_id)
  on delete cascade
  , foreign key (account_id) references account(account_id)
  on delete cascade
) ;

alter table r_test_specification_account add constraint r_test_specification_account_IX1
  unique (test_specification_id,account_id) ;

-- �^�O-�e�X�g�P�[�X�����[�V����
--* RestoreFromTempTable
create table r_tag_test_case (
  tag_id integer not null
  , test_case_id integer not null
  , foreign key (tag_id) references m_tag(tag_id)
  on delete cascade
  , foreign key (test_case_id) references m_test_case(test_case_id)
  on delete cascade
) ;

alter table r_tag_test_case add constraint r_tag_test_case_IX1
  unique (test_case_id,tag_id) ;

-- �^�O-�e�X�g�X�C�[�g�����[�V����
--* RestoreFromTempTable
create table r_tag_test_suite (
  tag_id integer not null
  , test_suite_id integer not null
  , foreign key (tag_id) references m_tag(tag_id)
  on delete cascade
  , foreign key (test_suite_id) references m_test_suite(test_suite_id)
  on delete cascade
) ;

alter table r_tag_test_suite add constraint r_tag_test_suite_IX1
  unique (test_suite_id,tag_id) ;

-- �e�X�g�d�l��-�e�X�g�X�C�[�g�����[�V����
--* RestoreFromTempTable
create table r_test_specification_test_suite (
  test_specification_id integer not null
  , test_suite_id integer not null
  , foreign key (test_specification_id) references m_test_specification(test_specification_id)
  on delete cascade
  , foreign key (test_suite_id) references m_test_suite(test_suite_id)
  on delete cascade
) ;

alter table r_test_specification_test_suite add constraint r_test_specification_test_suite_IX1
  unique (test_suite_id,test_specification_id) ;

-- �A�J�E���g-���[�������[�V����
--* RestoreFromTempTable
create table r_account_role (
  account_id integer not null
  , role_id integer not null
  , foreign key (account_id) references account(account_id)
  on delete cascade
  , foreign key (role_id) references m_role(role_id)
  on delete cascade
) ;

alter table r_account_role add constraint r_account_role_IX1
  unique (account_id,role_id) ;

comment on table r_test_suite_test_case is '�e�X�g�X�C�[�g-�e�X�g�P�[�X�����[�V����';
comment on column r_test_suite_test_case.test_suite_id is '�e�X�g�X�C�[�gID';
comment on column r_test_suite_test_case.test_case_id is '�e�X�g�P�[�XID';

comment on table r_test_specification_account is '�e�X�g�d�l��-�A�J�E���g�����[�V����';
comment on column r_test_specification_account.test_specification_id is '�e�X�g�d�l��ID';
comment on column r_test_specification_account.account_id is '�A�J�E���gID';

comment on table r_tag_test_case is '�^�O-�e�X�g�P�[�X�����[�V����';
comment on column r_tag_test_case.tag_id is '�^�OID';
comment on column r_tag_test_case.test_case_id is '�e�X�g�P�[�XID';

comment on table r_tag_test_suite is '�^�O-�e�X�g�X�C�[�g�����[�V����';
comment on column r_tag_test_suite.tag_id is '�^�OID';
comment on column r_tag_test_suite.test_suite_id is '�e�X�g�X�C�[�gID';

comment on table m_tag is '�^�O';
comment on column m_tag.tag_id is '�^�OID';
comment on column m_tag.tag_name is '�^�O��';

comment on table m_test_suite is '�e�X�g�X�C�[�g';
comment on column m_test_suite.test_suite_id is '�e�X�g�X�C�[�gID';
comment on column m_test_suite.test_target is '�e�X�g�Ώ�';
comment on column m_test_suite.expected is '���ғ��e';
comment on column m_test_suite.testSupplement is '���l';

comment on table r_test_specification_test_suite is '�e�X�g�d�l��-�e�X�g�X�C�[�g�����[�V����';
comment on column r_test_specification_test_suite.test_specification_id is '�e�X�g�d�l��ID';
comment on column r_test_specification_test_suite.test_suite_id is '�e�X�g�X�C�[�gID';

comment on table m_test_case is '�e�X�g�P�[�X';
comment on column m_test_case.test_case_id is '�e�X�g�P�[�XID';
comment on column m_test_case.target is '�e�X�g�Ώ�';
comment on column m_test_case.expected is '���ғ��e';
comment on column m_test_case.test_supplement is '���l';
comment on column m_test_case.status is '���:0:�����{1:�e�X�g��2:����3:�ۗ�4:�J���ґΉ���';

comment on table r_account_role is '�A�J�E���g-���[�������[�V����';
comment on column r_account_role.account_id is '�A�J�E���gID';
comment on column r_account_role.role_id is '���[��ID';

comment on table m_role is '���[��';
comment on column m_role.role_id is '���[��ID';
comment on column m_role.role_name is '���[����';
comment on column m_role.created_at is '�쐬����';

comment on table account is '�A�J�E���g';
comment on column account.account_id is '�A�J�E���gID';
comment on column account.account_name is '�A�J�E���g��';
comment on column account.email is '���[���A�h���X';
comment on column account.created_at is '�쐬����';

comment on table m_test_specification is '�e�X�g�d�l��';
comment on column m_test_specification.test_specification_id is '�d�l��ID';
comment on column m_test_specification.title is '�^�C�g��';
comment on column m_test_specification.tested_dt is '�e�X�g���{����';
comment on column m_test_specification.test_supplement is '���l';
comment on column m_test_specification.created_at is '�쐬����';

