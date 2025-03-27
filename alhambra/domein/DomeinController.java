package domein;

import java.util.ArrayList;
import java.util.List;

import dtos.SpelerDTO;
import utils.SpelerKleur;

public class DomeinController {

	private final SpelerRepository spelerRepository;
	private Dobbelsteen ds;
	private Spel spel;
	private final DobbelsteenRepository dobbelRepo;
	public DomeinController() {
		spelerRepository = new SpelerRepository();
//		ds = new Dobbelsteen(null);
		//spel = new Spel();
		dobbelRepo = new DobbelsteenRepository();
	}

	public void registreerSpeler(String gebruikersnaam, int geboortejaar) {
		Speler nieuweSpeler = new Speler(gebruikersnaam, geboortejaar);
		spelerRepository.voegToe(nieuweSpeler);
	}

	// zet alle spelerobjecten om naar DTOs
	public List<SpelerDTO> geefSpelers() {
		List<Speler> spelers = spelerRepository.getSpelers();
		List<SpelerDTO> spelerDTO = new ArrayList<>();
		for (Speler s : spelers) {
			spelerDTO.add(new SpelerDTO(s.getGebruikersnaam(), s.getGeboortejaar(), s.getScore()));
		}
		return spelerDTO;
	}
	
	public String geefResultaatWorp() {
		return ds.toString();
	}
	
	public void kiesSpelerSpel(String gebruikersnaam, SpelerKleur spelerKleur, int geboortejaar, int score) {
		spel.voegSpelerToe(gebruikersnaam, spelerKleur, geboortejaar, score);
		
	}
	public List<SpelerDTO> geefGekozenSpelersSpel(String gebruikersnaam, SpelerKleur spelerKleur, int geboortejaar, int score){
		return spel.geefGekozenSpelers(gebruikersnaam, spelerKleur, geboortejaar, score);
	}
	public List<SpelerKleur> geefGekozenKleur(){
		return spel.geefGekozenKleurSpeler();
	}
	
//	public List<String> geefDobbelstenen(){
//		List<String> dobbelstenen = new ArrayList();
//		for(Dobbelsteen d : dobbelRepo.getDobbelstenen())
//			dobbelstenen.add(d.getKleurZijde());
//		
//	}
	
	public SpelerDTO bepaalStartSpeler() {
		return spel.StartSpeler();
	}
	public int getZetstenen() {
		return spel.getAantalZetstenen();
		
	
	}
	public int getGebouwstenen() {
		return spel.getAantalGebouwstenen();
	}
	public List<Fiche> geefFiches(){
		return spel.geefLijstFiche();
	}
	

}

