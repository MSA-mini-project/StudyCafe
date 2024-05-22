drop SEQUENCE seq_drink_idx;
drop sequence seq_order_idx;

CREATE SEQUENCE seq_order_idx
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;
    
CREATE SEQUENCE seq_drink_idx
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;
    


DECLARE
    v_user_count NUMBER;
    v_user_idx users.user_idx%TYPE;
    v_drink_cursor SYS_REFCURSOR; -- �޴� ���̺��� ���� ����Ʈ�� �������� ���� Ŀ�� ���� ����
    v_drink_idx menu.drink_idx%TYPE; -- �ֹ��� ������ drink_idx ���� ����
BEGIN
    -- ����� �� Ȯ��
    SELECT COUNT(*) INTO v_user_count FROM users;

    -- �޴� ���̺��� ���� ����Ʈ ��������
    OPEN v_drink_cursor FOR
        SELECT drink_idx FROM menu ORDER BY drink_idx; -- �޴� ���̺��� drink_idx�� �����Ͽ� ���� ����Ʈ ��������

    -- ����� ������� �� 10���� �ֹ� �߰�
    FOR u IN (SELECT user_idx FROM users ORDER BY user_idx) LOOP
            -- ���� ����Ʈ Ŀ������ ���� ���� ��������
            FETCH v_drink_cursor INTO v_drink_idx;

            -- �ֹ� ���� �߰�
            INSERT INTO orders (order_idx, users_user_idx, order_date, drink_idx)
            VALUES (seq_order_idx.NEXTVAL, u.user_idx, SYSDATE, v_drink_idx);
    END LOOP;

    -- Ŀ�� �ݱ�
    CLOSE v_drink_cursor;
END;
/
