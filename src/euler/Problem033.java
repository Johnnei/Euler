package euler;

public class Problem033 extends ProblemBase {
	
	private int denomenator = 0;
	
	public Problem033() {
		super(33, "Digit Cancelling Fractions");
	}

	@Override
	protected String getSolution() {
		return Integer.toString(denomenator);
	}

	@Override
	protected void solve() {
		float product = calculateProblemProduct();
		// Remove float errors
		product = Float.parseFloat(Float.toString(product).substring(0, 4));
		
		// Find division
		int numerator = 0;
		int denomenator = 1;
		float fraction = 0;
		
		while (fraction != product) {
			if (fraction < product) {
				numerator++;
			} else {
				denomenator++;
			}
			
			fraction = numerator / (float) denomenator;
		}
		
		System.out.println(String.format("%s / %s = %s", numerator, denomenator, fraction));
		
		// Simplify terms
		for (int i = 2; i < denomenator; i++) {
			if (numerator % i != 0 && denomenator % i != 0) {
				continue;
			}
			
			int a = numerator / i;
			int b = denomenator / i;
			float f = a / (float )b;
			
			if (f == fraction) {
				System.out.println(String.format("Simplified to %s/%s = %s", a, b, f));
				numerator = a;
				denomenator = b;
			}
		}
		
		this.denomenator = denomenator;
	}
	
	private float calculateProblemProduct() {
		float product = 1;
		
		for (int i = 10; i < 100; i++) {
			for (int j = 10; j < 100; j++) {
				float fraction = i / (float) j;
				if (fraction >= 1) {
					continue;
				}
				
				String a = Integer.toString(i);
				String b = Integer.toString(j);
				
				char duplicateChar = 0;
				for (char c : a.toCharArray()) {
					for (char d : b.toCharArray()) {
						if (c == d) {
							duplicateChar = c;
							break;
						}
					}
					
					if (duplicateChar != 0)
						break;
				}
				
				if (duplicateChar == 0 || duplicateChar == '0') {
					continue;
				}
				
				String a2 = a.replace(Character.toString(duplicateChar), "");
				String b2 = b.replace(Character.toString(duplicateChar), "");
				
				if (a2.length() == 0 || b2.length() == 0) {
					continue;
				}
				
				int i2 = Integer.parseInt(a2);
				int j2 = Integer.parseInt(b2);
				
				if (i2 == 0 || j2 == 0) {
					continue;
				}
				
				float fraction2 = i2 / (float) j2;
				
				if (fraction != fraction2) {
					continue;
				}
				
				System.out.println(String.format("%s/%s = %s -> %s/%s = %s", a, b, fraction, a2, b2, fraction2));
				product *= fraction;
			}
		}
		
		return product;
	}

}
