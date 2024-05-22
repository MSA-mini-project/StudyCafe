CREATE SEQUENCE seq_drink_idx
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;
    
-- Ŀ�� �� ���� �߰�
DECLARE
    coffee_names SYS.ODCIVARCHAR2LIST := SYS.ODCIVARCHAR2LIST('�Ƹ޸�ī��', 'ī���', '����', '������ �꽺');
BEGIN
    FOR i IN 1..coffee_names.COUNT LOOP
        INSERT INTO menu (drink_idx, drink_name, drink_price, remaining)
        VALUES (seq_drink_idx.NEXTVAL, coffee_names(i), ROUND(DBMS_RANDOM.VALUE(2500, 4500)), ROUND(DBMS_RANDOM.VALUE(10, 50)));
    END LOOP;
END;
/

-- ���̵� �߰�
DECLARE
    ade_names SYS.ODCIVARCHAR2LIST := SYS.ODCIVARCHAR2LIST('�����̵�', '�ڸ����̵�', '���⿡�̵�', 'û�������̵�');
BEGIN
    FOR i IN 1..ade_names.COUNT LOOP
        INSERT INTO menu (drink_idx, drink_name, drink_price, remaining)
        VALUES (seq_drink_idx.NEXTVAL, ade_names(i), ROUND(DBMS_RANDOM.VALUE(3000, 5000)), ROUND(DBMS_RANDOM.VALUE(10, 50)));
    END LOOP;
END;
/

-- ������ �߰�
DECLARE
    smoothie_names SYS.ODCIVARCHAR2LIST := SYS.ODCIVARCHAR2LIST('���⽺����', '��纣��������', '��������', '�ٳ���������');
BEGIN
    FOR i IN 1..smoothie_names.COUNT LOOP
        INSERT INTO menu (drink_idx, drink_name, drink_price, remaining)
        VALUES (seq_drink_idx.NEXTVAL, smoothie_names(i), ROUND(DBMS_RANDOM.VALUE(3500, 5500)), ROUND(DBMS_RANDOM.VALUE(10, 50)));
    END LOOP;
END;
/