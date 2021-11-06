package com.pethumjeewantha;

import com.pethumjeewantha.annotations.Table;
import com.pethumjeewantha.util.NoSuchTableException;

import java.lang.reflect.Field;
import java.sql.Connection;

public class TableCreation {

    public static void init(Connection connection, Class table) throws NoSuchTableException {
        Field[] fields = table.getDeclaredFields();

        for (Field field : fields) {
            Table tableName = field.getAnnotation(Table.class);

            if (tableName == null) throw new NoSuchTableException("There is no table annotation");


        }
    }
}
