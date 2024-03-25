package fantan;

import trump.Card;
import trump.Table;

/**
 * 七並べのテーブルを表すクラス
 */
public class FantanTable implements Table {
    // カードを並べるテーブルを表す配列
    private Card[][] table_ = new Card[Card.SUIT_NUM][Card.CARD_NUM];

    /**
     * カードを置く
     * 
     * @param card
     */
    public void putCard(Card[] card) {

    }
}
