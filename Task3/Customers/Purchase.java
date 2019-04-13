/**
 *
 *  @author Pawlaszek Grzegorz S17651
 *
 */

package zad2;

public class Purchase {

	private String id;
	private String nazwisko;
	private String produkt;
	private double cena;
	private double ilosc;
	private double koszt;

	public Purchase(String[] tab) {
		id = tab[0];
		nazwisko = tab[1];
		produkt = tab[2];
		cena = Double.parseDouble(tab[3]);
		ilosc = Double.parseDouble(tab[4]);
		koszt = cena * ilosc;
	}

	public String getId() {
		return id;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public String getProdukt() {
		return produkt;
	}

	public double getCena() {
		return cena;
	}

	public double getIlosc() {
		return ilosc;
	}

	public double getKoszt() {
		return koszt;
	}

	public String toString() {
		return id + ";" + nazwisko + ";" + produkt + ";" + cena + ";" + ilosc;
	}

}
