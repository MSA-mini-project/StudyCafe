DROP SEQUENCE seq_seat_idx;

alter table seats modify(user_idx NULL);

CREATE SEQUENCE seq_seat_idx
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

DECLARE
BEGIN
    -- �¼� ������ �߰� (2000�� �������� 10��)
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

    -- �¼� ������ �߰� (4000�� �������� 10��)
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

    -- �¼� ������ �߰� (5000�� �������� 10��)
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

    -- �¼� ������ �߰� (7000�� �������� 5��)
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

