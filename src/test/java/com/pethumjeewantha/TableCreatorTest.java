/*
 * Copyright (c) 2021 - present Pethum Jeewantha. All rights reserved.
 *  Licensed under the MIT License. See LICENSE.txt in the project root for license information.
 */

package com.pethumjeewantha;

import com.pethumjeewantha.annotations.Column;
import com.pethumjeewantha.annotations.Embed;
import com.pethumjeewantha.annotations.Id;
import com.pethumjeewantha.annotations.Table;
import com.pethumjeewantha.util.DuplicateIdException;
import com.pethumjeewantha.util.NoSuchColumnException;
import com.pethumjeewantha.util.NoSuchTableException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Table("student")
class Student {

    @Id
    @Column("id")
    String id;
    @Column("name")
    String name;
    @Embed
    Customer customer;
    @Column("address")
    String address;
    @Column("contact")
    int contact;
}

class Customer {
    @Column("customer_id")
    String code;
    @Column("customer_name")
    String fullName;
    @Column("customer_address")
    String address;
    @Column("customer_contact")
    int contact;
}

class TableCreatorTest {
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/annotation_table", "root", "mysql");

    TableCreatorTest() throws SQLException {
    }

    @AfterEach
    void tearDown() throws SQLException {
        /*Statement stm = connection.createStatement();
        stm.executeUpdate("DROP TABLE IF EXISTS student");*/
    }

    @BeforeEach
    void setUp() throws SQLException {
        Statement stm = connection.createStatement();
        stm.executeUpdate("DROP TABLE IF EXISTS student");
    }

    @Test
    void init() throws SQLException, NoSuchTableException, NoSuchColumnException, DuplicateIdException, InvocationTargetException, IllegalAccessException {
        assertEquals(1, TableCreator.init(connection, Student.class));
//        assertThrows(DuplicateIdException.class,() -> TableCreation.init(connection,Student.class));
    }
}