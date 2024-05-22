CREATE SEQUENCE seq_drink_idx
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;
    
-- 커피 등 음료 추가
DECLARE
    coffee_names SYS.ODCIVARCHAR2LIST := SYS.ODCIVARCHAR2LIST('아메리카노', '카페라떼', '생수', '오렌지 쥬스');
BEGIN
    FOR i IN 1..coffee_names.COUNT LOOP
        INSERT INTO menu (drink_idx, drink_name, drink_price, remaining)
        VALUES (seq_drink_idx.NEXTVAL, coffee_names(i), ROUND(DBMS_RANDOM.VALUE(2500, 4500)), ROUND(DBMS_RANDOM.VALUE(10, 50)));
    END LOOP;
END;
/

-- 에이드 추가
DECLARE
    ade_names SYS.ODCIVARCHAR2LIST := SYS.ODCIVARCHAR2LIST('레몬에이드', '자몽에이드', '딸기에이드', '청포도에이드');
BEGIN
    FOR i IN 1..ade_names.COUNT LOOP
        INSERT INTO menu (drink_idx, drink_name, drink_price, remaining)
        VALUES (seq_drink_idx.NEXTVAL, ade_names(i), ROUND(DBMS_RANDOM.VALUE(3000, 5000)), ROUND(DBMS_RANDOM.VALUE(10, 50)));
    END LOOP;
END;
/

-- 스무디 추가
DECLARE
    smoothie_names SYS.ODCIVARCHAR2LIST := SYS.ODCIVARCHAR2LIST('딸기스무디', '블루베리스무디', '망고스무디', '바나나스무디');
BEGIN
    FOR i IN 1..smoothie_names.COUNT LOOP
        INSERT INTO menu (drink_idx, drink_name, drink_price, remaining)
        VALUES (seq_drink_idx.NEXTVAL, smoothie_names(i), ROUND(DBMS_RANDOM.VALUE(3500, 5500)), ROUND(DBMS_RANDOM.VALUE(10, 50)));
    END LOOP;
END;
/