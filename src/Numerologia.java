import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

public class Numerologia {
   private HashMap<String, Integer> tabellaPitagorica;
   private HashMap<Integer, Integer> tabellaConversioneNumeriEsoterica;
   private HashMap<String, Integer> tabellaEsoterica;
   private HashMap<Integer, String> tabellaDifettiNumeroPersona;
   private String nome;
   private String cognome;
   private Integer giorno;
   private Integer mese;
   private Integer anno;
   private Integer sentiero;
   private Integer destino;
   private Integer realizzazione;
   private Integer anima;
   private Integer persona;
   private Integer espressione;
   private Integer quintaEssenza;
   private Integer culmine1;
   private Integer culmine2;
   private Integer culmine3;
   private Integer culmine4;
   private Integer sfida1;
   private Integer sfida2;
   private Integer sfida3;
   private Integer sfida4;
   private Integer annoTransizione1;
   private Integer annoTransizione2;
   private Integer annoTransizione3;
   private Integer annoTransizione4;
   private HashMap<Integer, Integer> distribuzioneCaratteriNome = new HashMap();
   private Integer ombraGioventu;
   private Integer ombraMaturità;
   private Integer ombraPrincipale;
   private Integer energiaCreativaCielo;
   private Integer energiaCreativaTerra;
   private Integer sintesiEnergieCreativeLivelloVita;
   private Integer energiaCorpoMentale;
   private Integer energiaCorpoEmozionale;
   private Integer energieCorpoFisicoEsotericoSintesi;
   private Integer karmaPassato;
   private Integer karmaAttuale;
   private Integer karmaTotale;
   private Integer sintesiSuprema;

   public void calcoloNumeriNomi() {
      boolean condizione = false;
      Scanner sc = new Scanner(System.in);

      while(!condizione) {
         System.out.println("Digita nome");
         String nome = sc.nextLine();
         nome = nome.replaceAll(" ", "");
         if (nome.equals("")) {
            condizione = true;
         } else {
            this.calcolaCifreNome(nome);
         }
      }

   }

   public void calcolaMantraNumericoPersonale() {
      System.out.println("Numeri Mantra personale : " + this.energiaCreativaCielo + " " + this.energiaCreativaTerra + " " + this.sintesiEnergieCreativeLivelloVita);
      String numero1 = this.energiaCreativaTerra.toString();
      String numero2 = this.energiaCreativaCielo.toString();
      String numero3 = this.sintesiEnergieCreativeLivelloVita.toString();

      int i;
      for(i = 0; i < numero1.length(); ++i) {
         System.out.print(numero1.charAt(i) + " ");
      }

      System.out.println("BREVE PAUSA");

      for(i = 0; i < numero2.length(); ++i) {
         System.out.print(numero2.charAt(i) + " ");
      }

      System.out.println("BREVE PAUSA");

      for(i = 0; i < numero3.length(); ++i) {
         System.out.print(numero3.charAt(i) + " ");
      }

   }

   public void calcolaSintesiSuperma() {
      this.sintesiSuprema = this.karmaPassato + this.karmaAttuale + this.karmaTotale;
      System.out.println(" Il valore della Sintesi Suprema totale è " + this.sintesiSuprema + " ridotto a una cifra: " + this.riduciAunaCifra(this.sintesiSuprema));
   }

   public void calcoloKarmaTotale() {
      String tot = this.karmaAttuale.toString() + this.karmaPassato.toString();
      int somma = 0;

      for(int i = 0; i < tot.length(); ++i) {
         int cifra = Integer.valueOf(Character.toString(tot.charAt(i)));
         somma += (Integer)this.tabellaConversioneNumeriEsoterica.get(cifra);
      }

      this.karmaTotale = somma;
      System.out.println(" Il valore del Karma totale è " + this.karmaTotale + " ridotto a una cifra: " + this.riduciAunaCifra(this.karmaTotale));
   }

