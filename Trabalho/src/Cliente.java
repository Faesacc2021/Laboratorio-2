package aplicacao;

public class Cliente {
    private String nome;
    private String CPF;
    private Long telefone;
    private String emailCliente;
    private Double saldoCliente;

    public Cliente (){
    }

    public Cliente(String nome, String CPF, Long telefone, String emailCliente) {
        this.nome = nome;
        this.CPF = CPF;
        this.telefone = telefone;
        this.emailCliente = emailCliente;
        this.saldoCliente = 0.0;
    }

    public Cliente(String nomeCliente, String CPF, Long telefone, String emailCliente, Double saldoCliente) {
        this.nome = nomeCliente;
        this.CPF = CPF;
        this.telefone = telefone;
        this.emailCliente = emailCliente;
        this.saldoCliente = saldoCliente;
    }

    public String getNomeCliente() {
        return nome;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nome = nomeCliente;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public double getSaldoCliente() {
        return saldoCliente;
    }

    public void setSaldoCliente(Double saldoCliente) {
        this.saldoCliente = saldoCliente;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome do cliente: ");
        sb.append(nome + "\n");
        sb.append("CPF: ");
        sb.append(CPF + "\n");
        sb.append("Telefone: ");
        sb.append(telefone + "\n");
        sb.append("Email: ");
        sb.append(emailCliente + "\n");
        sb.append("Saldo do Cliente: R$");
        sb.append(String.format("%.2f", saldoCliente) + "\n\n");
        return sb.toString();
    }
}
