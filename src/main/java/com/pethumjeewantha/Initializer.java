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

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Initializer {
    private static final StringBuilder sql = new StringBuilder("CREATE TABLE ");

    public static int init(Connection connection, Class tableClass) throws NoSuchTableException, DuplicateIdException, NoSuchColumnException, InvocationTargetException, IllegalAccessException, SQLException {
        Annotation table = tableClass.getAnnotation(Table.class);

        if (table == null) throw new NoSuchTableException("Add Table Class");
        String tableName = (String) table.annotationType().getDeclaredMethods()[0].invoke(table, (Object[]) null);

        sql.append(String.format("`%s` (", tableName));
        Field[] fields = tableClass.getDeclaredFields();
        int columnCount = 0;
        int idCount = 0;
        String id = "";

        for (Field field : fields) {
            Column columnClass = field.getAnnotation(Column.class);

            String type = "";
            switch (field.getType().getTypeName()) {
                case "java.lang.String":
                    type = "VARCHAR(500)";
                    break;
                case "java.math.BigDecimal":
                    type = "DECIMAL";
                    break;
                default:
                    Embed embed = field.getAnnotation(Embed.class);
                    if (embed != null) {
                        embed(field.getType());
                        continue;
                    } else if (field.getClass().getName().startsWith("java.lang.")) {
                        type = field.getType().getTypeName();
                    } else {
                        continue;
                    }
            }

            sql.append("`").append(columnClass.value()).append("` ").append(type).append(", ");
            columnCount++;

            Id idClass = field.getAnnotation(Id.class);
            if (idClass != null) {
                id = columnClass.value();
                idCount++;
            }
        }

        if (columnCount < 1) throw new NoSuchColumnException("Column count must be at least one");

        if (idCount > 1) throw new DuplicateIdException("Id should not be duplicate");

        if (idCount == 1) {
            sql.append(String.format("CONSTRAINT PRIMARY KEY (%s)", id));
        } else {
            sql.deleteCharAt(sql.length() - 2);
        }

        sql.append(");");
        Statement stm = connection.createStatement();
        System.out.println(sql);

        if (stm.executeUpdate(sql.toString()) == 0) {
            return 1;
        } else {
            return -1;
        }
    }

    private static void embed(Class tableColumn) {
        Field[] fields = tableColumn.getDeclaredFields();

        for (Field field : fields) {
            Column columnClass = field.getAnnotation(Column.class);

            String type = "";
            switch (field.getType().getTypeName()) {
                case "java.lang.String":
                    type = "VARCHAR(500)";
                    break;
                case "java.math.BigDecimal":
                    type = "DECIMAL";
                    break;
                default:
                    Embed embed = field.getAnnotation(Embed.class);
                    if (embed != null) {
                        throw new RuntimeException("The classes must be nested in one level");
                    } else if (field.getClass().getName().startsWith("java.lang.")) {
                        type = field.getType().getTypeName();
                    } else {
                        continue;
                    }
            }

            sql.append("`").append(columnClass.value()).append("` ").append(type).append(", ");

            Id idClass = field.getAnnotation(Id.class);
            if (idClass == null) {
                throw new RuntimeException("Primary key must be in the @table() class");
            }
        }
    }
}
