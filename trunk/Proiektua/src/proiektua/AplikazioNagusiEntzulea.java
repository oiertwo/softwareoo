package proiektua;

import java.util.*;

public class AplikazioNagusiEntzulea extends Observable{
	//MENU NAGUSIKOAK:
	void hasiInterfazeNagusia(){
		setChanged();
		notifyObservers(new String("HASI_INTERFAZE_NAGUSIA"));
	}
	void aukeratuData(){
		setChanged();
		notifyObservers("DATA");
	}
	void aukeratuAgentea(){
		setChanged();
		notifyObservers(new String("AGENTEAK"));
	}
	void aukeratuEzaugarria(){
		setChanged();
		notifyObservers(new String("EZAUGARRIAK"));
	}
	void erreserbaBerria(){
		setChanged();
		notifyObservers(new String("ERRES_BERRI"));
	}
	void sartuErreserba(){
		setChanged();
		notifyObservers(new String("ERRES_SARTU"));
	}

	//TURISTEN SARRERAREN INTERFAZEKOAK:
	void hasieratuTuristenInterfazea(){
		setChanged();
		notifyObservers(new String("HASI_TURISTEN_INTERFAZEA"));
	}
	void hurrengoTuristaraJoan(){
		setChanged();
		notifyObservers(new String("HURRENGO_TURISTA"));
	}
	void aurrekoTuristaraJoan(){
		setChanged();
		notifyObservers(new String("AURREKO_TURISTA"));
	}
	void bidaliErreserba(){
		setChanged();
		notifyObservers(new String("BIDALI_ERRESERBA"));
	}
	void ezeztatuErreserba(){
		setChanged();
		notifyObservers(new String("EZEZTATU_ERRESERBA"));
	}
	void aldatuErreserba(){
		setChanged();
		notifyObservers(new String("ALDATU_ERRESERBA"));
	}
	void itxiTuristenInterfazea(){
		setChanged();
		notifyObservers(new String("ITXI_TURISTEN_INTERFAZEA"));
	}

}
