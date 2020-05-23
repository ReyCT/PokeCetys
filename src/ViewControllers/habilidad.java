package ViewControllers;

public class habilidad {
    private String nombre;
    private String tipo;
    private int damage;

    public habilidad(){

    }
    public habilidad(String nombre, String tipo, int damage){
        this.nombre = nombre;
        this.tipo = tipo;
        this.damage = damage;

    }
    public void setDamage(int damage){
        this.damage = damage;
    }
    public int getDamage(){
        return damage;
    }
    public String getNombre(){
        return nombre;
    }
}
