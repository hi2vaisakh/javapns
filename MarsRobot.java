/**
 * 
 */
package com.my.project;

import java.util.HashMap;

/**
 * @author user
 *
 */
public class Robots {

	private static final String left = "L";
	private static final String right = "R";
	private static final String move = "M";

	private static final String east = "E";
	private static final String west = "W";
	private static final String north = "N";
	private static final String south = "S";


	public String processInstruction(String instr, String position) {
		String[] posArray = position.split(" ");
		String[] instrArray = instr.split("");
		Integer newDataX = 0;
		Integer newDataY = 0;
		for (int i = 1; i < instrArray.length; i++) {
			switch (instrArray[i]) {

			case left:

				switch (posArray[2]) {

				case north:
					posArray[2] = west;
					break;
				case south:
					posArray[2] = east;
					break;
				case east:
					posArray[2] = north;
					break;
				case west:
					posArray[2] = south;
					break;
				}
				break;
			case right:

				switch (posArray[2]) {

				case north:
					posArray[2] = east;
					break;
				case south:
					posArray[2] = west;
					break;
				case east:
					posArray[2] = south;
					break;
				case west:
					posArray[2] = north;
					break;
				}
				break;
			case move:

				switch (posArray[2]) {

				case east:
					String x = posArray[0];
					newDataX = Integer.parseInt(x) + 1;
					posArray[0] = newDataX.toString();
					break;
				case west:
					x = posArray[0];
					newDataX = Integer.parseInt(x) - 1;
					posArray[0] = newDataX.toString();
					break;
				case north:
					String y = posArray[1];
					newDataY = Integer.parseInt(y) + 1;
					posArray[1] = newDataY.toString();
					break;
				case south:
					y = posArray[1];
					newDataY = Integer.parseInt(y) - 1;
					posArray[1] = newDataY.toString();
					break;
				}
				break;
			}
		}
		return posArray[0] + " " + posArray[1] + " " + posArray[2];
	}
}
