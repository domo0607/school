
public class TeaSet {

	public static void main(String[] args) {
		Teapot tp = new Teapot();
		Cups[] cup = new Cups[4];
		
		tp.setVolume(1500);
		
		for(int i = 0; i < cup.length ; i++) {
			cup[ i ] = new Cups();
			cup[ i ].wash();
			cup[ i ].reset();
			cup[ i ].setcapacity(400);
			
		}
		
		for(int i = 0; i < cup.length ; i++) {
			if (tp.getsize()> cup[ i ].getcapacity()) {
				cup[ i ].setVolume(cup[ i ].getcapacity());
				tp.setVolume(tp.getsize() - cup[i].getsize());
			}
			else if (tp.getsize()<cup[ i ].getcapacity()) {
				cup[ i ].setVolume(tp.getsize());
				tp.setVolume(tp.getsize() - cup[i].getsize());
			}
			
			
			System.out.println("The amount of tea in cup " + i + " is " + cup[ i ].getsize());
			System.out.println("the amount of tea left in the teapot is " + tp.getsize());
		}
		

	}

}
