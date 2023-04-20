package fr.diginamic.recensement.services;

import java.util.List;
import exception.CodeException;
import java.util.Scanner;

import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Ville;

/**
 * Recherche et affichage de toutes les villes d'un département dont la
 * population est comprise entre une valeur min et une valeur max renseignées
 * par l'utilisateur.
 * 
 * @author DIGINAMIC
 *
 */
public class RecherchePopulationBorneService extends MenuService {

	@Override
	public void traiter(Recensement rec, Scanner scanner) throws CodeException {

		System.out.println("Quel est le code du département recherché ? ");
		String choix = scanner.nextLine();

		System.out.println("Choississez une population minimum (en milliers d'habitants): ");
		String saisieMin = scanner.nextLine();

		try {
		    int min = Integer.parseInt(saisieMin) * 1000;
		} catch (NumberFormatException e) {
		    throw new CodeException("La saisie doit être un nombre pour la population minimum.");
		}
		
		System.out.println("Choississez une population maximum (en milliers d'habitants): ");
		String saisieMax = scanner.nextLine();
		
		try {
		    int max = Integer.parseInt(saisieMax) * 1000;
		} catch (NumberFormatException e) {
		    throw new CodeException("La saisie doit être un nombre pour la population minimum.");
		}
		
		int min = Integer.parseInt(saisieMin) * 1000;
		int max = Integer.parseInt(saisieMax) * 1000;
		
		if(min < 0 || max < 0 || min>max) {
			throw new CodeException("Veuillez entrer un chiffre valide non négatif et le minimum en dessous du max");
		}

	
	
		
		List<Ville> villes = rec.getVilles();
		for (Ville ville : villes) {
			if (ville.getCodeDepartement().equalsIgnoreCase(choix)) {
				if (ville.getPopulation() >= min && ville.getPopulation() <= max) {
					System.out.println(ville);
				}
			}
		}
	}

}