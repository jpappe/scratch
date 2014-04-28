package com.jpappe.scratch.trigtriangletrouble.model;


public class Triangle {

	private double sideA;
	private double sideB;
	private double sideC;

	private double angleA;
	private double angleB;
	private double angleC;

	/**
	 * These are the possible inputs for the triangle; edges are lowercase, angles are uppercase
	 * 
	 * @author jacob
	 * 
	 */
	public enum Input {
		a("a"),
		b("b"),
		c("c"),
		A("A"),
		B("B"),
		C("C");
		
		private final String val;
		
		private Input(String val) {
			this.val = val;
		}
		
		/**
		 * get the Input that matches the given string
		 * 
		 * @param s
		 * @return Input
		 */
		public static Input forInputString( String s ) {
			for ( Input i : Input.values() ) {
				if ( i.val.equals( s ) ) {
					return i;
				}
			}
			throw new IllegalArgumentException( "Unknown input: " + s );
		}
	}
	
	/**
	 * set a field based on user input
	 * 
	 * @param field
	 * @param value
	 */
	public void setField( String field, double value ) {
		Input i = Input.forInputString( field );
		switch ( i ) {
			case a:
				this.setSideA( value );
				break;
			case b:
				this.setSideB( value );
				break;
			case c:
				this.setSideC( value );
				break;
			case A:
				this.setAngleA( value );
				break;
			case B:
				this.setAngleB( value );
				break;
			case C:
				this.setAngleC( value );
				break;
			default: // shouldn't ever get here
		}
	}

	public double getSideA() {
		return sideA;
	}

	public void setSideA( double sideA ) {
		this.sideA = sideA;
	}

	public double getSideB() {
		return sideB;
	}

	public void setSideB( double sideB ) {
		this.sideB = sideB;
	}

	public double getSideC() {
		return sideC;
	}

	public void setSideC( double sideC ) {
		this.sideC = sideC;
	}

	public double getAngleA() {
		return angleA;
	}

	public void setAngleA( double angleA ) {
		this.angleA = angleA;
	}

	public double getAngleB() {
		return angleB;
	}

	public void setAngleB( double angleB ) {
		this.angleB = angleB;
	}

	public double getAngleC() {
		return angleC;
	}

	public void setAngleC( double angleC ) {
		this.angleC = angleC;
	}

	@Override
	public String toString() {
		StringBuffer out = new StringBuffer();
		out.append( "a=" ).append( this.getSideA() ).append( "\n" );
		out.append( "b=" ).append( this.getSideB() ).append( "\n" );
		out.append( "c=" ).append( this.getSideC() ).append( "\n" );
		out.append( "A=" ).append( this.getAngleA() ).append( "\n" );
		out.append( "B=" ).append( this.getAngleB() ).append( "\n" );
		out.append( "C=" ).append( this.getAngleC() ).append( "\n" );

		return out.toString();
	}

}
