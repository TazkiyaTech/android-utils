package com.thinkincode.utils.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.support.test.runner.AndroidJUnit4;

import com.thinkincode.utils.BaseTestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.AnyOf.anyOf;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
public class QueryPlanExplainerTest extends BaseTestCase {

    private QueryPlanExplainer queryPlanExplainer;
    private SomeDatabase someDatabase;

    @Before
    @Override
    public void setUp() {
        super.setUp();

        someDatabase = new SomeDatabase(getContext());
        someDatabase.createTable();
        someDatabase.createRecord(1, "1");
        someDatabase.createRecord(2, "2");
        someDatabase.createRecord(3, "3");

        queryPlanExplainer = new QueryPlanExplainer(someDatabase.getReadableDatabase());
    }

    @After
    @Override
    public void tearDown() {
        super.tearDown();
        someDatabase.dropTable();
        someDatabase.close();
    }

    @Test
    public void test_explainQueryPlanForSelectStatement_when_noWhereClauseProvided_1() {
        // When.
        QueryPlan result = queryPlanExplainer.explainQueryPlanForSqlStatement(
                "SELECT * FROM TableA"
        );

        // Then.
        assertThat(result.getDetail(), is(equalTo("SCAN TABLE TableA")));
    }

    @Test
    public void test_explainQueryPlanForSelectStatement_when_noWhereClauseProvided_2() {
        // When.
        QueryPlan result = queryPlanExplainer.explainQueryPlanForSelectStatement(
                "TableA",
                null,
                null,
                null,
                null,
                null,
                null,
                null
        );

        // Then.
        assertThat(result.getDetail(), is(equalTo("SCAN TABLE TableA")));
    }

    @Test
    public void test_explainQueryPlanForUpdateStatement_when_noWhereClauseProvided_1() {
        // When.
        QueryPlan result = queryPlanExplainer.explainQueryPlanForSqlStatement(
                "UPDATE TableA SET ColumnB = 1"
        );

        // Then.
        assertThat(result.getDetail(), is(equalTo("SCAN TABLE TableA")));
    }

    @Test
    public void test_explainQueryPlanForUpdateStatement_when_noWhereClauseProvided_2() {
        // Given.
        ContentValues contentValues = new ContentValues();
        contentValues.put("ColumnB", 1);

        // When.
        QueryPlan result = queryPlanExplainer.explainQueryPlanForUpdateStatement(
                "TableA",
                contentValues,
                null,
                null
        );

        // Then.
        assertThat(result.getDetail(), is(equalTo("SCAN TABLE TableA")));
    }

    @Test
    public void test_explainQueryPlanForSelectStatement_whereClauseProvidedForColumnA_1() {
        // When.
        QueryPlan result = queryPlanExplainer.explainQueryPlanForSqlStatement(
                "SELECT * FROM TableA WHERE ColumnA = 1"
        );

        // Then.
        assertThat(result.getDetail(), is(equalTo("SEARCH TABLE TableA USING INTEGER PRIMARY KEY (rowid=?)")));
    }

    @Test
    public void test_explainQueryPlanForSelectStatement_whereClauseProvidedForColumnA_2() {
        // When.
        QueryPlan result = queryPlanExplainer.explainQueryPlanForSelectStatement(
                "TableA",
                null,
                "ColumnA = ? ",
                new String[] { "1" },
                null,
                null,
                null,
                null
        );

        // Then.
        assertThat(result.getDetail(), is(equalTo("SEARCH TABLE TableA USING INTEGER PRIMARY KEY (rowid=?)")));
    }

    @Test
    public void test_explainQueryPlanForUpdateStatement_whereClauseProvidedForColumnA_1() {
        // When.
        QueryPlan result = queryPlanExplainer.explainQueryPlanForSqlStatement(
                "UPDATE TableA SET ColumnB = 1 WHERE ColumnA = 1"
        );

        // Then.
        assertThat(result.getDetail(), is(equalTo("SEARCH TABLE TableA USING INTEGER PRIMARY KEY (rowid=?)")));
    }

    @Test
    public void test_explainQueryPlanForUpdateStatement_whereClauseProvidedForColumnA_2() {
        // Given.
        ContentValues contentValues = new ContentValues();
        contentValues.put("ColumnB", 1);

        // When.
        QueryPlan result = queryPlanExplainer.explainQueryPlanForUpdateStatement(
                "TableA",
                contentValues,
                "ColumnA = ?",
                new String[] { "1" }
        );

        // Then.
        assertThat(result.getDetail(), is(equalTo("SEARCH TABLE TableA USING INTEGER PRIMARY KEY (rowid=?)")));
    }

    @Test
    public void test_explainQueryPlanForSelectStatement_whereClauseProvidedForColumnB_1() {
        // When.
        QueryPlan result = queryPlanExplainer.explainQueryPlanForSqlStatement(
                "SELECT * FROM TableA WHERE ColumnB = 1"
        );

        // Then.
        assertThat(result.getDetail(), anyOf(
                equalTo("SEARCH TABLE TableA USING INDEX ColumnB_on_TableA (ColumnB=?)"),
                equalTo("SEARCH TABLE TableA USING COVERING INDEX ColumnB_on_TableA (ColumnB=?)")));
    }

