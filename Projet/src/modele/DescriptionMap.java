package modele;

import java.util.Hashtable;
import commun.DateFormatee;

public class DescriptionMap  {
	 private static TableFastSearchDescription tb;
	 private static String[] strConsoLabel= new String[5];
	 private static int[] nConsoPrix= new int[5];
	 private static String[] strFilmLabel= new String[50];
	 private static String[] strFilmGenre= new String[6];
	 private static String[] strFilmSupport = new String[2];
	 private static boolean[] strFilmNouveau = new boolean[2];
	 private static String[] strFilmTitre= new String[50];
	 private static String[] strFilmAnnee = new String[6];
	 private static final String strEmpty = "";
	   	    
	 public static void ChargerArticles(){	
		 
	    tb = new TableFastSearchDescription();
	    
	    int theConsoLength = strConsoLabel.length;
	    for( int indexConsommable = 0; indexConsommable < theConsoLength;  indexConsommable++){
	    	Article theArticle = new Article( "conso"+indexConsommable, nConsoPrix[indexConsommable], strConsoLabel[indexConsommable], strEmpty, strEmpty, false, true, (indexConsommable+1)*(indexConsommable+7), strEmpty, (new DateFormatee().getDateTime()) );
	    	tb.putIndexInTable("conso"+indexConsommable,theArticle);
	    }
	    
	    int theFilmLength = strFilmLabel.length;
	    for( int indexFilm = 0; indexFilm < theFilmLength;  indexFilm++){
	    	int leRandom2 = (int)(2*Math.random());
	    	if( leRandom2 > 1) leRandom2 = 1;
	    	else leRandom2 = 0;
	    	
	    	int leRandom6 = (int)(6*Math.random());
	    	if(leRandom6 == 6 ) leRandom6 = 5;
	    	
	    	boolean unConsommable = leRandom6 < 2;
	    	int lePrix;
	    	if( unConsommable ) lePrix = Article.PRIX_VENTE_FILM;
	    	if( !unConsommable &&  strFilmNouveau[leRandom2] ) lePrix = Article.PRIX_LOCATION_JOUR;
	    	else lePrix = -1;	    	
	    	
	    	Article theArticle = new Article( "film"+indexFilm, lePrix, strFilmLabel[indexFilm], strFilmGenre[leRandom6], strFilmSupport[leRandom2], strFilmNouveau[leRandom2], unConsommable, (indexFilm+1)*(indexFilm+7), strFilmTitre[indexFilm], strFilmAnnee[leRandom6] );
	    	tb.putIndexInTable("film"+indexFilm,theArticle);
	    }
	    
	 }
	 
	 public static DescriptionProduit trouveDescription( String unCodeArticle ) {
		 DescriptionProduit uneDescp = tb.chercherDescriptionProduit( unCodeArticle );
		 if( uneDescp == null ) return null;
		    return uneDescp;
	 }
	 
	 public static Article trouveArticle( String unCodeArticle ) {
		 Article objArticle = tb.chercherArticle( unCodeArticle );
		 if( objArticle == null ) return null;
		    return objArticle;
	 }
	 
	 public static int getNumbreDeConsosommables(){
		 return strConsoLabel.length;
	 }
	 public static int getNumbreDeFilms(){
		 return strFilmLabel.length;
	 }
	 
