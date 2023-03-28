package org.nischay.integration.model;

import org.nischay.core.table_annotations.PrimaryKey;
import org.nischay.core.table_annotations.Table;

@Table("move")
public class Move {
    @PrimaryKey
    public Integer id;

    public String name;
}
