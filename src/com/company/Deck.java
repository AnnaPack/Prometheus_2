package com.company;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * Created by Bravo on 24.11.2017.
 */

public class Deck {
    private int callNumber = 0;
    private Card[] deck = new Card[36];

    //Перемішує колоду у випадковому порядку
    public void shuffle() {


        for (int i=0; i<=8; i++) {
            for (int j = 0; j <= 3; j++)

            {
                deck[j+4*i] = new Card(Rank.values[i], Suit.values[j]);}}
             //   System.out.println((j+4*i)+" " + deck[j+4*i].getRank().getName() + " " + deck[j+4*i].getSuit().getName());

           printDeck();

            Random rnd = new Random(new Date().getTime());

            for (int i=0; i<36; i++){
                int r = rnd.nextInt(35);
                Card buf = deck[r];
                deck[r] = deck[i];
                deck[i] = buf;
            }

                printDeck();
            ;
        }






    /* * Впорядкування колоди за мастями та значеннями
    * Порядок сотрування:
    * Спочатку всі карти з мастю HEARTS, потім DIAMONDS, CLUBS, SPADES
    * для кожної масті порядок наступний: Ace,King,Queen,Jack,10,9,8,7,6
    * Наприклад
    * HEARTS Ace
    * HEARTS King
    * HEARTS Queen
    * HEARTS Jack
    * HEARTS 10
    * HEARTS 9
    * HEARTS 8
    * HEARTS 7
    * HEARTS 6
    * І так далі для DIAMONDS, CLUBS, SPADES */
    public void order() {
      int[] count = {0,0,0,0};
      Rank[] rank;
      rank=Rank.values;

      for (int j=0; j<4; j++)
      {
          for (int i=0; i<36; i++)
          {
             if ( deck[i].getSuit()==Suit.values[j])
             {Card buf = deck[j*9+count[j]];
             deck[j*9+count[j]]=deck[i];
             deck[i]=buf;
             count[j]++;
          }
         }
          System.out.println("Sorted");
          printDeck();

          for (j=0;j<4;j++)
          for (int i=0;i<9;i++)
          {
              System.out.println(Arrays.asList(rank).indexOf(deck[i+j*9].getRank()));
          }



      }


    }

    //Повертає true у випадку коли в колоді ще доступні карти
    public boolean hasNext() {

    return true;}

    //"Виймає" одну карту з колоди, коли буде видано всі 36 карт повертає null
    //Карти виймаються з "вершини" колоди. Наприклад перший виклик видасть SPADES 6 потім
    //SPADES 7, ..., CLUBS 6, ..., CLUBS Ace і так далі до HEARTS Ace
    public Card drawOne() {
        Card card = new Card(null, null);
    return card;}

    private void  printDeck()
    {
        for (int i=0; i<36; i++)
            System.out.println(i+" "+deck[i].getRank().getName()+" "+deck[i].getSuit().getName());
    }
}

