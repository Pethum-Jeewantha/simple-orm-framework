package com.pethumjeewantha;

import com.pethumjeewantha.annotations.Column;
import com.pethumjeewantha.annotations.Id;
import com.pethumjeewantha.annotations.Table;
import com.pethumjeewantha.util.DuplicateIdException;
import com.pethumjeewantha.util.NoSuchColumnException;
import com.pethumjeewantha.util.NoSuchTableException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Table("student")
class Student {

    @Column("id")
    String id;
    @Id
    @Column("name")
    String name;
    @Column("address")
    String address;
    @Column("contact")
    int contact;
    @Column("price")
    BigDecimal price;
    @Column("qty")
    int qty;
    @Column("range")
    double range;
}

class TableCreationTest {
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/annotation_table", "root", "mysql");

    TableCreationTest() throws SQLException {
    }

    @AfterEach
    void tearDown() throws SQLException {
        Statement stm = connection.createStatement();
        stm.executeUpdate("DROP TABLE IF EXISTS student");
    }

    @BeforeEach
    void setUp() throws SQLException {
        Statement stm = connection.createStatement();
        stm.executeUpdate("DROP TABLE IF EXISTS student");
    }

    @Test
    void init() throws SQLException, NoSuchTableException, NoSuchColumnException, DuplicateIdException, InvocationTargetException, IllegalAccessException {
        assertEquals(1, TableCreation.init(connection, Student.class));
    }
}