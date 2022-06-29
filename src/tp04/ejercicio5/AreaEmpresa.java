package tp04.ejercicio5;

public class AreaEmpresa {
	private String area;
	private int tardanza;

	public AreaEmpresa(String area, int tardanza) {
		this.area = area;
		this.tardanza = tardanza;
	}
	
	public String getArea() {
		return this.area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
	public int getTardanza() {
		return this.tardanza;
	}
	public void setTardanza(int tardanza) {
		this.tardanza = tardanza;
	}
}
