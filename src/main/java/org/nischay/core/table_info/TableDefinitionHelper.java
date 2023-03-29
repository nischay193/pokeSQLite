package org.nischay.core.table_info;

import org.nischay.core.table_annotations.PrimaryKey;
import org.nischay.core.table_annotations.Table;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TableDefinitionHelper {

    public String getTableNameFromClass(Class<?> classType) {
        return classType.getAnnotation(Table.class).value();
    }

    public List<Column> getColumnsFromClass(Class<?> classType) {
        return Arrays.stream(classType.getFields())
                .map(TableDefinitionHelper::generateColumnFromField)
                .collect(Collectors.toList());
    }

    private static Column generateColumnFromField(Field field) {
        return new Column(
                field.getName(),
                getColumnTypeForJavaType(field.getType()),
                isPrimaryKey(field)
        );
    }

    private static ColumnType getColumnTypeForJavaType(Class<?> classType) {
        switch (classType.getSimpleName()) {
            case "Integer":
                return ColumnType.INTEGER;
            case "String":
                return ColumnType.STRING;
            case "Boolean":
                return ColumnType.BOOLEAN;
            case "Double":
                return ColumnType.DOUBLE;
            case "Object":
                return ColumnType.OBJECT;
            default:
                return ColumnType.UNKNOWN;
        }
    }


    private static boolean isPrimaryKey(Field field) {
        return field.getAnnotation(PrimaryKey.class) != null;
    }
}