	 static{
		 
		 strFilmAnnee[0] = "2007";
		 strFilmAnnee[1] = "2008";
		 strFilmAnnee[2] = "2009";
		 strFilmAnnee[3] = "2010";
		 strFilmAnnee[4] = "2011";
		 strFilmAnnee[5] = "2012";
		 
		 strFilmSupport[0] = Article.SUPPORT_DVD;
		 strFilmSupport[1] = Article.SUPPORT_DVD;
		 
		 strFilmNouveau[0] = true;
		 strFilmNouveau[1] = false;
		 
		 
		 strFilmGenre[0] = "Thriller";
		 strFilmGenre[1] = "Romantic";
		 strFilmGenre[2] = "Horreur";
		 strFilmGenre[3] = "Guerre";
		 strFilmGenre[4] = "Policier";
		 strFilmGenre[5] = "Documentaire";
		 
		 strConsoLabel[0] = "Mais souffl�";
		 strConsoLabel[1] = "Gomme";
		 strConsoLabel[2] = "bonbon";
		 strConsoLabel[3] = "Tricot";
		 strConsoLabel[4] = "Gadget Canadien de Montr�al";
		 nConsoPrix[0] = 2;
		 nConsoPrix[1] = 3;
		 nConsoPrix[2] = 1;
		 nConsoPrix[3] = 10;
		 nConsoPrix[4] = 5;
		 //
		 strFilmLabel[0] = " Suite logique des pr�c�dents:lourd,pompeux,mais aussi efficace,sombre et film� avec virtuosit�.Et une fois de plus le m�chant est";
		 strFilmLabel[1] = "Du Tarantino dans le texte:violent,verbeux,hilarant, jubilatoire et toujours flamboyant.Et comme toujours le genre importe";
		 strFilmLabel[2] = "Le regroupement des super h�ros est amusant mais peu cr�dible.Le m�chant est insignifiant.Chaque sc�ne avec Hulk d�chire";
		 strFilmLabel[3] = "Apr�s avoir perdu toute m�fiance au bout de 10mn,le m�me enchantement nous reprend 8 ans apr�s,et la m�me frustration";
		 strFilmLabel[4] = "Apr�s un �pisode b�cl�,les 50 ans du mythe se f�tent de mani�re sombre avec un grand r�al,un m�chant cingl�,et des clins d��il ";
		 strFilmLabel[5] = "Un thriller politique qu'Affleck r�alisateur transcende en bombe cin�matographique. A la fois dr�le, stressant";
		 strFilmLabel[6] = "Vu le public vis�,l'immoralit� et la violence peuvent surprendre.L'histoire tient la route et c'est efficace.Mais la r�volte manque ";
		 strFilmLabel[7] = "Une mont�e en puissance ph�nom�nale pendant 2h30 qui passent en coup de vent. La fin est moins intense mais l'exp�rience est inoubliabl...";
		 strFilmLabel[8] = "Malgr� une mise en sc�ne trop sage,cette pi�ce de th��tre est transpos�e en film tr�s agr�able,dr�le et �tonnamment passionnant.";
		 strFilmLabel[9] = "D'abord c'est un film inutile trop long. Ensuite le public vis� est celui des ados. Par contre c'est bien jou�,efficace et dr�le. A voir?";
		 strFilmLabel[10] = "Voyage sensoriel et spirituel aux images �poustouflantes,avec une relation homme-tigre qui n'a pas fini de nous hanter.�tonnant et uni";
		 strFilmLabel[11] = "Un film fantastique �trange, naviguant entre une horreur crue bas de gamme et une fi�vre mystique � l'esth�tisme bouleversant.";
		 strFilmLabel[12] = "Un drame chaud,dur,sans concession,et � l'ambiance lourde. Apr�s Un proph�te,encore une �uvre � la fois subtile et";
		 strFilmLabel[13] = "Com�die dramatique qui ose une romance entre 2 n�vros�s.Les 4 acteurs principaux sont bouleversants,et la fin transcende un ";
		 strFilmLabel[14] = "Apocalypse,action,suspense et sentiments. C'est parfois un peu r�p�titif mais le film a tout pour devenir culte";
		 strFilmLabel[15] = "Petite bombe dramatique et �motionnelle,sans fulgurances mais analysant avec finesse la psychologie d'ados jou�s par des acte";
		 strFilmLabel[16] = "Le film montre l'homme et pas le chanteur.J�r�my R�nier est parfait.Siri ne manque pas de virtuosit� mais a oubli� l'�motion et";
		 strFilmLabel[17] = "Bayona nous a refait le coup de Spielberg avec son Soldat Ryan: un d�but g�nial,effrayant et bouleversant; la suite lourde ";
		 strFilmLabel[18] = "Apparemment on a switch� les bracelets dans les studios. Si M�rida est le portrait crach� du p�re Disney, Ralph a bien l'ADN de Pixar.";
		 strFilmLabel[19] = "C'est l'histoire d'un am�ricain, un black, un brid�, un british, un su�dois et Chuck Norris qui d�foncent un belge. R�sultat : 2000 morts. ";
		 strFilmLabel[20] = "Les gros bourrins des ann�es 80 refont les gros bourrins dans une suite de sketches parodiques. L'amateur s'�clate.";
		 strFilmLabel[21] = "Wes Anderson est en forme. La fuite des enfants est un sommet de dr�lerie et de d�lire.Chaque image est cadr�e,color�e,l�ch�e.";
		 strFilmLabel[22] = " Avant la fin du mandat,penser � finir la guerre civile,� unifier le pays puis � abolir l'esclavage. Modestement,avec discours puis fr�n�s";
		 strFilmLabel[23] = "Une histoire simple mais originale, saupoudr�e de drame constamment contrebalanc� par de l'humour vache.Une belle ";
		 strFilmLabel[24] = "Grande saga familiale l�gendaire r�alis�e sobrement par l'auteur de La Route. Guy Pearce en fait trop mais l'irr�el Tom Hardy �crase";
		 strFilmLabel[25] = "Vous allez adorer Teddy,un ours en peluche obs�d�,drogu� et donneur de le�on. Scoop: Hollywood a os� sortir un film non famil";
		 strFilmLabel[26] = "Un documentaire sur des jeunes qui filment leurs supers-pouvoirs,c'est tr�s amusant.Et le trop s�rieux de la suite ne g�che pas";
		 strFilmLabel[27] = "Enqu�te et traque furent si r�barbatives que cela mine les 2/3 du film. Mais l'assaut final est une splendeur explosive et ";
		 strFilmLabel[28] = "Un hommage au film noir US,avec les sc�nes d'action qui s'encha�nent,sans musique et sans piti�.Un divertissement efficace et";
		 strFilmLabel[29] = "Glauque mais plein d'ironie,un film qui �vite le graveleux gr�ce � une gaiet� omnipr�sente. D'un int�r�t mesur� mais parf";
		 strFilmLabel[30] = "Un 4�me �pisode sans surprise malgr� un d�marrage en fanfare. L'animation est r�ussie mais le sc�nario sent le r�chauff�. Lassant";
		 strFilmLabel[31] = "La r�alisation d�su�te et le comique r�chauff� sentent un peu le roussi, mais le retour dans les ann�es 60 est nostalgiquement r�ussi.";
		 strFilmLabel[32] = "Haneke donne le temps aux sc�nes d'exister,aux acteurs de faire vivre leur personnage et ce vieux couple magnifique en souffr...";
		 strFilmLabel[33] = "Plus qu'un film catastrophe, c'est surtout un drame in�gal sur un homme ravag�, magistralement jou� par un Washington criant ";
		 strFilmLabel[34] = "Une ambiance d'horreur et de claustrophobie flotte tout le long de ce film d'action pure.La violence est omnipr�sente,le danger est ";
		 strFilmLabel[35] = "Un sujet tr�s tabou sous la forme d'un thriller haletant et insoutenable.Sans concession,sans excuse,ce film fort a bien s�r fait ";
		 strFilmLabel[36] = "Les d�chirures d'un couple marginal sur fond de country, chimio et croyance en l'au-del�. Sans chronologie, un tr�s beau film lyrique. �";
		 strFilmLabel[37] = "Ce film est un vieux pote de lyc�e attard� : on est nostalgique et un peu content de le voir, mais assez soulag� de ne plus avoir 18 ans.";
		 strFilmLabel[38] = "De l'�motion dans la r�al, un acteur magnifique et un sujet captivant: Comment s'attacher � quelqu'un pour l'aider durablement? UNE CLAQUE!";
		 strFilmLabel[39] = "La double peine, c'est t�l�charger Les Mis�rables, le regarder, puis se faire �pingler par Hadopi. Je ne sais pas ce qui est le pire. ";
		 strFilmLabel[40] = "Longuette histoire tronqu�e,chansons � tout-va, lourdeur,r�alisation t�l� avec gros plans. C'est pourtant pas si �dulcor� et bien jou�.";
		 strFilmLabel[41] = "Amusant au d�but, surtout pour l'atmosph�re des seventies. Puis cela se termine comme un film hollywoodien quelconque.";
		 strFilmLabel[42] = "Une com�die romantique r�ussie,situ�e dans des ann�es 50 imaginaires,color�e et �nergique. Un concentr� de talents qui met de bonn";
		 strFilmLabel[43] = "Un grand spectacle souvent impressionnant. Mais qui dit gros budget, dit film familial. Avec toutes les limites du genre";
		 strFilmLabel[44] = "_Une histoire simple pleine de fra�cheur, r�alis�e en finesse,traitant courageusement de la condition de la femme en Arabie Saoudite.";
		 strFilmLabel[45] = "C'est sympa mais �a malgache un peu. ";
		 strFilmLabel[46] = "Romance �tudiante,drame social,puis hymne au courage et � la libert�.Une fable superbe parfaitement rythm�e et r�alis�e dans ";
		 strFilmLabel[47] = "Fin d'une s�rie infantile et moralisatrice. Aussi bien que le 1 pour les fans. Les non-fans ne vont tout de m�me pas s'en farcir 5, si ?";
		 strFilmLabel[48] = "Un film d'horreur au d�marrage dr�le et tr�s classique. Puis tout bascule jusqu'� un orgasme cin�mato-gorique. Maladroit mais �t...";
		 strFilmLabel[49] = "Ce cauchemar irr�el navigue de r�le en r�le, sans suite logique. Ce film veut cabosser, irriter ou impressionner. Il atteint bien son but.";
		 //
		 strFilmTitre[0] = "Some broken hearts neve mend";
		 strFilmTitre[1] = "The Dark Knight Rises";
		 strFilmTitre[2] = "Django Unchained ";
		 strFilmTitre[3] = "Avengers ";
		 strFilmTitre[4] = "Le Hobbit : Un voyage inattendu ";
		 strFilmTitre[5] = "Skyfall";
		 strFilmTitre[6] = "Argo";
		 strFilmTitre[7] = "Hunger Games";
		 strFilmTitre[8] = "Cloud Atlas";
		 strFilmTitre[9] = "Le pr�nom";
		 strFilmTitre[10] = "The Amazing Spider-Man ";
		 strFilmTitre[11] = "L'Odyss�e de Pi";
		 strFilmTitre[12] = "Prometheus";
		 strFilmTitre[13] = "De rouille et d'os";
		 strFilmTitre[14] = "Happiness Therapy ";
		 strFilmTitre[15] = "Looper";
		 strFilmTitre[16] = "Le Monde de Charlie ";
		 strFilmTitre[17] = "Cloclo ";
		 strFilmTitre[18] = "The Impossible";
		 strFilmTitre[19] = "Les Mondes de Ralph";
		 strFilmTitre[20] = "Expendables 2 : unit� sp�ciale";
		 strFilmTitre[21] = "Moonrise Kingdom";
		 strFilmTitre[22] = " Lincoln";
		 strFilmTitre[23] = "Rebelle";
		 strFilmTitre[24] = "Des hommes sans loi ";
		 strFilmTitre[25] = "Les Cinq l�gendes ";
		 strFilmTitre[26] = "Ted";
		 strFilmTitre[27] = "Chronicle";
		 strFilmTitre[28] = "Zero Dark Thirty";
		 strFilmTitre[29] = "Jack Reacher ";
		 strFilmTitre[30] = "Dans la maison ";
		 strFilmTitre[31] = "L'�ge de glace : La d�rive des c...";
		 strFilmTitre[32] = "Men In Black III";
		 strFilmTitre[33] = "Amour";
		 strFilmTitre[34] = "Flight";
		 strFilmTitre[35] = "The Raid";
		 strFilmTitre[36] = "La Chasse";
		 strFilmTitre[37] = "Alabama Monroe ";
		 strFilmTitre[38] = "American Pie 4";
		 strFilmTitre[39] = "Detachment";
		 strFilmTitre[40] = "Les Mis�rables ";
		 strFilmTitre[41] = "Dark Shadows";
		 strFilmTitre[42] = "Populaire";
		 strFilmTitre[43] = "Blanche-Neige et le chasseur ";
		 strFilmTitre[44] = "Wadjda";
		 strFilmTitre[45] = "Madagascar 3 Bons Baisers D�Europe ";
		 strFilmTitre[46] = "Twilight - Chapitre 5 : R�v�lati...";
		 strFilmTitre[47] = "La Cabane dans les bois";
		 strFilmTitre[48] = "Sugar Man";
		 strFilmTitre[49] = "Holy Motors";
		 //http://www.vodkaster.com/Listes-de-films/Films-les-plus-populaires-de-2012
	 }	 
	 
}	 
	 class TableFastSearchDescription{
	    private Hashtable<String, Article>  ht = new Hashtable<String, Article>();
	    TableFastSearchDescription(){
	    }
	        
	    public void putIndexInTable( String unCodeArticle, Article unArticle ){	       
		     ht.put(unCodeArticle, unArticle );
		}
		    
		public DescriptionProduit chercherDescriptionProduit( String unCodeArticle ){
		   Article obj = ht.get( unCodeArticle );
		   if( obj == null ) return null;
		   return obj.getObjDescription();
		}
	    
	 
	   public Article chercherArticle( String unCodeArticle ){
		   Article obj = ht.get( unCodeArticle );
		   if( obj == null ) return null;
		      return obj;		  
	   }
	   
	 }

