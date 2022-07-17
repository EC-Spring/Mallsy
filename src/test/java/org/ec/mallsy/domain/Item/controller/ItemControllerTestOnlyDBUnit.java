package org.ec.mallsy.domain.Item.controller;

import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.mysql.MySqlConnection;
import org.dbunit.operation.DatabaseOperation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
public class ItemControllerTestOnlyDBUnit {

    @Autowired
    private DataSource dataSource;

    private Connection connection;
    private IDatabaseConnection iDatabaseConnection;
    private IDataSet flatXmlDataSet;

    @BeforeEach
    void setUp() throws Exception {
        connection = dataSource.getConnection();
        iDatabaseConnection = new MySqlConnection(connection, "dbunit");

        InputStream is = this.getClass().getResourceAsStream("item.xml");
        flatXmlDataSet = new FlatXmlDataSetBuilder().build(is);
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, flatXmlDataSet);
    }

    @AfterEach
    void tearDown() throws Exception {
        DatabaseOperation.DELETE_ALL.execute(iDatabaseConnection, flatXmlDataSet);
        if (connection != null)
            connection.close();
        if (iDatabaseConnection != null)
                iDatabaseConnection.close();
    }
}
