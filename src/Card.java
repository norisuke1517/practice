/**
 * カードを表すクラス
 */

public class Card {

    // ジョーカー
    public static final int JOKER = 0;

    // スペード
    public static final int SUIT_SPADE = 1;

    // ダイヤ
    public static final int SUIT_DIAMOND = 2;

    // クラブ
    public static final int SUIT_CLUB = 3;

    // ハート
    public static final int SUIT_HEART = 4;

    // カードの示すスート
    private int suit_;

    // カードの示す数
    private int number_;

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
     * 数字を見る
     *
     * return 数
     */
    public int getNumber() {
        return number_;
    }

    /**
     * カードを文字列として表示
     * 
     * return 文字列
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();

        if (number_ > 0) {
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
        } else {
            // ジョーカー
            sb.append("JK");
        }
        return sb.toString();
    }
}
