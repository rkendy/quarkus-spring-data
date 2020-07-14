package org.acme;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class ProdutoTest {

    @Inject
    ProdutoRepository produtoReporitory;

    @Test
    public void teste() {
        assertEquals(4, produtoReporitory.count());
    }

}