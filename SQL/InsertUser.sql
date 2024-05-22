CREATE SEQUENCE seq_user_idx
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

-- 사용자 데이터 추가
DECLARE
    user_name_list SYS.ODCIVARCHAR2LIST := SYS.ODCIVARCHAR2LIST('홍길동', '김철수', '이영희', '박지영', '최영수', '정수민', '장미경', '강동원', '서지혜', '임채영');
    user_phone_list SYS.ODCIVARCHAR2LIST := SYS.ODCIVARCHAR2LIST('01012345678', '01098765432', '01056781234', '01011112222', '01033334444', '01055556666', '01077778888', '01099990000', '01024681357', '01013579246');
    user_pw_list SYS.ODCIVARCHAR2LIST := SYS.ODCIVARCHAR2LIST('password123', 'qwerty123', 'pass1234', 'abcd1234', '1234abcd', 'abcd1234', 'qwertyui', 'asdfghjk', 'zxcvbnml', '0987654321');
BEGIN
    FOR i IN 1..10 LOOP
        INSERT INTO users (user_idx, user_name, user_phone, user_pw, report_count, admin)
        VALUES (seq_user_idx.NEXTVAL, user_name_list(i), user_phone_list(i), user_pw_list(i), 0, 'N');
    END LOOP;
END;
/

drop sequence seq_users_idx;

--관리자 데이터는 따로 추가
CREATE SEQUENCE seq_admin_idx
    START WITH 11
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

DECLARE
    user_name_list SYS.ODCIVARCHAR2LIST := SYS.ODCIVARCHAR2LIST('강민지','김찬별','이푸름');
    user_phone_list SYS.ODCIVARCHAR2LIST := SYS.ODCIVARCHAR2LIST('01022222222', '01032431234', '01054368994');
    user_pw_list SYS.ODCIVARCHAR2LIST := SYS.ODCIVARCHAR2LIST('admin','admin','admin');
BEGIN
    FOR i IN 1..3 LOOP
        INSERT INTO users (user_idx, user_name, user_phone, user_pw, report_count, admin)
        VALUES (seq_admin_idx.NEXTVAL, user_name_list(i), user_phone_list(i), user_pw_list(i), 0, 'Y');
    END LOOP;
END;
/