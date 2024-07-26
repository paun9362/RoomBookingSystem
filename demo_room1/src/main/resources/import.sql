DROP TABLE IF EXISTS room;

CREATE TABLE room (
    id INT AUTO_INCREMENT PRIMARY KEY,
    room_type VARCHAR(50) NOT NULL,
);

INSERT INTO room (room_type, is_booked) VALUES ('Big' );
INSERT INTO room (room_type, is_booked) VALUES ('Big' );
INSERT INTO room (room_type, is_booked) VALUES ('Medium' );
INSERT INTO room (room_type, is_booked) VALUES ('Medium');
INSERT INTO room (room_type, is_booked) VALUES ('Small');
INSERT INTO room (room_type, is_booked) VALUES ('Small');
INSERT INTO room (room_type, is_booked) VALUES ('Small');
INSERT INTO room (room_type, is_booked) VALUES ('Small');
INSERT INTO room (room_type, is_booked) VALUES ('Small');
INSERT INTO room (room_type, is_booked) VALUES ('Small');
INSERT INTO room (room_type, is_booked) VALUES ('Small');
INSERT INTO room (room_type, is_booked) VALUES ('Small');
