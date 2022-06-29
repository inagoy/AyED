package JuegoPrincesa;

public class Personaje {
	 private String nombre;
	 private String tipo;
	 
	 public Personaje(String nombre, String tipo) {
		 this.nombre = nombre;
		 this.tipo = tipo;
	 }
	 public String getNombre() {
		 return nombre;
	 }
	 public void setNombre(String nombre) {
		 this.nombre = nombre;
	 }
	 public boolean esDragon(){
		 return this.tipo.equals("Dragon");
	 }
	 public boolean esPrincesa(){
		 return this.tipo.equals("Princesa");
	 }
	 public String toString() {
		 return this.tipo + this.nombre;
	 }
	}