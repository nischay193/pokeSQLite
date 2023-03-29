package org.nischay.core.table_info;

import java.util.ArrayList;
import java.util.List;

public class TableDefinition {
    String table;
    List<Column> columns = new ArrayList<>();
    static TableDefinitionHelper helper = new TableDefinitionHelper();

    public String getTable() {
        return table;
    }

    public List<Column> getColumns() {
        return columns;
    }

    private void addColumn(Column column) {
        columns.add(column);
    }

    public static TableDefinition build(Class<?> classType) {
        return new Builder().withTable(helper.getTableNameFromClass(classType))
                .withColumns(helper.getColumnsFromClass(classType))
                .build();
    }

    public static class Builder {
        String table;
        List<Column> columns = new ArrayList<>();

        public Builder withTable(String table) {
            this.table = table;
            return this;
        }

        public Builder withColumn(Column column) {
            columns.add(column);
            return this;
        }

        public Builder withColumns(List<Column> columns) {
            this.columns.addAll(columns);
            return this;
        }

        public TableDefinition build() {
            var tableDef = new TableDefinition();
            tableDef.table = table;
            this.columns.forEach(tableDef::addColumn);
            return tableDef;
        }
    }
}
