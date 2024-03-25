package trump;

/**
 * カードを表すクラス
 */
public class Card {

    // スペード
    public static final int SUIT_SPADE = 1;

    // ダイヤ
    public static final int SUIT_DIAMOND = 2;

    // クラブ
    public static final int SUIT_CLUB = 3;

    // ハート
    public static final int SUIT_HEART = 4;

    // スートの数
    public static final int SUIT_NUM = 4;

    // 値の数
    public static final int CARD_NUM = 13;

    // カードの示すスート
    protected int suit_;

    // カードの示す数
    protected int number_;

    /**
     * コンストラクタ
     * 
     * @param suit   スート
     * @param number 数（0の場合はジョーカーとして扱う）
     */
    public Card(int suit, int number) {
        this.suit_ = suit;
        this.number_ = number;
    }

    /**
     * 数を見る
     *
     * return 数
     */
    public int getNumber() {
        return number_;
    }

    /**
     * スートを見る
     *
     * return スート
     */
    public int getSuit() {
        return suit_;
    }

    /**
     * カードを文字列として表示
     * 
     * return 文字列
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();

        if (number_ > 0) {
            // スートの表示
            switch (suit_) {
                case SUIT_SPADE:
                    sb.append("S");
                    break;
                case SUIT_DIAMOND:
                    sb.append("D");
                    break;
                case SUIT_CLUB:
                    sb.append("C");
                    break;
                case SUIT_HEART:
                    sb.append("H");
                    break;
                default:
                    break;
            }

            // 数の表示
            switch (number_) {
                case 1:
                    sb.append("A");
                    break;
                case 10:
                    sb.append("T");
                    break;
                case 11:
                    sb.append("J");
                    break;
                case 12:
                    sb.append("Q");
                    break;
                case 13:
                    sb.append("K");
                    break;
                default:
                    sb.append(number_);
                    break;
            }
        }

        return sb.toString();
    }
}
