package com.pethumjeewantha;

import com.pethumjeewantha.annotations.Column;
import com.pethumjeewantha.annotations.Id;
import com.pethumjeewantha.annotations.Table;
import com.pethumjeewantha.util.NoSuchTableException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Table("student")
class Student {

    @Id
    @Column("id")
    String id;
    @Column("name")
    String name;
    @Column("address")
    String address;
}

class TableCreationTest {

    @AfterEach
    void tearDown() throws SQLException {
        /*Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/annotation_table", "root", "mysql");
        Statement stm = connection.createStatement();
        stm.executeUpdate("DROP TABLE student");*/
    }

    @Test
    void init() throws SQLException, NoSuchTableException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/annotation_table", "root", "mysql");
        TableCreation.init(connection, Student.class);
    }
}