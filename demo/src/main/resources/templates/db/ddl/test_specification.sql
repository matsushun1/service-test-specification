-- Project Name : noname
-- Date/Time    : 2022/06/24 23:18:55
-- Author       : shunmatsushita
-- RDBMS Type   : PostgreSQL
-- Application  : A5:SQL Mk-2

/*
  << 注意！！ >>
  BackupToTempTable, RestoreFromTempTable疑似命令が付加されています。
  これにより、drop table, create table 後もデータが残ります。
  この機能は一時的に $$TableName のような一時テーブルを作成します。
  この機能は A5:SQL Mk-2でのみ有効であることに注意してください。
*/

-- アカウント-ロールリレーション
--* BackupToTempTable
drop table if exists r_account_role cascade;

--* RestoreFromTempTable
create table r_account_role (
  account_id integer not null
  , role_id integer not null
) ;

alter table r_account_role add constraint r_account_role_ux1
  unique (account_id,role_id) ;

-- テストフレーム-タグリレーション
--* BackupToTempTable
drop table if exists r_test_frame_tag cascade;

--* RestoreFromTempTable
create table r_test_frame_tag (
  test_frame_id integer not null
  , tag_id integer not null
) ;

alter table r_test_frame_tag add constraint r_test_frame_tag_ux1
  unique (test_frame_id,tag_id) ;

-- テスト成績書-アカウントリレーション
--* BackupToTempTable
drop table if exists r_test_report_account cascade;

--* RestoreFromTempTable
create table r_test_report_account (
  test_report_id integer not null
  , account_id integer not null
) ;

alter table r_test_report_account add constraint r_test_report_account_ux1
  unique (test_report_id,account_id) ;

-- テスト成績書-フレームリレーション
--* BackupToTempTable
drop table if exists r_test_report_frame cascade;

--* RestoreFromTempTable
create table r_test_report_frame (
  test_report_id integer not null
  , test_frame_id integer not null
) ;

alter table r_test_report_frame add constraint r_test_report_frame_ux1
  unique (test_report_id,test_frame_id) ;

-- テスト成績書-取引先リレーション
--* BackupToTempTable
drop table if exists r_test_report_supplier cascade;

--* RestoreFromTempTable
create table r_test_report_supplier (
  test_report_id integer not null
  , supplier_id integer not null
) ;

alter table r_test_report_supplier add constraint r_report_supplier_ux1
  unique (test_report_id,supplier_id) ;

-- アカウント
--* BackupToTempTable
drop table if exists m_account cascade;

--* RestoreFromTempTable
create table m_account (
  account_id integer not null
  , account_name character varying(100) not null
  , email character varying(255) not null
  , created_at timestamp with time zone default now() not null
  , constraint m_account_PKC primary key (account_id)
) ;

-- ロール
--* BackupToTempTable
drop table if exists m_role cascade;

--* RestoreFromTempTable
create table m_role (
  role_id integer not null
  , role_name character varying(100) not null
  , created_at timestamp with time zone default now() not null
  , constraint m_role_PKC primary key (role_id)
) ;

-- 取引先
--* BackupToTempTable
drop table if exists m_supplier cascade;

--* RestoreFromTempTable
create table m_supplier (
  supplier_id integer not null
  , supplier_name varchar(100) not null
  , description varchar(100)
  , created_at timestamp with time zone default now() not null
  , constraint m_supplier_PKC primary key (supplier_id)
) ;

-- タグ
--* BackupToTempTable
drop table if exists m_tag cascade;

--* RestoreFromTempTable
create table m_tag (
  tag_id integer not null
  , tag_name character varying(100) not null
  , created_at timestamp with time zone default now() not null
  , constraint m_tag_PKC primary key (tag_id)
) ;

-- テストフレーム
--* BackupToTempTable
drop table if exists m_test_frame cascade;

--* RestoreFromTempTable
create table m_test_frame (
  test_frame_id integer not null
  , title character varying(100) not null
  , target varchar(255)
  , pre_conditions character varying(255)
  , expected character varying(255) not null
  , type integer not null
  , status integer default 0 not null
  , description character varying(255)
  , parent_suite_id integer
  , created_at timestamp with time zone default now() not null
  , constraint m_test_frame_PKC primary key (test_frame_id)
) ;

-- テスト成績書
--* BackupToTempTable
drop table if exists m_test_report cascade;

--* RestoreFromTempTable
create table m_test_report (
  test_report_id integer not null
  , title character varying(50) not null
  , tested_dt timestamp(6) with time zone
  , description character varying(255)
  , status integer not null
  , created_at timestamp with time zone default now() not null
  , constraint m_test_report_PKC primary key (test_report_id)
) ;

alter table m_test_frame
  add constraint m_test_frame_FK1 foreign key (parent_suite_id) references m_test_frame(test_frame_id)
  on delete cascade;

