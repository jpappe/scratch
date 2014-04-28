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

		// TODO actually solve the problem

		System.out.println( "Your triangle:" );
		System.out.println( m.getTriangle().toString() );
	}

}
