package practica1;


public class Test {

	public static void main(String[] args) {	
		
		Estudiante  [] ests = new Estudiante [2];
		for (int i = 0; i<ests.length; i++)
			ests[i] = new Estudiante();
		
		ests[0].setNombre("Juan");
		ests[0].setApellido("Perez");
		ests[1].setNombre("Martin");
		ests[1].setApellido("Roto");
		
		Profesor  [] profs = new Profesor [3];	
		for (int j = 0; j<profs.length; j++)
			profs[j]= new Profesor();
		
		profs[0].setNombre("Oscar");
		profs[0].setApellido("Romero");	
		profs[1].setNombre("Julio");
		profs[1].setApellido("Roca");	
		profs[2].setNombre("Martin");
		profs[2].setApellido("Lopez");	
		
		for (int i = 0; i<ests.length; i++)
			System.out.println(ests[i].tusDatos());
		

		for (int j = 0; j<profs.length; j++)
			System.out.println(profs[j].tusDatos());
	}

}