   public void calcoloKarmaAttuale() {
      String numeroNome = "";
      String numeroCognome = "";
      String totaleNome = "";
      String totaleCognome = "";
      Integer somma = 0;

      int i;
      String a;
      for(i = 0; i < this.nome.length(); ++i) {
         a = Character.toString(this.nome.charAt(i));
         numeroNome = numeroNome + this.tabellaEsoterica.get(a.toUpperCase());
      }

      for(i = 0; i < this.cognome.length(); ++i) {
         a = Character.toString(this.cognome.charAt(i));
         numeroCognome = numeroCognome + this.tabellaEsoterica.get(a.toUpperCase());
      }

      int cifra;
      for(i = 0; i < numeroNome.length(); ++i) {
         cifra = Integer.valueOf(Character.toString(numeroNome.charAt(i)));
         somma = somma + (Integer)this.tabellaConversioneNumeriEsoterica.get(cifra);
      }

      totaleNome = somma.toString();
      somma = 0;

      for(i = 0; i < numeroCognome.length(); ++i) {
         cifra = Integer.valueOf(Character.toString(numeroCognome.charAt(i)));
         somma = somma + (Integer)this.tabellaConversioneNumeriEsoterica.get(cifra);
      }

      totaleCognome = somma.toString();
      somma = 0;

      for(i = 0; i < totaleNome.length() + totaleCognome.length(); ++i) {
         cifra = Integer.valueOf(Character.toString(numeroCognome.charAt(i)));
         somma = somma + (Integer)this.tabellaConversioneNumeriEsoterica.get(cifra);
      }

      this.karmaAttuale = somma;
      System.out.println(" Il valore del Karma attuale,familiare è " + this.karmaAttuale + " ridotto a una cifra: " + this.riduciAunaCifra(this.karmaAttuale));
   }

   public void calcoloKarmaPassato() {
      String dataNascita = this.giorno.toString() + this.mese.toString() + this.anno.toString();
      int somma = 0;

      for(int i = 0; i < dataNascita.length(); ++i) {
         int cifra = Integer.valueOf(Character.toString(dataNascita.charAt(i)));
         somma += (Integer)this.tabellaConversioneNumeriEsoterica.get(cifra);
      }

      this.karmaPassato = somma;
      System.out.println(" Il valore del Karma delle vite passate è " + this.karmaPassato + " ridotto a una cifra: " + this.riduciAunaCifra(this.karmaPassato));
   }

   public void calcoloEnergieCorpoFisicoEsotericoSintesi() {
      this.energieCorpoFisicoEsotericoSintesi = this.calcolaPiramideCifraNumero(this.energiaCorpoEmozionale.toString() + this.energiaCorpoMentale.toString());
      System.out.println(" Il valore della sintesi Energie Corpo Fisico Esoterico è " + this.energieCorpoFisicoEsotericoSintesi + " ridotto a una cifra: " + this.riduciAunaCifra(this.energieCorpoFisicoEsotericoSintesi));
   }

   public void calcoloEnergieCorpoEmozionale() {
      String sommaNome = "";
      String sommaCognome = "";

      int i;
      String a;
      for(i = 0; i < this.nome.length(); ++i) {
         a = Character.toString(this.nome.charAt(i));
         sommaNome = sommaNome + this.tabellaEsoterica.get(a.toUpperCase());
      }

      for(i = 0; i < this.cognome.length(); ++i) {
         a = Character.toString(this.cognome.charAt(i));
         sommaCognome = sommaCognome + this.tabellaEsoterica.get(a.toUpperCase());
      }

      this.energiaCorpoEmozionale = this.calcolaPiramideCifraNumero(this.calcolaPiramideCifraNumero(sommaNome).toString() + this.calcolaPiramideCifraNumero(sommaCognome).toString());
      System.out.println(" Il valore del corpo emozionale è " + this.energiaCorpoEmozionale + " ridotto a una cifra: " + this.riduciAunaCifra(this.energiaCorpoEmozionale));
   }

   public void calcoloEnergieCorpoMentale() {
      String dataNascita = this.giorno.toString().replace("0", "") + this.mese.toString().replace("0", "") + this.anno.toString();
      this.energiaCorpoMentale = this.calcolaPiramideCifraNumero(dataNascita);
      System.out.println(" Il valore Energia Corpo Mentale è : " + this.energiaCorpoMentale + " ridotto a una cifra: " + this.riduciAunaCifra(this.energiaCorpoMentale));
   }

