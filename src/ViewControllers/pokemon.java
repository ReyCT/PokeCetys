package ViewControllers;

public class pokemon {

    private Motor motor;
    private String tipo;
    private String nombre;
    private habilidad habilidad1;
    private habilidad habilidad2;
    private habilidad habilidad3;
    private habilidad habilidad4;
    private int tamaño;
    private int nivel;
    private pokemon evolucion;
    private double vida;
    private double exp;

    public pokemon(String tipo, String nombre, habilidad habilidad1,habilidad habilidad2, habilidad habilidad3, habilidad habilidad4, int tamaño, int nivel, pokemon evolucion, double vida, double exp){
        this.tipo = tipo;
        this.nombre = nombre;
        this.habilidad1 = habilidad1;
        this.habilidad2 = habilidad2;
        this.habilidad3 = habilidad3;
        this.habilidad4 = habilidad4;
        this.tamaño = tamaño;
        this.nivel = nivel*3;
        this.evolucion = evolucion;
        this.vida = vida*10;
        this.exp = exp=0;
    }
    public pokemon(){

    }
    public pokemon returnCopyPokemon() {
        pokemon copy = new pokemon();
        copy.setTipo(this.tipo);
        copy.setNombre(this.nombre);
        copy.setHabilidad1(this.habilidad1);
        copy.setHabilidad2(this.habilidad2);
        copy.setHabilidad3(this.habilidad3);
        copy.setHabilidad4(this.habilidad4);
        copy.setTamaño(this.tamaño);
        copy.setNivel(this.nivel);
        copy.setEvolucion(this.evolucion);
        copy.setVida(this.vida);
        copy.setExp(this.exp);
        return copy;
    }
    public void setAllData(pokemon newPokemon) {
        this.tipo = newPokemon.getTipo();
        this.nombre = newPokemon.getNombre();
        this.habilidad1 = newPokemon.getHabilidad1();
        this.habilidad2 = newPokemon.getHabilidad2();
        this.habilidad3 = newPokemon.getHabilidad3();
        this.habilidad4 = newPokemon.getHabilidad4();
        this.tamaño = newPokemon.getTamaño();
        this.nivel = newPokemon.getNivel();
        this.evolucion = newPokemon.getEvolucion();
        this.vida = newPokemon.getVida();
        this.exp = newPokemon.getExp();
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return nombre;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public String getTipo(){
        return tipo;
    }
    public void setHabilidad1(habilidad habilidad1){
        this.habilidad1 = habilidad1;
    }
    public void setHabilidad2(habilidad habilidad2){
        this.habilidad2 = habilidad2;
    }
    public void setHabilidad3(habilidad habilidad3){
        this.habilidad3 = habilidad3;
    }
    public void setHabilidad4(habilidad habilidad4){
        this.habilidad4 = habilidad4;
    }
    public habilidad getHabilidad1(){
        return habilidad1;
    }
    public habilidad getHabilidad2(){
        return habilidad2;
    }
    public habilidad getHabilidad3(){
        return habilidad3;
    }
    public habilidad getHabilidad4(){
        return habilidad4;
    }
    public void setTamaño(int tamaño){
        this.tamaño = tamaño;
    }
    public int getTamaño(){
        return tamaño;
    }
    public int getNivel(){
        return nivel;
    }
    public void setNivel(int nivel){
        this.nivel = nivel;
    }
    public void setEvolucion(pokemon evolucion){
        this.evolucion = evolucion;
    }
    public pokemon getEvolucion(){
        return evolucion;
    }
    public double getVida(){
        return vida;
    }
    public void setVida(double vida){
        this.vida = vida;
    }
    public double getExp(){
        return exp;
    }
    public void setExp(double exp){
        this.exp = exp;
    }
}
