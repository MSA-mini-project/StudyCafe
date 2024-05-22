DROP SEQUENCE seq_seat_idx;

alter table seats modify(user_idx NULL);

CREATE SEQUENCE seq_seat_idx
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

DECLARE
BEGIN
    -- 좌석 데이터 추가 (2000원 가격으로 10개)
    FOR i IN 1..10 LOOP
        INSERT INTO seats (seat_idx, seat_start_time, seat_end_time, seat_price, waiting_user, user_idx)
        VALUES (
            seq_seat_idx.NEXTVAL,
            NULL,
            NULL,
            2000,
            NULL,
            NULL
        );
    END LOOP;

    -- 좌석 데이터 추가 (4000원 가격으로 10개)
    FOR i IN 1..10 LOOP
        INSERT INTO seats (seat_idx, seat_start_time, seat_end_time, seat_price, waiting_user, user_idx)
        VALUES (
            seq_seat_idx.NEXTVAL,
            NULL,
            NULL,
            4000,
            NULL,
            NULL
        );
    END LOOP;

    -- 좌석 데이터 추가 (5000원 가격으로 10개)
    FOR i IN 1..10 LOOP
        INSERT INTO seats (seat_idx, seat_start_time, seat_end_time, seat_price, waiting_user, user_idx)
        VALUES (
            seq_seat_idx.NEXTVAL,
            NULL,
            NULL,
            5000,
            NULL,
            NULL
        );
    END LOOP;

    -- 좌석 데이터 추가 (7000원 가격으로 5개)
    FOR i IN 1..5 LOOP
        INSERT INTO seats (seat_idx, seat_start_time, seat_end_time, seat_price, waiting_user, user_idx)
        VALUES (
            seq_seat_idx.NEXTVAL,
            NULL,
            NULL,
            7000,
            NULL,
            NULL
        );
    END LOOP;
END;
/

