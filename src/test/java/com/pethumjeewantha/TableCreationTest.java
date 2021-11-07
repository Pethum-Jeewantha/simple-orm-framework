package com.pethumjeewantha;

import com.pethumjeewantha.annotations.Column;
import com.pethumjeewantha.annotations.Table;
import com.pethumjeewantha.util.DuplicateIdException;
import com.pethumjeewantha.util.NoSuchColumnException;
import com.pethumjeewantha.util.NoSuchTableException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Table("student")
class Student {

    @Column("id")
    String id;
    @Column("name")
    String name;
    @Column("address")
    String address;
    @Column("contact")
    int contact;
    @Column("price")
    BigDecimal price;
}

class TableCreationTest {

    @AfterEach
    void tearDown() throws SQLException {
        /*Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/annotation_table", "root", "mysql");
        Statement stm = connection.createStatement();
        stm.executeUpdate("DROP TABLE student");*/
    }

    @Test
    void init() throws SQLException, NoSuchTableException, NoSuchColumnException, DuplicateIdException, InvocationTargetException, IllegalAccessException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/annotation_table", "root", "mysql");
        TableCreation.init(connection, Student.class);
    }
}