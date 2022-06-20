-- Project Name : noname
-- Date/Time    : 2022/06/20 22:41:30
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
--* RestoreFromTempTable
create table r_account_role (
  account_id integer not null
  , role_id integer not null
) ;

alter table r_account_role add constraint r_account_role_ix1
  unique (account_id,role_id) ;

-- タグ-テストケースリレーション
--* RestoreFromTempTable
create table r_tag_test_case (
  tag_id integer not null
  , test_case_id integer not null
) ;

alter table r_tag_test_case add constraint r_tag_test_case_ix1
  unique (test_case_id,tag_id) ;

-- タグ-テストスイートリレーション
--* RestoreFromTempTable
create table r_tag_test_suite (
  tag_id integer not null
  , test_suite_id integer not null
) ;

alter table r_tag_test_suite add constraint r_tag_test_suite_ix1
  unique (test_suite_id,tag_id) ;

-- テスト成績書-アカウントリレーション
--* RestoreFromTempTable
create table r_test_report_account (
  test_report_id integer not null
  , account_id integer not null
) ;

alter table r_test_report_account add constraint r_test_report_account_ix1
  unique (test_report_id,account_id) ;

-- テスト成績書-取引先リレーション
--* RestoreFromTempTable
create table r_test_report_supplier (
  test_report_id integer not null
  , supplier_id integer not null
) ;

alter table r_test_report_supplier add constraint r_report_supplier_IX1
  unique (test_report_id,supplier_id) ;

-- テスト成績書-テストスイートリレーション
--* RestoreFromTempTable
create table r_test_report_test_suite (
  test_report_id integer not null
  , test_suite_id integer not null
) ;

alter table r_test_report_test_suite add constraint r_test_report_test_suite_ix1
  unique (test_suite_id,test_report_id) ;

-- テストスイート-テストケースリレーション
--* RestoreFromTempTable
create table r_test_suite_test_case (
  test_suite_id integer not null
  , test_case_id integer not null
) ;

alter table r_test_suite_test_case add constraint r_test_suite_test_case_ix1
  unique (test_case_id,test_suite_id) ;

-- アカウント
--* RestoreFromTempTable
create table m_account (
  account_id integer not null
  , account_name character varying(100) not null
  , email character varying(255) not null
  , created_at timestamp with time zone default now() not null
  , constraint m_account_PKC primary key (account_id)
) ;

-- ロール
--* RestoreFromTempTable
create table m_role (
  role_id integer not null
  , role_name character varying(100) not null
  , created_at timestamp with time zone default now() not null
  , constraint m_role_PKC primary key (role_id)
) ;

-- 取引先
--* RestoreFromTempTable
create table m_supplier (
  spplier_id integer not null
  , spplier_name varchar(100) not null
  , description varchar(100)
  , created_at timestamp with time zone default now() not null
  , constraint m_supplier_PKC primary key (spplier_id)
) ;

-- タグ
--* RestoreFromTempTable
create table m_tag (
  tag_id integer not null
  , tag_name character varying(100) not null
  , created_at timestamp with time zone default now() not null
  , constraint m_tag_PKC primary key (tag_id)
) ;

-- テストケース
--* RestoreFromTempTable
create table m_test_case (
  test_case_id integer not null
  , target character varying(100) not null
  , expected character varying(255) not null
  , description character varying(255)
  , status integer default 0 not null
  , created_at timestamp with time zone default now() not null
  , constraint m_test_case_PKC primary key (test_case_id)
) ;

-- テスト成績書
--* RestoreFromTempTable
create table m_test_report (
  test_report_id integer default nextval('test_report_id_seq') not null
  , title character varying(50) not null
  , tested_dt timestamp(6) with time zone
  , description character varying(255)
  , created_at timestamp with time zone default now() not null
  , constraint m_test_report_PKC primary key (test_report_id)
) ;

-- テストスイート
--* RestoreFromTempTable
create table m_test_suite (
  test_suite_id integer not null
  , test_target character varying(100) not null
  , expected character varying(255) not null
  , description character varying(255)
  , created_at timestamp with time zone default now() not null
  , constraint m_test_suite_PKC primary key (test_suite_id)
) ;

comment on table r_account_role is 'アカウント-ロールリレーション';
comment on column r_account_role.account_id is 'アカウントID';
comment on column r_account_role.role_id is 'ロールID';

comment on table r_tag_test_case is 'タグ-テストケースリレーション';
comment on column r_tag_test_case.tag_id is 'タグID';
comment on column r_tag_test_case.test_case_id is 'テストケースID';

comment on table r_tag_test_suite is 'タグ-テストスイートリレーション';
comment on column r_tag_test_suite.tag_id is 'タグID';
comment on column r_tag_test_suite.test_suite_id is 'テストスイートID';

comment on table r_test_report_account is 'テスト成績書-アカウントリレーション';
comment on column r_test_report_account.test_report_id is 'テスト成績書ID';
comment on column r_test_report_account.account_id is 'アカウントID';

comment on table r_test_report_supplier is 'テスト成績書-取引先リレーション';
comment on column r_test_report_supplier.test_report_id is 'テスト成績書ID';
comment on column r_test_report_supplier.supplier_id is '取引先ID';

comment on table r_test_report_test_suite is 'テスト成績書-テストスイートリレーション';
comment on column r_test_report_test_suite.test_report_id is 'テスト成績書ID';
comment on column r_test_report_test_suite.test_suite_id is 'テストスイートID';

comment on table r_test_suite_test_case is 'テストスイート-テストケースリレーション';
comment on column r_test_suite_test_case.test_suite_id is 'テストスイートID';
comment on column r_test_suite_test_case.test_case_id is 'テストケースID';

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
comment on column m_supplier.spplier_id is '取引先ID';
comment on column m_supplier.spplier_name is '取引先名';
comment on column m_supplier.description is '備考';
comment on column m_supplier.created_at is '作成日時';

comment on table m_tag is 'タグ';
comment on column m_tag.tag_id is 'タグID';
comment on column m_tag.tag_name is 'タグ名';
comment on column m_tag.created_at is '作成日時';

comment on table m_test_case is 'テストケース';
comment on column m_test_case.test_case_id is 'テストケースID';
comment on column m_test_case.target is 'テスト対象';
comment on column m_test_case.expected is '期待内容';
comment on column m_test_case.description is '備考';
comment on column m_test_case.status is '状態:0:未実施1:テスト中2:完了3:保留4:開発者対応中';
comment on column m_test_case.created_at is '作成日時';

comment on table m_test_report is 'テスト成績書';
comment on column m_test_report.test_report_id is '成績書ID';
comment on column m_test_report.title is 'タイトル';
comment on column m_test_report.tested_dt is 'テスト実施日時';
comment on column m_test_report.description is '備考';
comment on column m_test_report.created_at is '作成日時';

comment on table m_test_suite is 'テストスイート';
comment on column m_test_suite.test_suite_id is 'テストスイートID';
comment on column m_test_suite.test_target is 'テスト対象';
comment on column m_test_suite.expected is '期待内容';
comment on column m_test_suite.description is '備考';
comment on column m_test_suite.created_at is '作成日時';

