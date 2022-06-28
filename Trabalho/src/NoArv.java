public class NoArv {
    private Cliente info; // o tipo Item est� declarado no cap�tulo 1
    private NoArv esq, dir;
    public NoArv(Cliente elem){
        this.info = elem;
        this.esq = null;
        this.dir = null;
    }
    public NoArv getEsq(){
        return this.esq;
    }
    public NoArv getDir(){
        return this.dir;
    }
    public Cliente getInfo(){
        return this.info;
    }
    public void setEsq(NoArv no){
        this.esq = no;
    }
    public void setDir(NoArv no){
        this.dir = no;
    }
    public void setInfo(Cliente elem){
        this.info = elem;
    }
}
