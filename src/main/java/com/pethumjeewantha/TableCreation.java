package com.pethumjeewantha;

import com.pethumjeewantha.annotations.Column;
import com.pethumjeewantha.annotations.Id;
import com.pethumjeewantha.annotations.Table;
import com.pethumjeewantha.util.DuplicateIdException;
import com.pethumjeewantha.util.NoSuchColumnException;
import com.pethumjeewantha.util.NoSuchTableException;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class TableCreation {

    public static void init(Connection connection, Class tableClass) throws NoSuchTableException, DuplicateIdException, NoSuchColumnException {
        Annotation table = tableClass.getAnnotation(Table.class);
        if (table == null) throw new NoSuchTableException("Add Table Class");
        String tableName = "";

        try {
            tableName = (String) table.annotationType().getDeclaredMethods()[0].invoke(table, (Object[]) null);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        Field[] fields = tableClass.getDeclaredFields();
        int columnCount = 0;
        int idCount = 0;
        List<String> columnNames = new ArrayList<>();
        String id = "";

        for (Field field : fields) {
            Column columnClass = field.getAnnotation(Column.class);

            if (columnClass != null) {
                columnNames.add(columnClass.value());
                columnCount++;
            }

            Id idClass = field.getAnnotation(Id.class);

            if (idClass != null) {
                id = columnClass.value();
                idCount++;
            }

        }

        if (columnCount < 1) throw new NoSuchColumnException("Column count must be at least one");

        if (idCount > 1) throw new DuplicateIdException("Id should not be duplicate");


    }
}
