package org.nischay;

import org.nischay.core.table_annotations.Table;
import org.nischay.integration.model.Move;

public class Test {
    public static void main(String[] args) {
        Table table = Move.class.getAnnotation(Table.class);
    }
}
