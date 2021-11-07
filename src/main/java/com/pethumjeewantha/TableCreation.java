package com.pethumjeewantha;

import com.pethumjeewantha.annotations.Table;
import com.pethumjeewantha.util.NoSuchTableException;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;

public class TableCreation {

    public static void init(Connection connection, Class tableClass) throws NoSuchTableException {
        Annotation annotation = tableClass.getAnnotation(Table.class);
        if (annotation == null) throw new NoSuchTableException("Add Table Class");

        try {
            Object value = annotation.annotationType().getDeclaredMethods()[0].invoke(annotation, (Object[]) null);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        Field[] fields = tableClass.getDeclaredFields();
        int columnCount = 0;

        /*for (Field field : fields) {
            Table table = field.getAnnotation(Table.class);

            if (table == null) throw new NoSuchTableException("There is no table annotation");
            String tableName = table.value();

            Column column = field.getAnnotation(Column.class);

            if (column != null){
                String columnName = column.value();
                field
            }

        }*/
    }
}