    @Test
    public void test_explainQueryPlanForSelectStatement_whereClauseProvidedForColumnB_2() {
        // When.
        QueryPlan result = queryPlanExplainer.explainQueryPlanForSelectStatement(
                "TableA",
                null,
                "ColumnB = ?",
                new String[] { "1" },
                null,
                null,
                null,
                null
        );

        // Then.
        assertThat(result.getDetail(), anyOf(
                equalTo("SEARCH TABLE TableA USING INDEX ColumnB_on_TableA (ColumnB=?)"),
                equalTo("SEARCH TABLE TableA USING COVERING INDEX ColumnB_on_TableA (ColumnB=?)")));
    }

    @Test
    public void test_explainQueryPlanForUpdateStatement_whereClauseProvidedForColumnB_1() {
        // When.
        QueryPlan result = queryPlanExplainer.explainQueryPlanForSqlStatement(
                "UPDATE TableA SET ColumnB = 1 WHERE ColumnB = 2"
        );

        // Then.
        assertThat(result.getDetail(), anyOf(
                equalTo("SEARCH TABLE TableA USING INDEX ColumnB_on_TableA (ColumnB=?)"),
                equalTo("SEARCH TABLE TableA USING COVERING INDEX ColumnB_on_TableA (ColumnB=?)")));
    }

    @Test
    public void test_explainQueryPlanForUpdateStatement_whereClauseProvidedForColumnB_2() {
        // Given.
        ContentValues contentValues = new ContentValues();
        contentValues.put("ColumnB", 1);

        // When.
        QueryPlan result = queryPlanExplainer.explainQueryPlanForUpdateStatement(
                "TableA",
                contentValues,
                "ColumnB = ?",
                new String[] { "1" }
        );

        // Then.
        assertThat(result.getDetail(), anyOf(
                equalTo("SEARCH TABLE TableA USING INDEX ColumnB_on_TableA (ColumnB=?)"),
                equalTo("SEARCH TABLE TableA USING COVERING INDEX ColumnB_on_TableA (ColumnB=?)")));
    }

    @Test
    public void test_explainQueryPlanForSelectStatement_whereClauseProvidedForColumnC_1() {
        // When.
        QueryPlan result = queryPlanExplainer.explainQueryPlanForSqlStatement(
                "SELECT * FROM TableA WHERE ColumnC = '1'"
        );

        // Then.
        assertThat(result.getDetail(), anyOf(
                equalTo("SEARCH TABLE TableA USING INDEX ColumnC_on_TableA (ColumnC=?)"),
                equalTo("SEARCH TABLE TableA USING COVERING INDEX ColumnC_on_TableA (ColumnC=?)")));
    }

    @Test
    public void test_explainQueryPlanForSelectStatement_whereClauseProvidedForColumnC_2() {
        // When.
        QueryPlan result = queryPlanExplainer.explainQueryPlanForSelectStatement(
                "TableA",
                null,
                "ColumnC = ? ",
                new String[] { "1" },
                null,
                null,
                null,
                null);

        // Then.
        assertThat(result.getDetail(), anyOf(
                equalTo("SEARCH TABLE TableA USING INDEX ColumnC_on_TableA (ColumnC=?)"),
                equalTo("SEARCH TABLE TableA USING COVERING INDEX ColumnC_on_TableA (ColumnC=?)")));
    }

    @Test
    public void test_explainQueryPlanForUpdateStatement_whereClauseProvidedForColumnC_1() {
        // When.
        QueryPlan result = queryPlanExplainer.explainQueryPlanForSqlStatement(
                "UPDATE TableA SET ColumnB = 1 WHERE ColumnC = '1'"
        );

        // Then.
        assertThat(result.getDetail(), anyOf(
                equalTo("SEARCH TABLE TableA USING INDEX ColumnC_on_TableA (ColumnC=?)"),
                equalTo("SEARCH TABLE TableA USING COVERING INDEX ColumnC_on_TableA (ColumnC=?)")));
    }

    @Test
    public void test_explainQueryPlanForUpdateStatement_whereClauseProvidedForColumnC_2() {
        // Given.
        ContentValues contentValues = new ContentValues();
        contentValues.put("ColumnB", 1);

        // When.
        QueryPlan result = queryPlanExplainer.explainQueryPlanForUpdateStatement(
                "TableA",
                contentValues,
                "ColumnC = ? ",
                new String[] { "1" });

        // Then.
        assertThat(result.getDetail(), anyOf(
                equalTo("SEARCH TABLE TableA USING INDEX ColumnC_on_TableA (ColumnC=?)"),
                equalTo("SEARCH TABLE TableA USING COVERING INDEX ColumnC_on_TableA (ColumnC=?)")));
    }

