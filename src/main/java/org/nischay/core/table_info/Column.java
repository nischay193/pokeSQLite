package org.nischay.core.table_info;

public class Column {
    String name;
    ColumnType columnType;
    boolean isPrimaryKey;

    public Column(String name, ColumnType columnType, boolean isPrimaryKey) {
        this.name = name;
        this.columnType = columnType;
        this.isPrimaryKey = isPrimaryKey;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Column)) return false;
        Column columnDef = (Column) obj;
        return this.name.equals(columnDef.name) && this.columnType == columnDef.columnType && this.isPrimaryKey == columnDef.isPrimaryKey;
    }
}
