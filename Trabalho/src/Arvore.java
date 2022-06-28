package aplicacao;

import java.util.ArrayList;
import java.util.List;

public class Arvore {
    private NoArv raiz;
    private int quantNos; //opcional

    public Arvore(){
        this.quantNos = 0;
        this.raiz = null;
    }

    public boolean eVazia (){
        return (this.raiz == null);
    }

    public NoArv getRaiz(){
        return this.raiz;
    }

    public int getQuantNos(){
        return this.quantNos;
    }

    //inserir um novo nó na arvore. Sempre insere em um atributo que seja igual a null
    public boolean inserir (Cliente elem){
        if (pesquisar (elem.getNomeCliente())){
            return false;
        }else{
            this.raiz = inserir (elem, this.raiz);
            this.quantNos++;
            return true;
        }
    }

    public NoArv inserir (Cliente elem, NoArv no){
        if (no == null){
            NoArv novo = new NoArv(elem);
            return novo;
        }else {
            if (elem.getNomeCliente().compareTo(no.getInfo().getNomeCliente()) < 0){
                no.setEsq(inserir(elem, no.getEsq()));
                return no;
            }else{
                no.setDir(inserir(elem, no.getDir()));
                return no;
            }
        }
    }

    //Pesquisa se um determinado valor está na árvore
    public boolean pesquisar (String nome){
        if (pesquisar (nome, this.raiz)!= null){
            return true;
        }else{
            return false;
        }
    }
    public NoArv pesquisar (String nome, NoArv no){
        if (no != null){
            if (nome.compareTo(no.getInfo().getNomeCliente()) < 0){
                no = pesquisar (nome, no.getEsq());
            }else{
                if (nome.compareTo(no.getInfo().getNomeCliente()) > 0){
                    no = pesquisar (nome, no.getDir());
                }
            }
        }
        return no;
    }

    public NoArv pesquisarCPF (String nome, NoArv no){
        if (no != null){
            if (nome.compareTo(no.getInfo().getCPF()) < 0){
                no = pesquisar (nome, no.getEsq());
            }else{
                if (nome.compareTo(no.getInfo().getCPF()) > 0){
                    no = pesquisar (nome, no.getDir());
                }
            }
        }
        return no;
    }

    //remove um determinado nó procurando pela chave. O nó pode estar em qualquer
    //posição na árvore
    public boolean remover (String nome){
        if (pesquisar (nome, this.raiz) != null){
            this.raiz = remover (nome, this.raiz);
            this.quantNos--;
            return true;
        }
        else {
            return false;
        }
    }
    public NoArv remover (String nome, NoArv arv){
        if (nome.compareTo(arv.getInfo().getNomeCliente()) < 0){
            arv.setEsq(remover (nome, arv.getEsq()));
        }else{
            if (nome.compareTo(arv.getInfo().getNomeCliente()) > 0){
                arv.setDir(remover (nome, arv.getDir()));
            }else{
                if (arv.getDir()== null){
                    return arv.getEsq();
                }else{
                    if (arv.getEsq() == null){
                        return arv.getDir();
                    }else{
                        arv.setEsq(Arrumar (arv, arv.getEsq()));
                    }
                }
            }
        }
        return arv;
    }
    private NoArv Arrumar (NoArv arv, NoArv maior){
        if (maior.getDir() != null){
            maior.setDir(Arrumar (arv, maior.getDir()));
        }
        else{
            arv.setInfo(maior.getInfo());
            maior = maior.getEsq();
        }
        return maior;
    }
    //caminhamento central
    public Cliente [] CamCentral (){
        int []n= new int[1];
        n[0]=0;
        Cliente [] vet = new Cliente[this.quantNos];
        return (FazCamCentral (this.raiz, vet, n));
    }
    private Cliente [] FazCamCentral (NoArv arv, Cliente [] vet, int []n){
        if (arv != null) {
            vet = FazCamCentral (arv.getEsq(),vet,n);
            vet[n[0]] = arv.getInfo();
            n[0]++;
            vet = FazCamCentral (arv.getDir(),vet,n);
        }
        return vet;
    }

    // Caminhamento para String
    public String [] CamCentralString (){
        int []n= new int[1];
        n[0] = 0;
        String [] vet = new String[this.quantNos];
        return (FazCamCentral (this.raiz, vet, n));
    }

    private String[] FazCamCentral (NoArv arv, String[] vet, int []n){
        if (arv != null) {
            vet = FazCamCentral (arv.getEsq(), vet, n);
            vet[n[0]] = arv.getInfo().getNomeCliente();
            n[0]++;
            vet = FazCamCentral (arv.getDir(), vet, n);
        }
        return vet;
    }
    // Caminhamento para Inteiros

    public double [] CamCentralInt (){
        int []n= new int[1];
        n[0] = 0;
        double [] vet = new double[this.quantNos];
        return (FazCamCentral (this.raiz, vet, n));
    }

    private double [] FazCamCentral (NoArv arv, double [] vet, int []n){
        double saldoTotal = 0.0;
        double resultado;
        double[] vetResultado = new double[quantNos];
        if (arv != null) {
            vet = FazCamCentral (arv.getEsq(),vet,n);
            vet[n[0]] = arv.getInfo().getSaldoCliente();
            n[0]++;
            vet = FazCamCentral (arv.getDir(),vet,n);
            for(int i = 0; i < quantNos; i++) {
                saldoTotal += vet[0];
            }
            resultado = saldoTotal / quantNos;
            vetResultado[0] = resultado;
        }
        return vetResultado;
    }

    //caminhamento pré-fixado
    public Cliente [] CamPreFixado (){
        int []n= new int[1];
        n[0]=0;
        Cliente [] vet = new Cliente[this.quantNos];
        return (FazCamPreFixado (this.raiz, vet, n));
    }
    private Cliente [] FazCamPreFixado (NoArv arv, Cliente [] vet, int []n){
        if (arv != null) {
            vet[n[0]] = arv.getInfo();
            n[0]++;
            vet = FazCamPreFixado (arv.getEsq(), vet,n);
            vet = FazCamPreFixado (arv.getDir(), vet,n);
        }
        return vet;
    }
    //caminhamento pós-fixado
    public Cliente [] CamPosFixado (){
        int []n= new int[1];
        n[0]=0;
        Cliente [] vet = new Cliente[this.quantNos];
        return (FazCamPosFixado (this.raiz, vet, n));
    }
    private Cliente [] FazCamPosFixado (NoArv arv, Cliente[] vet, int []n){
        if (arv != null) {
            vet = FazCamPosFixado (arv.getEsq(), vet,n);
            vet = FazCamPosFixado (arv.getDir(), vet,n);
            vet[n[0]] = arv.getInfo();
            n[0]++;
        }
        return vet;
    }

}
