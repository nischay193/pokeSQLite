package core_spec.table_info_spec;

import org.junit.Test;
import org.nischay.core.table_info.Column;
import org.nischay.core.table_info.ColumnType;
import org.nischay.core.table_info.TableDefinition;
import org.nischay.core.table_info.TableDefinitionHelper;
import org.nischay.integration.model.Move;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TableDefinitionSpec {

    @Test
    public void testBuildDefinition() throws IOException {
        // arrange

        TableDefinition expectedTableDefinition
                = new TableDefinition.Builder()
                .withTable("move")
                .withColumn(new Column("id", ColumnType.INTEGER, true))
                .withColumn(new Column("name", ColumnType.STRING, false))
                .build();
        // act
        TableDefinition tableDef = TableDefinition.build(Move.class);

        // assert
        assertThat(tableDef.getTable(), is(expectedTableDefinition.getTable()));
        assertThat(tableDef.getColumns(), is(expectedTableDefinition.getColumns()));
    }
}
