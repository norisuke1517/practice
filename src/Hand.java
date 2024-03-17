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
     * カードを引く
     * 
     * @return 引かれたカード
     */
    public Card pickCard() {
        Card pickedCard = hand_.remove(0);

        return pickedCard;
    }

    /**
     * 同じ数のカードを探す
     * 
     * @return 同じ数のカード
     */
    public Card[] findSameNumberCard() {
        int numberOfCards = hand_.size();
        Card[] sameCards = null;

        // 手札が1枚以上の場合
        if (numberOfCards > 0) {
            // 最後に追加されたカードを取得する
            int lastIndex = numberOfCards - 1;
            Card lastAddedCard = (Card) hand_.get(lastIndex);

            // 最後に追加されたカードの数字を取得する
            int lastAddedCardNum = lastAddedCard.getNumber();

            for (int index = 0; index < lastIndex; index++) {
                Card card = (Card) hand_.get(index);
                if (card.getNumber() == lastAddedCardNum) {
                    // 最後に追加されたカードと同じカードが見つかった場合
                    // 見つかった組み合わせをsameCardsに格納し、ループを抜ける
                    sameCards = new Card[2];
                    sameCards[0] = (Card) hand_.remove(lastIndex);
                    sameCards[1] = (Card) hand_.remove(index);

                    break;
                }
            }
        }
        return sameCards;
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

}
