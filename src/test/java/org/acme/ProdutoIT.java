package org.acme;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.inject.Inject;

import com.github.database.rider.cdi.api.DBRider;
import com.github.database.rider.core.api.dataset.DataSet;

import org.junit.ClassRule;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.MySQLContainer;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@DBRider
public class ProdutoIT {

    @ClassRule
    private static MySQLContainer<?> MYSQL = new MySQLContainer<>("mysql:latest");

    @BeforeAll
    private static void setup() {
        MYSQL.start();

        System.setProperty("quarkus.datasource.url", MYSQL.getJdbcUrl());
        System.setProperty("quarkus.datasource.username", MYSQL.getUsername());
        System.setProperty("quarkus.datasource.password", MYSQL.getPassword());

    }

    @AfterAll
    private static void shutdown() {
        if (MYSQL != null) {
            MYSQL.stop();
        }
    }

    @Inject
    ProdutoRepository produtoReporitory;

    @Test
    @DataSet(value = "produtos.yml")
    public void teste() {
        assertEquals(1, produtoReporitory.count());
    }
}