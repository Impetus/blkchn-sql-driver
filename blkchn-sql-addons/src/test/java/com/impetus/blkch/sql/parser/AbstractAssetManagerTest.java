package com.impetus.blkch.sql.parser;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;

import java.util.Properties;

import junit.framework.TestCase;

import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.impetus.blkch.BlkchnException;
import com.impetus.blkch.sql.generated.BlkchnSqlLexer;
import com.impetus.blkch.sql.generated.BlkchnSqlParser;

@RunWith(PowerMockRunner.class)
@PrepareForTest({AbstractAssetManager.class})
public class AbstractAssetManagerTest extends TestCase {

    @Test
    public void testExecuteCreateAsset() throws Exception {
        AbstractAssetManager Am = new AbstractAssetManager() {
            @Override
            public Properties getDBProperties() {
                return null;
            }
        };
        String sqlCreate = "CREATE ASSET user_asset1"
                + " WITH STORAGE TYPE JSON "
                + "FIELDS DELIMITED BY ',' "
                + "RECORDS DELIMITED BY \"\\n\"";
        LogicalPlan plan = getLogicalPlan(sqlCreate);
        Am.logicalPlan = plan;
        String privateSaveDBMethod = "saveSchemaInDB";
        AbstractAssetManager spyObject = PowerMockito.spy(Am);
        PowerMockito.doNothing().when(spyObject,privateSaveDBMethod,anyString(), any());
        spyObject.executeCreateAsset();
    }

    @Test
    public void testExecuteCreateAssetWithFields() throws Exception {
        AbstractAssetManager Am = new AbstractAssetManager() {
            @Override
            public Properties getDBProperties() {
                return null;
            }
        };
        String sqlCreate = "CREATE ASSET user_asset1(a Integer, b String)"
                + " WITH STORAGE TYPE CSV "
                + "FIELDS DELIMITED BY ',' "
                + "RECORDS DELIMITED BY \"\\n\"";
        LogicalPlan plan = getLogicalPlan(sqlCreate);
        Am.logicalPlan = plan;
        String privateSaveDBMethod = "saveSchemaInDB";
        AbstractAssetManager spyObject = PowerMockito.spy(Am);
        PowerMockito.doNothing().when(spyObject,privateSaveDBMethod,anyString(), any());
        spyObject.executeCreateAsset();
    }


    @Test(expected = BlkchnException.class)
    public void testExecuteCreateAssetWithoutFieldsStorageCSV() throws Exception {
        AbstractAssetManager Am = new AbstractAssetManager() {
            @Override
            public Properties getDBProperties() {
                return null;
            }
        };
        String sqlCreate = "CREATE ASSET user_asset1"
                + " WITH STORAGE TYPE CSV "
                + "FIELDS DELIMITED BY ',' "
                + "RECORDS DELIMITED BY \"\\n\"";
        LogicalPlan plan = getLogicalPlan(sqlCreate);
        Am.logicalPlan = plan;
        String privateSaveDBMethod = "saveSchemaInDB";
        AbstractAssetManager spyObject = PowerMockito.spy(Am);
        PowerMockito.doNothing().when(spyObject,privateSaveDBMethod,anyString(), any());
        spyObject.executeCreateAsset();

    }

    @Test
    public void testDropAsset() throws Exception {
        AbstractAssetManager Am = new AbstractAssetManager() {
            @Override
            public Properties getDBProperties() {
                return null;
            }
        };
        String sqlCreate = "Drop ASSET user_asset1";
        LogicalPlan plan = getLogicalPlan(sqlCreate);
        Am.logicalPlan = plan;
        String privateDeleteDBMethod = "removeSchemaInDB";
        AbstractAssetManager spyObject = PowerMockito.spy(Am);
        PowerMockito.doNothing().when(spyObject,privateDeleteDBMethod,anyString());
        spyObject.executeDropAsset();
    }

    private LogicalPlan getLogicalPlan(String sqlText) {
        LogicalPlan logicalPlan = null;
        BlkchnSqlParser parser = getParser(sqlText);
        AbstractSyntaxTreeVisitor astBuilder = new BlockchainVisitor();
        logicalPlan = (LogicalPlan) astBuilder.visitSingleStatement(parser.singleStatement());
        return logicalPlan;
    }

    private BlkchnSqlParser getParser(String sqlText) {
        BlkchnSqlLexer lexer = new BlkchnSqlLexer(new CaseInsensitiveCharStream(sqlText));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        BlkchnSqlParser parser = new BlkchnSqlParser(tokens);
        return parser;
    }

}
