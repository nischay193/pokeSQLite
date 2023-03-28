package org.nischay.core.table_info;

import org.nischay.core.table_annotations.Table;

public class TableDefinitionHelper {

    public String getTableNameFromClass(Class<?> classType) {
        return classType.getAnnotation(Table.class).value();
    }
}
