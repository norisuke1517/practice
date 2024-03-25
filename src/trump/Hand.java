package trump;

import java.util.ArrayList;

/**
 * 手札を表すクラス
 */
public class Hand {

    // 手札を保持するリスト
    ArrayList<Card> hand_ = new ArrayList<>();

    /**
     * カードを加える
     * 
     * @param card 加わるカード
     */
    public void addCard(Card card) {
        hand_.add(card);
    }

    /**
     * カードを見る
     * positionは0からgetNumberOfCards()の範囲で指定すること
     * 
     * @param positionカードの位置
     * @return positionで指定された位置のカード。範囲外の場合はnullで返す
     */
    public Card lookCard(int position) {
        Card lookingCard = null;

        // 引数で指定された位置が妥当であるかチェック
        if ((0 <= position) && (position < hand_.size())) {
            lookingCard = (Card) hand_.get(position);
        }

        return lookingCard;
    }

    /**
     * カードを引く
     * 引いたカードは手札から削除される
     * 
     * @param position カードの位置
     * @return positionで指定された位置のカード。範囲外の場合はnullで返す
     */
    public Card pickCard(int position) {
        Card pickedCard = null;

        // 引数で指定された位置が妥当であるかチェック
        if ((0 <= position) && (position < hand_.size())) {
            pickedCard = (Card) hand_.remove(position);
        }

        return pickedCard;
    }

    /*
     * 手札の枚数を数える
     * 
     * @return 手札の枚数
     */
    public int getNumberOfCards() {
        return hand_.size();
    }

    /**
     * シャッフル
     */
    public void shuffle() {
        int number = hand_.size();

        // カードを抜きだす位置
        int pos;

        // カードをランダムに抜き取って最後に加える動作を繰り返す
        for (int count = 0; count < number * 2; count++) {
            // ランダムな位置からカードを1枚抜き取る
            pos = (int) (Math.random() * number);
            Card pickedCard = (Card) hand_.remove(pos);

            // 抜き取ったカードを最後に加える
            hand_.add(pickedCard);
        }
    }

    /**
     * 手札にあるカードを文字列で表す
     * objectクラスのtoStringメソッドをオーバーライドしたメソッド
     * 
     * @return 手札にあるカードの文字列表現
     */
    public String toString() {
        StringBuffer string = new StringBuffer();

        int size = hand_.size();
        if (size > 0) {
            for (int index = 0; index < size; index++) {
                Card card = hand_.get(index);
                string.append(card);
                string.append(" ");
            }
        }

        return string.toString();
    }

}
