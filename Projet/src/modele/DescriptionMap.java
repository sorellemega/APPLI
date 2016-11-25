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
		 
		 strConsoLabel[0] = "Mais soufflé";
		 strConsoLabel[1] = "Gomme";
		 strConsoLabel[2] = "bonbon";
		 strConsoLabel[3] = "Tricot";
		 strConsoLabel[4] = "Gadget Canadien de Montréal";
		 nConsoPrix[0] = 2;
		 nConsoPrix[1] = 3;
		 nConsoPrix[2] = 1;
		 nConsoPrix[3] = 10;
		 nConsoPrix[4] = 5;
		 //
		 strFilmLabel[0] = " Suite logique des précédents:lourd,pompeux,mais aussi efficace,sombre et filmé avec virtuosité.Et une fois de plus le méchant est";
		 strFilmLabel[1] = "Du Tarantino dans le texte:violent,verbeux,hilarant, jubilatoire et toujours flamboyant.Et comme toujours le genre importe";
		 strFilmLabel[2] = "Le regroupement des super héros est amusant mais peu crédible.Le méchant est insignifiant.Chaque scène avec Hulk déchire";
		 strFilmLabel[3] = "Après avoir perdu toute méfiance au bout de 10mn,le même enchantement nous reprend 8 ans après,et la même frustration";
		 strFilmLabel[4] = "Après un épisode bâclé,les 50 ans du mythe se fêtent de manière sombre avec un grand réal,un méchant cinglé,et des clins d’œil ";
		 strFilmLabel[5] = "Un thriller politique qu'Affleck réalisateur transcende en bombe cinématographique. A la fois drôle, stressant";
		 strFilmLabel[6] = "Vu le public visé,l'immoralité et la violence peuvent surprendre.L'histoire tient la route et c'est efficace.Mais la révolte manque ";
		 strFilmLabel[7] = "Une montée en puissance phénoménale pendant 2h30 qui passent en coup de vent. La fin est moins intense mais l'expérience est inoubliabl...";
		 strFilmLabel[8] = "Malgré une mise en scène trop sage,cette pièce de théâtre est transposée en film très agréable,drôle et étonnamment passionnant.";
		 strFilmLabel[9] = "D'abord c'est un film inutile trop long. Ensuite le public visé est celui des ados. Par contre c'est bien joué,efficace et drôle. A voir?";
		 strFilmLabel[10] = "Voyage sensoriel et spirituel aux images époustouflantes,avec une relation homme-tigre qui n'a pas fini de nous hanter.Étonnant et uni";
		 strFilmLabel[11] = "Un film fantastique étrange, naviguant entre une horreur crue bas de gamme et une fièvre mystique à l'esthétisme bouleversant.";
		 strFilmLabel[12] = "Un drame chaud,dur,sans concession,et à l'ambiance lourde. Après Un prophète,encore une œuvre à la fois subtile et";
		 strFilmLabel[13] = "Comédie dramatique qui ose une romance entre 2 névrosés.Les 4 acteurs principaux sont bouleversants,et la fin transcende un ";
		 strFilmLabel[14] = "Apocalypse,action,suspense et sentiments. C'est parfois un peu répétitif mais le film a tout pour devenir culte";
		 strFilmLabel[15] = "Petite bombe dramatique et émotionnelle,sans fulgurances mais analysant avec finesse la psychologie d'ados joués par des acte";
		 strFilmLabel[16] = "Le film montre l'homme et pas le chanteur.Jérémy Rénier est parfait.Siri ne manque pas de virtuosité mais a oublié l'émotion et";
		 strFilmLabel[17] = "Bayona nous a refait le coup de Spielberg avec son Soldat Ryan: un début génial,effrayant et bouleversant; la suite lourde ";
		 strFilmLabel[18] = "Apparemment on a switché les bracelets dans les studios. Si Mérida est le portrait craché du père Disney, Ralph a bien l'ADN de Pixar.";
		 strFilmLabel[19] = "C'est l'histoire d'un américain, un black, un bridé, un british, un suédois et Chuck Norris qui défoncent un belge. Résultat : 2000 morts. ";
		 strFilmLabel[20] = "Les gros bourrins des années 80 refont les gros bourrins dans une suite de sketches parodiques. L'amateur s'éclate.";
		 strFilmLabel[21] = "Wes Anderson est en forme. La fuite des enfants est un sommet de drôlerie et de délire.Chaque image est cadrée,colorée,léchée.";
		 strFilmLabel[22] = " Avant la fin du mandat,penser à finir la guerre civile,à unifier le pays puis à abolir l'esclavage. Modestement,avec discours puis frénés";
		 strFilmLabel[23] = "Une histoire simple mais originale, saupoudrée de drame constamment contrebalancé par de l'humour vache.Une belle ";
		 strFilmLabel[24] = "Grande saga familiale légendaire réalisée sobrement par l'auteur de La Route. Guy Pearce en fait trop mais l'irréel Tom Hardy écrase";
		 strFilmLabel[25] = "Vous allez adorer Teddy,un ours en peluche obsédé,drogué et donneur de leçon. Scoop: Hollywood a osé sortir un film non famil";
		 strFilmLabel[26] = "Un documentaire sur des jeunes qui filment leurs supers-pouvoirs,c'est très amusant.Et le trop sérieux de la suite ne gâche pas";
		 strFilmLabel[27] = "Enquête et traque furent si rébarbatives que cela mine les 2/3 du film. Mais l'assaut final est une splendeur explosive et ";
		 strFilmLabel[28] = "Un hommage au film noir US,avec les scènes d'action qui s'enchaînent,sans musique et sans pitié.Un divertissement efficace et";
		 strFilmLabel[29] = "Glauque mais plein d'ironie,un film qui évite le graveleux grâce à une gaieté omniprésente. D'un intérêt mesuré mais parf";
		 strFilmLabel[30] = "Un 4ème épisode sans surprise malgré un démarrage en fanfare. L'animation est réussie mais le scénario sent le réchauffé. Lassant";
		 strFilmLabel[31] = "La réalisation désuète et le comique réchauffé sentent un peu le roussi, mais le retour dans les années 60 est nostalgiquement réussi.";
		 strFilmLabel[32] = "Haneke donne le temps aux scènes d'exister,aux acteurs de faire vivre leur personnage et ce vieux couple magnifique en souffr...";
		 strFilmLabel[33] = "Plus qu'un film catastrophe, c'est surtout un drame inégal sur un homme ravagé, magistralement joué par un Washington criant ";
		 strFilmLabel[34] = "Une ambiance d'horreur et de claustrophobie flotte tout le long de ce film d'action pure.La violence est omniprésente,le danger est ";
		 strFilmLabel[35] = "Un sujet très tabou sous la forme d'un thriller haletant et insoutenable.Sans concession,sans excuse,ce film fort a bien sûr fait ";
		 strFilmLabel[36] = "Les déchirures d'un couple marginal sur fond de country, chimio et croyance en l'au-delà. Sans chronologie, un très beau film lyrique. ”";
		 strFilmLabel[37] = "Ce film est un vieux pote de lycée attardé : on est nostalgique et un peu content de le voir, mais assez soulagé de ne plus avoir 18 ans.";
		 strFilmLabel[38] = "De l'émotion dans la réal, un acteur magnifique et un sujet captivant: Comment s'attacher à quelqu'un pour l'aider durablement? UNE CLAQUE!";
		 strFilmLabel[39] = "La double peine, c'est télécharger Les Misérables, le regarder, puis se faire épingler par Hadopi. Je ne sais pas ce qui est le pire. ";
		 strFilmLabel[40] = "Longuette histoire tronquée,chansons à tout-va, lourdeur,réalisation télé avec gros plans. C'est pourtant pas si édulcoré et bien joué.";
		 strFilmLabel[41] = "Amusant au début, surtout pour l'atmosphère des seventies. Puis cela se termine comme un film hollywoodien quelconque.";
		 strFilmLabel[42] = "Une comédie romantique réussie,située dans des années 50 imaginaires,colorée et énergique. Un concentré de talents qui met de bonn";
		 strFilmLabel[43] = "Un grand spectacle souvent impressionnant. Mais qui dit gros budget, dit film familial. Avec toutes les limites du genre";
		 strFilmLabel[44] = "_Une histoire simple pleine de fraîcheur, réalisée en finesse,traitant courageusement de la condition de la femme en Arabie Saoudite.";
		 strFilmLabel[45] = "C'est sympa mais ça malgache un peu. ";
		 strFilmLabel[46] = "Romance étudiante,drame social,puis hymne au courage et à la liberté.Une fable superbe parfaitement rythmée et réalisée dans ";
		 strFilmLabel[47] = "Fin d'une série infantile et moralisatrice. Aussi bien que le 1 pour les fans. Les non-fans ne vont tout de même pas s'en farcir 5, si ?";
		 strFilmLabel[48] = "Un film d'horreur au démarrage drôle et très classique. Puis tout bascule jusqu'à un orgasme cinémato-gorique. Maladroit mais ét...";
		 strFilmLabel[49] = "Ce cauchemar irréel navigue de rôle en rôle, sans suite logique. Ce film veut cabosser, irriter ou impressionner. Il atteint bien son but.";
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
		 strFilmTitre[9] = "Le prénom";
		 strFilmTitre[10] = "The Amazing Spider-Man ";
		 strFilmTitre[11] = "L'Odyssée de Pi";
		 strFilmTitre[12] = "Prometheus";
		 strFilmTitre[13] = "De rouille et d'os";
		 strFilmTitre[14] = "Happiness Therapy ";
		 strFilmTitre[15] = "Looper";
		 strFilmTitre[16] = "Le Monde de Charlie ";
		 strFilmTitre[17] = "Cloclo ";
		 strFilmTitre[18] = "The Impossible";
		 strFilmTitre[19] = "Les Mondes de Ralph";
		 strFilmTitre[20] = "Expendables 2 : unité spéciale";
		 strFilmTitre[21] = "Moonrise Kingdom";
		 strFilmTitre[22] = " Lincoln";
		 strFilmTitre[23] = "Rebelle";
		 strFilmTitre[24] = "Des hommes sans loi ";
		 strFilmTitre[25] = "Les Cinq légendes ";
		 strFilmTitre[26] = "Ted";
		 strFilmTitre[27] = "Chronicle";
		 strFilmTitre[28] = "Zero Dark Thirty";
		 strFilmTitre[29] = "Jack Reacher ";
		 strFilmTitre[30] = "Dans la maison ";
		 strFilmTitre[31] = "L'Âge de glace : La dérive des c...";
		 strFilmTitre[32] = "Men In Black III";
		 strFilmTitre[33] = "Amour";
		 strFilmTitre[34] = "Flight";
		 strFilmTitre[35] = "The Raid";
		 strFilmTitre[36] = "La Chasse";
		 strFilmTitre[37] = "Alabama Monroe ";
		 strFilmTitre[38] = "American Pie 4";
		 strFilmTitre[39] = "Detachment";
		 strFilmTitre[40] = "Les Misérables ";
		 strFilmTitre[41] = "Dark Shadows";
		 strFilmTitre[42] = "Populaire";
		 strFilmTitre[43] = "Blanche-Neige et le chasseur ";
		 strFilmTitre[44] = "Wadjda";
		 strFilmTitre[45] = "Madagascar 3 Bons Baisers D’Europe ";
		 strFilmTitre[46] = "Twilight - Chapitre 5 : Révélati...";
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

