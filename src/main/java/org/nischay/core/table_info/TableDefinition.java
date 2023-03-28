package org.nischay.core.table_info;

import org.nischay.core.table_annotations.Table;

import java.util.ArrayList;
import java.util.List;

public class TableDefinition {
    String table;
    List<Column> columns = new ArrayList<>();

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
        return null;
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

        public TableDefinition build() {
            var tableDef = new TableDefinition();
            tableDef.table = table;
            this.columns.forEach(tableDef::addColumn);
            return tableDef;
        }
    }
}