   public void calcolaEnergiaCreativaCielo() {
      String annoStringa = this.anno.toString();
      int somma = 0;

      for(int i = 0; i < annoStringa.length(); ++i) {
         somma += Character.getNumericValue(annoStringa.charAt(i));
      }

      somma = somma + this.mese + this.giorno;
      this.energiaCreativaCielo = somma;
      System.out.println(" Il valore Energia Creativa Cielo (sentiero) : " + somma + " ridotto a una cifra: " + this.riduciAunaCifra(somma));
   }

   public void calcolaEnergiaCreativaTerra() {
      new HashMap();
      String tot = this.nome + this.cognome;
      int somma = 0;

      for(int i = 0; i < tot.length(); ++i) {
         String carattereNome = Character.toString(tot.charAt(i)).toUpperCase();
         somma += (Integer)this.tabellaEsoterica.get(carattereNome.toUpperCase());
      }

      this.energiaCreativaTerra = somma;
      System.out.println(" Il valore Energia Creativa terra  è " + somma + " ridotto a una cifra: " + this.riduciAunaCifra(somma));
   }

   public void sintesiEnergieCreativeLivelloVita() {
      this.sintesiEnergieCreativeLivelloVita = this.energiaCreativaTerra + this.energiaCreativaCielo;
      System.out.println(" Sintesi Energie Creative Livello Vita : " + this.sintesiEnergieCreativeLivelloVita + " ridotto a una cifra: " + this.riduciAunaCifra(this.sintesiEnergieCreativeLivelloVita));
   }

   public void calcolaOmbre() {
      this.ombraGioventu = Math.abs(this.riduciAunaCifra(this.anno) - this.riduciAunaCifra(this.mese));
      this.ombraMaturità = Math.abs(this.riduciAunaCifra(this.anno) - this.riduciAunaCifra(this.giorno));
      this.ombraPrincipale = Math.abs(this.ombraGioventu - this.ombraMaturità);
      System.out.println("La prima ombra di gioventù che va dalla nascita agli 30 è data dal numero : " + this.ombraGioventu);
      System.out.println("La seconda ombra che va dai 30 anni in poi è data dal numero : " + this.ombraMaturità);
      System.out.println("L' ombra principale è  : " + this.ombraPrincipale);
   }

   public void calcolaCaratteristiche() {
      Iterator iterator = this.distribuzioneCaratteriNome.entrySet().stream().sorted(Entry.comparingByValue()).iterator();

      while(iterator.hasNext()) {
         Entry<Integer, Integer> next = (Entry)iterator.next();
         System.out.println("Il numero " + next.getKey() + " è stato ripetuto " + next.getValue());
      }

   }
   
   public void calcolaNumeriEccessoDifetto () {
	   
	  String nominativo = this.nome+this.cognome;
	  int n=nominativo.length();
	   
	  System.out.println ("I numeri in eccesso sono tutti quelli superiori alla ripetizione: "+ n/9);
	  System.out.println();
	   
	  Iterator iterator = this.distribuzioneCaratteriNome.entrySet().stream().sorted(Entry.comparingByValue()).iterator();
	  
	  Set <Integer> set = this.distribuzioneCaratteriNome.keySet();
	
	  if (!set.contains(1)) {
		  System.out.println("Numero 1 Mancante");
	  }
	  if (!set.contains(2)) {
		  System.out.println("Numero 2 Mancante");
	  }
	  if (!set.contains(3)) {
		  System.out.println("Numero 3 Mancante");
	  }
	  if (!set.contains(4)) {
		  System.out.println("Numero 4 Mancante");
	  }
	  if (!set.contains(5)) {
		  System.out.println("Numero 5 Mancante");
	  }
	  if (!set.contains(6)) {
		  System.out.println("Numero 6 Mancante");
	  }
	  if (!set.contains(7)) {
		  System.out.println("Numero 7 Mancante");
	  }
	  if (!set.contains(8)) {
		  System.out.println("Numero 8 Mancante");
	  }
	  if (!set.contains(9)) {
		  System.out.println("Numero 9 Mancante");
	  }
  	         
   }

