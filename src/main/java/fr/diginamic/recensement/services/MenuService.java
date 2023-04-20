package fr.diginamic.recensement.services;

import java.util.Scanner;

import exception.CodeException;
import fr.diginamic.recensement.entites.Recensement;

/**
 * Classe représentant un service
 * 
 * @author DIGINAMIC
 *
 */
public abstract class MenuService {

	/**
	 * Méthode abstraite de traitement que doivent posséder toutes les méthodes de
	 * services
	 * 
	 * @param lignes  lignes du fichier
	 * @param scanner scanner
	 * @throws CodeException 
	 */
	public abstract void traiter(Recensement recensement, Scanner scanner) throws CodeException;
}
