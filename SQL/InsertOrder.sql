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
    v_drink_cursor SYS_REFCURSOR; -- 메뉴 테이블의 음료 리스트를 가져오기 위한 커서 변수 선언
    v_drink_idx menu.drink_idx%TYPE; -- 주문할 음료의 drink_idx 변수 선언
BEGIN
    -- 사용자 수 확인
    SELECT COUNT(*) INTO v_user_count FROM users;

    -- 메뉴 테이블에서 음료 리스트 가져오기
    OPEN v_drink_cursor FOR
        SELECT drink_idx FROM menu ORDER BY drink_idx; -- 메뉴 테이블의 drink_idx로 정렬하여 음료 리스트 가져오기

    -- 사용자 순서대로 총 10개의 주문 추가
    FOR u IN (SELECT user_idx FROM users ORDER BY user_idx) LOOP
            -- 음료 리스트 커서에서 다음 음료 가져오기
            FETCH v_drink_cursor INTO v_drink_idx;

            -- 주문 내역 추가
            INSERT INTO orders (order_idx, users_user_idx, order_date, drink_idx)
            VALUES (seq_order_idx.NEXTVAL, u.user_idx, SYSDATE, v_drink_idx);
    END LOOP;

    -- 커서 닫기
    CLOSE v_drink_cursor;
END;
/