   public void calcoloAnnoPersonale() {
      LocalDate current_date = LocalDate.now();
      int year = current_date.getYear();
      int mese = current_date.getMonthValue();
      int giorno = current_date.getDayOfMonth();
      System.out.println("Numero calcolato dell' anno personale del: " + year + " è  " + this.riduciAunaCifra(this.giorno + this.mese + year));
      System.out.println("Numero calcolato del mese personale: " + this.riduciAunaCifra(this.anno + mese));
      System.out.println("Numero calcolato del giorno personale :  " + this.riduciAunaCifra(giorno + mese + this.anno));
   }

   public void calcoloCulmini() {
      this.culmine1 = this.riduciAunaCifra(this.giorno + this.mese);
      this.culmine2 = this.riduciAunaCifra(this.giorno + this.anno);
      this.culmine3 = this.riduciAunaCifra(this.culmine1 + this.culmine2);
      this.culmine4 = this.riduciAunaCifra(this.mese + this.anno);
      this.sfida1 = this.riduciAunaCifra(Math.abs(this.mese - this.giorno));
      this.sfida2 = this.riduciAunaCifra(Math.abs(this.giorno - this.anno));
      this.sfida3 = this.riduciAunaCifra(Math.abs(this.sfida1 - this.sfida2));
      this.sfida4 = this.riduciAunaCifra(Math.abs(this.mese - this.anno));
      this.annoTransizione1 = new Integer(36 - this.riduciAunaCifra(this.sentiero));
      this.annoTransizione2 = this.annoTransizione1 + 9;
      this.annoTransizione3 = this.annoTransizione2 + 9;
      this.annoTransizione4 = this.annoTransizione3 + 9;
      System.out.println("Il 1° culmine dal 1 anno all' anno " + new Integer(36 - this.riduciAunaCifra(this.sentiero)) + " e' " + this.culmine1 + " e la sfida sarà data dal numero : " + this.sfida1);
      System.out.println("Il 2° culmine dagli anni " + new Integer(this.annoTransizione1 + 1) + " agli anni " + this.annoTransizione2 + " e': " + this.culmine2 + " e la sfida sarà data dal numero : " + this.sfida2);
      System.out.println("Il 3° culmine dagli anni " + new Integer(this.annoTransizione2 + 1) + " agli anni " + this.annoTransizione3 + " e': " + this.culmine3 + " e la sfida sarà data dal numero : " + this.sfida3);
      System.out.println("Il 4° culmine dagli anni " + new Integer(this.annoTransizione3 + 1) + " agli anni " + this.annoTransizione4 + " e': " + this.culmine4 + " e la sfida sarà data dal numero : " + this.sfida4);
   }

   public void calcoloGiornoNascita() {
      System.out.println(" Il valore del giorno di nascita  è " + this.giorno + " ridotto a una cifra: " + this.riduciAunaCifra(this.giorno));
   }

   public void calcolaQuintaessenza() {
      this.quintaEssenza = this.espressione + this.sentiero;
      System.out.println(" Il valore della quinta essenza è " + this.quintaEssenza + " ridotto a una cifra: " + this.riduciAunaCifra(this.quintaEssenza));
   }

   public void calcolaEspressione() {
      this.espressione = this.persona + this.anima;
      System.out.println(" Il valore dell' espressione è " + this.espressione + " ridotto a una cifra: " + this.riduciAunaCifra(this.espressione));
   }

   public void calcolaStringaNome(String nome) {
      String tot = nome;
      String stringaNome = "";

      for(int i = 0; i < tot.length(); ++i) {
         String a = Character.toString(tot.charAt(i));
         stringaNome = stringaNome + this.tabellaPitagorica.get(a.toUpperCase());
      }

      System.out.println(" Il valore della Stringa nome " + stringaNome);
   }

   Integer calcolaPiramideCifraNumero(String numeri) {
      String nuovoNumero = numeri;

      for(String appoNumero = ""; nuovoNumero.length() > 2; nuovoNumero = appoNumero) {
         appoNumero = "";

         for(int i = 0; i < nuovoNumero.length() - 1; ++i) {
            appoNumero = appoNumero + String.valueOf(this.riduciAunaCifra(Character.getNumericValue(nuovoNumero.charAt(i)) + Character.getNumericValue(nuovoNumero.charAt(i + 1))));
         }
      }

      return Integer.valueOf(nuovoNumero);
   }

