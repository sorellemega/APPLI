package modele;

import java.util.Hashtable;
import java.util.Vector;

import commun.DateFormatee;

public class RepertoireAbonnes {
	private static TableFastSearchClient tb;
	private static Address[] objAddress = new Address[30];
	private static Telephone[] objTelephone = new Telephone[30];
	private static CodeSecret[] objCodeSecret = new CodeSecret[30];
	private static String[] strCarteCredit = new String[30];
	private static String[] strDateAbonnement = new String[30];
	private static Vector<Client> hashClients;
	private static final String strEmpty = "";
	private String strSp = " ";
	
	public static void ChargerAbonnes() {

		tb = new TableFastSearchClient();
		hashClients = new Vector<Client>();

		int theSize = strCarteCredit.length;
		for (int index = 0; index < theSize; index++) {
			String thekey = objCodeSecret[index].getCode()
					+ objTelephone[index].getRegion()
					+ objTelephone[index].getZone()
					+ objTelephone[index].getId();
			Client theClient = new Client(objAddress[index],
					objTelephone[index], objCodeSecret[index]);
			tb.putIndexInTable(thekey, theClient);
			hashClients.add(theClient);
			System.out.println(theClient);
		}

	}

	public static Vector<Client> getListedesClients() {
		return hashClients;
	}

	public static Client trouveClient(Client unIdentifiant) {
		Client unClient = tb.chercherClient(unIdentifiant);
		if (unClient == null)
			return null;
		return unClient;
	}

	public static void construitTelephones() {
		int theSize = strCarteCredit.length;
		for (int indexPhone = 0; indexPhone < theSize; indexPhone++) {

			int leRandom10 = (int) (9 * Math.random());
			int leRandom9 = (int) (9 * Math.random());
			int leRandom8 = (int) (9 * Math.random());
			int leRandom7 = (int) (9 * Math.random());
			int leRandom6 = (int) (9 * Math.random());
			int leRandom5 = (int) (9 * Math.random());
			int leRandom4 = (int) (9 * Math.random());
			int leRandom3 = (int) (9 * Math.random());
			int leRandom2 = (int) (9 * Math.random());
			int leRandom1 = (int) (9 * Math.random());

			objTelephone[indexPhone] = new Telephone(strEmpty + leRandom10
					+ leRandom9 + leRandom8, strEmpty + leRandom7 + leRandom3
					+ leRandom5, strEmpty + leRandom4 + leRandom6 + leRandom2
					+ leRandom1);
		}

	}

	public static void construitCodeSecret() {
		int theSize = strCarteCredit.length;
		for (int indexCode = 0; indexCode < theSize; indexCode++) {

			objCodeSecret[indexCode] = new CodeSecret(indexCode);
		}

	}

	public static void construitAdresse() {
		int theSize = strCarteCredit.length;
		for (int indexAdress = 0; indexAdress < theSize; indexAdress++) {
			int leRandom2 = (int) (9 * Math.random());
			int leRandom1 = (int) (9 * Math.random());
			int leRandom3 = (int) (9 * Math.random());
			objAddress[indexAdress] = new Address(strEmpty
					+ ((indexAdress + 1) * (indexAdress + 7)), "Laurier",
					strEmpty + (7 + indexAdress), "Gatineau", "Québec",
					"Canada", strEmpty + "J" + leRandom2 + "A" + leRandom3
							+ "K" + leRandom1);

		}
	}

	public static int getNumbreDeClients() {
		return strCarteCredit.length;
	}

	static {
		construitTelephones();
		construitCodeSecret();
		construitAdresse();

	}

}

class TableFastSearchClient {

	private Hashtable<String, Client> ht = new Hashtable<String, Client>();

	TableFastSearchClient() {
	}

	public void putIndexInTable(String unIdentifiant, Client unClient) {
		ht.put(unIdentifiant, unClient);
	}

	@SuppressWarnings("unused")
	public Client chercherClient(Client obj) {
		// Client obj = ht.get( unIdentifiant );
		// Address uneAdresse=new Address("1", "rue", "unAppartement",
		// "uneVille", "uneProvince", "unPays", "unCodePostal");
		// Telephone unTelephone=new Telephone("819","000","0000");
		// CodeSecret unCodesecret =new CodeSecret(0);

		// Client obj =new Client(uneAdresse,unTelephone,unCodesecret);
		if (obj == null)
			return null;
		return obj;
	}

}