alter table r_account_role
  add constraint r_account_role_FK1 foreign key (account_id) references m_account(account_id)
  on delete cascade;

alter table r_account_role
  add constraint r_account_role_FK2 foreign key (role_id) references m_role(role_id)
  on delete cascade;

alter table r_test_frame_tag
  add constraint r_test_frame_tag_FK1 foreign key (tag_id) references m_tag(tag_id)
  on delete cascade;

alter table r_test_frame_tag
  add constraint r_test_frame_tag_FK2 foreign key (test_frame_id) references m_test_frame(test_frame_id)
  on delete cascade;

alter table r_test_report_account
  add constraint r_test_report_account_FK1 foreign key (test_report_id) references m_test_report(test_report_id)
  on delete cascade;

alter table r_test_report_account
  add constraint r_test_report_account_FK2 foreign key (account_id) references m_account(account_id)
  on delete cascade;

alter table r_test_report_frame
  add constraint r_test_report_frame_FK1 foreign key (test_frame_id) references m_test_frame(test_frame_id)
  on delete cascade;

alter table r_test_report_frame
  add constraint r_test_report_frame_FK2 foreign key (test_report_id) references m_test_report(test_report_id)
  on delete cascade;

alter table r_test_report_supplier
  add constraint r_test_report_supplier_FK1 foreign key (test_report_id) references m_test_report(test_report_id)
  on delete cascade;

alter table r_test_report_supplier
  add constraint r_test_report_supplier_FK2 foreign key (supplier_id) references m_supplier(supplier_id)
  on delete cascade;

comment on table r_account_role is 'アカウント-ロールリレーション';
comment on column r_account_role.account_id is 'アカウントID';
comment on column r_account_role.role_id is 'ロールID';

comment on table r_test_frame_tag is 'テストフレーム-タグリレーション';
comment on column r_test_frame_tag.test_frame_id is 'テストフレームID';
comment on column r_test_frame_tag.tag_id is 'タグID';

comment on table r_test_report_account is 'テスト成績書-アカウントリレーション';
comment on column r_test_report_account.test_report_id is 'テスト成績書ID';
comment on column r_test_report_account.account_id is 'アカウントID';

comment on table r_test_report_frame is 'テスト成績書-フレームリレーション';
comment on column r_test_report_frame.test_report_id is 'テスト成績書ID';
comment on column r_test_report_frame.test_frame_id is 'テストフレームID';

comment on table r_test_report_supplier is 'テスト成績書-取引先リレーション';
comment on column r_test_report_supplier.test_report_id is 'テスト成績書ID';
comment on column r_test_report_supplier.supplier_id is '取引先ID';

comment on table m_account is 'アカウント';
comment on column m_account.account_id is 'アカウントID';
comment on column m_account.account_name is 'アカウント名';
comment on column m_account.email is 'メールアドレス';
comment on column m_account.created_at is '作成日時';

comment on table m_role is 'ロール';
comment on column m_role.role_id is 'ロールID';
comment on column m_role.role_name is 'ロール名';
comment on column m_role.created_at is '作成日時';

comment on table m_supplier is '取引先';
comment on column m_supplier.supplier_id is '取引先ID';
comment on column m_supplier.supplier_name is '取引先名';
comment on column m_supplier.description is '備考';
comment on column m_supplier.created_at is '作成日時';

comment on table m_tag is 'タグ';
comment on column m_tag.tag_id is 'タグID';
comment on column m_tag.tag_name is 'タグ名';
comment on column m_tag.created_at is '作成日時';

comment on table m_test_frame is 'テストフレーム';
comment on column m_test_frame.test_frame_id is 'テストフレームID';
comment on column m_test_frame.title is 'タイトル';
comment on column m_test_frame.target is '対象';
comment on column m_test_frame.pre_conditions is '事前条件';
comment on column m_test_frame.expected is '期待内容';
comment on column m_test_frame.type is 'タイプ:1:テストケース2:テストスイート';
comment on column m_test_frame.status is '状態:0:下書き1:未実施2:テスト中3:完了4:保留5:開発者対応中6:非推奨';
comment on column m_test_frame.description is '備考';
comment on column m_test_frame.parent_suite_id is '親スイートID:親のテストスイートID';
comment on column m_test_frame.created_at is '作成日時';

comment on table m_test_report is 'テスト成績書';
comment on column m_test_report.test_report_id is '成績書ID';
comment on column m_test_report.title is 'タイトル';
comment on column m_test_report.tested_dt is 'テスト実施日時';
comment on column m_test_report.description is '備考';
comment on column m_test_report.status is '状態:0:下書き1:未実施2:完了3:保留';
comment on column m_test_report.created_at is '作成日時';