    @Test
    public void test_explainQueryPlanForSelectStatement_when_whereClauseProvidedForColumnBAndColumnC_1() {
        // When.
        QueryPlan result = queryPlanExplainer.explainQueryPlanForSqlStatement(
                "SELECT * FROM TableA WHERE ColumnB = 1 AND ColumnC = '1'"
        );

        // Then.
        assertThat(result.getDetail(), anyOf(
                equalTo("SEARCH TABLE TableA USING INDEX ColumnB_on_TableA (ColumnB=?)"),
                equalTo("SEARCH TABLE TableA USING COVERING INDEX ColumnB_on_TableA (ColumnB=?)")));
    }

    @Test
    public void test_explainQueryPlanForSelectStatement_when_whereClauseProvidedForColumnBAndColumnC_2() {
        // When.
        QueryPlan result = queryPlanExplainer.explainQueryPlanForSelectStatement(
                "TableA",
                null,
                "ColumnB = ? AND ColumnC = ? ",
                new String[] { "1", "1" },
                null,
                null,
                null,
                null);

        // Then.
        assertThat(result.getDetail(), anyOf(
                equalTo("SEARCH TABLE TableA USING INDEX ColumnB_on_TableA (ColumnB=?)"),
                equalTo("SEARCH TABLE TableA USING COVERING INDEX ColumnB_on_TableA (ColumnB=?)")));
    }

    @Test
    public void test_explainQueryPlanForUpdateStatement_when_whereClauseProvidedForColumnBAndColumnC_1() {
        // When.
        QueryPlan result = queryPlanExplainer.explainQueryPlanForSqlStatement(
                "UPDATE TableA SET ColumnB = 2 WHERE ColumnB = 1 AND ColumnC = '1'"
        );

        // Then.
        assertThat(result.getDetail(), anyOf(
                equalTo("SEARCH TABLE TableA USING INDEX ColumnB_on_TableA (ColumnB=?)"),
                equalTo("SEARCH TABLE TableA USING COVERING INDEX ColumnB_on_TableA (ColumnB=?)")));
    }

    @Test
    public void test_explainQueryPlanForUpdateStatement_when_whereClauseProvidedForColumnBAndColumnC_2() {
        // Given.
        ContentValues contentValues = new ContentValues();
        contentValues.put("ColumnB", 2);

        // When.
        QueryPlan result = queryPlanExplainer.explainQueryPlanForUpdateStatement(
                "TableA",
                contentValues,
                "ColumnB = ? AND ColumnC = ? ",
                new String[] { "1", "1" });

        // Then.
        assertThat(result.getDetail(), anyOf(
                equalTo("SEARCH TABLE TableA USING INDEX ColumnB_on_TableA (ColumnB=?)"),
                equalTo("SEARCH TABLE TableA USING COVERING INDEX ColumnB_on_TableA (ColumnB=?)")));
    }

    private static class SomeDatabase extends SQLiteOpenHelper {

        private static final String CREATE_TABLE_A =
                "CREATE TABLE TableA (" +
                        "ColumnA INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "ColumnB INTEGER NOT NULL, " +
                        "ColumnC TEXT NOT NULL);";

        private static final String DROP_TABLE_A =
                "DROP TABLE IF EXISTS TableA";

        private static final String CREATE_INDEX_COLUMN_B_FOR_TABLE_A =
                "CREATE INDEX ColumnB_on_TableA " +
                        " ON TableA" +
                        " (ColumnB ASC)";

        private static final String CREATE_INDEX_COLUMN_C_FOR_TABLE_A =
                "CREATE INDEX ColumnC_on_TableA " +
                        " ON TableA" +
                        " (ColumnC ASC)";

        private static final String DROP_INDEX_COLUMN_B_FOR_TABLE_A =
                "DROP INDEX IF EXISTS ColumnB_on_TableA";

        private static final String DROP_INDEX_COLUMN_C_FOR_TABLE_A =
                "DROP INDEX IF EXISTS ColumnC_on_TableA";

        /**
         * Constructor.
         */
        SomeDatabase(@NonNull Context context) {
            super(context, "SomeDatabase", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            // nothing to do
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // nothing to do
        }

        void createTable() {
            SQLiteDatabase database = getWritableDatabase();

            database.execSQL(CREATE_TABLE_A);
            database.execSQL(CREATE_INDEX_COLUMN_B_FOR_TABLE_A);
            database.execSQL(CREATE_INDEX_COLUMN_C_FOR_TABLE_A);
        }

        void dropTable() {
            SQLiteDatabase database = getWritableDatabase();
            database.execSQL(DROP_TABLE_A);
            database.execSQL(DROP_INDEX_COLUMN_B_FOR_TABLE_A);
            database.execSQL(DROP_INDEX_COLUMN_C_FOR_TABLE_A);
        }

        long createRecord(int columnBValue, String columnCValue) {
            SQLiteDatabase database = getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("ColumnB", columnBValue);
            contentValues.put("ColumnC", columnCValue);

            return database.insert("TableA", null, contentValues);
        }
    }
}