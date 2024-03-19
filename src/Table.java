import java.util.ArrayList;

/**
 * テーブルを表すクラス
 */
public class Table {
    // 捨てられたカードを保持しておくためのリスト
    private ArrayList disposedCards_ = new ArrayList();

    /**
     * カードを捨てる
     * 
     * @param card 捨てるカードの配列
     */
    public void disposeCards(Card card[]) {
        for (int index = 0; index < card.length; index++) {
            // 捨てられたカードを表示する
            System.out.println(card[index] + " ");
        }
        System.out.println("を捨てました");

        disposedCards_.add(card);
    }
}