   public void calcolaCifreNome(String nome) {
      String tot = nome;
      int somma = 0;

      for(int i = 0; i < tot.length(); ++i) {
         String a = Character.toString(tot.charAt(i));
         somma += (Integer)this.tabellaPitagorica.get(a.toUpperCase());
      }

      System.out.println(" Il valore della nome  è " + somma + " ridotto a una cifra: " + this.riduciAunaCifra(somma));
   }

   public void calcolaPersona() {
      String tot = this.nome + this.cognome;
      int somma = 0;

      for(int i = 0; i < tot.length(); ++i) {
         String a = Character.toString(tot.charAt(i));
         if (!this.isVocal(a)) {
            somma += (Integer)this.tabellaPitagorica.get(a.toUpperCase());
         }
      }

      this.persona = somma;
      System.out.println(" Il valore della persona è " + somma + " ridotto a una cifra: " + this.riduciAunaCifra(somma));
   }

   public void calcolaRealizzazione() {
      this.realizzazione = this.sentiero + this.destino;
      System.out.println(" Il valore della realizzazione è " + this.realizzazione + " ridotto a una cifra: " + this.riduciAunaCifra(this.sentiero + this.destino));
   }

   public void calcolaNumeroDestino() {
      HashMap<Integer, Integer> hs = new HashMap();
      String tot = this.nome + this.cognome;
      int somma = 0;

      for(int i = 0; i < tot.length(); ++i) {
         String carattereNome = Character.toString(tot.charAt(i)).toUpperCase();
         if (hs.get(this.tabellaPitagorica.get(carattereNome)) != null) {
            hs.put((Integer)this.tabellaPitagorica.get(carattereNome), (Integer)hs.get(this.tabellaPitagorica.get(carattereNome)) + 1);
         } else {
            hs.put((Integer)this.tabellaPitagorica.get(carattereNome), 1);
         }

         somma += (Integer)this.tabellaPitagorica.get(carattereNome.toUpperCase());
      }

      this.destino = somma;
      this.distribuzioneCaratteriNome = hs;
      System.out.println(" Il valore del destino è " + somma + " ridotto a una cifra: " + this.riduciAunaCifra(somma));
   }

   public void calcoloAnima() {
      String tot = this.nome + this.cognome;
      int somma = 0;

      int i;
      String a;
      for(i = 0; i < tot.length(); ++i) {
         a = Character.toString(tot.charAt(i));
         if (this.isVocal(a)) {
            somma += (Integer)this.tabellaPitagorica.get(a.toUpperCase());
         }
      }

      if (somma == 0 && (tot.contains("y") || tot.contains("Y"))) {
         for(i = 0; i < tot.length(); ++i) {
            a = Character.toString(tot.charAt(i));
            if (this.isY(a)) {
               somma += (Integer)this.tabellaPitagorica.get(a.toUpperCase());
            }
         }
      }

      this.anima = somma;
      System.out.println(" Il valore del' anima è " + somma + " ridotto a una cifra: " + this.riduciAunaCifra(somma));
   }

   public int contaVocali(String nome) {
      int count = 0;

      for(int i = 0; i < nome.length(); ++i) {
         if (this.isVocal(Character.toString(nome.charAt(i)))) {
            ++count;
         }
      }

      return count;
   }

   private boolean isVocal(String a) {
      return a.toUpperCase().equals("A") || a.toUpperCase().equals("E") || a.toUpperCase().equals("I") || a.toUpperCase().equals("O") || a.toUpperCase().equals("U");
   }

   private boolean isY(String a) {
      return a.toUpperCase().equals("Y");
   }

   public void calcoloSentiero() {
      String annoStringa = this.anno.toString();
      int somma = 0;

      for(int i = 0; i < annoStringa.length(); ++i) {
         somma += Character.getNumericValue(annoStringa.charAt(i));
      }

      somma = somma + this.mese + this.giorno;
      this.sentiero = somma;
      System.out.println(" Il valore del sentiero è: " + somma + " ridotto a una cifra: " + this.riduciAunaCifra(somma));
   }

