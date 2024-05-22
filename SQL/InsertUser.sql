CREATE SEQUENCE seq_user_idx
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

-- ����� ������ �߰�
DECLARE
    user_name_list SYS.ODCIVARCHAR2LIST := SYS.ODCIVARCHAR2LIST('ȫ�浿', '��ö��', '�̿���', '������', '�ֿ���', '������', '��̰�', '������', '������', '��ä��');
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

--������ �����ʹ� ���� �߰�
CREATE SEQUENCE seq_admin_idx
    START WITH 11
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

DECLARE
    user_name_list SYS.ODCIVARCHAR2LIST := SYS.ODCIVARCHAR2LIST('������','������','��Ǫ��');
    user_phone_list SYS.ODCIVARCHAR2LIST := SYS.ODCIVARCHAR2LIST('01022222222', '01032431234', '01054368994');
    user_pw_list SYS.ODCIVARCHAR2LIST := SYS.ODCIVARCHAR2LIST('admin','admin','admin');
BEGIN
    FOR i IN 1..3 LOOP
        INSERT INTO users (user_idx, user_name, user_phone, user_pw, report_count, admin)
        VALUES (seq_admin_idx.NEXTVAL, user_name_list(i), user_phone_list(i), user_pw_list(i), 0, 'Y');
    END LOOP;
END;
/