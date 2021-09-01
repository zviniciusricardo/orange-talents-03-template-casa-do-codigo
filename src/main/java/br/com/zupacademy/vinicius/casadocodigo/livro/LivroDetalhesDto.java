package br.com.zupacademy.vinicius.casadocodigo.livro;

public class LivroViewDetalhes {

    private Livro livro;
    private Float precoEbook;
    private Float precoImpresso;
    private Float precoEbookMaisImpresso;

    public LivroViewDetalhes(LivroViewForm viewForm) {
        this.livro = viewForm.getLivro();
        this.precoEbook = this.livro.getPreco();
        this.precoImpresso = calculaPrecoImpresso(1.8F);
        this.precoEbookMaisImpresso = calculaPrecoEbookMaisImpresso(.15F);
    }

    private Float calculaPrecoImpresso(Float addCustos) {
        return this.precoImpresso = this.precoEbook * addCustos;
    }

    private Float calculaPrecoEbookMaisImpresso(Float desconto) {
        float total = (this.precoEbook + this.precoImpresso);
        return this.precoEbookMaisImpresso = total - (total * desconto);
    }

    public Livro getLivro() {
        return livro;
    }

    public Float getPrecoEbook() {
        return precoEbook;
    }

    public Float getPrecoImpresso() {
        return precoImpresso;
    }

    public Float getPrecoEbookMaisImpresso() {
        return precoEbookMaisImpresso;
    }
}