   private int riduciAunaCifra(Integer numero) {
      String numeroStringa = numero.toString();
      int somma = 0;
      boolean unacifra = false;

      while(!unacifra) {
         for(int i = 0; i < numeroStringa.length(); ++i) {
            somma += Character.getNumericValue(numeroStringa.charAt(i));
         }

         if (somma < 10) {
            unacifra = true;
         } else {
            numeroStringa = (new Integer(somma)).toString();
            somma = 0;
         }
      }

      return somma;
   }

   public void giveData() {
      Scanner sc = new Scanner(System.in);
      System.out.println("Adesso prendo in ingresso i dati");
      System.out.println("Digita nome");
      this.nome = sc.nextLine().replace(" ", "");
      System.out.println("Digita cognome");
      this.cognome = sc.nextLine().replace(" ", "");
      System.out.println("Digita giorno nascita");
      this.giorno = Integer.parseInt(sc.nextLine());
      System.out.println("Digita mese nascita");
      this.mese = Integer.parseInt(sc.nextLine());
      System.out.println("Digita anno nascita");
      this.anno = Integer.parseInt(sc.nextLine());
   }

   public Numerologia() {
      this.generaTabellaPitagorica();
      this.generaTabellaEsoterica();
      this.generaTabellaDifettiNumeroPersona();
      this.generaTabellaConversioneNumeriEsoterica();
   }

