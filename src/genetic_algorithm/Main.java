/*
# GAPE - Genetic Algorithm for Parameter Estimation of SIFTER tool
#
# Created by Eng. (C) Julian Camilo Castañeda Alonso, Msc. Carlos Andres Sierra and Msc. Tania Andrea Rodriguez Quiñones on August 2017.
# Copyright (c) 2017. Eng. (C) Julian Camilo Castañeda Alonso, Msc. Carlos Andres Sierra and Msc. Tania Andrea Rodriguez Quiñones. Universidad Antonio Narino. All rights reserved.
#
# GAPE is free software: you can redistribute it and/or modify it under the terms of the 
# GNU General Public License v3.0 found in the LICENSE file in the root directory of this project.
*/

package genetic_algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

import print_files.PrintFiles;

/**
 * 
 * @author Eng. (C) Julian Camilo Castañeda Alonso, Msc. Carlos Andres Sierra and Msc. Tania Andrea Rodriguez Quiñones
 *
 */

public class Main {

	public static void main(String[] args) {

		long startTime = System.nanoTime(); // Start time counter

		// To print in console information about execution
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		if (args.length != 1) {

			// No valid file
			try {

				bw.write("Invalid parameter. Please set a valid configuration file. \n");
				bw.flush();

			} catch (IOException e) {

				e.printStackTrace();

			}
		}

		System.gc(); // Call Garbage Collector

		String setupFile = args[0]; // File to extract configuration parameters
		String line;

		// Read parameters from configuration file
		int populationSize = 10; // Population size of genetic algorithm
		int iterations = 10; // Iterations or generations for genetic algorithm
		double weightMutation = 0.5;
		String idFamily = ""; // Id of Protein Family
		String output = "bestIndividual_" + idFamily;
		int[] rowNames = null; // Number of proteins functions

		try {

			BufferedReader br;
			br = new BufferedReader(new FileReader(setupFile));
			String[] field_value;
			line = br.readLine();

			while (line != null) {

				field_value = line.split("=");

				switch (field_value[0]) {

				case "PopulationSize":
					populationSize = Integer.parseInt(field_value[1]);
					break;

				case "Iterations":
					iterations = Integer.parseInt(field_value[1]);
					break;

				case "WeightMutation":
					weightMutation = Double.parseDouble(field_value[1]);
					break;

				case "IdFamily":
					idFamily = field_value[1];
					break;

				case "Functions":
					rowNames = Arrays.stream(field_value[1].split(",")).mapToInt(Integer::parseInt).toArray();
					break;

				case "Output":
					output = field_value[1];
					break;

				}

				line = br.readLine();

			}

			br.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

		Population population = new Population(populationSize, iterations, weightMutation, rowNames, idFamily);

		String bestIndividual = population.getBest();

		// Define time of execution
		double elapsedTimeInSec = (System.nanoTime() - startTime) * 1.0e-9;

		try {
			bw.write("\nBest individual is: \n" + bestIndividual);
			bw.write("\n\nElapsed Time: " + elapsedTimeInSec + " seconds\n\n");
			bw.flush();

			String outp = "output/" + output;
			PrintFiles prFiles = new PrintFiles();

			prFiles.printBestIndividual(outp, bestIndividual, String.valueOf(elapsedTimeInSec));

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

}
