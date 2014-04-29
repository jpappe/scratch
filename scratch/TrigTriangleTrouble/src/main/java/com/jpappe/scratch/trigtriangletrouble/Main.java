
package com.jpappe.scratch.trigtriangletrouble;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jpappe.scratch.trigtriangletrouble.model.Triangle;

public class Main {

	private Triangle triangle;

	public Main() {
		this.triangle = new Triangle();
	}

	/**
	 * Parse the given clues and assign them to the triangle
	 * 
	 * @param clues
	 */
	public void parseClues( List<String> clues ) {
		String[] tokens = null;
		for ( String clue : clues ) {
			tokens = clue.split( "=" );
			triangle.setField( tokens[0], Double.parseDouble( tokens[1] ) );
		}
	}

	/**
	 * based on what we know of the triangle, figure out the rest
	 */
	public void inferRemaining() {
		// we always know C is 90
		triangle.setAngleC( 90 );

		// try to figure out a
		if ( triangle.getSideB() != 0 && triangle.getSideC() != 0 ) {
			System.out.println( "Solving for a using Pythagorus" );
			triangle.setSideA( Math.sqrt( Math.pow( triangle.getSideC(), 2 ) - Math.pow( triangle.getSideB(), 2 ) ) );
		}
		else if ( triangle.getAngleA() != 0 && triangle.getSideC() != 0 ) {
			System.out.println( "Solving for a using sin(A)" );
			triangle.setSideA( Math.sin( triangle.getAngleARads() ) * triangle.getSideC() );
		}
		else if ( triangle.getAngleB() != 0 && triangle.getSideC() != 0 ) {
			System.out.println( "Solving for a using cos(B)" );
			triangle.setSideA( Math.cos( triangle.getAngleBRads() ) * triangle.getSideC() );
		}
		else if ( triangle.getAngleA() != 0 && triangle.getSideB() != 0 ) {
			System.out.println( "Solving for a using tan(A)" );
			triangle.setSideA( Math.tan( triangle.getAngleARads() ) * triangle.getSideB() );
		}

		// same thing but for b
		if ( triangle.getSideA() != 0 && triangle.getSideC() != 0 ) {
			System.out.println( "Solving for b using Pythagorus" );
			triangle.setSideB( Math.sqrt( Math.pow( triangle.getSideC(), 2 ) - Math.pow( triangle.getSideA(), 2 ) ) );
		}
		else if ( triangle.getAngleB() != 0 && triangle.getSideC() != 0 ) {
			System.out.println( "Solving for b using sin(B)" );
			triangle.setSideB( Math.sin( triangle.getAngleBRads() ) * triangle.getSideC() );
		}
		else if ( triangle.getAngleA() != 0 && triangle.getSideC() != 0 ) {
			System.out.println( "Solving for b using cos(A)" );
			triangle.setSideB( Math.cos( triangle.getAngleARads() ) * triangle.getSideC() );
		}
		else if ( triangle.getAngleB() != 0 && triangle.getSideA() != 0 ) {
			System.out.println( "Solving for b using tan(B)" );
			triangle.setSideB( Math.tan( triangle.getAngleBRads() ) * triangle.getSideA() );
		}

		// same thing but for c
		if ( triangle.getSideA() != 0 && triangle.getSideB() != 0 ) {
			System.out.println( "Solving for c using Pythagorus" );
			triangle.setSideC( Math.sqrt( Math.pow( triangle.getSideA(), 2 ) + Math.pow( triangle.getSideB(), 2 ) ) );
		}
		else if ( triangle.getAngleA() != 0 && triangle.getSideA() != 0 ) {
			System.out.println( "Solving for c using sin(A)" );
			triangle.setSideC( triangle.getSideA() / Math.sin( triangle.getAngleARads() ) );
		}
		else if ( triangle.getSideA() != 0 && triangle.getAngleB() != 0 ) {
			System.out.println( "Solving for c using cos(B)" );
			triangle.setSideC( triangle.getSideA() / Math.cos( triangle.getAngleBRads() ) );
		}
		else if ( triangle.getSideB() != 0 && triangle.getAngleB() != 0 ) {
			System.out.println( "Solving for c using sin(B)" );
			triangle.setSideC( triangle.getSideB() / Math.sin( triangle.getAngleBRads() ) );
		}
		else if ( triangle.getSideB() != 0 && triangle.getAngleA() != 0 ) {
			System.out.println( "Solving for c using cos(A)" );
			triangle.setSideC( triangle.getSideB() / Math.cos( triangle.getAngleARads() ) );
		}

		// now solve for A
		if ( triangle.getAngleB() != 0 && triangle.getAngleC() != 0 ) {
			System.out.println( "Solving for A using 180 degrees" );
			triangle.setAngleA( 180 - triangle.getAngleC() - triangle.getAngleB() );
		}
		else if ( triangle.getSideA() != 0 && triangle.getSideC() != 0 ) {
			System.out.println( "Solving for A using asin(a/c)" );
			triangle.setAngleA( Math.asin( triangle.getSideA() / triangle.getSideC() ) * (180 / Math.PI) );
		}
		else if ( triangle.getSideB() != 0 && triangle.getSideC() != 0 ) {
			System.out.println( "Solving for A using acos(b/c)" );
			triangle.setAngleA( Math.acos( triangle.getSideB() / triangle.getSideC() ) * (180 / Math.PI) );
		}
		else if ( triangle.getSideA() != 0 && triangle.getSideB() != 0 ) {
			System.out.println( "Solving for A using atan(a/b)" );
			triangle.setAngleA( Math.atan( triangle.getSideA() / triangle.getSideB() ) );
		}

		// now solve for B
		if ( triangle.getAngleA() != 0 && triangle.getAngleC() != 0 ) {
			System.out.println( "Solving for B using 180 degrees" );
			triangle.setAngleB( 180 - triangle.getAngleA() - triangle.getAngleC() );
		}

		// TODO there are other ways to calculate B, but we've probably figured it out by now

		if ( !triangle.isSolved() ) {
			System.out.println( "Looks like we couldn't figure it out." );
		}
	}

	public Triangle getTriangle() {
		return this.triangle;
	}

	public static void main( String[] args ) {
		Scanner scan = new Scanner( System.in );

		int numClues = 0;
		List<String> clues = new ArrayList<String>();

		System.out.println( "Enter number of clues:" );
		numClues = scan.nextInt();

		System.out.println( "\nEnter clues:" );
		for ( int i = 0 ; i < numClues ; i++ ) {
			clues.add( scan.next() );
		}

		scan.close();

		Main m = new Main();
		m.parseClues( clues );

		m.inferRemaining();

		System.out.println( "Your triangle:" );
		System.out.println( m.getTriangle().toString() );
	}

}