   public String getNome() {
      return this.nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public String getCognome() {
      return this.cognome;
   }

   public void setCognome(String cognome) {
      this.cognome = cognome;
   }

   public Integer getGiorno() {
      return this.giorno;
   }

   public void setGiorno(Integer giorno) {
      this.giorno = giorno;
   }

   public Integer getMese() {
      return this.mese;
   }

   public void setMese(Integer mese) {
      this.mese = mese;
   }

   public Integer getAnno() {
      return this.anno;
   }

   public void setAnno(Integer anno) {
      this.anno = anno;
   }

   private void generaTabellaDifettiNumeroPersona() {
      this.tabellaDifettiNumeroPersona = new HashMap();
      this.tabellaDifettiNumeroPersona.put(1, "Egocentrico");
      this.tabellaDifettiNumeroPersona.put(2, "Dualità");
      this.tabellaDifettiNumeroPersona.put(3, "Giocherellone");
      this.tabellaDifettiNumeroPersona.put(4, "Serietà");
      this.tabellaDifettiNumeroPersona.put(5, "Libertino");
      this.tabellaDifettiNumeroPersona.put(6, "Dubbioso");
      this.tabellaDifettiNumeroPersona.put(7, "Snob");
      this.tabellaDifettiNumeroPersona.put(8, "Autoritario");
      this.tabellaDifettiNumeroPersona.put(9, "Vittimismo");
   }

   public HashMap<String, Integer> generaTabellaPitagorica() {
      this.tabellaPitagorica = new HashMap();
      this.tabellaPitagorica.put("A", 1);
      this.tabellaPitagorica.put("J", 1);
      this.tabellaPitagorica.put("S", 1);
      this.tabellaPitagorica.put("B", 2);
      this.tabellaPitagorica.put("K", 2);
      this.tabellaPitagorica.put("T", 2);
      this.tabellaPitagorica.put("C", 3);
      this.tabellaPitagorica.put("L", 3);
      this.tabellaPitagorica.put("U", 3);
      this.tabellaPitagorica.put("D", 4);
      this.tabellaPitagorica.put("M", 4);
      this.tabellaPitagorica.put("V", 4);
      this.tabellaPitagorica.put("E", 5);
      this.tabellaPitagorica.put("N", 5);
      this.tabellaPitagorica.put("W", 5);
      this.tabellaPitagorica.put("F", 6);
      this.tabellaPitagorica.put("O", 6);
      this.tabellaPitagorica.put("X", 6);
      this.tabellaPitagorica.put("G", 7);
      this.tabellaPitagorica.put("P", 7);
      this.tabellaPitagorica.put("Y", 7);
      this.tabellaPitagorica.put("H", 8);
      this.tabellaPitagorica.put("Q", 8);
      this.tabellaPitagorica.put("Z", 8);
      this.tabellaPitagorica.put("I", 9);
      this.tabellaPitagorica.put("R", 9);
      return this.tabellaPitagorica;
   }

   public HashMap<String, Integer> generaTabellaEsoterica() {
      this.tabellaEsoterica = new HashMap();
      this.tabellaEsoterica.put("A", 1);
      this.tabellaEsoterica.put("K", 1);
      this.tabellaEsoterica.put("S", 1);
      this.tabellaEsoterica.put("B", 2);
      this.tabellaEsoterica.put("I", 2);
      this.tabellaEsoterica.put("T", 2);
      this.tabellaEsoterica.put("C", 3);
      this.tabellaEsoterica.put("L", 3);
      this.tabellaEsoterica.put("U", 3);
      this.tabellaEsoterica.put("D", 4);
      this.tabellaEsoterica.put("M", 4);
      this.tabellaEsoterica.put("V", 4);
      this.tabellaEsoterica.put("E", 5);
      this.tabellaEsoterica.put("N", 5);
      this.tabellaEsoterica.put("W", 5);
      this.tabellaEsoterica.put("F", 6);
      this.tabellaEsoterica.put("O", 6);
      this.tabellaEsoterica.put("X", 6);
      this.tabellaEsoterica.put("G", 7);
      this.tabellaEsoterica.put("P", 7);
      this.tabellaEsoterica.put("Y", 7);
      this.tabellaEsoterica.put("H", 8);
      this.tabellaEsoterica.put("Q", 8);
      this.tabellaEsoterica.put("Z", 8);
      this.tabellaEsoterica.put("J", 9);
      this.tabellaEsoterica.put("R", 9);
      return this.tabellaEsoterica;
   }

   public HashMap<Integer, Integer> generaTabellaConversioneNumeriEsoterica() {
      this.tabellaConversioneNumeriEsoterica = new HashMap();
      this.tabellaConversioneNumeriEsoterica.put(0, 0);
      this.tabellaConversioneNumeriEsoterica.put(1, 1);
      this.tabellaConversioneNumeriEsoterica.put(2, 3);
      this.tabellaConversioneNumeriEsoterica.put(3, 6);
      this.tabellaConversioneNumeriEsoterica.put(4, 10);
      this.tabellaConversioneNumeriEsoterica.put(5, 15);
      this.tabellaConversioneNumeriEsoterica.put(6, 21);
      this.tabellaConversioneNumeriEsoterica.put(7, 28);
      this.tabellaConversioneNumeriEsoterica.put(8, 36);
      this.tabellaConversioneNumeriEsoterica.put(9, 45);
      return this.tabellaConversioneNumeriEsoterica;
   }

   public void calcoloNumerologiaPitagorica() {
      
	   this.calcoloGiornoNascita();
      
	   System.out.println();
      this.calcoloAnima();
      
      System.out.println();
      this.calcolaPersona();
      
      System.out.println();
      this.calcolaEspressione();
      
      System.out.println();
      this.calcoloSentiero();
      
      System.out.println();
      this.calcolaQuintaessenza();
      
      System.out.println();
      
      System.out.println();
      
      this.calcolaNumeroDestino();
      this.calcolaRealizzazione();
      
      System.out.println();
      System.out.println();
      
      this.calcolaOmbre();
      System.out.println();
      System.out.println();
      
      this.calcoloCulmini();
      System.out.println();
      System.out.println();
      
      this.calcoloAnnoPersonale();
      
      System.out.println();
      System.out.println();
      
      this.calcolaCaratteristiche();
      
      System.out.println();
      
      this.calcolaNumeriEccessoDifetto();
      
   }

   public void calcoloNumerologiaEsoterica() {
      this.calcolaEnergiaCreativaCielo();
      this.calcolaEnergiaCreativaTerra();
      this.sintesiEnergieCreativeLivelloVita();
      System.out.println();
      System.out.println();
      this.calcoloEnergieCorpoMentale();
      this.calcoloEnergieCorpoEmozionale();
      this.calcoloEnergieCorpoFisicoEsotericoSintesi();
      System.out.println();
      System.out.println();
      this.calcoloKarmaPassato();
      this.calcoloKarmaAttuale();
      this.calcoloKarmaTotale();
      System.out.println();
      System.out.println();
      this.calcolaSintesiSuperma();
      this.calcolaMantraNumericoPersonale();
   }
}
