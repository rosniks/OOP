package werkzeuge;

public interface Entsaftbar {
	//Saft pro cm^3 Obst (Form von Kugel)
	double ERTRAGAPFEL = 0.7;
	double ERTRAGBIRNE = 0.6;
	//nur reifes Obst wird entsaftet, sonst retrun 0
	double entsaften();

}
