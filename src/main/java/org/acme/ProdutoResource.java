package org.acme;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {

    @Inject
    private ProdutoRepository produtoRepository;

    @GET
    public List<Produto> getAll() {
        List<Produto> result = new ArrayList<>();
        produtoRepository.findAll().forEach(result::add);
        return result;
    }

    @GET
    @Path("{id}")
    public Produto get(@PathParam("id") Long id) {
        Optional<Produto> produtoOp = produtoRepository.findById(id);
        if (produtoOp.isPresent()) {
            return produtoOp.get();
        } else {
            throw new NotFoundException();
        }
    }

    @POST
    public void salvaProduto(ProdutoDTO produtoDto) {
        Produto produto = new Produto();
        produto.setNome(produtoDto.nome);
        produto.setValor(produtoDto.valor);
        produtoRepository.save(produto);
    }

    @PUT
    @Path("{id}")
    @Transactional
    public Produto atualizarProduto(@PathParam("id") Long id, ProdutoDTO produtoDto) {
        Optional<Produto> produtoOp = produtoRepository.findById(id);
        if (produtoOp.isPresent()) {
            Produto produto = produtoOp.get();
            produto.setNome(produtoDto.nome);
            produto.setValor(produtoDto.valor);
            Produto x = produtoRepository.save(produto);
            return x;

        } else {
            throw new NotFoundException();
        }
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void removeProduto(@PathParam("id") Long id) {
        Optional<Produto> produtoOp = produtoRepository.findById(id);
        produtoOp.ifPresentOrElse((e) -> produtoRepository.delete(e), () -> {
            throw new NotFoundException();
        });
    }
}